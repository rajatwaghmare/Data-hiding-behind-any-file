package secretKeyGeneratorPanels;


import javax.swing.*;
import java.awt.*;

public class DetermineEPanel extends JPanel {

    private JTextArea showEArea;
    private JTextField eField;

    /**
     * Takes all available e Values in string form and shows it to user and
     * takes input one e value
     *
     * @param eValues
     */
    public DetermineEPanel(String eValues) {
        setPreferredSize(new Dimension(425, 275));
        setBackground(new Color(240, 240, 240));
        setLayout(null);
        setBorder(BorderFactory.createEtchedBorder());

        JLabel showELabel = new JLabel("Allowable public key Values");
        showELabel.setBounds(25, 20, 310, 20);
        showELabel.setForeground(new Color(0, 0, 0));
        Font f1 = new Font("Dialog", Font.BOLD, 15);
        showELabel.setFont(f1);
        add(showELabel);

        JLabel enterELabel = new JLabel("Enter Selected E Value (public key)");
        enterELabel.setBounds(21, 238, 252, 28);
        enterELabel.setForeground(new Color(0, 0, 0));
        Font f2 = new Font("Dialog", Font.BOLD, 14);
        enterELabel.setFont(f2);
        add(enterELabel);

        showEArea = new JTextArea(0, 1);
        showEArea.setLineWrap(true);
        showEArea.setWrapStyleWord(true);
        showEArea.setEditable(false);
        showEArea.setText(eValues);
        JScrollPane sp = new JScrollPane(showEArea);
        sp.setBounds(20, 55, 370, 160);
        showEArea.setForeground(new Color(0, 0, 0));
        add(sp);

        eField = new JTextField(1);
        eField.setText("");
        eField.setBounds(294, 238, 98, 28);
        eField.setForeground(new Color(0, 0, 0));
        eField.grabFocus();
        eField.setText(eValues.substring(0, eValues.indexOf("\t")));
        add(eField);

    }

    /**
     * Returns e value if correct else -1 if NumberFormatException occurs
     *
     * @return e
     */

    public String getE() {
        return eField.getText();
    }

    /**
     * Clears All the Fields used in this Panel
     */
    public void clearFields() {
        eField.setText("");
    }

}