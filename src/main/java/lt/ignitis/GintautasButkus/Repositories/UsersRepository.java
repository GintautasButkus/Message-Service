package lt.ignitis.GintautasButkus.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import lt.ignitis.GintautasButkus.Model.User;

public interface UsersRepository extends JpaRepositoryImplementation<User, Long> {
	Optional<User> findByEmail(String email);
}
