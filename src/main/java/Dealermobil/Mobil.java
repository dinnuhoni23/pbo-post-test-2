package Dealermobil;

abstract class Mobil {
    private final String id;
    private final String merek;
    private final String model;
    private final int harga;
    private final int tahunProduksi;

    public Mobil(String id, String merek, String model, int harga, int tahunProduksi) {
        this.id = id;
        this.merek = merek;
        this.model = model;
        this.harga = harga;
        this.tahunProduksi = tahunProduksi;
    }

    public final String getId() {
        return id;
    }

    public final String getMerek() {
        return merek;
    }

    public final String getModel() {
        return model;
    }

    public final int getHarga() {
        return harga;
    }

    public final int getTahunProduksi() {
        return tahunProduksi;
    }

    public abstract void tampilkanInformasi();
}
