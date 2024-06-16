package com.blogs.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="categories")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Category extends BaseEntity {
	@Column(length = 50, unique = true)
	private String name;
	@Column(length = 200)
	private String description;
	// Category 1 ----> * BlogPost (one --> Many)
	
	@OneToMany(mappedBy = "chosenCategory",
			cascade = CascadeType.ALL,orphanRemoval = true
			/*,fetch=FetchType.EAGER*/)
//	@JsonIgnore
	private List<BlogPost> posts = new ArrayList<>();

	

	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

		//helper methods - to add/remove a blog post
	public void addBlogPost(BlogPost post)
	{
		posts.add(post);//category --> posts
		post.setChosenCategory(this); //posts --> catgeory
	}
	public void removeBlogPost(BlogPost post)
	{
		posts.remove(post);
		post.setChosenCategory(null);
	}

}
