package BussinessLayer;

import junit.framework.TestCase;

public class SessionObjectTest extends TestCase 
{
    
    public SessionObjectTest(String testName) 
    {
        super(testName);
    }

    public void testGetId() 
    {
        System.out.println("getId");
        SessionObject instance = new SessionObject(1);
        Integer expResult = 1;
    
        Integer result = instance.getId();
        
        assertEquals(expResult, result);
        
    }

    public void testSetId() 
    {
        System.out.println("setId");
        Integer Id = 1;
        SessionObject instance = new SessionObject(2);
        instance.setId(Id);
        assertEquals(Id, instance.getId());
    }
    
}
