//package lt.ignitis.GintautasButkus.Controller;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import io.swagger.annotations.Api;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lt.ignitis.GintautasButkus.Exceptions.NoUnreadMessagesException;
//import lt.ignitis.GintautasButkus.Exceptions.NoUserExistsException;
//import lt.ignitis.GintautasButkus.Model.Message;
//import lt.ignitis.GintautasButkus.Repositories.MessagesRepository;
//import lt.ignitis.GintautasButkus.Repositories.UsersRepository;
//
//@RestController
//@RequestMapping("/api/v1")
//@Api(value = "", tags = {"Message management controller"})
//@Tag(name = "Message management controller", description = "Ignitis Message System")
//public class MessagesController {
//	
//	@Autowired
//	private MessagesRepository messagesRepo;
//	
//	@Autowired
//	private UsersRepository usersRepo;
//	
//	@GetMapping
//	public List<Message> getAllMessages(){
//		return messagesRepo.findAll();
//	}
//	
//	@GetMapping("/unread")
//	public List<Message> getUnreadMessages(){
//		return getAllMessages().stream().filter(message -> message.getMessageRead()==false).collect(Collectors.toList());
//	}
//	
//	@GetMapping("/read")
//	public Message readUnreadMessage(){
//		Message unreadMessage = null;
//		if(!getUnreadMessages().isEmpty()) {
//			unreadMessage = getUnreadMessages().get(0);
//			Message readMessage = getUnreadMessages().get(0);
//			readMessage.setMessageRead(true);
//			messagesRepo.save(readMessage);
//			 return unreadMessage;
//		} else {
//			throw new NoUnreadMessagesException("No unread messages in mailbox");
//		}
//	}
//	
//	
//	@PostMapping("/{username}")
//	@ResponseStatus(HttpStatus.CREATED)
//	public void createMessage(@PathVariable String username, @RequestBody @Valid Message messageDetails) {
//		Message message = usersRepo.findById(usersRepo.findAll().stream().filter(user -> user.getEmail().equals(username)).findFirst().get().getUserId()).map(user -> {
//			messageDetails.setUser(user);
//			messageDetails.setSentDate(LocalDateTime.now());
//			messageDetails.setMessageRead(false);
//			messageDetails.setTo(username);
//			return messagesRepo.save(messageDetails);
//		}).orElseThrow(() -> new NoUserExistsException("No user exists with username  " + username));
//		messagesRepo.save(message);
//	}
//
//}
