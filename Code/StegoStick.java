

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.*;


/** It Provides Full GUI for User to Perform Hiding and Unhiding
 */
public class StegoStick extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	private JLabel titleLabel;
	private JTextPane licensePane;
	private JScrollPane readmeScrollPane;
	private JScrollPane helpScrollPane;
	private JTextPane helpPane;
	private JScrollPane licenceScrollPane;
	private JPanel licencePanel;
	private JPanel helpPanel;
	private JPanel unhidingPanel;
	private JPanel hidingPanel;
	private JPanel selectionPanel;
	private JTextPane readmePane;
	private JPanel readmePanel;
	private JTabbedPane containerPane;

	String readme = new String("Robust Stegnography");

    // Main Method
	public static void main(String[] args) {
	    Splash splashScreen = new Splash(1); // Logo.jpg

	    StegoStick inst = new StegoStick();
	    try{
             Thread.sleep(3000);
		     splashScreen.dispose();
		}
		catch(Exception ex){}
		inst.setVisible(true);
	}

	public StegoStick() {
		super("StegoStick");

		setLocation(180,175);
		setResizable(false);
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				titleLabel = new JLabel();
				getContentPane().add(titleLabel);
				titleLabel.setText("Robust Video Data Hiding");
				titleLabel.setFont(new java.awt.Font("Baskerville Old Face",1,20));
				titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
				titleLabel.setBounds(0, 0, 550, 49);
			}
			{
				containerPane = new JTabbedPane();
				getContentPane().add(containerPane);
				containerPane.setBounds(0, 49, 595, 371);
				containerPane.setTabPlacement(JTabbedPane.LEFT);
				{
					hidingPanel = new HideGUI();
					containerPane.addTab("Hiding", null, hidingPanel, null);
					hidingPanel.setPreferredSize(new java.awt.Dimension(459,371));
					hidingPanel.setOpaque(false);
             	}
				{
					unhidingPanel = new UnhideGUI();
					containerPane.addTab("UnHiding", null, unhidingPanel, null);
					unhidingPanel.setOpaque(false);
				}
			}
			pack();
			this.setSize(610, 461);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}