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
   // $FF: renamed from: LG android.os.ParcelFileDescriptor
   private final ParcelFileDescriptor field_4502;
   // $FF: renamed from: ZO java.io.InputStream
   private final InputStream field_4503;
   // $FF: renamed from: ZP java.io.OutputStream
   private final OutputStream field_4504;

   LibjingleNativeSocket(ParcelFileDescriptor var1) {
      this.field_4502 = var1;
      this.field_4503 = new AutoCloseInputStream(var1);
      this.field_4504 = new AutoCloseOutputStream(var1);
   }

   public void close() throws IOException {
      this.field_4502.close();
   }

   public InputStream getInputStream() throws IOException {
      return this.field_4503;
   }

   public OutputStream getOutputStream() throws IOException {
      return this.field_4504;
   }

   public ParcelFileDescriptor getParcelFileDescriptor() throws IOException {
      return this.field_4502;
   }

   public boolean isClosed() {
      try {
         this.field_4503.available();
         return false;
      } catch (IOException var2) {
         return true;
      }
   }
}
