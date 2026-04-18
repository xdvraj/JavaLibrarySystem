public class IssueRecord {
    private int bookId;
    private String title;
    private int memberId;
    private String name;

    public IssueRecord(int bookId, String title, int memberId, String name) {
        this.bookId = bookId;
        this.title = title;
        this.memberId = memberId;
        this.name = name;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }
}
