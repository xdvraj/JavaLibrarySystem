import java.util.ArrayList;
public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;
    private ArrayList<IssueRecord> issues;
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
    public void bookList() {
        if (books.isEmpty()) {
            System.out.println("Shelf is empty.");
            return;
        }
        System.out.println("\n--- Shelf Books ---");
        for (Book b : books) {
            String s;
            if (b.issued()) {
                s = "Issued to member ID " + b.member();
            } else {
                s = "Available";
            }
            System.out.println("ID: " + b.id() + ", Title: " + b.title() + ", Author: " + b.author() + ", Status: " + s);
        }
    }
    public boolean hasBook(int id) {
        for (Book b : books) {
            if (b.id() == id) {
                return true;
            }
        }
        return false;
    }
    public boolean giveBook(int bookId, int memberId) {
        Book b = null;
        Member m = null;
        for (Book x : books) {
            if (x.id() == bookId) {
                b = x;
                break;
            }
        }
        for (Member x : members) {
            if (x.id() == memberId) {
                m = x;
                break;
            }
        }
        if (b == null) {
            System.out.println("Book id missing.");
            return false;
        }
        if (m == null) {
            System.out.println("Member id missing.");
            return false;
        }
        if (b.issued()) {
            System.out.println("Book already out.");
            return false;
        }
        b.out(memberId);
        issues.add(new IssueRecord(b.id(), b.title(), m.id(), m.name()));
        System.out.println("Given to " + m.name() + ".");
        return true;
    }
    public boolean takeBook(int bookId) {
        Book b = null;
        for (Book x : books) {
            if (x.id() == bookId) {
                b = x;
                break;
            }
        }
        if (b == null) {
            System.out.println("Book id missing.");
            return false;
        }
        if (!b.issued()) {
            System.out.println("Book not issued.");
            return false;
        }
        int idx = -1;
        for (int i = 0; i < issues.size(); i++) {
            if (issues.get(i).book() == bookId) {
                idx = i;
                break;
            }
        }
        if (idx != -1) {
            issues.remove(idx);
        }
        b.back();
        System.out.println("Returned to shelf.");
        return true;
    }
    public void loanList() {
        if (issues.isEmpty()) {
            System.out.println("No active loans.");
            return;
        }
        System.out.println("\n--- Loan List ---");
        for (IssueRecord r : issues) {
            System.out.println("Book: " + r.title() + " (ID: " + r.book() + ") -> Issued to: " + r.name() + " (Member ID: " + r.member() + ")");
        }
    }
}
