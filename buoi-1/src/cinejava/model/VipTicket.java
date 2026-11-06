package cinejava.model;

/** Vé VIP: phụ thu theo tỉ lệ + phí combo bắp nước. */
public class VipTicket extends Ticket {
    private double surchargeRate; // 0 → 1
    private double comboFee;      // >= 0

    public VipTicket(String id, String movie, double basePrice, double surchargeRate, double comboFee) {
        super(id, movie, basePrice); // phải là dòng đầu tiên
        setSurchargeRate(surchargeRate); // gọi setter để dữ liệu sai bị chặn ngay khi tạo vé
        setComboFee(comboFee);
    }

    public double getSurchargeRate() {
        return surchargeRate;
    }

    public final void setSurchargeRate(double surchargeRate) {
        if (surchargeRate < 0 || surchargeRate > 1) throw new IllegalArgumentException("Phụ thu phải trong khoảng 0–1");
        this.surchargeRate = surchargeRate;
    }

    public double getComboFee() {
        return comboFee;
    }

    public final void setComboFee(double comboFee) {
        if (comboFee < 0) throw new IllegalArgumentException("Phí combo phải >= 0");
        this.comboFee = comboFee;
    }

    @Override
    public double finalPrice() {
        double p = getBasePrice(); // basePrice là private của Ticket → phải dùng getter
        return p + p * surchargeRate + comboFee;
    }
}
