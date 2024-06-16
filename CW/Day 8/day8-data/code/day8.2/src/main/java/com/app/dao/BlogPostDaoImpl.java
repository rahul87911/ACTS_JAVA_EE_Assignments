package com.app.dao;

import static com.app.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entities.BlogPost;
import com.app.entities.Category;
import com.app.entities.User;

public class BlogPostDaoImpl implements BlogPostDao {

	@Override
	public String addNewBlog(Long categoryId, Long bloggerId, BlogPost post) {
		String mesg = "adding blog failed ";
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			// 3. get categroy ref from it's id
			Category cat = session.get(Category.class, categoryId);
			//4. get blogger from the id
			User blogger=session.get(User.class, bloggerId);
			if (cat != null && blogger != null) {
				// => category n blogger : persistent
				// 4. IMPORTANT -- establish bi dir asso -using helper method
				cat.addBlogPost(post);
				//establish post --> blogger
				post.setBlogger(blogger);
				// session.persist(post);
				mesg = "added new post";
			}
			tx.commit();// Hib performs dirty chking -> cascadeType.MERGE --> inserts post rec
			mesg = "added new post with id=" + post.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return mesg;
	}

	@Override
	public String removeBlog(Long catId, Long blogId) {
		String mesg = "removing blog failed";
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			// get category from id
			Category category = session.get(Category.class, catId);
			// get blog from its id
			BlogPost post = session.get(BlogPost.class, blogId);
			// validate
			if (category != null && post != null) {
				// updating state of the persistent entity
				category.removeBlogPost(post);
				mesg = "removed blog";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return null;
	}

}
