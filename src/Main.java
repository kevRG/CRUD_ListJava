import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Producto> products = new ArrayList<Producto>();
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        int option;

        do {
            System.out.println("===== Carrito de compra =====");
            System.out.println("1. Agregar producto");
            System.out.println("2. Modificar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Mostrar producto");
            System.out.println("0. Salir");
            System.out.println("Opcion: ");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> agregar();
                case 2 -> modificar();
                case 3 -> eliminar();
                case 4 -> mostrar();
                case 0 -> System.out.println("Hasta luego!");
                default ->  System.out.println("Opción no válida.");
            }
        } while (option != 0);
    }

    private static void agregar() {
        final Producto producto = ingresarProducto();
        products.add(producto);

        System.out.println(producto + " agregado correctamente!");
    }

    private static Producto ingresarProducto() {
        System.out.println("Ingresa el nombre del prodcuto: ");
        String nombre = sc.nextLine();

        System.out.println("Ingresa la categoría del producto: ");
        String stock = sc.nextLine();

        return new Producto(nombre, stock);
    }

    private static void modificar() {
        mostrar();

        System.out.println("Ingresa el indice del producto a modificar: ");
        int id = sc.nextInt() -1;
        sc.nextLine();

        if (id < 0 || id >= products.size()) {
            System.out.println("El producto no existe");
            return;
        }

        final Producto producto = ingresarProducto();

        products.set(id, producto);
    }
    private static void mostrar() {
        if (products.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        System.out.println("Productos:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
    }
    private static void eliminar() {
        if (products.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        
        mostrar();

        System.out.println("Ingresa el índice del producto a eliminar: ");
        int id = sc.nextInt() -1;
        sc.nextLine();

        if (id < 0 || id >= products.size()) {
            System.out.println("El producto no existe");
            return;
        }

        products.remove(id);
        System.out.println("El producto ha sido eliminado.");
    }
}
