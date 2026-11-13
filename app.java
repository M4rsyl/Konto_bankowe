public class App {
    public static void main(String[] args) throws Exception {
        konto k1 = new konto("Anna Kowalska", 1000);
        konto k2 = new konto("Jan Nowak");
        konto k3 = new konto("", -50);

        System.out.println(k1);
        System.out.println(k2);
        System.out.println(k3);

        System.out.print("Wplata 200 na konto nr2: ");
        System.out.println(k2.wplac(200) ? "OK" : "ODMOWA");

        System.out.print("Wyplata 300 na konto nr1: ");
        System.out.println(k1.wyplac(300) ? "OK" : "ODMOWA");

        System.out.print("Wyplata 500 na konto nr2: ");
        System.out.println(k2.wyplac(500) ? "OK" : "ODMOWA");

        System.out.print("Wyplata -50 na konto nr2: ");
        System.out.println(k2.wyplac(-50) ? "OK" : "ODMOWA");

        System.out.print("Wyplata 6000 na konto nr1: ");
        System.out.println(k1.wyplac(6000) ? "OK" : "ODMOWA");

        System.out.print("Wyplata 6000 na konto nr1: ");
        System.out.println(k1.wyplac(6000) ? "OK" : "ODMOWA");

        System.out.print("Wyplata 5000 na konto nr1: ");
        System.out.println(k1.wyplac(5000) ? "OK" : "ODMOWA");

        System.out.println(k1);
        System.out.println(k2);
        System.out.println(k3);

        System.out.println("Liczba kont: " + konto.getLiczbaUtworzonychKont());
        System.out.println("Konto nr 1 ma wiecej niz konto nr 2: " + (k1.maWiecejNiz(k2) ? "TAK" : "NIE"));
    }
}
