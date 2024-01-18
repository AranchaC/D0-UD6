package daw.dwes.ud6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ComsumoApiRestApplication {

	private static final Logger log = LoggerFactory.getLogger(ComsumoApiRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ComsumoApiRestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	@Profile("!test")
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Joke joke = restTemplate.getForObject(
					"http://official-joke-api.appspot.com/random_joke", Joke.class);
			log.info(joke.toString());
		};
	}
}
