package dumpserver;

 
import BussinessLayer.Client;
import BussinessLayer.Staff;
import ServiceLayer.API;
import java.sql.SQLException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Protocol 
{
    private static boolean state=false;
    
    public  API sessionAPI=new API();
            
    public String Answer(String Ask) throws ParseException, SQLException
    {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(Ask);
        
        String result="";
        
        switch((String)jsonObject.get("command"))
        {
            case "login":
            {
                String Name=((JSONObject)jsonObject.get("arg")).get("name").toString();
                String Password=((JSONObject)jsonObject.get("arg")).get("password").toString();
                
                this.state=sessionAPI.Login(Name, Password);
                
                
                if((sessionAPI.getCurrentUser()!=null)&&
                   (sessionAPI.getCurrentUser().getType()!=Staff.StaffType.администратор))
                {
                    this.state=false;
                    sessionAPI.logout();
                };
                
                result=makeLoginResult(this.state);
                break;
            }
            case "getClients":
            {
                
                ArrayList<Client> Clients=new ArrayList<>();
                
                Clients=sessionAPI.getClient();
                
                if (!this.state)
                    Clients.clear();
                
                result=makegetClientsResult(Clients);
                break;
            }
            case "logout":
            {
                
                this.state=false;
                result=makelogout();
                break;
            }
            
        }
        
        return result;
    };

    private String makeLoginResult(boolean switcher) 
    {
         JSONObject obj=new JSONObject();
         
         obj.put("result",switcher);
         
         return obj.toJSONString();
    }

    private String makegetClientsResult(ArrayList<Client> Clients) 
    {
         JSONObject mainobj=new JSONObject();
         JSONArray list = new JSONArray();
         
         for (Client t:Clients)
         {
            JSONObject obj=new JSONObject();
         
            obj.put("id", t.getId());
            obj.put("surname", t.getSurname());
            obj.put("name", t.getName());
            obj.put("patronym", t.getPatronym());
            
            list.add(obj);
         }
         
         mainobj.put("clients", list);
         
         return mainobj.toJSONString();
    }

    private String makelogout() 
    {
         JSONObject obj=new JSONObject();
         
         obj.put("result",true);
         
         return obj.toJSONString();
    }
    
}
