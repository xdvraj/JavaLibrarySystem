import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> books;
    private final ArrayList<Member> members;
    private final ArrayList<IssueRecord> issues;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        issues = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("Shelf is empty.");
            return;
        }
        System.out.println("\n--- Shelf Books ---");
        for (Book book : books) {
            String status;
            if (book.issued()) {
                status = "Issued to member ID " + book.member();
            } else {
                status = "Available";
            }
            System.out.println("ID: " + book.id()
                    + ", Title: " + book.title()
                    + ", Author: " + book.author()
                    + ", Status: " + status);
        }
    }
    public Book getBook(int bookId) {
        for (Book book : books) {
            if (book.id() == bookId) {
                return book;
            }
        }
        return null;
    }
    public Member getMember(int memberId) {
        for (Member member : members) {
            if (member.id() == memberId) {
                return member;
            }
        }
        return null;
    }

    public boolean lendBook(int bookId, int memberId) {
        Book book = getBook(bookId);
        Member member = getMember(memberId);
        if (book == null) {
            System.out.println("Book id missing.");
            return false;
        }
        if (member == null) {
            System.out.println("Member id missing.");
            return false;
        }
        if (book.issued()) {
            System.out.println("Book already out.");
            return false;
        }
        book.lendTo(memberId);
        issues.add(new IssueRecord(
                book.id(),
                book.title(),
                member.id(),
                member.name()
        ));
        System.out.println("Given to " + member.name() + ".");
        return true;
    }
    public boolean receiveBook(int bookId) {
        Book book = getBook(bookId);
        if (book == null) {
            System.out.println("Book id missing.");
            return false;
        }
        if (!book.issued()) {
            System.out.println("Book not issued.");
            return false;
        }
        removeIssue(bookId);
        book.markReturned();
        System.out.println("Returned to shelf.");
        return true;
    }

    public void showLoans() {
        if (issues.isEmpty()) {
            System.out.println("No active loans.");
            return;
        }
        System.out.println("\n--- Loan List ---");
        for (IssueRecord issue : issues) {
            System.out.println("Book: " + issue.title()
                    + " (ID: " + issue.book() + ")"
                    + " -> Issued to: " + issue.name()
                    + " (Member ID: " + issue.member() + ")");
        }
    }
    private void removeIssue(int bookId) {
        int foundIndex = -1;
        for (int i = 0; i < issues.size(); i++) {
            if (issues.get(i).book() == bookId) {
                foundIndex = i;
                break;
            }
        }
        // remove match
        if (foundIndex != -1) {
            issues.remove(foundIndex);
        }
    }
}
