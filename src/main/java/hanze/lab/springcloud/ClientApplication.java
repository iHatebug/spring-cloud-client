package hanze.lab.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ClientApplication {

	@Value("${user.role}")
	private String role;

	@Value("${user.password}")
	private String password;

	@Value("${user.email}")
	private String email;

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@RequestMapping(
			value = "/whoami/{username}",
			method = RequestMethod.GET,
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String whoami(@PathVariable("username") String username) {
		return String.format("Hello! You're %s and you'll become a(n) %s only if your password is %s \n email: %s", username, role, password,email
		);
	}
}
