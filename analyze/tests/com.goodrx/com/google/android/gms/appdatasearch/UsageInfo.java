package com.google.android.gms.appdatasearch;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appdatasearch.DocumentContents;
import com.google.android.gms.appdatasearch.DocumentId;
import com.google.android.gms.appdatasearch.DocumentSection;
import com.google.android.gms.appdatasearch.RegisterSectionInfo;
import com.google.android.gms.appdatasearch.zzj;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzpm;
import com.google.android.gms.internal.zzsu;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.CRC32;

public class UsageInfo implements SafeParcelable {
   public static final zzj CREATOR = new zzj();
   final int mVersionCode;
   final DocumentId zzUs;
   final long zzUt;
   int zzUu;
   final DocumentContents zzUv;
   final boolean zzUw;
   int zzUx;
   int zzUy;
   public final String zzvp;

   UsageInfo(int var1, DocumentId var2, long var3, int var5, String var6, DocumentContents var7, boolean var8, int var9, int var10) {
      this.mVersionCode = var1;
      this.zzUs = var2;
      this.zzUt = var3;
      this.zzUu = var5;
      this.zzvp = var6;
      this.zzUv = var7;
      this.zzUw = var8;
      this.zzUx = var9;
      this.zzUy = var10;
   }

   private UsageInfo(DocumentId var1, long var2, int var4, String var5, DocumentContents var6, boolean var7, int var8, int var9) {
      this(1, var1, var2, var4, var5, var6, var7, var8, var9);
   }

   // $FF: synthetic method
   UsageInfo(DocumentId var1, long var2, int var4, String var5, DocumentContents var6, boolean var7, int var8, int var9, Object var10) {
      this(var1, var2, var4, var5, var6, var7, var8, var9);
   }

   public static DocumentContents.zza zza(Intent var0, String var1, Uri var2, String var3, List<AppIndexApi.AppIndexingLink> var4) {
      DocumentContents.zza var5 = new DocumentContents.zza();
      var5.zza(zzbD(var1));
      if(var2 != null) {
         var5.zza(zzi(var2));
      }

      if(var4 != null) {
         var5.zza(zzs(var4));
      }

      String var7 = var0.getAction();
      if(var7 != null) {
         var5.zza(zzo("intent_action", var7));
      }

      String var8 = var0.getDataString();
      if(var8 != null) {
         var5.zza(zzo("intent_data", var8));
      }

      ComponentName var9 = var0.getComponent();
      if(var9 != null) {
         var5.zza(zzo("intent_activity", var9.getClassName()));
      }

      Bundle var10 = var0.getExtras();
      if(var10 != null) {
         String var11 = var10.getString("intent_extra_data_key");
         if(var11 != null) {
            var5.zza(zzo("intent_extra_data", var11));
         }
      }

      return var5.zzbz(var3).zzL(true);
   }

   public static DocumentId zza(String var0, Intent var1) {
      return zzn(var0, zzg(var1));
   }

   private static DocumentSection zzbD(String var0) {
      return new DocumentSection(var0, (new RegisterSectionInfo.zza("title")).zzap(1).zzN(true).zzbC("name").zzmh(), "text1");
   }

   private static String zzg(Intent var0) {
      String var1 = var0.toUri(1);
      CRC32 var2 = new CRC32();

      try {
         var2.update(var1.getBytes("UTF-8"));
      } catch (UnsupportedEncodingException var4) {
         throw new IllegalStateException(var4);
      }

      return Long.toHexString(var2.getValue());
   }

   private static DocumentSection zzi(Uri var0) {
      return new DocumentSection(var0.toString(), (new RegisterSectionInfo.zza("web_url")).zzap(4).zzM(true).zzbC("url").zzmh());
   }

   private static DocumentId zzn(String var0, String var1) {
      return new DocumentId(var0, "", var1);
   }

   private static DocumentSection zzo(String var0, String var1) {
      return new DocumentSection(var1, (new RegisterSectionInfo.zza(var0)).zzM(true).zzmh(), var0);
   }

   private static DocumentSection zzs(List<AppIndexApi.AppIndexingLink> var0) {
      zzpm.zza var1 = new zzpm.zza();
      zzpm.zza[] var2 = new zzpm.zza[var0.size()];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         var2[var3] = new zzpm.zza();
         AppIndexApi.AppIndexingLink var4 = (AppIndexApi.AppIndexingLink)var0.get(var3);
         var2[var3].zzaMq = var4.appIndexingUrl.toString();
         var2[var3].viewId = var4.viewId;
         if(var4.webUrl != null) {
            var2[var3].zzaMr = var4.webUrl.toString();
         }
      }

      var1.zzaMo = var2;
      return new DocumentSection(zzsu.toByteArray(var1), (new RegisterSectionInfo.zza("outlinks")).zzM(true).zzbC(".private:outLinks").zzbB("blob").zzmh());
   }

   public int describeContents() {
      zzj var10000 = CREATOR;
      return 0;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.zzUs, Long.valueOf(this.zzUt), Integer.valueOf(this.zzUu), Integer.valueOf(this.zzUy)};
      return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzj var10000 = CREATOR;
      zzj.zza(this, var1, var2);
   }

   public static final class zza {
      private String zzOJ;
      private DocumentId zzUs;
      private long zzUt = -1L;
      private int zzUu = -1;
      private DocumentContents zzUv;
      private boolean zzUw = false;
      private int zzUx = -1;
      private int zzUy = 0;

      public UsageInfo.zza zzO(boolean var1) {
         this.zzUw = var1;
         return this;
      }

      public UsageInfo.zza zza(DocumentContents var1) {
         this.zzUv = var1;
         return this;
      }

      public UsageInfo.zza zza(DocumentId var1) {
         this.zzUs = var1;
         return this;
      }

      public UsageInfo.zza zzar(int var1) {
         this.zzUu = var1;
         return this;
      }

      public UsageInfo.zza zzas(int var1) {
         this.zzUy = var1;
         return this;
      }

      public UsageInfo zzmi() {
         return new UsageInfo(this.zzUs, this.zzUt, this.zzUu, this.zzOJ, this.zzUv, this.zzUw, this.zzUx, this.zzUy);
      }

      public UsageInfo.zza zzw(long var1) {
         this.zzUt = var1;
         return this;
      }
   }
}
