import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import secretKeyGeneratorPanels.*;


public class KeyGeneratorUI extends JFrame implements ActionListener {

    int stage;              /* Indicates Current Stage in Wizard */

    private JButton nextButton;
    private JButton cancelButton;

    private JPanel navigationPanel;
    private EnterPrimesPanel enterPrimesPanel;
    private DetermineEPanel determineEPanel;
    private DetermineDPanel determineDPanel;
    private ShowKeysPanel showKeysPanel;

    private KeyGenerator keyGen;
    private Container c;

    /**
     * Constructs of Sender Interface Wizard showing Each stages
     */
    public KeyGeneratorUI() {
        super("KeyGenerator");
        this.setSize(437, 370);
        setResizable(false);
        setBackground(new Color(240, 240, 240));

        c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setPreferredSize(new java.awt.Dimension(429, 347));

        navigationPanel = new JPanel(null);
        navigationPanel.setPreferredSize(new Dimension(425, 65));
        navigationPanel.setBorder(BorderFactory.createEtchedBorder(1));
        navigationPanel.setLayout(null);

        nextButton = new JButton(" next > ");
        nextButton.setMargin(new Insets(2, 2, 2, 2));
        nextButton.setBounds(231, 14, 77, 35);
        nextButton.setForeground(new Color(0, 0, 0));
        nextButton.setActionCommand("next");
        nextButton.addActionListener(this);
        nextButton.grabFocus();
        navigationPanel.add(nextButton);
        nextButton.setFont(new java.awt.Font("Tahoma",1,11));

        cancelButton = new JButton(" cancel ");
        cancelButton.setMargin(new Insets(2, 2, 2, 2));
        cancelButton.setBounds(322, 14, 77, 35);
        cancelButton.setForeground(new Color(0, 0, 0));
        cancelButton.setActionCommand("cancel");
        cancelButton.addActionListener(this);
        navigationPanel.add(cancelButton);
        navigationPanel.setBackground(new Color(240, 240, 240));
        cancelButton.setFont(new java.awt.Font("Tahoma",1,11));

        stage = 0;
        enterPrimesPanel = new EnterPrimesPanel();
        keyGen = new KeyGenerator();
        c.add(enterPrimesPanel);
        enterPrimesPanel.setPreferredSize(new java.awt.Dimension(425, 261));
        c.add(navigationPanel);
    }

    /**
     * Actions Performed when next button and cancel button pressed
     *
     * @param e(ActionEvent)
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(new String("next"))) {  // Next Button Pressed
            switch (stage) {
                case 0 :   // initial stage i.e  get primary numbers
                    String pVal = enterPrimesPanel.getP();

                    if (!keyGen.setP(pVal)) { // p is not prime
                        enterPrimesPanel.clearFields();
                        showError(new String("p Value is not prime"));
                        break;
                    }
                    String qVal = enterPrimesPanel.getQ();
                    if (!keyGen.setQ(qVal)) { // p is not prime
                        enterPrimesPanel.clearFields();
                        showError(new String("q Value is not prime"));
                        break;
                    }
                    goToNextStage();       // Stage Successful
                    break;

                case 1 :  // stage : show Available values for public key e
                    String eVal = determineEPanel.getE();
                    if (!keyGen.setE(eVal)) {  // is entered value not correct e value
                        determineEPanel.clearFields();
                        showError(new String("Entered Public Key value not Correct"));
                        break;
                    }
                    goToNextStage();
                    break;

                case 2 :  // stage : show Available values for private key d
                    String dVal = determineDPanel.getD();
                    if (!keyGen.setD(dVal)) {  // is entered value not correct d value
                        determineDPanel.clearFields();
                        showError(new String("Entered Private Key value not Correct"));
                        break;
                    }
                    goToNextStage();
                    break;
                case 3 :  // stage : show All Keys to Sender
                    goToNextStage();
                    break;

                default:
                    this.dispose(); // Dispose this Frame i.e wizard completed
                    break;
            }
        } else if (e.getActionCommand().equals(new String("cancel"))) {  // cancel pressed
            this.dispose();
            System.gc();
        }
    }

    /**
     * Shows Error Message
     *
     * @param msg
     */
    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * It verifies whih stage we are in currently and updates wizard with next stage
     */
    private void goToNextStage() {
        switch (stage) {
            case 0 :
                stage++;
                determineEPanel = new DetermineEPanel(keyGen.getEValues());
                c.remove(enterPrimesPanel);
                c.remove(navigationPanel);
                c.add(determineEPanel);
                c.add(navigationPanel);
                c.validate();
                break;
            case 1 :
                stage++;
                determineDPanel = new DetermineDPanel(keyGen.getDValues());
                c.remove(determineEPanel);
                c.remove(navigationPanel);
                c.add(determineDPanel);
                c.add(navigationPanel);
                c.validate();
                break;
            case 2 :
                stage++;
                showKeysPanel = new ShowKeysPanel(keyGen.getE(), keyGen.getD(), keyGen.getN());
                c.remove(determineDPanel);
                c.remove(navigationPanel);
                c.add(showKeysPanel);
                nextButton.setText("Finish");
                c.add(navigationPanel);
                c.validate();
                break;
            case 3 :
            	this.dispose();
            default :
                this.dispose();
                break;
        }
    }


    public static void main(String args[]) {
          try {
               UIManager.setLookAndFeel(new String("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"));
          } catch (Exception ex) {
          }

        KeyGeneratorUI senderUI = new KeyGeneratorUI();
        senderUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        senderUI.setLocation(260, 200);
        senderUI.setVisible(true);
    }
}