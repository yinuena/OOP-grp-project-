import java.util.Calendar;
import java.util.Date;

public class Budget {
    private Date BWeek[];
    private Expense expense[];
    private float[] budget;
    private String currency;

    public float getBudgetAmount(int index){
        return budget[index];
    }

    public void setBudgetAmount(float budgetAmt, int index){
        this.budget[index] = budgetAmt;
    }

    public String getCurrency(){
        return currency;
    }

    public void setCurrency(String currency){
        this.currency = currency;
    }

    public void ChkExceedBudget(double totalexpense, int weeknum){
        int i = weeknum;
        if (totalexpense > budget[i]){
            System.out.println("You have exceeded your budget amount for this week!");
        }
    }

    public Budget(){
        BWeek = new Date[52];
        expense = new Expense[52];
        budget = new float[52];
        currency = "USD";

        Calendar calendar = Calendar.getInstance();
        int numWeekD = calendar.get(Calendar.WEEK_OF_YEAR);
        // set budget for current week to 1000
        budget[numWeekD - 1] = 1000.0f;
    }

    public static void main(String[] args){
        Budget budget = new Budget();
        System.out.println("Budget for current week: " + budget.getBudgetAmount(Calendar.getInstance().get(Calendar.WEEK_OF_YEAR) - 1));
        budget.ChkExceedBudget(1200, Calendar.getInstance().get(Calendar.WEEK_OF_YEAR) - 1);
    }
}
