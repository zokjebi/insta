package com.cos.insta.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.insta.model.User;
import com.cos.insta.repository.UserRepository;

@Controller
public class UserController {
	
	//private static final String TAG = "User";
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepository mUserRepository;
	
	@GetMapping("/auth/login")
	public String authLogin() {
		return "auth/login";
	}
	
	@GetMapping("/auth/join")
	public String authJoin() {
		return "auth/join";
	}
	
	@PostMapping("/auth/joinProc")
	public String authJoinProc(User user) {
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		user.setPassword(encPassword);
		log.info("rawPassword : " + rawPassword);
		log.info("encPassword : " + encPassword);
		
		mUserRepository.save(user);
		
		return "redirect:/auth/login";
	}
	
	@GetMapping("/user/{id}")
	public String profile(@PathVariable int id) {
		
		// id를 통해서 해당 유저를 검색 (이미지 + 유저정보)
		/**
		 * 1. imageCount
		 * 2. followerCount
		 * 3. followingCount
		 * 4. User 오브젝트 (Image (likeCount) 컬렉션)
		 * 5. follow 유무
		 */
		
		return "user/profile";
	}
}
