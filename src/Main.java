import java.util.Scanner;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
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

    //   if (option == 2){

               User u = new User();
               u.getUsername(username);
               u.setEmail(email);
               u.setPassword(password);
               u.setAge(age);
               System.out.println("Your Details:");
               System.out.println("Username : " + u.getUsername());
               System.out.println("Email :" + u.getEmail());
               System.out.println("Password :" + u.getPassword());
               System.out.println("Age: " + u.getAge());

               Name n = new Name();
               n.setFname(fname);
               n.setMname(mname);
               n.setLname(lname);

               System.out.println("First name: " + n.getFname());
               System.out.println("Middle name: " + n.getMname());
               System.out.println("Last name: " + n.getLname());
               //sc.close();

               Calendar cal = Calendar.getInstance();
               SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
               System.out.println("DATE : " + sdf.format(cal.getTime()));
               Format f = new SimpleDateFormat("EEEE");
               String str = f.format(new Date());
               System.out.println("DAY : " + str);
               Date d = new Date();
               System.out.println("Day of the week is  : " + d.getDay());
      // }

      // if (option == 3) {
           //get currency from user
           Budget budget = new Budget();
           System.out.println("[3] Set Budget");
           System.out.print("Enter the currency you want to proceed with:  ");
           String currency = sc.nextLine();
           budget.setCurrency(currency);

           //get budget from userr
           System.out.print("Enter the week of the month you want to set the budget to: ");
           int index = sc.nextInt();
           if ((index > 4) || (index <= 0)) {
               index = 0;
               System.out.println("invalid input ");
               System.out.println("Enter the week of the month you want to set the budget to: ");
               index = sc.nextInt();
           }
           System.out.println("Enter week " + index + " budget: ");
           float amount = sc.nextFloat();
           budget.setBudgetAmount(amount, index);


           while (true) {

               System.out.println("Enter the week you want to key in expense to: ");
               weeknum = sc.nextInt();
               if ((index > 4) || (index <= 0)) {
                   index = 0;
                   System.out.println("invalid input ");
                   System.out.println("Enter the week you want to key in expense to: ");
                   index = sc.nextInt();
               }


               // prompt the user for input
               System.out.print("Enter the date of the expense (YYYY-MM-DD): ");
               String dateString = sc.nextLine();

               System.out.print("Enter the amount of the expense: ");
               double Eamount = sc.nextDouble();
               sc.nextLine(); // consume the newline character

               System.out.print("Enter the notes of the expense: ");
               String notes = sc.nextLine();

               System.out.print("Enter the currency of the expense: ");
               String Ecurrency = String.join(sc.nextLine());

               // create a new Expense object and add it to the list
               Expense expense = new Expense(dateString, amount, currency, notes);


               System.out.print("Do you want to add another expense? (y/n): ");
               String choice = sc.nextLine();
               if (choice.equals("n")) {
                   break;
               }
           }

           double[] expenses = new double[7];
           String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

           // Input expenses for each day of the week
           for (int i = 0; i < 7; i++) {
               System.out.print("Enter expenses for " + daysOfWeek[i] + ": ");
               expenses[i] = sc.nextDouble();
           }

           // Calculate total weekly expense
           double totalExpense = 0;
           for (double expense : expenses) {
               totalExpense += expense;
           }

           // Print total weekly expense
           System.out.printf("Total weekly expense week ", weeknum, " : $%.2f\n", totalExpense);
           budget.ChkExceedBudget(totalExpense, weeknum);
      // }
        }
        }



