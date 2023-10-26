package org.sid.bankaccountservice.service;

import org.sid.bankaccountservice.dto.CompteRequestDTO;
import org.sid.bankaccountservice.dto.CompteResponseDTO;

public interface CompteService {
    public CompteResponseDTO addCompte(CompteRequestDTO compteDTO);
}
