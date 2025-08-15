package workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import workshopmongo.domain.Post;
import workshopmongo.domain.User;
import workshopmongo.repository.PostRepository;
import workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Eduarda", "maria@gmail.com");
		User romulo = new User(null, "Romulo", "romulo@gmail.com");
		User vincius = new User(null, "Vinicius", "vinicius@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("11/08/2025"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("12/08/2025"), "Novo video game", "Estou feliz por ter comprado um video game novo!", maria);
		
		userRepository.saveAll(Arrays.asList(maria, romulo, vincius)); 
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
