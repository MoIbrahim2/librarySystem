public class PremiumEBookAccessProxy extends Book implements BorrowAccessPolicy {
    private final Book eBook;

    public PremiumEBookAccessProxy(Book eBook) {
        super(eBook.getTitle());
        this.eBook = eBook;
    }

    @Override
    public String getTitle() {
        return eBook.getTitle();
    }

    @Override
    public String getAuthorName() {
        return eBook.getAuthorName();
    }

    @Override
    public int getYear() {
        return eBook.getYear();
    }

    @Override
    public boolean isAvailable() {
        return eBook.isAvailable();
    }

    @Override
    public void borrowBook(User user) {
        if (!canBorrow(user)) {
            System.out.println("Premium membership is required to borrow the e-book: " + getTitle());
            return;
        }

        eBook.borrowBook(user);
    }

    @Override
    public void returnBook() {
        eBook.returnBook();
    }

    @Override
    public boolean canBorrow(User user) {
        return user.isPremium();
    }
}
