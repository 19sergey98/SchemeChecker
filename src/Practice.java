
import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;


/**That's here to try something  */


public class Practice {

    public static void main(String[] args){
        //JSONObject myobj = new JSONObject();
        try {
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
            File sampelXSDfile = new File("C:\\Users\\Sergey\\Desktop\\SbrTech\\easyLevel.xsd");
            InputStream is = new FileInputStream(sampelXSDfile);
            XmlSchemaCollection schemaCol = new XmlSchemaCollection();


            XmlSchema schema = schemaCol.read(new StreamSource(is));

            /**scheme URI*/
            String baseUri = schema.getSourceURI();
            System.out.print("anme = "+baseUri);


            Map<QName,XmlSchemaType> myMap = schema.getSchemaTypes();


            //  System.out.println(schema.getAttributeByName("xs:type"));
           //Document[] allSch =  schema.getAllSchemas();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        }

}
