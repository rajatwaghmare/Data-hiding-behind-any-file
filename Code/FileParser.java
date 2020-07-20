import java.io.*;
import javax.swing.*;

public class FileParser{
    public static final int MESSAGE = 0;
    public static final int FILE = 1;

    private static String getExtension(String fileName){
          return fileName.substring(fileName.lastIndexOf("."));
    }

    // return 1 if file is file
    // return 0 if file is message ext-xxxx
    public static int getType(String fileName){
           String ext = getExtension(fileName);

           if(ext.equals(".XXXX"))
                                  return 0;
           else
               return 1;
    }

    public static long getSize(String fName){
        File f = new File(fName);
        return f.length();
    }

    public static String getMessage(String fileName) {
        try{
            FileInputStream fin = new FileInputStream( fileName );
            byte data[] = new byte[(int)getSize(fileName)];

            fin.read(data);
            String msg = new String(data);
            return msg;
        }catch(IOException ex){
            return "Error";
        }
    }

    public static String toFile(String message){

        try{
             String outFileName = "C:\\Windows\\Temp\\temp.XXXX";
             FileOutputStream fout = new FileOutputStream(outFileName);
             byte data[] = message.getBytes();

             fout.write(data);
             return outFileName;
        }catch(IOException ex){
            return "Error";
        }
    }

    public static String copyFile(String inName, String dst){
        try{
            String outName = dst + "\\hidden" + getExtension(inName);
            FileInputStream fin = new FileInputStream(inName);
            FileOutputStream fout = new FileOutputStream(outName);

          //  JOptionPane.showMessageDialog(null,inName);
            while(fin.available()>0){
                fout.write(fin.read());
            }
            fin.close();
            fout.close();
            return outName;
        }catch(IOException ex){
            return "Error";
        }

    }
}