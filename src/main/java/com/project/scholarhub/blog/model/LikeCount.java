package com.project.scholarhub.blog.model;

import java.util.UUID;

import lombok.Data;

@Data
public class LikeCount {

	private UUID blogId;
	private int likeCount;
}
