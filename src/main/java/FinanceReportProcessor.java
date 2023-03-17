import java.util.ArrayList;

public class FinanceReportProcessor {
    /* Филиппов А.В. 31.05.2020 Комментарий не удалять.
     Не работает! Результат должен быть FinanceReport, а не Payment[].
    */
    public static FinanceReport getPaymentsWithPrefix(FinanceReport financeReport, String prefix){
        ArrayList<Payment> payments = new ArrayList<>();
        for(Payment p: financeReport.getPayments()){
            if(p.getName().startsWith(prefix)){
                payments.add(p);
            }
        }
//        return payments.toArray(new Payment[0]);
        return financeReport;
    }

    /* Филиппов А.В. 31.05.2020 Комментарий не удалять.
     Не работает! Результат должен быть FinanceReport, а не Payment[].
    */
    public static FinanceReport getPaymentsLessThan(FinanceReport financeReport, int max){
        ArrayList<Payment> payments = new ArrayList<>();
        for (Payment p: financeReport.getPayments()){
            if(p.getPayment() < max){
                payments.add(p);
            }
        }
//        return payments.toArray(new Payment[0]);
        return financeReport;
    }
}
