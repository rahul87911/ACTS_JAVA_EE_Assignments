package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.BlogPostDao;
import com.app.dao.BlogPostDaoImpl;
import com.app.entities.BlogPost;
import com.app.entities.Category;

public class AddBlogToExistingCategoryByBlogger {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			BlogPostDao dao = new BlogPostDaoImpl();
			System.out.println("Enter category id , for adding new blog");
			Long categoryId = sc.nextLong();
			System.out.println("Enter blogger  id , for adding new blog");
			Long bloggerId = sc.nextLong();
			System.out.println("Add blog details -title content desc");
			BlogPost post = new BlogPost(sc.next(), sc.next(), sc.next());
			System.out.println(dao.
					addNewBlog(categoryId, bloggerId, post));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
