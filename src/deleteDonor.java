import Project.ConnectionProvider;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class deleteDonor extends JFrame{
    private JTextField tfDonorID;
    private JButton btnSearch;
    private JTextField tfName;
    private JTextField tfFName;
    private JTextField tfMName;
    private JTextField tfDOB;
    private JTextField tfMobile;
    private JTextField tfGender;
    private JTextField tfEmail;
    private JTextField tfBloodGroup;
    private JTextField tfCity;
    private JTextArea taAddress;
    private JButton btnDelete;
    private JButton btnReset;
    private JButton btnClose;
    private JPanel DeleteDonorPanel;


    public deleteDonor(JFrame parent) {
        setUndecorated(true);
        setSize(700, 500);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        add(DeleteDonorPanel);

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String donorId = tfDonorID.getText();
                try{
                    Connection con = ConnectionProvider.getCon();
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select * from donor where donorId ='"+donorId+"'");
                    if (rs.next()){
                        tfName.setText(rs.getString(2));
                        tfFName.setText(rs.getString(3));
                        tfMName.setText(rs.getString(4));
                        tfDOB.setText(rs.getString(6));
                        tfMobile.setText(rs.getString(5));
                        tfGender.setText(rs.getString(7));
                        tfEmail.setText(rs.getString(8));
                        tfBloodGroup.setText(rs.getString(9));
                        tfCity.setText(rs.getString(10));
                        taAddress.setText(rs.getString(11));
                        tfDonorID.setEditable(false);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Donor ID does not Exist");
                    }

                }catch (Exception ee){
                    JOptionPane.showMessageDialog(null,ee);
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String donorId = tfDonorID.getText();
                try{
                    Connection con = ConnectionProvider.getCon();
                    Statement st = con.createStatement();
                    st.executeUpdate("delete * from donor where donotId='"+donorId+"'");
                    JOptionPane.showMessageDialog(null,"Successfully Deleted");
                    setVisible(false);
                }
                catch (Exception ee){
                    JOptionPane.showMessageDialog(null,ee);
                }
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new deleteDonor(null).setVisible(true);
            }
        });

        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
//                new Dashboard(null).setVisible(true);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new deleteDonor(null);
    }
}