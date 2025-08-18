package workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import workshopmongo.domain.Post;
import workshopmongo.domain.User;
import workshopmongo.dto.AuthorDTO;
import workshopmongo.dto.CommentDTO;
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
		User vinicius = new User(null, "Vinicius", "vinicius@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, romulo, vinicius)); 
		
		Post post1 = new Post(null, sdf.parse("11/08/2025"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("13/08/2025"), "Carro novo", "Estou feliz por ter comprado um carro novo!", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem!", sdf.parse("11/08/2025"), new AuthorDTO(romulo));
		CommentDTO c2 = new CommentDTO("Aproveite sua viagem!", sdf.parse("12/08/2025"), new AuthorDTO(vinicius));
		CommentDTO c3 = new CommentDTO("Parabens pela sua conquista!", sdf.parse("13/08/2025"), new AuthorDTO(romulo));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
