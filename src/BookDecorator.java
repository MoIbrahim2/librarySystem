public abstract class BookDecorator extends Book implements Loanable {
    private static final int DEFAULT_BORROW_DAYS = 14;
    private final Book decoratedBook;

    protected BookDecorator(Book decoratedBook) {
        super(decoratedBook.getTitle());
        this.decoratedBook = decoratedBook;
    }

    protected Book getDecoratedBook() {
        return decoratedBook;
    }

    @Override
    public String getTitle() {
        return decoratedBook.getTitle();
    }

    @Override
    public String getAuthorName() {
        return decoratedBook.getAuthorName();
    }

    @Override
    public int getYear() {
        return decoratedBook.getYear();
    }

    @Override
    public boolean isAvailable() {
        return decoratedBook.isAvailable();
    }

    @Override
    public void borrowBook(User user) {
        decoratedBook.borrowBook(user);
    }

    @Override
    public void returnBook() {
        decoratedBook.returnBook();
    }

    @Override
    public int getBorrowDurationDays() {
        return DEFAULT_BORROW_DAYS;
    }
}
