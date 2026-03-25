public class Librarian extends BorrowRequestHandler {
    @Override
    protected boolean canApprove(BorrowRequest request) {
        return request.getRequestedDays() <= 7;
    }

    @Override
    protected void approve(BorrowRequest request, LibraryService libraryService) {
        System.out.println("Librarian approved the borrowing request for: "
                + request.getBookTitle() + " for " + request.getRequestedDays() + " days.");
        libraryService.completeBorrow(request);
    }
}
