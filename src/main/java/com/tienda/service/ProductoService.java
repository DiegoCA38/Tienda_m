package com.tienda.service;

import com.tienda.domain.Producto;
import java.util.List;

public interface ProductoService {
    // Se obtiene un Producto, a partir del id de un producto
    public Producto getProducto(Producto producto);
    
    // Se inserta un nuevo producto si el id del producto esta vacío
    // Se actualiza un producto si el id del producto NO esta vacío
    public void save(Producto producto);
    
    // Se elimina el producto que tiene el id pasado por parámetro
    public void delete(Producto producto);
    
    //Se genera un método para obtener un ArrayList de Productos
    public List<Producto> getProductos(boolean activos);
    
    public List<Producto> consultaQuery(double precioInf,double precioSup);
    
    // Ejemplo de una consulta con un JPQL
    public List<Producto> consultaJPQL(double precioInf,double precioSup);
    
    
}
