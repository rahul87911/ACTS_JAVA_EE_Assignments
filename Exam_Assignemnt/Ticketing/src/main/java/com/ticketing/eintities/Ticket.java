 package com.ticketing.eintities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String requesterPhoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private String issueDetails;

    private String resolutionDetails;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private LocalDateTime createDateTime;

    private LocalDateTime resolutionDateTime;

	public Ticket() {
		super();
	}

	public Ticket(Long id, String requesterPhoneNumber, Category category, String issueDetails,
			String resolutionDetails, Status status, LocalDateTime createDateTime, LocalDateTime resolutionDateTime) {
		super();
		this.id = id;
		this.requesterPhoneNumber = requesterPhoneNumber;
		this.category = category;
		this.issueDetails = issueDetails;
		this.resolutionDetails = resolutionDetails;
		this.status = status;
		this.createDateTime = createDateTime;
		this.resolutionDateTime = resolutionDateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequesterPhoneNumber() {
		return requesterPhoneNumber;
	}

	public void setRequesterPhoneNumber(String requesterPhoneNumber) {
		this.requesterPhoneNumber = requesterPhoneNumber;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getIssueDetails() {
		return issueDetails;
	}

	public void setIssueDetails(String issueDetails) {
		this.issueDetails = issueDetails;
	}

	public String getResolutionDetails() {
		return resolutionDetails;
	}

	public void setResolutionDetails(String resolutionDetails) {
		this.resolutionDetails = resolutionDetails;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getResolutionDateTime() {
		return resolutionDateTime;
	}

	public void setResolutionDateTime(LocalDateTime resolutionDateTime) {
		this.resolutionDateTime = resolutionDateTime;
	}

    
}
