
package jm.task.core.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY, firstname VARCHAR(30) NOT NULL, lastName VARCHAR(30), age SMALLINT)";

        try {
            Connection connection = Util.getConnection();

            try {
                Statement statement = connection.createStatement();

                try {
                    statement.executeUpdate(sql);
                } catch (Throwable var8) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var7) {
                            var8.addSuppressed(var7);
                        }
                    }

                    throw var8;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var9) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var6) {
                        var9.addSuppressed(var6);
                    }
                }

                throw var9;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var10) {
            SQLException e = var10;
            e.printStackTrace();
            System.out.println("Ошибка при создании таблицы");
        }

    }

    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users";

        try {
            Connection connection = Util.getConnection();

            try {
                Statement statement = connection.createStatement();

                try {
                    statement.executeUpdate(sql);
                } catch (Throwable var8) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var7) {
                            var8.addSuppressed(var7);
                        }
                    }

                    throw var8;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var9) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var6) {
                        var9.addSuppressed(var6);
                    }
                }

                throw var9;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var10) {
            SQLException e = var10;
            e.printStackTrace();
            System.out.println("Ошибка при удалении таблицы");
        }

    }

    public void saveUser(String firstname, String lastName, byte age) {
        String sql = "INSERT INTO users (firstname, lastName, age) VALUES (?, ?, ?)";

        try {
            Connection connection = Util.getConnection();

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                try {
                    preparedStatement.setString(1, firstname);
                    preparedStatement.setString(2, lastName);
                    preparedStatement.setByte(3, age);
                    preparedStatement.executeUpdate();
                    System.out.println("User с именем – " + firstname + " добавлен в базу данных");
                } catch (Throwable var11) {
                    if (preparedStatement != null) {
                        try {
                            preparedStatement.close();
                        } catch (Throwable var10) {
                            var11.addSuppressed(var10);
                        }
                    }

                    throw var11;
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable var12) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var9) {
                        var12.addSuppressed(var9);
                    }
                }

                throw var12;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var13) {
            SQLException e = var13;
            e.printStackTrace();
            System.out.println("Ошибка при добавлении пользователя");
        }

    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try {
            Connection connection = Util.getConnection();

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                try {
                    preparedStatement.setLong(1, id);
                    preparedStatement.executeUpdate();
                } catch (Throwable var10) {
                    if (preparedStatement != null) {
                        try {
                            preparedStatement.close();
                        } catch (Throwable var9) {
                            var10.addSuppressed(var9);
                        }
                    }

                    throw var10;
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable var11) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var8) {
                        var11.addSuppressed(var8);
                    }
                }

                throw var11;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var12) {
            SQLException e = var12;
            e.printStackTrace();
            System.out.println("Ошибка при удалении пользователя");
        }

    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList();
        String sql = "SELECT * FROM users";

        try {
            Connection connection = Util.getConnection();

            try {
                Statement statement = connection.createStatement();

                try {
                    ResultSet resultSet = statement.executeQuery(sql);

                    try {
                        while(resultSet.next()) {
                            User user = new User();
                            user.setId(resultSet.getLong("id"));
                            user.setName(resultSet.getString("firstname"));
                            user.setLastName(resultSet.getString("lastName"));
                            user.setAge((byte)resultSet.getShort("age"));
                            users.add(user);
                        }
                    } catch (Throwable var11) {
                        if (resultSet != null) {
                            try {
                                resultSet.close();
                            } catch (Throwable var10) {
                                var11.addSuppressed(var10);
                            }
                        }

                        throw var11;
                    }

                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (Throwable var12) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var9) {
                            var12.addSuppressed(var9);
                        }
                    }

                    throw var12;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var13) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var8) {
                        var13.addSuppressed(var8);
                    }
                }

                throw var13;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var14) {
            SQLException e = var14;
            e.printStackTrace();
            System.out.println("Ошибка при получении списка пользователей");
        }

        return users;
    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE TABLE users";

        try {
            Connection connection = Util.getConnection();

            try {
                Statement statement = connection.createStatement();

                try {
                    statement.executeUpdate(sql);
                } catch (Throwable var8) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var7) {
                            var8.addSuppressed(var7);
                        }
                    }

                    throw var8;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var9) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var6) {
                        var9.addSuppressed(var6);
                    }
                }

                throw var9;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var10) {
            SQLException e = var10;
            e.printStackTrace();
            System.out.println("Ошибка при очистке таблицы пользователей");
        }

    }
}
