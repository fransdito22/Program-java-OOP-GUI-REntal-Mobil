package View.DasboardAdmin;

import Controller.MobilController;
import Entity.MobilEntity;
import View.LoginPage.LoginPage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class TampilkanMobil extends JFrame  {
    private DefaultTableModel tableModel;


    public TampilkanMobil() {
        initializeUI();
        displayCars();
        createMenu();
        judul();
    }

    private void initializeUI() {
        setTitle("frnssRENT");
        setSize(1024, 576);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                dispose();
                new LoginPage().runView();
            }
        });
        tableModel = new DefaultTableModel();
        JTable mobilTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(mobilTable);

        tableModel.addColumn("Type");
        tableModel.addColumn("Plat Nomor");
        tableModel.addColumn("Harga Sewa");

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    //dropdown menu
    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem viewCarsMenuItem = new JMenuItem("list mobil");
        viewCarsMenuItem.addActionListener(e -> showCarList());

        JMenuItem addCarMenuItem = new JMenuItem("Tambah mobil");
        addCarMenuItem.addActionListener(e -> showTambahMobilForm());

        JMenuItem deleteCarMenuItem = new JMenuItem("Hapus mobil");
        deleteCarMenuItem.addActionListener(e -> showDeleteMobil());

        JMenuItem homeMenuItem = new JMenuItem("Home");
        homeMenuItem.addActionListener(e -> showHome());

        menu.add(viewCarsMenuItem);
        menu.add(addCarMenuItem);
        menu.add(deleteCarMenuItem);
        menu.add(homeMenuItem);
        menuBar.add(menu);

        setJMenuBar(menuBar);
    }

    private void judul() {
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());

        JLabel judul = new JLabel("List Mobil");
        judul.setFont(new Font("arial", Font.BOLD, 20));
        judul.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(judul, BorderLayout.CENTER);

        titlePanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        getContentPane().add(titlePanel, BorderLayout.NORTH);
    }

    private void displayCars() {
        MobilController mobilController = new MobilController();
        ArrayList<MobilEntity> allMobil = mobilController.readAll();

        if (!allMobil.isEmpty()) {
            for (MobilEntity car : allMobil) {
                Object[] rowData = {car.getTypeMobil(), car.getPlatNomor(), car.getHargaSewa()};
                tableModel.addRow(rowData);
            }
        }
    }

    private void showHome() {
        dispose();
        AdminMenu adminMenu = new AdminMenu();
        adminMenu.setVisible(true);
    }

    private void showCarList() {
        dispose();
        TampilkanMobil tampilkanMobil = new TampilkanMobil();
        tampilkanMobil.setVisible(true);
    }

    private void showTambahMobilForm() {
        dispose();
        TambahMobil tambahMobil = new TambahMobil();
        tambahMobil.setVisible(true);
    }
    private void showDeleteMobil(){
        dispose();
        HapusMobil hapusMobil = new HapusMobil();
        hapusMobil.setVisible(true);
    }


}
