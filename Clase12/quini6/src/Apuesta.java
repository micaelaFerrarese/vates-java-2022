import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Apuesta {

    private Set<Integer> numeros;
    private int boleta;
    private String apostador;

    public Apuesta(int boleta, String apostador) {
        this.boleta = boleta;
        this.apostador = apostador;
        this.numeros = new TreeSet<>();
    }

    public int getBoleta() {
        return boleta;
    }

    public void setBoleta(int boleta) {
        this.boleta = boleta;
    }

    public String getApostador() {
        return apostador;
    }

    public void setApostador(String apostador) {
        this.apostador = apostador;
    }

    public boolean agregarNumero(int numero) {
        if (numero < 1 || numero > 36 || completa()) return false;
        return numeros.add(numero);
    }

    public boolean completa() {
        return numeros.size() == 6;
    }

    public int contarAciertos(Set<Integer> sorteados) {
        return (int)numeros.stream().filter(sorteados::contains).count();


        //Set<Integer> copia = new TreeSet<>();
        //copia.addAll(sorteados);
        //copia.retainAll(numeros);
        //return copia.size();

        //int aciertos = 0;
        //for (Integer apostado: numeros) {
        //    if (sorteados.contains(apostado))
        //        aciertos++;
        //}
        //return aciertos;
    }

    public boolean esGanadora(Set<Integer> sorteados) {
        return contarAciertos(sorteados) == 6;
    }

    @Override
    public String toString() {
        return String.format("%6d %20s %s", boleta, apostador,
                numeros.stream()
                        .map(x -> String.valueOf(x))
                        .collect(Collectors.joining(" - ", "(", ")")));
    }
}
