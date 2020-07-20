import java.io.*;
import java.math.BigInteger;

/**
 * This is the Class used to decrypt the file encrypted by JEncryption Wizard
 */
public class Decryptor {
    private BigInteger d;
    private BigInteger n;
    private FileOutputStream fout;
    private DataInputStream fin;
    private String outputFileName;

    private String getExtension(String fileName){
            return fileName.substring(fileName.lastIndexOf("."));
    }

    public String getOutputFileName(){
        return outputFileName;
    }
    /**
     * It sets d (private key) value
     *
     * @param dVal(d value as String)
     * @return boolean(success or failure)
     */
    public void setD(String dVal) {
        d = new BigInteger(dVal);
    }

    /**
     * It sets n (private key) value
     *
     * @param nVal(nvalue as String)
     * @return boolean(success or failure)
     */
    public void setN(String nVal) {
        n = new BigInteger(nVal);
    }

    /**
     * It sets source file path (encrypted File) value
     *
     * @param finStr(finStr value as String)
     * @return boolean(success or failure)
     */
    public boolean setSrc(String finStr) {
        try {
            fin = new DataInputStream(new FileInputStream(finStr));
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    /**
     * It sets destination file path (decrypted File) value
     *
     * @param foutStr(foutStr value as String)
     * @return boolean(success or failure)
     */
    public boolean setDst(String foutStr) {
        try {
            fout = new FileOutputStream(foutStr);
        } catch (FileNotFoundException ex) {
            return false;
        }
        return true;
    }

    /**
     * It decrypts the encrypted file to plain text and saves to destination path
     *
     * @return boolean(indicating success or failure)
     */
    public boolean decrypt(String src, String dVal, String nVal) {


        setD(dVal);
        setN(nVal);
        setSrc( src );

        outputFileName = new String("C:\\Windows\\Temp\\tempd") + getExtension(src);
        setDst( outputFileName  );

        try {
            BigInteger input;
            BigInteger output;
            int data;
            while (fin.available()>0) {
                data = fin.readShort();
                input = new BigInteger(String.valueOf(data));

                output = input.modPow(d, n);
                fout.write(output.intValue());
            }
            fout.close();
        } catch(EOFException ex){
        } catch (IOException ex) {
        }

        return true;
    }
}