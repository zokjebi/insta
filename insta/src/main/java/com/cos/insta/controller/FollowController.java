package com.cos.insta.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.insta.model.Follow;
import com.cos.insta.service.MyUserDetail;

@Controller
public class FollowController {
	
	@PostMapping("/follow/{id}")
	public @ResponseBody Follow follow(@AuthenticationPrincipal MyUserDetail userDetail, 
									   @PathVariable int id) {
		
		
	}
}
