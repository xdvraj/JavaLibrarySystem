import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;
    private ArrayList<IssueRecord> issueRecords;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        issueRecords = new ArrayList<>();
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
                status = "Issued to member ID " + book.getIssuedToMemberId();
            } else {
                status = "Available";
            }

            System.out.println("ID: " + book.getBookId()
                    + ", Title: " + book.getTitle()
                    + ", Author: " + book.getAuthor()
                    + ", Status: " + status);
        }
    }

    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
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
        issueRecords.add(new IssueRecord(
                book.getBookId(),
                book.getTitle(),
                member.getMemberId(),
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

        // Basic return logic
        int indexToRemove = -1;
        for (int i = 0; i < issueRecords.size(); i++) {
            if (issueRecords.get(i).getBookId() == bookId) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1) {
            issueRecords.remove(indexToRemove);
        }

        book.returnBook();
        System.out.println("Book returned successfully.");
        return true;
    }

    public void viewIssuedBooks() {
        if (issueRecords.isEmpty()) {
            System.out.println("No books are currently issued.");
            return;
        }

        System.out.println("\n--- Issued Books Details ---");
        for (IssueRecord record : issueRecords) {
            System.out.println("Book: " + record.getBookTitle()
                    + " (ID: " + record.getBookId() + ")"
                    + " -> Issued to: " + record.getMemberName()
                    + " (Member ID: " + record.getMemberId() + ")");
        }
    }
}
