package DataAccessLayer;

import BussinessLayer.SessionObject;
import BussinessLayer.Man;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class ManMapper extends AbstractMapper
{
    protected ManMapper() throws SQLException
    {
        super();
    };
    
    @Override
    protected SessionObject load(ResultSet rs) throws SQLException
    {
        Man Result=null;
        
        Result=new Man(rs.getInt("PK"), rs.getString("Surname"), rs.getString("Name"), rs.getString("Patronym"));
        
        return (SessionObject)Result;
    };
    
    public Man findManById(Integer Id) throws SQLException
    {
        ArrayList<SessionObject> Result= DomainObjectsFind("SELECT * FROM MANSIT "
                + "WHERE PK="+Id.toString());
        
        Man Cust=null;
        
        if (!Result.isEmpty())
            Cust=(Man) Result.get(0);
        
        return Cust;
    };
    
}
