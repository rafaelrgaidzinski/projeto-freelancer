package com.example.freelancer.repositories;

import com.example.freelancer.models.OfertaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OfertaRepository extends JpaRepository<OfertaModel, UUID> {
}
