import java.io.*;

public class Logger {

    private String fileName;

    Logger(String Fname)
    {
        fileName = Fname;
    }
    public void AddNewNote(String xPath ,String type, String err) throws IOException {

        String lineToAdd = "[xpath] "+xPath +"," + " [тип] " + "," + type + " [err] "+err + ";";
      //  Writer output = new BufferedWriter(new FileWriter(fileName,true));  //
       //output.append(lineToAdd);

        //output.close();
        File fout = new File(fileName);
        FileOutputStream fos = new FileOutputStream(fout,true);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));


            bw.write(lineToAdd);
            bw.newLine();


        bw.close();
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
       // out.println(lineToAdd);

    }
    public void ClearLogFile() throws IOException {
        Writer output = new BufferedWriter(new FileWriter(fileName));
    }
}
