public abstract class BorrowRequestHandler {
    private BorrowRequestHandler nextHandler;

    public BorrowRequestHandler setNext(BorrowRequestHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public void handle(BorrowRequest request, LibraryService libraryService) {
        if (canApprove(request)) {
            approve(request, libraryService);
            return;
        }

        if (nextHandler != null) {
            nextHandler.handle(request, libraryService);
            return;
        }

        System.out.println("No approver is available for " + request.getRequestedDays() + " requested days.");
    }

    protected abstract boolean canApprove(BorrowRequest request);

    protected abstract void approve(BorrowRequest request, LibraryService libraryService);
}
