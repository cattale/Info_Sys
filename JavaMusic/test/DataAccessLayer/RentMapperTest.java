package DataAccessLayer;

import BussinessLayer.Client;
import BussinessLayer.SessionObject;
import BussinessLayer.Staff;
import BussinessLayer.Rent;
import BussinessLayer.Subject;
import static BussinessLayer.Subject.SubjectType.гитара;
import static BussinessLayer.Subject.SubjectType.бас;
import static BussinessLayer.Subject.SubjectType.чехол;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import junit.framework.TestCase;

public class RentMapperTest extends TestCase {
    
    public RentMapperTest(String testName) 
    {
        super(testName);
    }

    
    public void testFindAllRents() throws Exception {
        System.out.println("findAllRents");
        RentMapper instance = new RentMapper();
        ArrayList<Integer> expResultIds = new ArrayList<>();
        expResultIds.add(16);
        expResultIds.add(17);
        expResultIds.add(18);
        expResultIds.add(19);
        expResultIds.add(20);
        
        ArrayList<Rent> result = instance.findAllRents();
        
        boolean ist=true;
        
        for(int i=0; i<5; i++)
        {
            if (expResultIds.get(i)!=result.get(i).getId())ist=false;
        };
        
        
        assertEquals(ist, true);
    };

    
    public void testInsert() throws Exception 
    {
        System.out.println("Insert");
       
        ArrayList<Subject> QuantumList1= new ArrayList<>();
       
        
        QuantumList1.add(new Subject(11, "СуперМегаАудио", 50, гитара) 
        );
        QuantumList1.add(new Subject(12, "СуперМегаАудио", 75, бас) 
        );
        
        SessionObject Subject = new Rent(null,"h",new Staff(3, "A", "B", "C", Staff.StaffType.менеджер),
                               new Client(2, "D", "E", "F"),
                               new Date(2014,9,11), new Date(2014,9,12), QuantumList1);
        RentMapper instance = new RentMapper();
        Integer result=instance.Insert(Subject);
        
        ArrayList<Rent> resultl = instance.findAllRents();
        ArrayList<Integer> resultlIds=new ArrayList<>();
        
        for (Rent f:resultl)
        {
            resultlIds.add(f.getId());
        };
        
        assertEquals(resultlIds.contains(result), true);
        
        instance.Delete(Subject);
    };

    
    public void testDelete() throws Exception 
    {
        System.out.println("Delete");
        
          ArrayList<Subject> QuantumList1= new ArrayList<>();
        QuantumList1.add(new Subject(11, "СуперМегаАудио", 50, гитара) 
        );
        QuantumList1.add(new Subject(12, "СуперМегаАудио", 75, бас) 
        );
        
        SessionObject Subject = new Rent(null,"h",new Staff(3, "A", "B", "C", Staff.StaffType.менеджер),
                               new Client(2, "D", "E", "F"),
                               new Date(2014,9,11), new Date(2014,9,12), QuantumList1);
        RentMapper instance = new RentMapper();
        Integer result=instance.Insert(Subject);
        
        instance.Delete(Subject);
        
        ArrayList<Rent> resultl = instance.findAllRents();
        ArrayList<Integer> resultlIds=new ArrayList<>();
        
        for (Rent f:resultl)
        {
            resultlIds.add(f.getId());
        };
        
        assertEquals(!resultlIds.contains(result), true);
        
    }

}
