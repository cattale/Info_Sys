package BussinessLayer;

import static BussinessLayer.Subject.SubjectType.гитара;
import static BussinessLayer.Subject.SubjectType.бас;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import junit.framework.TestCase;

public class SubjectTest extends TestCase 
{
    
    public SubjectTest(String testName) 
    {
        super(testName);
    }

    public void testGetOwner() 
    {
        System.out.println("getOwner");
        Subject instance = new Subject(1, "A", 10, гитара) ;
        String expResult = "A";
        String result = instance.getOwner();
        assertEquals(expResult, result);
    };

    public void testSetOwner() 
    {
        System.out.println("setOwner");
        String Owner = "B";
        Subject instance = new Subject(1, "A", 10, гитара) ;
        instance.setOwner(Owner);
        assertEquals(Owner, instance.getOwner());
    };

    public void testGetHourFee() 
    {
        System.out.println("GetHourFee");
        Subject instance = new Subject(1, "A", 10, гитара) ;
        Integer expResult = 10;
        Integer result = instance.GetHourFee();
        assertEquals(expResult, result);
        
    };

    public void testSetHourFee() 
    {
        System.out.println("setHourFee");
        Integer HourFee = 15;
        Subject instance = new Subject(1, "A", 10, гитара) ;
        instance.setHourFee(HourFee);
        assertEquals(HourFee, instance.GetHourFee());
    };

    public void testGetType() 
    {
        System.out.println("getType");
        Subject instance = new Subject(1, "A", 10, гитара) ;
        Subject.SubjectType expResult = гитара;
        Subject.SubjectType result = instance.getType();
        assertEquals(expResult, result);
    };

    public void testSetType() 
    {
        System.out.println("setType");
        Subject.SubjectType Type = бас;
        Subject instance = new Subject(1, "A", 10, гитара) ;
        instance.setType(Type);
        assertEquals(Type, instance.getType());
    };

    public void testIsCorrectFee() 
    {
        System.out.println("isCorrectFee");
        Integer potentialHourFee = -5;
        boolean expResult = false;
        boolean result = Subject.isCorrectFee(potentialHourFee);
        assertEquals(expResult, result);
    };

    public void testIsFree() throws SQLException 
    {
        System.out.println("isFree");
        Date Start;
        Date End;
        
        Calendar ins1=Calendar.getInstance();
        ins1.set(2014,7,7,11,00);
        Start=ins1.getTime();
        
        Calendar ins2=Calendar.getInstance();
        ins2.set(2014,7,8,00,00);
        
        End=ins2.getTime();
        
        
        Subject instance = new Subject(11, "СуперМегаАудио", 50, гитара) ;
        boolean expResult = false;
        boolean result = instance.isFree(Start, End);
        assertEquals(expResult, result);
    };
    
}
