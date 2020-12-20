package by.gsu.pms;

public class FamilyRecord {
    private int fm_id;
    private int incomes_id;
    private int expences_id;
    private String fm_name;

    public int getFm_id() {
        return fm_id;
    }

    public void setFm_id(int fm_id) {
        this.fm_id = fm_id;
    }

    public int getIncomes_id() {
        return incomes_id;
    }

    public void setIncomes_id(int incomes_id) {
        this.incomes_id = incomes_id;
    }

    public int getExpences_id() {
        return expences_id;
    }

    public void setExpences_id(int expences_id) {
        this.expences_id = expences_id;
    }

    public String getFm_name() {
        return fm_name;
    }

    public void setFm_name(String fm_name) {
        this.fm_name = fm_name;
    }

    public FamilyRecord(int fm_id, int incomes_id, int expences_id, String fm_name) {
        this.fm_id = fm_id;
        this.incomes_id = incomes_id;
        this.expences_id = expences_id;
        this.fm_name = fm_name;
    }
}
