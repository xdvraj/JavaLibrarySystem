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
            System.out.print("Enter your choice: ");


            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                System.out.print("Enter Book ID: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Book ID should be a number.");
                    scanner.nextLine();
                    continue;
                }
                int bookId = scanner.nextInt();
                scanner.nextLine();

                if (library.findBookById(bookId) != null) {
                    System.out.println("Book with this ID already exists.");
                    continue;
                }

                System.out.print("Enter Book Title: ");
                String title = scanner.nextLine().trim();
                System.out.print("Enter Author Name: ");
                String author = scanner.nextLine().trim();

                if (title.isEmpty() || author.isEmpty()) {
                    System.out.println("Title and author cannot be empty.");
                } else {
                    library.addBook(new Book(bookId, title, author));
                    System.out.println("Book added successfully.");
                }
            } else if (choice == 2) {
                library.viewBooks();
            } else if (choice == 3) {
                System.out.print("Enter Book ID to issue: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Book ID should be a number.");
                    scanner.nextLine();
                    continue;
                }
                int bookId = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter Member ID: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Member ID should be a number.");
                    scanner.nextLine();
                    continue;
                }
                int memberId = scanner.nextInt();
                scanner.nextLine();

                library.issueBook(bookId, memberId);
            } else if (choice == 4) {
                System.out.print("Enter Book ID to return: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Book ID should be a number.");
                    scanner.nextLine();
                    continue;
                }
                int bookId = scanner.nextInt();
                scanner.nextLine();

                library.returnBook(bookId);
            } else if (choice == 5) {
                library.viewIssuedBooks();
            } else if (choice == 6) {
                running = false;
                System.out.println("Exiting system. Goodbye!");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
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
