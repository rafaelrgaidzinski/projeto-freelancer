package com.example.freelancer.services;

import com.example.freelancer.models.EstabelecimentoModel;
import com.example.freelancer.repositories.EstabelecimentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EstabelecimentoService {

    @Autowired
    EstabelecimentoRepository estabelecimentoRepository;

    @Transactional
    public EstabelecimentoModel save(EstabelecimentoModel estabelecimentoModel) {
        return estabelecimentoRepository.save(estabelecimentoModel);
    }

    @Transactional
    public void delete(EstabelecimentoModel estabelecimentoModel) {
        estabelecimentoRepository.delete(estabelecimentoModel);
    }

    public Optional<EstabelecimentoModel> findById(UUID id) {
        return estabelecimentoRepository.findById(id);
    }

    public List<EstabelecimentoModel> findAll() {
        return estabelecimentoRepository.findAll();
    }
}
