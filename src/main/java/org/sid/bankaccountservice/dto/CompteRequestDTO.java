package org.sid.bankaccountservice.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bankaccountservice.enums.CompteType;


@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CompteRequestDTO {
    private Double balance;
    private String currency;
    private CompteType type;
}
