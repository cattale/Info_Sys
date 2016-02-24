package BussinessLayer;

public class Staff extends Man
{
    public enum StaffType
    {
        администратор,
        финдиректор,
        менеджер
    };

    private StaffType Type;
    
    public Staff(Integer Id, String Surname, String Name, String Patronym, 
            StaffType Type) 
    {
        super(Id, Surname, Name, Patronym);
        this.Type=Type;
    };
    
    public StaffType getType()
    {
        return this.Type;
    };
    
    public void setType(StaffType Type)
    {
        this.Type=Type;
    };
    
}
