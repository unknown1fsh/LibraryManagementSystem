import java.util.List;

public class Kitap {
    private String ad;
    private String yazar;
    private boolean oduncAlindiMi;

    public Kitap(String ad, String yazar) {
        this.ad = ad;
        this.yazar = yazar;
        this.oduncAlindiMi = false;
    }

    public String getAd() {
        return ad;
    }

    public String getYazar() {
        return yazar;
    }

    public boolean isOduncAlindiMi() {
        return oduncAlindiMi;
    }

    public void setOduncAlindiMi(boolean oduncAlindiMi) {
        this.oduncAlindiMi = oduncAlindiMi;
    }
}
