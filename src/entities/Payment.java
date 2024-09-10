package entities;

public class Payment {

    private int payment_id;
    private int total;
    private int reservation_id;

    public Payment(int total, int reservation_id) {
        this.total = total;
        this.reservation_id = reservation_id;
    }


    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment_id=" + payment_id +
                ", total=" + total +
                ", reservation_id=" + reservation_id +
                '}';
    }
}
