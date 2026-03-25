public class BorrowRequest {
    private final String bookTitle;
    private final User user;

    public BorrowRequest(String bookTitle, User user) {
        this.bookTitle = bookTitle;
        this.user = user;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public User getUser() {
        return user;
    }
}
