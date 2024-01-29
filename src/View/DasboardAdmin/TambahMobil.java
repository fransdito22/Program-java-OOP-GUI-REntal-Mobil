package View.DasboardAdmin;

import Controller.MobilController;
import View.LoginPage.LoginPage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TambahMobil extends JFrame  {

    private final MobilController mobilController = new MobilController();
    private JPanel formPanel;

    private JTextField fieldTypeMobil, fieldPlatNomor, fieldHargaSewa;

    public TambahMobil() {
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
        formPanel = new JPanel(null);
        createFormPanel();
        add(formPanel, BorderLayout.CENTER);
    }

    private void createUI() {
        setVisible(true);
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

        JLabel judul = new JLabel("Tambah Mobil");
        judul.setFont(new Font("arial", Font.BOLD, 20));
        judul.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(judul, BorderLayout.CENTER);

        titlePanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        getContentPane().add(titlePanel, BorderLayout.NORTH);
    }

    private void createFormPanel() {
        JLabel labelTypeMobil = new JLabel("Type Mobil");
        fieldTypeMobil = new JTextField();

        JLabel labelPlatNomor = new JLabel("Plat Nomor");
        fieldPlatNomor = new JTextField();

        JLabel labelHargaSewa = new JLabel("Harga Sewa");
        fieldHargaSewa = new JTextField();

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> submitData());


//        mengatur posisi dan lebar

        labelTypeMobil.setBounds(275, 70, 100, 20);
        fieldTypeMobil.setBounds(275, 90, 450, 30);

        labelPlatNomor.setBounds(275, 130, 100, 20);
        fieldPlatNomor.setBounds(275, 150, 450, 30);

        labelHargaSewa.setBounds(275, 190, 100, 20);
        fieldHargaSewa.setBounds(275, 210, 450, 30);

        submitButton.setBounds(275, 260, 100, 30);


        formPanel.add(labelTypeMobil);
        formPanel.add(fieldTypeMobil);
        formPanel.add(labelPlatNomor);
        formPanel.add(fieldPlatNomor);
        formPanel.add(labelHargaSewa);
        formPanel.add(fieldHargaSewa);
        formPanel.add(submitButton);
    }

    private void submitData() {
        try {
            String typeMobil = fieldTypeMobil.getText();
            String platNomor = fieldPlatNomor.getText();
            long hargaSewa = Long.parseLong(fieldHargaSewa.getText());
            if (mobilController.createCar(typeMobil, platNomor, hargaSewa)) {
            JOptionPane.showMessageDialog(this,"Berhasil ditambahkan", "Succes",JOptionPane.INFORMATION_MESSAGE);
                fieldTypeMobil.setText("");
                fieldPlatNomor.setText("");
                fieldHargaSewa.setText("");
            }else {
                JOptionPane.showMessageDialog(this,"Mobil dengan nomor " + platNomor +" sudah ada","Error",JOptionPane.ERROR_MESSAGE);
            }
            setVisible(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Harga Sewa harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
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
