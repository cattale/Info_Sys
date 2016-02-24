
package DataAccessLayer;

import BussinessLayer.SessionObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class KeyGenerator
{
    
    protected static String Host = "jdbc:derby://localhost:1527/Base";
    protected static String Name = "ivan";
    protected static String Pass= "ivan";
    
    protected Connection con;
    protected Statement stmt;
    
    private Integer nextId;
    private Integer maxId;
    private Integer incrementBy;
    
    public KeyGenerator(Integer incrementBy) throws SQLException
    {
      this.con = DriverManager.getConnection(this.Host, this.Name, this.Pass);
      this.stmt = con.createStatement();
        
      this.nextId=0;
      this.maxId=0;
      this.incrementBy=incrementBy;
    };
    
    public Integer nextKey() throws SQLException, ClassNotFoundException
    {
      if (this.nextId==this.maxId)
          reserveIds();
      
      return this.nextId++;
    };
    
    private void reserveIds() throws SQLException, ClassNotFoundException
    {
        ResultSet rs=stmt.executeQuery("SELECT Pk FROM KEYS FOR UPDATE");
        rs.next();
        this.nextId= rs.getInt("Pk");
        this.maxId=nextId+incrementBy;
        
        stmt.executeUpdate("UPDATE Keys SET Pk="+this.maxId);
        con.commit();
    };

}
