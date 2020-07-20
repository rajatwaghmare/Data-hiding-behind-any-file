/*************************************************
*                                                *
*  StegoStick1.0 a Steganographic Tool for BMP   * 
*                                                *
*  Author: P.V. Uma Mahesh and V. Santhosh Kumar *
*   email: echo_mahesh@yahoo.co.in,              *
*          santhosh_auce@yahoo.com               *
*                                                *
*          file: SecretMessageFrame.java         * 
*    date added: 3-01-2007                       *
*       version: 1.0                             *
*                                                *
*   License: GNU General Public Licence          *
* Copyright: 2006-07 by the StegoStick Project   * 
*                                                *
* description: Actual source file                *
*                                                *
*************************************************/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JOptionPane;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


/** It Shows the Secret Message hided in the stego image 
 */
 
public class SecretMessageFrame extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JLabel showMsgLabel;
	private JTextPane msgPane;
	private JScrollPane msgScrollPane;
	private JButton okButton;
	private JButton saveButton;
	private String currentPath;
	private String msg;

	// Takes Message and Current Path to Save the Message	
	public SecretMessageFrame(String message, String curPath) {
		super("Hidden Message Successfully Retreived");
		currentPath = curPath;
		msg = message;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setResizable(false);
		    setBackground(new java.awt.Color(0,128,192));
			getContentPane().setLayout(null);
			{
				showMsgLabel = new JLabel();
				getContentPane().add(showMsgLabel);
				showMsgLabel.setText("Hidden Message");
				showMsgLabel.setBounds(14, 21, 399, 28);
				showMsgLabel.setFont(new java.awt.Font("Palatino Linotype",1,18));
				showMsgLabel.setForeground(new java.awt.Color(0,0,255));
			}
			{
				msgScrollPane = new JScrollPane();
				getContentPane().add(msgScrollPane);
				msgScrollPane.setBounds(14, 49, 399, 147);
				{
					msgPane = new JTextPane();
					msgPane.setText(msg);
					msgScrollPane.setViewportView(msgPane);
					msgPane.setBounds(189, 35, 63, 28);
					msgPane.setBorder(BorderFactory
						.createEtchedBorder(BevelBorder.LOWERED));
					msgPane.setEditable(false);
					msgPane.setFont(new java.awt.Font("Lucida Console",0,12));
					msgPane.setCaretPosition(0);
					
				}
			}
			{
				saveButton = new JButton();
				getContentPane().add(saveButton);
				saveButton.setText("Save");
				saveButton.setBounds(231, 210, 84, 35);
				saveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("saveButton.actionPerformed, event="
							+ evt);
						JFileChooser fileChooser = new JFileChooser(currentPath);

						ExampleFileFilter txtFilter = new ExampleFileFilter(new String("txt"), 
																			new String("Text Files"));

                        fileChooser.setFileFilter(txtFilter);
                        fileChooser.setDialogTitle(new String("Save Hidden Message"));
			            int result = fileChooser.showSaveDialog(SecretMessageFrame.this);

			            if (result == JFileChooser.APPROVE_OPTION) {
			                try{
			                	File fl = fileChooser.getSelectedFile();
			                    File f = new File(fl.getAbsolutePath()+".txt");
			                	currentPath = f.getPath();
			                	FileOutputStream fout = new FileOutputStream(f);
			                	byte msg[] = msgPane.getText().getBytes();
			                	fout.write(msg);
			                	fout.close();
			                }catch(IOException ex){
			                	JOptionPane.showMessageDialog(SecretMessageFrame.this, "Error Saving the File",
			                									"Error", JOptionPane.ERROR_MESSAGE);
			                }
			            }
					}
				});
			}
			{
				okButton = new JButton();
				getContentPane().add(okButton);
				okButton.setText("OK");
				okButton.setBounds(329, 210, 84, 35);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("okButton.actionPerformed, event="
							+ evt);
						SecretMessageFrame.this.dispose();
					}
				});
			}
			pack();
			this.setSize(435, 292);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
