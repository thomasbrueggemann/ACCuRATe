package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.data.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class BitmapTeleporter implements SafeParcelable {
   public static final Creator<BitmapTeleporter> CREATOR = new zza();
   final int mVersionCode;
   ParcelFileDescriptor zzIq;
   final int zzabB;
   private Bitmap zzaiY;
   private boolean zzaiZ;
   private File zzaja;

   BitmapTeleporter(int var1, ParcelFileDescriptor var2, int var3) {
      this.mVersionCode = var1;
      this.zzIq = var2;
      this.zzabB = var3;
      this.zzaiY = null;
      this.zzaiZ = false;
   }

   private void zza(Closeable var1) {
      try {
         var1.close();
      } catch (IOException var3) {
         Log.w("BitmapTeleporter", "Could not close stream", var3);
      }
   }

   private FileOutputStream zzqb() {
      if(this.zzaja == null) {
         throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
      } else {
         File var2;
         try {
            var2 = File.createTempFile("teleporter", ".tmp", this.zzaja);
         } catch (IOException var6) {
            throw new IllegalStateException("Could not create temporary file", var6);
         }

         FileOutputStream var3;
         try {
            var3 = new FileOutputStream(var2);
            this.zzIq = ParcelFileDescriptor.open(var2, 268435456);
         } catch (FileNotFoundException var5) {
            throw new IllegalStateException("Temporary file is somehow already deleted");
         }

         var2.delete();
         return var3;
      }
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(this.zzIq == null) {
         Bitmap var3 = this.zzaiY;
         ByteBuffer var4 = ByteBuffer.allocate(var3.getRowBytes() * var3.getHeight());
         var3.copyPixelsToBuffer(var4);
         byte[] var5 = var4.array();
         DataOutputStream var6 = new DataOutputStream(this.zzqb());

         try {
            var6.writeInt(var5.length);
            var6.writeInt(var3.getWidth());
            var6.writeInt(var3.getHeight());
            var6.writeUTF(var3.getConfig().toString());
            var6.write(var5);
         } catch (IOException var11) {
            throw new IllegalStateException("Could not write into unlinked file", var11);
         } finally {
            this.zza(var6);
         }
      }

      zza.zza(this, var1, var2 | 1);
      this.zzIq = null;
   }

   public Bitmap zzqa() {
      if(!this.zzaiZ) {
         DataInputStream var1 = new DataInputStream(new AutoCloseInputStream(this.zzIq));

         byte[] var4;
         int var5;
         int var6;
         Config var7;
         try {
            var4 = new byte[var1.readInt()];
            var5 = var1.readInt();
            var6 = var1.readInt();
            var7 = Config.valueOf(var1.readUTF());
            var1.read(var4);
         } catch (IOException var13) {
            throw new IllegalStateException("Could not read from parcel file descriptor", var13);
         } finally {
            this.zza(var1);
         }

         ByteBuffer var9 = ByteBuffer.wrap(var4);
         Bitmap var10 = Bitmap.createBitmap(var5, var6, var7);
         var10.copyPixelsFromBuffer(var9);
         this.zzaiY = var10;
         this.zzaiZ = true;
      }

      return this.zzaiY;
   }
}
