package View.DasboardUser;

import Controller.RentalController;
import View.LoginPage.LoginPage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TambahRental extends JFrame {
    private final RentalController rentalController = new RentalController();
    private JTextField namaField, alamatField, lamaSewaField, labelTipeMobil;

    public TambahRental() {
        initUI();
        createUI();
        createMenu();
        judul();
    }

    private void initUI() {
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
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(null);
        createFormPanel(formPanel);
        add(formPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void createUI() {
        setVisible(true);
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
        deleteRentalMenuItem.addActionListener(e -> showCariMobil());

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

        JLabel judul = new JLabel("Tambah Rental");
        judul.setFont(new Font("arial", Font.BOLD, 20));
        judul.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(judul, BorderLayout.CENTER);

        titlePanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        add(titlePanel, BorderLayout.NORTH);
    }

    private void createFormPanel(JPanel formPanel) {
        JLabel labelNama = new JLabel("Nama Penyewa");
        namaField = new JTextField();

        JLabel labelAlamat = new JLabel("Alamat Penyewa");
        alamatField = new JTextField();

        JLabel labelLamaSewa = new JLabel("Lama Sewa (hari)");
        lamaSewaField = new JTextField();

        JLabel labelTypeMobil = new JLabel("Type Mobil");
        labelTipeMobil = new JTextField();

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> createRent());

        labelNama.setBounds(275, 70, 100, 20);
        namaField.setBounds(275, 90, 450, 30);

        labelAlamat.setBounds(275, 130, 100, 20);
        alamatField.setBounds(275, 150, 450, 30);

        labelLamaSewa.setBounds(275, 190, 100, 20);
        lamaSewaField.setBounds(275, 210, 450, 30);

        labelTypeMobil.setBounds(275, 250, 100, 20);
        labelTipeMobil.setBounds(275, 270, 450, 30);

        submitButton.setBounds(275, 320, 100, 30);

        formPanel.add(labelNama);
        formPanel.add(namaField);
        formPanel.add(labelAlamat);
        formPanel.add(alamatField);
        formPanel.add(labelLamaSewa);
        formPanel.add(lamaSewaField);
        formPanel.add(labelTypeMobil);
        formPanel.add(labelTipeMobil);
        formPanel.add(submitButton);
    }

    private void createRent() {
        String namaPenyewa = namaField.getText();
        String alamatPenyewa = alamatField.getText();
        int lamaSewa = Integer.parseInt(lamaSewaField.getText());
        String typeMobil = labelTipeMobil.getText();

        boolean success = rentalController.createRent(namaPenyewa, alamatPenyewa, lamaSewa, typeMobil);

        if (success) {
            JOptionPane.showMessageDialog(this, "Berhasil membuat penyewaan.", "Success", JOptionPane.INFORMATION_MESSAGE);
            namaField.setText("");
            alamatField.setText("");
            lamaSewaField.setText("");
            lamaSewaField.setText("");

        } else {
            JOptionPane.showMessageDialog(this, "Gagal membuat penyewaan. Pengguna sudah ada atau mobil tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
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

    private void showCariMobil() {
        dispose();
        CariMobil cariMobil = new CariMobil();
        cariMobil.setVisible(true);
    }
    private void showHome(){
        dispose();
        UserMenu userMenu = new UserMenu();
        userMenu.setVisible(true);
    }

}
