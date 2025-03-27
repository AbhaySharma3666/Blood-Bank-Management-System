import Project.ConnectionProvider;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import javax.swing.JTable;
import java.sql.*;
import java.awt.event.*;


public class allDonorDetails extends JFrame {
    private JButton btnClose;
    private JPanel allDonorDetailsPanel;
    private JTable table1;
    private JButton btnPrint;

    public allDonorDetails(JFrame parent) {
        setUndecorated(true);
        setContentPane(allDonorDetailsPanel);
        setSize(700, 500);

        setLocationRelativeTo(parent);

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
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from donor");
            table1.setAutoResizeMode(table1.AUTO_RESIZE_OFF);
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public static void main(String[] args) {
        allDonorDetails add = new allDonorDetails(null);
    }
}