package Entity;

public abstract class Penyewa {
    private String namaPenyewa,alamatPenyewa;

    public Penyewa(String namaPenyewa, String alamatPenyewa) {
        this.namaPenyewa = namaPenyewa;
        this.alamatPenyewa = alamatPenyewa;
    }
    public String getNamaPenyewa() {
        return namaPenyewa;
    }

    public String getAlamatPenyewa() {
        return alamatPenyewa;
    }
}
