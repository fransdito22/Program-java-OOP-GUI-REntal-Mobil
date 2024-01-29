package Entity;

public class MobilEntity extends Mobil{

    private long hargaSewa;

    public MobilEntity(String typeMobil, String platNomor, long hargaSewa) {
        super(typeMobil,platNomor);
        this.hargaSewa = hargaSewa;
    }


    public long getHargaSewa() {
        return hargaSewa;
    }
}
