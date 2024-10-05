package jm.task.core.jdbc.dao;

import java.util.List;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDaoHibernateImpl implements UserDao {
    private final SessionFactory sessionFactory = Util.getSessionFactory();

    public UserDaoHibernateImpl() {
    }

    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS  users(id serial primary key, firstname varchar(100),lastname varchar(100),age integer)";

        try {
            Session session = Util.getSessionFactory().openSession();

            try {
                session.beginTransaction();
                session.createSQLQuery(sql).executeUpdate();
                session.getTransaction().commit();
            } catch (Throwable var6) {
                if (session != null) {
                    try {
                        session.close();
                    } catch (Throwable var5) {
                        var6.addSuppressed(var5);
                    }
                }

                throw var6;
            }

            if (session != null) {
                session.close();
            }
        } catch (Exception var7) {
            Exception e = var7;
            e.printStackTrace();
        }

    }

    public void dropUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();

            try {
                session.beginTransaction();
                session.createSQLQuery("DROP TABLE users").executeUpdate();
                session.getTransaction().commit();
            } catch (Throwable var5) {
                if (session != null) {
                    try {
                        session.close();
                    } catch (Throwable var4) {
                        var5.addSuppressed(var4);
                    }
                }

                throw var5;
            }

            if (session != null) {
                session.close();
            }
        } catch (Exception var6) {
            Exception e = var6;
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            Session session = this.sessionFactory.openSession();

            try {
                Transaction transaction = session.beginTransaction();
                User user = new User(name, lastName, age);
                session.save(user);
                transaction.commit();
                System.out.println("User с именем – " + name + " добавлен в базу данных");
            } catch (Throwable var8) {
                if (session != null) {
                    try {
                        session.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            if (session != null) {
                session.close();
            }
        } catch (Exception var9) {
            Exception e = var9;
            e.printStackTrace();
            System.out.println("Ошибка при добавлении пользователя");
        }

    }

    public void removeUserById(long id) {
        try {
            Session session = this.sessionFactory.openSession();

            try {
                Transaction transaction = session.beginTransaction();
                User user = (User)session.get(User.class, id);
                if (user != null) {
                    session.delete(user);
                }

                transaction.commit();
            } catch (Throwable var7) {
                if (session != null) {
                    try {
                        session.close();
                    } catch (Throwable var6) {
                        var7.addSuppressed(var6);
                    }
                }

                throw var7;
            }

            if (session != null) {
                session.close();
            }
        } catch (Exception var8) {
            Exception e = var8;
            e.printStackTrace();
            System.out.println("Ошибка при удалении пользователя");
        }

    }

    public List<User> getAllUsers() {
        try {
            Session session = this.sessionFactory.openSession();

            List var3;
            try {
                Query<User> query = session.createQuery("FROM User", User.class);
                var3 = query.list();
            } catch (Throwable var5) {
                if (session != null) {
                    try {
                        session.close();
                    } catch (Throwable var4) {
                        var5.addSuppressed(var4);
                    }
                }

                throw var5;
            }

            if (session != null) {
                session.close();
            }

            return var3;
        } catch (Exception var6) {
            Exception e = var6;
            e.printStackTrace();
            System.out.println("Ошибка при получении списка пользователей");
            return null;
        }
    }

    public void cleanUsersTable() {
        try {
            Session session = this.sessionFactory.openSession();

            try {
                Transaction transaction = session.beginTransaction();
                session.createQuery("DELETE FROM User").executeUpdate();
                transaction.commit();
            } catch (Throwable var5) {
                if (session != null) {
                    try {
                        session.close();
                    } catch (Throwable var4) {
                        var5.addSuppressed(var4);
                    }
                }

                throw var5;
            }

            if (session != null) {
                session.close();
            }
        } catch (Exception var6) {
            Exception e = var6;
            e.printStackTrace();
            System.out.println("Ошибка при очистке таблицы пользователей");
        }

    }
}
