package com.exam.demo.pojos;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
public class Room {
   
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private Integer roomNumber;
	    @Enumerated(EnumType.STRING)
	    private RoomType type;
	    private BigDecimal price;
	    private boolean availability;
		public Room() {
			super();
		}
		public Room(Long id, Integer roomNumber, RoomType type, BigDecimal price, boolean availability) {
			super();
			this.id = id;
			this.roomNumber = roomNumber;
			this.type = type;
			this.price = price;
			this.availability = availability;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Integer getRoomNumber() {
			return roomNumber;
		}
		public void setRoomNumber(Integer roomNumber) {
			this.roomNumber = roomNumber;
		}
		public RoomType getType() {
			return type;
		}
		public void setType(RoomType type) {
			this.type = type;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public boolean isAvailability() {
			return availability;
		}
		public void setAvailability(boolean availability) {
			this.availability = availability;
		}
	
	    
}
