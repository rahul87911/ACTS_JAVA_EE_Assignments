package dao;

import java.sql.*;



import static utils.DbUtils.openConnection; 

import pojos.User;

public class UserDaoImpl implements IUserDao {

	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	
	public UserDaoImpl() throws ClassNotFoundException,SQLException{
		cn=openConnection();
		pst1=cn.prepareStatement("select*from users where email=? and password=?");
		pst2=cn.prepareStatement("INSERT INTO users (first_name, last_name, email, password, dob) VALUES (?, ?, ?, ?, ?)");

		System.out.println("user dao created");
	}
	
	@Override
	public User validateUser(String email, String pwd) throws SQLException {
		pst1.setString(1, email);
		pst1.setString(2, pwd);
		
		try(ResultSet rst=pst1.executeQuery())
		{
			if(rst.next())
			{
   //int userId, String firstName, String lastName, String email, String password, Date dob, boolean status,
				//String role
			 return new User(rst.getInt(1),rst.getString(2),rst.getString(3),email,pwd,rst.getDate(6),rst.getBoolean(7),rst.getString(8));	
			}
	  	}
		
		return null;
	}
	
	  @Override
	    public User addUser(String firstName, String lastName, String email, String password, Date dob) throws SQLException {
	        pst2.setString(1, firstName);
	        pst2.setString(2, lastName);
	        pst2.setString(3, email);
	        pst2.setString(4, password);
	        pst2.setDate(5, dob);

	        int insertCount = pst2.executeUpdate(); // Use executeUpdate() for INSERT statement

	        if (insertCount == 1) {
	            // User added successfully, retrieve the newly added user details
	         
	               
	                    return new User(-1, firstName, lastName, email, password, dob, true, "User");
	                
	        }
	        return null;
	        
	    }
	
	public void cleanUp() throws SQLException
	{
	  if(pst1 != null)
		  pst1.close();
	  if (pst2 != null)
          pst2.close();
	}

}
