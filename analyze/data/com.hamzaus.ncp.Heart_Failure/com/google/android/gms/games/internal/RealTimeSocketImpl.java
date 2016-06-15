package com.google.android.gms.games.internal;

import android.net.LocalSocket;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class RealTimeSocketImpl implements RealTimeSocket {
   // $FF: renamed from: Fg android.os.ParcelFileDescriptor
   private ParcelFileDescriptor field_3318;
   // $FF: renamed from: On java.lang.String
   private final String field_3319;
   // $FF: renamed from: Pa android.net.LocalSocket
   private final LocalSocket field_3320;

   RealTimeSocketImpl(LocalSocket var1, String var2) {
      this.field_3320 = var1;
      this.field_3319 = var2;
   }

   public void close() throws IOException {
      this.field_3320.close();
   }

   public InputStream getInputStream() throws IOException {
      return this.field_3320.getInputStream();
   }

   public OutputStream getOutputStream() throws IOException {
      return this.field_3320.getOutputStream();
   }

   public ParcelFileDescriptor getParcelFileDescriptor() throws IOException {
      if(this.field_3318 == null && !this.isClosed()) {
         Parcel var1 = Parcel.obtain();
         var1.writeFileDescriptor(this.field_3320.getFileDescriptor());
         var1.setDataPosition(0);
         this.field_3318 = var1.readFileDescriptor();
      }

      return this.field_3318;
   }

   public boolean isClosed() {
      return !this.field_3320.isConnected() && !this.field_3320.isBound();
   }
}
