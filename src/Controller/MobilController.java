package Controller;

import Model.MobilModel;
import Entity.MobilEntity;


import java.util.ArrayList;

public class MobilController {
    private MobilModel mobilModel = new MobilModel();


        public boolean createCar(String typeMobil,String platNomor,long hargaSewa) {
            boolean cek = false;
            try {
                if (findMobilByPlatNomor(platNomor) == null) {
                    mobilModel.create(typeMobil, platNomor, hargaSewa);
                    cek = true;
                }
            } catch (Exception e) {
                System.out.println( e.getMessage());
            }
            return cek;
        }
        public ArrayList<MobilEntity> readAll() {
            return mobilModel.readAllMobil();
        }

        public ArrayList<MobilEntity> readCarsByType(String typeMobil) {
            return mobilModel.readBySeachType(typeMobil);
        }

        public void delete(String platNomor) {
            try {
                if (findMobilByPlatNomor(platNomor) != null) {
                    mobilModel.delete(platNomor);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        private MobilEntity findMobilByPlatNomor(String platNomor) {
            for (MobilEntity mobil : mobilModel.readAllMobil()) {
                if (platNomor.equals(mobil.getPlatNomor())) {
                    return mobil;
                }
            }
            return null;
        }
    }
