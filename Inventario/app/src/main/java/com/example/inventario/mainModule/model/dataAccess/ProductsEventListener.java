package com.example.inventario.mainModule.model.dataAccess;

import com.example.inventario.common.pojo.Product;

public interface ProductsEventListener {
    void onChildAdded(Product product);
    void onChildUpdated(Product product);
    void onChildRemoved(Product product);

    void onError(int resMsg);

}
