import Project.ConnectionProvider;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class stockDetails extends JFrame {
    private JTable table1;
    private JButton btnPrint;
    private JButton btnClose;
    private JPanel stockDetailPanel;

    public stockDetails(JFrame parent) {
        setUndecorated(true);
        setSize(700, 500);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        add(stockDetailPanel);

        showtable();

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

        setVisible(true);
    }

    private void showtable(){
        try{
            Connection con = ConnectionProvider.getCon();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from stock");
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }

    public static void main(String[] args) {
        new stockDetails(null);
    }
}