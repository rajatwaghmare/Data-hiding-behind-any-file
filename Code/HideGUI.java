import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

public class HideGUI extends javax.swing.JPanel {
       private JPanel hidePanel;
       private JPanel selectionPanel;

       public HideGUI(){
           selectionPanel = new SelectionPanel(this);
           selectionPanel.setOpaque(false);
           add( selectionPanel );
       }

       public void changePanel(int encryptTechnique){

           remove(selectionPanel);
           if(encryptTechnique == SelectionPanel.RSA)
               hidePanel = new RSAHidePanel(this);
           else
               hidePanel = new PasswordHidePanel( encryptTechnique, this );
           hidePanel.setOpaque(false);
           add( hidePanel );
           validate();
       }
       
       public void reset(){
       		remove(hidePanel);
       		add( selectionPanel );
       		revalidate();
       		updateUI();
       }
}