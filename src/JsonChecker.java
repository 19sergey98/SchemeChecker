import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.xml.xpath.XPath;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class JsonChecker {

    Properties properties ;
    JsonChecker(String propertiesFileName) throws NoPropertiesFileException {
       /*input = */;

        try {
            properties=new Properties();
            properties.load(new FileInputStream(propertiesFileName));
        } catch (IOException e) {
            throw new NoPropertiesFileException();
            //create properties file
            //PropSetter propSetter = new PropSetter("config.properties")
        }
    }

    public ArrayList<String> CheckRequires(Set<Map.Entry<String, JsonElement>> entries, JsonArray reqrs)
    {

        ArrayList<String> missingReqs= new ArrayList<>();
        //NoRequires

        if(reqrs==null) {
            String ds = new String("Отсутствуют обязательные параметры");
            missingReqs.add(ds);
            return  missingReqs;
        }

        boolean gotThat=false;

            //thru da all requires
            for (JsonElement cureq:reqrs) {

                gotThat=false;

                for (Map.Entry<String, JsonElement> entry : entries) {
                    if(cureq.getAsString().equals(entry.getKey())) {
                        //System.out.println("VSE OK");
                        gotThat=true;
                    }
                }
                if(!gotThat)
                    missingReqs.add(cureq.getAsString());//add missing reqs

            }
        return missingReqs;
    }

    public boolean CheckUnlimString(JsonObject obj)
    {
        if (obj.get("type").getAsString().equals("string")) {
            if(obj.get("maxLength")==null)
                return false;
            if(Integer.parseInt( properties.getProperty("maxStringLength"))< Integer.parseInt( obj.get("maxLength").getAsString()))
                return false;
        }
        return true;
    }

    public void CheckThemAll(JsonObject curJsobj, String xPath) throws IOException {
        JsonObject curProps = curJsobj.getAsJsonObject("properties").getAsJsonObject();
        JsonObject nextJobject;
        ArrayList<String> keys = new ArrayList<>();
        Set<Map.Entry<String, JsonElement>> entries = curProps.entrySet();
        Logger myLog = new Logger("logFile.txt");

        keys.clear();
        for (Map.Entry<String, JsonElement> entry : entries
                ) {
            keys.add(entry.getKey());
        }

        for (String curKey:keys
             ) {
            //check them all
            nextJobject=curProps.get(curKey).getAsJsonObject();
           // System.out.println(nextJobject.get("type").getAsString());
            if(nextJobject.get("type").getAsString().equals("object"))
                CheckThemAll(nextJobject,xPath+"/"+curKey);

            /***STRING CHECKING*/
            if(properties.getProperty("checkUnlimStrings").equals("true"))
                if (!CheckUnlimString(nextJobject)) {
                    System.out.println("there is no maxlength or  type in " + xPath + "/" + curKey);//LOGGING
                    myLog.AddNewNote(xPath + curKey,"string","Неограниченная длина или превышение её максимально возможного значения");
            }
           // myLog.ClearLogFile();

            //   if (nextJobject.get("type").getAsString().equals("string")) {
         //       //Check What u want 4 type string
         //
         //       System.out.println("there is string type in " + xPath + "/" + curKey);
         //   }

            if (nextJobject.get("type").getAsString().equals("array"))
            {
                System.out.println("there is array type in " + xPath + "/" + curKey);
            }
        }

        /*
        if(curJsobj.get("type").equals("object"))
        {
            CheckThemAll(curJsobj.get("proper"));
        }*/

        if(curJsobj.get("type").getAsString().equals("String"))
        {
            curJsobj.get("maxLength");
        }
    }

    public void CheckScheme(String fileName) throws IOException {

        String CurrentXpath=new String();
        String Xpath="";

        //testthing
       // fileName = "C:\\Users\\Sergey\\Desktop\\SbrTech\\easyLevel.json";

         FileReader reader = new FileReader(fileName);

        JsonParser parser = new JsonParser();

        JsonObject js = parser.parse(reader).getAsJsonObject();

        CheckThemAll(js,"");

        JsonObject jsProps = js.get("properties").getAsJsonObject();

        Set<Map.Entry<String, JsonElement>> entries = jsProps.entrySet();//will return members of your object

        JsonArray reqrs =  js.get("required").getAsJsonArray();
        /*
        js = jsProps.get(reqrs.get(0).getAsString()).getAsJsonObject();
        reqrs = js.get("required").getAsJsonArray();
        */
        //System.out.println(entries.contains(reqrs.get(0)));
        /***THERE MUST BE ITERATING!!!!!! THRU DA NESTED OBJ*/

        ArrayList<String> keys = new ArrayList<>();
        /*while(jsProps!=null) {

            //filling keys array
            keys.clear();
            for (Map.Entry<String, JsonElement> entry : entries
                 ) {
               keys.add(entry.getKey());

            }

            /***REQUIRES CHECKING*/
           /* ArrayList<String> result = CheckRequires(entries, reqrs);
            if (result.size() > 0) {
                System.out.println("тут ошибки:");//logging
                for (String line : result
                        ) {
                    System.out.println(line); //LOGGING
                }
            } else
                System.out.println("vse ok");*/
            /***STRING CHECKING*/
            /***Array CHECKING*/
            for (String curKey: keys
                 ) {
                //Check what u want
                CurrentXpath = Xpath+curKey;

            }

            //moving to the next level


        }

        /* for(int i = 0 ;i<1;i++)
        {
            //thru da all requires
            for (JsonElement cureq:reqrs) {

                gotThat=false;

                for (Map.Entry<String, JsonElement> entry : entries) {
                    if(cureq.getAsString().equals(entry.getKey())) {
                        System.out.println("VSE OK");
                        gotThat=true;
                    }
                }
                if(!gotThat)
                    System.out.println("No such required element  " + cureq);


            }*/

        }






