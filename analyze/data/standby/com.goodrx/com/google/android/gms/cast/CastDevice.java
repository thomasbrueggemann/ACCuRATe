package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.cast.zzb;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CastDevice implements SafeParcelable {
   public static final Creator<CastDevice> CREATOR = new zzb();
   private final int mVersionCode;
   private int zzBc;
   private String zzZT;
   String zzZU;
   private Inet4Address zzZV;
   private String zzZW;
   private String zzZX;
   private String zzZY;
   private int zzZZ;
   private List<WebImage> zzaaa;
   private int zzaab;
   private String zzaac;

   private CastDevice() {
      this(4, (String)null, (String)null, (String)null, (String)null, (String)null, -1, new ArrayList(), 0, -1, (String)null);
   }

   CastDevice(int var1, String var2, String var3, String var4, String var5, String var6, int var7, List<WebImage> var8, int var9, int var10, String var11) {
      this.mVersionCode = var1;
      this.zzZT = zzbZ(var2);
      this.zzZU = zzbZ(var3);
      if(!TextUtils.isEmpty(this.zzZU)) {
         try {
            InetAddress var14 = InetAddress.getByName(this.zzZU);
            if(var14 instanceof Inet4Address) {
               this.zzZV = (Inet4Address)var14;
            }
         } catch (UnknownHostException var15) {
            Log.i("CastDevice", "Unable to convert host address (" + this.zzZU + ") to ipaddress: " + var15.getMessage());
         }
      }

      this.zzZW = zzbZ(var4);
      this.zzZX = zzbZ(var5);
      this.zzZY = zzbZ(var6);
      this.zzZZ = var7;
      if(var8 == null) {
         var8 = new ArrayList();
      }

      this.zzaaa = (List)var8;
      this.zzaab = var9;
      this.zzBc = var10;
      this.zzaac = zzbZ(var11);
   }

   private static String zzbZ(String var0) {
      if(var0 == null) {
         var0 = "";
      }

      return var0;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof CastDevice)) {
            return false;
         }

         CastDevice var2 = (CastDevice)var1;
         if(this.zzZT == null) {
            if(var2.zzZT != null) {
               return false;
            }
         } else if(!zzf.zza(this.zzZT, var2.zzZT) || !zzf.zza(this.zzZV, var2.zzZV) || !zzf.zza(this.zzZX, var2.zzZX) || !zzf.zza(this.zzZW, var2.zzZW) || !zzf.zza(this.zzZY, var2.zzZY) || this.zzZZ != var2.zzZZ || !zzf.zza(this.zzaaa, var2.zzaaa) || this.zzaab != var2.zzaab || this.zzBc != var2.zzBc || !zzf.zza(this.zzaac, var2.zzaac)) {
            return false;
         }
      }

      return true;
   }

   public int getCapabilities() {
      return this.zzaab;
   }

   public String getDeviceVersion() {
      return this.zzZY;
   }

   public String getFriendlyName() {
      return this.zzZW;
   }

   public List<WebImage> getIcons() {
      return Collections.unmodifiableList(this.zzaaa);
   }

   public String getModelName() {
      return this.zzZX;
   }

   public int getServicePort() {
      return this.zzZZ;
   }

   public int getStatus() {
      return this.zzBc;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      return this.zzZT == null?0:this.zzZT.hashCode();
   }

   public String toString() {
      Object[] var1 = new Object[]{this.zzZW, this.zzZT};
      return String.format("\"%s\" (%s)", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }

   public String zzny() {
      return this.zzZT;
   }

   public String zznz() {
      return this.zzaac;
   }
}
