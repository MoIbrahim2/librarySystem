public class Main {
    public static void main(String[] args) {
        LibraryFacade libraryFacade = new LibraryFacade();
        String externalBookJson = "{\n"
                + "  \"bookTitle\": \"Design Patterns\",\n"
                + "  \"isBorrowable\": true,\n"
                + "  \"authorName\": \"Erich Gamma\",\n"
                + "  \"year\": 1994\n"
                + "}";

        libraryFacade.addBook(BookType.PHYSICAL, "Harry Potter");
        libraryFacade.addBook(BookType.HISTORICAL, "Lord of the Rings");
        libraryFacade.addPremiumBook(BookType.EBOOK, "Clean Code");
        libraryFacade.addExternalBook(externalBookJson);

        User premiumUser = new User("John", true);
        User regularUser = new User("Mike", false);

        libraryFacade.handleBorrowRequest("Harry Potter", regularUser, 7);
        libraryFacade.handleBorrowRequest("Clean Code", premiumUser, 14);
        libraryFacade.handleBorrowRequest("Design Patterns", regularUser, 21);
        libraryFacade.handleBorrowRequest("Clean Code", regularUser, 5);
    }
}
