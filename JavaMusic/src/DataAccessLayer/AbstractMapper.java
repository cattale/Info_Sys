package DataAccessLayer;

import BussinessLayer.SessionObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class AbstractMapper 
{
    protected static String Host = "jdbc:derby://localhost:1527/Base";
    protected static String Name = "ivan";
    protected static String Pass= "ivan";
    
    protected Connection con;
    protected Statement stmt;
  
    protected static KeyGenerator KeyMaker;
    protected static Map<Integer,SessionObject> AllIdentitiesMap=new HashMap();
    
    protected AbstractMapper() throws SQLException
    {
        this.con = DriverManager.getConnection(Host, Name, Pass);
        this.con.setAutoCommit(false);
        this.stmt = con.createStatement();
        KeyMaker= new KeyGenerator(new Integer(1));
    };
    
    
    protected ArrayList<SessionObject> DomainObjectsFind(String Ask) throws SQLException
    {
        ArrayList<SessionObject> Result=new ArrayList<>();
        
        ResultSet rs=stmt.executeQuery(Ask);
        
        Result=loadMany(rs);
        
        return Result;
    };
    
    protected abstract SessionObject load(ResultSet rs) throws SQLException;
    
    protected ArrayList<SessionObject> loadMany(ResultSet rs) throws SQLException 
    {
        List<SessionObject> Result=new ArrayList<>();
        
        if (!rs.isClosed())
        {
       
            while (rs.next())
            {
                if (load(rs)!=null)
                {
                    Result.add(load(rs));
                };
            };
        }
        
        return (ArrayList<SessionObject>) Result;
    };
  
    public Integer Insert(SessionObject Subject) throws SQLException, ClassNotFoundException
    {
        if (Subject.getId()!=null) return Subject.getId();
            
        PreparedStatement insertStatement=null;
        insertStatement=con.prepareStatement(insertStatement());
        Subject.setId(KeyMaker.nextKey());
        
        insertStatement.setInt(1, Subject.getId());
        
        doInsert(Subject, insertStatement);
        
        insertStatement.execute();
        AllIdentitiesMap.put(Subject.getId(), Subject);
        con.commit();
        return Subject.getId();
    };
    
    public void Delete(SessionObject Subject) throws SQLException
    {
        PreparedStatement deleteStatement=null;
        deleteStatement=con.prepareStatement(deleteStatement());
        
        deleteStatement.setInt(1, Subject.getId());
        
        deleteStatement.execute();
        AllIdentitiesMap.remove(Subject);
        con.commit();
        
    };
    
    public void varDeleteWithoutIM(String AskDelete) throws SQLException
    {
        PreparedStatement deleteStatement=null;
        deleteStatement=con.prepareStatement(AskDelete);
        deleteStatement.execute();
        
    };
    
    protected abstract String insertStatement();

    protected abstract void doInsert(SessionObject Subject, PreparedStatement insertStatement) throws SQLException;

    protected abstract String deleteStatement(); 

}
