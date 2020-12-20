package by.gsu.pms;

public class Mapper {
    public FmDTO mapFmDTO(FamilyRecord familyRecord, Expenses expenses, Income income){
        return FmDTO.builder()
                .fm_id(familyRecord.getFm_id())
                .income_name(income.getIncome_name())
                .income_sum(income.getIncome_sum())
                .expensese_name(expenses.getExpensese_name())
                .expenses_sum(expenses.getExpenses_sum())
                .fm_name(familyRecord.getFm_name())
                .build();
    }
}
