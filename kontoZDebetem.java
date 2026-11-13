/*
 * Wyjasnienie dlaczego wyplata z debetem dziala bez nadpisywania metody wyplac:
 * Metoda wyplac w klasie bazowej bazuje na metodzie czyMozemyWyplacic() oraz odpowiednio pomniejsza saldo.
 * Poniewaz w tej klasie nadpisujemy wylacznie czyMozemyWyplacic() tak, aby uwzglednialo dostepne srodki (saldo + limit debetu),
 * bazowa metoda wyplac poprawnie zezwoli na transakcje i obnizy saldo (nawet poniżej zera), korzystając z mechanizmów klasy bazowej.
 */
public class KontoZDebetem extends Konto {
    private double limitDebetu;

    public KontoZDebetem(String wlasciciel, double limitDebetu) {
        super(wlasciciel);
        this.limitDebetu = limitDebetu > 0 ? limitDebetu : 0;
    }

    public double getLimitDebetu() {
        return limitDebetu;
    }

    public double dostepneSrodki() {
        return getSaldo() + limitDebetu;
    }

    @Override
    public boolean czyMozemyWyplacic(double kwota) {
        return (kwota > 0 && kwota <= MAKS_WYPLATA && kwota <= dostepneSrodki());
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | z debetem, limit %.2f", this.limitDebetu);
    }
}
