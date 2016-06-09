package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.zza;
import com.google.android.gms.nearby.messages.devices.NearbyDevice;
import java.util.Arrays;

public class Message implements SafeParcelable {
   public static final Creator<Message> CREATOR = new zza();
   private static final NearbyDevice[] zzbbz;
   private final byte[] content;
   private final String type;
   final int versionCode;
   private final String zzamD;
   private final NearbyDevice[] zzbbA;

   static {
      NearbyDevice[] var0 = new NearbyDevice[]{NearbyDevice.zzbcd};
      zzbbz = var0;
   }

   Message(int var1, byte[] var2, String var3, String var4, NearbyDevice[] var5) {
      this.versionCode = var1;
      this.type = (String)zzx.zzz(var4);
      if(var3 == null) {
         var3 = "";
      }

      this.zzamD = var3;
      if(zzR(this.zzamD, this.type)) {
         boolean var11;
         if(var2 == null) {
            var11 = true;
         } else {
            var11 = false;
         }

         zzx.zzb(var11, "Content must be null for a device presence message.");
      } else {
         zzx.zzz(var2);
         boolean var7;
         if(var2.length <= 102400) {
            var7 = true;
         } else {
            var7 = false;
         }

         Object[] var8 = new Object[]{Integer.valueOf(var2.length), Integer.valueOf(102400)};
         zzx.zzb(var7, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", var8);
      }

      this.content = var2;
      if(var5 == null || var5.length == 0) {
         var5 = zzbbz;
      }

      this.zzbbA = var5;
      boolean var9;
      if(var4.length() <= 32) {
         var9 = true;
      } else {
         var9 = false;
      }

      Object[] var10 = new Object[]{Integer.valueOf(var4.length()), Integer.valueOf(32)};
      zzx.zzb(var9, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", var10);
   }

   public static boolean zzR(String var0, String var1) {
      return var0.equals("__reserved_namespace") && var1.equals("__device_presence");
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof Message)) {
            return false;
         }

         Message var2 = (Message)var1;
         if(!TextUtils.equals(this.zzamD, var2.zzamD) || !TextUtils.equals(this.type, var2.type) || !Arrays.equals(this.content, var2.content)) {
            return false;
         }
      }

      return true;
   }

   public byte[] getContent() {
      return this.content;
   }

   public String getNamespace() {
      return this.zzamD;
   }

   public String getType() {
      return this.type;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzamD, this.type, Integer.valueOf(Arrays.hashCode(this.content))};
      return zzw.hashCode(var1);
   }

   public String toString() {
      StringBuilder var1 = (new StringBuilder()).append("Message{namespace=\'").append(this.zzamD).append("\'").append(", type=\'").append(this.type).append("\'").append(", content=[");
      int var2;
      if(this.content == null) {
         var2 = 0;
      } else {
         var2 = this.content.length;
      }

      return var1.append(var2).append(" bytes]").append(", devices=").append(Arrays.toString(this.zzEn())).append("}").toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }

   public NearbyDevice[] zzEn() {
      return this.zzbbA;
   }
}
