import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JDialog {
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JButton btnOk;
    private JButton btnCancel;
    private JPanel loginPanel;

    public LoginForm(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(600, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Action listener of login ok button
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfUsername.getText();
                String password = new String(pfPassword.getPassword()); // Convert char[] to String

                if (username.equals("bbms") && password.equals("bbms")) {
                    setVisible(false);
                    new Dashboard(null).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Incorrect Username or Password");
                }
            }
        });

        // Action listener of login cancel button
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a  = JOptionPane.showConfirmDialog(null,
                        "Do you really want to close the application?",
                        "Select", JOptionPane.YES_NO_OPTION);
                if (a == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {

        LoginForm loginForm = new LoginForm(null);

    }
}