package com.example.inventario.mainModule.view.adapters;

import com.example.inventario.common.pojo.Product;

public interface OnItemClickListener {
    void onItemClick(Product product);
    void onLongItemClick(Product product);
}
