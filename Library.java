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

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library right now.");
            return;
        }

        System.out.println("\n--- Book List ---");
        for (Book book : books) {
            String status;
            if (book.isIssued()) {
                status = "Issued to member ID " + book.getMemberId();
            } else {
                status = "Available";
            }

            System.out.println("ID: " + book.getId()
                    + ", Title: " + book.getTitle()
                    + ", Author: " + book.getAuthor()
                    + ", Status: " + status);
        }
    }

    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getId() == memberId) {
                return member;
            }
        }
        return null;
    }

    public boolean issueBook(int bookId, int memberId) {
        Book book = findBookById(bookId);
        Member member = findMemberById(memberId);

        if (book == null) {
            System.out.println("Book ID not found.");
            return false;
        }

        if (member == null) {
            System.out.println("Member ID not found.");
            return false;
        }

        if (book.isIssued()) {
            System.out.println("Book is already issued.");
            return false;
        }

        book.issueTo(memberId);
        issues.add(new IssueRecord(
                book.getId(),
                book.getTitle(),
                member.getId(),
                member.getName()
        ));
        System.out.println("Book issued to " + member.getName() + ".");
        return true;
    }

    public boolean returnBook(int bookId) {
        Book book = findBookById(bookId);

        if (book == null) {
            System.out.println("Book ID not found.");
            return false;
        }

        if (!book.isIssued()) {
            System.out.println("This book was not issued.");
            return false;
        }

        removeIssue(bookId);

        book.markReturned();
        System.out.println("Book returned successfully.");
        return true;
    }

    public void viewIssuedBooks() {
        if (issues.isEmpty()) {
            System.out.println("No books are currently issued.");
            return;
        }

        System.out.println("\n--- Issued Books Details ---");
        for (IssueRecord issue : issues) {
            System.out.println("Book: " + issue.getTitle()
                    + " (ID: " + issue.getBookId() + ")"
                    + " -> Issued to: " + issue.getName()
                    + " (Member ID: " + issue.getMemberId() + ")");
        }
    }

    private void removeIssue(int bookId) {
        int foundIndex = -1;
        for (int i = 0; i < issues.size(); i++) {
            if (issues.get(i).getBookId() == bookId) {
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
