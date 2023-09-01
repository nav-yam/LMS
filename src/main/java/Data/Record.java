package Data;

import Item.Book;
import Person.Member;

import java.time.LocalDateTime;

public class Record {
    private Book book;
    private int book_id;
    private Member member;
    private int member_id;
    private LocalDateTime issued;
    private LocalDateTime returned;
    private int fine;

    Record(Book _book, Member _member){
        book = _book;
        book_id = _book.getId();

        member = _member;
        member_id = _member.getMember_id();

        issued = LocalDateTime.now();
    }


}

