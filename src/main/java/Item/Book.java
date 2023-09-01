package Item;

import Data.Record;
import Person.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class Book implements Item{
    static int num_of_books = 0;
    static int due_period = 10;
    static int subsequent_charge = 3;
    static private final ArrayList<Book> all_books = new ArrayList<>();
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
    public static void add(){
//        ? Add code
    }

    public static void show_all(){
        for (Book bk : all_books){
            bk.display();
        }
    }

    public static void remove(){
        Book buffer = lookup("remove");
        if (buffer == null) System.out.println("No such Book found !");
        else if (buffer.issued != 0) System.out.println("Not all Books are Returned");
        else {
            all_books.remove(buffer);
            System.out.println("Book removed from Library Successfully.");
        }
    }

    public static void search(){
        Book buffer = lookup("search");
        if (buffer == null) System.out.println("No such Book found !");
        else buffer.display();
    }

    public static Book lookup(String str){
        System.out.printf("Enter to Book Id of the Book you wish to '%s'", str);

        Scanner scanner = new Scanner(System.in);
        int _id = scanner.nextInt();
        for (Book bk : all_books){
            if (bk.id == _id) return bk;
        }
        return null;
    }

    public void display(){
        System.out.println("\nTitle : " + title);
        System.out.println("Author : " + author);
        System.out.println("Book ID : " + id);
        System.out.println("Available : " + available + "/" + total);
        System.out.println("~~~~~");
    }

    public int getId() {
        return id;
    }



}
