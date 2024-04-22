package com.ps;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Creating books
        Book book1 = new Book(1, "1435158695", "The Art of War", true, "Tony");
        Book book2 = new Book(2, "1590309847", "The Book of Five Rings", true, "Jeremy");
        Book book3 = new Book(3, "00553418033", "Fast Food Maniac", true, "Jeremy");
        Book book4 = new Book(4, "1975314212", "Three Days of Happiness", true, "Jeremy");
        Book book5 = new Book(5, "9781975303129", "86—EIGHTY-SIX, Vol. 1", false, "");
        Book book6 = new Book(6, "9781250866448", "Friends, Lovers, and the Big Terrible Thing", false, "");
        Book book7 = new Book(7, "9781974734641", "Look Back", true, "Jeremy");
        Book book8 = new Book(8, "9781646512492", "A Silent Voice Complete Collector's Edition 1", true, "Jeremy");
        Book book9 = new Book(9, "9781646514069", "A Silent Voice Complete Collector's Edition 2", true, "Jeremy");
        Book book10 = new Book(10, "9781632366436", "A Silent Voice Complete Series Box Set", true, "");
        Book book11 = new Book(11, "9781637742617", "Tremendous", true, "Jeremy");
        Book book12 = new Book(12, "9780399592096", "The Ride of a Lifetime: Lessons Learned from 15 Years as CEO of the Walt Disney Company", true, "Jeremy");
        Book book13 = new Book(13, "9780525478812", "The Fault in Our Stars", true, "Jeremy");
        Book book14 = new Book(14, "9780765367297", "Halo: The Fall of Reach", true, "Jeremy");
        Book book15 = new Book(15, "9781789092615", "Gears of War: Ascendance", true, "Jeremy");
        Book book16 = new Book(16, "9781421561325", "Uzumaki", true, "Jeremy");
        Book book17 = new Book(17, "9781645059998", "My Alcoholic Escape from Reality", true, "Jeremy");
        Book book18 = new Book(18, "9780316254205", "Kingdom Hearts: Final Mix, Vol. 1 - manga", true, "Jeremy");
        Book book19 = new Book(19, "9780316254212", "Kingdom Hearts: Final Mix Vol. 2", true, "Jeremy");
        Book book20 = new Book(20, "9781501194290", "Howard Stern Comes Again", false, "");
        Book book21 = new Book(21, "9780316512442", "The Saga of Tanya the Evil, Vol. 1: Deus lo Vult", true, "Jeremy");
        Book book22 = new Book(22, "9780316512466", "The Saga of Tanya the Evil, Vol. 2: Plus Ultra", true, "Jeremy");
        Book book23 = new Book(23, "9780316512480", "The Saga of Tanya the Evil, Vol. 3: The Finest Hour", true, "Jeremy");
        Book book24 = new Book(24, "9780316560627", "The Saga of Tanya the Evil, Vol. 4: Dabit Deus his Quoque Finem", false, "");
        Book book25 = new Book(25, "9781250183866", "Extreme Ownership: How U.S. Navy SEALs Lead and Win", true, "Jeremy");
        Book book26 = new Book(26, "1451627289", "11/22/63: A Novel", false, "");
        Book book27 = new Book(27, "1982173610", "Billy Summers", false, "");
        Book book28 = new Book(28, "150114426X", "The Long Walk", false, "");



        //Storing books in array
        Book[] bookInventory = {book1,book2, book3, book4, book5, book6, book7, book8, book9, book10, book11, book12, book13, book14, book15, book16, book17, book18, book19, book20, book21, book21, book23, book24, book25, book26, book27, book28};


        int command;

        // Creating menu in do/while loop
        do {
            // Greeting user and prompting options
            System.out.println("Welcome to the Library");
            System.out.println("Please select an option: ");
            System.out.println("\t1) Show available books");
            System.out.println("\t2) Show checked out books");
            System.out.println("\t3) Exit");

            // Creating input for user
            Scanner scanner = new Scanner(System.in);
            command = Integer.parseInt(scanner.nextLine().trim());

            switch (command) {
                case 1:
                        //Displays list of all the available books
                    System.out.println("Here are all the available books: ");
                    for (Book availableBook : bookInventory) {
                        if (!availableBook.getIsCheckedOut()) {
                            System.out.println(availableBook);
                        }
                    }
                        //Ask the user if they want to check out a book or go back to the home screen
                    System.out.println("Would you like to check out a book?");
                    System.out.println("\t1) Yes");
                    System.out.println("\t2) No, go back to home screen");
                    int checkoutOption = Integer.parseInt(scanner.nextLine().trim());

                    switch (checkoutOption) {
                        case 1:
                            boolean validBookId = false;
                            do {
                                System.out.println("Please enter the ID of the book you want to check out (or 0 to go back):");
                                int bookIdToCheckout = Integer.parseInt(scanner.nextLine().trim());

                                if (bookIdToCheckout == 0) {
                                    break;  //Go back to main menu
                                }

                                for (Book book : bookInventory) {
                                    if (book.getId() == bookIdToCheckout && !book.getIsCheckedOut()) {
                                        System.out.println("Please enter your name to check out the book:");
                                        String borrowerName = scanner.nextLine().trim();

                                        if (book.checkOut(borrowerName)) {
                                            System.out.println("Successfully checked out to " + borrowerName);
                                        } else {
                                            System.out.println("Book is already checked out.");
                                        }
                                        validBookId = true;
                                        break; //Exit the loop after checking out
                                    }
                                }

                                if (!validBookId) {
                                    System.out.println("Command not found.");
                                }
                            } while (!validBookId);
                            break;
                        case 2:
                            break;  //Go back to main menu
                        default:
                            System.out.println("Command not found.");
                            break;
                    }
                    break;
                case 2:
                        //Displays list of all books checked out
                    System.out.println("Here are all books currently checked out: ");
                    boolean hasCheckedOutBooks = false;
                    for (Book checkedOutBook : bookInventory) {
                        if (checkedOutBook.getIsCheckedOut()) {
                            System.out.println(checkedOutBook);
                            hasCheckedOutBooks = true;
                        }
                    }

                    if (!hasCheckedOutBooks) {
                        System.out.println("No books are currently checked out.");
                        break;
                    }

                    System.out.println("Please select an option:");
                    System.out.println("\tC) Check In a book");
                    System.out.println("\tX) Go back to home screen");
                    String checkInOption = scanner.nextLine().toUpperCase();

                    switch (checkInOption) {
                        case "C":
                            System.out.println("Please enter the ID of the book you want to check in:");
                            int bookIdToCheckIn = Integer.parseInt(scanner.nextLine().trim());

                            for (Book book : bookInventory) {
                                if (book.getId() == bookIdToCheckIn && book.getIsCheckedOut()) {
                                    book.checkIn();
                                    System.out.println("Book  ID " + bookIdToCheckIn + " has been returned and checked in.");
                                    break;
                                }
                            }
                            break;
                        case "X":
                            break;  //Go back to main menu
                        default:
                            System.out.println("Command not found.");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Thank you for visiting the library!");
                    break;
                default:
                    System.out.println("Command not found.");
            }
        } while (command != 3);
    }
}