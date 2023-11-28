package com.tienda.dao;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoDao extends JpaRepository<Producto, Long>{
 
    
    //ejemplo de una consulta con un Query
    
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf,
            double precioSup);

    //Ejemplo de un a consulta con JPQL
    @Query(value="Select a from Producto a where a.precio between :precioInf and :precioSup order by a.descripcion asc")
    public List<Producto> consultaJPQL(double precioInf,
            double precioSup);

}

