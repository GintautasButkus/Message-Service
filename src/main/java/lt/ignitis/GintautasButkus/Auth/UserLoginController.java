package lt.ignitis.GintautasButkus.Auth;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lt.ignitis.GintautasButkus.Model.User;
import lt.ignitis.GintautasButkus.jwt.JwtTokenUtil;

@RequestMapping("/api/v1/user")
@RestController
@Api(value = "", tags = {"Ignitis Login"})
@Tag(name = "Ignitis Login", description = "All Ignitis Employees")
public class UserLoginController {
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request){
		try {
			Authentication authenticate = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
					);
			
			User user = (User) authenticate.getPrincipal();
			
			String accessToken = jwtTokenUtil.generateAccessToken(user);
			AuthResponse response = new AuthResponse(user.getEmail(), accessToken);
			
			return ResponseEntity.ok(response);
			
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

}
