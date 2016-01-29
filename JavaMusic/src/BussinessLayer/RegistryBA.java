package BussinessLayer;

import static BussinessLayer.Subject.SubjectType.гитара;
import static BussinessLayer.Subject.SubjectType.бас;
import static BussinessLayer.Subject.SubjectType.чехол;
import static BussinessLayer.Subject.SubjectType.саксофон;
import static BussinessLayer.Subject.SubjectType.барабаны;
import java.util.ArrayList;
import java.util.Date;

public class RegistryBA 
{
    private static RegistryBA Instance=null;
    
    public static RegistryBA getInstance()
    {
        if (Instance==null)
        {
            Instance=new RegistryBA();
        };
        
        return Instance;
    };
    
    public ArrayList<Rent> getAllRents()
    {
        ArrayList<Rent> dumpRent=new ArrayList<>();
        
        ArrayList<Subject> SubjectList1= new ArrayList<>();
        ArrayList<Subject> SubjectList2= new ArrayList<>();
        ArrayList<Subject> SubjectList3= new ArrayList<>();
        
        dumpRent.add(new Rent(1,"h",new Staff(1, "A", "B", "C", Staff.StaffType.менеджер),
                          new Client(1, "D", "E", "F"),
                          new Date(2014,9,11), new Date(2014,9,12), SubjectList1));
        dumpRent.add(new Rent(2,"hh",new Staff(2, "G", "H", "K", Staff.StaffType.менеджер),
                          new Client(2, "L", "M", "N"),
                          new Date(2014,9,11), new Date(2014,9,13), SubjectList2));
        dumpRent.add(new Rent(3,"hhh", new Staff(3, "O", "P", "R", Staff.StaffType.менеджер),
                          new Client(2, "S", "T", "Q"),
                          new Date(2014,9,17), new Date(2014,9,21), SubjectList3));
        
        return dumpRent;
    };
    
}
