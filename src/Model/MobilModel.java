package Model;

import Database.Database;
import Entity.MobilEntity;

import java.util.ArrayList;

public class MobilModel {

    public void create(String typeMobil, String platNomor, long hargaSewa) {
        MobilEntity tambahMobil = new MobilEntity(typeMobil, platNomor, hargaSewa);

        Database.mobilEntities.add(tambahMobil);
    }

    public ArrayList<MobilEntity> readAllMobil(){
        return Database.mobilEntities;
    }

    public ArrayList<MobilEntity> readBySeachType(String typeMobil) {
        ArrayList<MobilEntity> SearchMobil = new ArrayList<>();
        for (MobilEntity mobil : Database.mobilEntities) {
            if (typeMobil.equals(mobil.getTypeMobil())) {
                SearchMobil.add(mobil);
            }
        }
        return SearchMobil;
    }

    public void delete(String platNomor) {
        Database.mobilEntities.removeIf(mobil -> platNomor.equals(mobil.getPlatNomor()));
    }
}
