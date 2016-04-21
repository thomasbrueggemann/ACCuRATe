package com.google.android.gms.analytics.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;

public interface IAnalyticsService extends IInterface {
    void clearHits() throws RemoteException;

    void sendHit(Map var1, long var2, String var4, List<Command> var5) throws RemoteException;

    public abstract static class Stub extends Binder implements IAnalyticsService {
        private static final String DESCRIPTOR = "com.google.android.gms.analytics.internal.IAnalyticsService";
        static final int TRANSACTION_clearHits = 2;
        static final int TRANSACTION_sendHit = 1;

        public Stub() {
            this.attachInterface(this, "com.google.android.gms.analytics.internal.IAnalyticsService");
        }

        public static IAnalyticsService asInterface(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                return (IAnalyticsService)(var1 != null && var1 instanceof IAnalyticsService?(IAnalyticsService)var1:new IAnalyticsService.Proxy(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                    this.sendHit(var2.readHashMap(this.getClass().getClassLoader()), var2.readLong(), var2.readString(), var2.createTypedArrayList(Command.CREATOR));
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                    this.clearHits();
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.analytics.internal.IAnalyticsService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class Proxy implements IAnalyticsService {
        private IBinder mRemote;

        Proxy(IBinder var1) {
            this.mRemote = var1;
        }

        public IBinder asBinder() {
            return this.mRemote;
        }

        public void clearHits() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
                this.mRemote.transact(2, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        public String getInterfaceDescriptor() {
            return "com.google.android.gms.analytics.internal.IAnalyticsService";
        }

        public void sendHit(Map var1, long var2, String var4, List<Command> var5) throws RemoteException {
            Parcel var6 = Parcel.obtain();
            Parcel var7 = Parcel.obtain();

            try {
                var6.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
                var6.writeMap(var1);
                var6.writeLong(var2);
                var6.writeString(var4);
                var6.writeTypedList(var5);
                this.mRemote.transact(1, var6, var7, 0);
                var7.readException();
            } finally {
                var7.recycle();
                var6.recycle();
            }

        }
    }
}
