package secretKeyGeneratorPanels;

import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;

public class ShowKeysPanel extends JPanel {

    private JTextField eField;
    private JTextField nPublicField;
    private JTextField dField;
    private JTextField nPrivateField;

    /**
     * Constructs GUI Panel to show Private and Public keys to sender
     *
     * @param e
     * @param d
     * @param n
     */
    public ShowKeysPanel(BigInteger e, BigInteger d, BigInteger n) {
        setPreferredSize(new Dimension(425, 275));
        setBackground(new Color(240, 240, 240));
        setLayout(null);
        setBorder(BorderFactory.createEtchedBorder());

        JLabel publicKeyLabel = new JLabel("Public Key (e , n)");
        publicKeyLabel.setBounds(21, 28, 119, 21);
        publicKeyLabel.setForeground(new Color(0, 0, 0));
        Font f1 = new Font("Dialog", Font.BOLD, 15);
        publicKeyLabel.setFont(f1);
        add(publicKeyLabel);

        JLabel privateKeyLabel = new JLabel("Private Key (d , n)");
        privateKeyLabel.setBounds(21, 147, 126, 21);
        privateKeyLabel.setForeground(new Color(0, 0, 0));
        Font f2 = new Font("Dialog", Font.BOLD, 15);
        privateKeyLabel.setFont(f2);
        add(privateKeyLabel);

        eField = new JTextField(1);
        eField.setText(String.valueOf(e.intValue()));
        eField.setEditable(false);
        eField.setBounds(231, 28, 140, 28);
        eField.setForeground(new Color(0, 0, 0));
        add(eField);

        nPublicField = new JTextField(1);
        nPublicField.setText(String.valueOf(n.intValue()));
        nPublicField.setEditable(false);
        nPublicField.setBounds(231, 77, 140, 28);
        nPublicField.setForeground(new Color(0, 0, 0));
        add(nPublicField);

        dField = new JTextField(1);
        dField.setText(String.valueOf(d.intValue()));
        dField.setEditable(false);
        dField.setBounds(231, 147, 140, 28);
        dField.setForeground(new Color(0, 0, 0));
        add(dField);

        nPrivateField = new JTextField(1);
        nPrivateField.setText(String.valueOf(n.intValue()));
        nPrivateField.setEditable(false);
        nPrivateField.setBounds(231, 196, 140, 28);
        nPrivateField.setForeground(new Color(0, 0, 0));
        add(nPrivateField);

    }


}