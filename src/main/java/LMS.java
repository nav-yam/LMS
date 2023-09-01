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
            case 2 -> member_page();
            case 3-> exit_page();
            default -> login_page();
        }
        return;
    }

    public static void librarian_page(){
        System.out.print(
                """
               
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
        switch (choice) {
            case 1 -> Member.register();
            case 2 ->
            case 3 ->
            case 4 ->
            case 5 ->
            case 6 ->
            case 7 ->
            case 8 ->
            case 9 -> {
                login_page();
                return;
            }
            librarian_page();
        }
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
