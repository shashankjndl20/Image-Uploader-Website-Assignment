package com.upgrad.ImageHoster.common;

import com.upgrad.ImageHoster.model.Comment;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

@SuppressWarnings("unchecked")
// This shows the comments given on the image by users
public class CommentManager extends SessionManager{
    public Comment getById(int id) {
        Session session = openSession();

        try {
            Comment comment = (Comment) session.createCriteria(Comment.class)
                                        .add(Restrictions.eq("id", id))
                                        .uniqueResult(); // retrieves only 1 image
            commitSession(session);

            return comment;
        } catch(HibernateException e) {
            System.out.println("unable to retrieve an comment from database by its id");
        }

        return null;
    }

    public Comment add(Comment comment) {
        Session session = openSession();
        session.save(comment);
        commitSession(session);
        return comment;
    }
}
