package View.LoginPage;

import Controller.LoginController;
import View.DasboardAdmin.AdminMenu;
import View.DasboardUser.UserMenu;
import View.RunView;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame implements RunView {
    JLabel labelFoto, labelJudul, subJudul;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> userTypeComboBox;
    private JButton loginButton;
    LoginController loginController = new LoginController();

    public LoginPage() {
        setTitle("Login");
        setSize(1024, 576);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeComponents();
        loginForm();
        login();
        judul();

        dummyAccount();
    }

    private void initializeComponents() {
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        userTypeComboBox = new JComboBox<>(new String[]{"ADMIN", "USER"});
        loginButton = new JButton("Login");
    }

    private void judul() {
        labelJudul = new JLabel("frnssRENT");
        Font font = new Font("arial", Font.ITALIC, 40);
        labelJudul.setFont(font);
        labelJudul.setBounds(380,20,504,50);

        subJudul = new JLabel("masukkan pilihan anda!");
        font = new Font("calibri", Font.PLAIN, 20);
        subJudul.setFont(font);
        subJudul.setBounds(400,80,252,50);

        labelFoto = new JLabel();
        labelFoto.setBounds(512, 0, 576, 576);
        ImageIcon icon = new ImageIcon("img/Login.png");
        Image image = icon.getImage().getScaledInstance(576, 576, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        labelFoto.setIcon(icon);

        add(labelJudul);
        add(subJudul);
        add(labelFoto);
    }


    private void loginForm() {
        setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(275, 70, 100, 20);
        add(usernameLabel);
        usernameField.setBounds(275, 90, 450, 30);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(275, 130, 100, 20);
        add(passwordLabel);
        passwordField.setBounds(275, 150, 450, 30);
        add(passwordField);

        JLabel userTypeLabel = new JLabel("Login Sebagai:");
        userTypeLabel.setBounds(275, 190, 100, 20);
        add(userTypeLabel);
        userTypeComboBox.setBounds(275, 210, 450, 30);
        add(userTypeComboBox);

        loginButton.setBounds(275, 260, 100, 30);
        add(loginButton);
    }

    private void login() {
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);
            String userType = (String) userTypeComboBox.getSelectedItem();
            // Kirim data login ke controller untuk divalidasi
            boolean loginResult = LoginController.validasiLogin(username, password, userType);

            if (loginResult) {
                // Tampilkan pesan berhasil login
                JOptionPane.showMessageDialog(LoginPage.this, "Berhasil Login", "Success", JOptionPane.INFORMATION_MESSAGE);
                if (userType.equals("ADMIN")) {
                    new AdminMenu();
                    dispose();
                } else if (userType.equals("USER")) {
                    new UserMenu();
                    dispose();
                }
            } else {
                // Tampilkan pesan gagal login
                JOptionPane.showMessageDialog(LoginPage.this, "Login gagal,pastikan nama,password benar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    private void dummyAccount(){
        loginController.dummyAdmin("admin1","admin123");
        loginController.dummyAdmin("admin2","admin456");
        loginController.dummyAdmin("admin3","admin789");

        loginController.dummyUser("user1","user123");
        loginController.dummyUser("user2","user456");
        loginController.dummyUser("user2","user789");
    }
    @Override
    public void runView() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }
}
