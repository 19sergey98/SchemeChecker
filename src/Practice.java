
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

/**That's here to try something  */


public class Practice {

    public static void main(String[] args){
        //JSONObject myobj = new JSONObject();
        try {
            JSONParser mypars = new JSONParser();
            Object obj = mypars.parse(new FileReader("C:\\Users\\Sergey\\Desktop\\SbrTech\\easyLevel.json"));
            JSONObject Jobj = (JSONObject) obj;
            while (Jobj.get("type").equals("string")){
            }


            //System.out.print(Jobj.toString());
            ;

           String name = (String) Jobj.get("type");
           JSONArray arr = (JSONArray) Jobj.get("type");
           //Iterator<> iterator = arr.iterator();
           while (arr.iterator().hasNext()) {
             //  System.out.println(arr.iterator().next());
           }
            //System.out.println((String) Jobj.get("name") );;
            //JSONArray msg = (JSONArray) Jobj.get("");
           // Iterator<String> iterator = msg.iterator();
         /*   while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }*/

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        }

}
