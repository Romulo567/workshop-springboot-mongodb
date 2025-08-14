package workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import workshopmongo.domain.User;
import workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Eduarda", "maria@gmail.com");
		User romulo = new User(null, "Romulo", "romulo@gmail.com");
		User vincius = new User(null, "Vinicius", "vinicius@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, romulo, vincius)); 
		
	}

}
