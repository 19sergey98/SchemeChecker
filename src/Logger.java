import java.io.*;

public class Logger {

    private String fileName;

    Logger(String Fname)
    {
        fileName = Fname;
    }
    Logger()
    {
        fileName = "logfile.txt";
    }

    public void AddNewNote(String xPath ,String type, String err) throws IOException {
        String lineToAdd = "[xpath] "+xPath +"," + " [тип] " + "," + type + " [err] "+err + ";";
        this.AddNewLine(lineToAdd);
    }

    public void ClearLogFile() throws IOException {
        Writer output = new BufferedWriter(new FileWriter(fileName));
    }

    public void AddNewLine(String line) throws IOException {
        File fout = new File(fileName);
        FileOutputStream fos = new FileOutputStream(fout,true);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        bw.write(line);
        bw.newLine();
        bw.close();
    }

    public void AddCheckedFileName(String fileToCheckName) throws IOException {
        AddNewLine("[Проверка ] "+fileToCheckName +" [Обнаружены исключения:]");
    }
}
