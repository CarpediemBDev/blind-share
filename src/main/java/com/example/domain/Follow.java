package com.example.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="follows")
//@ToString(exclude="posts")
public class Follow  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private Integer id;
	@Column(nullable = false)
	private String follower_id;
	@Column(nullable = false)
	private String followed_id;
	@Column(name = "reg_date", updatable=false)
	@CreationTimestamp
    private LocalDate reg_date;
	@Column(name = "upd_date")
    @UpdateTimestamp
    private LocalDate upd_date;
    //@OneToMany(fetch = FetchType.LAZY )
    //@JoinColumn(name="username" , referencedColumnName="followed_id")
    //@JsonSerialize
    //private List<Post> posts;
}
