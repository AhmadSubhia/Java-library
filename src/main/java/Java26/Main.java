package Java26;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("Bibliotaket");
            System.out.println("1. Lägg till bok");
            System.out.println("2. Registera medlem");
            System.out.println("3. Låna bok");
            System.out.println("4.  Lämna till bok");
            System.out.println("5. sök bok");
            System.out.println("6. visa alla böcker");
            System.out.println("e. Avsluta");
            System.out.print("Välje: ");


            String choice = scanner.nextLine().trim().toLowerCase();

            try {

                switch (choice) {

                    case "1":
                        System.out.print("ISBN: ");
                        String isbn = scanner.nextLine();

                        System.out.print("Rubrik: ");
                        String title = scanner.nextLine();

                        System.out.print("Författare: ");
                        String author = scanner.nextLine();

                        library.addBook(
                                new Book(isbn, title, author)
                        );
                        break;

                    case "2":
                        System.out.print("Medlem ID: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        System.out.print("Namn: ");
                        String name = scanner.nextLine();

                        library.addMember(
                                new Member(id, name)
                        );
                        break;

                    case "3":
                        System.out.print("Bokens Rubrik eller författare: ");
                        String borrowBook = scanner.nextLine();

                        System.out.print("Medlem ID: ");
                        int borrowId = Integer.parseInt(scanner.nextLine());

                        library.borrowBook(borrowBook, borrowId);
                        break;

                    case "4":
                        System.out.print("Bokens Rubrik eller författare: ");
                        String returnBook = scanner.nextLine();

                        System.out.print("Medlem ID: ");
                        int returnId = Integer.parseInt(scanner.nextLine());

                        library.returnBook(returnBook, returnId);
                        break;

                    case "5":
                        System.out.print("Sök: ");
                        String search = scanner.nextLine();

                        library.searchBook(search);
                        break;

                    case "6":
                        library.showBooks();
                        break;

                    case "e":
                        running = false;
                        System.out.println("Program Avslutad.");
                        break;

                    default:
                        System.out.println("Ogiltigt val.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Ange ett giltigt nummer.");
            }
        }

        scanner.close();
    }
}