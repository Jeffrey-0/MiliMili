package model;

import java.util.Date;


public class Post {
	private Integer id;
	private Integer post_id;
	private Integer post_stprey_id;
	private Integer post_from_uid;
	private String post_from_name;
	private Integer post_to_uid;
	private String post_to_name;	
	private String post_content;
	private String post_date;
	
	public Post() {
	}

	public Post(Integer post_id,Integer post_stprey_id,Integer post_from_uid,String post_from_name,Integer post_to_uid,String post_to_name,String post_content, String post_date) {
		
		this.post_id=post_id;
		this.post_stprey_id=post_stprey_id;
		this.post_from_uid=post_from_uid;
		this.post_from_name=post_from_name;
		this.post_to_uid=post_to_uid;
		this.post_to_name=post_to_name;
		this.post_content=post_content;
		this.post_date=post_date;
	}
	
public Post(Integer post_id,Integer post_stprey_id,Integer post_from_uid,String post_from_name,String post_content, String post_date) {
		
		this.post_id=post_id;
		this.post_stprey_id=post_stprey_id;
		this.post_from_uid=post_from_uid;
		this.post_from_name=post_from_name;
		this.post_content=post_content;
		this.post_date=post_date;
	}
	
	public Post(Integer id,Integer post_id,Integer post_stprey_id,Integer post_from_uid,Integer post_to_uid,String post_content, String post_date) {
		this.id=id;
		this.post_id=post_id;
		this.post_stprey_id=post_stprey_id;
		this.post_from_uid=post_from_uid;
		this.post_to_uid=post_to_uid;
		this.post_content=post_content;
		this.post_date=post_date;
	}
	
	public Post(Integer id,Integer post_id,Integer post_stprey_id,Integer post_from_uid,String post_content, String post_date) {
		this.id=id;
		this.post_id=post_id;
		this.post_stprey_id=post_stprey_id;
		this.post_from_uid=post_from_uid;
		this.post_content=post_content;
		this.post_date=post_date;
	}
	
	public Post(Integer post_stprey_id,String post_from_name,String post_content, String post_date) {
	
		this.post_stprey_id=post_stprey_id;
		this.post_from_name=post_from_name;
		this.post_content=post_content;
		this.post_date=post_date;
	}
	
	public Post(String post_from_name,String post_content, String post_date) {
		
		
		this.post_from_name=post_from_name;
		this.post_content=post_content;
		this.post_date=post_date;
	}
	
	public Post(Integer post_from_uid,Integer post_stprey_id,String post_from_name,String post_content, String post_date) {
		this.post_from_uid=post_from_uid;
		this.post_stprey_id=post_stprey_id;
		this.post_from_name=post_from_name;
		this.post_content=post_content;
		this.post_date=post_date;
	}
	
	public Post(Integer post_from_uid,String post_from_name) {
		this.post_from_uid=post_from_uid;
		this.post_from_name=post_from_name;

	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPost_id() {
		return post_id;
	}
	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}
	public Integer getPost_stprey_id() {
		return post_stprey_id;
	}
	public void setPost_stprey_id(Integer post_stprey_id) {
		this.post_stprey_id = post_stprey_id;
	}
	public Integer getPost_from_uid() {
		return post_from_uid;
	}
	public void setPost_from_uid(Integer post_from_uid) {
		this.post_from_uid = post_from_uid;
	}
	public Integer getPost_to_uid() {
		return post_to_uid;
	}
	public void setPost_to_uid(Integer post_to_uid) {
		this.post_to_uid = post_to_uid;
	}
	



	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public String getPost_to_name() {
		return post_to_name;
	}

	public void setPost_to_name(String post_to_name) {
		this.post_to_name = post_to_name;
	}

	public String getPost_from_name() {
		return post_from_name;
	}

	public void setPost_from_name(String post_from_name) {
		this.post_from_name = post_from_name;
	}

	public String getPost_date() {
		return post_date;
	}

	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}


	
	
	
	
}
