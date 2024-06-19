package com.ticketing.dto;



import java.time.LocalDateTime;

import com.ticketing.eintities.Status;

public class TicketUpdateRequest {

    private Status status;
    private String resolutionDetails;
    private LocalDateTime resolutionDateTime;
    
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getResolutionDetails() {
		return resolutionDetails;
	}
	public void setResolutionDetails(String resolutionDetails) {
		this.resolutionDetails = resolutionDetails;
	}
	public LocalDateTime getResolutionDateTime() {
		return resolutionDateTime;
	}
	public void setResolutionDateTime(LocalDateTime resolutionDateTime) {
		this.resolutionDateTime = resolutionDateTime;
	}

    
}
