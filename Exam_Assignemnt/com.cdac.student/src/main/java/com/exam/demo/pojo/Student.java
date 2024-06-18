package com.exam.demo.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long sid;
	    private String sname;
	    private String email;
	    private String password;
	    @ManyToOne
	    @JoinColumn(name = "cid")
	    private Course course;
		public Student() {
			super();
		}
		public Student(Long sid, String sname, String email, String password, Course course) {
			super();
			this.sid = sid;
			this.sname = sname;
			this.email = email;
			this.password = password;
			this.course = course;
		}
		public Long getSid() {
			return sid;
		}
		public void setSid(Long sid) {
			this.sid = sid;
		}
		public String getSname() {
			return sname;
		}
		public void setSname(String sname) {
			this.sname = sname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Course getCourse() {
			return course;
		}
		public void setCourse(Course course) {
			this.course = course;
		}
	    
	    
}
