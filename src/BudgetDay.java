import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;



public class BudgetDay extends Budget{
    private Date day;
    private Float dayBudget;




    public String getDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String str = formatter.format(date);
        return str;
    }

    public void setDayBudget(float amount){
        dayBudget = amount;
    }

    public static void main(String args[]) {
        BudgetDay daybudget = new BudgetDay();
        String  date =  daybudget.getDate();
        System.out.println("Date : " + date);
    }


    }
