package BussinessLayer;

import java.util.ArrayList;
import java.util.Date;

public class Rent extends SessionObject
{
    private String Name;
    private Staff Worker;
    private Client Orderer;
    private Date Start;
    private Date End;
    private boolean paid;
    private ArrayList<Subject> Items=new ArrayList<>();
    
    
    public Rent(Integer Id, String Name, Staff Worker, Client Orderer, Date Start, 
            Date End, ArrayList<Subject> Items, boolean paid) 
    {
        super(Id);
        
        this.Name=Name;
        
        if (isCorrectDates(Start, End))
        {
            this.Start=Start;
            this.End=End;
        };
        
        this.Worker=Worker;
        this.Orderer=Orderer;
        
        if(Items!=null)
        this.Items.addAll(Items);
        this.paid = paid;
    };

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    
    public void changePaid() {
        paid = ! paid;
    }
    
    public String getName()
    {
        return this.Name;
    };
    
    public void setName(String Name)
    {
        this.Name=Name;
    };
    
    public Staff getWorker()
    {
        return this.Worker;
    };
    
    public void setWorker(Staff Worker)
    {
        this.Worker=Worker;
    };
    
    public Client getOrderer()
    {
        return this.Orderer;
    };
    
    public void setOrderer(Client Orderer)
    {
        this.Orderer=Orderer;
    };
    
    public Date getStart()
    {
        return this.Start;
    };
    
    public void setStart(Date Start)
    {
        if ((this.End==null)||(isCorrectDates(Start, this.End)))
            this.Start=Start;
    };
    
    public Date getEnd()
    {
        return this.End;
    };
    
    public void setEnd(Date End)
    {
        if ((this.Start==null)||(isCorrectDates(this.Start, End)))
            this.End=End;        
    };
    
    public ArrayList<Subject> getItems()
    {
        return this.Items;
    };
    
    public static boolean isCorrectDates(Date potentialStart, Date potentialEnd)
    {
        return(potentialEnd.after(potentialStart));
    };
    
    public Long getRentCost()
    {
        Long S=0L;
        
        for (Subject q: this.getItems())
        {
            S+=q.GetHourFee()*(this.getEnd().getTime()-this.getStart().getTime())/(1000*60*60);
        };
        
        return S;
    };
    
}
