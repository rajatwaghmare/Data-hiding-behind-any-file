import javax.swing.*;

public class UnhideGUI extends javax.swing.JPanel {
       private JPanel unhidePanel;
       private JPanel selectionPanel;

       public UnhideGUI(){
           selectionPanel = new SelectionPanel(this);
           selectionPanel.setOpaque(false);
           add( selectionPanel );
       }

       public void changePanel(int encryptTechnique){

           remove(selectionPanel);
           if(encryptTechnique == SelectionPanel.RSA)
               unhidePanel = new RSAUnhidePanel(this);
           else
               unhidePanel = new PasswordUnhidePanel( encryptTechnique, this );
           unhidePanel.setOpaque(false);
           add( unhidePanel );
           validate();
       }
       
       public void reset(){
       		remove(unhidePanel);
       		add( selectionPanel );
       		revalidate();
       		updateUI();
       }
}