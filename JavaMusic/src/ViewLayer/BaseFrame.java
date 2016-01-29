package ViewLayer;

import ServiceLayer.API;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public abstract class BaseFrame extends JFrame
{
    private static String Title="Аренда музыкальных инструментов";
    private static String IconPath="E:\\logoWonder.jpg";
    
    protected static BaseFrame startFrame=null;
    protected BaseFrame previousFrame;
    protected static API sessionAPI=new API();
    
    public BaseFrame(String TitleAdd, BaseFrame previousFrame)
    {
        super();
        setFrIcon();
        setFrTitle(TitleAdd);
        this.previousFrame=previousFrame;
    };
    
    private void setFrIcon()
    {
        ImageIcon img = new ImageIcon(IconPath);
        this.setIconImage(img.getImage());
    };
    
    private void setFrTitle(String TitleAdd)
    {
        this.setTitle(Title+TitleAdd);
    };
    
    protected void goToFrame(BaseFrame nextFrame)
    {
        if (nextFrame==null) throw new NullPointerException();
        
        this.dispose();
        nextFrame.setVisible(true);
        
    }
    
    protected void goToStartFrame()
    {
        if (startFrame==null) throw new NullPointerException();
        
        this.dispose();
        startFrame.setVisible(true);
    };
    
    protected void goToPreviousFrame()
    {
        if (this.previousFrame==null) throw new NullPointerException();
        
        this.dispose();
        this.previousFrame.setVisible(true);
    };
    
    public static String DateToString(Date T)
    {
        SimpleDateFormat Formatter=new SimpleDateFormat("dd.MM.yy HH:mm");
        String S=Formatter.format(T);
        
        return S;
    };
    
    public static Date DateFromString(String S) throws ParseException
    {
         SimpleDateFormat Formatter=new SimpleDateFormat("dd.MM.yy HH:mm");
         Date T=Formatter.parse(S);
         
         return T;
    };
}
