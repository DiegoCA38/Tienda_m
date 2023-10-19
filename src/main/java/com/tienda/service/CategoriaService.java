package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    //Se genera un método para obtener un ArrayList de Categorias
    public List<Categoria> getCategorias(boolean activos);
}
