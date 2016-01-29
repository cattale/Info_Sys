package Frames;

public class Client 
{
    private Integer Id;
    private String Surname;
    private String Name;
    private String Patronym;
    
    public Client(Integer Id, String Surname, String Name, String Patronym)
    {
        this.Id=Id;
        this.Surname=Surname;
        this.Name=Name;
        this.Patronym=Patronym;
        
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
    };
    
     public Integer getId()
    {
        return Id;
    };
    
    public void setId(Integer Id)
    {
        this.Id=Id;  
    };
}
