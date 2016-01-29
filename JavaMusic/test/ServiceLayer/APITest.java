package ServiceLayer;

import BussinessLayer.Client;
import BussinessLayer.Staff;
import BussinessLayer.Rent;
import BussinessLayer.Subject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import junit.framework.TestCase;

public class APITest extends TestCase 
{
    
    public APITest(String testName) 
    {
        super(testName);
    }

    public void testGetCurrentUser() throws SQLException 
    {
        System.out.println("getCurrentUser");
        API instance = new API();
        instance.Login("happy", "Goal");
        String expResult = "Ступин";
        Staff result = instance.getCurrentUser();
        assertEquals(expResult, result.getSurname());
    }

    public void testLogin() throws Exception 
    {
        System.out.println("Login");
        String Name = "happy";
        String Password = "Goal";
        API instance = new API();
        boolean expResult = true;
        boolean result = instance.Login(Name, Password);
        assertEquals(expResult, result);
      
    }

    public void testLogout() throws SQLException 
    {
        System.out.println("logout");
        API instance = new API();
        instance.Login("happy", "Goal");
        instance.logout();
        assertEquals(instance.getCurrentUser(), null);
    }

    public void testGetRent() throws Exception 
    {
        System.out.println("getRents");
        API instance = new API();
        instance.Login("happy", "Goal");
        
        ArrayList<Integer> expResultIds = new ArrayList<>();
        expResultIds.add(16);
        expResultIds.add(17);
        expResultIds.add(18);
        expResultIds.add(19);
        expResultIds.add(20);
        
        ArrayList<Rent> resultl = instance.getRent();
        
        boolean result=true;
        
        for (int i=0; i<expResultIds.size(); i++)
        {
            if (!Objects.equals(resultl.get(i).getId(), expResultIds.get(i)))
                result=false;
        };
        
        assertEquals(result, true);
    };

    public void testGetRentById() throws Exception 
    {
        System.out.println("getRentById");
        Integer Id = 18;
        API instance = new API();
        instance.Login("456", "Snake");
        Rent expResult = null;
        Rent result = instance.getRentById(Id);
        assertEquals(expResult, result);
       
    };

    public void testDeleteRentById() throws Exception 
    {
        System.out.println("deleteRentById");
        
        Integer ClientId = 6;
        Calendar ins1=Calendar.getInstance();
        ins1.set(2014, 10, 9, 0, 0);
        
        Calendar ins2=Calendar.getInstance();
        ins2.set(2014, 10, 10, 0, 0);
        
        Date Start = ins1.getTime();
        Date End = ins2.getTime();
        
        String Name = "Трамонтана!";
        
        API instance = new API();
        instance.Login("happy", "Goal");
        
        ArrayList<Subject> Items = instance.getFreeSubject(Start, End);
        Integer newH=instance.createRent(ClientId, Start, End, Name, Items);
        
     
        instance.deleteRentById(newH);
        Rent res=instance.getRentById(newH);
        assertNull(res);
    };

    public void testCreateRent() throws Exception 
    {
        System.out.println("createRent");
        Integer ClientId = 6;
        Calendar ins1=Calendar.getInstance();
        ins1.set(2014, 10, 9, 0, 0);
        
        Calendar ins2=Calendar.getInstance();
        ins2.set(2014, 10, 10, 0, 0);
        
        Date Start = ins1.getTime();
        Date End = ins2.getTime();
        
        String Name = "Трамонтана!";
        
        API instance = new API();
        instance.Login("happy", "Goal");
        ArrayList<Subject> Items = instance.getFreeSubject(Start, End);
        Integer newH=instance.createRent(ClientId, Start, End, Name, Items);
        
        assertNotNull(instance.getRentById(newH));
        instance.deleteRentById(newH);
        
    }

    public void testGetFreeSubject() throws Exception 
    {
        System.out.println("getFreeSubject");
       
        Calendar ins1=Calendar.getInstance();
        ins1.set(2014,7,7,21,0);
        
        Calendar ins2=Calendar.getInstance();
        ins2.set(2014,7,8,2,0);
        
        Date Start = ins1.getTime();
        Date End = ins2.getTime();
        
        API instance = new API();
        instance.Login("happy", "Goal");
         
        ArrayList<Integer> expResultIds = new ArrayList<>();
        expResultIds.add(13);
        expResultIds.add(14);
        
        ArrayList<Subject> result = instance.getFreeSubject(Start, End);
        
        boolean real=true;
        
        for (int i=0; i<expResultIds.size(); i++)
        {
            if (!Objects.equals(result.get(i).getId(), expResultIds.get(i))) real=false;
        };
        assertEquals(real, true);
    }

    public void testGetClient() throws Exception 
    {
        System.out.println("getCelebrities");
        
        API instance = new API();
        instance.Login("happy", "Goal");
        
        ArrayList<Integer> expResultIds = new ArrayList<>();
        
        expResultIds.add(6);
        expResultIds.add(7);
        expResultIds.add(8);
        expResultIds.add(9);
        expResultIds.add(10);
        
        boolean tmpres=true;
        
        ArrayList<Client> result = instance.getClient();
        
        for (int i=0;i<5;i++)
        {
            if (!Objects.equals(expResultIds.get(i), result.get(i).getId()))
                tmpres=false;
        };
        
        assertEquals(tmpres, true);
    };

    @SuppressWarnings("empty-statement")
    public void testDeleteClientById() throws Exception 
    {
        System.out.println("deleteClientById");
        
        String Surname = "Ono";
        String Name = "L";
        String Patronym = "Yoko";
        
        API instance = new API();
        instance.Login("happy", "Goal");
        Integer Id=instance.createClient(Surname, Name, Patronym);
        
        ArrayList<Client> tmpList=instance.getClient();
        
        boolean exist=false;
        for (Client c:tmpList)
        {
            if(Objects.equals(c.getId(), Id)) 
                exist=true;
        };
        
        assertEquals(exist, true);
        
        instance.deleteClientById(Id);
        
        tmpList=instance.getClient();
        
        exist=false;
        for (Client c:tmpList)
        {
            if(Objects.equals(c.getId(), Id)) 
                exist=true;
        };
        
        assertEquals(exist, false);
        
    };

    public void testCreateClient() throws Exception 
    {
        System.out.println("createClient");
        String Surname = "Ono";
        String Name = "L";
        String Patronym = "Yoko";
        API instance = new API();
        instance.Login("happy", "Goal");
        Integer Id=instance.createClient(Surname, Name, Patronym);
        
        ArrayList<Client> tmpList=instance.getClient();
        boolean exist=false;
        for (Client c:tmpList)
        {
            if(Objects.equals(c.getId(), Id)) 
                exist=true;
        };
        
        assertEquals(exist, true);
        instance.deleteClientById(Id);
    }
    
}
