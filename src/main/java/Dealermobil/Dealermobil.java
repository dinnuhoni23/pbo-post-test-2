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
