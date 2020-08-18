package com.cos.insta.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.insta.model.Follow;

public interface FollowRepository extends JpaRepository<Follow, Integer>{

	// unfollow
	@Transactional
	int deleteByFromUserIdAndToUserId(int fromUserId, int toUserId);
}
