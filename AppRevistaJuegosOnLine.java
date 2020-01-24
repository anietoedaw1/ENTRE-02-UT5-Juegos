/**
 * Punto de entrada a la aplicación
 * 
 * @author - 
 */
public class AppRevistaJuegosOnLine 
{
    public static void main(String[] args)
    {
        if(args.length != 2 ){
            System.out.println("Error en argumentos" + 
                "\nSintaxis: java AppRevistaJuegosOnline <nombre> <n>");
        }
        else{
            int maximo = Integer.parseInt(args[1]);
            String nombre = args[0];
            RevistaOnLineJuegos revista = new RevistaOnLineJuegos(nombre,maximo);
            revista.leerDeFichero();
            System.out.println(revista.toString());
            System.out.println("*************************************** \nPuntuando...");
            revista.puntuar("Planet Zoo",8);
            revista.puntuar("Steep",7);
            revista.puntuar("Catastronauts",9);
            revista.puntuar("Wattam",9);
            System.out.println("\nDespues de puntuar la revista queda\n");
            System.out.println(revista.toString());
            System.out.println("*************************************** \nBorrando juegos de genero ROL...");
            System.out.println("\nBorrados " + revista.borrarDeGenero(Genero.ROL) + " juegos");
            System.out.println(revista.toString());
            
        }

    }

}
