package com.exam.demo.exceptions;

public class InvalidRoomIdException extends RuntimeException {

	public InvalidRoomIdException(String mesg) {
		super(mesg);
	}

}
