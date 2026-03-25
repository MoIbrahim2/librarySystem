public class PremiumBook extends BookDecorator {
    private static final int EXTRA_BORROW_DAYS = 10;

    public PremiumBook(Book decoratedBook) {
        super(decoratedBook);
    }

    @Override
    public void borrowBook(User user) {
        if (getDecoratedBook() instanceof BorrowAccessPolicy accessPolicy && !accessPolicy.canBorrow(user)) {
            getDecoratedBook().borrowBook(user);
            return;
        }

        super.borrowBook(user);
        System.out.println("Premium access: borrow period is " + getBorrowDurationDays() + " days.");
    }

    @Override
    public int getBorrowDurationDays() {
        return super.getBorrowDurationDays() + EXTRA_BORROW_DAYS;
    }
}
