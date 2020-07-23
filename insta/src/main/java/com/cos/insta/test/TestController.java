package com.cos.insta.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.insta.model.Follow;
import com.cos.insta.model.Image;
import com.cos.insta.model.Likes;
import com.cos.insta.model.User;

@Controller
public class TestController {
	
	@GetMapping("/test/home")
	public String testHome() {
		return "home";
	}
	
	
	@GetMapping("/test/like")
	public @ResponseBody Likes getLike() {
		User user = new User();
		user.setId(1);
		user.setUsername("cos");
		user.setName("홍길동");
		user.setEmail("cos@nate.com");
		user.setProfileImage("my.jpg");
		
		Image img1 = new Image();
		img1.setId(1);
		img1.setCaption("음식 사진");
		img1.setLocation("food.jpg");
		img1.setLocation("부산 서면");
		img1.setUser(user);
		
		Likes like = new Likes();
		like.setId(1);
		like.setUser(user);
		like.setImage(img1);
		
		return like;
	}
	
	@GetMapping("/test/follows")
	public @ResponseBody List<Follow> getFollows() {
		
		User user1 = new User();
		user1.setId(1);
		user1.setUsername("cos");
		user1.setName("홍길동");
		user1.setEmail("cos@nate.com");
		user1.setProfileImage("my.jpg");
		
		User user2 = new User();
		user2.setId(2);
		user2.setUsername("ssar");
		user2.setName("장동건");
		user2.setEmail("ssar@nate.com");
		user2.setProfileImage("you.jpg");
		
		User user3 = new User();
		user3.setId(3);
		user3.setUsername("love");
		user3.setName("장보고");
		user3.setEmail("love@nate.com");
		user3.setProfileImage("love.jpg");
		
		Follow follow1 = new Follow();
		follow1.setId(1);
		follow1.setFromUser(user1);
		follow1.setToUser(user2);
		
		Follow follow2 = new Follow();
		follow2.setId(2);
		follow2.setFromUser(user1);
		follow2.setToUser(user3);
		
		Follow follow3 = new Follow();
		follow3.setId(3);
		follow3.setFromUser(user2);
		follow3.setToUser(user1);
		
		List<Follow> follows = new ArrayList<Follow>();
		follows.add(follow1);
		follows.add(follow2);
		follows.add(follow3);
		
		return follows;
	}
	
	@GetMapping("/test/login")
	public String testLogin() {
		return "auth/login";
	}
	
	@GetMapping("/test/join")
	public String testJoin() {
		return "auth/join";
	}
	
	@GetMapping("/test/profile")
	public String testProfile() {
		return "user/profile";
	}
	
	@GetMapping("/test/feed")
	public String testFeed() {
		return "image/feed";
	}
	
	@GetMapping("/test/imageUpload")
	public String testImageUpload() {
		return "image/image_upload";
	}
	
}