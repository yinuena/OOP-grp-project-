import java.util.Scanner;

public class User {
    //attributes of the class
    private String username = " ";
    private String email;
    private String password;
    private int age;



    Scanner sc = new Scanner(System.in);

    
    public String setUsername(String username) {
        return username;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void display(){

        System.out.println("Your Details:");
        System.out.println("Username : " + username);
        System.out.println("Email :" + email);
        System.out.println("Password :" + password);
        System.out.println("Age: " + age);

    }



    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //menu
        //int option = 0;
        // while (option != 5 ){
        //  System.out.println("----- Welcome to HelloMYCa$h----- \n [1] Login \n [2] Check Login Details \n [3] Set Budget \n [4] Key in Expense \n [5]Quit");
        // System.out.print("Enter your choice of menu: ");
        //option = sc.nextInt();


        String username = null;
        String email = null;
        String password = null;
        int age = 0;
        String fname = null;
        String mname = null;
        String lname = null;
        int weeknum;

        User user= new User();



        // if (option == 1) {

        try {
            System.out.print("Enter your username:");
            username = sc.nextLine();
            System.out.print("Enter your email:");
            email = sc.nextLine();
            System.out.print("Enter your password:");
            password = sc.nextLine();
            System.out.print("Enter your age: ");
            age = sc.nextInt();
            System.out.print("Enter your first name: ");
            fname = sc.nextLine();
            System.out.print("Enter your middle name: ");
            mname = sc.nextLine();
            System.out.print("Enter your last name: ");
            lname = sc.nextLine();
        } catch (Exception e) {
            System.out.println("I/O Exception");
        }
        //  }
        System.out.print(username+ email + password + age);
    }

}
