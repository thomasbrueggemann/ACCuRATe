package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzu;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public interface zzp {
   ConnectionResult blockingConnect();

   void connect();

   boolean disconnect();

   void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4);

   boolean isConnected();

   <A extends Api.zzb, R extends Result, T extends zza.zza<R, A>> T zza(@NonNull T var1);

   boolean zza(zzu var1);

   <A extends Api.zzb, T extends zza.zza<? extends Result, A>> T zzb(@NonNull T var1);

   void zzoW();

   void zzpj();

   public interface zza {
      void zzc(int var1, boolean var2);

      void zzd(ConnectionResult var1);

      void zzi(Bundle var1);
   }
}
