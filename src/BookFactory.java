public class BookFactory {
    private final ExternalBookJsonAdapter externalBookJsonAdapter = new ExternalBookJsonAdapter();

    public Book createBook(BookType bookType, String title) {
        return switch (bookType) {
            case STANDARD -> new Book(title);
            case PHYSICAL -> new PhysicalBook(title);
            case EBOOK -> new PremiumEBookAccessProxy(new EBook(title));
            case HISTORICAL -> new HistoricalBook(title);
        };
    }

    public Book createPremiumBook(BookType bookType, String title) {
        return new PremiumBook(createBook(bookType, title));
    }

    public Book createBookFromJson(String json) {
        return externalBookJsonAdapter.adapt(json);
    }
}
