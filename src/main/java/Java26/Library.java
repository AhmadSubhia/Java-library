package Java26;

public class Library {

    private Book[] books = new Book[10];
    private Member[] members = new Member[10];
    private boolean[] borrowed = new boolean[10];
    private int[] borrowedBy = new int[10];

    public Library() {

        members[0] = new Member(1, "Ahmad");
        members[1] = new Member(2, "Oskar");
        members[2] = new Member(3, "Laura");

        for (int i = 0; i < borrowedBy.length; i++) {
            borrowedBy[i] = -1;
        }
    }
private void expandBookArrays() {

        Book[] newBooks = new Book[books.length * 2];
        boolean[] newBorrowed = new boolean[borrowed.length * 2];
        int[] newBorrowedBy = new int[borrowedBy.length * 2];

        for (int i = 0; i < books.length; i++) {
            newBooks[i] = books[i];
            newBorrowed[i] = borrowed[i];
            newBorrowedBy[i] = borrowedBy[i];
        }

        for (int i = borrowedBy.length; i < newBorrowedBy.length; i++) {
            newBorrowedBy[i] = -1;
        }

        books = newBooks;
        borrowed = newBorrowed;
        borrowedBy = newBorrowedBy;
    }
private void expandMemberArray() {

        Member[] newMembers = new Member[members.length * 2];

        for (int i = 0; i < members.length; i++) {
            newMembers[i] = members[i];
        }

        members = newMembers;
    }
 public void addBook(Book book) {

        for (Book b : books) {

            if (b != null && b.isbn().equals(book.isbn())) {
                System.out.println("ISBN already exists.");
                return;
            }
        }

        for (int i = 0; i < books.length; i++) {

            if (books[i] == null) {
                books[i] = book;
                System.out.println("Book added.");
                return;
            }
        }

        expandBookArrays();

        for (int i = 0; i < books.length; i++) {

            if (books[i] == null) {
                books[i] = book;
                System.out.println("Book added.");
                return;
            }
        }
    }
 public void addMember(Member member) {

        for (Member m : members) {

            if (m != null && m.getId() == member.getId()) {
                System.out.println("Member ID already exists.");
                return;
            }
        }

        for (int i = 0; i < members.length; i++) {

            if (members[i] == null) {
                members[i] = member;
                System.out.println("Member registered.");
                return;
            }
        }

        expandMemberArray();

        for (int i = 0; i < members.length; i++) {

            if (members[i] == null) {
                members[i] = member;
                System.out.println("Member registered.");
                return;
            }
        }
    }
 private int findBook(String text) {

        for (int i = 0; i < books.length; i++) {

            if (books[i] != null &&
                    (books[i].title().toLowerCase().contains(text.toLowerCase())
                            || books[i].author().toLowerCase().contains(text.toLowerCase()))) {

                return i;
            }
        }

        return -1;
    }
private int findBookByIsbn(String isbn) {

        for (int i = 0; i < books.length; i++) {

            if (books[i] != null && books[i].isbn().equals(isbn)) {
                return i;
            }
        }

        return -1;
    }
private Member findMember(int id) {

        for (Member member : members) {

            if (member != null && member.getId() == id) {
                return member;
            }
        }

        return null;
    }
 public void searchBook(String text) {

        boolean found = false;

        for (Book book : books) {

            if (book != null &&
                    (book.title().toLowerCase().contains(text.toLowerCase())
                            || book.author().toLowerCase().contains(text.toLowerCase()))) {

                System.out.println(book.title() + " - " + book.author());

                found = true;
            }
        }

        if (!found) {
            System.out.println("No book found.");
        }
    }
 public void borrowBook(String isbn, int memberId) {

        int bookIndex = findBookByIsbn(isbn);
        Member member = findMember(memberId);

        if (bookIndex == -1) {
            System.out.println("Book not found.");
            return;
        }

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        if (borrowed[bookIndex]) {
            System.out.println("Book is already borrowed.");
            return;
        }

        if (!member.canBorrow()) {
            System.out.println("Member cannot borrow more books.");
            return;
        }

        borrowed[bookIndex] = true;
        borrowedBy[bookIndex] = memberId;

        member.setActiveLoans(member.getActiveLoans() + 1);

        System.out.println("Book borrowed.");
    }
public void returnBook(String text, int memberId) {

        int bookIndex = findBook(text);

        if (bookIndex == -1) {
            System.out.println("Book not found.");
            return;
        }

        if (!borrowed[bookIndex]) {
            System.out.println("Book is not borrowed.");
            return;
        }

        if (borrowedBy[bookIndex] != memberId) {
            System.out.println("This book belongs to another member.");
            return;
        }

        Member member = findMember(memberId);

        if (member != null) {
            member.setActiveLoans(member.getActiveLoans() - 1);
        }

        borrowed[bookIndex] = false;
        borrowedBy[bookIndex] = -1;

        System.out.println("Book returned.");
    }
 private void sortBooksByTitle() {

        for (int i = 0; i < books.length - 1; i++) {

            for (int j = 0; j < books.length - 1 - i; j++) {

                if (books[j] != null &&
                        books[j + 1] != null &&
                        books[j].title().compareToIgnoreCase(books[j + 1].title()) > 0) {

                    Book tempBook = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = tempBook;

                    boolean tempBorrowed = borrowed[j];
                    borrowed[j] = borrowed[j + 1];
                    borrowed[j + 1] = tempBorrowed;

                    int tempBorrowedBy = borrowedBy[j];
                    borrowedBy[j] = borrowedBy[j + 1];
                    borrowedBy[j + 1] = tempBorrowedBy;
                }
            }
        }
    }
 public void showBooks() {

        sortBooksByTitle();

        boolean found = false;

        for (int i = 0; i < books.length; i++) {

            if (books[i] != null) {

                found = true;

                System.out.print(
                        books[i].title() + " - " +
                                books[i].author()
                );

                if (borrowed[i]) {

                    System.out.println(
                            " | Borrowed by member: " + borrowedBy[i]
                    );

                } else {

                    System.out.println(" | Available");
                }
            }
        }
        if (!found) {
            System.out.println("No books available.");
        }
    }
}