package BussinessLayer;

import junit.framework.TestCase;

public class ManTest extends TestCase 
{
    
    public ManTest(String testName) 
    {
        super(testName);
    };

    public void testGetSurname() 
    {
        System.out.println("getSurname");
        Man instance = new Man(1, "A", "B", "C") {
        };
        String expResult = "A";
        String result = instance.getSurname();
        assertEquals(expResult, result);
    };

    public void testSetSurname() 
    {
        System.out.println("setSurname");
        String Surname = "D";
        Man instance = new Man(1, "A", "B", "C") {
        };
        instance.setSurname(Surname);
        assertEquals(Surname, instance.getSurname());
    };

    public void testGetPatronym() 
    {
        System.out.println("getPatronym");
        Man instance = new Man(1, "A", "B", "C") {
        };
        String expResult = "C";
        String result = instance.getPatronym();
        assertEquals(expResult, result);
    };

    public void testSetPatronym() 
    {
        System.out.println("setPatronym");
        String Patronym = "D";
        Man instance = new Man(1, "A", "B", "C") {
        };
        instance.setPatronym(Patronym);
        assertEquals(Patronym, instance.getPatronym());
    };

    public void testGetName() 
    {
        System.out.println("getName");
        Man instance = new Man(1, "A", "B", "C") {
        };
        String expResult = "B";
        String result = instance.getName();
        assertEquals(expResult, result);
    };

    public void testSetName() 
    {
        System.out.println("setName");
        String Name = "D";
        Man instance = new Man(1, "A", "B", "C") {
        };
        instance.setName(Name);
        assertEquals(Name, instance.getName());
    };
    
}
