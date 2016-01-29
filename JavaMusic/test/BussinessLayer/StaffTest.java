package BussinessLayer;

import junit.framework.TestCase;

public class StaffTest extends TestCase 
{
    
    public StaffTest(String testName) 
    {
        super(testName);
    };

    public void testGetType() 
    {
        System.out.println("getType");
        Staff instance = new Staff(1, "A", "B", "C", Staff.StaffType.менеджер);
        Staff.StaffType expResult = Staff.StaffType.менеджер;
        Staff.StaffType result = instance.getType();
        assertEquals(expResult, result);
    };

    public void testSetType() 
    {
        System.out.println("setType");
        Staff.StaffType Type = Staff.StaffType.администратор;
        Staff instance = new Staff(1, "A", "B", "C", Staff.StaffType.менеджер);
        instance.setType(Type);
        assertEquals(Type, instance.getType());
    };
    
}
