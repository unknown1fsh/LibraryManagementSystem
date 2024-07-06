import java.util.ArrayList;
import java.util.List;

public class Kutuphane {
    private List<Kitap> kitaplar;

    public Kutuphane() {
        this.kitaplar = new ArrayList<>();
    }

    public void kitapEkle(Kitap kitap) {
        kitaplar.add(kitap);
    }

    public void kitapOduncAl(String ad) {
        for (Kitap kitap : kitaplar) {
            if (kitap.getAd().equals(ad) && !kitap.isOduncAlindiMi()) {
                kitap.setOduncAlindiMi(true);
                return;
            }
        }
        System.out.println("Kitap mevcut değil veya ödünç verilemez.");
    }

    public void kitapGeriVer(String ad) {
        for (Kitap kitap : kitaplar) {
            if (kitap.getAd().equals(ad) && kitap.isOduncAlindiMi()) {
                kitap.setOduncAlindiMi(false);
                return;
            }
        }
        System.out.println("Böyle bir kitap ödünç alınmamış.");
    }

    public List<Kitap> getKitaplar() {
        List<Kitap> mevcutKitaplar = new ArrayList<>();
        for (Kitap kitap : kitaplar) {
            if (!kitap.isOduncAlindiMi()) {
                mevcutKitaplar.add(kitap);
            }
        }
        return mevcutKitaplar;
    }
}
