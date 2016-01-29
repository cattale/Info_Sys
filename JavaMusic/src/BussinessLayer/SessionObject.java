package BussinessLayer;

public class SessionObject 
{
    private Integer Id;
    
    public SessionObject(Integer Id)
    {
        this.Id=Id;
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
