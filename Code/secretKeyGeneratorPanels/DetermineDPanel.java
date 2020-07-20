package secretKeyGeneratorPanels;


import javax.swing.*;
import java.awt.*;

public class DetermineDPanel extends JPanel {

    private JTextArea showDArea;
    private JTextField dField;

    /**
     * Takes all available d Values in string form and shows it to user and
     * takes input one d value
     *
     * @param dValues
     */
    public DetermineDPanel(String dValues) {
        setPreferredSize(new Dimension(425, 275));
        setBackground(new Color(240, 240, 240));
        setLayout(null);
        setBorder(BorderFactory.createEtchedBorder());

        JLabel showDLabel = new JLabel("Allowable Private Key Values");
        showDLabel.setBounds(25, 20, 310, 20);
        showDLabel.setForeground(new Color(0, 0, 0));
        Font f1 = new Font("Dialog", Font.BOLD, 15);
        showDLabel.setFont(f1);
        add(showDLabel);

        JLabel enterDLabel = new JLabel("Enter Selected Private Key");
        enterDLabel.setBounds(21, 231, 238, 28);
        enterDLabel.setForeground(new Color(0, 0, 0));
        Font f2 = new Font("Dialog", Font.BOLD, 14);
        enterDLabel.setFont(f2);
        add(enterDLabel);

        showDArea = new JTextArea(0, 1);
        showDArea.setLineWrap(true);
        showDArea.setWrapStyleWord(true);
        showDArea.setEditable(false);
        showDArea.setText(dValues);
        JScrollPane sp = new JScrollPane(showDArea);
        sp.setBounds(20, 55, 370, 160);
        showDArea.setForeground(new Color(0, 0, 0));
        add(sp);

        dField = new JTextField(1);
        dField.setText("");
        dField.setBounds(287, 231, 105, 28);
        dField.setForeground(new Color(0, 0, 0));
        dField.setFocusable(true);
        dField.setText(dValues.substring(0, dValues.indexOf("\t")));
        add(dField);

    }

    /**
     * Returns d value as string
     *
     * @return d
     */

    public String getD() {
        return dField.getText();
    }

    /**
     * Clears all the fields
     */
    public void clearFields() {
        dField.setText("");
    }

}