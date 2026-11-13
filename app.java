public class App {
    public static void main(String[] args) throws Exception {
        // a. Tworzenie kont
        Konto k1 = new Konto("Anna Kowalska", 1000);
        KontoOszczednosciowe k2 = new KontoOszczednosciowe("Jan Nowak", 1000, 0.02);
        KontoZDebetem k3 = new KontoZDebetem("Firma XYZ", 500);

        // b. Nalicz odsetki na koncie nr 2 i wypisz to konto
        k2.naliczOdsetki();
        System.out.println(k2);

        // c. Wykonanie operacji z wypisem OK / ODMOWA
        System.out.print("Wplata 100 na konto nr 3: ");
        System.out.println(k3.wplac(100) ? "OK" : "ODMOWA");

        System.out.print("Wyplata 300 z konta nr 3: ");
        System.out.println(k3.wyplac(300) ? "OK" : "ODMOWA");

        System.out.print("Wyplata 400 z konta nr 3: ");
        System.out.println(k3.wyplac(400) ? "OK" : "ODMOWA");

        System.out.print("Wyplata 100 z konta nr 2: ");
        System.out.println(k2.wyplac(100) ? "OK" : "ODMOWA");

        System.out.print("Wyplata 100 z konta nr 2: ");
        System.out.println(k2.wyplac(100) ? "OK" : "ODMOWA");

        System.out.print("Wyplata 100 z konta nr 2: ");
        System.out.println(k2.wyplac(100) ? "OK" : "ODMOWA");

        // d. Przypisz konto nr 3 do zmiennej typu Konto i wykonaj wyplate 250
        Konto k3JakoKonto = k3;
        System.out.print("Wyplata 250 z konta nr 3 (zmienna typu Konto): ");
        System.out.println(k3JakoKonto.wyplac(250) ? "OK" : "ODMOWA");

        // e. Wypis wszystkich danych koncowych
        System.out.println(k1);
        System.out.println(k2);
        System.out.println(k3);
        System.out.printf("Dostepne srodki konta nr 3: %.2f\n", k3.dostepneSrodki());
        System.out.println("Konto nr 2 ma wiecej niz konto nr 3: " + (k2.maWiecejNiz(k3) ? "TAK" : "NIE"));
        System.out.println("Liczba kont: " + Konto.getLiczbaUtworzonychKont());
    }
}
