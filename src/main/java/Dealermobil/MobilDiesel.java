package Dealermobil;

public class MobilDiesel extends Mobil{
    private final int kapasitasTangki;

    public MobilDiesel(String id, String merek, String model, int harga, int tahunProduksi, int kapasitasTangki) {
        super(id, merek, model, harga, tahunProduksi);
        this.kapasitasTangki = kapasitasTangki;
    }

    public int getKapasitasTangki() {
        return kapasitasTangki;
    }

    @Override
    public void tampilkanInformasi() {
        System.out.println("=============================");
        System.out.println("        Mobil Diesel         ");
        System.out.println("=============================");
        System.out.println("ID Mobil: " + getId());
        System.out.println("Merek Mobil: " + getMerek());
        System.out.println("Model Mobil: " + getModel());
        System.out.println("Tahun Produksi: " + getTahunProduksi());
        System.out.println("Harga Mobil: " + getHarga());
        System.out.println("Mesin Mobil Sport: " + getKapasitasTangki());
        System.out.println("=============================");
        System.out.println();
    }
}
