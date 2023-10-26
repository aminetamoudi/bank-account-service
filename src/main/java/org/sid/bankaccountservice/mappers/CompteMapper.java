package org.sid.bankaccountservice.mappers;

import org.sid.bankaccountservice.dto.CompteResponseDTO;
import org.sid.bankaccountservice.entities.Compte;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CompteMapper {
    public CompteResponseDTO fromCompte(Compte compte){
        CompteResponseDTO compteResponseDTO=new CompteResponseDTO();
        BeanUtils.copyProperties(compte,compteResponseDTO);
        return compteResponseDTO;
    }
}
