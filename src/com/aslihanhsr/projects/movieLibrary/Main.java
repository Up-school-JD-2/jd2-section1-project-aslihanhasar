package com.aslihanhsr.projects.movieLibrary;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManagement userManagement = new UserManagement();
        MovieManagement movieManagement = new MovieManagement();
        userManagement.generateUsers();
        movieManagement.generateMovies();
        boolean quit = false;
        boolean login = true;
        String startChoice;
        do {
            StringBuilder messageInfo = printStartMessage();
            System.out.println(messageInfo);
            startChoice = String.valueOf(scanner.next().charAt(0));
            if (startChoice.equalsIgnoreCase("d")) {
                System.out.println("------- MOVIES IN THE LIBRARY -------");
                movieManagement.listMovies();
                System.out.println("-------------------------------------");
            } else if (startChoice.equalsIgnoreCase("c")) {
                System.out.println("-------------------------------------");
                userManagement.register();
                System.out.println("-------------------------------------");
            } else if (startChoice.equalsIgnoreCase("l")) {
                System.out.println("-------------------------------------");
                System.out.print("Id : ");
                Long userId = scanner.nextLong();
                System.out.print("Password : ");
                String userPassword = scanner.next();
                boolean successLogin = userManagement.isLoginSuccess(userPassword, userId);
                if (!successLogin) {
                    System.out.println("Invalid id or password. Try Again. ");
                    System.out.println("-------------------------------------");
                } else {
                    System.out.println("You have successfully logged in. ");
                    do {
                        System.out.println(printMenu());
                        int choice = scanner.nextInt();
                        switch (choice) {
                            case 1 -> {
                                System.out.print("Movie Id : ");
                                Long movieId = scanner.nextLong();
                                scanner.nextLine();
                                System.out.print("Movie Name : ");
                                String movieName = scanner.next();
                                System.out.print("Movie Type: ");
                                String movieType = scanner.next();
                                System.out.print("Movie Director : ");
                                String movieDirector = scanner.next();
                                System.out.print("Enter the 3 stars of the movie : ");
                                String[] movieStars = new String[3];
                                for (int i = 0; i < 3; i++) {
                                    movieStars[i] = scanner.next();
                                }
                                System.out.print("Movie Overview : ");
                                String movieOverview = scanner.next();
                                System.out.print("Movie Release Year : ");
                                String movieReleaseYear = scanner.next();
                                Movie movie = new Movie(movieId, movieName, movieType,
                                        movieDirector, movieStars, movieOverview, movieReleaseYear);
                                movieManagement.addMovieToLibrary(movie);
                            }
                            case 2 -> {
                                System.out.print("Enter movie name to search : ");
                                scanner.nextLine();
                                String name = scanner.nextLine();
                                Movie movie = movieManagement.searchMovieByName(name);
                                if (movie == null) {
                                    System.out.println("Movie not exist");
                                    break;
                                }
                                System.out.println(movie);
                            }
                            case 3 -> {
                                System.out.println("------- MOVIES IN THE LIBRARY -------");
                                movieManagement.listMovies();
                                System.out.println("-------------------------------------");
                            }
                            case 4 -> {
                                System.out.print("Enter the id of the movie you want to remove: ");
                                Long movieId = scanner.nextLong();
                                scanner.nextLine();
                                System.out.print("Enter the name of the movie you want to remove: ");
                                String movieName = scanner.nextLine();
                                movieManagement.removeMovieFromLibrary(movieName, movieId);
                            }
                            case 5 -> {
                                scanner.nextLine();
                                System.out.print("Enter the user's full name to search: ");
                                String userFullName = scanner.nextLine();
                                User user = userManagement.searchUserByName(userFullName);
                                if (user == null) {
                                    System.out.println("User not exist");
                                    break;
                                }
                                System.out.println(user);
                            }
                            case 6 -> {
                                System.out.println("------- USERS IN THE LIBRARY -------");
                                userManagement.listUsers();
                                System.out.println("-------------------------------------");
                            }
                            case 7 -> {
                                System.out.print("Enter your id: ");
                                userId = scanner.nextLong();
                                scanner.nextLine();
                                System.out.print("Enter your full name: ");
                                String userFullName = scanner.nextLine();
                                userManagement.removeUserAccount(userFullName, userId);
                                User user = userManagement.searchUserById(userId);
                                if (user == null) {
                                    login = false;
                                }
                            }
                            case 0 -> login = false;
                        }
                    }
                    while (login);
                }
            } else {
                quit = true;
            }
        } while (!quit);
    }

    private static StringBuilder printStartMessage() {
        final StringBuilder sb = new StringBuilder("************ WELCOME TO THE MOVIE LIBRARY ************").append('\n');
        sb.append("-------------------------------------------------------------------------------").append('\n');
        sb.append("We have selected the 10 best movies in the world for your library.").append('\n');
        sb.append("To display, please click \"D\"").append('\n');
        sb.append("To create a new account, please click \"C\" ").append('\n');
        sb.append("Do you have an account? please click \"L\" to login. ").append('\n');
        sb.append("To exit program, please click \"E\"").append('\n');
        sb.append("-------------------------------------------------------------------------------");
        return sb;
    }

    private static StringBuilder printMenu() {
        final StringBuilder sb = new StringBuilder("########## MENU #########").append('\n');
        sb.append("1 - Add movie to the library").append('\n');
        sb.append("2 - Search a movie in the library").append('\n');
        sb.append("3 - List your movies in the library").append('\n');
        sb.append("4 - Remove movie from the library").append('\n');
        sb.append("5 - Search users in the library").append('\n');
        sb.append("6 - List users in the library").append('\n');
        sb.append("7 - Delete your account").append('\n');
        sb.append("0 - Quit").append('\n');
        sb.append("##########################").append('\n');
        sb.append("Enter your choice (0-9) : ");
        return sb;
    }

}