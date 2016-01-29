package DataAccessLayer;

import BussinessLayer.SessionObject;
import BussinessLayer.Subject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;
import junit.framework.TestCase;


public class SubjectMapperTest extends TestCase 
{
    
    public SubjectMapperTest(String testName) 
    {
        super(testName);
    }

    public void testFindAllQuantum() throws Exception {
        System.out.println("findAllQuantum");
        SubjectMapper instance = new SubjectMapper();
        ArrayList<Integer> expResult = new ArrayList<>();
        expResult.add(11);
        expResult.add(12);
        expResult.add(13);
        expResult.add(14);
        expResult.add(15);
        ArrayList<Subject> result = instance.findAllSubject();
        
        boolean rqesult=true;

        for (int i=0; i<5; i++)
        {
            if (!Objects.equals(result.get(i).getId(), expResult.get(i))) rqesult=false;
        };
        assertEquals(rqesult, true);
    };

    public void testFindQuantumById() throws Exception 
    {
        System.out.println("findQuantumById");
        Integer Id = 15;
        SubjectMapper instance = new SubjectMapper();
        Subject.SubjectType expResult = Subject.SubjectType.бас;
        Subject result = instance.findSubjectById(Id);
        assertEquals(expResult, result.getType());
    };

}
