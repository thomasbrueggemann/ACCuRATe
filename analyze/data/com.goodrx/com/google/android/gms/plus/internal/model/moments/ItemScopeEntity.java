package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.internal.model.moments.zza;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ItemScopeEntity extends FastSafeParcelableJsonResponse implements ItemScope {
   public static final zza CREATOR = new zza();
   private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap();
   String mName;
   final int mVersionCode;
   String zzF;
   String zzJN;
   double zzaNF;
   double zzaNG;
   String zzaxl;
   final Set<Integer> zzbeN;
   ItemScopeEntity zzbeO;
   List<String> zzbeP;
   ItemScopeEntity zzbeQ;
   String zzbeR;
   String zzbeS;
   String zzbeT;
   List<ItemScopeEntity> zzbeU;
   int zzbeV;
   List<ItemScopeEntity> zzbeW;
   ItemScopeEntity zzbeX;
   List<ItemScopeEntity> zzbeY;
   String zzbeZ;
   String zzbfA;
   String zzbfB;
   String zzbfC;
   ItemScopeEntity zzbfD;
   String zzbfE;
   String zzbfF;
   String zzbfG;
   String zzbfH;
   String zzbfa;
   ItemScopeEntity zzbfb;
   String zzbfc;
   String zzbfd;
   List<ItemScopeEntity> zzbfe;
   String zzbff;
   String zzbfg;
   String zzbfh;
   String zzbfi;
   String zzbfj;
   String zzbfk;
   String zzbfl;
   String zzbfm;
   ItemScopeEntity zzbfn;
   String zzbfo;
   String zzbfp;
   String zzbfq;
   ItemScopeEntity zzbfr;
   ItemScopeEntity zzbfs;
   ItemScopeEntity zzbft;
   List<ItemScopeEntity> zzbfu;
   String zzbfv;
   String zzbfw;
   String zzbfx;
   String zzbfy;
   ItemScopeEntity zzbfz;
   String zztZ;
   String zzyv;

   static {
      zzbeM.put("about", FastJsonResponse.Field.zza("about", 2, ItemScopeEntity.class));
      zzbeM.put("additionalName", FastJsonResponse.Field.zzm("additionalName", 3));
      zzbeM.put("address", FastJsonResponse.Field.zza("address", 4, ItemScopeEntity.class));
      zzbeM.put("addressCountry", FastJsonResponse.Field.zzl("addressCountry", 5));
      zzbeM.put("addressLocality", FastJsonResponse.Field.zzl("addressLocality", 6));
      zzbeM.put("addressRegion", FastJsonResponse.Field.zzl("addressRegion", 7));
      zzbeM.put("associated_media", FastJsonResponse.Field.zzb("associated_media", 8, ItemScopeEntity.class));
      zzbeM.put("attendeeCount", FastJsonResponse.Field.zzi("attendeeCount", 9));
      zzbeM.put("attendees", FastJsonResponse.Field.zzb("attendees", 10, ItemScopeEntity.class));
      zzbeM.put("audio", FastJsonResponse.Field.zza("audio", 11, ItemScopeEntity.class));
      zzbeM.put("author", FastJsonResponse.Field.zzb("author", 12, ItemScopeEntity.class));
      zzbeM.put("bestRating", FastJsonResponse.Field.zzl("bestRating", 13));
      zzbeM.put("birthDate", FastJsonResponse.Field.zzl("birthDate", 14));
      zzbeM.put("byArtist", FastJsonResponse.Field.zza("byArtist", 15, ItemScopeEntity.class));
      zzbeM.put("caption", FastJsonResponse.Field.zzl("caption", 16));
      zzbeM.put("contentSize", FastJsonResponse.Field.zzl("contentSize", 17));
      zzbeM.put("contentUrl", FastJsonResponse.Field.zzl("contentUrl", 18));
      zzbeM.put("contributor", FastJsonResponse.Field.zzb("contributor", 19, ItemScopeEntity.class));
      zzbeM.put("dateCreated", FastJsonResponse.Field.zzl("dateCreated", 20));
      zzbeM.put("dateModified", FastJsonResponse.Field.zzl("dateModified", 21));
      zzbeM.put("datePublished", FastJsonResponse.Field.zzl("datePublished", 22));
      zzbeM.put("description", FastJsonResponse.Field.zzl("description", 23));
      zzbeM.put("duration", FastJsonResponse.Field.zzl("duration", 24));
      zzbeM.put("embedUrl", FastJsonResponse.Field.zzl("embedUrl", 25));
      zzbeM.put("endDate", FastJsonResponse.Field.zzl("endDate", 26));
      zzbeM.put("familyName", FastJsonResponse.Field.zzl("familyName", 27));
      zzbeM.put("gender", FastJsonResponse.Field.zzl("gender", 28));
      zzbeM.put("geo", FastJsonResponse.Field.zza("geo", 29, ItemScopeEntity.class));
      zzbeM.put("givenName", FastJsonResponse.Field.zzl("givenName", 30));
      zzbeM.put("height", FastJsonResponse.Field.zzl("height", 31));
      zzbeM.put("id", FastJsonResponse.Field.zzl("id", 32));
      zzbeM.put("image", FastJsonResponse.Field.zzl("image", 33));
      zzbeM.put("inAlbum", FastJsonResponse.Field.zza("inAlbum", 34, ItemScopeEntity.class));
      zzbeM.put("latitude", FastJsonResponse.Field.zzj("latitude", 36));
      zzbeM.put("location", FastJsonResponse.Field.zza("location", 37, ItemScopeEntity.class));
      zzbeM.put("longitude", FastJsonResponse.Field.zzj("longitude", 38));
      zzbeM.put("name", FastJsonResponse.Field.zzl("name", 39));
      zzbeM.put("partOfTVSeries", FastJsonResponse.Field.zza("partOfTVSeries", 40, ItemScopeEntity.class));
      zzbeM.put("performers", FastJsonResponse.Field.zzb("performers", 41, ItemScopeEntity.class));
      zzbeM.put("playerType", FastJsonResponse.Field.zzl("playerType", 42));
      zzbeM.put("postOfficeBoxNumber", FastJsonResponse.Field.zzl("postOfficeBoxNumber", 43));
      zzbeM.put("postalCode", FastJsonResponse.Field.zzl("postalCode", 44));
      zzbeM.put("ratingValue", FastJsonResponse.Field.zzl("ratingValue", 45));
      zzbeM.put("reviewRating", FastJsonResponse.Field.zza("reviewRating", 46, ItemScopeEntity.class));
      zzbeM.put("startDate", FastJsonResponse.Field.zzl("startDate", 47));
      zzbeM.put("streetAddress", FastJsonResponse.Field.zzl("streetAddress", 48));
      zzbeM.put("text", FastJsonResponse.Field.zzl("text", 49));
      zzbeM.put("thumbnail", FastJsonResponse.Field.zza("thumbnail", 50, ItemScopeEntity.class));
      zzbeM.put("thumbnailUrl", FastJsonResponse.Field.zzl("thumbnailUrl", 51));
      zzbeM.put("tickerSymbol", FastJsonResponse.Field.zzl("tickerSymbol", 52));
      zzbeM.put("type", FastJsonResponse.Field.zzl("type", 53));
      zzbeM.put("url", FastJsonResponse.Field.zzl("url", 54));
      zzbeM.put("width", FastJsonResponse.Field.zzl("width", 55));
      zzbeM.put("worstRating", FastJsonResponse.Field.zzl("worstRating", 56));
   }

   public ItemScopeEntity() {
      this.mVersionCode = 1;
      this.zzbeN = new HashSet();
   }

   ItemScopeEntity(Set<Integer> var1, int var2, ItemScopeEntity var3, List<String> var4, ItemScopeEntity var5, String var6, String var7, String var8, List<ItemScopeEntity> var9, int var10, List<ItemScopeEntity> var11, ItemScopeEntity var12, List<ItemScopeEntity> var13, String var14, String var15, ItemScopeEntity var16, String var17, String var18, String var19, List<ItemScopeEntity> var20, String var21, String var22, String var23, String var24, String var25, String var26, String var27, String var28, String var29, ItemScopeEntity var30, String var31, String var32, String var33, String var34, ItemScopeEntity var35, double var36, ItemScopeEntity var38, double var39, String var41, ItemScopeEntity var42, List<ItemScopeEntity> var43, String var44, String var45, String var46, String var47, ItemScopeEntity var48, String var49, String var50, String var51, ItemScopeEntity var52, String var53, String var54, String var55, String var56, String var57, String var58) {
      this.zzbeN = var1;
      this.mVersionCode = var2;
      this.zzbeO = var3;
      this.zzbeP = var4;
      this.zzbeQ = var5;
      this.zzbeR = var6;
      this.zzbeS = var7;
      this.zzbeT = var8;
      this.zzbeU = var9;
      this.zzbeV = var10;
      this.zzbeW = var11;
      this.zzbeX = var12;
      this.zzbeY = var13;
      this.zzbeZ = var14;
      this.zzbfa = var15;
      this.zzbfb = var16;
      this.zzbfc = var17;
      this.zzbfd = var18;
      this.zztZ = var19;
      this.zzbfe = var20;
      this.zzbff = var21;
      this.zzbfg = var22;
      this.zzbfh = var23;
      this.zzaxl = var24;
      this.zzbfi = var25;
      this.zzbfj = var26;
      this.zzbfk = var27;
      this.zzbfl = var28;
      this.zzbfm = var29;
      this.zzbfn = var30;
      this.zzbfo = var31;
      this.zzbfp = var32;
      this.zzyv = var33;
      this.zzbfq = var34;
      this.zzbfr = var35;
      this.zzaNF = var36;
      this.zzbfs = var38;
      this.zzaNG = var39;
      this.mName = var41;
      this.zzbft = var42;
      this.zzbfu = var43;
      this.zzbfv = var44;
      this.zzbfw = var45;
      this.zzbfx = var46;
      this.zzbfy = var47;
      this.zzbfz = var48;
      this.zzbfA = var49;
      this.zzbfB = var50;
      this.zzbfC = var51;
      this.zzbfD = var52;
      this.zzbfE = var53;
      this.zzbfF = var54;
      this.zzJN = var55;
      this.zzF = var56;
      this.zzbfG = var57;
      this.zzbfH = var58;
   }

   public int describeContents() {
      zza var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof ItemScopeEntity)) {
         return false;
      } else if(this == var1) {
         return true;
      } else {
         ItemScopeEntity var2 = (ItemScopeEntity)var1;
         Iterator var3 = zzbeM.values().iterator();

         while(var3.hasNext()) {
            FastJsonResponse.Field var4 = (FastJsonResponse.Field)var3.next();
            if(this.zza(var4)) {
               if(!var2.zza(var4)) {
                  return false;
               }

               if(!this.zzb(var4).equals(var2.zzb(var4))) {
                  return false;
               }
            } else if(var2.zza(var4)) {
               return false;
            }
         }

         return true;
      }
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzFm();
   }

   public int hashCode() {
      Iterator var1 = zzbeM.values().iterator();

      int var2;
      int var4;
      for(var2 = 0; var1.hasNext(); var2 = var4) {
         FastJsonResponse.Field var3 = (FastJsonResponse.Field)var1.next();
         if(this.zza(var3)) {
            var4 = var2 + var3.zzrs() + this.zzb(var3).hashCode();
         } else {
            var4 = var2;
         }
      }

      return var2;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza var10000 = CREATOR;
      zza.zza(this, var1, var2);
   }

   public HashMap<String, FastJsonResponse.Field<?, ?>> zzFl() {
      return zzbeM;
   }

   public ItemScopeEntity zzFm() {
      return this;
   }

   protected boolean zza(FastJsonResponse.Field var1) {
      return this.zzbeN.contains(Integer.valueOf(var1.zzrs()));
   }

   protected Object zzb(FastJsonResponse.Field var1) {
      switch(var1.zzrs()) {
      case 2:
         return this.zzbeO;
      case 3:
         return this.zzbeP;
      case 4:
         return this.zzbeQ;
      case 5:
         return this.zzbeR;
      case 6:
         return this.zzbeS;
      case 7:
         return this.zzbeT;
      case 8:
         return this.zzbeU;
      case 9:
         return Integer.valueOf(this.zzbeV);
      case 10:
         return this.zzbeW;
      case 11:
         return this.zzbeX;
      case 12:
         return this.zzbeY;
      case 13:
         return this.zzbeZ;
      case 14:
         return this.zzbfa;
      case 15:
         return this.zzbfb;
      case 16:
         return this.zzbfc;
      case 17:
         return this.zzbfd;
      case 18:
         return this.zztZ;
      case 19:
         return this.zzbfe;
      case 20:
         return this.zzbff;
      case 21:
         return this.zzbfg;
      case 22:
         return this.zzbfh;
      case 23:
         return this.zzaxl;
      case 24:
         return this.zzbfi;
      case 25:
         return this.zzbfj;
      case 26:
         return this.zzbfk;
      case 27:
         return this.zzbfl;
      case 28:
         return this.zzbfm;
      case 29:
         return this.zzbfn;
      case 30:
         return this.zzbfo;
      case 31:
         return this.zzbfp;
      case 32:
         return this.zzyv;
      case 33:
         return this.zzbfq;
      case 34:
         return this.zzbfr;
      case 35:
      default:
         throw new IllegalStateException("Unknown safe parcelable id=" + var1.zzrs());
      case 36:
         return Double.valueOf(this.zzaNF);
      case 37:
         return this.zzbfs;
      case 38:
         return Double.valueOf(this.zzaNG);
      case 39:
         return this.mName;
      case 40:
         return this.zzbft;
      case 41:
         return this.zzbfu;
      case 42:
         return this.zzbfv;
      case 43:
         return this.zzbfw;
      case 44:
         return this.zzbfx;
      case 45:
         return this.zzbfy;
      case 46:
         return this.zzbfz;
      case 47:
         return this.zzbfA;
      case 48:
         return this.zzbfB;
      case 49:
         return this.zzbfC;
      case 50:
         return this.zzbfD;
      case 51:
         return this.zzbfE;
      case 52:
         return this.zzbfF;
      case 53:
         return this.zzJN;
      case 54:
         return this.zzF;
      case 55:
         return this.zzbfG;
      case 56:
         return this.zzbfH;
      }
   }

   // $FF: synthetic method
   public Map zzrl() {
      return this.zzFl();
   }
}
