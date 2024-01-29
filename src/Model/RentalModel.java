package Model;

import Database.Database;
import Entity.MobilEntity;
import Entity.RentEntity;

import java.util.ArrayList;

public class RentalModel extends MobilModel {
    public void create(String namaPenyewa, String alamatPenyewa, int lamaSewa, String typeMobil) {
        float totalHargaSewa,hargaSewa;
        ArrayList<MobilEntity> mobilList = readBySeachType(typeMobil);
        if (mobilList != null && !mobilList.isEmpty()) {
            MobilEntity mobil = mobilList.get(0);
//        perhitungan total harga sewa
            hargaSewa = mobil.getHargaSewa();
            totalHargaSewa = lamaSewa * hargaSewa;

            RentEntity tambahRent = new RentEntity(namaPenyewa, alamatPenyewa, lamaSewa,totalHargaSewa, mobil);
            Database.rentEntities.add(tambahRent);
        }
    }
    public ArrayList<RentEntity> showAllRent(){
        return Database.rentEntities;
    }
}
