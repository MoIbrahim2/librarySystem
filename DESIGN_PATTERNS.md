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
- Solution: [src/BorrowRequestHandler.java](/Volumes/work/librarySystem/src/BorrowRequestHandler.java) defines the chain and routes borrowing requests through [src/Librarian.java](/Volumes/work/librarySystem/src/Librarian.java) and [src/Manager.java](/Volumes/work/librarySystem/src/Manager.java).

## Requirement 6
Simplify the library operations handling book borrowing requests.

- Pattern used: `Facade`
- Solution: [src/LibraryFacade.java](/Volumes/work/librarySystem/src/LibraryFacade.java) provides a single entry point for adding books, adding premium books, borrowing, and returning, while hiding the internal coordination between `LibraryService`, `BookFactory`, the borrow chain, the proxy, and the decorator.

## Requirement 7
Use external book data in JSON format and convert it to the internal book entity.

- Pattern used: `Adapter`
- Solution: [src/ExternalBookJsonAdapter.java](/Volumes/work/librarySystem/src/ExternalBookJsonAdapter.java) converts external JSON fields like `bookTitle`, `isBorrowable`, `authorName`, and `year` into the internal [src/Book.java](/Volumes/work/librarySystem/src/Book.java) entity. The factory and facade expose this through [src/BookFactory.java](/Volumes/work/librarySystem/src/BookFactory.java) and [src/LibraryFacade.java](/Volumes/work/librarySystem/src/LibraryFacade.java).

## Requirement 8
Borrowing requests must be approved based on the number of days requested:
`Librarian -> 7 days`, `Manager -> 14 days`, `Director -> 15+ days`.

- Pattern used: `Chain of Responsibility`
- Solution: [src/BorrowRequest.java](/Volumes/work/librarySystem/src/BorrowRequest.java) now includes `requestedDays`, and the approval chain routes requests to [src/Librarian.java](/Volumes/work/librarySystem/src/Librarian.java), [src/Manager.java](/Volumes/work/librarySystem/src/Manager.java), or [src/Director.java](/Volumes/work/librarySystem/src/Director.java) based on the requested borrow duration.

## Current Pattern Map

- `Singleton`: [src/LibraryService.java](/Volumes/work/librarySystem/src/LibraryService.java)
- `Factory`: [src/BookFactory.java](/Volumes/work/librarySystem/src/BookFactory.java)
- `Decorator`: [src/BookDecorator.java](/Volumes/work/librarySystem/src/BookDecorator.java), [src/PremiumBook.java](/Volumes/work/librarySystem/src/PremiumBook.java)
- `Proxy`: [src/PremiumEBookAccessProxy.java](/Volumes/work/librarySystem/src/PremiumEBookAccessProxy.java)
- `Adapter`: [src/ExternalBookJsonAdapter.java](/Volumes/work/librarySystem/src/ExternalBookJsonAdapter.java)
- `Chain of Responsibility`: [src/BorrowRequestHandler.java](/Volumes/work/librarySystem/src/BorrowRequestHandler.java), [src/Librarian.java](/Volumes/work/librarySystem/src/Librarian.java), [src/Manager.java](/Volumes/work/librarySystem/src/Manager.java), [src/Director.java](/Volumes/work/librarySystem/src/Director.java)
- `Facade`: [src/LibraryFacade.java](/Volumes/work/librarySystem/src/LibraryFacade.java)
