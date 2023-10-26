package org.sid.bankaccountservice.entities;

import org.sid.bankaccountservice.enums.CompteType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Compte.class, name = "p1")
public interface CompteProjection {
    public String getId();
    public CompteType getType();
    public Double getBalance();
}
