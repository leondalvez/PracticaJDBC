/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import Servicio.servicioFabricante;
import Servicio.servicioProducto;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        servicioFabricante sf = new servicioFabricante();
        servicioProducto sp = new servicioProducto();

        /* 
        Prueba de guardado
        try {
            sf.crearFabricante("Michi");
            sf.crearFabricante("Fakuri");
            sp.crearProducto("Portatil", 110.0, 2);
            sp.crearProducto("Camara", 127.0, 1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
         */
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opcion = 0;

        /*  a) Lista el nombre de todos los productos que hay en la tabla producto.
            b) Lista los nombres y los precios de todos los productos de la tabla producto.
            c) Listar aquellos productos que su precio esté entre 120 y 202.
            d) Buscar y listar todos los Portátiles de la tabla producto.
            e) Listar el nombre y el precio del producto más barato.
            f) Ingresar un producto a la base de datos.
            g) Ingresar un fabricante a la base de datos
            h) Editar un producto con datos a elección. */
        try {
            System.out.println("--MENÚ--");
            System.out.println("Elija su consulta:");
            System.out.println("1 - Nombre de todos los productos que hay en la tabla producto.");
            System.out.println("2 - Nombres y precios de todos los productos de la tabla producto. ");
            System.out.println("3 - Productos que su precio esté entre 120 y 202.");
            System.out.println("4 - Portátiles de la tabla producto.");
            System.out.println("5 - Nombre y precio del producto más barato.");
            System.out.println("6 - Ingresar un producto a la base de datos.");
            System.out.println("7 - Ingresar un fabricante a la base de datos.");
            System.out.println("8 - Editar un producto con datos a elección.");

            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    sp.mostrarNombreProducto();
                    break;
                case 2:
                    sp.mostrarNombreYPrecioDeLosProductos();
                    break;
                case 3:
                    sp.mostrarNombreYPrecioDeLosProductosEntre120Y202();
                    break;
                case 4:
                    sp.mostrarPortatiles();
                    break;
                case 5:
                    sp.mostrarProductoMasBarato();
                    break;
                case 6: 
                    try {
                        System.out.println("Ingrese el nombre del producto");
                        String nombre = leer.next();
                        if (nombre == null || nombre.trim().isEmpty()) {
                            throw new Exception("Debe indicar el nombre");
                        }
                        System.out.println("Ingrese el precio del producto");
                        Double precio = leer.nextDouble();
                        if (precio == null) {
                            throw new Exception("Debe indicar el precio");
                        }
                        System.out.println("Ingrese el codigo de fabricante del producto");
                        int codigoFabricante = leer.nextInt();
                        if (codigoFabricante == 0) {
                            throw new Exception("Debe indicar el código de fabricante");
                        }
                        sp.crearProducto(nombre, precio, codigoFabricante);
                        System.out.println("Ingreso exitosamente el siguiente producto");
                        System.out.println("Nombre: " + nombre);
                        System.out.println("Precio es: " + precio);
                        System.out.println("Código de Fabricante: " + codigoFabricante);
                    } catch (Exception e) {
                    }
                    break;
                case 7:
                    try {
                        System.out.println("Ingrese el nombre del fabricante");
                        String nombre = leer.next();
                        if (nombre == null || nombre.trim().isEmpty()) {
                            throw new Exception("Debe indicar el nombre");
                        }
                        sf.crearFabricante(nombre);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        System.out.println("Elegí el dato que querés modíficar del producto");
                        System.out.println("1: Modíficar nombre del producto");
                        System.out.println("2: Modíficar precio del producto");
                        System.out.println("3: Modíficar código del fabricante del producto");
                        int opc = leer.nextInt();
                        switch (opc) {
                            case 1:
                                System.out.println("Ingrese el código del producto a modificar");
                                int codigo = leer.nextInt();
                                System.out.println("Ingrese el nombre nuevo del producto");
                                String nombreNuevo = leer.next();
                                sp.modificarNombreProducto(codigo, nombreNuevo);
                                System.out.println("La modificación fue exitosa");
                                break;
                            case 2:
                                System.out.println("Ingrese el código del producto a modificar");
                                int codigo1 = leer.nextInt();
                                System.out.println("Ingrese el nuevo precio del producto a modificar");
                                Double precio = leer.nextDouble();
                                sp.modificarPrecioProducto(codigo1, precio);
                                System.out.println("La modificación fue exitosa");
                                break;
                            case 3:
                                System.out.println("Ingrese el código del producto al que quiere modificar el codigo de fabricante");
                                int codigo2 = leer.nextInt();
                                System.out.println("Ingrese el nuevo código de fabricante del producto a modificar");
                                int codigo3 = leer.nextInt();
                                sp.modificarCodFabProducto(codigo2, codigo3);
                                System.out.println("La modificación fue exitosa");
                                break;
                            default:
                                System.out.println("Opcion incorrecta");
                        }
                    } catch (Exception e) {
                    }
                       break;
                default:
                    System.out.println("Opcion incorrecta.Intente nuevamente.");
            }
        } catch (NumberFormatException | InputMismatchException e) {
            throw e;
        }
    }
}
