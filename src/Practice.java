
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaType;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.FileAlreadyExistsException;
import java.util.*;

import org.w3c.dom.Document;

import java.io.*;
import java.nio.file.Files;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

/**That's here to try something  */


public class Practice {

    public static void main(String[] args){
        //JSONObject myobj = new JSONObject();
        try {

            //JsonChecker jsonChecker = new JsonChecker("config.properties");
            //C:\SchemeChecker\config.properties
            JsonChecker jsonChecker = new JsonChecker("config.properties");
            jsonChecker.CheckScheme("C:\\Users\\Sergey\\Desktop\\SbrTech\\easyLevel.json");
            //File file = new File(new String());
           // JsonArray myarr = new JsonArray();
            //InputStream in = new FileInputStream(file);
           FileReader reader = new FileReader("C:\\Users\\Sergey\\Desktop\\SbrTech\\easyLevel.json");

           //JsonParser parser = new JsonParser();

            //JsonObject onj = parser.parse(reader).getAsJsonObject();
            //System.out.println(onj.get("properties").getAsString());
          //  JsonObject jsonProperties  = onj.get("properties").getAsJsonObject();
           // JsonElement jsonTree = parser.parse(jsonProperties.toString());


         /*   Set<Map.Entry<String, JsonElement>> entries = jsonProperties.entrySet();//will return members of your object
                for (Map.Entry<String, JsonElement> entry: entries) {
                System.out.println(entry.getKey());
            }

          //  System.out.println(onj.get("required").getAsJsonArray().get(0).getAsString().equals("d"));




          /*  for (String j : jsonProperties.keySet()) {
                JsonObject property = jsonProperties.get(j).getAsJsonObject();
                System.out.println(property);
            }
           */


           // System.out.print(onj);
           //System.out.print(jsonProperties);
            //jsonProperties.entrySet();
          //System.out.print(jsonTree.getAsJsonObject());
         //   myarr = jsonProperties.getAsJsonArray("properties");
           //    myarr.get(0);



           //System.out.println(onj);



          // System.out.print(onj.get("type"));;

            //System.out.print(onj.getAsJsonArray("type"));
            //onj.get("properties");


            //Parsing back the string as Array






            /*JsonElement jelement = new JsonParser().parse(jsonLine);
            JsonObject jobject = jelement.getAsJsonObject();
            jobject = jobject.getAsJsonObject("data");
            JsonArray jarray = jobject.getAsJsonArray("translations");
            jobject = jarray.get(0).getAsJsonObject();
            String result = jobject.get("translatedText").getAsString();
            System.out.print(result);*/


           /* JSONParser mypars = new JSONParser();
            Object obj = mypars.parse(new FileReader("C:\\Users\\Sergey\\Desktop\\SbrTech\\easyLevel.json"));
            JSONObject Jobj = (JSONObject) obj;
            while (Jobj.get("type").equals("string")){
1            }


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


            //File sampelXSDfile = new File("C:\\Users\\Sergey\\Desktop\\SbrTech\\easyLevel.xsd");
            //  InputStream is = new FileInputStream(sampelXSDfile);
           // XmlSchemaCollection schemaCol = new XmlSchemaCollection();


            //XmlSchema schema = schemaCol.read(new StreamSource(is));

            /**scheme URI*/
//            String baseUri = schema.getSourceURI();
  //          System.out.print("anme = "+baseUri);


    //        Map<QName,XmlSchemaType> myMap = schema.getSchemaTypes();*///


            //  System.out.println(schema.getAttributeByName("xs:type"));
           //Document[] allSch =  schema.getAllSchemas();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        }

}
