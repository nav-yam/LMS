package Person;

import Data.Record;

import java.util.ArrayList;
import java.util.Scanner;

public class Member {
    static int num_of_members = 0;
    static int num_of_active_mems = 0;
    static final int max_holds = 2;
    static private final ArrayList<Member> all_members = new ArrayList<>();
    private final String name;
    private final String ph_number;
    private final int member_id;
    private final int age;
    private int dues;
    private int num_issued;
    private Record[] holds;

    Member(String _name, int _age, String _phone) {
        name = _name;
        age = _age;
        ph_number = _phone;
        member_id = num_of_members;
        dues = 0;
        num_issued = 0;
        holds = new Record[max_holds];
    }

    public static void register() {
        Scanner RegisterMember = new Scanner(System.in);

        System.out.print("Enter the phone number of new member: +91-");
        String phone = RegisterMember.nextLine();

        while (phone.length() != 10) {
            System.out.print("Enter a valid (10-digit) phone number: +91-");
            phone = RegisterMember.nextLine();
        }

        Member dummy = Member.find(phone);
        if (dummy == null) {
            System.out.print("Enter name : ");
            String user_name = RegisterMember.nextLine();

            System.out.print("Enter age : ");
            int user_age = RegisterMember.nextInt();

            System.out.printf("""
                    Are you sure to proceed with the following details:\s
                    Name -> '%s'\s
                    Age -> '%d'\s
                    Phone -> '%s'\s
                    Enter 1 for YES, anything else for NO :\s""", user_name, user_age, phone);

            int option = RegisterMember.nextInt();
            if (option == 1) {
                Member user = new Member(user_name, user_age, phone);
                all_members.add(user);
                num_of_members++;
                num_of_active_mems++;
                System.out.println("\nUser successfully registered !\n");
            }
        } else {
            System.out.println("User already exists with same phone number.\nPhone Number need to be unique.");
        }
    }

    public static void show_all() {
        for (Member user : all_members) {
            user.display();
        }
    }

    public static void remove() {
        Member buffer = look_up("Delete");
        if (buffer == null) System.out.println("No such member found !\n");
        else if (buffer.dues != 0) System.out.println("Please clear all your dues\n");
        else if (buffer.num_issued != 0) System.out.println("Please return all books\n");
        else {
            all_members.remove(buffer);
            System.out.println("User Deregistered Successfully !\n");
            num_of_active_mems--;
        }
        return;
    }

    public static void search() {
        Member buffer = look_up("Search");
        if (buffer == null) System.out.println("No user found with this information !");
        else buffer.display();
    }

    public static Member look_up(String str) {
        System.out.printf("""
                Choose a suitable option from the menu below.
                1. '%s' using Phone Number
                2. '%s' using Member ID
                                
                Your choice : \s""", str, str);
        Scanner scanner = new Scanner(System.in);

        int option = scanner.nextInt();
        while (option != 1 && option != 2) {
            System.out.print("Choose a valid option: ");
            option = scanner.nextInt();
        }

        Member buffer = null;
        scanner.nextLine();
        if (option == 1) {
            System.out.print("Enter the phone number : +91-");
            String phone = scanner.nextLine();
            while (phone.length() != 10) {
                System.out.print("Enter a valid (10-digit) phone number: +91-");
                phone = scanner.nextLine();
            }
            buffer = find(phone);
        } else {
            System.out.print("Enter the Member ID : ");
            int id = scanner.nextInt();
            buffer = find(id);
        }
        return buffer;
    }

    public static Member find(String _phone) {
        for (Member user : all_members) {
            if (user.ph_number.equals(_phone)) return user;
        }
        return null;
    }

    public static Member find(int _id) {
        for (Member user : all_members) {
            if (user.member_id == _id) return user;
        }
        return null;
    }

    public void pay_fine(){
        dues = 0;
        System.out.println("Payment Successful !");
    }
    public void display() {
        System.out.println("\nName : " + name);
        System.out.println("Age : " + age);
        System.out.println("Member ID : " + member_id);
        System.out.println("Balance : " + dues);
        System.out.println("Books issued : " + num_issued + "\n");
        System.out.println("~~~~~");
    }

    public String getPh_number() {
        return ph_number;
    }

    public int getMember_id() {
        return member_id;
    }

    public int getDues() {
        return dues;
    }

    public int getNum_issued() {
        return num_issued;
    }
}
