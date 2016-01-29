package DataAccessLayer;

import BussinessLayer.Client;
import BussinessLayer.SessionObject;
import BussinessLayer.Staff;
import BussinessLayer.Rent;
import BussinessLayer.Man;
import BussinessLayer.Subject;
import static DataAccessLayer.AbstractMapper.AllIdentitiesMap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class ClientMapper extends ManMapper
{
    
    public ClientMapper() throws SQLException
    {
        super();
    };

    @Override
    protected SessionObject load(ResultSet rs) throws SQLException 
    {
        Client Result=null;
        
        if (rs.getInt("Class")!=2) return null;


        if (!AllIdentitiesMap.containsKey(rs.getInt("PK")))
        {
            Man Base=(Man)super.load(rs);

            Result=new Client(Base.getId(),Base.getSurname(), Base.getName(), Base.getPatronym());
        }
        else
            Result=(Client) AllIdentitiesMap.get(rs.getInt("PK"));


        return (SessionObject)Result;
    };

     
    public ArrayList<Client> findAllCelebrities() throws SQLException
    {
        ArrayList<SessionObject> Result= DomainObjectsFind("SELECT * FROM ManSIT");
        ArrayList<Client> ResultQ=new ArrayList<>();
        
        for (SessionObject DO:Result)
        {
            ResultQ.add((Client)DO);
        }
        
        return ResultQ;
    };
     
    @Override
    protected String insertStatement()
    {
        return "INSERT INTO ManSIT (PK, Surname, Name, Patronym, Class, Type,"
                + "Login, Password) VALUES (?,?,?,?,?,?,?,?)";
    };

    @Override
    protected void doInsert(SessionObject Subject, PreparedStatement insertStatement) throws SQLException 
    {
        Client SubjectIns=(Client)Subject;
        
        insertStatement.setString(2, SubjectIns.getSurname());
        insertStatement.setString(3, SubjectIns.getName());
        insertStatement.setString(4, SubjectIns.getPatronym());
        insertStatement.setInt(5, 2);
        insertStatement.setString(6, null);
        insertStatement.setString(7, null);
        insertStatement.setString(8, null);
    };

    @Override
    protected String deleteStatement() 
    {
        return "DELETE FROM ManSIT WHERE PK=(?)";    
    };
    
    @SuppressWarnings("empty-statement")
    public void Delete(SessionObject Subject) throws SQLException
    {
        RentMapper HM=new RentMapper();
        ArrayList<Rent> HL=new ArrayList<>();
     
        HL=HM.findAllRents();
        
        if (!HL.isEmpty())
        for(Rent H:HL)
        {
            if (H.getOrderer()==null) continue;
            if(Objects.equals(H.getOrderer().getId(), Subject.getId()))
                HM.Delete(H);
        };
        
        super.Delete(Subject);
    };

    
}
