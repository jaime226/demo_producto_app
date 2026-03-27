package com.producto.producto.service;

import com.producto.producto.entity.Producto;
import com.producto.producto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAllProducto(){
        return productoRepository.findTop10ByOrderByIdDesc();
    }
    public Producto saveProducto(Producto producto){
        return productoRepository.save(producto);

    }
    public Producto getProductoById(Long id){
        return productoRepository.findById(id).orElse(null);
    }
    public void  deleteProducto(Long id){
        productoRepository.deleteById(id);
    }
    public List<Producto> ultimoRegistro(int cantidad){
        switch (cantidad){
            case 3:
                //return registroRepository.findTop3ByOrderByIdDesc();

            default:
                return productoRepository.findAll();
        }

}
}
