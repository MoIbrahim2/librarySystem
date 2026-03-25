public class Main {
    public static void main(String[] args) {
        LibraryFacade libraryFacade = new LibraryFacade();

        libraryFacade.addBook(BookType.PHYSICAL, "Harry Potter");
        libraryFacade.addBook(BookType.HISTORICAL, "Lord of the Rings");
        libraryFacade.addPremiumBook(BookType.EBOOK, "Clean Code");

        User premiumUser = new User("John", true);
        User regularUser = new User("Mike", false);

        libraryFacade.handleBorrowRequest("Clean Code", premiumUser);
        libraryFacade.handleBorrowRequest("Clean Code", regularUser);
    }
}
