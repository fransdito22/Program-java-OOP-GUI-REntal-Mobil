package Model;

import Entity.AdminEntity;
import Entity.PenyewaEntity;

import static Database.Database.adminEntities;
import static Database.Database.userEntities;

public class LoginModel {

    public void createDummyAdmin(String nama, String password) {
        AdminEntity adminEntity = new AdminEntity(nama,password);

        adminEntities.add(adminEntity);
    }
    public void createDummyUser(String nama,String password){
        PenyewaEntity penyewaEntity = new PenyewaEntity(nama, password);

        userEntities.add(penyewaEntity);
    }

    // Metode untuk validasi login admin
    public static boolean validasiAdminLogin(String username, String password) {
        for (AdminEntity admin : adminEntities) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Metode untuk validasi login user
    public static boolean validasiUserLogin(String username, String password) {
        for (PenyewaEntity user : userEntities) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
