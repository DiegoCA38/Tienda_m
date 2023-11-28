package com.tienda.controller;

import com.tienda.domain.Categoria;
import com.tienda.domain.Producto;
import com.tienda.service.CategoriaService;
import com.tienda.service.ProductoService;
import com.tienda.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.jpa.repository.Query;

@Controller
@RequestMapping("/pruebas")
public class PruebasController {
    
    
    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var productos =productoService.getProductos(false);
        model.addAttribute("productos",productos);
        model.addAttribute("totalProductos", productos.size());
        var categorias =categoriaService.getCategorias(true);
        model.addAttribute("categorias",categorias);
        return "/pruebas/listado";
    }
     @GetMapping("/listado/{idCategoria}")
    public String listado(Model model, Categoria categoria) {
        var productos = categoriaService.getCategoria(categoria).getProductos();
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        model.addAttribute("categorias", categorias);
        return "/pruebas/listado";
    }
    @GetMapping("/listado2")
    public String listado2(Model model) {
        var productos =productoService.getProductos(false);
        model.addAttribute("productos",productos);
        model.addAttribute("totalProductos", productos.size());
        var categorias =categoriaService.getCategorias(true);
        model.addAttribute("categorias",categorias);
        return "/pruebas/listado2";
    }
    @PostMapping("/query1")
    public String consulta1(@RequestParam(value="precioInf") double precioInf,
            @RequestParam(value="precioSup") double precioSup,
            Model model) {
        
        var productos =productoService.consultaQuery(precioInf, precioSup);
        model.addAttribute("productos",productos);
        model.addAttribute("precioInf", precioInf);
         model.addAttribute("precioSup", precioSup);
       
        return "/pruebas/listado2";
    }
    @PostMapping("/query2")
    public String consulta2(@RequestParam(value="precioInf") double precioInf,
            @RequestParam(value="precioSup") double precioSup,
            Model model) {
        
        var productos =productoService.consultaQuery(precioInf, precioSup);
        model.addAttribute("productos",productos);
        model.addAttribute("precioInf", precioInf);
         model.addAttribute("precioSup", precioSup);
       
        return "/pruebas/listado2";
    }
}