package com.example.inventario.mainModule;

import com.example.inventario.common.pojo.Product;
import com.example.inventario.mainModule.events.MainEvent;

public interface MainPresenter {
    void onCreate();
    void onPause();
    void onResume();
    void onDestroy();

    void remove(Product product);

    void onEventListener(MainEvent event);
}
