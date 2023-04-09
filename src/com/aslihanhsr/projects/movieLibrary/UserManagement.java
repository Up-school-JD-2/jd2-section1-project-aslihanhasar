package com.aslihanhsr.projects.movieLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManagement {
    private final List<User> users = new ArrayList<>();

    public void generateUsers() {
        users.add(new User(1L, "Aslıhan Hasar", "asli123", "damage@gmail.com"));
        users.add(new User(2L, "Dila Unus", "dila123", "unus@gmail.com"));
        users.add(new User(3L, "James Gosling", "james123", "gosling@gmail.com"));
        users.add(new User(4L, "Can Bonomo", "can123", "bonomo@gmail.com"));
        users.add(new User(5L, "Paul Rudd", "paul123", "rudd@gmail.com"));
        users.add(new User(6L, "Andy Samberg", "andy123", "samberg@gmail.com"));
        users.add(new User(7L, "Ozan Toktop", "ozan123", "toktop@gmail.com"));
    }

    public void createUserAccount(User user) {
        long id = user.getUserId();
        User searchedUser = searchUserById(id);
        if (searchedUser != null) {
            System.out.println("Account already exists. Change id.");
            return;
        }
        users.add(user);
        System.out.println("Account has been created.");

    }

    public void removeUserAccount(String userName, Long userId) {
        User searchedUser = searchUserByName(userName);
        if (searchedUser == null) {
            System.out.println("Invalid name and surname.");
            return;
        }
        searchedUser = searchUserById(userId);
        if (searchedUser == null) {
            System.out.println("Mismatch user name and id.");
            return;
        }
        users.remove(searchedUser);
        System.out.println("Account has been deleted.");
    }

    public User searchUserById(Long id) {
        User user = null;
        for (User u : users) {
            if (u.getUserId().equals(id)) {
                user = u;
            }
        }
        return user;
    }

    public User searchUserByName(String name) {
        User searchedUser = null;
        for (User user : users) {
            if (user.getUserFullName().equalsIgnoreCase(name)) {
                searchedUser = user;
            }
        }
        return searchedUser;
    }

    public void listUsers() {
        System.out.println(users);
    }

    public void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id : ");
        Long userId = scanner.nextLong();
        System.out.print("Full name : ");
        scanner.nextLine();
        String userFullName = scanner.nextLine();
        System.out.print("Password : ");
        String userPassword = scanner.nextLine();
        System.out.print("E mail : ");
        String userEmail = scanner.nextLine();
        User user = new User(userId, userFullName, userPassword, userEmail);
        createUserAccount(user);
    }

    public boolean isLoginSuccess(String userPassword, Long userId) {
        User user = searchUserById(userId);
        if (user == null) {
            return false;
        }
        return user.getUserPassword().equals(userPassword);
    }
}
