import javafx.scene.effect.Reflection;
import org.apache.commons.text.WordUtils;

import java.util.Arrays;

public class Producto implements Comparable<Producto> {

    public static enum UnidadVenta { CANTIDAD, KILO, LITRO }

    private String _nombre, _descripcion;
    private Integer _precio;
    private UnidadVenta _unidadVenta;

    public Producto(String nombre, String descripcion, Integer precio, UnidadVenta unidadVenta){

        checkNull(nombre, descripcion, precio, unidadVenta);
        if( nombre.isEmpty() )
            throw new IllegalArgumentException( "El nombre no puede estar vacio" );

        _nombre = WordUtils.capitalize( nombre );
        _descripcion = descripcion;
        _precio = precio;
        _unidadVenta = unidadVenta;
    }

    public Producto(String nombre, Integer precio, UnidadVenta unidadVenta){
        this(nombre, "", precio, unidadVenta);
    }

    public String getNombre(){
        return _nombre;
    }

    public String getDescripcion(){
        return _descripcion;
    }

    public Integer getPrecio() {
        return _precio;
    }

    public UnidadVenta getUnidadVenta(){
        return _unidadVenta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(
                String.format("Nombre: %s /// ", getNombre() )
        );

        if( !getDescripcion().isEmpty() )
            sb.append(
                    String.format( "%s /// ", getDescripcion() )
            );

        sb.append( String.format( "Precio: $%d", getPrecio() ) );

        if( getUnidadVenta() != UnidadVenta.CANTIDAD )
            sb.append(
                    String.format( " /// Unidad de venta: %s", getUnidadVenta().toString().toLowerCase() )
            );

        return sb.toString();
    }

    @Override
    public int compareTo(Producto p2) {
        return getPrecio().compareTo( p2.getPrecio() );
    }

    public void checkNull(Object... params){
        for( Object param:params )
            if( param == null )
                throw new IllegalArgumentException( "Ningun argumento puede ser null" );
    }
}
