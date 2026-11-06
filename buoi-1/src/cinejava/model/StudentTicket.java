package cinejava.model;

/** Vé sinh viên: giảm giá theo phần trăm, tối đa 50%. */
public class StudentTicket extends Ticket {
    private int discountPercent;

    public StudentTicket(String id, String movie, double basePrice, int discountPercent) {
        super(id, movie, basePrice);
        setDiscountPercent(discountPercent); // gọi setter để dữ liệu sai bị chặn ngay khi tạo vé
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public final void setDiscountPercent(int discountPercent) {
        if (discountPercent < 0 || discountPercent > 50) throw new IllegalArgumentException("Giảm giá phải trong khoảng 0–50%");
        this.discountPercent = discountPercent;
    }

    @Override
    public double finalPrice() {
        return getBasePrice() * (100 - discountPercent) / 100;
    }
}
