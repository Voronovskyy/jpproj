package LITS.jpproj;

import LITS.jpproj.entity.User;
import LITS.jpproj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JpprojApplication implements ApplicationRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpprojApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		User user = new User();
		user.setLogin("Voronovsky");
		user.setPassword(passwordEncoder.encode("123"));
		user.setRole("Admin");
		userRepository.save(user);
	}
}
