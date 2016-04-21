package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// $FF: renamed from: com.google.android.gms.common.a
public class class_949 implements ServiceConnection {
    // $FF: renamed from: HC boolean
    boolean field_4422 = false;
    // $FF: renamed from: HD java.util.concurrent.BlockingQueue
    private final BlockingQueue<IBinder> field_4423 = new LinkedBlockingQueue();

    // $FF: renamed from: fW () android.os.IBinder
    public IBinder method_4986() throws InterruptedException {
        if(this.field_4422) {
            throw new IllegalStateException();
        } else {
            this.field_4422 = true;
            return (IBinder)this.field_4423.take();
        }
    }

    public void onServiceConnected(ComponentName var1, IBinder var2) {
        this.field_4423.add(var2);
    }

    public void onServiceDisconnected(ComponentName var1) {
    }
}
