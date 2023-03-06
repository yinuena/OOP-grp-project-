public class Budget {
    private Date Bweek[];
    private Expense expense[];
    private float budgetAmt[];
    private string currency;


    public float getBudgetAmount(int index){
        return budgetAmt[index];
    }
    public void setBudgetAmount(float Bamount, int index ){
        this.budgetAmt[index] = Bamount;
    }


    //to get the number of week to key in the budget
    Date noWeekD = new Date();
    int numWeekD = noWeekD.getWeek();
  //getExpense

  
    // to see if expese is more than budget
    public void ExspenseandBudget(Expense expense ){
        int i = numWeekD;
        if (expense[i] > budgetAmt[i]){
            System.out.println("You have exceeded your budget amount");
        }
    }

}
