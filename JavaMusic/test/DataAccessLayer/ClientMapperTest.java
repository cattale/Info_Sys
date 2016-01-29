package DataAccessLayer;

import BussinessLayer.Client;
import BussinessLayer.SessionObject;
import BussinessLayer.Staff;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

public class ClientMapperTest extends TestCase 
{
    
    public ClientMapperTest(String testName) 
    {
        super(testName);
    }

    public void testFindClientById() throws Exception 
    {
        System.out.println("findManById(Client)");
        Integer Id = 6;
        ClientMapper CM=new ClientMapper();
        String Surname = "Смородина";
        Client result = (Client) CM.findManById(Id);
        assertEquals(Surname, result.getSurname());
    };
    
    public void testInsert() throws Exception 
    {
        System.out.println("Insert(Client)");
        ClientMapper CM=new ClientMapper();
        Client newClient=new Client(null, "Ицыксон", "Владимир", "Михайлович");
        Integer Id=CM.Insert(newClient);
        Client result=(Client)CM.findManById(Id);
        assertEquals("Ицыксон", result.getSurname());
        CM.Delete(result);
    };
    
    
    public void testDelete() throws Exception 
    {
        System.out.println("Delete(Client)");           
        ClientMapper CM=new ClientMapper();
        Client newClient=new Client(null, "Ицыксон", "Владимир", "Михайлович");
        Integer Id=CM.Insert(newClient);
        Client result=(Client)CM.findManById(Id);
        CM.Delete(result);
        
        assertEquals(null, (Client)CM.findManById(Id));
    };

    public void testFindAllCelebrities() throws Exception 
    {
        System.out.println("findAllCelebrities");
        ClientMapper instance = new ClientMapper();
        ArrayList<Integer> expResultIds = new ArrayList<>();
        expResultIds.add(6);
        expResultIds.add(7);
        expResultIds.add(8);
        expResultIds.add(9);
        expResultIds.add(10);
        
        ArrayList<Client> result = instance.findAllCelebrities();
        boolean real=true;
        
        for (int i=0;i<5;i++)
        {
           if(!Objects.equals(expResultIds.get(i), result.get(i).getId())) real=false;  
        };
        
        
        assertEquals(real, true);
        
    }

}
