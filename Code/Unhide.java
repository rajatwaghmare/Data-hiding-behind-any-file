/*************************************************
*                                                *
*  StegoStick1.0 a Steganographic Tool for BMP   *
*                                                *
*  Author: P.V. Uma Mahesh and V. Santhosh Kumar *
*   email: echo_mahesh@yahoo.co.in,              *
*          santhosh_auce@yahoo.com               *
*                                                *
*          file: Unhide.java                     *
*    date added: 23-09-2007                      *
*       version: 1.0                             *
*                                                *
*   License: GNU General Public Licence          *
* Copyright: 2006-07 by the StegoStick Project   *
*                                                *
* description: Actual source file                *
*                                                *
*************************************************/
import javax.swing.*;

public class Unhide{
    static{
        try{
            System.loadLibrary("StegBMP");
            System.loadLibrary("StegMEDIA");
            System.loadLibrary("StegOTHER");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Required DLLs Not Found\n"+ex.getCause(),"Error Loading Libraries", JOptionPane.ERROR_MESSAGE);
        }
    }

	// Native Functions to unhide
	public static native int unhideInBMP(String coverFile, String dstFile,String password);
	public static native int unhideInMEDIA(String coverFile, String dstFile,String password);
	public static native int unhideInOTHER(String coverFile, String dstFile,String password);
    public static native String getHiddenFileNameInBMP();
    public static native String getHiddenFileNameInMEDIA();
    public static native String getHiddenFileNameInOTHER();

    private UnhidePanel parent;
    private String msg;
    private String hiddenFileName;
    private String coverFileName;
    private String dstFileName;
    private String password;
    private String dVal;
    private String nVal;
    private int encryptTechnique;

    Splash splashScreen;

    String tempDst = "C:\\Windows\\Temp";
    int result=6, coverType;
    int BMP = 1, MEDIA = 2, OTHER = 3;

    public Unhide(UnhidePanel parent){
           this.parent = parent;
    }

    public void unhideUsingPassword(String coverFileName, String dstFileName, String password, int encryptTechnique){
        this.coverFileName = coverFileName;
        this.dstFileName = dstFileName;
        this.password = password;
        this.encryptTechnique = encryptTechnique;

        if(!verifyData()){
            return;
        }

        splashScreen = new Splash(2); // Processing.jpg
        // Unhide the file
        if(!unhide()){
            return ;
        }

        // decrypt the file
        Cryptor cryptor = new Cryptor();
        cryptor.setAlgorithm( encryptTechnique );
        cryptor.decrypt(hiddenFileName, tempDst, password);
        hiddenFileName = cryptor.getOutputFileName();

        // create output File
        createOutputFile();
        splashScreen.dispose();
    }

    public void unhideUsingRSA(String coverFileName, String dstFileName, String dVal, String nVal){
        this.coverFileName = coverFileName;
        this.dstFileName = dstFileName;
        this.dVal = dVal;
        this.nVal = nVal;
        parent.encryptTechnique = 3;
        password = nVal;

        if(!verifyData()){
            return;
        }
        splashScreen = new Splash(2); // Processing.jpg
        // Unhide the file
        if(!unhide()){
            return ;
        }

        // decrypt the file
        Decryptor cryptor = new Decryptor();
        cryptor.decrypt(hiddenFileName, dVal, nVal);
        hiddenFileName = cryptor.getOutputFileName();

        // create output File
        createOutputFile();
        splashScreen.dispose();
    }

    private void createOutputFile(){
        //JOptionPane.showMessageDialog(null,"Retriving from "+hiddenFileName);
        int fileType = FileParser.getType(hiddenFileName);
        if(fileType == FileParser.MESSAGE){
             String msg = FileParser.getMessage(hiddenFileName);

             SecretMessageFrame frm = new SecretMessageFrame(msg, parent.currentPath);
             frm.setLocation(parent.getLocation().x+200, parent.getLocation().y+250);
        	 frm.setVisible(true);
        }
        else{
             hiddenFileName = FileParser.copyFile(hiddenFileName, dstFileName);
             JOptionPane.showMessageDialog(parent, "Secret File is successfully retreived to "+hiddenFileName,
                                                      "UnHiding Successful", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private boolean unhide(){

        // Parse the Cover Type
        if((coverFileName.substring(coverFileName.indexOf('.')).equals(".bmp")) ||
           (coverFileName.substring(coverFileName.indexOf('.')).equals(".BMP"))){

            result = unhideInBMP(coverFileName, tempDst,password);
            coverType = BMP;
        }
        else if((coverFileName.substring(coverFileName.indexOf('.')).equalsIgnoreCase(".wav")) ||
                (coverFileName.substring(coverFileName.indexOf('.')).equalsIgnoreCase(".avi")) ||
                (coverFileName.substring(coverFileName.indexOf('.')).equalsIgnoreCase(".mpg")) ||
                (coverFileName.substring(coverFileName.indexOf('.')).equalsIgnoreCase(".mpeg")) ){
            result = unhideInMEDIA(coverFileName, tempDst,password);
            coverType = MEDIA;
        }
        else{
            result = unhideInOTHER(coverFileName, tempDst,password);
            coverType = OTHER;
        }

        // Parse the result
        switch(result){
          case 0 : // Invalid password or image not encrypted by StegoStick
                   JOptionPane.showMessageDialog(parent, "Please Verify the password or Cover weather it has been encrypted by StegoStick",
                                                      "Error", JOptionPane.ERROR_MESSAGE);
                   parent.clearFields();
                   return false;
          case 1 : // Invalid cover File Name
                   JOptionPane.showMessageDialog(parent, "Invalid Cover File Name",
                                                      "Error", JOptionPane.ERROR_MESSAGE);
                   parent.coverField.setText("");
                   return false;
          case 2 : // Unhiding File Successful
                   hiddenFileName = new String();
                   if(coverType == BMP)
                            hiddenFileName = getHiddenFileNameInBMP();
                   else if(coverType == MEDIA)
                            hiddenFileName = getHiddenFileNameInMEDIA();
                   else
                            hiddenFileName = getHiddenFileNameInOTHER();

              //     JOptionPane.showMessageDialog(null,"Retreiving "+hiddenFileName);
                   parent.clearFields();
                   return true;
          case 3 : // Invalid destination File Name
                   JOptionPane.showMessageDialog(parent, "Invalid Destination File Path",
                                                      "Error", JOptionPane.ERROR_MESSAGE);
                   parent.dstField.setText("");
                   return false;

          default: JOptionPane.showMessageDialog(parent,"Unknown Error");
                   return false;
        }
    }
    private boolean verifyData(){
        if(coverFileName.equals("")){
            JOptionPane.showMessageDialog(parent,"Cover File Name not Entered",
	 	                                               "Error", JOptionPane.ERROR_MESSAGE);
	 	    return false;
        }
	    if(dstFileName.equals("")) {
		    JOptionPane.showMessageDialog(parent,"Destination File Path not Entered",
	 	                                               "Error", JOptionPane.ERROR_MESSAGE);
	        return false;
        }
        if(encryptTechnique == 3){
            if(dVal.equals("")){
                    JOptionPane.showMessageDialog(parent,"D Value not Entered",
		                                               "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
            }
            if(nVal.equals("")){
                    JOptionPane.showMessageDialog(parent,"N Value not Entered",
		                                               "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
            }
        }
        else{
            if(password.equals("")){
		            JOptionPane.showMessageDialog(parent,"password not Entered",
		                                               "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
            }
        }

        return true;
    }

}