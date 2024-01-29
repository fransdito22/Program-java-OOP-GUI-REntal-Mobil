package Entity;

public abstract class Mobil {
    private String typeMobil,platNomor;

    public Mobil(String typeMobil, String platNomor) {
        this.typeMobil = typeMobil;
        this.platNomor = platNomor;
    }
    public String getTypeMobil() {
        return typeMobil;
    }

    public String getPlatNomor() {
        return platNomor;
    }
}
