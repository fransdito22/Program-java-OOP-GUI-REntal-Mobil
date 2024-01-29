package Database;

import Entity.AdminEntity;
import Entity.MobilEntity;
import Entity.RentEntity;
import Entity.PenyewaEntity;

import java.util.ArrayList;

public class Database {
    public static ArrayList<MobilEntity> mobilEntities = new ArrayList<>();
    public static ArrayList<RentEntity> rentEntities = new ArrayList<>();
    public static ArrayList<AdminEntity> adminEntities = new ArrayList<>();
    public static ArrayList<PenyewaEntity> userEntities = new ArrayList<>();
}