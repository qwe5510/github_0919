package com.example.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	private Integer commentNo;
	private String userId;
	private String content;
	
	public Comment(String userId,String content){
		this.userId=userId;
		this.content=content;
	}
}
