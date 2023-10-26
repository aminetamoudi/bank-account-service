package org.sid.bankaccountservice.web;

import org.sid.bankaccountservice.dto.CompteRequestDTO;
import org.sid.bankaccountservice.dto.CompteResponseDTO;
import org.sid.bankaccountservice.entities.Compte;
import org.sid.bankaccountservice.mappers.CompteMapper;
import org.sid.bankaccountservice.repositories.CompteRepository;
import org.sid.bankaccountservice.service.CompteService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CompteRestController {
    private CompteRepository compteRepository;
    private CompteService compteService;
    private CompteMapper compteMapper;
    public  CompteRestController(CompteRepository compteRepository, CompteService compteService) {
        this.compteRepository=compteRepository;
        this.compteService = compteService;
    }
    @GetMapping("/comptes")
    public List<Compte> comptes(){
        return compteRepository.findAll();
    }
    @GetMapping("/comptes/{id}")
    public Compte compte(@PathVariable String id){
        return compteRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Compte %s non trouve",id)));
    }
    @PostMapping("/comptes")
    public CompteResponseDTO save(@RequestBody CompteRequestDTO requestDTO){

        return compteService.addCompte(requestDTO);
    }
    @PutMapping("/comptes/{id}")
    public Compte update(@PathVariable String id,@RequestBody Compte compte){
        Compte compte1=compteRepository.findById(id).orElseThrow();
        if(compte.getBalance()!=null) compte.setBalance(compte.getBalance());
        if(compte.getCreatedAt()!=null) compte.setCreatedAt(new Date());
        if(compte.getType()!=null) compte.setType(compte.getType());
        if(compte.getCurrency()!=null) compte.setCurrency(compte.getCurrency());
        return compteRepository.save(compte1);
    }
    @DeleteMapping("/compte/{id}")
    public void deleteCompte(@PathVariable String id){
         compteRepository.deleteById(id);
    }

}
