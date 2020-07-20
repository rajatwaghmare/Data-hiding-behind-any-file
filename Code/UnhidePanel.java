import javax.swing.*;

public class UnhidePanel extends JPanel{
    protected JPanel coverFilePanel;
	protected JTextField coverField;
	protected JPanel dstPanel;
	protected JTextField nField;
	protected JLabel nLabel;
	protected JTextField dField;
	protected JLabel dLabel;
	protected JButton clearButton;
	protected JButton unhideButton;
	protected JButton dstBrowseButton;
	protected JButton backButton;
	protected JTextField dstField;
	protected JButton coverBrowseButton;
	protected JPasswordField pwdField;
	protected JLabel pwdLabel;
    protected String currentPath = new String("");
	protected int encryptTechnique;

	public void clearFields(){
		coverField.setText("");
		dstField.setText("");
		if(encryptTechnique == 3){
            dField.setText("");
            nField.setText("");
        }
        else
            pwdField.setText("");
	}
}