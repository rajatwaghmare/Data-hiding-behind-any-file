/*************************************************
*                                                *
*  StegoStick1.0 a Steganographic Tool for BMP   *
*                                                *
*  Author: P.V. Uma Mahesh and V. Santhosh Kumar *
*   email: echo_mahesh@yahoo.co.in,              *
*          santhosh_auce@yahoo.com               *
*                                                *
*          file: PasswordUnhidePanel.java              *
*    date added: 3-01-2007                       *
*       version: 1.0                             *
*                                                *
*   License: GNU General Public Licence          *
* Copyright: 2006-07 by the StegoStick Project   *
*                                                *
* description: Actual source file                *
*                                                *
*************************************************/


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;


/** It is GUI Panel to give interface for Unhiding the secret Information
 *	and takes appropriate steps to Unhide
 */
public class PasswordUnhidePanel extends UnhidePanel {

	UnhideGUI parent;

	public PasswordUnhidePanel(int encryptTechnique, UnhideGUI parent) {
		super();
		this.encryptTechnique = encryptTechnique;
		this.parent = parent;
		initGUI();
	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(504, 364));
			this.setLayout(null);
			this.setOpaque(false);
			this.setForeground(new java.awt.Color(0,128,192));
			{
				coverFilePanel = new JPanel();
				this.add(coverFilePanel);
				coverFilePanel.setBounds(14, 28, 483, 77);
				coverFilePanel.setOpaque(false);
				coverFilePanel.setBorder(BorderFactory.createTitledBorder(null, "Cover File", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Trebuchet MS",0,12), new java.awt.Color(0,0,255)));
				coverFilePanel.setLayout(null);
				coverFilePanel.setFont(new java.awt.Font("Trebuchet MS",0,12));
				coverFilePanel.setForeground(new java.awt.Color(0,128,192));
				{
					coverField = new JTextField();
					coverFilePanel.add(coverField);
					coverField.setBounds(21, 28, 343, 28);
				}
				{
					coverBrowseButton = new JButton();
					coverFilePanel.add(coverBrowseButton);
					coverBrowseButton.setText("browse");
					coverBrowseButton.setBounds(385, 28, 84, 28);
					coverBrowseButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out
								.println("coverBrowseButton.actionPerformed, event="
									+ evt);
							JFileChooser fileChooser = new JFileChooser(currentPath);

						//	ExampleFileFilter imgFilter = new ExampleFileFilter(new String("bmp"),new String("Bit-Map Images"));
                        //    fileChooser.setFileFilter(imgFilter);

                            fileChooser.setDialogTitle(new String("Select Cover Image File"));
				            int result = fileChooser.showOpenDialog(PasswordUnhidePanel.this);

				            if (result == JFileChooser.APPROVE_OPTION) {
				                File f = fileChooser.getSelectedFile();
				                currentPath = f.getPath();
				                coverField.setText(f.getAbsolutePath());
				                dstField.setText(f.getParent());
				            }
						}
					});
				}
			}
			{
				dstPanel = new JPanel();
				this.add(dstPanel);
				dstPanel.setBounds(14, 133, 483, 84);
				dstPanel.setBorder(BorderFactory.createTitledBorder(null, "Destination Path", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Trebuchet MS",0,12), new java.awt.Color(0,0,255)));
				dstPanel.setLayout(null);
				dstPanel.setOpaque(false);
				dstPanel.setFont(new java.awt.Font("Trebuchet MS",0,12));
				dstPanel.setForeground(new java.awt.Color(0,128,192));
				{
					dstField = new JTextField();
					dstPanel.add(dstField);
					dstField.setBounds(21, 35, 343, 28);
				}
				{
					dstBrowseButton = new JButton();
					dstPanel.add(dstBrowseButton);
					dstBrowseButton.setText("browse");
					dstBrowseButton.setBounds(385, 35, 84, 28);
					dstBrowseButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out
								.println("dstBrowseButton.actionPerformed, event="
									+ evt);

							JFileChooser fileChooser = new JFileChooser(currentPath);
							fileChooser.setDialogTitle(new String("Select Destination Folder"));
							fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				            int result = fileChooser.showSaveDialog(PasswordUnhidePanel.this);

				            if (result == JFileChooser.APPROVE_OPTION) {
				                File f = fileChooser.getSelectedFile();
				                currentPath = f.getPath();
				                dstField.setText(f.getAbsolutePath());
				            }
						}
					});
				}
			}
			{
				pwdLabel = new JLabel();
				this.add(pwdLabel);
				pwdLabel.setText("Enter Password");
				pwdLabel.setBounds(21, 245, 196, 35);
				pwdLabel.setFont(new java.awt.Font("Trebuchet MS",1,14));
				pwdLabel.setForeground(new java.awt.Color(0,0,255));
			}
			{
				pwdField = new JPasswordField();
				this.add(pwdField);
				pwdField.setBounds(252, 245, 238, 28);
			}
			{
				backButton = new JButton();
				this.add(backButton);
				backButton.setText("Back");
				backButton.setBounds(24, 294, 105, 49);
				backButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						backButtonActionPerformed(evt);
					}
				});
			}
			{
				unhideButton = new JButton();
				pwdField.setNextFocusableComponent(unhideButton);
				unhideButton.setFocusable(true);
				this.add(unhideButton);
				unhideButton.setText("UnHide");
				unhideButton.setBounds(259, 294, 105, 49);
				unhideButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						unhideButtonActionPerformed(evt);
					}
				});
			}
			{
				clearButton = new JButton();
				this.add(clearButton);
				clearButton.setText("Clear");
				clearButton.setBounds(385, 294, 105, 49);
				clearButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						clearButtonActionPerformed(evt);
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void unhideButtonActionPerformed(ActionEvent evt) {
	//	System.out.println("unhideButton.actionPerformed, event=" + evt);

		String coverFileName = coverField.getText();
		String dstFileName = dstField.getText();
		String password = pwdField.getText();


		Unhide unhider = new Unhide(this);
		unhider.unhideUsingPassword(coverFileName, dstFileName, password, encryptTechnique);
	}

	private void clearButtonActionPerformed(ActionEvent evt) {
		System.out.println("clearButton.actionPerformed, event=" + evt);
		clearFields();
	}
	
	private void backButtonActionPerformed(ActionEvent evt){
		parent.reset();
	}
}