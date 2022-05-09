package lt.ignitis.GintautasButkus.Repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import lt.ignitis.GintautasButkus.Model.Message;

public interface MessagesRepository extends JpaRepositoryImplementation<Message, Long> {

}
