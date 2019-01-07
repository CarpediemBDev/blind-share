package com.example.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PostForm {
	@NotNull
	@Size(min = 1, max = 127)
	private String title;
	@NotNull
	@Size(min = 1, max = 300)
	private String context;
	
}
