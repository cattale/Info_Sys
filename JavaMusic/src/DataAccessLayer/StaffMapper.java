package DataAccessLayer;

import BussinessLayer.SessionObject;
import BussinessLayer.Staff;
import BussinessLayer.Man;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StaffMapper extends ManMapper 
{
    
    public StaffMapper() throws SQLException
    {
        super();
    };
    
    
    @Override
    protected SessionObject load(ResultSet rs) throws SQLException
    {
      
        Staff Result=null;
        
        if (rs.getInt("Class")!=1) return null;


        if (!AllIdentitiesMap.containsKey(rs.getInt("PK")))
        {
            Man Base=(Man)super.load(rs);

            Staff.StaffType Appointment;
            Appointment= Staff.StaffType.valueOf(rs.getString("Type"));

            Result=new Staff(Base.getId(),Base.getSurname(), Base.getName(), Base.getPatronym(),Appointment);
        }
        else
            Result=(Staff) AllIdentitiesMap.get(rs.getInt("PK"));


        return (SessionObject)Result;
    };

    public Staff findFellowByLoginPass(String Login, String Password) throws SQLException
    {
        ArrayList<SessionObject> Result= DomainObjectsFind("SELECT * FROM MANSIT "
                + "WHERE Login='"+Login+"' AND PASSWORD='"+Password+"'");
        
        Staff Cust=null;
        
        if (!Result.isEmpty())
            Cust=(Staff) Result.get(0);
        
        return Cust;
    };
    
    @Override
    protected String insertStatement() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doInsert(SessionObject Subject, PreparedStatement insertStatement) throws SQLException 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String deleteStatement() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
