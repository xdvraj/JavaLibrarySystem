import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library lib = new Library();
        lib.addMember(new Member(1, "Arth"));
        lib.addMember(new Member(2, "Vinay"));
        lib.addMember(new Member(3, "Satvik"));
        lib.addMember(new Member(4, "Nishant"));
        lib.addMember(new Member(5, "Manvir"));
        boolean running = true;
        while (running) {
            showHome();
            int cmd = readMenuCmd(scanner);
            running = doCmd(lib, scanner, cmd);
        }
        scanner.close();
    }
    private static boolean doCmd(Library lib, Scanner scanner, int cmd) {
        if (cmd == 1) {
            int bookId = askBookId(scanner, "Enter new book id: ");
            if (lib.getBook(bookId) != null) {
                System.out.println("Book id already used.");
                return true;
            }
            System.out.print("Book title: ");
            String title = scanner.nextLine().trim();
            System.out.print("Author name: ");
            String author = scanner.nextLine().trim();
            if (title.isEmpty() || author.isEmpty()) {
                System.out.println("Title/author needed.");
                return true;
            }
            lib.addBook(new Book(bookId, title, author));
            System.out.println("Book saved.");
            return true;
        }
        if (cmd == 2) {
            lib.showBooks();
            return true;
        }
        if (cmd == 3) {
            int bookId = askBookId(scanner, "Book id to issue: ");
            int memberId = askMemberId(scanner, "Member id: ");
            lib.lendBook(bookId, memberId);
            return true;
        }
        if (cmd == 4) {
            int bookId = askBookId(scanner, "Book id to return: ");
            lib.receiveBook(bookId);
            return true;
        }
        if (cmd == 5) {
            lib.showLoans();
            return true;
        }
        if (cmd == 6) {
            System.out.println("Bye.");
            return false;
        }
        System.out.println("Wrong menu number.");
        return true;
    }
    private static int readMenuCmd(Scanner scanner) {
        while (true) {
            System.out.print("Pick option: ");
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); // clear line
                return value;
            }
            System.out.println("Only numbers.");
            scanner.nextLine();
        }
    }
    private static int askBookId(Scanner scanner, String msg) {
        while (true) {
            System.out.print(msg);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); // clear line
                return value;
            }
            System.out.println("Book id number.");
            scanner.nextLine();
        }
    }
    private static int askMemberId(Scanner scanner, String msg) {
        while (true) {
            System.out.print(msg);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); // clear line
                return value;
            }
            System.out.println("Member id number.");
            scanner.nextLine();
        }
    }
    private static void showHome() {
        System.out.println("\nLibrary Desk");
        System.out.println("1. Add Book");
        System.out.println("2. View Books");
        System.out.println("3. Issue Book");
        System.out.println("4. Return Book");
        System.out.println("5. View Issued Books");
        System.out.println("6. Exit");
    }
}
