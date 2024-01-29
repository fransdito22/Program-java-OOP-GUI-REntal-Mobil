package View.DasboardUser;

import View.LoginPage.LoginPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UserMenu extends JFrame {
    JLabel labelFoto, labelJudul, subJudul, labelTambahRental, labelListRental, labelCariMobil;
    JButton buttonTambahRental, buttonListMobil, buttonCariMobil;

    Font font;

    public UserMenu() {
        setTitle("frnssRent");
        setSize(1024, 576);
        setLayout(null);
        buttonTambahRental();
        buttonListMobil();
        buttonCariMobil();
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
        labelJudul = new JLabel("Rental Menu");
        font = new Font("arial", Font.ITALIC, 40);
        labelJudul.setFont(font);
        labelJudul.setBounds(400,40,504,50);

        subJudul = new JLabel("masukkan pilihan anda!");
        font = new Font("calibri", NORMAL, 20);
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

    private void buttonTambahRental() {
        labelTambahRental = new JLabel("Sewa Mobil");
        font = new Font("calibri", Font.BOLD, 18);
        labelTambahRental.setFont(font);
        labelTambahRental.setBounds(220,275,150,50);
        Color color = new Color(240, 102, 102);
        labelTambahRental.setForeground(color);

        buttonTambahRental = new JButton();
        buttonTambahRental.setBounds(220, 180, 100,100 );
        ImageIcon icon = new ImageIcon("img/create.png");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        buttonTambahRental.setIcon(icon);
        buttonTambahRental.setContentAreaFilled(false);
        buttonTambahRental.addActionListener(e -> showTambahRental());
        add(buttonTambahRental);
        add(labelTambahRental);
    }

    private void buttonListMobil() {
        labelListRental = new JLabel("List Mobil");
        font = new Font("calibri", Font.BOLD, 18);
        labelListRental.setFont(font);
        labelListRental.setBounds(460,275,200,50);
        Color color = new Color(240, 102, 102);
        labelListRental.setForeground(color);

        buttonListMobil = new JButton();
        buttonListMobil.setBounds(450, 180, 100,100 );
        ImageIcon icon = new ImageIcon("img/carList.png");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        buttonListMobil.setIcon(icon);
        buttonListMobil.setContentAreaFilled(false);
        buttonListMobil.addActionListener(e -> showAllRental());
        add(buttonListMobil);
        add(labelListRental);
    }

    private void buttonCariMobil() {
        labelCariMobil = new JLabel("Cari Mobil");
        font = new Font("calibri", Font.BOLD, 18);
        labelCariMobil.setFont(font);
        labelCariMobil.setBounds(660,275,150,50);
        Color color = new Color(240, 102, 102);
        labelCariMobil.setForeground(color);

        buttonCariMobil = new JButton();
        buttonCariMobil.setBounds(660, 180, 100,100 );
        ImageIcon icon = new ImageIcon("img/delete.png");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        buttonCariMobil.setIcon(icon);
        buttonCariMobil.setContentAreaFilled(false);
        buttonCariMobil.addActionListener(e -> showSearchMobil());
        add(buttonCariMobil);
        add(labelCariMobil);
    }

    private void showAllRental() {
        dispose();
        TampilkanRental tampilkanRental = new TampilkanRental();
        tampilkanRental.setVisible(true);
    }

    private void showTambahRental() {
        dispose();
        TambahRental labelTambahRental = new TambahRental();
        labelTambahRental.setVisible(true);
    }
    private void showSearchMobil(){
        dispose();
        CariMobil labelCariMobil = new CariMobil();
        labelCariMobil.setVisible(true);
    }
}
