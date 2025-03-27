import Project.ConnectionProvider;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class stockDecrease extends JFrame{
    private JPanel stockDecreasePanel;
    private JComboBox cbBloodGroup;
    private JTextField tfUnits;
    private JButton btnUpdate;
    private JTable table1;
    private JButton btnPrint;
    private JButton btnClose;

    public stockDecrease(JFrame parent) {
        setUndecorated(true);
        setSize(700, 500);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        add(stockDecreasePanel);

        showtable();

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bloodGroup = (String) cbBloodGroup.getSelectedItem();
                String unit = tfUnits.getText();
                int unit1 = Integer.parseInt(unit);

                try{
                    Connection con = ConnectionProvider.getCon();
                    Statement st = con.createStatement();
                    st.executeUpdate("update stock set units=units-'"+unit1+"' where bloodGroup='"+bloodGroup+"'");
                    JOptionPane.showMessageDialog(null,"Successfully Updated");
                    setVisible(false);
                    new stockDecrease(null).setVisible(true);

                }catch (Exception ee){
                    JOptionPane.showMessageDialog(null,ee);
                }
            }
        });

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
        new stockDecrease(null);
    }
}