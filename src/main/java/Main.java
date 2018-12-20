
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String... args){

        LinkedList<Producto> productos = new LinkedList<>();

        productos.addAll( Arrays.asList( new Producto[]{
                new Producto("Coca-Cola Zero", "Litros: 1.5", 20, Producto.UnidadVenta.CANTIDAD ),
                new Producto( "Coca-Cola", "Litros: 1.5", 18, Producto.UnidadVenta.CANTIDAD ),
                new Producto( "Shampoo Sedal", "Contenido: 500ml", 19, Producto.UnidadVenta.CANTIDAD ),
                new Producto( "Frutillas", 64, Producto.UnidadVenta.KILO ),
        }));

        productos.forEach( System.out::println );

        System.out.println("=============================");

        Collections.sort(productos);

        System.out.println( String.format("Producto más caro: %s", productos.getLast().getNombre() ));
        System.out.println( String.format("Producto más barato: %s", productos.getFirst().getNombre()) );


    }

}
