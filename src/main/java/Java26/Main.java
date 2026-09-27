package Java26;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("Library:");
            System.out.println("1. Add Book ");
            System.out.println("2. Register member");
            System.out.println("3. Borrow book");
            System.out.println("4. Return book");
            System.out.println("5. Search book");
            System.out.println("6. Show all books");
            System.out.println("e. Exit");
            System.out.print("Choose an option: ");


            String choice = scanner.nextLine().trim().toLowerCase();

            try {

                switch (choice) {

                    case "1":
                        System.out.print("ISBN: ");
                        String isbn = scanner.nextLine();

                        System.out.print("Title: ");
                        String title = scanner.nextLine();

                        System.out.print("Author: ");
                        String author = scanner.nextLine();

                        library.addBook(
                                new Book(isbn, title, author)
                        );
                        break;

                    case "2":
                        System.out.print("Member ID: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        System.out.print("Name: ");
                        String name = scanner.nextLine();

                        library.addMember(new Member(id, name));
                        break;

                    case "3":
                        System.out.print("ISBN: ");
                        String isbnToBorrow = scanner.nextLine();

                        if (isbnToBorrow.isEmpty()) {
                            System.out.println("ISBN cannot be empty.");
                            break;
                        }

                        System.out.print("Member ID: ");
                        int borrowId = Integer.parseInt(scanner.nextLine());

                        library.borrowBook(isbnToBorrow, borrowId);
                        break;

                    case "4":
                        System.out.print("Book title or author: ");
                        String returnBook = scanner.nextLine();

                        System.out.print("Member ID: ");
                        int returnId = Integer.parseInt(scanner.nextLine());

                        library.returnBook(returnBook, returnId);
                        break;

                    case "5":
                        System.out.print("Search: ");
                        String search = scanner.nextLine();

                        library.searchBook(search);
                        break;

                    case "6":
                        library.showBooks();
                        break;

                    case "e":
                        running = false;
                        System.out.println("Program exited.");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        scanner.close();
    }
}