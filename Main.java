import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library data = new Library();
        data.addMember(new Member(1, "Arth"));
        data.addMember(new Member(2, "Vinay"));
        data.addMember(new Member(3, "Satvik"));
        data.addMember(new Member(4, "Nishant"));
        data.addMember(new Member(5, "Manvir"));
        boolean running = true;
        while (running) {
            // simple menu
            System.out.println("\nLibrary Desk");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Issued Books");
            System.out.println("6. Exit");
            System.out.print("option: ");
            int cmd;
            try {
                cmd = Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println("number only");
                continue;
            }
            if (cmd == 1) {
                System.out.print("new book id: ");
                int bookId;
                try {
                    bookId = Integer.parseInt(scanner.nextLine().trim());
                } catch (Exception e) {
                    System.out.println("wrong id");
                    continue;
                }
                if (data.hasBook(bookId)) {
                    System.out.println("id already used");
                    continue;
                }
                System.out.print("book title: ");
                String title = scanner.nextLine().trim();
                System.out.print("author name: ");
                String author = scanner.nextLine().trim();
                if (title.isEmpty() || author.isEmpty()) {
                    System.out.println("fill both");
                    continue;
                }
                data.addBook(new Book(bookId, title, author));
                System.out.println("book saved");
            } else if (cmd == 2) {
                data.bookList();
            } else if (cmd == 3) {
                System.out.print("book id: ");
                int bookId;
                try {
                    bookId = Integer.parseInt(scanner.nextLine().trim());
                } catch (Exception e) {
                    System.out.println("wrong book id");
                    continue;
                }
                System.out.print("member id: ");
                int memberId;
                try {
                    memberId = Integer.parseInt(scanner.nextLine().trim());
                } catch (Exception e) {
                    System.out.println("wrong member id");
                    continue;
                }
                data.giveBook(bookId, memberId);
            } else if (cmd == 4) {
                System.out.print("book id: ");
                int bookId;
                try {
                    bookId = Integer.parseInt(scanner.nextLine().trim());
                } catch (Exception e) {
                    System.out.println("wrong book id");
                    continue;
                }
                data.takeBook(bookId);
            } else if (cmd == 5) {
                data.loanList();
            } else if (cmd == 6) {
                running = false;
                System.out.println("bye");
            } else {
                System.out.println("wrong option");
            }
        }
        scanner.close();
    }
}
