package Servicio;

import java.util.Collection;
import tienda.entidades.Producto;
import tienda.persistencia.productoDAOext;

public class servicioProducto {

    private productoDAOext dao;

    public servicioProducto() {
        this.dao = new productoDAOext();
    }

    public void crearProducto(String nombre, Double precio, Integer idFabricante) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            if (precio == null) {
                throw new Exception("Debe indicar el precio");
            }
            if (idFabricante == null) {
                throw new Exception("Debe indicar el id de fabricante");
            }
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(idFabricante);

            dao.guardarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarNombreProducto(int codigo, String nombreNuevo) throws Exception {
        try {

            if (codigo == 0) {
                throw new Exception("Debe indicar el codigo del fabricante");
            }

            if (nombreNuevo == null) {
                throw new Exception("Debe indicar el nombre nuevo");
            }

            Producto producto = buscarProductoPorCodigo(codigo);

            producto.setNombre(nombreNuevo);

            dao.modificarNombreProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarPrecioProducto(int codigo, Double nuevoPrecio) throws Exception {
        try {

            if (codigo == 0) {
                throw new Exception("Debe indicar el codigo del producto");
            }
            if (nuevoPrecio == null) {
                throw new Exception("Debe indicar el nuevo precio");
            }
            dao.modificarPrecioProducto(codigo, nuevoPrecio);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarCodFabProducto(int codigo, int nuevoCodFab) throws Exception {
        try {

            if (codigo == 0) {
                throw new Exception("Debe indicar el código del producto");
            }
            if (nuevoCodFab == 0) {
                throw new Exception("Debe indicar el código de fabricante");
            }
            dao.modificarCodFabProducto(codigo, nuevoCodFab);
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto buscarProductoPorCodigo(int codigo) throws Exception {
        try {

            if (codigo == 0) {
                throw new Exception("Debe indicar el codigo");
            }

            Producto producto = dao.buscarProductoPorCodigo(codigo);

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarProducto(int codigo) throws Exception {
        try {
            String codigoS = String.valueOf(codigo);
            if (codigoS == null || codigoS.trim().isEmpty()) {
                throw new Exception("Debe indicar el codigo");
            }

            dao.eliminarProducto(codigo);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarProducto() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProducto() throws Exception {

        try {
            Collection<Producto> productos = listarProducto();

            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void mostrarNombreProducto() throws Exception {
        try {
            Collection<Producto> productos = dao.listarProductos();
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p.getNombre());
                }
            }
        } catch (Exception e) {
        }
    }

    public void mostrarNombreYPrecioDeLosProductos() throws Exception {
        try {
            Collection<Producto> productos = dao.consultarNombreYPrecioProducto();
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p.getNombre());
                    System.out.println(p.getPrecio());
                }
            }
        } catch (Exception e) {
        }
    }

    public void mostrarNombreYPrecioDeLosProductosEntre120Y202() throws Exception {
        try {
            Collection<Producto> productos = dao.consultarProductosConPrecioEntre120Y202();
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p.getNombre());
                    System.out.println(p.getPrecio());
                }
            }
        } catch (Exception e) {
        }
    }

    public void mostrarPortatiles() throws Exception {
        try {
            Collection<Producto> productos = dao.consultarPortatiles();
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p.getNombre());
                }
            }
        } catch (Exception e) {
        }
    }

    public void mostrarProductoMasBarato() throws Exception {
        try {
            Collection<Producto> productos = dao.consultarProductoMasBarato();
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p.getNombre());
                    System.out.println(p.getPrecio());
                }
            }
        } catch (Exception e) {
        }
    }

    
}
