package com.producto.producto.controller;

import com.producto.producto.entity.Producto;
import com.producto.producto.repository.ProductoRepository;
import com.producto.producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Controller
@RequestMapping("/producto")

public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String getAllProducto(Model model ){
        List<Producto> producto = productoService.getAllProducto();
        model.addAttribute("producto", producto);
        return "producto";
    }

    // Mostrar formulario para crear un nuevo producto
    @GetMapping("/crear")
    public String crearProductoForm(Model model){
        List<Producto> producto = productoService.getAllProducto();
        model.addAttribute("producto", new Producto());
        return "crear_registro";
    }

    // Guardar un nuevo producto
    @PostMapping
    public String saveProducto(@ModelAttribute Producto producto){
        productoService.saveProducto(producto);
        return "redirect:/producto";
    }

    // Mostrar formulario para editar un producto existente
    @GetMapping("/editar/{id}")
    public String editarProductoForm(@PathVariable Long id, Model model){
        Producto producto = productoService.getProductoById(id);
        model.addAttribute("producto", producto);
        return "editar_registro";
    }

    // Actualizar un producto existente
    @PostMapping("/{id}")
    public String updateProducto(@PathVariable Long id, @ModelAttribute Producto producto){
        producto.setId(id);
        productoService.saveProducto(producto);
        return "redirect:/producto";
    }

    // Eliminar un producto
    @GetMapping("/eliminar/{id}")
    public String deleteProducto(@PathVariable Long id){
        productoService.deleteProducto(id);
        return "redirect:/producto";
    }


}




























