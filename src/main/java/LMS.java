import Item.Book;
import Person.Member;

import java.util.Scanner;

public class LMS {
    public static void main(String[] args) {
        begin();
    }
    private static void begin() {
        System.out.print(
                """
                                        
                        - - - - - - - - - - - - - - - - - - - - - - - -\s
                        Library Portal Initialising....
                        Fetching Data....
                        - - - - - - - - - - - - - - - - - - - - - - - -\s
                                        
                        Library Management System (LMS) ready to use\s
                                        
                        - - - - - - - - - - - - - - - - - - - - - - - -\s
                        """
        );
        login_page();
        return;
    }


    private static void login_page(){
        System.out.print(
                """
                Choose a suitable option from the menu below.
                                                
                1) I am a librarian
                2) I am student
                3) Exit
                                        
                Your choice : \s""");

        Scanner LMS_interface = new Scanner(System.in);
        int choice = LMS_interface.nextInt();
        switch (choice) {
            case 1 -> {

                System.out.print(
                """
                - - - - - - - - - - - - - - - - - - - - - - - -\s

                Welcome Librarian !!!
                """);
                librarian_page();
            }
            case 2 -> member_login_page();
            case 3-> exit_page();
            default -> login_page();
        }
        return;
    }

    private static void member_page(Member person){
        System.out.print(
                """
                        - - - - - - - - - - - - - - - - - - - - - - - -\s
                        Choose a suitable option from the menu below.
                        
                        1. List all Books
                        2. List my Books
                        3. Issue a Book
                        4. Return Book
                        5. Pay Fine
                        6. Back
                                               
                        Your choice : \s""");
        Scanner Member_interface = new Scanner(System.in);
        int choice = Member_interface.nextInt();
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - -\s");
        switch (choice) {
            case 1 -> Book.show_all();
            case 2 -> //List my books
            case 3 -> //Issue a book
            case 4 -> //Return a book
            case 5 -> person.pay_fine();
            case 6 -> {
                login_page();
                return;
            }
        }
        member_page();
        return;
    }

    public static void librarian_page(){
        System.out.print(
                """
                        - - - - - - - - - - - - - - - - - - - - - - - -\s
                        Choose a suitable option from the menu below.
                                        
                        1. Register new Member
                        2. View all members with pending dues
                        3. De-register a Member
                        4. Find a Member
                        5. Add a Book
                        6. View all Books
                        7. Remove a Book
                        8. Find a Book
                        9. Back
                                                
                        Your choice : \s""");
        Scanner Librarian_interface = new Scanner(System.in);
        int choice = Librarian_interface.nextInt();
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - -\s");
        switch (choice) {
            case 1 -> Member.register();
            case 2 -> Member.show_all();
            case 3 -> Member.remove();
            case 4 -> Member.search();
            case 5 -> Book.add();
            case 6 -> Book.show_all();
            case 7 -> Book.remove();
            case 8 -> Book.search();
            case 9 -> {
                login_page();
                return;
            }
        }
        librarian_page();
        return;
    }

    private static void exit_page(){
        System.out.print(
                """
                - - - - - - - - - - - - - - - - - - - - - - - -\s
                
                Updating Database....
                Data Successfully Updated
                
                Thanks for Visiting\s
                
                'Education is the second step towards success after commencing the journey'
                
                        """);
        return;
    }

}
