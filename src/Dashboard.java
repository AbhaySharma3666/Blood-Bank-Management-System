import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
    private JPanel DBPanel;
    private JMenuBar MenuBar;
    private JMenu menuDonor;
    private JMenu menuSearch;
    private JMenu menuStock;
    private JMenu menuDelete_Donor;
    private JMenu menuExit;
    private JMenuItem btnLogout;
    private JMenuItem btnExitAppl;
    private JMenuItem btnDelete;
    private JMenuItem btnIncrease;
    private JMenuItem btnDecrease;
    private JMenuItem btnD_Details;
    private JMenuItem btnLocation;
    private JMenuItem btnBloodGroup;
    private JMenuItem btnAddNew;
    private JMenuItem btnUpdate;
    private JMenuItem btnAll_Donor;

    public Dashboard(JFrame parent) {
        setTitle("Home Page");
        setContentPane(DBPanel);
        setSize(1366, 768);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

//        setExtendedState(JFrame.MAXIMIZED_BOTH);

        btnAddNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddNewDonor(null).setVisible(true);
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateDonorDetail(null).setVisible(true);
            }
        });

        btnAll_Donor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new allDonorDetails(null).setVisible(true);
            }
        });

        btnLocation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new searchBloodDonorLocation(null).setVisible(true);
            }
        });

        btnBloodGroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new searchBloodDonorBloodGroup(null).setVisible(true);
            }
        });

        btnIncrease.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new stockIncrease(null).setVisible(true);
            }
        });

        btnDecrease.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new stockDecrease(null).setVisible(true);
            }
        });

        btnD_Details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new stockDetails(null).setVisible(true);
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new deleteDonor(null).setVisible(true);
            }
        });

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null,
                        "Do you really want to logout",
                        "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0) {
                    setVisible(false);
                    new LoginForm(null).setVisible(true);
                }
            }
        });

        btnExitAppl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null,
                        "Do you really want to Close Application",
                        "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0) {
                    System.exit(0);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
//        new LoginForm(null);
        Dashboard dashboard = new Dashboard(null);
    }
}