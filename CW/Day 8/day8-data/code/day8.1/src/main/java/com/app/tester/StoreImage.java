package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.UserDao;
import com.app.dao.UserDaoImpl;
import com.app.entities.Role;
import com.app.entities.User;
import static java.time.LocalDate.parse;

public class StoreImage {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			// create user dao instance
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter file name");
			String fileName=sc.nextLine();
			System.out.println("Enter user id ");
			System.out.println(dao.storeImage(fileName, sc.nextLong()));		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
