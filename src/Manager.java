public class Manager extends BorrowRequestHandler {
    @Override
    protected boolean process(BorrowRequest request, LibraryService libraryService) {
        System.out.println("Manager approved the borrowing request for: " + request.getBookTitle());
        libraryService.completeBorrow(request);
        return true;
    }
}
