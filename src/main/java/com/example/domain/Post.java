package com.example.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="posts")
@ToString(exclude="follow")
public class Post{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private Integer id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String context;
	@Column(nullable = false)
	private String username;
	@Column(name = "reg_date", updatable=false)
	@CreationTimestamp
    private LocalDate reg_date;
	@Column(name = "upd_date")
    @UpdateTimestamp
    private LocalDate upd_date;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="username" , referencedColumnName="followed_id", insertable = false, updatable = false)
	@JsonIgnore
	private Follow follow;

}
