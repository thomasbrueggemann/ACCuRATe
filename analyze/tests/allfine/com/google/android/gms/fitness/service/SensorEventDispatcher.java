package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.DataPoint;
import java.util.List;

public interface SensorEventDispatcher {
    void publish(DataPoint var1) throws RemoteException;

    void publish(List<DataPoint> var1) throws RemoteException;
}
