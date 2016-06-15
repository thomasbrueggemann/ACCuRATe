package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.data.a;
import com.google.android.gms.common.data.class_750;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

// $FF: renamed from: com.google.android.gms.common.data.a
public class class_749 implements SafeParcelable {
   public static final Creator<a> CREATOR = new class_750();
   // $FF: renamed from: AQ int
   final int field_4041;
   // $FF: renamed from: Et android.os.ParcelFileDescriptor
   ParcelFileDescriptor field_4042;
   // $FF: renamed from: Eu android.graphics.Bitmap
   private Bitmap field_4043;
   // $FF: renamed from: Ev boolean
   private boolean field_4044;
   // $FF: renamed from: Ew java.io.File
   private File field_4045;
   // $FF: renamed from: xJ int
   final int field_4046;

   class_749(int var1, ParcelFileDescriptor var2, int var3) {
      this.field_4046 = var1;
      this.field_4042 = var2;
      this.field_4041 = var3;
      this.field_4043 = null;
      this.field_4044 = false;
   }

   public class_749(Bitmap var1) {
      this.field_4046 = 1;
      this.field_4042 = null;
      this.field_4041 = 0;
      this.field_4043 = var1;
      this.field_4044 = true;
   }

   // $FF: renamed from: a (java.io.Closeable) void
   private void method_4285(Closeable var1) {
      try {
         var1.close();
      } catch (IOException var3) {
         Log.w("BitmapTeleporter", "Could not close stream", var3);
      }
   }

   // $FF: renamed from: eO () java.io.FileOutputStream
   private FileOutputStream method_4286() {
      if(this.field_4045 == null) {
         throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
      } else {
         File var2;
         try {
            var2 = File.createTempFile("teleporter", ".tmp", this.field_4045);
         } catch (IOException var6) {
            throw new IllegalStateException("Could not create temporary file", var6);
         }

         FileOutputStream var3;
         try {
            var3 = new FileOutputStream(var2);
            this.field_4042 = ParcelFileDescriptor.open(var2, 268435456);
         } catch (FileNotFoundException var5) {
            throw new IllegalStateException("Temporary file is somehow already deleted");
         }

         var2.delete();
         return var3;
      }
   }

   // $FF: renamed from: a (java.io.File) void
   public void method_4287(File var1) {
      if(var1 == null) {
         throw new NullPointerException("Cannot set null temp directory");
      } else {
         this.field_4045 = var1;
      }
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: eN () android.graphics.Bitmap
   public Bitmap method_4288() {
      if(!this.field_4044) {
         DataInputStream var1 = new DataInputStream(new AutoCloseInputStream(this.field_4042));

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
            this.method_4285(var1);
         }

         ByteBuffer var9 = ByteBuffer.wrap(var4);
         Bitmap var10 = Bitmap.createBitmap(var5, var6, var7);
         var10.copyPixelsFromBuffer(var9);
         this.field_4043 = var10;
         this.field_4044 = true;
      }

      return this.field_4043;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(this.field_4042 == null) {
         Bitmap var3 = this.field_4043;
         ByteBuffer var4 = ByteBuffer.allocate(var3.getRowBytes() * var3.getHeight());
         var3.copyPixelsToBuffer(var4);
         byte[] var5 = var4.array();
         DataOutputStream var6 = new DataOutputStream(this.method_4286());

         try {
            var6.writeInt(var5.length);
            var6.writeInt(var3.getWidth());
            var6.writeInt(var3.getHeight());
            var6.writeUTF(var3.getConfig().toString());
            var6.write(var5);
         } catch (IOException var11) {
            throw new IllegalStateException("Could not write into unlinked file", var11);
         } finally {
            this.method_4285(var6);
         }
      }

      class_750.method_4289(this, var1, var2);
   }
}
