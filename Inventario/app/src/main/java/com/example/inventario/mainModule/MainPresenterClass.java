package com.example.inventario.mainModule;

import com.example.inventario.common.pojo.Product;
import com.example.inventario.mainModule.events.MainEvent;
import com.example.inventario.mainModule.model.MainInteractor;
import com.example.inventario.mainModule.model.MainInteractorClass;
import com.example.inventario.mainModule.view.MainView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainPresenterClass implements  MainPresenter {
    private MainView mView;
    private MainInteractor mInteractor;

    public MainPresenterClass(MainView mView) {
        this.mView = mView;
        this.mInteractor = new MainInteractorClass();
    }

    @Override
    public void onCreate() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void onPause() {
        mInteractor.unsibscribeToProducts();
    }

    @Override
    public void onResume() {
        mInteractor.subscribeToProducts();
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        mView = null;
    }

    @Override
    public void remove(Product product) {
        if(setProgress()){
            mInteractor.removerProduct(product);
        }
    }

    private boolean setProgress() {
        if(mView!= null){
            mView.showProgress();
            return true;
        }
        return false;
    }

    @Subscribe
    @Override
    public void onEventListener(MainEvent event) {
        if(mView != null){
            mView.hideProgress();

            switch (event.getTypeEvent()){
                case MainEvent.SUCCESS_ADD:
                    mView.add(event.getProduct());
                    break;
                case MainEvent.SUCCESS_UPDATE:
                    mView.update(event.getProduct());
                    break;
                case MainEvent.SUCCESS_REMOVE:
                    mView.remove(event.getProduct());
                    break;
                case MainEvent.ERROR_SERVER:
                    mView.onShowError(event.getResMsg());
                    break;
                case MainEvent.ERROR_TO_REMOVE:
                    mView.removeFail();
                    break;
            }
        }
    }
}
