package Entity;

public class RentEntity extends Penyewa{
    private int lamaSewa;
    private float totalHargaSewa;
    private MobilEntity mobil;

    public RentEntity(String namaPenyewa, String alamatPenyewa, int lamaSewa, float totalHargaSewa, MobilEntity mobil) {
       super(namaPenyewa,alamatPenyewa);
        this.lamaSewa = lamaSewa;
        this.totalHargaSewa = totalHargaSewa;
        this.mobil = mobil;
    }



    public int getLamaSewa() {
        return lamaSewa;
    }

    public float getTotalHargaSewa() {
        return totalHargaSewa;
    }

    public MobilEntity getMobil() {
        return mobil;
    }
}
