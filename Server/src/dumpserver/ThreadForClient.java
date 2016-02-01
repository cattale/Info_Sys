package dumpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;


public class ThreadForClient extends Thread 
{
    
    private Socket socket = null;
 
    public ThreadForClient(Socket socket) 
    {
        super();
        this.socket = socket;
    }
     
    public void run() 
    {
 
        try 
        (
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        )
        {
            String inputLine, outputLine;
            
            Protocol p=new Protocol();
 
            while ((inputLine = in.readLine()) != null) 
            {
               outputLine=p.Answer(inputLine);
               out.println(outputLine);
               if (inputLine.contains("logout"))
                   break;
            }
            
            this.socket.close();
        } 
        catch (IOException | ParseException|SQLException e) 
        {
            e.printStackTrace();
        }
    }
}
