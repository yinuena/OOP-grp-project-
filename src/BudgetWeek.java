import java.util.Calendar;
import java.util.Date;

public class BudgetWeek extends Budget{
    private Float[] WeekBudget;

    public BudgetWeek() {
        super(53); // 53 weeks in a year
        WeekBudget = new Float[53];
    }

    public void setBudgetWeek(float budgetAmt, int week){
        this.WeekBudget[week] = budgetAmt;
    }
}

