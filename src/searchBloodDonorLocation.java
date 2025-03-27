import Project.ConnectionProvider;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class searchBloodDonorLocation extends JFrame {
    private JPanel LocationPanel;
    private JTextField tfAddress;
    private JTable table1;
    private JButton btnPrint;
    private JButton btnClose;

    public searchBloodDonorLocation(JFrame parent) {
        setUndecorated(true);
        setSize(700, 500);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        add(LocationPanel);

        // Initialize the table to handle empty or initial data state
        table1.setModel(new DefaultTableModel());

        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    table1.print(JTable.PrintMode.NORMAL);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee);
                }
            }
        });

        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });

        tfAddress.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String location = tfAddress.getText();
                try {
                    Connection con = ConnectionProvider.getCon();
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM donor WHERE city LIKE '%" + location + "%' OR address LIKE '%" + location + "%'");
                    table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    table1.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new searchBloodDonorLocation(null);
            }
        });
    }
}