import org.junit.Assert;
import org.junit.Test;

public class TestFinances {
    Payment payment1 = new Payment("Андрей", 1995, 1, 7, 1);
    Payment payment2 = new Payment("Александр", 1965, 1, 7, 300);
    Payment payment3 = new Payment("Артем", 1978, 1, 7, 599);
    Payment[] payments = new Payment[]{
            payment1,
            payment2,
            payment3
    };
    FinanceReport financeReport = new FinanceReport(payments, "Семен", 2000, 5, 6);

    @Test
    public void testFinanceReportOutput(){
        System.out.println(financeReport.toString());
    }

    @Test
    public void testCopy(){
        FinanceReport financeReportCopy = new FinanceReport(financeReport);
        Assert.assertEquals(financeReportCopy, financeReport);
        financeReportCopy.getPayments()[1].setPayment(555);
        Assert.assertNotEquals(financeReportCopy, financeReport);
    }

    @Test
    public void testProcessor(){
        Payment[] expected = new Payment[]{
                payment1,
                payment2,
                payment3
        };
        Assert.assertArrayEquals(expected, FinanceReportProcessor.getPaymentsWithPrefix(financeReport, "А").getPayments());

        expected = new Payment[]{ payment2 };
        Assert.assertArrayEquals(expected, FinanceReportProcessor.getPaymentsLessThan(financeReport, 301).getPayments());
    }
}
