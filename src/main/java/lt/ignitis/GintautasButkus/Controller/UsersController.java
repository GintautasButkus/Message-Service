//package lt.ignitis.GintautasButkus.Controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import io.swagger.annotations.Api;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lt.ignitis.GintautasButkus.Exceptions.UserAlreadyExistsException;
//import lt.ignitis.GintautasButkus.Model.User;
//import lt.ignitis.GintautasButkus.Repositories.UsersRepository;
//
//@RestController
//@RequestMapping("/api/v1/user")
//@Api(value = "", tags = {"Ignitis People"})
//@Tag(name = "Ignitis People", description = "All Ignitis Employees")
//public class UsersController {
//	
//	@Autowired
//	UsersRepository usersRepo;
//	
//	@GetMapping
//	public List<User> getUsers() {
//		return usersRepo.findAll();
//	}
//	
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public void addUser(@RequestBody User userObj) {
//		if (getUsers().stream()
//				.anyMatch(user -> 
//				user.getEmail().equals(userObj.getEmail()))) {
//			throw new UserAlreadyExistsException("User already exists");
//		} else {
//			usersRepo.save(userObj);
//		}
//	}
//
//}
