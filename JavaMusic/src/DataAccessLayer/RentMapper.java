package DataAccessLayer;

import BussinessLayer.Client;
import BussinessLayer.SessionObject;
import BussinessLayer.Staff;
import BussinessLayer.Rent;
import BussinessLayer.Subject;
import static DataAccessLayer.AbstractMapper.AllIdentitiesMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;


public class RentMapper extends AbstractMapper
{
    
    public RentMapper() throws SQLException
    {
        super();
    };

    @Override
    protected SessionObject load(ResultSet rs) throws SQLException 
    {
        Rent Result=null;
        
        if (!AllIdentitiesMap.containsKey(rs.getInt("PK")))
        {
            Result=new Rent(rs.getInt("PK"),rs.getString("Name"), null, null, new Date(rs.getTimestamp("Start").getTime()), new Date(rs.getTimestamp("Finish").getTime()), null);
            
            
            String Ask="SELECT * FROM MHAT WHERE FK_H="+Result.getId().toString();
            
            Connection e1conn = DriverManager.getConnection(Host, Name, Pass);
            e1conn.setAutoCommit(false);
            
            Statement e1stmt = e1conn.createStatement();
            ResultSet rsn=e1stmt.executeQuery(Ask);
            
            ArrayList<Integer> ManAssociatedPKs=new ArrayList<>();
            
            while(rsn.next())
            {
                ManAssociatedPKs.add(rsn.getInt("FK_M"));
            };
            
            StaffMapper FM=new StaffMapper();
            ClientMapper CM=new ClientMapper();
            
            for (Integer Id: ManAssociatedPKs)
            {
                if (FM.findManById(Id)!=null) Result.setWorker((Staff)FM.findManById(Id));
                if (CM.findManById(Id)!=null) Result.setOrderer((Client)CM.findManById(Id));
                
            };
           
            
            Ask="SELECT * FROM HQAT WHERE FK_H="+Result.getId().toString();
            
            Connection e2conn = DriverManager.getConnection(Host, Name, Pass);
            e2conn.setAutoCommit(false);
            
            Statement e2stmt = e2conn.createStatement();
            ResultSet rsm=e2stmt.executeQuery(Ask);
            
            ArrayList<Integer> SubjectAssociatedPKs=new ArrayList<>();
            
            while(rsm.next())
            {
                SubjectAssociatedPKs.add(rsm.getInt("FK_Q"));
            };
            
            SubjectMapper QM=new SubjectMapper();
            
            for (Integer Id: SubjectAssociatedPKs)
            {
                Result.getItems().add(QM.findSubjectById(Id));
            };
            
        }
        else
            Result=(Rent) AllIdentitiesMap.get(rs.getInt("PK"));


        return (SessionObject)Result;
    };
    
    public ArrayList<Rent> findAllRents() throws SQLException
    {
        ArrayList<SessionObject> Result= DomainObjectsFind("SELECT * FROM RENT");
        ArrayList<Rent> RentQ=new ArrayList<>();
        
        for (SessionObject DO:Result)
        {
            RentQ.add((Rent)DO);
        }
        
        return RentQ;
    };

    @Override
    protected String insertStatement() {
         return "INSERT INTO Rent (PK, Name, Start, Finish"
                + ") VALUES (?,?,?,?)";
    }

    @Override
    protected void doInsert(SessionObject Subject, PreparedStatement insertStatement) throws SQLException {
        Rent SubjectIns=(Rent)Subject;
        
        insertStatement.setString(2, SubjectIns.getName());
        insertStatement.setTimestamp(3, new Timestamp(SubjectIns.getStart().getTime()));
        insertStatement.setTimestamp(4, new Timestamp(SubjectIns.getEnd().getTime()));
        
    };
    
    @Override
    public Integer Insert(SessionObject Subject) throws SQLException, ClassNotFoundException
    {
        Integer res=super.Insert(Subject);
        stmt.execute("INSERT INTO MHAT (FK_M, FK_H) VALUES ("+((Rent)Subject).getWorker().getId()+","+((Rent)Subject).getId()+")");
        stmt.execute("INSERT INTO MHAT (FK_M, FK_H) VALUES ("+((Rent)Subject).getOrderer().getId()+","+((Rent)Subject).getId()+")");
        
        for (Subject q: ((Rent)Subject).getItems())
        {
           stmt.execute("INSERT INTO HQAT (FK_Q, FK_H) VALUES ("+q.getId()+","+((Rent)Subject).getId()+")");
        };
     
        con.commit();
        return res;
    };
    
    @Override
    public void Delete(SessionObject Subject) throws SQLException
    {
        stmt.execute("DELETE FROM MHAT WHERE FK_H="+Subject.getId());
        stmt.execute("DELETE FROM HQAT WHERE FK_H="+Subject.getId());
        
        super.Delete(Subject);
        con.commit();
    };

    @Override
    protected String deleteStatement() 
    {
         return "DELETE FROM Rent WHERE PK=(?)";    
    };
    
    
}
