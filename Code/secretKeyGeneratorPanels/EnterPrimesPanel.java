package secretKeyGeneratorPanels;


import javax.swing.*;
import java.awt.*;

public class EnterPrimesPanel extends JPanel {

    private JTextField pField;
    private JTextField qField;

    private JLabel waitLabel;

    /**
     * Constructs GUI Panel for entering prime numbers and inputs and sends to Encryptor
     * User Interface
     */
    public EnterPrimesPanel() {
        setPreferredSize(new Dimension(425, 275));
        setBackground(new Color(240, 240, 240));
        setLayout(null);
        setBorder(BorderFactory.createEtchedBorder());

        JLabel pLabel = new JLabel("Enter Prime Number (p)");
        pLabel.setBounds(21, 63, 168, 28);
        pLabel.setForeground(new Color(0, 0, 0));
        Font f1 = new Font("Dialog", Font.BOLD, 15);
        pLabel.setFont(f1);
        add(pLabel);

        JLabel qLabel = new JLabel("Enter Prime Number (q)");
        qLabel.setBounds(21, 133, 168, 28);
        qLabel.setForeground(new Color(0, 0, 0));
        Font f2 = new Font("Dialog", Font.BOLD, 14);
        qLabel.setFont(f2);
        add(qLabel);

        waitLabel = new JLabel("Please Wait while verifying Prime Numbers");
        waitLabel.setBounds(40, 200, 335, 23);
        waitLabel.setForeground(new Color(0, 0, 0));
        Font f3 = new Font("SansSherif", Font.TRUETYPE_FONT, 15);
        waitLabel.setFont(f3);

        pField = new JTextField(3);
        pField.setText("");
        pField.setBounds(210, 63, 140, 28);
        pField.setForeground(new Color(0, 0, 0));
        add(pField);
        pField.setFont(new java.awt.Font("Tw Cen MT",0,11));

        qField = new JTextField(3);
        qField.setText("");
        qField.setBounds(210, 133, 140, 28);
        qField.setForeground(new Color(0, 0, 0));
        add(qField);

    }

    /**
     * Retrurns p value
     *
     * @return p
     */
    public String getP() {
        add(waitLabel);
        this.validate();
        return pField.getText();
    }

    /**
     * returns q Value
     *
     * @return q
     */
    public String getQ() {
        return qField.getText();
    }

    /**
     * Clears All the Fields used in this Panel
     */
    public void clearFields() {
        pField.setText("");
        qField.setText("");
        this.remove(waitLabel);
    }

}