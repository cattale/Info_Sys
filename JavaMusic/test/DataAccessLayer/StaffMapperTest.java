

package DataAccessLayer;

import BussinessLayer.SessionObject;
import BussinessLayer.Staff;
import BussinessLayer.Staff.StaffType;
import BussinessLayer.Man;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

public class StaffMapperTest extends TestCase {
    
    public StaffMapperTest(String testName) {
        super(testName);
    }

    public void testFindFellowById() throws Exception 
    {
        System.out.println("findManById(Fellow)");
        Integer Id = 4;
        StaffMapper FM=new StaffMapper();
        StaffType expResult = StaffType.менеджер;
        Staff result = (Staff) FM.findManById(4);
        assertEquals(expResult, result.getType());
    };
    
    public void testFindFellowByLoginPass() throws Exception
    {
        System.out.println("findFellowByLoginPass");
        StaffMapper FM=new StaffMapper();
        String expResult = "Ступин";
        Staff result = (Staff) FM.findFellowByLoginPass("happy", "Goal");
        assertEquals(expResult, result.getSurname());
    }
}
