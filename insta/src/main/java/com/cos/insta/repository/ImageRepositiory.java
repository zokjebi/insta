package com.cos.insta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.insta.model.Image;

public interface ImageRepositiory extends JpaRepository<Image, Integer> {
	
}
