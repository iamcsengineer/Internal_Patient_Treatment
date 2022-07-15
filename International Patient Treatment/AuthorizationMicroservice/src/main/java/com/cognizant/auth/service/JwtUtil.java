package com.cognizant.auth.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
public class JwtUtil {

	private String secretKey = "${jwt.secret}";

	public String extractUsername(String token) {
		log.info("START :: Method :: extractUsername() :: ");
		log.info("END :: Method :: extractUsername() :: ");
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		log.info("START :: Method :: extractExpiration() :: ");
		log.info("END :: Method :: extractExpiration() :: ");
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		log.info("START :: Method :: extractClaim() :: ");
		final Claims claims = extractAllClaims(token);
		log.info("END :: Method :: extractClaim() :: ");
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		log.info("START :: Method :: extractAllClaims() :: ");
		log.info("END :: Method :: extractAllClaims() :: ");
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		log.info("START :: Method :: isTokenExpired() :: ");
		log.info("END :: Method :: isTokenExpired() :: ");
		return extractExpiration(token).before(new Date());
	}

	public String generateToken(UserDetails userDetails) {
		log.info("START :: Method :: generateToken() :: ");
		Map<String, Object> claims = new HashMap<>();
		log.info("START :: Method :: generateToken() :: ");
		return createToken(claims, userDetails.getUsername());
	}

	private String createToken(Map<String, Object> claims, String subject) {
		log.info("START :: Method :: createToken() :: ");
		log.info("END :: Method :: createToken() :: ");
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))// token for 30 mins
				.signWith(SignatureAlgorithm.HS256, secretKey).compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		log.info("START :: Method :: validateToken() :: ");
		final String username = extractUsername(token);
		log.info("END :: Method :: validateToken() :: ");
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	public Boolean validateToken(String token) {
		log.info("START :: Method :: validateToken() :: ");
		log.info("END :: Method :: validateToken() :: ");
		return !isTokenExpired(token);
		
	}
}
