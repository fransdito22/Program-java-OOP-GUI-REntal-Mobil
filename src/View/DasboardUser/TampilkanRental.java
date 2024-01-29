package View.DasboardUser;

import Controller.RentalController;
import Entity.RentEntity;
import View.LoginPage.LoginPage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class TampilkanRental extends JFrame {
    private DefaultTableModel tableModel;

    private final RentalController rentalController;

    public TampilkanRental() {
        rentalController = new RentalController();
        initializeUI();
        displayRentals();
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
        JTable rentalTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(rentalTable);

        tableModel.addColumn("Nama Penyewa");
        tableModel.addColumn("Alamat Penyewa");
        tableModel.addColumn("Lama Sewa");
        tableModel.addColumn("Total Harga Sewa");

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

//    dropdown menu
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

    private void judul() {
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());

        JLabel judul = new JLabel("List Rental");
        judul.setFont(new Font("arial", Font.BOLD, 20));
        judul.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(judul, BorderLayout.CENTER);

        titlePanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        getContentPane().add(titlePanel, BorderLayout.NORTH);
    }

    private void displayRentals() {
        ArrayList<RentEntity> allRentals = rentalController.showAllRent();

        if (!allRentals.isEmpty()) {
            for (RentEntity rental : allRentals) {
                Object[] rowData = {rental.getNamaPenyewa(), rental.getAlamatPenyewa(), rental.getLamaSewa(), rental.getTotalHargaSewa()};
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
