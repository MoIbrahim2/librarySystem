public abstract class BorrowRequestHandler {
    private BorrowRequestHandler nextHandler;

    public BorrowRequestHandler setNext(BorrowRequestHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public void handle(BorrowRequest request, LibraryService libraryService) {
        boolean shouldContinue = process(request, libraryService);

        if (shouldContinue && nextHandler != null) {
            nextHandler.handle(request, libraryService);
        }
    }

    protected abstract boolean process(BorrowRequest request, LibraryService libraryService);
}
