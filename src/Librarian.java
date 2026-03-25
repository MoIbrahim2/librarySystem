public class Librarian extends BorrowRequestHandler {
    @Override
    protected boolean process(BorrowRequest request, LibraryService libraryService) {
        if (libraryService.findBook(request.getBookTitle()) == null) {
            System.out.println("Librarian rejected the request. Book not found: " + request.getBookTitle());
            return false;
        }

        System.out.println("Librarian received the borrowing request for: " + request.getBookTitle());
        return true;
    }
}
