package com.example.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class FollowForm {
	@NotNull
	@Size(min = 1, max = 30)
	private String follower_id;
	@NotNull
	@Size(min = 1, max = 30)
	private String followed_id;
}
