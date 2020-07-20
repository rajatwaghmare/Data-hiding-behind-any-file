import javax.swing.*;

public class HidePanel extends JPanel{
    protected JPanel secretFilePanel;
	protected JTextField secretField;
	protected JButton secretFileBrowseButton;
	protected JButton hideButton;
	protected JButton backButton;
	protected JScrollPane messageScrollPane;
	protected JEditorPane messagePane;
	protected JPanel messagePanel;
	protected JTabbedPane secretPane;
	protected JButton clearButton;
	protected JPasswordField pwdField;
	protected JLabel pwdLabel;
	protected JTextField dstField;
	protected JButton dstBrowseButton;
	protected JPanel DestinationPanel;
	protected JButton coverFileBrowseButton;
	protected JTextField coverField;
	protected JPanel CoverFilePanel;
	protected JLabel eLabel;
	protected JLabel nLabel;
	protected JTextField eField;
	protected JTextField nField;
    protected int encryptTechnique;

    public void clearFields(){
        secretField.setText("");
        messagePane.setText("");
        coverField.setText("");
        dstField.setText("");
        if(encryptTechnique == 3){
            eField.setText("");
            nField.setText("");
        }
        else
            pwdField.setText("");
    }
}