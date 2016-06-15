package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.internal.class_726;
import com.google.android.gms.internal.class_727;
import com.google.android.gms.internal.class_738;
import com.google.android.gms.internal.class_791;
import com.google.android.gms.internal.class_792;
import com.google.android.gms.internal.class_793;
import com.google.android.gms.internal.class_794;
import com.google.android.gms.internal.class_795;
import com.google.android.gms.internal.class_796;
import com.google.android.gms.internal.class_798;
import com.google.android.gms.internal.class_799;
import com.google.android.gms.internal.class_800;
import com.google.android.gms.internal.class_801;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.pi
public final class class_730 extends class_727 implements Person {
   public static final class_796 CREATOR = new class_796();
   private static final HashMap<String, class_726.class_1680<?, ?>> aom = new HashMap();
   // $FF: renamed from: CE java.lang.String
   String field_3361;
   // $FF: renamed from: CK int
   final int field_3362;
   // $FF: renamed from: FR java.lang.String
   String field_3363;
   // $FF: renamed from: OS java.lang.String
   String field_3364;
   final Set<Integer> aon;
   int apA;
   String apB;
   List<class_730.class_1706> apC;
   boolean apD;
   String apl;
   class_730.class_1700 apm;
   String apn;
   String apo;
   int app;
   class_730.class_1663 apq;
   String apr;
   class_730.class_1703 aps;
   boolean apt;
   class_730.class_1704 apu;
   String apv;
   int apw;
   List<class_730.class_1702> apx;
   List<class_730.class_1705> apy;
   int apz;
   // $FF: renamed from: ow int
   int field_3365;
   // $FF: renamed from: vf java.lang.String
   String field_3366;

   static {
      aom.put("aboutMe", class_726.class_1680.method_5316("aboutMe", 2));
      aom.put("ageRange", class_726.class_1680.method_5310("ageRange", 3, class_730.class_1700.class));
      aom.put("birthday", class_726.class_1680.method_5316("birthday", 4));
      aom.put("braggingRights", class_726.class_1680.method_5316("braggingRights", 5));
      aom.put("circledByCount", class_726.class_1680.method_5313("circledByCount", 6));
      aom.put("cover", class_726.class_1680.method_5310("cover", 7, class_730.class_1663.class));
      aom.put("currentLocation", class_726.class_1680.method_5316("currentLocation", 8));
      aom.put("displayName", class_726.class_1680.method_5316("displayName", 9));
      aom.put("gender", class_726.class_1680.method_5309("gender", 12, (new class_738()).method_4286("male", 0).method_4286("female", 1).method_4286("other", 2), false));
      aom.put("id", class_726.class_1680.method_5316("id", 14));
      aom.put("image", class_726.class_1680.method_5310("image", 15, class_730.class_1703.class));
      aom.put("isPlusUser", class_726.class_1680.method_5315("isPlusUser", 16));
      aom.put("language", class_726.class_1680.method_5316("language", 18));
      aom.put("name", class_726.class_1680.method_5310("name", 19, class_730.class_1704.class));
      aom.put("nickname", class_726.class_1680.method_5316("nickname", 20));
      aom.put("objectType", class_726.class_1680.method_5309("objectType", 21, (new class_738()).method_4286("person", 0).method_4286("page", 1), false));
      aom.put("organizations", class_726.class_1680.method_5311("organizations", 22, class_730.class_1702.class));
      aom.put("placesLived", class_726.class_1680.method_5311("placesLived", 23, class_730.class_1705.class));
      aom.put("plusOneCount", class_726.class_1680.method_5313("plusOneCount", 24));
      aom.put("relationshipStatus", class_726.class_1680.method_5309("relationshipStatus", 25, (new class_738()).method_4286("single", 0).method_4286("in_a_relationship", 1).method_4286("engaged", 2).method_4286("married", 3).method_4286("its_complicated", 4).method_4286("open_relationship", 5).method_4286("widowed", 6).method_4286("in_domestic_partnership", 7).method_4286("in_civil_union", 8), false));
      aom.put("tagline", class_726.class_1680.method_5316("tagline", 26));
      aom.put("url", class_726.class_1680.method_5316("url", 27));
      aom.put("urls", class_726.class_1680.method_5311("urls", 28, class_730.class_1706.class));
      aom.put("verified", class_726.class_1680.method_5315("verified", 29));
   }

   public class_730() {
      this.field_3362 = 1;
      this.aon = new HashSet();
   }

   public class_730(String var1, String var2, class_730.class_1703 var3, int var4, String var5) {
      this.field_3362 = 1;
      this.aon = new HashSet();
      this.field_3364 = var1;
      this.aon.add(Integer.valueOf(9));
      this.field_3361 = var2;
      this.aon.add(Integer.valueOf(14));
      this.aps = var3;
      this.aon.add(Integer.valueOf(15));
      this.apw = var4;
      this.aon.add(Integer.valueOf(21));
      this.field_3366 = var5;
      this.aon.add(Integer.valueOf(27));
   }

   class_730(Set<Integer> var1, int var2, String var3, class_730.class_1700 var4, String var5, String var6, int var7, class_730.class_1663 var8, String var9, String var10, int var11, String var12, class_730.class_1703 var13, boolean var14, String var15, class_730.class_1704 var16, String var17, int var18, List<class_730.class_1702> var19, List<class_730.class_1705> var20, int var21, int var22, String var23, String var24, List<class_730.class_1706> var25, boolean var26) {
      this.aon = var1;
      this.field_3362 = var2;
      this.apl = var3;
      this.apm = var4;
      this.apn = var5;
      this.apo = var6;
      this.app = var7;
      this.apq = var8;
      this.apr = var9;
      this.field_3364 = var10;
      this.field_3365 = var11;
      this.field_3361 = var12;
      this.aps = var13;
      this.apt = var14;
      this.field_3363 = var15;
      this.apu = var16;
      this.apv = var17;
      this.apw = var18;
      this.apx = var19;
      this.apy = var20;
      this.apz = var21;
      this.apA = var22;
      this.apB = var23;
      this.field_3366 = var24;
      this.apC = var25;
      this.apD = var26;
   }

   // $FF: renamed from: i (byte[]) com.google.android.gms.internal.pi
   public static class_730 method_4245(byte[] var0) {
      Parcel var1 = Parcel.obtain();
      var1.unmarshall(var0, 0, var0.length);
      var1.setDataPosition(0);
      class_730 var2 = CREATOR.method_4431(var1);
      var1.recycle();
      return var2;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.kr$a) boolean
   protected boolean method_4224(class_726.class_1680 var1) {
      return this.aon.contains(Integer.valueOf(var1.method_5325()));
   }

   // $FF: renamed from: b (com.google.android.gms.internal.kr$a) java.lang.Object
   protected Object method_4225(class_726.class_1680 var1) {
      switch(var1.method_5325()) {
      case 2:
         return this.apl;
      case 3:
         return this.apm;
      case 4:
         return this.apn;
      case 5:
         return this.apo;
      case 6:
         return Integer.valueOf(this.app);
      case 7:
         return this.apq;
      case 8:
         return this.apr;
      case 9:
         return this.field_3364;
      case 10:
      case 11:
      case 13:
      case 17:
      default:
         throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_5325());
      case 12:
         return Integer.valueOf(this.field_3365);
      case 14:
         return this.field_3361;
      case 15:
         return this.aps;
      case 16:
         return Boolean.valueOf(this.apt);
      case 18:
         return this.field_3363;
      case 19:
         return this.apu;
      case 20:
         return this.apv;
      case 21:
         return Integer.valueOf(this.apw);
      case 22:
         return this.apx;
      case 23:
         return this.apy;
      case 24:
         return Integer.valueOf(this.apz);
      case 25:
         return Integer.valueOf(this.apA);
      case 26:
         return this.apB;
      case 27:
         return this.field_3366;
      case 28:
         return this.apC;
      case 29:
         return Boolean.valueOf(this.apD);
      }
   }

   public int describeContents() {
      class_796 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class_730)) {
         return false;
      } else if(this == var1) {
         return true;
      } else {
         class_730 var2 = (class_730)var1;
         Iterator var3 = aom.values().iterator();

         while(var3.hasNext()) {
            class_726.class_1680 var4 = (class_726.class_1680)var3.next();
            if(this.method_4224(var4)) {
               if(!var2.method_4224(var4)) {
                  return false;
               }

               if(!this.method_4225(var4).equals(var2.method_4225(var4))) {
                  return false;
               }
            } else if(var2.method_4224(var4)) {
               return false;
            }
         }

         return true;
      }
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_4246();
   }

   public String getAboutMe() {
      return this.apl;
   }

   public Person.AgeRange getAgeRange() {
      return this.apm;
   }

   public String getBirthday() {
      return this.apn;
   }

   public String getBraggingRights() {
      return this.apo;
   }

   public int getCircledByCount() {
      return this.app;
   }

   public Person.Cover getCover() {
      return this.apq;
   }

   public String getCurrentLocation() {
      return this.apr;
   }

   public String getDisplayName() {
      return this.field_3364;
   }

   public int getGender() {
      return this.field_3365;
   }

   public String getId() {
      return this.field_3361;
   }

   public Person.Image getImage() {
      return this.aps;
   }

   public String getLanguage() {
      return this.field_3363;
   }

   public Person.Name getName() {
      return this.apu;
   }

   public String getNickname() {
      return this.apv;
   }

   public int getObjectType() {
      return this.apw;
   }

   public List<Person.Organizations> getOrganizations() {
      return (ArrayList)this.apx;
   }

   public List<Person.PlacesLived> getPlacesLived() {
      return (ArrayList)this.apy;
   }

   public int getPlusOneCount() {
      return this.apz;
   }

   public int getRelationshipStatus() {
      return this.apA;
   }

   public String getTagline() {
      return this.apB;
   }

   public String getUrl() {
      return this.field_3366;
   }

   public List<Person.Urls> getUrls() {
      return (ArrayList)this.apC;
   }

   // $FF: renamed from: hK () java.util.HashMap
   public HashMap<String, class_726.class_1680<?, ?>> method_4230() {
      return aom;
   }

   public boolean hasAboutMe() {
      return this.aon.contains(Integer.valueOf(2));
   }

   public boolean hasAgeRange() {
      return this.aon.contains(Integer.valueOf(3));
   }

   public boolean hasBirthday() {
      return this.aon.contains(Integer.valueOf(4));
   }

   public boolean hasBraggingRights() {
      return this.aon.contains(Integer.valueOf(5));
   }

   public boolean hasCircledByCount() {
      return this.aon.contains(Integer.valueOf(6));
   }

   public boolean hasCover() {
      return this.aon.contains(Integer.valueOf(7));
   }

   public boolean hasCurrentLocation() {
      return this.aon.contains(Integer.valueOf(8));
   }

   public boolean hasDisplayName() {
      return this.aon.contains(Integer.valueOf(9));
   }

   public boolean hasGender() {
      return this.aon.contains(Integer.valueOf(12));
   }

   public boolean hasId() {
      return this.aon.contains(Integer.valueOf(14));
   }

   public boolean hasImage() {
      return this.aon.contains(Integer.valueOf(15));
   }

   public boolean hasIsPlusUser() {
      return this.aon.contains(Integer.valueOf(16));
   }

   public boolean hasLanguage() {
      return this.aon.contains(Integer.valueOf(18));
   }

   public boolean hasName() {
      return this.aon.contains(Integer.valueOf(19));
   }

   public boolean hasNickname() {
      return this.aon.contains(Integer.valueOf(20));
   }

   public boolean hasObjectType() {
      return this.aon.contains(Integer.valueOf(21));
   }

   public boolean hasOrganizations() {
      return this.aon.contains(Integer.valueOf(22));
   }

   public boolean hasPlacesLived() {
      return this.aon.contains(Integer.valueOf(23));
   }

   public boolean hasPlusOneCount() {
      return this.aon.contains(Integer.valueOf(24));
   }

   public boolean hasRelationshipStatus() {
      return this.aon.contains(Integer.valueOf(25));
   }

   public boolean hasTagline() {
      return this.aon.contains(Integer.valueOf(26));
   }

   public boolean hasUrl() {
      return this.aon.contains(Integer.valueOf(27));
   }

   public boolean hasUrls() {
      return this.aon.contains(Integer.valueOf(28));
   }

   public boolean hasVerified() {
      return this.aon.contains(Integer.valueOf(29));
   }

   public int hashCode() {
      Iterator var1 = aom.values().iterator();

      int var2;
      int var4;
      for(var2 = 0; var1.hasNext(); var2 = var4) {
         class_726.class_1680 var3 = (class_726.class_1680)var1.next();
         if(this.method_4224(var3)) {
            var4 = var2 + var3.method_5325() + this.method_4225(var3).hashCode();
         } else {
            var4 = var2;
         }
      }

      return var2;
   }

   public boolean isDataValid() {
      return true;
   }

   public boolean isPlusUser() {
      return this.apt;
   }

   public boolean isVerified() {
      return this.apD;
   }

   // $FF: renamed from: oL () com.google.android.gms.internal.pi
   public class_730 method_4246() {
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_796 var10000 = CREATOR;
      class_796.method_4430(this, var1, var2);
   }

   public static final class class_1700 extends class_727 implements Person.AgeRange {
      public static final class_795 CREATOR = new class_795();
      private static final HashMap<String, class_726.class_1680<?, ?>> aom = new HashMap();
      // $FF: renamed from: CK int
      final int field_3345;
      final Set<Integer> aon;
      int apE;
      int apF;

      static {
         aom.put("max", class_726.class_1680.method_5313("max", 2));
         aom.put("min", class_726.class_1680.method_5313("min", 3));
      }

      public class_1700() {
         this.field_3345 = 1;
         this.aon = new HashSet();
      }

      class_1700(Set<Integer> var1, int var2, int var3, int var4) {
         this.aon = var1;
         this.field_3345 = var2;
         this.apE = var3;
         this.apF = var4;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.kr$a) boolean
      protected boolean method_4224(class_726.class_1680 var1) {
         return this.aon.contains(Integer.valueOf(var1.method_5325()));
      }

      // $FF: renamed from: b (com.google.android.gms.internal.kr$a) java.lang.Object
      protected Object method_4225(class_726.class_1680 var1) {
         switch(var1.method_5325()) {
         case 2:
            return Integer.valueOf(this.apE);
         case 3:
            return Integer.valueOf(this.apF);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_5325());
         }
      }

      public int describeContents() {
         class_795 var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_730.class_1700)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_730.class_1700 var2 = (class_730.class_1700)var1;
            Iterator var3 = aom.values().iterator();

            while(var3.hasNext()) {
               class_726.class_1680 var4 = (class_726.class_1680)var3.next();
               if(this.method_4224(var4)) {
                  if(!var2.method_4224(var4)) {
                     return false;
                  }

                  if(!this.method_4225(var4).equals(var2.method_4225(var4))) {
                     return false;
                  }
               } else if(var2.method_4224(var4)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.method_4239();
      }

      public int getMax() {
         return this.apE;
      }

      public int getMin() {
         return this.apF;
      }

      // $FF: renamed from: hK () java.util.HashMap
      public HashMap<String, class_726.class_1680<?, ?>> method_4230() {
         return aom;
      }

      public boolean hasMax() {
         return this.aon.contains(Integer.valueOf(2));
      }

      public boolean hasMin() {
         return this.aon.contains(Integer.valueOf(3));
      }

      public int hashCode() {
         Iterator var1 = aom.values().iterator();

         int var2;
         int var4;
         for(var2 = 0; var1.hasNext(); var2 = var4) {
            class_726.class_1680 var3 = (class_726.class_1680)var1.next();
            if(this.method_4224(var3)) {
               var4 = var2 + var3.method_5325() + this.method_4225(var3).hashCode();
            } else {
               var4 = var2;
            }
         }

         return var2;
      }

      public boolean isDataValid() {
         return true;
      }

      // $FF: renamed from: oM () com.google.android.gms.internal.pi$a
      public class_730.class_1700 method_4239() {
         return this;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_795 var10000 = CREATOR;
         class_795.method_4427(this, var1, var2);
      }
   }

   public static final class class_1663 extends class_727 implements Person.Cover {
      public static final class_792 CREATOR = new class_792();
      private static final HashMap<String, class_726.class_1680<?, ?>> aom = new HashMap();
      // $FF: renamed from: CK int
      final int field_3346;
      final Set<Integer> aon;
      class_730.class_1664 apG;
      class_730.class_1665 apH;
      int apI;

      static {
         aom.put("coverInfo", class_726.class_1680.method_5310("coverInfo", 2, class_730.class_1664.class));
         aom.put("coverPhoto", class_726.class_1680.method_5310("coverPhoto", 3, class_730.class_1665.class));
         aom.put("layout", class_726.class_1680.method_5309("layout", 4, (new class_738()).method_4286("banner", 0), false));
      }

      public class_1663() {
         this.field_3346 = 1;
         this.aon = new HashSet();
      }

      class_1663(Set<Integer> var1, int var2, class_730.class_1664 var3, class_730.class_1665 var4, int var5) {
         this.aon = var1;
         this.field_3346 = var2;
         this.apG = var3;
         this.apH = var4;
         this.apI = var5;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.kr$a) boolean
      protected boolean method_4224(class_726.class_1680 var1) {
         return this.aon.contains(Integer.valueOf(var1.method_5325()));
      }

      // $FF: renamed from: b (com.google.android.gms.internal.kr$a) java.lang.Object
      protected Object method_4225(class_726.class_1680 var1) {
         switch(var1.method_5325()) {
         case 2:
            return this.apG;
         case 3:
            return this.apH;
         case 4:
            return Integer.valueOf(this.apI);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_5325());
         }
      }

      public int describeContents() {
         class_792 var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_730.class_1663)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_730.class_1663 var2 = (class_730.class_1663)var1;
            Iterator var3 = aom.values().iterator();

            while(var3.hasNext()) {
               class_726.class_1680 var4 = (class_726.class_1680)var3.next();
               if(this.method_4224(var4)) {
                  if(!var2.method_4224(var4)) {
                     return false;
                  }

                  if(!this.method_4225(var4).equals(var2.method_4225(var4))) {
                     return false;
                  }
               } else if(var2.method_4224(var4)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.method_4240();
      }

      public Person.CoverInfo getCoverInfo() {
         return this.apG;
      }

      public Person.CoverPhoto getCoverPhoto() {
         return this.apH;
      }

      public int getLayout() {
         return this.apI;
      }

      // $FF: renamed from: hK () java.util.HashMap
      public HashMap<String, class_726.class_1680<?, ?>> method_4230() {
         return aom;
      }

      public boolean hasCoverInfo() {
         return this.aon.contains(Integer.valueOf(2));
      }

      public boolean hasCoverPhoto() {
         return this.aon.contains(Integer.valueOf(3));
      }

      public boolean hasLayout() {
         return this.aon.contains(Integer.valueOf(4));
      }

      public int hashCode() {
         Iterator var1 = aom.values().iterator();

         int var2;
         int var4;
         for(var2 = 0; var1.hasNext(); var2 = var4) {
            class_726.class_1680 var3 = (class_726.class_1680)var1.next();
            if(this.method_4224(var3)) {
               var4 = var2 + var3.method_5325() + this.method_4225(var3).hashCode();
            } else {
               var4 = var2;
            }
         }

         return var2;
      }

      public boolean isDataValid() {
         return true;
      }

      // $FF: renamed from: oN () com.google.android.gms.internal.pi$b
      public class_730.class_1663 method_4240() {
         return this;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_792 var10000 = CREATOR;
         class_792.method_4418(this, var1, var2);
      }
   }

   public static final class class_1664 extends class_727 implements Person.CoverInfo {
      public static final class_791 CREATOR = new class_791();
      private static final HashMap<String, class_726.class_1680<?, ?>> aom = new HashMap();
      // $FF: renamed from: CK int
      final int field_3351;
      final Set<Integer> aon;
      int apJ;
      int apK;

      static {
         aom.put("leftImageOffset", class_726.class_1680.method_5313("leftImageOffset", 2));
         aom.put("topImageOffset", class_726.class_1680.method_5313("topImageOffset", 3));
      }

      public class_1664() {
         this.field_3351 = 1;
         this.aon = new HashSet();
      }

      class_1664(Set<Integer> var1, int var2, int var3, int var4) {
         this.aon = var1;
         this.field_3351 = var2;
         this.apJ = var3;
         this.apK = var4;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.kr$a) boolean
      protected boolean method_4224(class_726.class_1680 var1) {
         return this.aon.contains(Integer.valueOf(var1.method_5325()));
      }

      // $FF: renamed from: b (com.google.android.gms.internal.kr$a) java.lang.Object
      protected Object method_4225(class_726.class_1680 var1) {
         switch(var1.method_5325()) {
         case 2:
            return Integer.valueOf(this.apJ);
         case 3:
            return Integer.valueOf(this.apK);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_5325());
         }
      }

      public int describeContents() {
         class_791 var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_730.class_1664)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_730.class_1664 var2 = (class_730.class_1664)var1;
            Iterator var3 = aom.values().iterator();

            while(var3.hasNext()) {
               class_726.class_1680 var4 = (class_726.class_1680)var3.next();
               if(this.method_4224(var4)) {
                  if(!var2.method_4224(var4)) {
                     return false;
                  }

                  if(!this.method_4225(var4).equals(var2.method_4225(var4))) {
                     return false;
                  }
               } else if(var2.method_4224(var4)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.method_4242();
      }

      public int getLeftImageOffset() {
         return this.apJ;
      }

      public int getTopImageOffset() {
         return this.apK;
      }

      // $FF: renamed from: hK () java.util.HashMap
      public HashMap<String, class_726.class_1680<?, ?>> method_4230() {
         return aom;
      }

      public boolean hasLeftImageOffset() {
         return this.aon.contains(Integer.valueOf(2));
      }

      public boolean hasTopImageOffset() {
         return this.aon.contains(Integer.valueOf(3));
      }

      public int hashCode() {
         Iterator var1 = aom.values().iterator();

         int var2;
         int var4;
         for(var2 = 0; var1.hasNext(); var2 = var4) {
            class_726.class_1680 var3 = (class_726.class_1680)var1.next();
            if(this.method_4224(var3)) {
               var4 = var2 + var3.method_5325() + this.method_4225(var3).hashCode();
            } else {
               var4 = var2;
            }
         }

         return var2;
      }

      public boolean isDataValid() {
         return true;
      }

      // $FF: renamed from: oO () com.google.android.gms.internal.pi$b$a
      public class_730.class_1664 method_4242() {
         return this;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_791 var10000 = CREATOR;
         class_791.method_4415(this, var1, var2);
      }
   }

   public static final class class_1665 extends class_727 implements Person.CoverPhoto {
      public static final class_794 CREATOR = new class_794();
      private static final HashMap<String, class_726.class_1680<?, ?>> aom = new HashMap();
      // $FF: renamed from: CK int
      final int field_3347;
      final Set<Integer> aon;
      // $FF: renamed from: li int
      int field_3348;
      // $FF: renamed from: lj int
      int field_3349;
      // $FF: renamed from: vf java.lang.String
      String field_3350;

      static {
         aom.put("height", class_726.class_1680.method_5313("height", 2));
         aom.put("url", class_726.class_1680.method_5316("url", 3));
         aom.put("width", class_726.class_1680.method_5313("width", 4));
      }

      public class_1665() {
         this.field_3347 = 1;
         this.aon = new HashSet();
      }

      class_1665(Set<Integer> var1, int var2, int var3, String var4, int var5) {
         this.aon = var1;
         this.field_3347 = var2;
         this.field_3349 = var3;
         this.field_3350 = var4;
         this.field_3348 = var5;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.kr$a) boolean
      protected boolean method_4224(class_726.class_1680 var1) {
         return this.aon.contains(Integer.valueOf(var1.method_5325()));
      }

      // $FF: renamed from: b (com.google.android.gms.internal.kr$a) java.lang.Object
      protected Object method_4225(class_726.class_1680 var1) {
         switch(var1.method_5325()) {
         case 2:
            return Integer.valueOf(this.field_3349);
         case 3:
            return this.field_3350;
         case 4:
            return Integer.valueOf(this.field_3348);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_5325());
         }
      }

      public int describeContents() {
         class_794 var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_730.class_1665)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_730.class_1665 var2 = (class_730.class_1665)var1;
            Iterator var3 = aom.values().iterator();

            while(var3.hasNext()) {
               class_726.class_1680 var4 = (class_726.class_1680)var3.next();
               if(this.method_4224(var4)) {
                  if(!var2.method_4224(var4)) {
                     return false;
                  }

                  if(!this.method_4225(var4).equals(var2.method_4225(var4))) {
                     return false;
                  }
               } else if(var2.method_4224(var4)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.method_4241();
      }

      public int getHeight() {
         return this.field_3349;
      }

      public String getUrl() {
         return this.field_3350;
      }

      public int getWidth() {
         return this.field_3348;
      }

      // $FF: renamed from: hK () java.util.HashMap
      public HashMap<String, class_726.class_1680<?, ?>> method_4230() {
         return aom;
      }

      public boolean hasHeight() {
         return this.aon.contains(Integer.valueOf(2));
      }

      public boolean hasUrl() {
         return this.aon.contains(Integer.valueOf(3));
      }

      public boolean hasWidth() {
         return this.aon.contains(Integer.valueOf(4));
      }

      public int hashCode() {
         Iterator var1 = aom.values().iterator();

         int var2;
         int var4;
         for(var2 = 0; var1.hasNext(); var2 = var4) {
            class_726.class_1680 var3 = (class_726.class_1680)var1.next();
            if(this.method_4224(var3)) {
               var4 = var2 + var3.method_5325() + this.method_4225(var3).hashCode();
            } else {
               var4 = var2;
            }
         }

         return var2;
      }

      public boolean isDataValid() {
         return true;
      }

      // $FF: renamed from: oP () com.google.android.gms.internal.pi$b$b
      public class_730.class_1665 method_4241() {
         return this;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_794 var10000 = CREATOR;
         class_794.method_4424(this, var1, var2);
      }
   }

   public static final class class_1703 extends class_727 implements Person.Image {
      public static final class_793 CREATOR = new class_793();
      private static final HashMap<String, class_726.class_1680<?, ?>> aom = new HashMap();
      // $FF: renamed from: CK int
      final int field_3339;
      final Set<Integer> aon;
      // $FF: renamed from: vf java.lang.String
      String field_3340;

      static {
         aom.put("url", class_726.class_1680.method_5316("url", 2));
      }

      public class_1703() {
         this.field_3339 = 1;
         this.aon = new HashSet();
      }

      public class_1703(String var1) {
         this.aon = new HashSet();
         this.field_3339 = 1;
         this.field_3340 = var1;
         this.aon.add(Integer.valueOf(2));
      }

      class_1703(Set<Integer> var1, int var2, String var3) {
         this.aon = var1;
         this.field_3339 = var2;
         this.field_3340 = var3;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.kr$a) boolean
      protected boolean method_4224(class_726.class_1680 var1) {
         return this.aon.contains(Integer.valueOf(var1.method_5325()));
      }

      // $FF: renamed from: b (com.google.android.gms.internal.kr$a) java.lang.Object
      protected Object method_4225(class_726.class_1680 var1) {
         switch(var1.method_5325()) {
         case 2:
            return this.field_3340;
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_5325());
         }
      }

      public int describeContents() {
         class_793 var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_730.class_1703)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_730.class_1703 var2 = (class_730.class_1703)var1;
            Iterator var3 = aom.values().iterator();

            while(var3.hasNext()) {
               class_726.class_1680 var4 = (class_726.class_1680)var3.next();
               if(this.method_4224(var4)) {
                  if(!var2.method_4224(var4)) {
                     return false;
                  }

                  if(!this.method_4225(var4).equals(var2.method_4225(var4))) {
                     return false;
                  }
               } else if(var2.method_4224(var4)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.method_4237();
      }

      public String getUrl() {
         return this.field_3340;
      }

      // $FF: renamed from: hK () java.util.HashMap
      public HashMap<String, class_726.class_1680<?, ?>> method_4230() {
         return aom;
      }

      public boolean hasUrl() {
         return this.aon.contains(Integer.valueOf(2));
      }

      public int hashCode() {
         Iterator var1 = aom.values().iterator();

         int var2;
         int var4;
         for(var2 = 0; var1.hasNext(); var2 = var4) {
            class_726.class_1680 var3 = (class_726.class_1680)var1.next();
            if(this.method_4224(var3)) {
               var4 = var2 + var3.method_5325() + this.method_4225(var3).hashCode();
            } else {
               var4 = var2;
            }
         }

         return var2;
      }

      public boolean isDataValid() {
         return true;
      }

      // $FF: renamed from: oQ () com.google.android.gms.internal.pi$c
      public class_730.class_1703 method_4237() {
         return this;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_793 var10000 = CREATOR;
         class_793.method_4421(this, var1, var2);
      }
   }

   public static final class class_1704 extends class_727 implements Person.Name {
      public static final class_799 CREATOR = new class_799();
      private static final HashMap<String, class_726.class_1680<?, ?>> aom = new HashMap();
      // $FF: renamed from: CK int
      final int field_3338;
      String aoL;
      String aoO;
      final Set<Integer> aon;
      String apL;
      String apM;
      String apN;
      String apO;

      static {
         aom.put("familyName", class_726.class_1680.method_5316("familyName", 2));
         aom.put("formatted", class_726.class_1680.method_5316("formatted", 3));
         aom.put("givenName", class_726.class_1680.method_5316("givenName", 4));
         aom.put("honorificPrefix", class_726.class_1680.method_5316("honorificPrefix", 5));
         aom.put("honorificSuffix", class_726.class_1680.method_5316("honorificSuffix", 6));
         aom.put("middleName", class_726.class_1680.method_5316("middleName", 7));
      }

      public class_1704() {
         this.field_3338 = 1;
         this.aon = new HashSet();
      }

      class_1704(Set<Integer> var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8) {
         this.aon = var1;
         this.field_3338 = var2;
         this.aoL = var3;
         this.apL = var4;
         this.aoO = var5;
         this.apM = var6;
         this.apN = var7;
         this.apO = var8;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.kr$a) boolean
      protected boolean method_4224(class_726.class_1680 var1) {
         return this.aon.contains(Integer.valueOf(var1.method_5325()));
      }

      // $FF: renamed from: b (com.google.android.gms.internal.kr$a) java.lang.Object
      protected Object method_4225(class_726.class_1680 var1) {
         switch(var1.method_5325()) {
         case 2:
            return this.aoL;
         case 3:
            return this.apL;
         case 4:
            return this.aoO;
         case 5:
            return this.apM;
         case 6:
            return this.apN;
         case 7:
            return this.apO;
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_5325());
         }
      }

      public int describeContents() {
         class_799 var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_730.class_1704)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_730.class_1704 var2 = (class_730.class_1704)var1;
            Iterator var3 = aom.values().iterator();

            while(var3.hasNext()) {
               class_726.class_1680 var4 = (class_726.class_1680)var3.next();
               if(this.method_4224(var4)) {
                  if(!var2.method_4224(var4)) {
                     return false;
                  }

                  if(!this.method_4225(var4).equals(var2.method_4225(var4))) {
                     return false;
                  }
               } else if(var2.method_4224(var4)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.method_4236();
      }

      public String getFamilyName() {
         return this.aoL;
      }

      public String getFormatted() {
         return this.apL;
      }

      public String getGivenName() {
         return this.aoO;
      }

      public String getHonorificPrefix() {
         return this.apM;
      }

      public String getHonorificSuffix() {
         return this.apN;
      }

      public String getMiddleName() {
         return this.apO;
      }

      // $FF: renamed from: hK () java.util.HashMap
      public HashMap<String, class_726.class_1680<?, ?>> method_4230() {
         return aom;
      }

      public boolean hasFamilyName() {
         return this.aon.contains(Integer.valueOf(2));
      }

      public boolean hasFormatted() {
         return this.aon.contains(Integer.valueOf(3));
      }

      public boolean hasGivenName() {
         return this.aon.contains(Integer.valueOf(4));
      }

      public boolean hasHonorificPrefix() {
         return this.aon.contains(Integer.valueOf(5));
      }

      public boolean hasHonorificSuffix() {
         return this.aon.contains(Integer.valueOf(6));
      }

      public boolean hasMiddleName() {
         return this.aon.contains(Integer.valueOf(7));
      }

      public int hashCode() {
         Iterator var1 = aom.values().iterator();

         int var2;
         int var4;
         for(var2 = 0; var1.hasNext(); var2 = var4) {
            class_726.class_1680 var3 = (class_726.class_1680)var1.next();
            if(this.method_4224(var3)) {
               var4 = var2 + var3.method_5325() + this.method_4225(var3).hashCode();
            } else {
               var4 = var2;
            }
         }

         return var2;
      }

      public boolean isDataValid() {
         return true;
      }

      // $FF: renamed from: oR () com.google.android.gms.internal.pi$d
      public class_730.class_1704 method_4236() {
         return this;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_799 var10000 = CREATOR;
         class_799.method_4436(this, var1, var2);
      }
   }

   public static class class_1701 {
      // $FF: renamed from: ck (java.lang.String) int
      public static int method_5764(String var0) {
         if(var0.equals("person")) {
            return 0;
         } else if(var0.equals("page")) {
            return 1;
         } else {
            throw new IllegalArgumentException("Unknown objectType string: " + var0);
         }
      }
   }

   public static final class class_1702 extends class_727 implements Person.Organizations {
      public static final class_798 CREATOR = new class_798();
      private static final HashMap<String, class_726.class_1680<?, ?>> aom = new HashMap();
      // $FF: renamed from: CK int
      final int field_3341;
      // $FF: renamed from: Gt int
      int field_3342;
      // $FF: renamed from: OH java.lang.String
      String field_3343;
      // $FF: renamed from: UO java.lang.String
      String field_3344;
      String aoK;
      final Set<Integer> aon;
      String apP;
      String apQ;
      boolean apR;
      String apa;
      String mName;

      static {
         aom.put("department", class_726.class_1680.method_5316("department", 2));
         aom.put("description", class_726.class_1680.method_5316("description", 3));
         aom.put("endDate", class_726.class_1680.method_5316("endDate", 4));
         aom.put("location", class_726.class_1680.method_5316("location", 5));
         aom.put("name", class_726.class_1680.method_5316("name", 6));
         aom.put("primary", class_726.class_1680.method_5315("primary", 7));
         aom.put("startDate", class_726.class_1680.method_5316("startDate", 8));
         aom.put("title", class_726.class_1680.method_5316("title", 9));
         aom.put("type", class_726.class_1680.method_5309("type", 10, (new class_738()).method_4286("work", 0).method_4286("school", 1), false));
      }

      public class_1702() {
         this.field_3341 = 1;
         this.aon = new HashSet();
      }

      class_1702(Set<Integer> var1, int var2, String var3, String var4, String var5, String var6, String var7, boolean var8, String var9, String var10, int var11) {
         this.aon = var1;
         this.field_3341 = var2;
         this.apP = var3;
         this.field_3344 = var4;
         this.aoK = var5;
         this.apQ = var6;
         this.mName = var7;
         this.apR = var8;
         this.apa = var9;
         this.field_3343 = var10;
         this.field_3342 = var11;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.kr$a) boolean
      protected boolean method_4224(class_726.class_1680 var1) {
         return this.aon.contains(Integer.valueOf(var1.method_5325()));
      }

      // $FF: renamed from: b (com.google.android.gms.internal.kr$a) java.lang.Object
      protected Object method_4225(class_726.class_1680 var1) {
         switch(var1.method_5325()) {
         case 2:
            return this.apP;
         case 3:
            return this.field_3344;
         case 4:
            return this.aoK;
         case 5:
            return this.apQ;
         case 6:
            return this.mName;
         case 7:
            return Boolean.valueOf(this.apR);
         case 8:
            return this.apa;
         case 9:
            return this.field_3343;
         case 10:
            return Integer.valueOf(this.field_3342);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_5325());
         }
      }

      public int describeContents() {
         class_798 var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_730.class_1702)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_730.class_1702 var2 = (class_730.class_1702)var1;
            Iterator var3 = aom.values().iterator();

            while(var3.hasNext()) {
               class_726.class_1680 var4 = (class_726.class_1680)var3.next();
               if(this.method_4224(var4)) {
                  if(!var2.method_4224(var4)) {
                     return false;
                  }

                  if(!this.method_4225(var4).equals(var2.method_4225(var4))) {
                     return false;
                  }
               } else if(var2.method_4224(var4)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.method_4238();
      }

      public String getDepartment() {
         return this.apP;
      }

      public String getDescription() {
         return this.field_3344;
      }

      public String getEndDate() {
         return this.aoK;
      }

      public String getLocation() {
         return this.apQ;
      }

      public String getName() {
         return this.mName;
      }

      public String getStartDate() {
         return this.apa;
      }

      public String getTitle() {
         return this.field_3343;
      }

      public int getType() {
         return this.field_3342;
      }

      // $FF: renamed from: hK () java.util.HashMap
      public HashMap<String, class_726.class_1680<?, ?>> method_4230() {
         return aom;
      }

      public boolean hasDepartment() {
         return this.aon.contains(Integer.valueOf(2));
      }

      public boolean hasDescription() {
         return this.aon.contains(Integer.valueOf(3));
      }

      public boolean hasEndDate() {
         return this.aon.contains(Integer.valueOf(4));
      }

      public boolean hasLocation() {
         return this.aon.contains(Integer.valueOf(5));
      }

      public boolean hasName() {
         return this.aon.contains(Integer.valueOf(6));
      }

      public boolean hasPrimary() {
         return this.aon.contains(Integer.valueOf(7));
      }

      public boolean hasStartDate() {
         return this.aon.contains(Integer.valueOf(8));
      }

      public boolean hasTitle() {
         return this.aon.contains(Integer.valueOf(9));
      }

      public boolean hasType() {
         return this.aon.contains(Integer.valueOf(10));
      }

      public int hashCode() {
         Iterator var1 = aom.values().iterator();

         int var2;
         int var4;
         for(var2 = 0; var1.hasNext(); var2 = var4) {
            class_726.class_1680 var3 = (class_726.class_1680)var1.next();
            if(this.method_4224(var3)) {
               var4 = var2 + var3.method_5325() + this.method_4225(var3).hashCode();
            } else {
               var4 = var2;
            }
         }

         return var2;
      }

      public boolean isDataValid() {
         return true;
      }

      public boolean isPrimary() {
         return this.apR;
      }

      // $FF: renamed from: oS () com.google.android.gms.internal.pi$f
      public class_730.class_1702 method_4238() {
         return this;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_798 var10000 = CREATOR;
         class_798.method_4433(this, var1, var2);
      }
   }

   public static final class class_1705 extends class_727 implements Person.PlacesLived {
      public static final class_801 CREATOR = new class_801();
      private static final HashMap<String, class_726.class_1680<?, ?>> aom = new HashMap();
      // $FF: renamed from: CK int
      final int field_3337;
      final Set<Integer> aon;
      boolean apR;
      String mValue;

      static {
         aom.put("primary", class_726.class_1680.method_5315("primary", 2));
         aom.put("value", class_726.class_1680.method_5316("value", 3));
      }

      public class_1705() {
         this.field_3337 = 1;
         this.aon = new HashSet();
      }

      class_1705(Set<Integer> var1, int var2, boolean var3, String var4) {
         this.aon = var1;
         this.field_3337 = var2;
         this.apR = var3;
         this.mValue = var4;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.kr$a) boolean
      protected boolean method_4224(class_726.class_1680 var1) {
         return this.aon.contains(Integer.valueOf(var1.method_5325()));
      }

      // $FF: renamed from: b (com.google.android.gms.internal.kr$a) java.lang.Object
      protected Object method_4225(class_726.class_1680 var1) {
         switch(var1.method_5325()) {
         case 2:
            return Boolean.valueOf(this.apR);
         case 3:
            return this.mValue;
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_5325());
         }
      }

      public int describeContents() {
         class_801 var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_730.class_1705)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_730.class_1705 var2 = (class_730.class_1705)var1;
            Iterator var3 = aom.values().iterator();

            while(var3.hasNext()) {
               class_726.class_1680 var4 = (class_726.class_1680)var3.next();
               if(this.method_4224(var4)) {
                  if(!var2.method_4224(var4)) {
                     return false;
                  }

                  if(!this.method_4225(var4).equals(var2.method_4225(var4))) {
                     return false;
                  }
               } else if(var2.method_4224(var4)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.method_4235();
      }

      public String getValue() {
         return this.mValue;
      }

      // $FF: renamed from: hK () java.util.HashMap
      public HashMap<String, class_726.class_1680<?, ?>> method_4230() {
         return aom;
      }

      public boolean hasPrimary() {
         return this.aon.contains(Integer.valueOf(2));
      }

      public boolean hasValue() {
         return this.aon.contains(Integer.valueOf(3));
      }

      public int hashCode() {
         Iterator var1 = aom.values().iterator();

         int var2;
         int var4;
         for(var2 = 0; var1.hasNext(); var2 = var4) {
            class_726.class_1680 var3 = (class_726.class_1680)var1.next();
            if(this.method_4224(var3)) {
               var4 = var2 + var3.method_5325() + this.method_4225(var3).hashCode();
            } else {
               var4 = var2;
            }
         }

         return var2;
      }

      public boolean isDataValid() {
         return true;
      }

      public boolean isPrimary() {
         return this.apR;
      }

      // $FF: renamed from: oT () com.google.android.gms.internal.pi$g
      public class_730.class_1705 method_4235() {
         return this;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_801 var10000 = CREATOR;
         class_801.method_4442(this, var1, var2);
      }
   }

   public static final class class_1706 extends class_727 implements Person.Urls {
      public static final class_800 CREATOR = new class_800();
      private static final HashMap<String, class_726.class_1680<?, ?>> aom = new HashMap();
      // $FF: renamed from: CK int
      final int field_3334;
      // $FF: renamed from: Gt int
      int field_3335;
      // $FF: renamed from: XL java.lang.String
      String field_3336;
      final Set<Integer> aon;
      private final int apS = 4;
      String mValue;

      static {
         aom.put("label", class_726.class_1680.method_5316("label", 5));
         aom.put("type", class_726.class_1680.method_5309("type", 6, (new class_738()).method_4286("home", 0).method_4286("work", 1).method_4286("blog", 2).method_4286("profile", 3).method_4286("other", 4).method_4286("otherProfile", 5).method_4286("contributor", 6).method_4286("website", 7), false));
         aom.put("value", class_726.class_1680.method_5316("value", 4));
      }

      public class_1706() {
         this.field_3334 = 1;
         this.aon = new HashSet();
      }

      class_1706(Set<Integer> var1, int var2, String var3, int var4, String var5, int var6) {
         this.aon = var1;
         this.field_3334 = var2;
         this.field_3336 = var3;
         this.field_3335 = var4;
         this.mValue = var5;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.kr$a) boolean
      protected boolean method_4224(class_726.class_1680 var1) {
         return this.aon.contains(Integer.valueOf(var1.method_5325()));
      }

      // $FF: renamed from: b (com.google.android.gms.internal.kr$a) java.lang.Object
      protected Object method_4225(class_726.class_1680 var1) {
         switch(var1.method_5325()) {
         case 4:
            return this.mValue;
         case 5:
            return this.field_3336;
         case 6:
            return Integer.valueOf(this.field_3335);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_5325());
         }
      }

      public int describeContents() {
         class_800 var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_730.class_1706)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_730.class_1706 var2 = (class_730.class_1706)var1;
            Iterator var3 = aom.values().iterator();

            while(var3.hasNext()) {
               class_726.class_1680 var4 = (class_726.class_1680)var3.next();
               if(this.method_4224(var4)) {
                  if(!var2.method_4224(var4)) {
                     return false;
                  }

                  if(!this.method_4225(var4).equals(var2.method_4225(var4))) {
                     return false;
                  }
               } else if(var2.method_4224(var4)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.method_4234();
      }

      public String getLabel() {
         return this.field_3336;
      }

      public int getType() {
         return this.field_3335;
      }

      public String getValue() {
         return this.mValue;
      }

      // $FF: renamed from: hK () java.util.HashMap
      public HashMap<String, class_726.class_1680<?, ?>> method_4230() {
         return aom;
      }

      public boolean hasLabel() {
         return this.aon.contains(Integer.valueOf(5));
      }

      public boolean hasType() {
         return this.aon.contains(Integer.valueOf(6));
      }

      public boolean hasValue() {
         return this.aon.contains(Integer.valueOf(4));
      }

      public int hashCode() {
         Iterator var1 = aom.values().iterator();

         int var2;
         int var4;
         for(var2 = 0; var1.hasNext(); var2 = var4) {
            class_726.class_1680 var3 = (class_726.class_1680)var1.next();
            if(this.method_4224(var3)) {
               var4 = var2 + var3.method_5325() + this.method_4225(var3).hashCode();
            } else {
               var4 = var2;
            }
         }

         return var2;
      }

      public boolean isDataValid() {
         return true;
      }

      // $FF: renamed from: oU () int
      @Deprecated
      public int method_4233() {
         return 4;
      }

      // $FF: renamed from: oV () com.google.android.gms.internal.pi$h
      public class_730.class_1706 method_4234() {
         return this;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_800 var10000 = CREATOR;
         class_800.method_4439(this, var1, var2);
      }
   }
}
