package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.ads.internal.request.zzl;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzna;
import java.io.DataInputStream;
import java.io.IOException;

@zzhb
public final class LargeParcelTeleporter implements SafeParcelable {
   public static final Creator<LargeParcelTeleporter> CREATOR = new zzl();
   final int mVersionCode;
   ParcelFileDescriptor zzIq;
   private Parcelable zzIr;
   private boolean zzIs;

   LargeParcelTeleporter(int var1, ParcelFileDescriptor var2) {
      this.mVersionCode = var1;
      this.zzIq = var2;
      this.zzIr = null;
      this.zzIs = true;
   }

   public LargeParcelTeleporter(SafeParcelable var1) {
      this.mVersionCode = 1;
      this.zzIq = null;
      this.zzIr = var1;
      this.zzIs = false;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(this.zzIq == null) {
         Parcel var3 = Parcel.obtain();

         byte[] var5;
         try {
            this.zzIr.writeToParcel(var3, 0);
            var5 = var3.marshall();
         } finally {
            var3.recycle();
         }

         this.zzIq = this.zzf(var5);
      }

      zzl.zza(this, var1, var2);
   }

   public <T extends SafeParcelable> T zza(Creator<T> var1) {
      if(this.zzIs) {
         if(this.zzIq == null) {
            zzin.e("File descriptor is empty, returning null.");
            return null;
         }

         DataInputStream var2 = new DataInputStream(new AutoCloseInputStream(this.zzIq));

         byte[] var5;
         try {
            var5 = new byte[var2.readInt()];
            var2.readFully(var5, 0, var5.length);
         } catch (IOException var15) {
            throw new IllegalStateException("Could not read from parcel file descriptor", var15);
         } finally {
            zzna.zzb(var2);
         }

         Parcel var6 = Parcel.obtain();

         try {
            var6.unmarshall(var5, 0, var5.length);
            var6.setDataPosition(0);
            this.zzIr = (SafeParcelable)var1.createFromParcel(var6);
         } finally {
            var6.recycle();
         }

         this.zzIs = false;
      }

      return (SafeParcelable)this.zzIr;
   }

   protected <T> ParcelFileDescriptor zzf(final byte[] var1) {
      IOException var2;
      final AutoCloseOutputStream var3;
      label17: {
         ParcelFileDescriptor[] var4;
         try {
            var4 = ParcelFileDescriptor.createPipe();
            var3 = new AutoCloseOutputStream(var4[1]);
         } catch (IOException var7) {
            var2 = var7;
            var3 = null;
            break label17;
         }

         try {
            (new Thread(new Runnable() {
               public void run() {
                  // $FF: Couldn't be decompiled
               }
            })).start();
            ParcelFileDescriptor var5 = var4[0];
            return var5;
         } catch (IOException var6) {
            var2 = var6;
         }
      }

      zzin.zzb("Error transporting the ad response", var2);
      zzr.zzbF().zzb(var2, true);
      zzna.zzb(var3);
      return null;
   }
}
