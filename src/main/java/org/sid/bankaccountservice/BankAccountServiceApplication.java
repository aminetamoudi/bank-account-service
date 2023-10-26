package org.sid.bankaccountservice;

import org.sid.bankaccountservice.entities.Compte;
import org.sid.bankaccountservice.enums.CompteType;
import org.sid.bankaccountservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository) {
		return args -> {
			for (int i = 0; i < 10; i++) {
				Compte compte = Compte.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random() > 0.5 ? CompteType.CURRENT_COMPTE : CompteType.SAVING_COMPTE)
						.balance(10000 + Math.random() * 90000)
						.createdAt(new Date())
						.currency("MAD")
						.build();
				compteRepository.save(compte);
			}
		};
	}
}


