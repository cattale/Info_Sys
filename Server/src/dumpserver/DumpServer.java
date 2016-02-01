package dumpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

public class DumpServer 
{

    public static void main(String[] args) throws IOException 
    {
    
        int portNumber = 9999;
    
        System.out.println("Введите номер порта:");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        String potentialPort=in.readLine();
       
        try
        {
            portNumber = Integer.parseInt(potentialPort);
            System.out.println("Прослушиваетсяя порт: "+portNumber);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Некорректный формат. Установлен порт по умолчанию: "+portNumber);
        };
        
        boolean listening = true;
         
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) 
        {
            while (listening) 
            {
                new ThreadForClient(serverSocket.accept()).start();
            }
        }
        catch (IOException e) 
        {
            System.out.println("Прослушивание на заданном порту невозможно: " + portNumber);
            return;
        }
    }
    
}
