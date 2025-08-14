package workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> readAll(){
		User maria = new User("1", "Maria Eduarda", "maria@gmail.com"); 
		User romulo = new User("2", "Romulo Ferreira", "romulo@gmail.com"); 
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, romulo));
		return ResponseEntity.ok().body(list);
	}
}
