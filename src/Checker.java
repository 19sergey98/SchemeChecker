
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class Checker {

    private ArrayList<String> FilesToCheckStr;

    Checker(){
        FilesToCheckStr = new ArrayList<>(1);
    }
    public int GetAmoutOfFiles()
    {
        return FilesToCheckStr.size();
    }
    public void CheckJSONScheme(){}

    public void CheckXSDScheme(){}

    public void CheckWSDLScheme(){}

    public FTypes GetFileType(String fileName)
    {
        //is dir
        File curFile = new File(fileName);
        if(curFile.isDirectory())
            return FTypes.DIR;

        //isn't dir so check type
        if(curFile.isFile()) {
            int index = fileName.lastIndexOf(".") + 1;
            String fileTypeStr = fileName.substring(index);
            //System.out.print("fileType = " + fileType);
            switch (fileTypeStr)
            {
                case "xsd" :
                    return FTypes.XSD;
                case "wsdl":
                    return FTypes.WSDL;
                case "json":
                    return FTypes.JSON;
                case "jsv" :
                    return FTypes.JSON;
                default:
                    return FTypes.UNSPECIFIED;
            }
         }

         return FTypes.UNSPECIFIED;
    }

    //get all file from that dir 
    public void DeepDirScanning(String dirName)
    {
        File dirFile = new File(dirName);

        if(dirFile.isDirectory())
        {
            for (File curF:
                 dirFile.listFiles()) {
                //file => add to files to check
                if(curF.isFile()) {
                    //get type
                    FTypes curT = GetFileType(curF.getAbsolutePath());

                    //if one of which we needed then we add
                    if(curT == FTypes.JSON ||curT == FTypes.WSDL ||curT == FTypes.XSD) {
                        FilesToCheckStr.add(curF.getName());
                    }
                }
                //if dir => scan
                if (curF.isDirectory())
                {
                    DeepDirScanning(curF.getAbsolutePath());
                }
            }

        }

    }

    public void PrintAllFilesInPull()
    {
        for (String cur: FilesToCheckStr
             ) {
            System.out.println(cur);
        }
    }

    public static void main(String[] args){
        Checker checker = new Checker();
        checker.GetFileType("C:\\Users\\Sergey\\Desktop\\SbrTech");
        System.out.println(checker.GetAmoutOfFiles());
        checker.DeepDirScanning("C:\\Users\\Sergey\\Desktop\\SbrTech");
        checker.PrintAllFilesInPull();
        System.out.print(checker.GetAmoutOfFiles());
        //System.out.print( checker.GetFileType("C:\\Users\\Sergey\\Desktop\\SbrTech\\easyLevel.xsd"));

        //create properties file
        PropSetter propSetter = new PropSetter();
        try {
            propSetter.SetDefaultProperties("defaultProps.properties");
            System.out.print("props has been set");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
