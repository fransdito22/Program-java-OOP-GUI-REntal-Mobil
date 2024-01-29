package View.DasboardUser;

import Controller.MobilController;
import Entity.MobilEntity;
import View.LoginPage.LoginPage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class CariMobil extends JFrame {
    private DefaultTableModel tableModel;
    private JTextField searchField;

    public CariMobil() {
        initializeUI();
        createMenu();
        createTable();
        createSearchPanel();
        displayCars();
    }

    private void initializeUI() {
        setTitle("frnssRENT");
        setSize(1024, 576);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                dispose();
                new LoginPage().runView();
            }
        });
        setLocationRelativeTo(null);
    }
    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem viewRentalMenuItem = new JMenuItem("List Rental");
        viewRentalMenuItem.addActionListener(e -> showRentalList());

        JMenuItem addRentalMenuItem = new JMenuItem("Tambah Rental");
        addRentalMenuItem.addActionListener(e -> showTambahRentalForm());

        JMenuItem deleteRentalMenuItem = new JMenuItem("Hapus Rental");
        deleteRentalMenuItem.addActionListener(e -> showDeleteRental());

        JMenuItem homeMenuItem = new JMenuItem("Home");
        homeMenuItem.addActionListener(e -> showHome());

        menu.add(viewRentalMenuItem);
        menu.add(addRentalMenuItem);
        menu.add(deleteRentalMenuItem);
        menu.add(homeMenuItem);
        menuBar.add(menu);

        setJMenuBar(menuBar);
    }

    private void createTable() {
        tableModel = new DefaultTableModel();
        JTable carTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(carTable);

        tableModel.addColumn("Type");
        tableModel.addColumn("Plat Nomor");
        tableModel.addColumn("Harga Sewa");

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void createSearchPanel() {
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchCars());

        searchPanel.add(new JLabel("Search by Type:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        getContentPane().add(searchPanel, BorderLayout.NORTH);
    }

    private void searchCars() {
        String searchType = searchField.getText().trim();
        MobilController mobilController = new MobilController();
        ArrayList<MobilEntity> searchResult = mobilController.readCarsByType(searchType);

        tableModel.setRowCount(0);

        if (!searchResult.isEmpty()) {
            for (MobilEntity car : searchResult) {
                Object[] rowData = {car.getTypeMobil(), car.getPlatNomor(), car.getHargaSewa()};
                tableModel.addRow(rowData);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Type Mobil tidak tersedia", "Search Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void displayCars() {
//        menampilkan mobil yang dicari
        MobilController mobilController = new MobilController();
        ArrayList<MobilEntity> allMobil = mobilController.readAll();

        if (!allMobil.isEmpty()) {
            for (MobilEntity car : allMobil) {
                Object[] rowData = {car.getTypeMobil(), car.getPlatNomor(), car.getHargaSewa()};
                tableModel.addRow(rowData);
            }
        }
    }
    private void showRentalList() {
        dispose();
        TampilkanRental showAllRental = new TampilkanRental();
        showAllRental.setVisible(true);
    }

    private void showTambahRentalForm() {
        dispose();
        TambahRental tambahRental = new TambahRental();
        tambahRental.setVisible(true);
    }

    private void showDeleteRental() {
        dispose();
        TampilkanRental tampilkanRental = new TampilkanRental();
        tampilkanRental.setVisible(true);
    }

    private void showHome(){
        dispose();
        UserMenu userMenu = new UserMenu();
        userMenu.setVisible(true);
    }
}
