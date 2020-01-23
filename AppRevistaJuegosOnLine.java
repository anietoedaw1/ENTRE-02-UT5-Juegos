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
            RevistaOnLineJuegos revista = new RevistaOnLineJuegos(args[0],maximo);
            revista.leerDeFichero();
            revista.toString();
        }

    }

}
