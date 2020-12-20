package by.gsu.pms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor



public class FmDTO {
    private int fm_id;
    private int incomes_id;
    private String income_name;
    private int income_sum;
    private int expences_id;
    private String expensese_name;
    private int expenses_sum;
    private String fm_name;

}
