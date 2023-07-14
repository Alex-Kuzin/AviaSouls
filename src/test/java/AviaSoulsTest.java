import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void testSortTicketsCompareToMultipleReturns() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Ижевск", 10_000, 8, 12);
        Ticket ticket2 = new Ticket("Москва", "Ижевск", 13_000, 9, 13);
        Ticket ticket3 = new Ticket("Москва", "Екатеринбург", 30_000, 12, 16);
        Ticket ticket4 = new Ticket("Москва", "Ижевск", 10_000, 18, 22);
        Ticket ticket5 = new Ticket("Иркутск", "Ижевск", 20_000, 19, 23);
        Ticket ticket6 = new Ticket("Москва", "Екатеринбург", 10_000, 12, 16);
        Ticket ticket7 = new Ticket("Москва", "Ижевск", 22_000, 18, 22);
        Ticket ticket8 = new Ticket("Иркутск", "Ижевск", 20_000, 19, 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("Москва", "Ижевск");
        Ticket[] expected = {ticket1, ticket4, ticket2, ticket7};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsComporatorMultipleReturns() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Ижевск", 10_000, 8, 12);//4
        Ticket ticket2 = new Ticket("Москва", "Ижевск", 13_000, 9, 13);//4
        Ticket ticket3 = new Ticket("Москва", "Екатеринбург", 30_000, 12, 14);
        Ticket ticket4 = new Ticket("Москва", "Ижевск", 10_000, 19, 22);//3
        Ticket ticket5 = new Ticket("Иркутск", "Ижевск", 20_000, 15, 23);
        Ticket ticket6 = new Ticket("Москва", "Екатеринбург", 10_000, 15, 16);
        Ticket ticket7 = new Ticket("Москва", "Ижевск", 22_000, 21, 22);//1
        Ticket ticket8 = new Ticket("Иркутск", "Ижевск", 20_000, 11, 19);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("Москва", "Ижевск", comparator);
        Ticket[] expected = {ticket7, ticket4, ticket1, ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsCompareToNoResult() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Ижевск", 10_000, 8, 12);
        Ticket ticket2 = new Ticket("Москва", "Ижевск", 13_000, 9, 13);
        Ticket ticket3 = new Ticket("Москва", "Екатеринбург", 30_000, 12, 16);
        Ticket ticket4 = new Ticket("Москва", "Ижевск", 10_000, 18, 22);
        Ticket ticket5 = new Ticket("Иркутск", "Ижевск", 20_000, 19, 23);
        Ticket ticket6 = new Ticket("Москва", "Екатеринбург", 10_000, 12, 16);
        Ticket ticket7 = new Ticket("Москва", "Ижевск", 22_000, 18, 22);
        Ticket ticket8 = new Ticket("Иркутск", "Ижевск", 20_000, 19, 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("Москва", "Владивосток");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsComporatorNoResult() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Ижевск", 10_000, 8, 12);//4
        Ticket ticket2 = new Ticket("Москва", "Ижевск", 13_000, 9, 13);//4
        Ticket ticket3 = new Ticket("Москва", "Екатеринбург", 30_000, 12, 14);
        Ticket ticket4 = new Ticket("Москва", "Ижевск", 10_000, 19, 22);//3
        Ticket ticket5 = new Ticket("Иркутск", "Ижевск", 20_000, 15, 23);
        Ticket ticket6 = new Ticket("Москва", "Екатеринбург", 10_000, 15, 16);
        Ticket ticket7 = new Ticket("Москва", "Ижевск", 22_000, 21, 22);//1
        Ticket ticket8 = new Ticket("Иркутск", "Ижевск", 20_000, 11, 19);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("Москва", "Владивосток", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsCompareToOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Ижевск", 10_000, 8, 12);
        Ticket ticket2 = new Ticket("Москва", "Ижевск", 13_000, 9, 13);
        Ticket ticket3 = new Ticket("Москва", "Екатеринбург", 30_000, 12, 16);
        Ticket ticket4 = new Ticket("Москва", "Ижевск", 10_000, 18, 22);
        Ticket ticket5 = new Ticket("Иркутск", "Ижевск", 20_000, 19, 23);
        Ticket ticket6 = new Ticket("Москва", "Екатеринбург", 10_000, 12, 16);
        Ticket ticket7 = new Ticket("Москва", "Ижевск", 22_000, 18, 22);
        Ticket ticket8 = new Ticket("Иркутск", "Екатеринбург", 20_000, 19, 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("Иркутск", "Екатеринбург");
        Ticket[] expected = {ticket8};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsComporatorOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Ижевск", 10_000, 8, 12);//4
        Ticket ticket2 = new Ticket("Москва", "Ижевск", 13_000, 9, 13);//4
        Ticket ticket3 = new Ticket("Москва", "Екатеринбург", 30_000, 12, 14);
        Ticket ticket4 = new Ticket("Екатеринбург", "Ижевск", 10_000, 19, 22);//3
        Ticket ticket5 = new Ticket("Иркутск", "Ижевск", 20_000, 15, 23);
        Ticket ticket6 = new Ticket("Москва", "Екатеринбург", 10_000, 15, 16);
        Ticket ticket7 = new Ticket("Москва", "Ижевск", 22_000, 21, 22);//1
        Ticket ticket8 = new Ticket("Иркутск", "Ижевск", 20_000, 11, 19);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("Екатеринбург", "Ижевск", comparator);
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }
}
