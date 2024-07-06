import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Kutuphane kutuphane = new Kutuphane();

        Kitap kitap1 = new Kitap("Sefiller", "Victor Hugo");
        Kitap kitap2 = new Kitap("Suç ve Ceza", "Fyodor Dostoyevski");
        Kitap kitap3 = new Kitap("Don Kişot", "Miguel de Cervantes");
        
        kutuphane.kitapEkle(kitap1);
        kutuphane.kitapEkle(kitap2);
        kutuphane.kitapEkle(kitap3);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Kütüphane Yönetim Sistemi");
            System.out.println("1. Kitapları Listele");
            System.out.println("2. Kitap Ödünç Al");
            System.out.println("3. Kitap Geri Ver");
            System.out.println("4. Çıkış");
            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    System.out.println("Kitaplar:");
                    for (Kitap kitap : kutuphane.getKitaplar()) {
                        String durum = kitap.isOduncAlindiMi() ? "Ödünç Alındı" : "Kütüphanede";
                        System.out.println("- " + kitap.getAd() + " | " + kitap.getYazar() + " | " + durum);
                    }
                    break;
                case 2:
                    System.out.print("Ödünç almak istediğiniz kitabın adı: ");
                    scanner.nextLine();
                    String oduncAlAd = scanner.nextLine();
                    kutuphane.kitapOduncAl(oduncAlAd);
                    break;
                case 3:
                    System.out.print("Geri vermek istediğiniz kitabın adı: ");
                    scanner.nextLine();
                    String geriVerAd = scanner.nextLine();
                    kutuphane.kitapGeriVer(geriVerAd);
                    break;
                case 4:
                    System.out.println("Çıkış yapılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim.");
            }
        }
    }
}