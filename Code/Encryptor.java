import java.io.*;
import java.math.BigInteger;

public class Encryptor {
    private BigInteger n;
    private BigInteger d;
    private BigInteger e;

    private FileInputStream fin;
    private DataOutputStream fout;
    private String outputFileName;

    public Encryptor() {
    }


    /**
     * it sets e value if satify the constraints of public key
     *
     * @param eVal
     * @return boolean
     */
    void setE(String eVal) {
        e = new BigInteger(eVal);
    }

    BigInteger getE() {
        return e;
    }

    void setN(String nVal){
        n = new BigInteger(nVal);
    }

    /**
     * it sets source file path
     *
     * @param finStr
     * @return boolean
     */
    boolean setSrc(String finStr) {
        try {
            File f = new File(finStr);
            if(!f.exists())     // file does not exists
                return false;
            fin = new FileInputStream(f);
        } catch (FileNotFoundException ex) {
            return false;
        }
        return true;
    }

    /**
     * it sets destination file path
     *
     * @param foutStr
     * @return boolean
     */
    boolean setDst(String foutStr) {
        try {
            fout = new DataOutputStream(new FileOutputStream(foutStr));
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
        return true;
    }



    private String getExtension(String fileName){
            return fileName.substring(fileName.lastIndexOf("."));
    }

    public String getOutputFileName(){
        return outputFileName;
    }
    /**
     * encrypts the source file and saves in destination file using RSA Encryption Technique
     */
    int encrypt(String src, String eVal, String nVal) {
        BigInteger data;
        BigInteger cipher;

        setE(eVal);
        setN(nVal);
        setSrc( src );
        //JOptionPane.showMessageDialog(null,src);
        outputFileName = new String("C:\\Windows\\Temp\\tempe") + getExtension(src);
        setDst( outputFileName  );
        try {
            while (fin.available() > 0) {
                int input;
                input = fin.read();
                data = new BigInteger(String.valueOf(input));
                cipher = data.modPow(e, n);
                fout.writeShort(cipher.intValue()) ;
            }
            fin.close();
            fout.close();
        } catch (IOException ex) {
            return 0;
        }
        return 1;
    }
}