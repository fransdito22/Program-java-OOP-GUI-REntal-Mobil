package Controller;


import Model.LoginModel;

import static Model.LoginModel.validasiAdminLogin;
import static Model.LoginModel.validasiUserLogin;

public class LoginController {
    LoginModel loginModel = new LoginModel();

    // Metode untuk mengecek login menggunakan parameter langsung
    public static boolean validasiLogin(String username, String password, String userType) {
        return switch (userType) {
            case "ADMIN" -> validasiAdminLogin(username, password);
            case "USER" -> validasiUserLogin(username, password);
            default -> false;
        };
    }
    public void dummyAdmin(String nama,String password){
        loginModel.createDummyAdmin(nama,password);
    }
    public void dummyUser(String nama,String password){
        loginModel.createDummyUser(nama,password);
    }

}
