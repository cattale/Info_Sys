package ServiceLayer;

import BussinessLayer.Client;
import BussinessLayer.Staff;
import BussinessLayer.Rent;
import BussinessLayer.Subject;
import DataAccessLayer.ClientMapper;
import DataAccessLayer.StaffMapper;
import DataAccessLayer.RentMapper;
import DataAccessLayer.SubjectMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
//import org.apache.derby.impl.sql.compile.HalfOuterJoinNode;

public class API 
{
  
    private Staff CurrentUser=null;
    
    public Staff getCurrentUser()
    {
        return CurrentUser;
    };
    
    public boolean subjectAtDate(Subject subject, Date date){
        //new SubjectMapper().
        return false;
    }
    public boolean Login(String Name, String Password) throws SQLException
    {
        StaffMapper FM=new StaffMapper();
        CurrentUser=FM.findFellowByLoginPass(Name, Password);
        return (CurrentUser!=null);
    };
    
    public void logout()
    {
        CurrentUser=null;
    }
    
    public ArrayList<Rent> getRent() throws SQLException
    {
        if (CurrentUser!=null)
        {
            RentMapper HM=new RentMapper();
            ArrayList<Rent> tmpResults=HM.findAllRents();
            if (tmpResults==null) return null;
            
            ArrayList<Rent> Results=new ArrayList<>();
            
            for (Rent h: tmpResults)
            {
                if (CurrentUser.getType()==Staff.StaffType.менеджер)
                {
                    if (h.getWorker()!=null)
                    if (Objects.equals(h.getWorker().getId(), CurrentUser.getId()))
                        Results.add(h);
                }
                else
                {
                   Results.add(h);
                };
            };
            
            if (Results.isEmpty()) return null;
            else
                return Results;
        }
        else
            return null;    
    };  
    
    public Rent getRentById(Integer Id) throws SQLException
    {
        ArrayList<Rent> ResultTmp=getRent();
        if (ResultTmp==null)
        {
            return null;
        }
        else
            for (Rent h: ResultTmp)
            {
                if (Objects.equals(h.getId(), Id))
                {
                    return h;
                }
            };
            
        return null;
    };
    
    public void deleteRentById(Integer Id) throws SQLException
    {
        Rent deletedRent=getRentById(Id);
       
        if (deletedRent==null)
        {
            return;
        }
        else
        {
            RentMapper HM=new RentMapper();
            HM.Delete(deletedRent);
        };
    };
    public void changeRentPaid(int id, boolean paid) throws SQLException{
        (new RentMapper()).changePaid(id, paid);
    }
    public Integer createRent(Integer ClientId, Date Start, Date End,
                                        String Name, ArrayList<Subject> Items) throws SQLException, ClassNotFoundException
    {
        if ((CurrentUser==null)||(!Rent.isCorrectDates(Start, End)))
        {
            return null;
        }
        else
        {
            ClientMapper CM=new ClientMapper();
            Client tmpClient=(Client)CM.findManById(ClientId);
            
            if (tmpClient==null) return null;
            
            RentMapper HM=new RentMapper();
            Integer res=HM.Insert(new Rent(null, Name, CurrentUser, tmpClient, Start, End, Items, false));
            return res;
        }
        
    };
    
    public ArrayList<Subject> getFreeSubject(Date Start, Date End) throws SQLException
    {
        if (CurrentUser==null)
        {
            return null;
        }
        else
        {
            SubjectMapper QM=new SubjectMapper();
            
            ArrayList<Subject> tmpRes= QM.findAllSubject();
            
            if (tmpRes.isEmpty())
            {
                return null;
            };
            ArrayList<Subject> reall=new ArrayList<>();
            
            for (Subject q: tmpRes)
            {
                if (q.isFree(Start, End))
                {
                    reall.add(q);
                };
            };
            
            return  reall;
        }
        
    };
    
    public ArrayList<Subject> getSubject(Date Start, Date End) throws SQLException
    {
        if (CurrentUser==null)
        {
            return null;
        }
        else
        {
            SubjectMapper QM=new SubjectMapper();
            
            ArrayList<Subject> tmpRes= QM.findAllSubject();
            
            if (tmpRes.isEmpty())
            {
                return null;
            };
            ArrayList<Subject> reall=new ArrayList<>();
            
            for (Subject q: tmpRes)
            {
                
                q.state = q.state(Start, End);
                reall.add(q);
            };
            
            return  reall;
        }
        
    };
    
    public ArrayList<Client> getClient() throws SQLException
    {
        if (CurrentUser==null)
        {
            return null;
        }
        else
        {
            if (CurrentUser.getType()!=Staff.StaffType.администратор)
                return null;
            
            ClientMapper CM=new ClientMapper();
            return CM.findAllCelebrities();
        }
    };
    
    public void deleteClientById(Integer Id) throws SQLException
    {
        if ((CurrentUser==null)||(CurrentUser.getType()!=Staff.StaffType.администратор))
        {
            return;
        }
        else
        {
            ClientMapper CM=new ClientMapper();
            Client deletedClient=(Client)CM.findManById(Id);
            CM.Delete(deletedClient);
            return;
        }
        
    };
    
    public Integer createClient(String Surname, String Name, String Patronym) throws SQLException, ClassNotFoundException
    {
    
        if ((CurrentUser==null)||(CurrentUser.getType()!=Staff.StaffType.администратор))
        {
            return null;
        }
        else
        {
            ClientMapper CM=new ClientMapper();
            Integer res=CM.Insert(new Client(null, Surname, Name, Patronym));
            return res;
        }
    }
}
