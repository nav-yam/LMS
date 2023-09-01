package Person;

import Data.Record;

import java.util.ArrayList;
import java.util.Scanner;

public class Member {
    static private ArrayList<Member> all_members = new ArrayList<>();
    static int num_of_members = 0;
    static int num_of_active_mems = 0;
    static int max_holds = 2;
    private final String name;
    private int age;
    private final String ph_number;
    private final int member_id;
    private int dues;
    private int num_issued;
    private Record[] holds;

    Member(String _name, int _age, String _phone){
        name = _name;
        age = _age;
        ph_number = _phone;
        member_id = num_of_members;
        num_of_members++;
        num_of_active_mems++;
        dues = 0;
        num_issued = 0;
        holds = new Record[2];
    }
    public static void register(){
        Scanner RegisterMember = new Scanner(System.in);

        System.out.print("Enter the phone number of new member: +91-");
        String phone = RegisterMember.nextLine();

        while(phone.length() != 10){
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

            String option = RegisterMember.nextLine();
            if (option.equals("1")){
                Member user = new Member(user_name, user_age, phone);
                all_members.add(user);
            }
            else return;

        }
        else {
            System.out.println("User already exists with same phone number");
        }
    }

    public static Member find(String _phone){
//       ? ENTER CODE
    }

    public void display(){
//        ? ENTER CODE
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
