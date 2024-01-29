package View.DasboardAdmin;

import View.LoginPage.LoginPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdminMenu extends JFrame {
    JLabel labelFoto, labelJudul, subJudul, labelTambahMobil, labelListMobil, labelHapusMobil;
    JButton tambahMobil, listMobil, hapusMobil;

    Font font;

    public AdminMenu() {
        setTitle("frnssRent");
        setSize(1024, 576);
        setLayout(null);
        tambahMobil();
        listMobil();
        hapusMobil();
        labelJudul();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                dispose();
                new LoginPage().runView();
            }
        });
    }

    private void labelJudul() {
        labelJudul = new JLabel("Admin Menu");
        font = new Font("arial", Font.ITALIC, 40);
        labelJudul.setFont(font);
        labelJudul.setBounds(380,40,504,50);

        subJudul = new JLabel("masukkan pilihan anda!");
        font = new Font("calibri", Font.PLAIN, 20);
        subJudul.setFont(font);
        subJudul.setBounds(400,80,252,50);

        labelFoto = new JLabel();
        labelFoto.setBounds(512, 0, 576, 576);
        ImageIcon icon = new ImageIcon("img/bg.png");
        Image image = icon.getImage().getScaledInstance(576, 576, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        labelFoto.setIcon(icon);

        add(labelJudul);
        add(subJudul);
        add(labelFoto);
    }

    private void tambahMobil() {
        labelTambahMobil = new JLabel("Tambah Data");
        font = new Font("calibri", Font.BOLD, 18);
        labelTambahMobil.setFont(font);
        labelTambahMobil.setBounds(220,275,150,50);
        Color color = new Color(240, 102, 102);
        labelTambahMobil.setForeground(color);

        tambahMobil = new JButton();
        tambahMobil.setBounds(220, 180, 100,100 );
        ImageIcon icon = new ImageIcon("img/create.png");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        tambahMobil.setIcon(icon);
        tambahMobil.setContentAreaFilled(false);
        tambahMobil.addActionListener(e -> showTambahMobilForm());
        add(tambahMobil);
        add(labelTambahMobil);
    }

    private void listMobil() {
        labelListMobil = new JLabel("List Mobil");
        font = new Font("calibri", Font.BOLD, 18);
        labelListMobil.setFont(font);
        labelListMobil.setBounds(460,275,200,50);
        Color color = new Color(240, 102, 102);
        labelListMobil.setForeground(color);

        listMobil = new JButton();
        listMobil.setBounds(450, 180, 100,100 );
        ImageIcon icon = new ImageIcon("img/carList.png");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        listMobil.setIcon(icon);
        listMobil.setContentAreaFilled(false);
        listMobil.addActionListener(e -> showCarList());
        add(listMobil);
        add(labelListMobil);
    }

    private void hapusMobil() {
        labelHapusMobil = new JLabel("Hapus Mobil");
        font = new Font("calibri", Font.BOLD, 18);
        labelHapusMobil.setFont(font);
        labelHapusMobil.setBounds(660,275,150,50);
        Color color = new Color(240, 102, 102);
        labelHapusMobil.setForeground(color);

        hapusMobil = new JButton();
        hapusMobil.setBounds(660, 180, 100,100 );
        ImageIcon icon = new ImageIcon("img/delete.png");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        hapusMobil.setIcon(icon);
        hapusMobil.setContentAreaFilled(false);
        hapusMobil.addActionListener(e -> showDeleteMobil());
        add(hapusMobil);
        add(labelHapusMobil);
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
