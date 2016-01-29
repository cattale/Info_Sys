package Frames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection 
{
    private static Connection Instance=null;
    private Socket clientSocket;
    public static int portNumber=9999;
    public PrintWriter out;
    public BufferedReader in; 
    
    private Connection() throws IOException
    {
        clientSocket = new Socket("127.0.0.1", portNumber);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    };
    
    public static Connection getInstance() throws IOException
    {
        if (Instance==null)
        {
            Instance=new Connection();
        };
     
        return Instance;
    };
    
    public void resetInstance() throws IOException
    {
        this.clientSocket.close();
        out.close();
        in.close();
        Instance=null;
        
    };
    
    
    
}
