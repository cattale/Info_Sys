package BussinessLayer;

public class Man extends SessionObject
{
    private String Surname;
    private String Name;
    private String Patronym;
    
    public Man(Integer Id, String Surname, String Name, String Patronym)
    {
        super(Id);
        this.Surname=Surname;
        this.Patronym=Patronym;
        this.Name=Name;
    };
    
    public String getSurname()
    {
        return this.Surname;
    };
    
    public void setSurname(String Surname)
    {
        this.Surname=Surname;
    };
    
    public String getPatronym()
    {
        return this.Patronym;
    };
    
    public void setPatronym(String Patronym)
    {
        this.Patronym=Patronym;
    };    
    
    public String getName()
    {
        return this.Name;
    };
    
    public void setName(String Name)
    {
        this.Name=Name;
    }
}
