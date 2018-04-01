import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropSetter {

    public void SetDefaultProperties(String propFileName) throws IOException {
        Properties properties = new Properties();

        properties.setProperty("checkUnlimStrings", "true");
        properties.setProperty("checkEmptyPattern", "true");
        properties.setProperty("maxStringLength", "300" );
        properties.setProperty("checkAdditionalProperties", "true");
        properties.setProperty("checkRequiredProperties", "true");
        properties.setProperty("checkAdditionalItems", "true");
        properties.setProperty("checkUnlimitedArrays", "true");

        File file = new File(propFileName);

        FileOutputStream fileOut = new FileOutputStream(file);

        properties.store(fileOut,"DefaultProperties");
    }

}
