package com.wearesorry.cashflow;

import com.wearesorry.cashflow.entities.Card;
import com.wearesorry.cashflow.entities.Sphere;
import com.wearesorry.cashflow.entities.Transaction;
import com.wearesorry.cashflow.entities.User;
import com.wearesorry.cashflow.services.CardService;
import com.wearesorry.cashflow.services.SphereService;
import com.wearesorry.cashflow.services.TransactionService;
import com.wearesorry.cashflow.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.UUID;

@SpringBootApplication
public class CashflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashflowApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserService userService, TransactionService transactionService, CardService cardService, SphereService sphereService) {
		return args -> {
			if(userService.canRegister("admin","admin@gmail.com")) {
				User user = userService.save(
						new User(
								UUID.randomUUID(),
								"admin",
								"admin@gmail.com",
								"123",
								3
						)
				);
			}
			/*for (int i = 0; i < 3; ++i){
				User user = userService.save(
						new User(
								UUID.randomUUID(),
								"user" + Integer.toString(i),
								"user@gmail.com",
								"123",
								0
						)
				);
				if(i == 2){
					userService.updateStatus(1, user.getId());
				}
				Card card = cardService.save(
						new Card(
								UUID.randomUUID(),
								user,
								"card",
								1000
						)
				);
				Sphere sphere = sphereService.save(
						new Sphere(
								UUID.randomUUID(),
								user,
								"sphere",
								10
						)
				);
				Transaction transaction = transactionService.save(
						new Transaction(
								UUID.randomUUID(),
								sphere,
								card,
								100,
								LocalDate.now()
						)
				);
			}*/
		};
	}

}
