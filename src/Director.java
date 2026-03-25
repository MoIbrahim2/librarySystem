public class Director extends BorrowRequestHandler {
    @Override
    protected boolean canApprove(BorrowRequest request) {
        return request.getRequestedDays() >= 15;
    }

    @Override
    protected void approve(BorrowRequest request, LibraryService libraryService) {
        System.out.println("Director approved the borrowing request for: "
                + request.getBookTitle() + " for " + request.getRequestedDays() + " days.");
        libraryService.completeBorrow(request);
    }
}
