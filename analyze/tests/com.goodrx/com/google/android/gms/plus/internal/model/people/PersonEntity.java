package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.internal.model.people.zza;
import com.google.android.gms.plus.internal.model.people.zzb;
import com.google.android.gms.plus.internal.model.people.zzc;
import com.google.android.gms.plus.internal.model.people.zzd;
import com.google.android.gms.plus.internal.model.people.zze;
import com.google.android.gms.plus.internal.model.people.zzf;
import com.google.android.gms.plus.internal.model.people.zzg;
import com.google.android.gms.plus.internal.model.people.zzh;
import com.google.android.gms.plus.internal.model.people.zzi;
import com.google.android.gms.plus.internal.model.people.zzj;
import com.google.android.gms.plus.model.people.Person;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class PersonEntity extends FastSafeParcelableJsonResponse implements Person {
   public static final zza CREATOR = new zza();
   private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap();
   final int mVersionCode;
   String zzF;
   String zzWQ;
   String zzaaL;
   final Set<Integer> zzbeN;
   String zzbfL;
   PersonEntity.AgeRangeEntity zzbfM;
   String zzbfN;
   String zzbfO;
   int zzbfP;
   PersonEntity.CoverEntity zzbfQ;
   String zzbfR;
   PersonEntity.ImageEntity zzbfS;
   boolean zzbfT;
   PersonEntity.NameEntity zzbfU;
   String zzbfV;
   int zzbfW;
   List<PersonEntity.OrganizationsEntity> zzbfX;
   List<PersonEntity.PlacesLivedEntity> zzbfY;
   int zzbfZ;
   int zzbga;
   String zzbgb;
   List<PersonEntity.UrlsEntity> zzbgc;
   boolean zzbgd;
   int zztT;
   String zzyv;

   static {
      zzbeM.put("aboutMe", FastJsonResponse.Field.zzl("aboutMe", 2));
      zzbeM.put("ageRange", FastJsonResponse.Field.zza("ageRange", 3, PersonEntity.AgeRangeEntity.class));
      zzbeM.put("birthday", FastJsonResponse.Field.zzl("birthday", 4));
      zzbeM.put("braggingRights", FastJsonResponse.Field.zzl("braggingRights", 5));
      zzbeM.put("circledByCount", FastJsonResponse.Field.zzi("circledByCount", 6));
      zzbeM.put("cover", FastJsonResponse.Field.zza("cover", 7, PersonEntity.CoverEntity.class));
      zzbeM.put("currentLocation", FastJsonResponse.Field.zzl("currentLocation", 8));
      zzbeM.put("displayName", FastJsonResponse.Field.zzl("displayName", 9));
      zzbeM.put("gender", FastJsonResponse.Field.zza("gender", 12, (new StringToIntConverter()).zzh("male", 0).zzh("female", 1).zzh("other", 2), false));
      zzbeM.put("id", FastJsonResponse.Field.zzl("id", 14));
      zzbeM.put("image", FastJsonResponse.Field.zza("image", 15, PersonEntity.ImageEntity.class));
      zzbeM.put("isPlusUser", FastJsonResponse.Field.zzk("isPlusUser", 16));
      zzbeM.put("language", FastJsonResponse.Field.zzl("language", 18));
      zzbeM.put("name", FastJsonResponse.Field.zza("name", 19, PersonEntity.NameEntity.class));
      zzbeM.put("nickname", FastJsonResponse.Field.zzl("nickname", 20));
      zzbeM.put("objectType", FastJsonResponse.Field.zza("objectType", 21, (new StringToIntConverter()).zzh("person", 0).zzh("page", 1), false));
      zzbeM.put("organizations", FastJsonResponse.Field.zzb("organizations", 22, PersonEntity.OrganizationsEntity.class));
      zzbeM.put("placesLived", FastJsonResponse.Field.zzb("placesLived", 23, PersonEntity.PlacesLivedEntity.class));
      zzbeM.put("plusOneCount", FastJsonResponse.Field.zzi("plusOneCount", 24));
      zzbeM.put("relationshipStatus", FastJsonResponse.Field.zza("relationshipStatus", 25, (new StringToIntConverter()).zzh("single", 0).zzh("in_a_relationship", 1).zzh("engaged", 2).zzh("married", 3).zzh("its_complicated", 4).zzh("open_relationship", 5).zzh("widowed", 6).zzh("in_domestic_partnership", 7).zzh("in_civil_union", 8), false));
      zzbeM.put("tagline", FastJsonResponse.Field.zzl("tagline", 26));
      zzbeM.put("url", FastJsonResponse.Field.zzl("url", 27));
      zzbeM.put("urls", FastJsonResponse.Field.zzb("urls", 28, PersonEntity.UrlsEntity.class));
      zzbeM.put("verified", FastJsonResponse.Field.zzk("verified", 29));
   }

   public PersonEntity() {
      this.mVersionCode = 1;
      this.zzbeN = new HashSet();
   }

   PersonEntity(Set<Integer> var1, int var2, String var3, PersonEntity.AgeRangeEntity var4, String var5, String var6, int var7, PersonEntity.CoverEntity var8, String var9, String var10, int var11, String var12, PersonEntity.ImageEntity var13, boolean var14, String var15, PersonEntity.NameEntity var16, String var17, int var18, List<PersonEntity.OrganizationsEntity> var19, List<PersonEntity.PlacesLivedEntity> var20, int var21, int var22, String var23, String var24, List<PersonEntity.UrlsEntity> var25, boolean var26) {
      this.zzbeN = var1;
      this.mVersionCode = var2;
      this.zzbfL = var3;
      this.zzbfM = var4;
      this.zzbfN = var5;
      this.zzbfO = var6;
      this.zzbfP = var7;
      this.zzbfQ = var8;
      this.zzbfR = var9;
      this.zzWQ = var10;
      this.zztT = var11;
      this.zzyv = var12;
      this.zzbfS = var13;
      this.zzbfT = var14;
      this.zzaaL = var15;
      this.zzbfU = var16;
      this.zzbfV = var17;
      this.zzbfW = var18;
      this.zzbfX = var19;
      this.zzbfY = var20;
      this.zzbfZ = var21;
      this.zzbga = var22;
      this.zzbgb = var23;
      this.zzF = var24;
      this.zzbgc = var25;
      this.zzbgd = var26;
   }

   public int describeContents() {
      zza var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof PersonEntity)) {
         return false;
      } else if(this == var1) {
         return true;
      } else {
         PersonEntity var2 = (PersonEntity)var1;
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
      return this.zzFp();
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

   public PersonEntity zzFp() {
      return this;
   }

   protected boolean zza(FastJsonResponse.Field var1) {
      return this.zzbeN.contains(Integer.valueOf(var1.zzrs()));
   }

   protected Object zzb(FastJsonResponse.Field var1) {
      switch(var1.zzrs()) {
      case 2:
         return this.zzbfL;
      case 3:
         return this.zzbfM;
      case 4:
         return this.zzbfN;
      case 5:
         return this.zzbfO;
      case 6:
         return Integer.valueOf(this.zzbfP);
      case 7:
         return this.zzbfQ;
      case 8:
         return this.zzbfR;
      case 9:
         return this.zzWQ;
      case 10:
      case 11:
      case 13:
      case 17:
      default:
         throw new IllegalStateException("Unknown safe parcelable id=" + var1.zzrs());
      case 12:
         return Integer.valueOf(this.zztT);
      case 14:
         return this.zzyv;
      case 15:
         return this.zzbfS;
      case 16:
         return Boolean.valueOf(this.zzbfT);
      case 18:
         return this.zzaaL;
      case 19:
         return this.zzbfU;
      case 20:
         return this.zzbfV;
      case 21:
         return Integer.valueOf(this.zzbfW);
      case 22:
         return this.zzbfX;
      case 23:
         return this.zzbfY;
      case 24:
         return Integer.valueOf(this.zzbfZ);
      case 25:
         return Integer.valueOf(this.zzbga);
      case 26:
         return this.zzbgb;
      case 27:
         return this.zzF;
      case 28:
         return this.zzbgc;
      case 29:
         return Boolean.valueOf(this.zzbgd);
      }
   }

   // $FF: synthetic method
   public Map zzrl() {
      return this.zzFl();
   }

   public static final class AgeRangeEntity extends FastSafeParcelableJsonResponse implements Person.AgeRange {
      public static final zzb CREATOR = new zzb();
      private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap();
      final int mVersionCode;
      final Set<Integer> zzbeN;
      int zzbge;
      int zzbgf;

      static {
         zzbeM.put("max", FastJsonResponse.Field.zzi("max", 2));
         zzbeM.put("min", FastJsonResponse.Field.zzi("min", 3));
      }

      public AgeRangeEntity() {
         this.mVersionCode = 1;
         this.zzbeN = new HashSet();
      }

      AgeRangeEntity(Set<Integer> var1, int var2, int var3, int var4) {
         this.zzbeN = var1;
         this.mVersionCode = var2;
         this.zzbge = var3;
         this.zzbgf = var4;
      }

      public int describeContents() {
         zzb var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof PersonEntity.AgeRangeEntity)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            PersonEntity.AgeRangeEntity var2 = (PersonEntity.AgeRangeEntity)var1;
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
         return this.zzFq();
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
         zzb var10000 = CREATOR;
         zzb.zza(this, var1, var2);
      }

      public HashMap<String, FastJsonResponse.Field<?, ?>> zzFl() {
         return zzbeM;
      }

      public PersonEntity.AgeRangeEntity zzFq() {
         return this;
      }

      protected boolean zza(FastJsonResponse.Field var1) {
         return this.zzbeN.contains(Integer.valueOf(var1.zzrs()));
      }

      protected Object zzb(FastJsonResponse.Field var1) {
         switch(var1.zzrs()) {
         case 2:
            return Integer.valueOf(this.zzbge);
         case 3:
            return Integer.valueOf(this.zzbgf);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.zzrs());
         }
      }

      // $FF: synthetic method
      public Map zzrl() {
         return this.zzFl();
      }
   }

   public static final class CoverEntity extends FastSafeParcelableJsonResponse implements Person.Cover {
      public static final zzc CREATOR = new zzc();
      private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap();
      final int mVersionCode;
      final Set<Integer> zzbeN;
      PersonEntity.CoverInfoEntity zzbgg;
      PersonEntity.CoverPhotoEntity zzbgh;
      int zzbgi;

      static {
         zzbeM.put("coverInfo", FastJsonResponse.Field.zza("coverInfo", 2, PersonEntity.CoverInfoEntity.class));
         zzbeM.put("coverPhoto", FastJsonResponse.Field.zza("coverPhoto", 3, PersonEntity.CoverPhotoEntity.class));
         zzbeM.put("layout", FastJsonResponse.Field.zza("layout", 4, (new StringToIntConverter()).zzh("banner", 0), false));
      }

      public CoverEntity() {
         this.mVersionCode = 1;
         this.zzbeN = new HashSet();
      }

      CoverEntity(Set<Integer> var1, int var2, PersonEntity.CoverInfoEntity var3, PersonEntity.CoverPhotoEntity var4, int var5) {
         this.zzbeN = var1;
         this.mVersionCode = var2;
         this.zzbgg = var3;
         this.zzbgh = var4;
         this.zzbgi = var5;
      }

      public int describeContents() {
         zzc var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof PersonEntity.CoverEntity)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            PersonEntity.CoverEntity var2 = (PersonEntity.CoverEntity)var1;
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
         return this.zzFr();
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
         zzc var10000 = CREATOR;
         zzc.zza(this, var1, var2);
      }

      public HashMap<String, FastJsonResponse.Field<?, ?>> zzFl() {
         return zzbeM;
      }

      public PersonEntity.CoverEntity zzFr() {
         return this;
      }

      protected boolean zza(FastJsonResponse.Field var1) {
         return this.zzbeN.contains(Integer.valueOf(var1.zzrs()));
      }

      protected Object zzb(FastJsonResponse.Field var1) {
         switch(var1.zzrs()) {
         case 2:
            return this.zzbgg;
         case 3:
            return this.zzbgh;
         case 4:
            return Integer.valueOf(this.zzbgi);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.zzrs());
         }
      }

      // $FF: synthetic method
      public Map zzrl() {
         return this.zzFl();
      }
   }

   public static final class CoverInfoEntity extends FastSafeParcelableJsonResponse implements Person.CoverInfo {
      public static final zzd CREATOR = new zzd();
      private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap();
      final int mVersionCode;
      final Set<Integer> zzbeN;
      int zzbgj;
      int zzbgk;

      static {
         zzbeM.put("leftImageOffset", FastJsonResponse.Field.zzi("leftImageOffset", 2));
         zzbeM.put("topImageOffset", FastJsonResponse.Field.zzi("topImageOffset", 3));
      }

      public CoverInfoEntity() {
         this.mVersionCode = 1;
         this.zzbeN = new HashSet();
      }

      CoverInfoEntity(Set<Integer> var1, int var2, int var3, int var4) {
         this.zzbeN = var1;
         this.mVersionCode = var2;
         this.zzbgj = var3;
         this.zzbgk = var4;
      }

      public int describeContents() {
         zzd var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof PersonEntity.CoverInfoEntity)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            PersonEntity.CoverInfoEntity var2 = (PersonEntity.CoverInfoEntity)var1;
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
         return this.zzFs();
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
         zzd var10000 = CREATOR;
         zzd.zza(this, var1, var2);
      }

      public HashMap<String, FastJsonResponse.Field<?, ?>> zzFl() {
         return zzbeM;
      }

      public PersonEntity.CoverInfoEntity zzFs() {
         return this;
      }

      protected boolean zza(FastJsonResponse.Field var1) {
         return this.zzbeN.contains(Integer.valueOf(var1.zzrs()));
      }

      protected Object zzb(FastJsonResponse.Field var1) {
         switch(var1.zzrs()) {
         case 2:
            return Integer.valueOf(this.zzbgj);
         case 3:
            return Integer.valueOf(this.zzbgk);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.zzrs());
         }
      }

      // $FF: synthetic method
      public Map zzrl() {
         return this.zzFl();
      }
   }

   public static final class CoverPhotoEntity extends FastSafeParcelableJsonResponse implements Person.CoverPhoto {
      public static final zze CREATOR = new zze();
      private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap();
      final int mVersionCode;
      String zzF;
      final Set<Integer> zzbeN;
      int zzoG;
      int zzoH;

      static {
         zzbeM.put("height", FastJsonResponse.Field.zzi("height", 2));
         zzbeM.put("url", FastJsonResponse.Field.zzl("url", 3));
         zzbeM.put("width", FastJsonResponse.Field.zzi("width", 4));
      }

      public CoverPhotoEntity() {
         this.mVersionCode = 1;
         this.zzbeN = new HashSet();
      }

      CoverPhotoEntity(Set<Integer> var1, int var2, int var3, String var4, int var5) {
         this.zzbeN = var1;
         this.mVersionCode = var2;
         this.zzoH = var3;
         this.zzF = var4;
         this.zzoG = var5;
      }

      public int describeContents() {
         zze var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof PersonEntity.CoverPhotoEntity)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            PersonEntity.CoverPhotoEntity var2 = (PersonEntity.CoverPhotoEntity)var1;
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
         return this.zzFt();
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
         zze var10000 = CREATOR;
         zze.zza(this, var1, var2);
      }

      public HashMap<String, FastJsonResponse.Field<?, ?>> zzFl() {
         return zzbeM;
      }

      public PersonEntity.CoverPhotoEntity zzFt() {
         return this;
      }

      protected boolean zza(FastJsonResponse.Field var1) {
         return this.zzbeN.contains(Integer.valueOf(var1.zzrs()));
      }

      protected Object zzb(FastJsonResponse.Field var1) {
         switch(var1.zzrs()) {
         case 2:
            return Integer.valueOf(this.zzoH);
         case 3:
            return this.zzF;
         case 4:
            return Integer.valueOf(this.zzoG);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.zzrs());
         }
      }

      // $FF: synthetic method
      public Map zzrl() {
         return this.zzFl();
      }
   }

   public static final class ImageEntity extends FastSafeParcelableJsonResponse implements Person.Image {
      public static final zzf CREATOR = new zzf();
      private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap();
      final int mVersionCode;
      String zzF;
      final Set<Integer> zzbeN;

      static {
         zzbeM.put("url", FastJsonResponse.Field.zzl("url", 2));
      }

      public ImageEntity() {
         this.mVersionCode = 1;
         this.zzbeN = new HashSet();
      }

      ImageEntity(Set<Integer> var1, int var2, String var3) {
         this.zzbeN = var1;
         this.mVersionCode = var2;
         this.zzF = var3;
      }

      public int describeContents() {
         zzf var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof PersonEntity.ImageEntity)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            PersonEntity.ImageEntity var2 = (PersonEntity.ImageEntity)var1;
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
         return this.zzFu();
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
         zzf var10000 = CREATOR;
         zzf.zza(this, var1, var2);
      }

      public HashMap<String, FastJsonResponse.Field<?, ?>> zzFl() {
         return zzbeM;
      }

      public PersonEntity.ImageEntity zzFu() {
         return this;
      }

      protected boolean zza(FastJsonResponse.Field var1) {
         return this.zzbeN.contains(Integer.valueOf(var1.zzrs()));
      }

      protected Object zzb(FastJsonResponse.Field var1) {
         switch(var1.zzrs()) {
         case 2:
            return this.zzF;
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.zzrs());
         }
      }

      // $FF: synthetic method
      public Map zzrl() {
         return this.zzFl();
      }
   }

   public static final class NameEntity extends FastSafeParcelableJsonResponse implements Person.Name {
      public static final zzg CREATOR = new zzg();
      private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap();
      final int mVersionCode;
      final Set<Integer> zzbeN;
      String zzbfl;
      String zzbfo;
      String zzbgl;
      String zzbgm;
      String zzbgn;
      String zzbgo;

      static {
         zzbeM.put("familyName", FastJsonResponse.Field.zzl("familyName", 2));
         zzbeM.put("formatted", FastJsonResponse.Field.zzl("formatted", 3));
         zzbeM.put("givenName", FastJsonResponse.Field.zzl("givenName", 4));
         zzbeM.put("honorificPrefix", FastJsonResponse.Field.zzl("honorificPrefix", 5));
         zzbeM.put("honorificSuffix", FastJsonResponse.Field.zzl("honorificSuffix", 6));
         zzbeM.put("middleName", FastJsonResponse.Field.zzl("middleName", 7));
      }

      public NameEntity() {
         this.mVersionCode = 1;
         this.zzbeN = new HashSet();
      }

      NameEntity(Set<Integer> var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8) {
         this.zzbeN = var1;
         this.mVersionCode = var2;
         this.zzbfl = var3;
         this.zzbgl = var4;
         this.zzbfo = var5;
         this.zzbgm = var6;
         this.zzbgn = var7;
         this.zzbgo = var8;
      }

      public int describeContents() {
         zzg var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof PersonEntity.NameEntity)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            PersonEntity.NameEntity var2 = (PersonEntity.NameEntity)var1;
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
         return this.zzFv();
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
         zzg var10000 = CREATOR;
         zzg.zza(this, var1, var2);
      }

      public HashMap<String, FastJsonResponse.Field<?, ?>> zzFl() {
         return zzbeM;
      }

      public PersonEntity.NameEntity zzFv() {
         return this;
      }

      protected boolean zza(FastJsonResponse.Field var1) {
         return this.zzbeN.contains(Integer.valueOf(var1.zzrs()));
      }

      protected Object zzb(FastJsonResponse.Field var1) {
         switch(var1.zzrs()) {
         case 2:
            return this.zzbfl;
         case 3:
            return this.zzbgl;
         case 4:
            return this.zzbfo;
         case 5:
            return this.zzbgm;
         case 6:
            return this.zzbgn;
         case 7:
            return this.zzbgo;
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.zzrs());
         }
      }

      // $FF: synthetic method
      public Map zzrl() {
         return this.zzFl();
      }
   }

   public static final class OrganizationsEntity extends FastSafeParcelableJsonResponse implements Person.Organizations {
      public static final zzh CREATOR = new zzh();
      private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap();
      String mName;
      final int mVersionCode;
      int zzabB;
      String zzapg;
      String zzaxl;
      final Set<Integer> zzbeN;
      String zzbfA;
      String zzbfk;
      String zzbgp;
      String zzbgq;
      boolean zzbgr;

      static {
         zzbeM.put("department", FastJsonResponse.Field.zzl("department", 2));
         zzbeM.put("description", FastJsonResponse.Field.zzl("description", 3));
         zzbeM.put("endDate", FastJsonResponse.Field.zzl("endDate", 4));
         zzbeM.put("location", FastJsonResponse.Field.zzl("location", 5));
         zzbeM.put("name", FastJsonResponse.Field.zzl("name", 6));
         zzbeM.put("primary", FastJsonResponse.Field.zzk("primary", 7));
         zzbeM.put("startDate", FastJsonResponse.Field.zzl("startDate", 8));
         zzbeM.put("title", FastJsonResponse.Field.zzl("title", 9));
         zzbeM.put("type", FastJsonResponse.Field.zza("type", 10, (new StringToIntConverter()).zzh("work", 0).zzh("school", 1), false));
      }

      public OrganizationsEntity() {
         this.mVersionCode = 1;
         this.zzbeN = new HashSet();
      }

      OrganizationsEntity(Set<Integer> var1, int var2, String var3, String var4, String var5, String var6, String var7, boolean var8, String var9, String var10, int var11) {
         this.zzbeN = var1;
         this.mVersionCode = var2;
         this.zzbgp = var3;
         this.zzaxl = var4;
         this.zzbfk = var5;
         this.zzbgq = var6;
         this.mName = var7;
         this.zzbgr = var8;
         this.zzbfA = var9;
         this.zzapg = var10;
         this.zzabB = var11;
      }

      public int describeContents() {
         zzh var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof PersonEntity.OrganizationsEntity)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            PersonEntity.OrganizationsEntity var2 = (PersonEntity.OrganizationsEntity)var1;
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
         return this.zzFw();
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
         zzh var10000 = CREATOR;
         zzh.zza(this, var1, var2);
      }

      public HashMap<String, FastJsonResponse.Field<?, ?>> zzFl() {
         return zzbeM;
      }

      public PersonEntity.OrganizationsEntity zzFw() {
         return this;
      }

      protected boolean zza(FastJsonResponse.Field var1) {
         return this.zzbeN.contains(Integer.valueOf(var1.zzrs()));
      }

      protected Object zzb(FastJsonResponse.Field var1) {
         switch(var1.zzrs()) {
         case 2:
            return this.zzbgp;
         case 3:
            return this.zzaxl;
         case 4:
            return this.zzbfk;
         case 5:
            return this.zzbgq;
         case 6:
            return this.mName;
         case 7:
            return Boolean.valueOf(this.zzbgr);
         case 8:
            return this.zzbfA;
         case 9:
            return this.zzapg;
         case 10:
            return Integer.valueOf(this.zzabB);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.zzrs());
         }
      }

      // $FF: synthetic method
      public Map zzrl() {
         return this.zzFl();
      }
   }

   public static final class PlacesLivedEntity extends FastSafeParcelableJsonResponse implements Person.PlacesLived {
      public static final zzi CREATOR = new zzi();
      private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap();
      String mValue;
      final int mVersionCode;
      final Set<Integer> zzbeN;
      boolean zzbgr;

      static {
         zzbeM.put("primary", FastJsonResponse.Field.zzk("primary", 2));
         zzbeM.put("value", FastJsonResponse.Field.zzl("value", 3));
      }

      public PlacesLivedEntity() {
         this.mVersionCode = 1;
         this.zzbeN = new HashSet();
      }

      PlacesLivedEntity(Set<Integer> var1, int var2, boolean var3, String var4) {
         this.zzbeN = var1;
         this.mVersionCode = var2;
         this.zzbgr = var3;
         this.mValue = var4;
      }

      public int describeContents() {
         zzi var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof PersonEntity.PlacesLivedEntity)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            PersonEntity.PlacesLivedEntity var2 = (PersonEntity.PlacesLivedEntity)var1;
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
         return this.zzFx();
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
         zzi var10000 = CREATOR;
         zzi.zza(this, var1, var2);
      }

      public HashMap<String, FastJsonResponse.Field<?, ?>> zzFl() {
         return zzbeM;
      }

      public PersonEntity.PlacesLivedEntity zzFx() {
         return this;
      }

      protected boolean zza(FastJsonResponse.Field var1) {
         return this.zzbeN.contains(Integer.valueOf(var1.zzrs()));
      }

      protected Object zzb(FastJsonResponse.Field var1) {
         switch(var1.zzrs()) {
         case 2:
            return Boolean.valueOf(this.zzbgr);
         case 3:
            return this.mValue;
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.zzrs());
         }
      }

      // $FF: synthetic method
      public Map zzrl() {
         return this.zzFl();
      }
   }

   public static final class UrlsEntity extends FastSafeParcelableJsonResponse implements Person.Urls {
      public static final zzj CREATOR = new zzj();
      private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap();
      String mValue;
      final int mVersionCode;
      String zzaUO;
      int zzabB;
      final Set<Integer> zzbeN;
      private final int zzbgs = 4;

      static {
         zzbeM.put("label", FastJsonResponse.Field.zzl("label", 5));
         zzbeM.put("type", FastJsonResponse.Field.zza("type", 6, (new StringToIntConverter()).zzh("home", 0).zzh("work", 1).zzh("blog", 2).zzh("profile", 3).zzh("other", 4).zzh("otherProfile", 5).zzh("contributor", 6).zzh("website", 7), false));
         zzbeM.put("value", FastJsonResponse.Field.zzl("value", 4));
      }

      public UrlsEntity() {
         this.mVersionCode = 1;
         this.zzbeN = new HashSet();
      }

      UrlsEntity(Set<Integer> var1, int var2, String var3, int var4, String var5, int var6) {
         this.zzbeN = var1;
         this.mVersionCode = var2;
         this.zzaUO = var3;
         this.zzabB = var4;
         this.mValue = var5;
      }

      public int describeContents() {
         zzj var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof PersonEntity.UrlsEntity)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            PersonEntity.UrlsEntity var2 = (PersonEntity.UrlsEntity)var1;
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
         return this.zzFz();
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
         zzj var10000 = CREATOR;
         zzj.zza(this, var1, var2);
      }

      public HashMap<String, FastJsonResponse.Field<?, ?>> zzFl() {
         return zzbeM;
      }

      @Deprecated
      public int zzFy() {
         return 4;
      }

      public PersonEntity.UrlsEntity zzFz() {
         return this;
      }

      protected boolean zza(FastJsonResponse.Field var1) {
         return this.zzbeN.contains(Integer.valueOf(var1.zzrs()));
      }

      protected Object zzb(FastJsonResponse.Field var1) {
         switch(var1.zzrs()) {
         case 4:
            return this.mValue;
         case 5:
            return this.zzaUO;
         case 6:
            return Integer.valueOf(this.zzabB);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.zzrs());
         }
      }

      // $FF: synthetic method
      public Map zzrl() {
         return this.zzFl();
      }
   }
}
