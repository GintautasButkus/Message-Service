package lt.ignitis.GintautasButkus.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import lt.ignitis.GintautasButkus.Model.User;
import lt.ignitis.GintautasButkus.Repositories.UsersRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest  {
	
	@Autowired
	UsersRepository userRepo;
	
	@Test
	public void testCreateUser() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawPassword = "name2022";
		String encodedPassword = passwordEncoder.encode(rawPassword);
		User newUser = new User("name@ignitis.lt", encodedPassword);
		
		User savedUser = userRepo.save(newUser);
		
		assertThat(savedUser).isNotNull();
		assertThat(savedUser.getUserId()).isGreaterThan(0);
		
	}

}
