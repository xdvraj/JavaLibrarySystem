public class Book {
    private int id;
    private String title;
    private String author;
    private boolean issued;
    private int memberId;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
        this.memberId = -1;
    }

    public int getId() {
        return id;
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

    public int getMemberId() {
        return memberId;
    }

    public void issueTo(int memberId) {
        issued = true;
        this.memberId = memberId;
    }

    public void markReturned() {
        issued = false;
        memberId = -1;
    }
}
