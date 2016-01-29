package BussinessLayer;

import static BussinessLayer.Subject.SubjectType.гитара;
import static BussinessLayer.Subject.SubjectType.бас;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import junit.framework.TestCase;

public class RentTest extends TestCase 
{
    
    public RentTest(String testName) 
    {
        super(testName);
    };
    
    public void testGetName()
    {
        System.out.println("getName");
        Staff F = new Staff(1, "A", "B", "C", Staff.StaffType.менеджер);
        
        ArrayList<Subject> SubjectList1= new ArrayList<>();
        SubjectList1.add(new Subject(1, "A", 10, гитара) 
        );
        SubjectList1.add(new Subject(2, "B", 20, бас) 
        );
        
        Calendar ins1=Calendar.getInstance();
        ins1.set(3914, 9, 11, 0, 0);
        
        Calendar ins2=Calendar.getInstance();
        ins2.set(3914, 9, 12, 0, 0);
        
        
        Rent instance;
        instance = new Rent(1,"h",F,
                new Client(1, "D", "E", "F"),
                ins1.getTime(), ins2.getTime(), SubjectList1);
        
        String expResult="h";
        String result = instance.getName();
        assertEquals(expResult, result);
    };
    
    public void testSetName()
    {
        System.out.println("setName");
        Staff F = new Staff(1, "A", "B", "C", Staff.StaffType.менеджер);
        
        ArrayList<Subject> SubjectList1= new ArrayList<>();
        SubjectList1.add(new Subject(1, "A", 10, гитара) 
        );
        SubjectList1.add(new Subject(2, "B", 20, бас) 
        );
        
        Calendar ins1=Calendar.getInstance();
        ins1.set(3914, 9, 11, 0, 0);
        
        Calendar ins2=Calendar.getInstance();
        ins2.set(3914, 9, 12, 0, 0);
        
        Rent instance = new Rent(1,"h",F,
                          new Client(1, "D", "E", "F"),
                          ins1.getTime(), ins2.getTime(), SubjectList1);
        
        String expResult="hh";
        
        instance.setName(expResult);
        
        String result = instance.getName();
        assertEquals(expResult, result);
        
    };
    
    public void testSetName(String Name)
    {
        System.out.println("setName");
    };

    public void testGetWorker() 
    {
        System.out.println("getWorker");
        Staff expResult = new Staff(1, "A", "B", "C", Staff.StaffType.менеджер);
        
        ArrayList<Subject> SubjectList1= new ArrayList<>();
        SubjectList1.add(new Subject(1, "A", 10, гитара) 
        );
        SubjectList1.add(new Subject(2, "B", 20, бас) 
        );
        
        Calendar ins1=Calendar.getInstance();
        ins1.set(3914, 9, 11, 0, 0);
        
        Calendar ins2=Calendar.getInstance();
        ins2.set(3914, 9, 12, 0, 0);
        
        Rent instance = new Rent(1,"h",expResult,
                          new Client(1, "D", "E", "F"),
                          ins1.getTime(), ins2.getTime(), SubjectList1);
        
        Staff result = instance.getWorker();
        assertEquals(expResult, result);
    };

    public void testSetWorker() 
    {
        System.out.println("setWorker");
        Staff expResult = new Staff(1, "A", "B", "C", Staff.StaffType.менеджер);
        
        ArrayList<Subject> SubjectList1= new ArrayList<>();
        SubjectList1.add(new Subject(1, "A", 10, гитара) 
        );
        SubjectList1.add(new Subject(2, "B", 20, бас) 
        );
        
        Calendar ins1=Calendar.getInstance();
        ins1.set(3914, 9, 11, 0, 0);
        
        Calendar ins2=Calendar.getInstance();
        ins2.set(3914, 9, 12, 0, 0);
        
        Rent instance = new Rent(1,"h",new Staff(3, "J", "K", "L", Staff.StaffType.менеджер),
                          new Client(1, "D", "E", "F"),
                          ins1.getTime(), ins2.getTime(), SubjectList1);
        
        instance.setWorker(expResult);
        
        assertEquals(expResult, instance.getWorker());
    };

    public void testGetOrderer() 
    {
        System.out.println("getOrderer");
        Client expResult = new Client(1, "D", "E", "F");

        ArrayList<Subject> SubjectList1= new ArrayList<>();
        SubjectList1.add(new Subject(1, "A", 10, гитара) 
        );
        SubjectList1.add(new Subject(2, "B", 20, бас) 
        );
        
        Calendar ins1=Calendar.getInstance();
        ins1.set(3914, 9, 11, 0, 0);
        
        Calendar ins2=Calendar.getInstance();
        ins2.set(3914, 9, 12, 0, 0);
        
        Rent instance = new Rent(1,"h",new Staff(1, "A", "B", "C", Staff.StaffType.менеджер),
                          expResult,
                          ins1.getTime(), ins2.getTime(), SubjectList1);
        
        Client result = instance.getOrderer();
        assertEquals(expResult, result);
    };

    public void testSetOrderer() 
    {
        System.out.println("setOrderer");
        Client expResult = new Client(1, "D", "E", "F");

        ArrayList<Subject> SubjectList1= new ArrayList<>();
        SubjectList1.add(new Subject(1, "A", 10, гитара) 
        );
        SubjectList1.add(new Subject(2, "B", 20, бас) 
        );
        
        Calendar ins1=Calendar.getInstance();
        ins1.set(3914, 9, 11, 0, 0);
        
        Calendar ins2=Calendar.getInstance();
        ins2.set(3914, 9, 12, 0, 0);
        
        Rent instance = new Rent(1,"h",new Staff(1, "A", "B", "C", Staff.StaffType.менеджер),
                          new Client(1, "J", "K", "L"),
                          ins1.getTime(), ins2.getTime(), SubjectList1);
        instance.setOrderer(expResult);
        assertEquals(expResult, instance.getOrderer());
    };

    public void testGetStart() 
    {
        System.out.println("getStart");
        
        ArrayList<Subject> SubjectList1= new ArrayList<>();
        SubjectList1.add(new Subject(1, "A", 10, гитара) 
        );
        SubjectList1.add(new Subject(2, "B", 20, бас) 
        );
        
        Calendar ins1=Calendar.getInstance();
        ins1.set(3914, 9, 11, 0, 0);
        
        Calendar ins2=Calendar.getInstance();
        ins2.set(3914, 9, 12, 0, 0);
        
        Rent instance = new Rent(1,"h",new Staff(1, "A", "B", "C", Staff.StaffType.менеджер),
                          new Client(1, "J", "K", "L"),
                          ins1.getTime(), ins2.getTime(), SubjectList1);
        
        Date result = instance.getStart();
        assertEquals(ins1.getTime(), result);
    };

    public void testSetStart() 
    {
        System.out.println("setStart");
        Date Start = new Date(2014,9,11,12,00);
        ArrayList<Subject> SubjectList1= new ArrayList<>();
        SubjectList1.add(new Subject(1, "A", 10, гитара) 
        );
        SubjectList1.add(new Subject(2, "B", 20, бас) 
        );
        
        Calendar ins1=Calendar.getInstance();
        ins1.set(3914, 9, 11, 0, 0);
        
        Calendar ins2=Calendar.getInstance();
        ins2.set(3914, 9, 12, 0, 0);
        
        Rent instance = new Rent(1,"h",new Staff(1, "A", "B", "C", Staff.StaffType.менеджер),
                          new Client(1, "J", "K", "L"),
                          ins1.getTime(), ins2.getTime(), SubjectList1);
      
        instance.setStart(Start);
        assertEquals(Start, instance.getStart());
      
    };

    public void testGetEnd() 
    {
        System.out.println("getEnd");
        ArrayList<Subject> SubjectList1= new ArrayList<>();
        SubjectList1.add(new Subject(1, "A", 10, гитара) 
        );
        SubjectList1.add(new Subject(2, "B", 20, бас) 
        );
        
        Calendar ins1=Calendar.getInstance();
        ins1.set(3914, 9, 11, 0, 0);
        
        Calendar ins2=Calendar.getInstance();
        ins2.set(3914, 9, 12, 0, 0);
        
        Rent instance = new Rent(1,"h",new Staff(1, "A", "B", "C", Staff.StaffType.менеджер),
                          new Client(1, "J", "K", "L"),
                          ins1.getTime(), ins2.getTime(), SubjectList1);
        Date expResult = new Date(2014,9,12);
        Date result = instance.getEnd();
        assertEquals(ins2.getTime(), result);
    };

    public void testSetEnd() 
    {
        System.out.println("setEnd");
        Date End = new Date(2014,9,25);
        ArrayList<Subject> SubjectList1= new ArrayList<>();
        SubjectList1.add(new Subject(1, "A", 10, гитара) 
        );
        SubjectList1.add(new Subject(2, "B", 20, бас) 
        );
        
        Calendar ins1=Calendar.getInstance();
        ins1.set(3914, 9, 11, 0, 0);
        
        Calendar ins2=Calendar.getInstance();
        ins2.set(3914, 9, 12, 0, 0);
        
        Rent instance = new Rent(1,"h",new Staff(1, "A", "B", "C", Staff.StaffType.менеджер),
                          new Client(1, "J", "K", "L"),
                          ins1.getTime(), ins2.getTime(), SubjectList1);
        instance.setEnd(End);
        
        assertEquals(End, instance.getEnd());
    }

    public void testGetItems() 
    {
        System.out.println("getItems");
        ArrayList<Subject> SubjectList1= new ArrayList<>();
        SubjectList1.add(new Subject(1, "A", 10, гитара) 
        );
        SubjectList1.add(new Subject(2, "B", 20, бас) 
        );
        
        Calendar ins1=Calendar.getInstance();
        ins1.set(3914, 9, 11, 0, 0);
        
        Calendar ins2=Calendar.getInstance();
        ins2.set(3914, 9, 12, 0, 0);
        
        Rent instance = new Rent(1,"h",new Staff(1, "A", "B", "C", Staff.StaffType.менеджер),
                          new Client(1, "J", "K", "L"),
                          ins1.getTime(), ins2.getTime(), SubjectList1);
        ArrayList<Subject> expResult = SubjectList1;
        ArrayList<Subject> result = instance.getItems();
        assertEquals(expResult, result);
    };

    public void testIsCorrectDates() 
    {
        System.out.println("isCorrectDates");
        Calendar ins1=Calendar.getInstance();
        ins1.set(3914, 9, 11, 0, 0);
        
        Calendar ins2=Calendar.getInstance();
        ins2.set(3914, 9, 12, 0, 0);
        
        Date potentialStart = ins2.getTime();
        Date potentialEnd = ins1.getTime();
        boolean expResult = false;
        boolean result = Rent.isCorrectDates(potentialStart, potentialEnd);
        assertEquals(expResult, result);
    };

    public void testGetRentCost() 
    {
        System.out.println("getRentCost");
        ArrayList<Subject> SubjectList1= new ArrayList<>();
        SubjectList1.add(new Subject(1, "A", 10, гитара) 
        );
        SubjectList1.add(new Subject(2, "B", 20, бас) 
        );
        
        Calendar ins1=Calendar.getInstance();
        ins1.set(3914, 9, 11, 0, 0);
        
        Calendar ins2=Calendar.getInstance();
        ins2.set(3914, 9, 12, 0, 0);
        
        Rent instance = new Rent(1,"h",new Staff(1, "A", "B", "C", Staff.StaffType.менеджер),
                          new Client(1, "J", "K", "L"),
                          ins1.getTime(), ins2.getTime(), SubjectList1);
        Long expResult = 720L;
        Long result = instance.getRentCost();
        assertEquals(expResult, result);
    };
    
}
