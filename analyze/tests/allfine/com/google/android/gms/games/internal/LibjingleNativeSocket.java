package com.google.android.gms.games.internal;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class LibjingleNativeSocket implements RealTimeSocket {
    private static final String TAG = LibjingleNativeSocket.class.getSimpleName();
    // $FF: renamed from: KE android.os.ParcelFileDescriptor
    private final ParcelFileDescriptor field_5361;
    // $FF: renamed from: XX java.io.InputStream
    private final InputStream field_5362;
    // $FF: renamed from: XY java.io.OutputStream
    private final OutputStream field_5363;

    LibjingleNativeSocket(ParcelFileDescriptor var1) {
        this.field_5361 = var1;
        this.field_5362 = new AutoCloseInputStream(var1);
        this.field_5363 = new AutoCloseOutputStream(var1);
    }

    public void close() throws IOException {
        this.field_5361.close();
    }

    public InputStream getInputStream() throws IOException {
        return this.field_5362;
    }

    public OutputStream getOutputStream() throws IOException {
        return this.field_5363;
    }

    public ParcelFileDescriptor getParcelFileDescriptor() throws IOException {
        return this.field_5361;
    }

    public boolean isClosed() {
        try {
            this.field_5362.available();
            return false;
        } catch (IOException var2) {
            return true;
        }
    }
}
