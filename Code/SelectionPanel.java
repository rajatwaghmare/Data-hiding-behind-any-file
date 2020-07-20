


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class SelectionPanel extends javax.swing.JPanel {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JLabel noteLabel;
	private JRadioButton des3RadioButton;
	private JRadioButton defaultRadiobutton;
	private JRadioButton rsaRadioButton;
	private JButton okButton;
	private JButton generateKeyButton;
	private JRadioButton desRadioButton;
	private ButtonGroup radioGroup;
    private HideGUI hideParent;
    private UnhideGUI unhideParent;

	private int encryptTechnique = 0;
	public static int DEFAULT = 0;
	public static int DES = 1;
	public static int DES3 = 2;
	public static int RSA = 3;
	int mode;
	public static int HIDE = 1;
	public static int UNHIDE = 2;

	/**
	* Auto-generated main method to display this
	* JPanel inside a new JFrame.
	*/
/*	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new SelectionPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
 */
	public SelectionPanel(HideGUI p) {
		super();
		hideParent = p;
		mode = HIDE;
		initGUI();
	}
	public SelectionPanel(UnhideGUI p){
        super();
        unhideParent = p;
        mode = UNHIDE;
        initGUI();
    }

	private void initGUI() {
		try {
			setPreferredSize(new Dimension(455, 364));
			this.setLayout(null);

			{
				noteLabel = new JLabel();
				this.add(noteLabel);
				noteLabel.setText("Select the Encryption Technique");
				noteLabel.setBounds(49, 42, 280, 28);
				noteLabel.setFont(new java.awt.Font("Trebuchet MS",1,18));
				noteLabel.setForeground(new java.awt.Color(0,0,255));
			}
			{
				desRadioButton = new JRadioButton();
				this.add(desRadioButton);
				desRadioButton.setText("DES ");
				desRadioButton.setBounds(49, 105, 231, 28);
				desRadioButton.setOpaque(false);
				desRadioButton.setToolTipText("Password  Based Data Encryption Standard");
			}
			{
				des3RadioButton = new JRadioButton();
				this.add(des3RadioButton);
				des3RadioButton.setText("Triple DES");
				des3RadioButton.setBounds(49, 147, 105, 28);
				des3RadioButton.setOpaque(false);
				des3RadioButton.setToolTipText("Password  Based Triple Data Encryption Standard,Robust than DES");
			}
			{
				rsaRadioButton = new JRadioButton();
				this.add(rsaRadioButton);
				rsaRadioButton.setText("RSA ");
				rsaRadioButton.setBounds(49, 189, 196, 28);
				rsaRadioButton.setOpaque(false);
				rsaRadioButton.setToolTipText("Public Key - Private Key Asymetric Encryption Technique");
			}
			radioGroup = new ButtonGroup();
			radioGroup.add(desRadioButton);
			desRadioButton.setFont(new java.awt.Font("Tahoma",1,14));
			desRadioButton.setForeground(new java.awt.Color(128,0,255));
			desRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					System.out.println("desRadioButton.actionPerformed, event="
						+ evt);
					encryptTechnique = DES;
					generateKeyButton.setEnabled(false);
				}
			});
			radioGroup.add(des3RadioButton);
			des3RadioButton.setFont(new java.awt.Font("Tahoma",1,14));
			des3RadioButton.setForeground(new java.awt.Color(128,0,255));
			des3RadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					System.out
						.println("des3RadioButton.actionPerformed, event="
							+ evt);
					encryptTechnique = DES3;
					generateKeyButton.setEnabled(false);
				}
			});
			radioGroup.add(rsaRadioButton);
			rsaRadioButton.setFont(new java.awt.Font("Tahoma",1,14));
			rsaRadioButton.setForeground(new java.awt.Color(128,0,255));
			rsaRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					System.out.println("rsaRadioButton.actionPerformed, event="
						+ evt);
					encryptTechnique = RSA;
					generateKeyButton.setEnabled(true);
				}
			});
			{
				generateKeyButton = new JButton();
				this.add(generateKeyButton);
				generateKeyButton.setText("Generate Keys");
				generateKeyButton.setBounds(273, 189, 154, 28);
				generateKeyButton.setFont(new java.awt.Font("Tahoma",1,11));
				generateKeyButton.setEnabled(false);
				generateKeyButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						generateKeyButtonActionPerformed(evt);
					}
				});
			}
			{
				okButton = new JButton();
				this.add(okButton);
				okButton.setText("OK");
				okButton.setBounds(196, 280, 63, 28);
				okButton.setFont(new java.awt.Font("Tahoma",1,11));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						okButtonActionPerformed(evt);
					}
				});
			}
			{
				defaultRadiobutton = new JRadioButton();
				this.add(defaultRadiobutton);
				defaultRadiobutton.setText("Default");
				defaultRadiobutton.setBounds(49, 231, 98, 28);
				defaultRadiobutton.setOpaque(false);
				defaultRadiobutton.setFont(new java.awt.Font("Tahoma",1,14));
				defaultRadiobutton.setForeground(new java.awt.Color(128,0,255));
				defaultRadiobutton.setToolTipText("A Simple Fast Password Based Encryption Technique");
				defaultRadiobutton.setSelected(true);
				defaultRadiobutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out
							.println("defaultRadiobutton.actionPerformed, event="
								+ evt);
						encryptTechnique = DEFAULT;
						generateKeyButton.setEnabled(false);
					}
				});
			}
			radioGroup.add(defaultRadiobutton);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void generateKeyButtonActionPerformed(ActionEvent evt) {
		System.out.println("generateKeyButton.actionPerformed, event=" + evt);
		KeyGeneratorUI senderUI = new KeyGeneratorUI();
        senderUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        senderUI.setLocation(260, 200);
        senderUI.setVisible(true);
	}

	private void okButtonActionPerformed(ActionEvent evt) {
		System.out.println("okButton.actionPerformed, event=" + evt);

		if(mode==HIDE)
            hideParent.changePanel(encryptTechnique);
        else
            unhideParent.changePanel(encryptTechnique);
	}

}