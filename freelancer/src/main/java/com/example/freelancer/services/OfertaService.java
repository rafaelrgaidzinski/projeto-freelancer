package com.example.freelancer.services;

import com.example.freelancer.models.OfertaModel;
import com.example.freelancer.repositories.OfertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OfertaService {

    @Autowired
    OfertaRepository ofertaRepository;

    @Transactional
    public OfertaModel save(OfertaModel ofertaModel) {
        return ofertaRepository.save(ofertaModel);
    }

    @Transactional
    public void delete(OfertaModel ofertaModel) {
        ofertaRepository.delete(ofertaModel);
    }

    public Optional<OfertaModel> findById(UUID id) {
        return ofertaRepository.findById(id);
    }

    public List<OfertaModel> findAll() {
        return ofertaRepository.findAll();
    }
}
