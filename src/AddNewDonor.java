import Project.ConnectionProvider;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class AddNewDonor extends JFrame {

    private JPanel AddDonorPanel;
    private JTextField tfName;
    private JTextField tfFName;
    private JTextField tfMName;
    private JTextField tfDOB;
    private JTextField tfMobile;
    private JComboBox<String> cbGender;
    private JTextField tfEmail;
    private JTextField tfCity;
    private JTextArea taAddress;
    private JButton btnSave;
    private JButton btnReset;
    private JButton btnClose;
    private JLabel tfDonorID;
    private JComboBox<String> cbBloodGroup;

    public AddNewDonor(JFrame parent) {
        setUndecorated(true);
        setContentPane(AddDonorPanel);
        setSize(700, 500);
        setLocationRelativeTo(parent);

        IDShown();

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String donorID = tfDonorID.getText();
                String name = tfName.getText();
                String fatherName = tfFName.getText();
                String motherName = tfMName.getText();
                String DOB = tfDOB.getText();
                String MobileNo = tfMobile.getText();
                String gender = (String) cbGender.getSelectedItem();
                String email = tfEmail.getText();
                String bloodGroup = (String) cbBloodGroup.getSelectedItem();
                String city = tfCity.getText();
                String address = taAddress.getText();

                try {
                    Connection con = ConnectionProvider.getCon();
                    Statement st = con.createStatement();
                    st.executeUpdate("insert into donor values('"
                            + donorID + "','"
                            + name + "','"
                            + fatherName + "','"
                            + motherName + "','"
                            + DOB + "','"
                            + MobileNo + "','"
                            + gender + "','"
                            + email + "','"
                            + bloodGroup + "','"
                            + city + "','"
                            + address + "')"
                    );
                    JOptionPane.showMessageDialog(null, "Successfully Updated");
                    setVisible(false);
                    new AddNewDonor(null).setVisible(true);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.getMessage());
                }
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AddNewDonor(null).setVisible(true);
            }
        });

        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setVisible(true);
    }

    private void IDShown() {
        try {
            Connection con = ConnectionProvider.getCon();
            // Create a Statement with a ResultSet that allows scrolling
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("select max(donorId) from donor");
            if (rs.first()) {
                int id = rs.getInt(1);
                id = id + 1;
                String str = String.valueOf(id);
                tfDonorID.setText(str);
            } else {
                tfDonorID.setText("1");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void main(String[] args) {
        new AddNewDonor(null);
    }
}