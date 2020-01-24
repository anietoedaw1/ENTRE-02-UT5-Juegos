/**
 * Un objeto de esta clase guarda información relativa a un juego
 * 
 * @author -
 */
public class Juego {
    private static final String SEPARADOR = ":";
    private String titulo;
    private Genero genero;
    private int year;
    private int[] valoraciones;

    /**
     *  Inicializa los atributos a partir de la información recibida
     *  Esta información se encuentra en linea
     */
    public Juego(String linea) {
        String []tokens = linea.replace(" ","").split(SEPARADOR);
        titulo = tokens[0];
        genero = Genero.valueOf(tokens[1].toUpperCase());
        year = Integer.parseInt(tokens[2]);
        valoraciones = new int[10];
        int p = 3;
        for(int i = 0;i < valoraciones.length;i++){

            valoraciones[i] = Integer.parseInt(tokens[p]);
            p++;

        }
    }

    /**
     * accesor título
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * accesor género
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * accesor year
     */
    public int getYear() {
        return year;
    }

    /**
     * accesor valoraciones
     */
    public int[] getValoraciones() {
        return valoraciones;
    }

    /**
     * total votos emitidos
     */
    public int getVotos() {
        int acumulador = 0;
        for(int i = 0; i < valoraciones.length;i++){
            acumulador += valoraciones[i];
        }
        return acumulador;
    }

    /**
     *  obtener valoración media
     */
    public double getValoracionMedia() {
        double puntuacion = 0;

        for(int i = 0; i < valoraciones.length;i++){
            if(valoraciones[i] != 0){
                puntuacion += valoraciones[i] * i;

            }
        }
        return puntuacion/getVotos();
    }

    /**
     *  Un usuario puntúa el juego con un valor entre 1 y 10 
     */
    public void puntuar(int puntuacion) {
        int i = 0;
        while(i != puntuacion){
            i++;
        }
        valoraciones[i] += 1;
    }

    /**
     * Representación textual del juego 
     * (Ver enunciado)
     */
    public String toString() {
        return titulo.toUpperCase() + "\nGénero: " + this.genero +
        "| Lanzamiento: " + this.year +
        "\nValoración (" + getVotos() + " votos): "
        + String.format("%.2f", this.getValoracionMedia()) + "\n-----------------------------------";

    }

    public static void main(String[] args) {
        Juego juego1 = new Juego(
                "Steep: deporte: 2016  : 0:0:0:0: 0: 0:0:0:12:  10");
        System.out.println(juego1.toString());

        Juego juego2 = new Juego(
                "For the King: estrategia: 2018  : 0:0:0:7: 12: 0:33:13:2: 0");
        System.out.println(juego2.toString());

    }
}
