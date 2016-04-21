package com.google.android.gms.games.internal;

import android.net.LocalSocket;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class RealTimeSocketImpl implements RealTimeSocket {
    // $FF: renamed from: KE android.os.ParcelFileDescriptor
    private ParcelFileDescriptor field_4100;
    // $FF: renamed from: Xr java.lang.String
    private final String field_4101;
    // $FF: renamed from: Ye android.net.LocalSocket
    private final LocalSocket field_4102;

    RealTimeSocketImpl(LocalSocket var1, String var2) {
        this.field_4102 = var1;
        this.field_4101 = var2;
    }

    public void close() throws IOException {
        this.field_4102.close();
    }

    public InputStream getInputStream() throws IOException {
        return this.field_4102.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return this.field_4102.getOutputStream();
    }

    public ParcelFileDescriptor getParcelFileDescriptor() throws IOException {
        if(this.field_4100 == null && !this.isClosed()) {
            Parcel var1 = Parcel.obtain();
            var1.writeFileDescriptor(this.field_4102.getFileDescriptor());
            var1.setDataPosition(0);
            this.field_4100 = var1.readFileDescriptor();
        }

        return this.field_4100;
    }

    public boolean isClosed() {
        return !this.field_4102.isConnected() && !this.field_4102.isBound();
    }
}
