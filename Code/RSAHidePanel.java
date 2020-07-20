
/*************************************************
*                                                *
*  StegoStick1.0 a Steganographic Tool for BMP   *
*                                                *
*  Author: P.V. Uma Mahesh and V. Santhosh Kumar *
*   email: echo_mahesh@yahoo.co.in,              *
*          santhosh_auce@yahoo.com               *
*                                                *
*          file: RSAHidePanel.java                *
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

import java.io.File;


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
/** It is GUI Panel to give interface for Hiding the secret Information
 *	and takes appropriate steps to Hide
 */
public class RSAHidePanel extends HidePanel {

    String currentPath = new String("");
    HideGUI parent;

	public RSAHidePanel(HideGUI parent) {
		super();
		encryptTechnique = SelectionPanel.RSA;
		this.parent = parent;
		initGUI();
	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(490, 371));
			this.setSize(455, 364);
			this.setLayout(null);
			this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED), "", TitledBorder.LEADING, TitledBorder.TOP));
			{
				CoverFilePanel = new JPanel();
				this.add(CoverFilePanel);
				CoverFilePanel.setBounds(14, 112, 462, 77);
				CoverFilePanel.setBorder(BorderFactory.createTitledBorder(null, "Cover File", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Trebuchet MS",0,12), new java.awt.Color(0,0,255)));
				CoverFilePanel.setLayout(null);
				CoverFilePanel.setOpaque(false);
				CoverFilePanel.setFont(new java.awt.Font("Trebuchet MS",0,12));
				CoverFilePanel.setForeground(new java.awt.Color(0,128,192));
				{
					coverField = new JTextField();
					CoverFilePanel.add(coverField);
					coverField.setBounds(21, 28, 315, 28);
				}
				{
					coverFileBrowseButton = new JButton();
					CoverFilePanel.add(coverFileBrowseButton);
					coverFileBrowseButton.setText("browse");
					coverFileBrowseButton.setBounds(371, 28, 77, 28);
					coverFileBrowseButton
						.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
				//			System.out.println("coverFileBrowseButton.actionPerformed, event="+ evt);
							JFileChooser fileChooser = new JFileChooser(currentPath);

				/*			String filters[] = new String[4];
							filters[0] = new String("bmp");
							filters[1] = new String("jpg");
							filters[2] = new String("gif");
							filters[3] = new String("wav");

							ExampleFileFilter imgFilter = new ExampleFileFilter(filters,new String("Image Files"));

                            fileChooser.setFileFilter(imgFilter);
                 */         fileChooser.setDialogTitle(new String("Select Cover Image File"));
				            int result = fileChooser.showOpenDialog(RSAHidePanel.this);

				            if (result == JFileChooser.APPROVE_OPTION) {
				                File f = fileChooser.getSelectedFile();
				                currentPath = f.getPath();
				                coverField.setText(f.getAbsolutePath());
				            }
						}
						});
				}
			}
			{
				DestinationPanel = new JPanel();
				this.add(DestinationPanel);
				DestinationPanel.setBounds(14, 196, 462, 70);
				DestinationPanel.setBorder(BorderFactory.createTitledBorder(null, "Destination Path", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Trebuchet MS",0,12), new java.awt.Color(0,0,255)));
				DestinationPanel.setLayout(null);
				DestinationPanel.setOpaque(false);
				DestinationPanel.setFont(new java.awt.Font("Trebuchet MS",0,12));
				DestinationPanel.setForeground(new java.awt.Color(0,128,192));
				{
					dstBrowseButton = new JButton();
					DestinationPanel.add(dstBrowseButton);
					dstBrowseButton.setText("browse");
					dstBrowseButton.setBounds(371, 28, 77, 28);
					dstBrowseButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
				/*			System.out
								.println("dstBrowseButton.actionPerformed, event="
									+ evt);
				*/			JFileChooser fileChooser = new JFileChooser(currentPath);
							fileChooser.setDialogTitle(new String("Select Destination Folder"));
							fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				            int result = fileChooser.showSaveDialog(RSAHidePanel.this);

				            if (result == JFileChooser.APPROVE_OPTION) {
				                File f = fileChooser.getSelectedFile();
				                currentPath = f.getPath();
				                dstField.setText(f.getAbsolutePath());
				            }
						}
					});
				}
				{
					dstField = new JTextField();
					DestinationPanel.add(dstField);
					dstField.setBounds(21, 28, 315, 28);
				}
			}
			{
				backButton = new JButton();
				this.add(backButton);
				backButton.setText("Back");
				backButton.setBounds(24, 322, 91, 35);
				backButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						backButtonActionPerformed(evt);
					}
				});
			}
			{
				hideButton = new JButton();
				this.add(hideButton);
				hideButton.setText("Hide");
				hideButton.setBounds(266, 322, 91, 35);
				hideButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						hideButtonActionPerformed(evt);
					}
				});
			}
			{
				clearButton = new JButton();
				this.add(clearButton);
				clearButton.setText("Clear");
				clearButton.setBounds(378, 322, 91, 35);
				clearButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						clearButtonActionPerformed(evt);
					}
				});
			}
			{
				secretPane = new JTabbedPane();
				this.add(secretPane);
				secretPane.setBounds(14, 7, 462, 105);
				secretPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				{
					secretFilePanel = new JPanel();
					secretPane.addTab("Hide File", null, secretFilePanel, null);
					secretFilePanel.setBounds(14, 14, 462, 77);
					secretFilePanel.setBorder(BorderFactory.createTitledBorder(
						null,
						"Secret File",
						TitledBorder.LEADING,
						TitledBorder.TOP,
						new java.awt.Font("Trebuchet MS", 0, 12),
						new java.awt.Color(0, 0, 255)));

					secretFilePanel.setLayout(null);
					secretFilePanel.setOpaque(false);
					secretFilePanel.setFont(new java.awt.Font(
						"Trebuchet MS",
						0,
						12));
					secretFilePanel.setForeground(new java.awt.Color(
						0,
						128,
						192));
					secretFilePanel.setPreferredSize(new java.awt.Dimension(448, 63));
					{
						secretField = new JTextField();
						secretFilePanel.add(secretField);
						secretField.setBounds(21, 28, 315, 28);
					}
					{
						secretFileBrowseButton = new JButton();
						secretFilePanel.add(secretFileBrowseButton);
						secretFileBrowseButton.setText("browse");
						secretFileBrowseButton.setBounds(371, 28, 77, 28);
						secretFileBrowseButton
							.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
					/*				System.out
										.println("secretFileBrowseButton.actionPerformed, event="
											+ evt);
					*/				JFileChooser fileChooser = new JFileChooser(
										currentPath);
									fileChooser.setDialogTitle(new String(
										"Select Secret File"));
									int result = fileChooser
										.showOpenDialog(RSAHidePanel.this);

									if (result == JFileChooser.APPROVE_OPTION) {
										File f = fileChooser.getSelectedFile();
										currentPath = f.getPath();
										secretField
											.setText(f.getAbsolutePath());
									}
								}
							});
					}
				}
				{
					messagePanel = new JPanel();
					messagePanel.setLayout(null);
					secretPane.addTab("Hide Message", null, messagePanel, null);
					messagePanel.setPreferredSize(new java.awt.Dimension(457, 68));
					messagePanel.setOpaque(false);

					{
						messageScrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
															JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
						messagePanel.add(messageScrollPane);
						messageScrollPane.setBounds(6, 5, 444, 65);
						{
							messagePane = new JEditorPane();
							messageScrollPane.setViewportView(messagePane);
							messagePane.setPreferredSize(new java.awt.Dimension(442, 63));
							messagePane.setFont(new java.awt.Font("Lucida Console",0,12));
						}
					}
				}
			}
			{
				eField = new JTextField();
				this.add(eField);
				eField.setBounds(98, 280, 98, 28);
			}
			{
				nLabel = new JLabel();
				this.add(nLabel);
				nLabel.setText("Enter N");
				nLabel.setBounds(252, 280, 63, 28);
				nLabel.setFont(new java.awt.Font("Trebuchet MS",1,14));
				nLabel.setForeground(new java.awt.Color(0,0,255));
			}
			{
				eLabel = new JLabel();
				this.add(eLabel);
				eLabel.setText("Enter E");
				eLabel.setBounds(21, 280, 63, 28);
				eLabel.setFont(new java.awt.Font("Trebuchet MS",1,14));
				eLabel.setForeground(new java.awt.Color(0,0,255));
			}
			{
				nField = new JTextField();
				this.add(nField);
				nField.setBounds(329, 280, 140, 28);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void hideButtonActionPerformed(ActionEvent evt){
	//	System.out.println("hideButton.actionPerformed, event=" + evt);

		String msg = messagePane.getText();
		String secretFileName = secretField.getText();
		String coverFileName = coverField.getText();
		String dstFileName = dstField.getText();
		String eVal = eField.getText();
		String nVal = nField.getText();
		String password;

		Hide hider = new Hide(this);
		hider.hideUsingRSA(msg, secretFileName, coverFileName, dstFileName, eVal, nVal);

	}

	private void clearButtonActionPerformed(ActionEvent evt) {
		System.out.println("clearButton.actionPerformed, event=" + evt);
		clearFields();
	}
	
	private void backButtonActionPerformed(ActionEvent evt){
		parent.reset();
	}

}