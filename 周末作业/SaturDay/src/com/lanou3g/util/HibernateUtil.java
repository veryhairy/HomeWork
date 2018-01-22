package com.lanou3g.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by fwj on 2018/1/18.
 */
public class HibernateUtil {
    static SessionFactory SF;

    static {
        SF=new Configuration().configure().buildSessionFactory();
    }
        public static <T> T handle(ResultHandler<T> rh){
            Session session = SF.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();
            T t = rh.resulthandle(session);
            transaction.commit();
            session.close();
            return t;
        }

    public interface ResultHandler<T>{

        T resulthandle(Session session);

    }
}
