import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class FinanceReport {
    private Payment[] payments;
    private String reporter;
    private int year;
    private int month;
    private int day;

    public FinanceReport(FinanceReport other){
        this.reporter = other.reporter;
        this.year = other.year;
        this.month = other.month;
        this.day = other.day;
        payments = new Payment[other.getPayments().length];
        for (int i = 0; i < payments.length; i++){
            this.payments[i] = new Payment(other.getPayments()[i].getName(), other.getPayments()[i].getYear(),
                    other.getPayments()[i].getMonth(), other.getPayments()[i].getDay(), other.getPayments()[i].getPayment());
        }
    }

    public FinanceReport(Payment[] payments, String reporter, int year, int month, int day) {
        this.payments = payments;
        this.reporter = reporter;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getAmountOfPayments(){
        return payments.length;
    }

    public Payment getPaymentAt(int index){
        return payments[index];
    }

    public void setPaymentAt(int index, Payment payment){
        payments[index] = payment;
    }

    /* Филиппов А.В. 31.05.2020 Комментарий не удалять.
     Не работает!
     У вас выше написан шаблон со словами и рублями, а вы где-то их потеряли.

     Должно быть что-то вида
     Плательщик: Петров Василий Иванович, дата: 20.05.2020 сумма: 100 руб. 00 коп.
     Копейки выводятся двумя цифрами с ведущим нулем, т.е. 1 копейка - это 01 коп.
    */
    @Override
    public String toString() {
        StringBuilder res;
        String template = "Плательщик: %s, дата: %s%s%d, сумма: %s руб. %s коп.\n";
        res = new StringBuilder(String.format("%s: %s%s%d, платежи: \n", reporter,
                new DecimalFormat("00.", new DecimalFormatSymbols(Locale.US)).format(day),
                new DecimalFormat("00.", new DecimalFormatSymbols(Locale.US)).format(month), year));
        for (Payment payment : payments) {
            int rubles = 0;
            int kop = payment.getPayment();
            while (kop >= 100) {
                rubles ++;
                kop -= 100;
            }
            res.append(
                    String.format(
                            template,
                            payment.getName(),
                            new DecimalFormat("00.", new DecimalFormatSymbols(Locale.US)).format(payment.getDay()),
                            new DecimalFormat("00.", new DecimalFormatSymbols(Locale.US)).format(payment.getMonth()),
                            payment.getYear(),
                            new DecimalFormat("00", new DecimalFormatSymbols(Locale.US)).format(kop),
                            new DecimalFormat("00", new DecimalFormatSymbols(Locale.US)).format(rubles)
                    )
            );
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinanceReport)) return false;
        FinanceReport that = (FinanceReport) o;
        return getYear() == that.getYear() &&
                getMonth() == that.getMonth() &&
                getDay() == that.getDay() &&
                Arrays.equals(getPayments(), that.getPayments()) &&
                Objects.equals(getReporter(), that.getReporter());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getReporter(), getYear(), getMonth(), getDay());
        result = 31 * result + Arrays.hashCode(getPayments());
        return result;
    }

    public Payment[] getPayments() {
        return payments;
    }

    public String getReporter() {
        return reporter;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
