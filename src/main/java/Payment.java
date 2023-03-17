import java.util.Objects;

public class Payment {
    private String name;
    private int year;
    private int month;
    private int day;
    private int payment;

    public Payment(String name, int year, int month, int day, int payment) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.payment = payment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment1 = (Payment) o;
        return year == payment1.year &&
                month == payment1.month &&
                day == payment1.day &&
                payment == payment1.payment &&
                Objects.equals(name, payment1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, month, day, payment);
    }
}
