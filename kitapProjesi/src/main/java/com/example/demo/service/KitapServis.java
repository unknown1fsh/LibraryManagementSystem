package com.example.demo.service;

import com.example.demo.model.Kitap;
import com.example.demo.repository.KitapRepository;

import java.util.List;
import java.util.Optional;

public class KitapServis {
    private KitapRepository kitapRepository = new KitapRepository();

    public List<Kitap> tumKitaplariGetir() {
        return kitapRepository.tumKitaplariGetir();
    }

    public void kitapEkle(Kitap kitap) {
        kitapRepository.kitapEkle(kitap);
    }

    public Optional<Kitap> kitapGetir(Long id) {
        return kitapRepository.kitapGetir(id);
    }

    public void kitapSil(Long id) {
        kitapRepository.kitapSil(id);
    }
}
