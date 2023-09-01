package Item;

import Data.Record;
import Person.Member;

public class Book implements Item{
    static int num_of_books = 0;
    static int due_period = 10;
    static int subsequent_charge = 3;

    private int id;
    private String title;
    private String author;
    private int total;
    private int available;
    private int issued;
    private Record[] holds;

    Book(int _id, String _title, String _author, int _total){
        id = _id;
        title = _title;
        author = _author;
        total = _total;
        available = _total;
        issued = 0;
        num_of_books += 1;
        holds = new Record[total];
    }

    public int getId() {
        return id;
    }
}
