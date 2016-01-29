package DataAccessLayer;

import BussinessLayer.SessionObject;
import BussinessLayer.Man;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import junit.framework.TestCase;

public class ManMapperTest extends TestCase 
{
    
    public ManMapperTest(String testName) 
    {
        super(testName);
    };

    public void testFindManById() throws Exception 
    {
        System.out.println("findManById");
        Integer Id = 4;
        ManMapper instance = new ManMapperImpl();
        String expResult = "Кабанец";
        Man result = instance.findManById(Id);
        assertEquals(expResult, result.getSurname());
    };

    public class ManMapperImpl extends ManMapper 
    {

        public ManMapperImpl() throws Exception 
        {
            super();
        }

        @Override
        protected String insertStatement() 
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        protected void doInsert(SessionObject Subject, PreparedStatement insertStatement) throws SQLException 
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        protected String deleteStatement() 
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

       
    }
    
}
