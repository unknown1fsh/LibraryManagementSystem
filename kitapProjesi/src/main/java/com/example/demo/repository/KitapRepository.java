package com.example.demo.repository;

import com.example.demo.model.Kitap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class KitapRepository {
    private List<Kitap> kitapListesi = new ArrayList<>();

    public List<Kitap> tumKitaplariGetir() {
        return kitapListesi;
    }

    public void kitapEkle(Kitap kitap) {
        kitapListesi.add(kitap);
    }

    public Optional<Kitap> kitapGetir(Long id) {
        return kitapListesi.stream().filter(k -> k.getId().equals(id)).findFirst();
    }

    public void kitapSil(Long id) {
        kitapListesi.removeIf(k -> k.getId().equals(id));
    }
}
