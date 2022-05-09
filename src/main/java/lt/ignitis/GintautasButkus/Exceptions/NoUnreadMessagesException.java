package lt.ignitis.GintautasButkus.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoUnreadMessagesException extends NullPointerException {
	private static final long serialVersionUID = 1L;
	
	public NoUnreadMessagesException(String message){
		super(message);
	}
}
