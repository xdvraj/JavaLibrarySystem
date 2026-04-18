public class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean issued;
    private int issuedToMemberId;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.issued = false;
        this.issuedToMemberId = -1;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }

    public int getIssuedToMemberId() {
        return issuedToMemberId;
    }

    public void issueTo(int memberId) {
        issued = true;
        issuedToMemberId = memberId;
    }

    public void returnBook() {
        issued = false;
        issuedToMemberId = -1;
    }
}
