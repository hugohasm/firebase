package com.example.inventario.mainModule.model;

import com.example.inventario.common.pojo.Product;

public interface MainInteractor {
    void subscribeToProducts();
    void unsibscribeToProducts();

    void removerProduct(Product product);

}
