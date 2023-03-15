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


    // to see if expense is more than budget
    // if expense == 4 then check exceed budget
    public void ChkExceedBudget(double totalexpense, int weeknum){
        int i = weeknum;
        if (totalexpense > budgetAmt[i]){
            System.out.println("You have exceeded your budget amount for this week! ");
        }
    }

}
