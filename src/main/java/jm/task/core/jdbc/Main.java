package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDaoHibernateImpl f = new UserDaoHibernateImpl();
        UserDaoJDBCImpl f1 = new UserDaoJDBCImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите вариант (1-10):");
        System.out.println("1. Создать таблицу");
        System.out.println("2. Удалить таблицу");
        System.out.println("3. Добавить 4 чел.");
        System.out.println("4. Удалить 1 чел");
        System.out.println("5. Удалить всех");
        System.out.println("---------------JDBC------------------------");
        System.out.println("6. Создать таблицу");
        System.out.println("7. Удалить таблицу");
        System.out.println("8. Добавить 4 чел.");
        System.out.println("9. Удалить 1 чел");
        System.out.println("10. Удалить всех");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Вы выбрали вариант 1");
                f.createUsersTable();
                break;
            case 2:
                System.out.println("Вы выбрали вариант 2");
                f.dropUsersTable();
                break;
            case 3:
                System.out.println("Вы выбрали вариант 3");
                f.saveUser("Andrey", "Merenko", (byte) 30);
                f.saveUser("Rustam", "Mirusupov", (byte) 35);
                f.saveUser("Sergo", "Kuznecov", (byte) 55);
                f.saveUser("Katy", "Katerok", (byte) 22);
                System.out.println("Список пользователей:");
                f.getAllUsers().forEach(System.out::println);
                break;
            case 4:
                System.out.println("Вы выбрали вариант 4");
                f.removeUserById(1);
                break;
            case 5:
                System.out.println("Вы выбрали вариант 5");
                f.cleanUsersTable();
                break;
            case 6:
                System.out.println("Вы выбрали вариант 6");
                f1.createUsersTable();
                break;
            case 7:
                System.out.println("Вы выбрали вариант 7");
                f1.dropUsersTable();
                break;
            case 8:
                System.out.println("Вы выбрали вариант 8");
                f1.saveUser("Andrey", "Merenko", (byte) 30);
                f1.saveUser("Rustam", "Mirusupov", (byte) 35);
                f1.saveUser("Sergo", "Kuznecov", (byte) 55);
                f1.saveUser("Katy", "Katerok", (byte) 22);
                System.out.println("Список пользователей:");
                f1.getAllUsers().forEach(System.out::println);
                break;
            case 9:
                System.out.println("Вы выбрали вариант 9");
                f1.removeUserById(1);
                break;
            case 10:
                System.out.println("Вы выбрали вариант 10");
                f1.cleanUsersTable();
                break;
            default:
                System.out.println("Неверный выбор. Пожалуйста, выберите число от 1 до 10.");
                break;
        }
        scanner.close();

    }
}

/*

UserServiceImpl userService = new UserServiceImpl(); // создал экземпляр класса UserServiceImpl,реализующий интерфейс userService
        userService.createUsersTable();

        try {

                userService.saveUser("Ivan", "Petrov", (byte) 30);
        userService.saveUser("Petr", "Ivanov", (byte) 25);
        userService.saveUser("Anna", "Gennadievna", (byte) 28);
        userService.saveUser("Maria", "Olegovna", (byte) 22);


        System.out.println("Список пользователей:");
            userService.getAllUsers().forEach(System.out::println);


             } finally {
//userService.cleanUsersTable();
// userService. removeUserById(14);
// userService.cleanUsersTable();
*/