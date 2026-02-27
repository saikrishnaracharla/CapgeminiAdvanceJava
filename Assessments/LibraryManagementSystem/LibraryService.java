package com.library;

import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    private final BookService bookService;
    private final MemberService memberService;

    public LibraryService(BookService bookService,
                          MemberService memberService) {
        this.bookService = bookService;
        this.memberService = memberService;
    }

    public void issueBook(Long memberId, Long bookId) {

        Member member = memberService.getMember(memberId);
        Book book = bookService.getBook(bookId);

        if (member == null) {
            System.out.println("Member not found");
            return;
        }

        if (book == null || !book.isAvailable()) {
            System.out.println("Book not available");
            return;
        }

        book.setAvailable(false);
        System.out.println("Book Issued Successfully");
    }

    public void returnBook(Long memberId, Long bookId) {

        Book book = bookService.getBook(bookId);

        if (book != null) {
            book.setAvailable(true);
            System.out.println("Book Returned Successfully");
        }
    }
}
