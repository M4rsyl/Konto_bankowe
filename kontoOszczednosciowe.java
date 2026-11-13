public class KontoOszczednosciowe extends Konto {
    private double oprocentowanie;
    private int liczbaWyplat;
    public static final int LIMIT_WYPLAT = 2;

    // Prywatna metoda pomocnicza do walidacji oprocentowania (zakres 0 - 0.10)
    private double walidujOprocentowanie(double op) {
        if (op < 0 || op > 0.10) {
            return 0;
        }
        return op;
    }

    public KontoOszczednosciowe(String wlasciciel, double oprocentowanie) {
        super(wlasciciel);
        this.oprocentowanie = walidujOprocentowanie(oprocentowanie);
        this.liczbaWyplat = 0;
    }

    public KontoOszczednosciowe(String wlasciciel, double saldoPoczatkowe, double oprocentowanie) {
        super(wlasciciel, saldoPoczatkowe);
        this.oprocentowanie = walidujOprocentowanie(oprocentowanie);
        this.liczbaWyplat = 0;
    }

    public double getOprocentowanie() {
        return oprocentowanie;
    }

    public int getLiczbaWyplat() {
        return liczbaWyplat;
    }

    // Naliczenie odsetek nie jest operacją (nie zwiększa liczby operacji)
    public void naliczOdsetki() {
        setSaldo(getSaldo() + getSaldo() * oprocentowanie);
    }

    @Override
    public boolean czyMozemyWyplacic(double kwota) {
        return super.czyMozemyWyplacic(kwota) && (this.liczbaWyplat < LIMIT_WYPLAT);
    }

    @Override
    public boolean wyplac(double kwota) {
        if (super.wyplac(kwota)) {
            this.liczbaWyplat++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | oszczednosciowe %.2f%%, wplat: %d/%d", this.oprocentowanie * 100, this.liczbaWyplat, LIMIT_WYPLAT);
    }
}
