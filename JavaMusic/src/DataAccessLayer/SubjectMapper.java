package DataAccessLayer;

import BussinessLayer.Client;
import BussinessLayer.SessionObject;
import BussinessLayer.Staff;
import BussinessLayer.Staff.StaffType;
import BussinessLayer.Man;
import BussinessLayer.Subject;
import static DataAccessLayer.AbstractMapper.AllIdentitiesMap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class SubjectMapper extends AbstractMapper
{

    public SubjectMapper() throws SQLException
    {
        super();
    };
    
    class MyDate extends SessionObject{
        public Date start;
        public Date finish;
        public boolean paid;

        public MyDate(Integer Id) {
            super(Id);
        }
    }
    
    public boolean getAllDateOfSubject(Subject subject, Date date) throws SQLException{
        String ask = "SELECT RENT.START, RENT.FINISH, RENT.PAID FROM SUBJECT JOIN" +  
            "MHAT ON SUBJECT.PK = MHAT.FK_H JOIN" + 
            "RENT ON MHAT.FK_M = RENT.PK" +
            "WHERE SUBJECT.PK = " + subject.getId();
        ArrayList<SessionObject> Result= DomainObjectsFind(ask);
        
        for (SessionObject o: Result) {
            MyDate d = (MyDate) o;
        }
        
        return false;
    }
        
    @Override
    protected SessionObject load(ResultSet rs) throws SQLException 
    {
        Subject Result=null;
       
        if (!AllIdentitiesMap.containsKey(rs.getInt("PK")))
        {
            Result=new Subject(rs.getInt("PK"),rs.getString("Owner"), rs.getInt("Fee"), Subject.SubjectType.valueOf(rs.getString("Type")));
        }
        else
            Result=(Subject) AllIdentitiesMap.get(rs.getInt("PK"));


        return (SessionObject)Result;
        
    };
    
    public ArrayList<Subject> findAllSubject() throws SQLException
    {
        ArrayList<SessionObject> Result= DomainObjectsFind("SELECT * FROM Subject");
        ArrayList<Subject> ResultQ=new ArrayList<>();
        
        for (SessionObject DO:Result)
        {
            ResultQ.add((Subject)DO);
        }
        
        return ResultQ;
    };
    
    public Subject findSubjectById(Integer Id) throws SQLException
    {
        ArrayList<SessionObject> Result= DomainObjectsFind("SELECT * FROM Subject "
                + "WHERE PK="+Id.toString());
        
        Subject Cust=null;
        
        if (!Result.isEmpty())
            Cust=(Subject) Result.get(0);
        
        return Cust;
    };

    @Override
    protected String insertStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doInsert(SessionObject Subject, PreparedStatement insertStatement) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String deleteStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
