package com.google.android.gms.games.internal;

import android.net.LocalSocket;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class RealTimeSocketImpl implements RealTimeSocket {
   // $FF: renamed from: LG android.os.ParcelFileDescriptor
   private ParcelFileDescriptor field_3280;
   // $FF: renamed from: ZV android.net.LocalSocket
   private final LocalSocket field_3281;
   // $FF: renamed from: Zk java.lang.String
   private final String field_3282;

   RealTimeSocketImpl(LocalSocket var1, String var2) {
      this.field_3281 = var1;
      this.field_3282 = var2;
   }

   public void close() throws IOException {
      this.field_3281.close();
   }

   public InputStream getInputStream() throws IOException {
      return this.field_3281.getInputStream();
   }

   public OutputStream getOutputStream() throws IOException {
      return this.field_3281.getOutputStream();
   }

   public ParcelFileDescriptor getParcelFileDescriptor() throws IOException {
      if(this.field_3280 == null && !this.isClosed()) {
         Parcel var1 = Parcel.obtain();
         var1.writeFileDescriptor(this.field_3281.getFileDescriptor());
         var1.setDataPosition(0);
         this.field_3280 = var1.readFileDescriptor();
      }

      return this.field_3280;
   }

   public boolean isClosed() {
      return !this.field_3281.isConnected() && !this.field_3281.isBound();
   }
}
