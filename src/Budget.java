

public class Budget {
    private Date BWeek[];
    private Expense expense[];
    private float budgetAmt[];
    private String currency;


    public float getBudgetAmount(int index){

        return budgetAmt[index];
    }
    public void setBudgetAmount(float  budgetAmt, int index ){

        this.budgetAmt[index] = budgetAmt;
    }

    public String getCurrency(){
        return currency;
    }

    public void setCurrency(){
        this.currency = currency;
    }


    //to get the number of week to key in the budget
    Date noWeekD = new Date();
    int numWeekD = noWeekD.getWeek();
  //getExpense


    // to see if expese is more than budget
    public void ChkExceedBudget(Expense expense ){
        int i = numWeekD;
        if (expense[i] > budgetAmt[i]){
            System.out.println("You have exceeded your budget amount for this week! ");
        }
    }

}
