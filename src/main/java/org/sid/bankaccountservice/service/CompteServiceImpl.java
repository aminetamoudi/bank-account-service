package org.sid.bankaccountservice.service;

import jakarta.transaction.Transactional;
import org.sid.bankaccountservice.dto.CompteRequestDTO;
import org.sid.bankaccountservice.dto.CompteResponseDTO;
import org.sid.bankaccountservice.entities.Compte;
import org.sid.bankaccountservice.mappers.CompteMapper;
import org.sid.bankaccountservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class CompteServiceImpl implements CompteService {
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private CompteMapper compteMapper;
    @Override
    public CompteResponseDTO addCompte(CompteRequestDTO compteDTO) {
        Compte compte=Compte.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(compteDTO.getBalance())
                .type(compteDTO.getType())
                .currency(compteDTO.getCurrency())
                .build();
        Compte saveCompte = compteRepository.save(compte);
        CompteResponseDTO compteResponseDTO = compteMapper.fromCompte(saveCompte);

        return compteResponseDTO;
    }
}
