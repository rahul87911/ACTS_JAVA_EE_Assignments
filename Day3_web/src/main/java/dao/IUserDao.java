package dao;

import java.sql.Date;
import java.sql.SQLException;
import  pojos.User;

public interface IUserDao {  
	User validateUser(String email,String pwd)throws SQLException; 
	User addUser(String firstName, String lastName, String email, String password, Date dob)throws SQLException;
}
