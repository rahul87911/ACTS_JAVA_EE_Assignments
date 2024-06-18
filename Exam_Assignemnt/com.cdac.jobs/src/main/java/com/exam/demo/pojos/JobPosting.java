package com.exam.demo.pojos;


import java.time.LocalDate;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name = "job_posting") // to specify table name
public class JobPosting {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String jobTitle;
	    private String companyName;
	    private String location;
	    private String description;
	    private String requirements;
	    private Double salary;
	    private LocalDate postingDate;
		public JobPosting() {
			super();
		}
		public JobPosting(Long id, String jobTitle, String companyName, String location, String description,
				String requirements, Double salary, LocalDate postingDate) {
			super();
			this.id = id;
			this.jobTitle = jobTitle;
			this.companyName = companyName;
			this.location = location;
			this.description = description;
			this.requirements = requirements;
			this.salary = salary;
			this.postingDate = postingDate;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getJobTitle() {
			return jobTitle;
		}
		public void setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getRequirements() {
			return requirements;
		}
		public void setRequirements(String requirements) {
			this.requirements = requirements;
		}
		public Double getSalary() {
			return salary;
		}
		public void setSalary(Double salary) {
			this.salary = salary;
		}
		public LocalDate getPostingDate() {
			return postingDate;
		}
		public void setPostingDate(LocalDate postingDate) {
			this.postingDate = postingDate;
		}
	    
	    
	    
	    
	
}
