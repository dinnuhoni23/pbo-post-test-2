package Dealermobil;

public class MobilBensin extends Mobil {
    private final int kapasitasMesin;

    public MobilBensin(String id, String merek, String model, int tahunProduksi, int harga, int kapasitasMesin) {
        super(id, merek, model, harga ,tahunProduksi);
        this.kapasitasMesin = kapasitasMesin;
    }

    public int getKapasitasMesin() {
        return kapasitasMesin;
    }

    @Override
    public void tampilkanInformasi() {
        System.out.println("=============================");
        System.out.println("        Mobil Bensin         ");
        System.out.println("=============================");
        System.out.println("ID Mobil: " + getId());
        System.out.println("Merek Mobil: " + getMerek());
        System.out.println("Model Mobil: " + getModel());
        System.out.println("Tahun Produksi: " + getTahunProduksi());
        System.out.println("Harga Mobil: " + getHarga());
        System.out.println("Kapasitas Mesin: " + getKapasitasMesin());
        System.out.println("=============================");
        System.out.println();
    }
}
