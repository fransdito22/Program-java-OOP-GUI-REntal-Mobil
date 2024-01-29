package Controller;

import Entity.MobilEntity;
import Model.MobilModel;
import Model.RentalModel;
import Entity.RentEntity;

import java.util.ArrayList;

public class RentalController {
    private RentalModel modelRental = new RentalModel();
    private MobilModel mobilModel = new MobilModel();


    public boolean createRent(String namaPenyewa, String alamatPenyewa, int lamaSewa, String typeMobil) {
        boolean cek = false;
        try {
            if (findMobilByType(typeMobil)) {
                if (findUserByNamaPenyewa(namaPenyewa) == null) {
                    modelRental.create(namaPenyewa, alamatPenyewa, lamaSewa, typeMobil);
                    cek = true;
                }
            }
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
        return cek;
    }

    public ArrayList<RentEntity> showAllRent() {
        return modelRental.showAllRent();
    }

    public RentEntity findUserByNamaPenyewa(String namaPenyewa) {
        for (RentEntity user : modelRental.showAllRent()) {
            if (namaPenyewa.equals(user.getNamaPenyewa())) {
                return user;
            }
        }
        return null;
    }
    private boolean findMobilByType(String type) {
        boolean cek = false;
        for (MobilEntity mobil : mobilModel.readAllMobil()) {
            if (type.equals(mobil.getTypeMobil())) {
                cek = true;
            }
        }
        return cek;
    }
}
