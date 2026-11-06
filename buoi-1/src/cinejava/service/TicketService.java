package cinejava.service;

import cinejava.model.StudentTicket;
import cinejava.model.Ticket;
import cinejava.model.VipTicket;

import java.util.ArrayList;
import java.util.List;

/** Các hàm xử lý danh sách vé: tạo vé mẫu, in, tìm vé đắt nhất. */
public class TicketService {

    /** Tạo danh sách vé mẫu: vé thường, VIP, sinh viên nằm chung một List<Ticket>. */
    public static List<Ticket> createSampleTickets() {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket("T01", "Mai", 90000));
        tickets.add(new VipTicket("V01", "Dune", 110000, 0.2, 30000));
        tickets.add(new StudentTicket("S01", "Mai", 90000, 20));
        tickets.add(new Ticket("T02", "Exhuma", 100000));
        tickets.add(new VipTicket("V02", "Inside Out 2", 90000, 0.1, 25000));
        return tickets;
    }

    /** In tất cả vé. Mỗi vé tự tính finalPrice() theo lớp của nó (đa hình). */
    public static void printAll(List<Ticket> tickets) {
        for (Ticket t : tickets) {
            System.out.println(t); // println tự gọi t.toString() – cùng kết quả với t.printInfo()
        }
    }

    /** Tìm vé có giá cuối cùng cao nhất. Danh sách rỗng thì trả về null. */
    public static Ticket findMostExpensive(List<Ticket> tickets) {
        if (tickets.isEmpty()) {
            return null;
        }
        Ticket max = tickets.get(0);
        for (Ticket t : tickets) {
            if (t.finalPrice() > max.finalPrice()) {
                max = t;
            }
        }
        return max;
    }
}
