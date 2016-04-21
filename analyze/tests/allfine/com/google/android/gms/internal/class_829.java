package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.class_142;
import com.google.android.gms.internal.class_826;
import com.google.android.gms.internal.lx;
import com.google.android.gms.internal.me;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.class_88;
import java.util.HashMap;

// $FF: renamed from: com.google.android.gms.internal.ly
public class class_829 {
    // $FF: renamed from: Dh com.google.android.gms.internal.me
    private final me<lx> field_4110;
    private ContentProviderClient aeR = null;
    private boolean aeS = false;
    private HashMap<LocationListener, class_829.class_1818> aeT = new HashMap();
    private final Context mContext;

    public class_829(Context var1, me<lx> var2) {
        this.mContext = var1;
        this.field_4110 = var2;
    }

    // $FF: renamed from: a (com.google.android.gms.location.LocationListener, android.os.Looper) com.google.android.gms.internal.ly$b
    private class_829.class_1818 method_4449(LocationListener param1, Looper param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ma, com.google.android.gms.location.LocationListener, android.os.Looper) void
    public void method_4450(class_826 var1, LocationListener var2, Looper var3) throws RemoteException {
        this.field_4110.method_798();
        class_829.class_1818 var4 = this.method_4449(var2, var3);
        ((class_142)this.field_4110.method_799()).method_726(var1, var4);
    }

    // $FF: renamed from: b (com.google.android.gms.internal.ma, android.app.PendingIntent) void
    public void method_4451(class_826 var1, PendingIntent var2) throws RemoteException {
        this.field_4110.method_798();
        ((class_142)this.field_4110.method_799()).method_725(var1, var2);
    }

    public Location getLastLocation() {
        this.field_4110.method_798();

        try {
            Location var2 = ((class_142)this.field_4110.method_799()).method_747(this.mContext.getPackageName());
            return var2;
        } catch (RemoteException var3) {
            throw new IllegalStateException(var3);
        }
    }

    // $FF: renamed from: lY () void
    public void method_4452() {
        if(this.aeS) {
            try {
                this.setMockMode(false);
            } catch (RemoteException var2) {
                throw new IllegalStateException(var2);
            }
        }

    }

    public void removeAllListeners() {
        // $FF: Couldn't be decompiled
    }

    public void removeLocationUpdates(PendingIntent var1) throws RemoteException {
        this.field_4110.method_798();
        ((class_142)this.field_4110.method_799()).method_721(var1);
    }

    public void removeLocationUpdates(LocationListener param1) throws RemoteException {
        // $FF: Couldn't be decompiled
    }

    public void requestLocationUpdates(LocationRequest var1, PendingIntent var2) throws RemoteException {
        this.field_4110.method_798();
        ((class_142)this.field_4110.method_799()).method_734(var1, var2);
    }

    public void requestLocationUpdates(LocationRequest var1, LocationListener var2, Looper var3) throws RemoteException {
        this.field_4110.method_798();
        class_829.class_1818 var4 = this.method_4449(var2, var3);
        ((class_142)this.field_4110.method_799()).method_735(var1, var4);
    }

    public void setMockLocation(Location var1) throws RemoteException {
        this.field_4110.method_798();
        ((class_142)this.field_4110.method_799()).setMockLocation(var1);
    }

    public void setMockMode(boolean var1) throws RemoteException {
        this.field_4110.method_798();
        ((class_142)this.field_4110.method_799()).setMockMode(var1);
        this.aeS = var1;
    }

    private static class class_1817 extends Handler {
        private final LocationListener aeU;

        public class_1817(LocationListener var1) {
            this.aeU = var1;
        }

        public class_1817(LocationListener var1, Looper var2) {
            super(var2);
            this.aeU = var1;
        }

        public void handleMessage(Message var1) {
            switch(var1.what) {
                case 1:
                    Location var2 = new Location((Location)var1.obj);
                    this.aeU.onLocationChanged(var2);
                    return;
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
            }
        }
    }

    private static class class_1818 extends class_88.class_1281 {
        private Handler aeV;

        class_1818(LocationListener var1, Looper var2) {
            class_829.class_1817 var3;
            if(var2 == null) {
                var3 = new class_829.class_1817(var1);
            } else {
                var3 = new class_829.class_1817(var1, var2);
            }

            this.aeV = var3;
        }

        public void onLocationChanged(Location var1) {
            if(this.aeV == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
            } else {
                Message var2 = Message.obtain();
                var2.what = 1;
                var2.obj = var1;
                this.aeV.sendMessage(var2);
            }
        }

        public void release() {
            this.aeV = null;
        }
    }
}
