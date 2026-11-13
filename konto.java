public class konto {
    private final int numer;
    private final String wlasciciel;
    private double saldo;
    private int liczbaOperacji;

    private static int liczbaKont = 0;

    public konto(String wlasciciel) {
        liczbaKont++;
        this.numer = liczbaKont;

        if (wlasciciel == null || wlasciciel.trim().isEmpty()) {
            this.wlasciciel = "Nieznany";
        } else {
            this.wlasciciel = wlasciciel;
        }
        saldo = 0;
        liczbaOperacji = 0;
    }

    public konto(String wlasciciel, double saldoPoczatkowe) {
        this(wlasciciel);
        if (saldoPoczatkowe > 0) {
            this.saldo = saldoPoczatkowe;
        }
    }

    public int getNumer() {
        return numer;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getLiczbaOperacji() {
        return liczbaOperacji;
    }

    public static int getLiczbaUtworzonychKont() {
        return liczbaKont;
    }

    public static final double MAKS_WYPLATA = 5000.0;

    public boolean wplac(double kwota) {
        if (kwota <= 0) {
            return false;
        }
        this.saldo += kwota;
        this.liczbaOperacji++;
        return true;
    }

    public boolean czyMozemyWyplacic(double kwota) {
        return (kwota > 0 && kwota <= this.saldo && kwota <= MAKS_WYPLATA);
    }

    public boolean wyplac(double kwota) {
        if (czyMozemyWyplacic(kwota)) {
            this.saldo -= kwota;
            this.liczbaOperacji++;
            return true;
        }
        return false;
    }

    public boolean maWiecejNiz(konto inneKonto) {
        if (inneKonto == null) return true;
        return this.saldo > inneKonto.getSaldo();
    }

    @Override
    public String toString() {
        return String.format("Konto nr %d [%s] saldo: %.2f | operacji: %d", this.numer, this.wlasciciel, this.saldo, this.liczbaOperacji);
    }
}
