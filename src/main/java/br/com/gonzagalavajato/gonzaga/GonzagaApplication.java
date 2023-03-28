package br.com.gonzagalavajato.gonzaga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class GonzagaApplication {
	
	@GetMapping
	public String getHomeTeste() {
		return "Teste Gonzaga API";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(GonzagaApplication.class, args);
	}
}