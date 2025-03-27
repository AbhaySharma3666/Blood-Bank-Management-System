import Project.ConnectionProvider;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateDonorDetail extends JFrame {
    private JPanel UpdateDetailsPanel;
    private JTextField tfDonorID;
    private JButton btnSearch;
    private JTextField tfName;
    private JTextField tfFName;
    private JTextField tfMName;
    private JTextField tfDOB;
    private JTextField tfMobile;
    private JTextField tfEmail;
    private JTextField tfCity;
    private JTextArea taAddress;
    private JButton btnUpdate;
    private JButton btnReset;
    private JButton btnClose;
    private JTextField tfBloodGroup;
    private JTextField tfGender;

    public UpdateDonorDetail(JFrame parent) {
        setUndecorated(true);
        setSize(700, 500);
        setLocationRelativeTo(parent);
        setContentPane(UpdateDetailsPanel);

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String donorID = tfDonorID.getText();
                try {
                    Connection con = ConnectionProvider.getCon();
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM Donor WHERE donorId='" + donorID + "'");
                    if (rs.next()) {
                        tfName.setText(rs.getString(2));
                        tfFName.setText(rs.getString(3));
                        tfMName.setText(rs.getString(4));
                        tfDOB.setText(rs.getString(5));
                        tfMobile.setText(rs.getString(6));
                        tfGender.setText(rs.getString(7));
                        tfEmail.setText(rs.getString(8));
                        tfBloodGroup.setText(rs.getString(9));
                        tfCity.setText(rs.getString(10));
                        taAddress.setText(rs.getString(11));
                        tfDonorID.setEnabled(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Donor ID does not exist");
                    }
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.getMessage());
                }
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String donorID = tfDonorID.getText();
                String name = tfName.getText();
                String fatherName = tfFName.getText();
                String motherName = tfMName.getText();
                String DOB = tfDOB.getText();
                String MobileNo = tfMobile.getText();
                String gender = tfGender.getText();
                String email = tfEmail.getText();
                String bloodGroup = tfBloodGroup.getText();
                String city = tfCity.getText();
                String address = taAddress.getText();
                try {
                    Connection con = ConnectionProvider.getCon();
                    Statement st = con.createStatement();
                    st.executeUpdate("UPDATE donor SET name='" + name + "', fatherName='" + fatherName + "', motherName='" + motherName + "', DOB='" + DOB + "', MobileNo='" + MobileNo + "', gender='" + gender + "', email='" + email + "', bloodGroup='" + bloodGroup + "', city='" + city + "', address='" + address + "' WHERE donorId='" + donorID + "'");
                    JOptionPane.showMessageDialog(null, "Successfully Updated");
                    resetFields();
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, "Connection Error");
                }
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields();
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

    private void resetFields() {
        tfDonorID.setText("");
        tfDonorID.setEnabled(true);
        tfName.setText("");
        tfFName.setText("");
        tfMName.setText("");
        tfDOB.setText("");
        tfMobile.setText("");
        tfGender.setText("");
        tfEmail.setText("");
        tfBloodGroup.setText("");
        tfCity.setText("");
        taAddress.setText("");
    }

    public static void main(String[] args) {
        new UpdateDonorDetail(null);
    }
}