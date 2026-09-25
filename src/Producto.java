public class Producto {
    private String nombre;
    private String categoria;

    public Producto(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }

    @Override
    public String toString() { return nombre + " categoría: " + categoria; }
}