import java.util.Scanner;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {



        Database db = new Database(
                "jdbc:mysql://localhost:3306/HelloMyCash", "3306",
                "HelloMyCash",
                "root", "database123");
        db.connect();
        Scanner sc = new Scanner(System.in);

        //menu

        String username = " ";
        String email = null;
        String password = null;
        int age = 0;
        String fname = null;
        String mname = null;
        String lname = null;


        int option = 0;
        while (option != 6) {
            System.out.println("----- Welcome to Hello My Ca$h  ----- \n [1] Login \n [2] Check Login Details \n [3] Set Budget \n [4] Expense \n [5] Date Details \n [6] Quit");
            System.out.print("Enter your choice of menu: ");
            option = sc.nextInt();


            User user = new User();


            if (option == 1) {

                try {
                    sc.nextLine();
                    System.out.print("Enter your username: ");
                    username = sc.nextLine();
                    System.out.print("Enter your email: ");
                    email = sc.nextLine();
                    System.out.print("Enter your password: ");
                    password = sc.nextLine();
                    System.out.print("Enter your age: ");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter your first name: ");
                    fname = sc.nextLine();
                    System.out.print("Enter your middle name: ");
                    mname = sc.nextLine();
                    System.out.print("Enter your last name: ");
                    lname = sc.nextLine();
                    db.insertRegistration(username,email,password,age,fname,mname,lname);
                } catch (Exception e) {
                    System.out.println("I/O Exception");
                }
            }

            if (option == 2) {

                User u = new User();

                u.setUsername(username);
                u.setEmail(email);
                u.setPassword(password);
                u.setAge(age);

                u.display();


                Name n = new Name();
                n.setFname(fname);
                n.setMname(mname);
                n.setLname(lname);


                n.DisplayName();

                //sc.close();
            }

            if (option == 5) {


                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                System.out.println("DATE : " + sdf.format(cal.getTime()));
                Format f = new SimpleDateFormat("EEEE");
                String str = f.format(new Date());
                System.out.println("DAY : " + str);
                Date d = new Date();
                System.out.println("Day of the week is  : " + d.getDay());
            }

            if (option == 3) {
                //get currency from user
                BudgetWeek budgetW = new BudgetWeek();
                Budget budget = new Budget();
                sc.nextLine();
                System.out.print("Enter the currency you want to proceed with:  ");
                String currency = sc.nextLine();
                budget.setCurrency(currency);
                String date = null;
                int index =0;
                float amount =0;
                float Dayamount = 0;

            int c = 3;
            while(c != 0 ) {
                System.out.print("---Set [1] Todays Budget OR [2] Week Budget--- [0]quit : ");
                c = sc.nextInt();


                    if (c == 1) {
                        BudgetDay daybudget = new BudgetDay();
                        date = daybudget.getDate();
                        System.out.println("Enter For Today's Budget " + date + " : ");
                        Dayamount = sc.nextFloat();
                        daybudget.setDayBudget(Dayamount);
                        index = 0;
                        db.insertBudget(date,Dayamount, index,amount);
                    }

                    if (c == 2) {
                        //get budget from userr
                        System.out.print("Enter the week of the month you want to set the budget to: ");
                        index = sc.nextInt();

                        //error checking
                        if ((index > 4) || (index <= 0)) {
                            index = 0;
                            System.out.println("invalid input ");
                            System.out.print("Enter the week of the month you want to set the budget to: ");
                            index = sc.nextInt();
                        }
                        System.out.print("Enter week " + index + " budget: ");
                        amount = sc.nextFloat();
                        budgetW.setBudgetWeek(amount, index);
                        date = null;
                        db.insertBudget(date,Dayamount, index,amount);
                    }

                }

            }

            if (option == 4) {
                //variable declaration

                int weeknum=0;
                double totalExpense = 0;
                double Eamount =0;
                String dateString = null;


                    //expense
                    while (true) {

                        System.out.println("Enter the week you want to key in expense to: ");
                        weeknum = sc.nextInt();
                        if ((weeknum > 4) || (weeknum <= 0)) {
                            weeknum = 0;
                            System.out.println("invalid input ");
                            System.out.println("Enter the week you want to key in expense to: ");
                            weeknum = sc.nextInt();
                        }




                        // prompt the user for input
                        sc.nextLine();
                        System.out.print("Enter the date of the expense (YYYY-MM-DD): ");
                        dateString = sc.nextLine();

                        System.out.print("Enter the amount of the expense: ");
                        Eamount = sc.nextDouble();
                        sc.nextLine(); // consume the newline character

                        System.out.print("Enter the notes of the expense: ");
                        String notes = sc.nextLine();

                        System.out.print("Enter the currency of the expense: ");
                        String Ecurrency = String.join(sc.nextLine());
                        db.insertExpense(dateString, Eamount, weeknum,totalExpense );


                        // create a new Expense object and add it to the list
                        Expense expense = new Expense(dateString, Eamount, Ecurrency, notes);


                        System.out.print("Do you want to add another expense to another date? (y/n): ");
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

                    for (double expense : expenses) {
                        totalExpense += expense;
                                            }
                    db.insertExpense(dateString, Eamount,  weeknum, totalExpense);
                    System.out.println("Total weekly expense week " +  weeknum +" "+  totalExpense);





                    // Print total weekly expense
                    BudgetWeek budgetW = new BudgetWeek();
                    budgetW.ChkExceedBudget(totalExpense, weeknum);
                }
                

            }
        }
        db.close();
    }


