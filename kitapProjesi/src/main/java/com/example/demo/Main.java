package com.example.demo;

import com.example.demo.model.Kitap;
import com.example.demo.service.KitapServis;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static KitapServis kitapServis = new KitapServis();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Tüm Kitapları Listele");
            System.out.println("3. Kitap Getir");
            System.out.println("4. Kitap Sil");
            System.out.println("5. Çıkış");

            int secim = scanner.nextInt();
            scanner.nextLine(); // newline karakterini temizle

            switch (secim) {
                case 1:
                    kitapEkle();
                    break;
                case 2:
                    tumKitaplariListele();
                    break;
                case 3:
                    kitapGetir();
                    break;
                case 4:
                    kitapSil();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Geçersiz seçim, tekrar deneyin.");
            }
        }
    }

    private static void kitapEkle() {
        System.out.print("Kitap ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // newline karakterini temizle
        System.out.print("Kitap İsmi: ");
        String isim = scanner.nextLine();
        System.out.print("Yazar: ");
        String yazar = scanner.nextLine();
        Kitap kitap = new Kitap(id, isim, yazar);
        kitapServis.kitapEkle(kitap);
        System.out.println("Kitap eklendi.");
    }

    private static void tumKitaplariListele() {
        List<Kitap> kitaplar = kitapServis.tumKitaplariGetir();
        kitaplar.forEach(System.out::println);
    }

    private static void kitapGetir() {
        System.out.print("Kitap ID: ");
        Long id = scanner.nextLong();
        Optional<Kitap> kitap = kitapServis.kitapGetir(id);
        kitap.ifPresentOrElse(System.out::println, () -> System.out.println("Kitap bulunamadı."));
    }

    private static void kitapSil() {
        System.out.print("Kitap ID: ");
        Long id = scanner.nextLong();
        kitapServis.kitapSil(id);
        System.out.println("Kitap silindi.");
    }
}
