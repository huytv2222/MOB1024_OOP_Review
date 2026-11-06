package cinejava.model;

/**
 * Vé xem phim thường. Mọi thuộc tính private, setter có kiểm tra,
 * constructor gọi lại setter nên object tạo ra luôn hợp lệ.
 */
public class Ticket {
    private String id;
    private String movie;
    private double basePrice;

    public Ticket(String id, String movie, double basePrice) {
        setId(id);
        setMovie(movie);
        setBasePrice(basePrice);
    }

    public String getId() {
        return id;
    }

    // final: lớp con không ghi đè được, nên constructor gọi setter luôn an toàn
    public final void setId(String id) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Mã vé rỗng");
        this.id = id.trim();
    }

    public String getMovie() {
        return movie;
    }

    public final void setMovie(String movie) {
        if (movie == null || movie.isBlank()) throw new IllegalArgumentException("Tên phim rỗng");
        this.movie = movie.trim();
    }

    public double getBasePrice() {
        return basePrice;
    }

    public final void setBasePrice(double basePrice) {
        if (basePrice < 0) throw new IllegalArgumentException("Giá vé phải >= 0");
        this.basePrice = basePrice;
    }

    /** Giá khách phải trả. Lớp con ghi đè để có công thức riêng. */
    public double finalPrice() {
        return basePrice;
    }

    /*
     * toString() và printInfo() – giữ cả hai, mỗi cái một việc:
     *
     *  toString()  TRẢ VỀ chuỗi mô tả vé, không tự in.
     *              → dùng được ở mọi nơi: println(t), "Vé: " + t, ghi file, hiện lên giao diện, debug.
     *              → Java tự gọi khi cần chuỗi; List in ra [T01 | Mai | ..., ...] cũng nhờ nó.
     *              → Đây là cách nên dùng.
     *
     *  printInfo() IN THẲNG ra màn hình (console), không trả về gì.
     *              → dễ hiểu cho người mới, nhưng chỉ dùng được với console.
     *              → Gọi lại toString() để định dạng chỉ viết MỘT chỗ: sửa toString là printInfo đổi theo.
     *
     * Cả hai đều gọi finalPrice() (trực tiếp hoặc qua toString) nên lớp con in đúng giá
     * mà không cần viết lại – đó là đa hình.
     */

    /** Chuỗi mô tả vé, vd "V01   | Dune         |    162,000". */
    @Override
    public String toString() {
        return String.format("%-5s | %-12s | %,10.0f", id, movie, finalPrice());
    }

    /** In vé trên một dòng ra console. */
    public void printInfo() {
        System.out.println(toString()); // tương đương System.out.println(this)
    }
}
