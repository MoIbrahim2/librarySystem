public class Manager extends BorrowRequestHandler {
    @Override
    protected boolean canApprove(BorrowRequest request) {
        return request.getRequestedDays() <= 14;
    }

    @Override
    protected void approve(BorrowRequest request, LibraryService libraryService) {
        System.out.println("Manager approved the borrowing request for: "
                + request.getBookTitle() + " for " + request.getRequestedDays() + " days.");
        libraryService.completeBorrow(request);
    }
}
