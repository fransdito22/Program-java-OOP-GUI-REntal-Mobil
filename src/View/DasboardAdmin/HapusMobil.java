package View.DasboardAdmin;

import Controller.MobilController;
import Entity.MobilEntity;
import View.LoginPage.LoginPage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

public class HapusMobil extends JFrame {
    private JTable carTable;
    JLabel  judul;
    private DefaultTableModel tableModel;

    public HapusMobil() {
        initializeUI();
        createMenu();
        judul();
        createTable();
        createDeleteButton();
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

        judul = new JLabel("Hapus Mobil");
        judul.setFont(new Font("arial", Font.BOLD, 20));
        judul.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(judul, BorderLayout.CENTER);

        titlePanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        getContentPane().add(titlePanel, BorderLayout.NORTH);
    }

    private void createTable() {
        judul = new JLabel("Hapus Mobil");
        judul.setFont(new Font("arial", Font.BOLD, 20));
        judul.setBounds(200, 20, 200, 50);

        tableModel = new DefaultTableModel();
        carTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(carTable);
        tableModel.addColumn("Type");
        tableModel.addColumn("Plat Nomor");
        tableModel.addColumn("Harga Sewa");

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }



    private void createDeleteButton() {
        JPanel deletePanel = new JPanel();
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> deleteCar());

        deletePanel.add(deleteButton);

        getContentPane().add(deletePanel, BorderLayout.SOUTH);
    }

    private void deleteCar() {
        int selectedRow = carTable.getSelectedRow();

        if (selectedRow != -1) {
            String platNomor = (String) tableModel.getValueAt(selectedRow, 1);
            MobilController tes = new MobilController();
            tes.delete(platNomor);
            tableModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this,"Mobil Telah Terhapus ","Succes", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Pilih Yang Ingin Dihapus", "Delete Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayCars() {
        MobilController mobilController = new MobilController();
        ArrayList<MobilEntity> allCars = mobilController.readAll();

        if (!allCars.isEmpty()) {
            for (MobilEntity car : allCars) {
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
