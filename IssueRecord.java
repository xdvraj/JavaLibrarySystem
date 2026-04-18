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

    public int getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }
}
