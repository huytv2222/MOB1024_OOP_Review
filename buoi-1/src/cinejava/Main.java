package cinejava;

import cinejava.model.Ticket;
import cinejava.service.TicketService;

import java.util.List;

/** CineJava v1 – Buổi 1: OOP, kế thừa, đa hình. */
public class Main {
    public static void main(String[] args) {
        List<Ticket> tickets = TicketService.createSampleTickets();

        System.out.println("===== DANH SÁCH VÉ =====");
        TicketService.printAll(tickets);

        Ticket max = TicketService.findMostExpensive(tickets);
        if (max != null) {
            // printInfo() phải in 2 lần (print nhãn rồi printInfo); toString() ghép thẳng vào chuỗi
            // System.out.print("Vé đắt nhất: ");
            // max.printInfo();
            System.out.println("Vé đắt nhất: " + max); // Java tự gọi max.toString()
        }
    }
}
