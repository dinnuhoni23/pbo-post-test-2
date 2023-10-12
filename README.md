# Dokumentasi Post Test 2 Pemrograman Berorietasi Objek
## **Nama** : Dinnuhoni Trahutomo
## **Nim**  : 2209116006

### 1. Source Code
#### Main.java
```java
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
```

#### Dealermobil.java
```java
package Dealermobil;

import java.util.ArrayList;

public final class Dealermobil {
    private static final ArrayList<Mobil> mobils = new ArrayList<>();

    public static void addMobil(MobilBensin mobil) {
        mobils.add(mobil);
    }

    public static void addMobil(MobilDiesel mobil) {
        mobils.add(mobil);
    }

    public static void tampilkanMobil() {
        for (Mobil mobil : mobils) {
            mobil.tampilkanInformasi();
        }
    }

    public static void updateMobil(int indeks, MobilBensin mobilBaru) {
        if (indeks >= 0 && indeks < mobils.size()) {
            if (mobils.get(indeks) instanceof MobilBensin) {
                mobils.set(indeks, mobilBaru);
            } else {
                System.out.println("Mobil yang dipilih bukan mobil bensin.");
            }
        } else {
            System.out.println("Indeks mobil tidak valid.");
        }
    }

    public static void updateMobil(int indeks, MobilDiesel mobilBaru) {
        if (indeks >= 0 && indeks < mobils.size()) {
            if (mobils.get(indeks) instanceof MobilDiesel) {
                mobils.set(indeks, mobilBaru);
            } else {
                System.out.println("Mobil yang dipilih bukan mobil diesel.");
                System.out.println("Gagal mengupdate mobil.");
            }
        } else {
            System.out.println("Indeks mobil tidak valid.");
        }
    }

    public static void hapusMobil(int indeks) {
        if (indeks >= 0 && indeks < mobils.size()) {
            mobils.remove(indeks);
        } else {
            System.out.println("Indeks mobil tidak valid.");
        }
    }

    public static int cariMobil(String idDelete) {
        for (int i = 0; i < mobils.size(); i++) {
            if (mobils.get(i).getId().equals(idDelete)) {
                return i;
            }
        }

        return -1;
    }
}
```

#### Mobil.java
```java
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
```

#### MobilBensin.java
```java
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
```
#### MobilDiesel.java
```java
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
```

### 2. Penjelasan

#### 1. Main.java
Class Main.java berfungsi sebagai class utama yang akan dijalankan pertama kali. Class ini berfungsi untuk menampilkan menu dan menerima input dari user. Input yang diterima akan diproses sesuai dengan pilihan yang dipilih oleh user.

Terdapat 5 pilihan menu yang dapat dipilih oleh user, yaitu:
1. Tambah Mobil
2. Tampilkan Mobil
3. Update Mobil
4. Delete Mobil
5. Keluar

##### 1.1. Tambah Mobil
Pada pilihan ini, user akan diminta untuk memilih jenis mobil yang ingin ditambahkan. Terdapat 2 jenis mobil yang dapat ditambahkan, yaitu Mobil Diesel dan Mobil Bensin. Setelah memilih jenis mobil, user akan diminta untuk memasukkan informasi mobil yang ingin ditambahkan. Informasi yang diminta adalah ID Mobil, Merek Mobil, Model Mobil, Harga Mobil, dan Tahun Produksi Mobil. Setelah itu, user akan diminta untuk memasukkan informasi tambahan sesuai dengan jenis mobil yang dipilih. Jika user memilih Mobil Diesel, maka user akan diminta untuk memasukkan Kapasitas Tangki. Jika user memilih Mobil Bensin, maka user akan diminta untuk memasukkan Kapasitas Mesin. Setelah semua informasi dimasukkan, mobil akan ditambahkan ke dalam list mobil.

##### 1.2. Tampilkan Mobil
Pada pilihan ini, semua mobil yang ada di dalam list mobil akan ditampilkan.

##### 1.3. Update Mobil
Pada pilihan ini, user akan diminta untuk memasukkan ID Mobil yang ingin diupdate. Setelah itu, user akan diminta untuk memasukkan informasi mobil yang ingin diupdate. Informasi yang diminta adalah ID Mobil, Merek Mobil, Model Mobil, Harga Mobil, dan Tahun Produksi Mobil. Setelah itu, user akan diminta untuk memasukkan informasi tambahan sesuai dengan jenis mobil yang dipilih. Jika user memilih Mobil Diesel, maka user akan diminta untuk memasukkan Kapasitas Tangki. Jika user memilih Mobil Bensin, maka user akan diminta untuk memasukkan Kapasitas Mesin. Setelah semua informasi dimasukkan, mobil akan diupdate.

##### 1.4. Delete Mobil
Pada pilihan ini, user akan diminta untuk memasukkan ID Mobil yang ingin dihapus. Setelah itu, mobil akan dihapus dari list mobil.

##### 1.5. Keluar
Pada pilihan ini, program akan berhenti.

#### 2. Dealermobil.java
Class Dealermobil.java berfungsi untuk mengelola list mobil. Class ini memiliki beberapa method, yaitu:

##### 2.1. addMobil
Method ini berfungsi untuk menambahkan mobil ke dalam list mobil.

##### 2.2. tampilkanMobil
Method ini berfungsi untuk menampilkan semua mobil yang ada di dalam list mobil.

##### 2.3. updateMobil
Method ini berfungsi untuk mengupdate mobil yang ada di dalam list mobil. Method ini memiliki 2 versi, yaitu untuk mobil diesel dan mobil bensin.

##### 2.4. hapusMobil
Method ini berfungsi untuk menghapus mobil yang ada di dalam list mobil.


##### 2.5. cariMobil
Method ini berfungsi untuk mencari mobil yang ada di dalam list mobil. Method ini akan mengembalikan indeks dari mobil yang dicari. Jika mobil tidak ditemukan, maka method ini akan mengembalikan nilai -1.


#### 3. Mobil.java
Class Mobil.java merupakan class abstract yang berfungsi sebagai parent class dari class MobilBensin dan MobilDiesel. Class ini memiliki beberapa atribut, yaitu:
1. id
2. merek
3. model
4. harga
5. tahunProduksi

Class ini juga memiliki beberapa method, yaitu:
1. getId
2. getMerek
3. getModel
4. getHarga

#### 4. MobilBensin.java
Class MobilBensin.java merupakan child class dari class Mobil.java. Class ini memiliki beberapa atribut, yaitu:
1. kapasitasMesin

Class ini juga memiliki beberapa method, yaitu:
1. getKapasitasMesin
2. tampilkanInformasi

#### 5. MobilDiesel.java
Class MobilDiesel.java merupakan child class dari class Mobil.java. Class ini memiliki beberapa atribut, yaitu:
1. kapasitasTangki

Class ini juga memiliki beberapa method, yaitu:

1. getKapasitasTangki
2. tampilkanInformasi

### 3. Screenshot Output
#### Tampilan Awal

![image](https://github.com/dinnuhoni23/pbo-post-test-2/assets/122195566/1b1f1045-36d0-42c6-96b0-651339976bf9)


Pada tampilan awal, user akan diminta untuk memilih menu yang tersedia. Terdapat 5 menu yang dapat dipilih, yaitu:
1. Tambah Mobil
2. Tampilkan Mobil
3. Update Mobil
4. Delete Mobil
5. Keluar

#### Tambah Mobil

![image](https://github.com/dinnuhoni23/pbo-post-test-2/assets/122195566/d7597b6a-4a12-47fc-8235-5c38100c898d)


Pada menu ini, user akan diminta untuk memilih jenis mobil yang ingin ditambahkan. Terdapat 2 jenis mobil yang dapat ditambahkan, yaitu Mobil Diesel dan Mobil Bensin. Setelah memilih jenis mobil, user akan diminta untuk memasukkan informasi mobil yang ingin ditambahkan. Informasi yang diminta adalah ID Mobil, Merek Mobil, Model Mobil, Harga Mobil, dan Tahun Produksi Mobil. Setelah itu, user akan diminta untuk memasukkan informasi tambahan sesuai dengan jenis mobil yang dipilih. Jika user memilih Mobil Diesel, maka user akan diminta untuk memasukkan Kapasitas Tangki. Jika user memilih Mobil Bensin, maka user akan diminta untuk memasukkan Kapasitas Mesin. Setelah semua informasi dimasukkan, mobil akan ditambahkan ke dalam list mobil.

#### Tampilkan Mobil

![image](https://github.com/dinnuhoni23/pbo-post-test-2/assets/122195566/98102fc1-7ddb-434a-9541-3fa7003f0e4e)


Pada menu ini, semua mobil yang ada di dalam list mobil akan ditampilkan.

#### Update Mobil

![image](https://github.com/dinnuhoni23/pbo-post-test-2/assets/122195566/d0895ce7-5896-42f8-8019-0e13f2b80d84)

![image](https://github.com/dinnuhoni23/pbo-post-test-2/assets/122195566/1c1573ab-ce56-4e2b-bffe-a78eb6c5df20)


Pada menu ini, user akan diminta untuk memasukkan ID Mobil yang ingin diupdate. Setelah itu, user akan diminta untuk memasukkan informasi mobil yang ingin diupdate. Informasi yang diminta adalah ID Mobil, Merek Mobil, Model Mobil, Harga Mobil, dan Tahun Produksi Mobil. Setelah itu, user akan diminta untuk memasukkan informasi tambahan sesuai dengan jenis mobil yang dipilih. Jika user memilih Mobil Diesel, maka user akan diminta untuk memasukkan Kapasitas Tangki. Jika user memilih Mobil Bensin, maka user akan diminta untuk memasukkan Kapasitas Mesin. Setelah semua informasi dimasukkan, mobil akan diupdate.

#### Delete Mobil

![image](https://github.com/dinnuhoni23/pbo-post-test-2/assets/122195566/cd096f33-5cce-40e3-a6d2-a682e197120c)


Pada menu ini, user akan diminta untuk memasukkan ID Mobil yang ingin dihapus. Setelah itu, mobil akan dihapus dari list mobil.

#### Keluar

Langsung keluar dari program.
