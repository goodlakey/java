package by.gsu.pms;

public class Expenses {
    private int expenses_id;
    private String expensese_name;
    private int expenses_sum;

    public int getExpenses_id() {
        return expenses_id;
    }

    public void setExpenses_id(int expenses_id) {
        this.expenses_id = expenses_id;
    }

    public String getExpensese_name() {
        return expensese_name;
    }

    public void setExpensese_name(String expensese_name) {
        this.expensese_name = expensese_name;
    }

    public int getExpenses_sum() {
        return expenses_sum;
    }

    public void setExpenses_sum(int expenses_sum) {
        this.expenses_sum = expenses_sum;
    }

    public Expenses(int expenses_id, String expensese_name, int expenses_sum) {
        this.expenses_id = expenses_id;
        this.expensese_name = expensese_name;
        this.expenses_sum = expenses_sum;
    }
}
