package org.sid.bankaccountservice.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bankaccountservice.enums.CompteType;

import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor @Builder

public class CompteResponseDTO {
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private CompteType type;
}
