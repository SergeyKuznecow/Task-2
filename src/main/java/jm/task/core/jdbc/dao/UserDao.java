
package jm.task.core.jdbc.dao;

import java.util.List;
import jm.task.core.jdbc.model.User;

public interface UserDao {
    void createUsersTable();

    void dropUsersTable();

    void saveUser(String var1, String var2, byte var3);

    void removeUserById(long var1);

    List<User> getAllUsers();

    void cleanUsersTable();
}
