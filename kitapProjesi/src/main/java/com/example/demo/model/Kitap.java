package com.example.demo.model;

public class Kitap {
    private Long id;
    private String isim;
    private String yazar;

    public Kitap(Long id, String isim, String yazar) {
        this.id = id;
        this.isim = isim;
        this.yazar = yazar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    @Override
    public String toString() {
        return "Kitap{" +
                "id=" + id +
                ", isim='" + isim + '\'' +
                ", yazar='" + yazar + '\'' +
                '}';
    }
}
