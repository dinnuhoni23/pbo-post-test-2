package main;

import java.util.Scanner;

import Dealermobil.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pilihan;
        do {
            System.out.println("+=======================+");
            System.out.println("| Dealer Mobil Jaya     |");
            System.out.println("+=======================+");
            System.out.println("| |> 1. Tambah Mobil    |");
            System.out.println("| |> 2. Tampilkan Mobil |");
            System.out.println("| |> 3. Update Mobil    |");
            System.out.println("| |> 4. Delete Mobil    |");
            System.out.println("| |> 5. Keluar          |");
            System.out.println("+=======================+");
            System.out.print("Pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\nTambah Mobil:");
                    System.out.println("1. Mobil Diesel");
                    System.out.println("2. Mobil Bensin");
                    System.out.print("Pilihan: ");
                    int pilihanMobil = scanner.nextInt();
                    scanner.nextLine();
                    if (pilihanMobil == 1 || pilihanMobil == 2) {
                        System.out.print("> ID Mobil: ");
                        String idMobil = scanner.nextLine().toUpperCase();
                        System.out.print("> Merek Mobil: ");
                        String namaMobil = scanner.nextLine().toUpperCase();
                        System.out.print("> Model Mobil: ");
                        String modelMobil = scanner.nextLine().toUpperCase();
                        System.out.print("> Harga Mobil: ");
                        int hargaMobil = scanner.nextInt();
                        System.out.print("> Tahun Produksi Mobil: ");
                        int tahunProduksiMobil = scanner.nextInt();

                        if (pilihanMobil == 1) {
                            System.out.print("> Kapasitas Tangki: ");
                            int kapasitasTangki = scanner.nextInt();
                            MobilDiesel mobilDiesel = new MobilDiesel(idMobil, namaMobil, modelMobil, hargaMobil, tahunProduksiMobil, kapasitasTangki);
                            Dealermobil.addMobil(mobilDiesel);
                        } else if (pilihanMobil == 2) {
                            System.out.print("> Kapasitas Mesin: ");
                            int kapasitasMesin = scanner.nextInt();
                            MobilBensin mobilBiasa = new MobilBensin(idMobil, namaMobil, modelMobil, hargaMobil, tahunProduksiMobil, kapasitasMesin);
                            Dealermobil.addMobil(mobilBiasa);
                        }

                        System.out.println("Mobil telah ditambahkan.");
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                    break;
                case 2:
                    System.out.println("\nDaftar Mobil:");
                    Dealermobil.tampilkanMobil();
                    break;
                case 3:
                    System.out.println("\nUpdate Mobil:");
                    System.out.print("> Masukkan ID mobil yang ingin diupdate: ");
                    String idUpdate = scanner.nextLine().toUpperCase();
                    int indeksUpdate = Dealermobil.cariMobil(idUpdate);
                    if (indeksUpdate != -1) {
                        System.out.println("1. Update Mobil Diesel");
                        System.out.println("2. Update Mobil Bensin");
                        System.out.print("> Pilihan: ");
                        int pilihanUpdate = scanner.nextInt();
                        scanner.nextLine();
                        if (pilihanUpdate == 1 || pilihanUpdate == 2) {
                            System.out.print("> Merek Mobil: ");
                            String namaMobil = scanner.nextLine().toUpperCase();
                            System.out.print("> Model Mobil: ");
                            String modelMobil = scanner.nextLine().toUpperCase();
                            System.out.print("> Harga Mobil: ");
                            int hargaMobil = scanner.nextInt();
                            System.out.print("> Tahun Produksi Mobil: ");
                            int tahunProduksiMobil = scanner.nextInt();

                            if (pilihanUpdate == 1) {
                                System.out.print("> Kapasitas Tangki: ");
                                int kapasitasTangki = scanner.nextInt();
                                MobilDiesel mobilDiesel = new MobilDiesel(idUpdate, namaMobil, modelMobil, hargaMobil, tahunProduksiMobil, kapasitasTangki);
                                Dealermobil.updateMobil(indeksUpdate, mobilDiesel);
                                System.out.println("Mobil telah diupdate.");
                            } else if (pilihanUpdate == 2) {
                                System.out.print("> Kapasitas Mesin: ");
                                int kapasitasMesin = scanner.nextInt();
                                MobilBensin mobilBiasa = new MobilBensin(idUpdate, namaMobil, modelMobil, hargaMobil, tahunProduksiMobil, kapasitasMesin);
                                Dealermobil.updateMobil(indeksUpdate, mobilBiasa);
                                System.out.println("Mobil telah diupdate.");
                            }
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }
                    } else {
                        System.out.println("ID mobil tidak ditemukan.");
                    }
                    break;
                case 4:
                    System.out.println("\nDelete Mobil:");
                    System.out.print("> Masukkan ID mobil yang ingin dihapus: ");
                    String idDelete = scanner.nextLine().toUpperCase();
                    int indeksDelete = Dealermobil.cariMobil(idDelete);
                    if (indeksDelete != -1) {
                        Dealermobil.hapusMobil(indeksDelete);
                        System.out.println("Mobil telah dihapus.");
                    } else {
                        System.out.println("ID mobil tidak ditemukan.");
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
                    break;
            }
        } while (true);
    }
}
