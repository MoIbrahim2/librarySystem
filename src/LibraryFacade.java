public class LibraryFacade {
    private final LibraryService libraryService;
    private final BookFactory bookFactory;

    public LibraryFacade() {
        this.libraryService = LibraryService.getInstance();
        this.bookFactory = new BookFactory();
    }

    public void addBook(BookType bookType, String title) {
        libraryService.addBook(bookFactory.createBook(bookType, title));
    }

    public void addPremiumBook(BookType bookType, String title) {
        libraryService.addBook(bookFactory.createPremiumBook(bookType, title));
    }

    public void handleBorrowRequest(String title, User user) {
        libraryService.borrowBook(title, user);
    }

    public void handleReturnRequest(String title) {
        libraryService.returnBook(title);
    }
}
