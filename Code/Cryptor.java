import java.io.*;
import javax.crypto.spec.*;
import java.util.*;
import javax.crypto.*;
import java.security.spec.*;
import java.math.*;
import java.security.*;

public class Cryptor{

    static {
           Security.addProvider(new com.sun.crypto.provider.SunJCE());
    }

    private Cipher cipher;
    private PBEParameterSpec paramSpec;
    private PBEKeySpec keySpec;
    private KeyGenerator keygen;
    private SecretKey secretKey;

    public String algorithm;
    public String password;
    private int encryptTechnique;
    private byte[] key; // for Triple DES
    IvParameterSpec IvParameters = new IvParameterSpec(
        new byte[] { 12, 34, 56, 78, 90, 87, 65, 43 });
    // Salt
    byte[] salt = {(byte)0xc7,(byte)0x73,(byte)0x21,(byte)0x8c,(byte)0x7e,(byte)0xc8,(byte)0xee,(byte)0x99};
    // Iteration count
    int count = 20;
    String outputFileName;

    public Cryptor(){
        setAlgorithm(1);
    }

    public void setAlgorithm(int choice){
        encryptTechnique = choice;

        switch(choice){
            case 1: algorithm = new String("PBEWithMD5AndDES"); //DES
                    break;
            case 2: algorithm = new String("DESede/CBC/PKCS5Padding"); //Triple DES
                    break;
            default: algorithm = new String("PBEWithMD5AndDES"); //DES
                    break;
        }
    }

    private void InitiateCipher(int mode){
        try{
        	if(encryptTechnique!=2){    // if not triple des
                paramSpec = new PBEParameterSpec(salt, count);
                keySpec = new PBEKeySpec(password.toCharArray());
                secretKey = SecretKeyFactory.getInstance(algorithm).generateSecret(keySpec);
            }
            else{
                key = toKey(password);
                // Create a DESede key spec from the key
                DESedeKeySpec spec = new DESedeKeySpec( key );
                // Get the secret key factor for generating DESede keys
                SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
                secretKey = keyFactory.generateSecret(spec);
            }

            cipher = Cipher.getInstance(algorithm);
            if(encryptTechnique==2)
                cipher.init(mode, secretKey, IvParameters);
            else
                cipher.init(mode, secretKey, paramSpec);
        }
        catch(Throwable t) {t.printStackTrace();}
    }

    private String getExtension(String fileName){
            return fileName.substring(fileName.lastIndexOf("."));
    }

    int encrypt(String inputFileName, String password){
        this.password = password;
        try{
        //     JOptionPane.showMessageDialog(null,"algorithm: "+algorithm);
             InitiateCipher(Cipher.ENCRYPT_MODE);
             FileInputStream fin = new FileInputStream(inputFileName);
             BufferedInputStream in = new BufferedInputStream(fin);

             outputFileName = new String("C:\\Windows\\Temp\\tempe") + getExtension(inputFileName);
         //    String outputFileName = new String("tempe") + getExtension(inputFileName);

             FileOutputStream fout = new FileOutputStream(outputFileName);
             CipherOutputStream out = new CipherOutputStream(fout, cipher);
             int buffer;
             while ((buffer = in.read()) != -1)
                 				out.write(buffer);
             out.close();
             in.close();

             return 0;
        }
        catch(Exception ex){
            return 1;
        }
    }

    int decrypt(String inputFileName, String dstPathName, String password){
        this.password = password;

        try{
            InitiateCipher(Cipher.DECRYPT_MODE);
            FileInputStream fin = new FileInputStream(inputFileName);
            CipherInputStream in = new CipherInputStream(fin, cipher);

            outputFileName = new String(dstPathName + "\\tempd") + getExtension(inputFileName);
            //     String outputFileName = new String("tempd") + getExtension(inputFileName);
            FileOutputStream fout = new FileOutputStream(outputFileName);
            BufferedOutputStream out = new BufferedOutputStream(fout);

            int buffer;
            while ((buffer = in.read()) != -1)
              				out.write(buffer);
            in.close();
            out.close();

            return 0;
        }catch(Exception ex){
            return 1;
        }
    }

    public String getOutputFileName(){
        return outputFileName;
    }


    public byte[] toKey(String password){
      int pwdlen = password.length();

      int i=pwdlen;
      while(i < 25){
        password = password + password;
        i = password.length();
      }
      byte[] encryptKey = password.getBytes();

      return encryptKey;
    }
}