package BussinessLayer;

import DataAccessLayer.RentMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Subject extends SessionObject
{
    public enum SubjectType
    {
        гитара,
        электрогитара,
        бас,
        саксофон,
        барабаны,
        укулеле,
        терменвокс,
        рояль,
        комбик,
        клавиши,
        драгун,
        скрипка,
        струны,
        чехол,
                
    };
    
    private String Owner=null;
    private Integer HourFee=null;
    private SubjectType Type=null;

    public Subject(Integer Id, String Owner, Integer HourFee, SubjectType Type) 
    {
        super(Id);
        this.Owner=Owner;
        
        if (isCorrectFee(HourFee))
            this.HourFee=HourFee;
        
        this.Type=Type;
    };
    
    public String getOwner()
    {
        return this.Owner;
    };
    
    public void setOwner(String Owner)
    {
        this.Owner=Owner;
    };
    
    public Integer GetHourFee()
    {
        return this.HourFee;
    };
    
    public void setHourFee(Integer HourFee)
    {
        if (isCorrectFee(HourFee))
        this.HourFee=HourFee;
    };
    
    public SubjectType getType()
    {
        return this.Type;
    };
    
    public void setType(SubjectType Type)
    {
        this.Type=Type;
    };
    
    public static boolean isCorrectFee(Integer potentialHourFee)
    {
        return (potentialHourFee>0);
    };
    
    public boolean isFree(Date Start, Date End) throws SQLException
    {
        boolean Result=true;
        
        RentMapper HM=new RentMapper();
        
        ArrayList<Rent> AllRents=HM.findAllRents();
        
        for (Rent H: AllRents)
        {
            for(Subject q: H.getItems())
            {
                if (this.getId()==q.getId())
                {
                    Long As=Start.getTime();
                    Long Ae=End.getTime();
                    
                    Long Bs=H.getStart().getTime();
                    Long Be=H.getEnd().getTime();
                    
                    if (((Bs<=As)&&(Be<=Ae)&&(Be>As))||
                            ((Bs<=As)&&(Be>=Ae))||
                            ((As<=Bs)&&(Ae<=Be)&&(Ae>Bs))||
                            ((As<=Bs)&&(Ae>=Be)))
                    Result=false;
                };
                
            };
        };
        
        return Result;
        
    };
}
