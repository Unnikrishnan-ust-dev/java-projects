package com.ust.jwtauth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.ust.jwtauth.MyUserDetailsService;
import com.ust.jwtauth.model.AuthenticationRequest;
import com.ust.jwtauth.model.AuthenticationResponse;
import com.ust.jwtauth.util.JwtUtil;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeResource {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	JwtUtil jwtutil;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		System.out.println(authenticationRequest.getUsername() + authenticationRequest.getPassword());
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {

			throw new Exception("Incorrect username or password", e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtutil.generateToken(userDetails);
		return ResponseEntity.ok().body(new AuthenticationResponse(jwt));

	}
	
	@GetMapping("/greet")
	public ResponseEntity<String> greet() {
		return ResponseEntity.ok("Working");
	}
	
	@GetMapping("/admin")
	public String greetAdmin() {
		return "Admin@Work";
	}
	
	@GetMapping("/user")
	public String greetUser() {
		return "User@Work";
	}
}
