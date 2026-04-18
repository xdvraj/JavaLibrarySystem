import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        library.addMember(new Member(1, "Arth"));
        library.addMember(new Member(2, "Vinay"));
        library.addMember(new Member(3, "Satvik"));
        library.addMember(new Member(4, "Nishant"));
        library.addMember(new Member(5, "Manvir"));

        boolean running = true;

        while (running) {
            printMenu();
            int option = readInt(scanner, "choice");
            running = handleOption(library, scanner, option);
        }

        scanner.close();
    }

    private static boolean handleOption(Library library, Scanner scanner, int option) {
        if (option == 1) {
            int bookId = readInt(scanner, "book id");

            if (library.findBookById(bookId) != null) {
                System.out.println("Book with this ID already exists.");
                return true;
            }

            System.out.print("Enter Book Title: ");
            String title = scanner.nextLine().trim();
            System.out.print("Enter Author Name: ");
            String author = scanner.nextLine().trim();

            if (title.isEmpty() || author.isEmpty()) {
                System.out.println("Title and author cannot be empty.");
                return true;
            }

            library.addBook(new Book(bookId, title, author));
            System.out.println("Book added successfully.");
            return true;
        }

        if (option == 2) {
            library.viewBooks();
            return true;
        }

        if (option == 3) {
            int bookId = readInt(scanner, "book id");
            int memberId = readInt(scanner, "member id");
            library.issueBook(bookId, memberId);
            return true;
        }

        if (option == 4) {
            int bookId = readInt(scanner, "book id");
            library.returnBook(bookId);
            return true;
        }

        if (option == 5) {
            library.viewIssuedBooks();
            return true;
        }

        if (option == 6) {
            System.out.println("Exiting system. Goodbye!");
            return false;
        }

        System.out.println("Invalid choice. Please try again.");
        return true;
    }

    private static int readInt(Scanner scanner, String label) {
        while (true) {
            System.out.print("Enter " + label + ": ");
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); // clear line
                return value;
            }

            System.out.println("Please enter a valid " + label + ".");
            scanner.nextLine();
        }
    }

    private static void printMenu() {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Add Book");
        System.out.println("2. View Books");
        System.out.println("3. Issue Book");
        System.out.println("4. Return Book");
        System.out.println("5. View Issued Books");
        System.out.println("6. Exit");
    }
}
