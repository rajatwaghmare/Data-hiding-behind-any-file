/*************************************************
*                                                *
*  StegoStick1.0 a Steganographic Tool for BMP   * 
*                                                *
*  Author: P.V. Uma Mahesh and V. Santhosh Kumar *
*   email: echo_mahesh@yahoo.co.in,              *
*          santhosh_auce@yahoo.com               *
*                                                *
*          file: ConverToBMP.java                * 
*    date added: 3-01-2007                       *
*       version: 1.0                             *
*                                                *
*   License: GNU General Public Licence          *
* Copyright: 2006-07 by the StegoStick Project   * 
*                                                *
* description: Actual source file                *
*                                                *
*************************************************/

import javax.imageio.*;
import java.awt.image.*;
import java.io.File;

/** Converts given image to temporary BMP image and delete it
 */
public class ConvertToBMP{
    public boolean convertToBMP(String imgFile){
        try{
            BufferedImage img = ImageIO.read(new File(imgFile));

            ImageIO.write(img,new String("bmp"),new File("C:\\WINDOWS\\Temp\\temp.bmp"));
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    void deleteTempImage(){
        try{
            File f = new File("C:\\WINDOWS\\Temp\temp.bmp");
            f.delete();
        }catch(Exception ex){
        }
    }
}
