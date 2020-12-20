package by.gsu.pms;

public class Income {
    private int income_id;
    private String income_name;
    private int income_sum;

    public int getIncome_id() {
        return income_id;
    }

    public void setIncome_id(int income_id) {
        this.income_id = income_id;
    }

    public String getIncome_name() {
        return income_name;
    }

    public void setIncome_name(String income_name) {
        this.income_name = income_name;
    }

    public int getIncome_sum() {
        return income_sum;
    }

    public void setIncome_sum(int income_sum) {
        this.income_sum = income_sum;
    }

    public Income(int income_id, String income_name, int income_sum) {
        this.income_id = income_id;
        this.income_name = income_name;
        this.income_sum = income_sum;
    }
}
