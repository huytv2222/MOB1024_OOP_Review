# CineJava – code demo MOB1024 Lập trình Java 2

Code live demo trên lớp. Cả môn dùng chung một bài toán: hệ thống bán vé rạp phim **CineJava**, lớn dần qua từng buổi. Mỗi thư mục `buoi-N` là một project độc lập, chạy được.

| Buổi | Nội dung |
|---|---|
| [buoi-1](buoi-1) | OOP: class, đóng gói (private + setter kiểm tra dữ liệu), kế thừa (`extends`, `super`), ghi đè, đa hình (`finalPrice()`), `toString()` và `printInfo()`, tách `model` / `service` |

Các buổi sau sẽ được thêm vào repo này sau mỗi buổi học.

## Cấu trúc buổi 1
```
buoi-1/src/cinejava/
├── Main.java                 ← chỉ gọi service và in kết quả
├── model/
│   ├── Ticket.java           ← vé thường: private + getter/setter kiểm tra, toString(), printInfo()
│   ├── VipTicket.java        ← extends Ticket: phụ thu + phí combo
│   └── StudentTicket.java    ← extends Ticket: giảm giá 0–50%
└── service/
    └── TicketService.java    ← tạo vé mẫu, in danh sách, tìm vé đắt nhất
```

## Cách lấy code và chạy
**Yêu cầu:** JDK 17 trở lên, VS Code + *Extension Pack for Java* (hoặc IntelliJ / NetBeans).

1. Bấm **Code → Download ZIP**, giải nén ra thư mục **không dấu, không khoảng trắng**, ví dụ `D:\Java2\MOB1024-CineJava`.
   Hoặc dùng Git: `git clone https://github.com/huytv2222/MOB1024_OOP_Review.git`
2. VS Code: **File → Open Folder…** → chọn thư mục **`buoi-1`** (không mở thư mục cha).
3. Mở `src/cinejava/Main.java` → bấm **Run** phía trên hàm `main`.

Kết quả mong đợi:
```
===== DANH SÁCH VÉ =====
T01   | Mai          |     90,000
V01   | Dune         |    162,000
S01   | Mai          |     72,000
T02   | Exhuma       |    100,000
V02   | Inside Out 2 |    124,000
Vé đắt nhất: V01   | Dune         |    162,000
```

Lấy bản mới khi có buổi tiếp theo: tải lại ZIP, hoặc `git pull`.

## Thử tự làm
1. Tạo vé `new StudentTicket("S09", "Dune", 90000, 70)` trong `Main` → chạy xem chuyện gì xảy ra, vì sao?
2. Bỏ `@Override public String toString()` trong `Ticket` → `System.out.println(t)` in ra gì?
3. Thêm lớp `CoupleTicket extends Ticket` (vé đôi = giá gốc × 2 × 90%) và cho vào danh sách mẫu. `printAll` có phải sửa không?

> Code demo chỉ để tham khảo cách tổ chức. Bài Lab có đề riêng – hãy tự làm.
