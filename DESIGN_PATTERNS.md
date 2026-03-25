# Library System Requirements and Patterns

## Requirement 1
Create only one `LibraryService` to manage books.

- Pattern used: `Singleton`
- Solution: [src/LibraryService.java](/Volumes/work/librarySystem/src/LibraryService.java) exposes one shared instance through `getInstance()` and hides its constructor.

## Requirement 2
Separate the logic of creating different types of books outside the main code.

- Pattern used: `Factory Method` / simple `Factory`
- Solution: [src/BookFactory.java](/Volumes/work/librarySystem/src/BookFactory.java) creates `STANDARD`, `PHYSICAL`, `EBOOK`, and `HISTORICAL` books based on [src/BookType.java](/Volumes/work/librarySystem/src/BookType.java).

## Requirement 3
Create a `PremiumBook` that allows an extra 10 days for borrowing without modifying the book entity.

- Pattern used: `Decorator`
- Solution: [src/PremiumBook.java](/Volumes/work/librarySystem/src/PremiumBook.java) wraps any `Book` through [src/BookDecorator.java](/Volumes/work/librarySystem/src/BookDecorator.java) and increases the borrow duration from 14 to 24 days.

## Requirement 4
Make premium access for `EBooks`.

- Pattern used: `Proxy`
- Solution: [src/PremiumEBookAccessProxy.java](/Volumes/work/librarySystem/src/PremiumEBookAccessProxy.java) wraps an `EBook` and blocks borrowing unless `user.isPremium()` is `true`.

## Requirement 5
Book borrowing requests go through `Librarian -> Manager`.

- Pattern used: `Chain of Responsibility`
- Solution: [src/BorrowRequestHandler.java](/Volumes/work/librarySystem/src/BorrowRequestHandler.java) defines the chain, [src/Librarian.java](/Volumes/work/librarySystem/src/Librarian.java) receives and validates the request, and [src/Manager.java](/Volumes/work/librarySystem/src/Manager.java) approves it before the borrow is completed.

## Requirement 6
Simplify the library operations handling book borrowing requests.

- Pattern used: `Facade`
- Solution: [src/LibraryFacade.java](/Volumes/work/librarySystem/src/LibraryFacade.java) provides a single entry point for adding books, adding premium books, borrowing, and returning, while hiding the internal coordination between `LibraryService`, `BookFactory`, the borrow chain, the proxy, and the decorator.

## Current Pattern Map

- `Singleton`: [src/LibraryService.java](/Volumes/work/librarySystem/src/LibraryService.java)
- `Factory`: [src/BookFactory.java](/Volumes/work/librarySystem/src/BookFactory.java)
- `Decorator`: [src/BookDecorator.java](/Volumes/work/librarySystem/src/BookDecorator.java), [src/PremiumBook.java](/Volumes/work/librarySystem/src/PremiumBook.java)
- `Proxy`: [src/PremiumEBookAccessProxy.java](/Volumes/work/librarySystem/src/PremiumEBookAccessProxy.java)
- `Chain of Responsibility`: [src/BorrowRequestHandler.java](/Volumes/work/librarySystem/src/BorrowRequestHandler.java), [src/Librarian.java](/Volumes/work/librarySystem/src/Librarian.java), [src/Manager.java](/Volumes/work/librarySystem/src/Manager.java)
- `Facade`: [src/LibraryFacade.java](/Volumes/work/librarySystem/src/LibraryFacade.java)
