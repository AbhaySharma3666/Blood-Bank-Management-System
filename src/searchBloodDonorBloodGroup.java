import Project.ConnectionProvider;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class searchBloodDonorBloodGroup extends JFrame{
    private JPanel SearchBloodGroupPanel;
    private JTextField tfBloodGroup;
    private JTable table1;
    private JButton btnPrint;
    private JButton btnClose;

    public searchBloodDonorBloodGroup(JFrame parent) {
        setUndecorated(true);
        setSize(800, 500);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        add(SearchBloodGroupPanel);

        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    table1.print(JTable.PrintMode.NORMAL);
                }
                catch (Exception ee){
                    JOptionPane.showMessageDialog(null,ee);
                }
            }
        });

        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
//                new Dashboard(null).setVisible(true);
            }
        });

        tfBloodGroup.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String bloodgroup = tfBloodGroup.getText();
                try{
                    Connection con = ConnectionProvider.getCon();
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from donor where bloodGroup like '%"+ bloodgroup+"%'");
                    table1.setAutoResizeMode(table1.AUTO_RESIZE_OFF);
                    table1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch (Exception ee){
                    JOptionPane.showMessageDialog(null,ee);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new searchBloodDonorBloodGroup(null);
    }
}