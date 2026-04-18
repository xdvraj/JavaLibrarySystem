public class IssueRecord {
    private int bookId;
    private String bookTitle;
    private int memberId;
    private String memberName;
    public IssueRecord(int bookId, String bookTitle, int memberId, String memberName) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.memberId = memberId;
        this.memberName = memberName;
    }
    public int book() {
        return bookId;
    }
    public String title() {
        return bookTitle;
    }
    public int member() {
        return memberId;
    }
    public String name() {
        return memberName;
    }
}
