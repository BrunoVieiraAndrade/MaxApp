package com.example.bruno.maxapp.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.bruno.maxapp.utils.DateUtils;

public class ClientStatusService extends Service {

    private final IBinder mBinder = new ClientStatusBinder();

    public class ClientStatusBinder extends Binder {
        public ClientStatusService getService() {
            // Return this instance of LocalService so clients can call public methods
            return ClientStatusService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public String getClientStatus() {
        return DateUtils.getDataEHora().concat(" - Status ativo");
    }
}
