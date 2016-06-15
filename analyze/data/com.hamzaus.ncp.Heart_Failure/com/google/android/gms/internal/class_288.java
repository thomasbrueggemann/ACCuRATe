package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_285;
import com.google.android.gms.internal.class_344;
import com.google.android.gms.internal.class_614;
import com.google.android.gms.internal.class_615;
import com.google.android.gms.internal.class_616;
import com.google.android.gms.internal.class_617;
import com.google.android.gms.internal.class_618;
import com.google.android.gms.internal.class_619;
import com.google.android.gms.internal.class_620;
import com.google.android.gms.internal.class_621;
import com.google.android.gms.internal.class_622;
import com.google.android.gms.internal.class_623;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.kt
public final class class_288 extends class_285 implements SafeParcelable, Person {
   public static final class_623 CREATOR = new class_623();
   private static final HashMap<String, class_285.class_944<?, ?>> aco = new HashMap();
   // $FF: renamed from: Ao java.lang.String
   private String field_988;
   // $FF: renamed from: Lk java.lang.String
   private String field_989;
   private final Set<Integer> acp;
   private List<class_288.class_954> adA;
   private int adB;
   private int adC;
   private String adD;
   private List<class_288.class_955> adE;
   private boolean adF;
   private String adn;
   private class_288.class_946 ado;
   private String adp;
   private String adq;
   private int adr;
   private class_288.class_947 ads;
   private String adt;
   private class_288.class_950 adu;
   private boolean adv;
   private class_288.class_951 adw;
   private String adx;
   private int ady;
   private List<class_288.class_953> adz;
   // $FF: renamed from: mj int
   private int field_990;
   // $FF: renamed from: qV java.lang.String
   private String field_991;
   // $FF: renamed from: xD java.lang.String
   private String field_992;
   // $FF: renamed from: xJ int
   private final int field_993;

   static {
      aco.put("aboutMe", class_285.class_944.method_3210("aboutMe", 2));
      aco.put("ageRange", class_285.class_944.method_3204("ageRange", 3, class_288.class_946.class));
      aco.put("birthday", class_285.class_944.method_3210("birthday", 4));
      aco.put("braggingRights", class_285.class_944.method_3210("braggingRights", 5));
      aco.put("circledByCount", class_285.class_944.method_3207("circledByCount", 6));
      aco.put("cover", class_285.class_944.method_3204("cover", 7, class_288.class_947.class));
      aco.put("currentLocation", class_285.class_944.method_3210("currentLocation", 8));
      aco.put("displayName", class_285.class_944.method_3210("displayName", 9));
      aco.put("gender", class_285.class_944.method_3203("gender", 12, (new class_344()).method_2148("male", 0).method_2148("female", 1).method_2148("other", 2), false));
      aco.put("id", class_285.class_944.method_3210("id", 14));
      aco.put("image", class_285.class_944.method_3204("image", 15, class_288.class_950.class));
      aco.put("isPlusUser", class_285.class_944.method_3209("isPlusUser", 16));
      aco.put("language", class_285.class_944.method_3210("language", 18));
      aco.put("name", class_285.class_944.method_3204("name", 19, class_288.class_951.class));
      aco.put("nickname", class_285.class_944.method_3210("nickname", 20));
      aco.put("objectType", class_285.class_944.method_3203("objectType", 21, (new class_344()).method_2148("person", 0).method_2148("page", 1), false));
      aco.put("organizations", class_285.class_944.method_3205("organizations", 22, class_288.class_953.class));
      aco.put("placesLived", class_285.class_944.method_3205("placesLived", 23, class_288.class_954.class));
      aco.put("plusOneCount", class_285.class_944.method_3207("plusOneCount", 24));
      aco.put("relationshipStatus", class_285.class_944.method_3203("relationshipStatus", 25, (new class_344()).method_2148("single", 0).method_2148("in_a_relationship", 1).method_2148("engaged", 2).method_2148("married", 3).method_2148("its_complicated", 4).method_2148("open_relationship", 5).method_2148("widowed", 6).method_2148("in_domestic_partnership", 7).method_2148("in_civil_union", 8), false));
      aco.put("tagline", class_285.class_944.method_3210("tagline", 26));
      aco.put("url", class_285.class_944.method_3210("url", 27));
      aco.put("urls", class_285.class_944.method_3205("urls", 28, class_288.class_955.class));
      aco.put("verified", class_285.class_944.method_3209("verified", 29));
   }

   public class_288() {
      this.field_993 = 2;
      this.acp = new HashSet();
   }

   public class_288(String var1, String var2, class_288.class_950 var3, int var4, String var5) {
      this.field_993 = 2;
      this.acp = new HashSet();
      this.field_989 = var1;
      this.acp.add(Integer.valueOf(9));
      this.field_992 = var2;
      this.acp.add(Integer.valueOf(14));
      this.adu = var3;
      this.acp.add(Integer.valueOf(15));
      this.ady = var4;
      this.acp.add(Integer.valueOf(21));
      this.field_991 = var5;
      this.acp.add(Integer.valueOf(27));
   }

   class_288(Set<Integer> var1, int var2, String var3, class_288.class_946 var4, String var5, String var6, int var7, class_288.class_947 var8, String var9, String var10, int var11, String var12, class_288.class_950 var13, boolean var14, String var15, class_288.class_951 var16, String var17, int var18, List<class_288.class_953> var19, List<class_288.class_954> var20, int var21, int var22, String var23, String var24, List<class_288.class_955> var25, boolean var26) {
      this.acp = var1;
      this.field_993 = var2;
      this.adn = var3;
      this.ado = var4;
      this.adp = var5;
      this.adq = var6;
      this.adr = var7;
      this.ads = var8;
      this.adt = var9;
      this.field_989 = var10;
      this.field_990 = var11;
      this.field_992 = var12;
      this.adu = var13;
      this.adv = var14;
      this.field_988 = var15;
      this.adw = var16;
      this.adx = var17;
      this.ady = var18;
      this.adz = var19;
      this.adA = var20;
      this.adB = var21;
      this.adC = var22;
      this.adD = var23;
      this.field_991 = var24;
      this.adE = var25;
      this.adF = var26;
   }

   // $FF: renamed from: i (byte[]) com.google.android.gms.internal.kt
   public static class_288 method_1931(byte[] var0) {
      Parcel var1 = Parcel.obtain();
      var1.unmarshall(var0, 0, var0.length);
      var1.setDataPosition(0);
      class_288 var2 = CREATOR.method_3618(var1);
      var1.recycle();
      return var2;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.hz$a) boolean
   protected boolean method_1880(class_285.class_944 var1) {
      return this.acp.contains(Integer.valueOf(var1.method_3218()));
   }

   // $FF: renamed from: aF (java.lang.String) java.lang.Object
   protected Object method_1881(String var1) {
      return null;
   }

   // $FF: renamed from: aG (java.lang.String) boolean
   protected boolean method_1882(String var1) {
      return false;
   }

   // $FF: renamed from: b (com.google.android.gms.internal.hz$a) java.lang.Object
   protected Object method_1885(class_285.class_944 var1) {
      switch(var1.method_3218()) {
      case 2:
         return this.adn;
      case 3:
         return this.ado;
      case 4:
         return this.adp;
      case 5:
         return this.adq;
      case 6:
         return Integer.valueOf(this.adr);
      case 7:
         return this.ads;
      case 8:
         return this.adt;
      case 9:
         return this.field_989;
      case 10:
      case 11:
      case 13:
      case 17:
      default:
         throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3218());
      case 12:
         return Integer.valueOf(this.field_990);
      case 14:
         return this.field_992;
      case 15:
         return this.adu;
      case 16:
         return Boolean.valueOf(this.adv);
      case 18:
         return this.field_988;
      case 19:
         return this.adw;
      case 20:
         return this.adx;
      case 21:
         return Integer.valueOf(this.ady);
      case 22:
         return this.adz;
      case 23:
         return this.adA;
      case 24:
         return Integer.valueOf(this.adB);
      case 25:
         return Integer.valueOf(this.adC);
      case 26:
         return this.adD;
      case 27:
         return this.field_991;
      case 28:
         return this.adE;
      case 29:
         return Boolean.valueOf(this.adF);
      }
   }

   public int describeContents() {
      class_623 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class_288)) {
         return false;
      } else if(this == var1) {
         return true;
      } else {
         class_288 var2 = (class_288)var1;
         Iterator var3 = aco.values().iterator();

         while(var3.hasNext()) {
            class_285.class_944 var4 = (class_285.class_944)var3.next();
            if(this.method_1880(var4)) {
               if(!var2.method_1880(var4)) {
                  return false;
               }

               if(!this.method_1885(var4).equals(var2.method_1885(var4))) {
                  return false;
               }
            } else if(var2.method_1880(var4)) {
               return false;
            }
         }

         return true;
      }
   }

   // $FF: renamed from: fB () java.util.HashMap
   public HashMap<String, class_285.class_944<?, ?>> method_1886() {
      return aco;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1939();
   }

   public String getAboutMe() {
      return this.adn;
   }

   public Person.AgeRange getAgeRange() {
      return this.ado;
   }

   public String getBirthday() {
      return this.adp;
   }

   public String getBraggingRights() {
      return this.adq;
   }

   public int getCircledByCount() {
      return this.adr;
   }

   public Person.Cover getCover() {
      return this.ads;
   }

   public String getCurrentLocation() {
      return this.adt;
   }

   public String getDisplayName() {
      return this.field_989;
   }

   public int getGender() {
      return this.field_990;
   }

   public String getId() {
      return this.field_992;
   }

   public Person.Image getImage() {
      return this.adu;
   }

   public String getLanguage() {
      return this.field_988;
   }

   public Person.Name getName() {
      return this.adw;
   }

   public String getNickname() {
      return this.adx;
   }

   public int getObjectType() {
      return this.ady;
   }

   public List<Person.Organizations> getOrganizations() {
      return (ArrayList)this.adz;
   }

   public List<Person.PlacesLived> getPlacesLived() {
      return (ArrayList)this.adA;
   }

   public int getPlusOneCount() {
      return this.adB;
   }

   public int getRelationshipStatus() {
      return this.adC;
   }

   public String getTagline() {
      return this.adD;
   }

   public String getUrl() {
      return this.field_991;
   }

   public List<Person.Urls> getUrls() {
      return (ArrayList)this.adE;
   }

   int getVersionCode() {
      return this.field_993;
   }

   public boolean hasAboutMe() {
      return this.acp.contains(Integer.valueOf(2));
   }

   public boolean hasAgeRange() {
      return this.acp.contains(Integer.valueOf(3));
   }

   public boolean hasBirthday() {
      return this.acp.contains(Integer.valueOf(4));
   }

   public boolean hasBraggingRights() {
      return this.acp.contains(Integer.valueOf(5));
   }

   public boolean hasCircledByCount() {
      return this.acp.contains(Integer.valueOf(6));
   }

   public boolean hasCover() {
      return this.acp.contains(Integer.valueOf(7));
   }

   public boolean hasCurrentLocation() {
      return this.acp.contains(Integer.valueOf(8));
   }

   public boolean hasDisplayName() {
      return this.acp.contains(Integer.valueOf(9));
   }

   public boolean hasGender() {
      return this.acp.contains(Integer.valueOf(12));
   }

   public boolean hasId() {
      return this.acp.contains(Integer.valueOf(14));
   }

   public boolean hasImage() {
      return this.acp.contains(Integer.valueOf(15));
   }

   public boolean hasIsPlusUser() {
      return this.acp.contains(Integer.valueOf(16));
   }

   public boolean hasLanguage() {
      return this.acp.contains(Integer.valueOf(18));
   }

   public boolean hasName() {
      return this.acp.contains(Integer.valueOf(19));
   }

   public boolean hasNickname() {
      return this.acp.contains(Integer.valueOf(20));
   }

   public boolean hasObjectType() {
      return this.acp.contains(Integer.valueOf(21));
   }

   public boolean hasOrganizations() {
      return this.acp.contains(Integer.valueOf(22));
   }

   public boolean hasPlacesLived() {
      return this.acp.contains(Integer.valueOf(23));
   }

   public boolean hasPlusOneCount() {
      return this.acp.contains(Integer.valueOf(24));
   }

   public boolean hasRelationshipStatus() {
      return this.acp.contains(Integer.valueOf(25));
   }

   public boolean hasTagline() {
      return this.acp.contains(Integer.valueOf(26));
   }

   public boolean hasUrl() {
      return this.acp.contains(Integer.valueOf(27));
   }

   public boolean hasUrls() {
      return this.acp.contains(Integer.valueOf(28));
   }

   public boolean hasVerified() {
      return this.acp.contains(Integer.valueOf(29));
   }

   public int hashCode() {
      Iterator var1 = aco.values().iterator();

      int var2;
      int var4;
      for(var2 = 0; var1.hasNext(); var2 = var4) {
         class_285.class_944 var3 = (class_285.class_944)var1.next();
         if(this.method_1880(var3)) {
            var4 = var2 + var3.method_3218() + this.method_1885(var3).hashCode();
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
      return this.adv;
   }

   public boolean isVerified() {
      return this.adF;
   }

   // $FF: renamed from: kA () com.google.android.gms.internal.kt$a
   class_288.class_946 method_1932() {
      return this.ado;
   }

   // $FF: renamed from: kB () com.google.android.gms.internal.kt$b
   class_288.class_947 method_1933() {
      return this.ads;
   }

   // $FF: renamed from: kC () com.google.android.gms.internal.kt$c
   class_288.class_950 method_1934() {
      return this.adu;
   }

   // $FF: renamed from: kD () com.google.android.gms.internal.kt$d
   class_288.class_951 method_1935() {
      return this.adw;
   }

   // $FF: renamed from: kE () java.util.List
   List<class_288.class_953> method_1936() {
      return this.adz;
   }

   // $FF: renamed from: kF () java.util.List
   List<class_288.class_954> method_1937() {
      return this.adA;
   }

   // $FF: renamed from: kG () java.util.List
   List<class_288.class_955> method_1938() {
      return this.adE;
   }

   // $FF: renamed from: kH () com.google.android.gms.internal.kt
   public class_288 method_1939() {
      return this;
   }

   // $FF: renamed from: kf () java.util.Set
   Set<Integer> method_1940() {
      return this.acp;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_623 var10000 = CREATOR;
      class_623.method_3617(this, var1, var2);
   }

   public static final class class_946 extends class_285 implements SafeParcelable, Person.AgeRange {
      public static final class_622 CREATOR = new class_622();
      private static final HashMap<String, class_285.class_944<?, ?>> aco = new HashMap();
      private final Set<Integer> acp;
      private int adG;
      private int adH;
      // $FF: renamed from: xJ int
      private final int field_960;

      static {
         aco.put("max", class_285.class_944.method_3207("max", 2));
         aco.put("min", class_285.class_944.method_3207("min", 3));
      }

      public class_946() {
         this.field_960 = 1;
         this.acp = new HashSet();
      }

      class_946(Set<Integer> var1, int var2, int var3, int var4) {
         this.acp = var1;
         this.field_960 = var2;
         this.adG = var3;
         this.adH = var4;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.hz$a) boolean
      protected boolean method_1880(class_285.class_944 var1) {
         return this.acp.contains(Integer.valueOf(var1.method_3218()));
      }

      // $FF: renamed from: aF (java.lang.String) java.lang.Object
      protected Object method_1881(String var1) {
         return null;
      }

      // $FF: renamed from: aG (java.lang.String) boolean
      protected boolean method_1882(String var1) {
         return false;
      }

      // $FF: renamed from: b (com.google.android.gms.internal.hz$a) java.lang.Object
      protected Object method_1885(class_285.class_944 var1) {
         switch(var1.method_3218()) {
         case 2:
            return Integer.valueOf(this.adG);
         case 3:
            return Integer.valueOf(this.adH);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3218());
         }
      }

      public int describeContents() {
         class_622 var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_288.class_946)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_288.class_946 var2 = (class_288.class_946)var1;
            Iterator var3 = aco.values().iterator();

            while(var3.hasNext()) {
               class_285.class_944 var4 = (class_285.class_944)var3.next();
               if(this.method_1880(var4)) {
                  if(!var2.method_1880(var4)) {
                     return false;
                  }

                  if(!this.method_1885(var4).equals(var2.method_1885(var4))) {
                     return false;
                  }
               } else if(var2.method_1880(var4)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: renamed from: fB () java.util.HashMap
      public HashMap<String, class_285.class_944<?, ?>> method_1886() {
         return aco;
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.method_1889();
      }

      public int getMax() {
         return this.adG;
      }

      public int getMin() {
         return this.adH;
      }

      int getVersionCode() {
         return this.field_960;
      }

      public boolean hasMax() {
         return this.acp.contains(Integer.valueOf(2));
      }

      public boolean hasMin() {
         return this.acp.contains(Integer.valueOf(3));
      }

      public int hashCode() {
         Iterator var1 = aco.values().iterator();

         int var2;
         int var4;
         for(var2 = 0; var1.hasNext(); var2 = var4) {
            class_285.class_944 var3 = (class_285.class_944)var1.next();
            if(this.method_1880(var3)) {
               var4 = var2 + var3.method_3218() + this.method_1885(var3).hashCode();
            } else {
               var4 = var2;
            }
         }

         return var2;
      }

      public boolean isDataValid() {
         return true;
      }

      // $FF: renamed from: kI () com.google.android.gms.internal.kt$a
      public class_288.class_946 method_1889() {
         return this;
      }

      // $FF: renamed from: kf () java.util.Set
      Set<Integer> method_1890() {
         return this.acp;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_622 var10000 = CREATOR;
         class_622.method_3614(this, var1, var2);
      }
   }

   public static final class class_947 extends class_285 implements SafeParcelable, Person.Cover {
      public static final class_621 CREATOR = new class_621();
      private static final HashMap<String, class_285.class_944<?, ?>> aco = new HashMap();
      private final Set<Integer> acp;
      private class_288.class_948 adI;
      private class_288.class_949 adJ;
      private int adK;
      // $FF: renamed from: xJ int
      private final int field_961;

      static {
         aco.put("coverInfo", class_285.class_944.method_3204("coverInfo", 2, class_288.class_948.class));
         aco.put("coverPhoto", class_285.class_944.method_3204("coverPhoto", 3, class_288.class_949.class));
         aco.put("layout", class_285.class_944.method_3203("layout", 4, (new class_344()).method_2148("banner", 0), false));
      }

      public class_947() {
         this.field_961 = 1;
         this.acp = new HashSet();
      }

      class_947(Set<Integer> var1, int var2, class_288.class_948 var3, class_288.class_949 var4, int var5) {
         this.acp = var1;
         this.field_961 = var2;
         this.adI = var3;
         this.adJ = var4;
         this.adK = var5;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.hz$a) boolean
      protected boolean method_1880(class_285.class_944 var1) {
         return this.acp.contains(Integer.valueOf(var1.method_3218()));
      }

      // $FF: renamed from: aF (java.lang.String) java.lang.Object
      protected Object method_1881(String var1) {
         return null;
      }

      // $FF: renamed from: aG (java.lang.String) boolean
      protected boolean method_1882(String var1) {
         return false;
      }

      // $FF: renamed from: b (com.google.android.gms.internal.hz$a) java.lang.Object
      protected Object method_1885(class_285.class_944 var1) {
         switch(var1.method_3218()) {
         case 2:
            return this.adI;
         case 3:
            return this.adJ;
         case 4:
            return Integer.valueOf(this.adK);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3218());
         }
      }

      public int describeContents() {
         class_621 var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_288.class_947)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_288.class_947 var2 = (class_288.class_947)var1;
            Iterator var3 = aco.values().iterator();

            while(var3.hasNext()) {
               class_285.class_944 var4 = (class_285.class_944)var3.next();
               if(this.method_1880(var4)) {
                  if(!var2.method_1880(var4)) {
                     return false;
                  }

                  if(!this.method_1885(var4).equals(var2.method_1885(var4))) {
                     return false;
                  }
               } else if(var2.method_1880(var4)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: renamed from: fB () java.util.HashMap
      public HashMap<String, class_285.class_944<?, ?>> method_1886() {
         return aco;
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.method_1893();
      }

      public Person.CoverInfo getCoverInfo() {
         return this.adI;
      }

      public Person.CoverPhoto getCoverPhoto() {
         return this.adJ;
      }

      public int getLayout() {
         return this.adK;
      }

      int getVersionCode() {
         return this.field_961;
      }

      public boolean hasCoverInfo() {
         return this.acp.contains(Integer.valueOf(2));
      }

      public boolean hasCoverPhoto() {
         return this.acp.contains(Integer.valueOf(3));
      }

      public boolean hasLayout() {
         return this.acp.contains(Integer.valueOf(4));
      }

      public int hashCode() {
         Iterator var1 = aco.values().iterator();

         int var2;
         int var4;
         for(var2 = 0; var1.hasNext(); var2 = var4) {
            class_285.class_944 var3 = (class_285.class_944)var1.next();
            if(this.method_1880(var3)) {
               var4 = var2 + var3.method_3218() + this.method_1885(var3).hashCode();
            } else {
               var4 = var2;
            }
         }

         return var2;
      }

      public boolean isDataValid() {
         return true;
      }

      // $FF: renamed from: kJ () com.google.android.gms.internal.kt$b$a
      class_288.class_948 method_1891() {
         return this.adI;
      }

      // $FF: renamed from: kK () com.google.android.gms.internal.kt$b$b
      class_288.class_949 method_1892() {
         return this.adJ;
      }

      // $FF: renamed from: kL () com.google.android.gms.internal.kt$b
      public class_288.class_947 method_1893() {
         return this;
      }

      // $FF: renamed from: kf () java.util.Set
      Set<Integer> method_1894() {
         return this.acp;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_621 var10000 = CREATOR;
         class_621.method_3611(this, var1, var2);
      }
   }

   public static final class class_948 extends class_285 implements SafeParcelable, Person.CoverInfo {
      public static final class_620 CREATOR = new class_620();
      private static final HashMap<String, class_285.class_944<?, ?>> aco = new HashMap();
      private final Set<Integer> acp;
      private int adL;
      private int adM;
      // $FF: renamed from: xJ int
      private final int field_972;

      static {
         aco.put("leftImageOffset", class_285.class_944.method_3207("leftImageOffset", 2));
         aco.put("topImageOffset", class_285.class_944.method_3207("topImageOffset", 3));
      }

      public class_948() {
         this.field_972 = 1;
         this.acp = new HashSet();
      }

      class_948(Set<Integer> var1, int var2, int var3, int var4) {
         this.acp = var1;
         this.field_972 = var2;
         this.adL = var3;
         this.adM = var4;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.hz$a) boolean
      protected boolean method_1880(class_285.class_944 var1) {
         return this.acp.contains(Integer.valueOf(var1.method_3218()));
      }

      // $FF: renamed from: aF (java.lang.String) java.lang.Object
      protected Object method_1881(String var1) {
         return null;
      }

      // $FF: renamed from: aG (java.lang.String) boolean
      protected boolean method_1882(String var1) {
         return false;
      }

      // $FF: renamed from: b (com.google.android.gms.internal.hz$a) java.lang.Object
      protected Object method_1885(class_285.class_944 var1) {
         switch(var1.method_3218()) {
         case 2:
            return Integer.valueOf(this.adL);
         case 3:
            return Integer.valueOf(this.adM);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3218());
         }
      }

      public int describeContents() {
         class_620 var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_288.class_948)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_288.class_948 var2 = (class_288.class_948)var1;
            Iterator var3 = aco.values().iterator();

            while(var3.hasNext()) {
               class_285.class_944 var4 = (class_285.class_944)var3.next();
               if(this.method_1880(var4)) {
                  if(!var2.method_1880(var4)) {
                     return false;
                  }

                  if(!this.method_1885(var4).equals(var2.method_1885(var4))) {
                     return false;
                  }
               } else if(var2.method_1880(var4)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: renamed from: fB () java.util.HashMap
      public HashMap<String, class_285.class_944<?, ?>> method_1886() {
         return aco;
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.method_1906();
      }

      public int getLeftImageOffset() {
         return this.adL;
      }

      public int getTopImageOffset() {
         return this.adM;
      }

      int getVersionCode() {
         return this.field_972;
      }

      public boolean hasLeftImageOffset() {
         return this.acp.contains(Integer.valueOf(2));
      }

      public boolean hasTopImageOffset() {
         return this.acp.contains(Integer.valueOf(3));
      }

      public int hashCode() {
         Iterator var1 = aco.values().iterator();

         int var2;
         int var4;
         for(var2 = 0; var1.hasNext(); var2 = var4) {
            class_285.class_944 var3 = (class_285.class_944)var1.next();
            if(this.method_1880(var3)) {
               var4 = var2 + var3.method_3218() + this.method_1885(var3).hashCode();
            } else {
               var4 = var2;
            }
         }

         return var2;
      }

      public boolean isDataValid() {
         return true;
      }

      // $FF: renamed from: kM () com.google.android.gms.internal.kt$b$a
      public class_288.class_948 method_1906() {
         return this;
      }

      // $FF: renamed from: kf () java.util.Set
      Set<Integer> method_1907() {
         return this.acp;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_620 var10000 = CREATOR;
         class_620.method_3608(this, var1, var2);
      }
   }

   public static final class class_949 extends class_285 implements SafeParcelable, Person.CoverPhoto {
      public static final class_619 CREATOR = new class_619();
      private static final HashMap<String, class_285.class_944<?, ?>> aco = new HashMap();
      private final Set<Integer> acp;
      // $FF: renamed from: ks int
      private int field_973;
      // $FF: renamed from: kt int
      private int field_974;
      // $FF: renamed from: qV java.lang.String
      private String field_975;
      // $FF: renamed from: xJ int
      private final int field_976;

      static {
         aco.put("height", class_285.class_944.method_3207("height", 2));
         aco.put("url", class_285.class_944.method_3210("url", 3));
         aco.put("width", class_285.class_944.method_3207("width", 4));
      }

      public class_949() {
         this.field_976 = 1;
         this.acp = new HashSet();
      }

      class_949(Set<Integer> var1, int var2, int var3, String var4, int var5) {
         this.acp = var1;
         this.field_976 = var2;
         this.field_974 = var3;
         this.field_975 = var4;
         this.field_973 = var5;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.hz$a) boolean
      protected boolean method_1880(class_285.class_944 var1) {
         return this.acp.contains(Integer.valueOf(var1.method_3218()));
      }

      // $FF: renamed from: aF (java.lang.String) java.lang.Object
      protected Object method_1881(String var1) {
         return null;
      }

      // $FF: renamed from: aG (java.lang.String) boolean
      protected boolean method_1882(String var1) {
         return false;
      }

      // $FF: renamed from: b (com.google.android.gms.internal.hz$a) java.lang.Object
      protected Object method_1885(class_285.class_944 var1) {
         switch(var1.method_3218()) {
         case 2:
            return Integer.valueOf(this.field_974);
         case 3:
            return this.field_975;
         case 4:
            return Integer.valueOf(this.field_973);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3218());
         }
      }

      public int describeContents() {
         class_619 var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_288.class_949)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_288.class_949 var2 = (class_288.class_949)var1;
            Iterator var3 = aco.values().iterator();

            while(var3.hasNext()) {
               class_285.class_944 var4 = (class_285.class_944)var3.next();
               if(this.method_1880(var4)) {
                  if(!var2.method_1880(var4)) {
                     return false;
                  }

                  if(!this.method_1885(var4).equals(var2.method_1885(var4))) {
                     return false;
                  }
               } else if(var2.method_1880(var4)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: renamed from: fB () java.util.HashMap
      public HashMap<String, class_285.class_944<?, ?>> method_1886() {
         return aco;
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.method_1908();
      }

      public int getHeight() {
         return this.field_974;
      }

      public String getUrl() {
         return this.field_975;
      }

      int getVersionCode() {
         return this.field_976;
      }

      public int getWidth() {
         return this.field_973;
      }

      public boolean hasHeight() {
         return this.acp.contains(Integer.valueOf(2));
      }

      public boolean hasUrl() {
         return this.acp.contains(Integer.valueOf(3));
      }

      public boolean hasWidth() {
         return this.acp.contains(Integer.valueOf(4));
      }

      public int hashCode() {
         Iterator var1 = aco.values().iterator();

         int var2;
         int var4;
         for(var2 = 0; var1.hasNext(); var2 = var4) {
            class_285.class_944 var3 = (class_285.class_944)var1.next();
            if(this.method_1880(var3)) {
               var4 = var2 + var3.method_3218() + this.method_1885(var3).hashCode();
            } else {
               var4 = var2;
            }
         }

         return var2;
      }

      public boolean isDataValid() {
         return true;
      }

      // $FF: renamed from: kN () com.google.android.gms.internal.kt$b$b
      public class_288.class_949 method_1908() {
         return this;
      }

      // $FF: renamed from: kf () java.util.Set
      Set<Integer> method_1909() {
         return this.acp;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_619 var10000 = CREATOR;
         class_619.method_3605(this, var1, var2);
      }
   }

   public static final class class_950 extends class_285 implements SafeParcelable, Person.Image {
      public static final class_618 CREATOR = new class_618();
      private static final HashMap<String, class_285.class_944<?, ?>> aco = new HashMap();
      private final Set<Integer> acp;
      // $FF: renamed from: qV java.lang.String
      private String field_966;
      // $FF: renamed from: xJ int
      private final int field_967;

      static {
         aco.put("url", class_285.class_944.method_3210("url", 2));
      }

      public class_950() {
         this.field_967 = 1;
         this.acp = new HashSet();
      }

      public class_950(String var1) {
         this.acp = new HashSet();
         this.field_967 = 1;
         this.field_966 = var1;
         this.acp.add(Integer.valueOf(2));
      }

      class_950(Set<Integer> var1, int var2, String var3) {
         this.acp = var1;
         this.field_967 = var2;
         this.field_966 = var3;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.hz$a) boolean
      protected boolean method_1880(class_285.class_944 var1) {
         return this.acp.contains(Integer.valueOf(var1.method_3218()));
      }

      // $FF: renamed from: aF (java.lang.String) java.lang.Object
      protected Object method_1881(String var1) {
         return null;
      }

      // $FF: renamed from: aG (java.lang.String) boolean
      protected boolean method_1882(String var1) {
         return false;
      }

      // $FF: renamed from: b (com.google.android.gms.internal.hz$a) java.lang.Object
      protected Object method_1885(class_285.class_944 var1) {
         switch(var1.method_3218()) {
         case 2:
            return this.field_966;
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3218());
         }
      }

      public int describeContents() {
         class_618 var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_288.class_950)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_288.class_950 var2 = (class_288.class_950)var1;
            Iterator var3 = aco.values().iterator();

            while(var3.hasNext()) {
               class_285.class_944 var4 = (class_285.class_944)var3.next();
               if(this.method_1880(var4)) {
                  if(!var2.method_1880(var4)) {
                     return false;
                  }

                  if(!this.method_1885(var4).equals(var2.method_1885(var4))) {
                     return false;
                  }
               } else if(var2.method_1880(var4)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: renamed from: fB () java.util.HashMap
      public HashMap<String, class_285.class_944<?, ?>> method_1886() {
         return aco;
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.method_1902();
      }

      public String getUrl() {
         return this.field_966;
      }

      int getVersionCode() {
         return this.field_967;
      }

      public boolean hasUrl() {
         return this.acp.contains(Integer.valueOf(2));
      }

      public int hashCode() {
         Iterator var1 = aco.values().iterator();

         int var2;
         int var4;
         for(var2 = 0; var1.hasNext(); var2 = var4) {
            class_285.class_944 var3 = (class_285.class_944)var1.next();
            if(this.method_1880(var3)) {
               var4 = var2 + var3.method_3218() + this.method_1885(var3).hashCode();
            } else {
               var4 = var2;
            }
         }

         return var2;
      }

      public boolean isDataValid() {
         return true;
      }

      // $FF: renamed from: kO () com.google.android.gms.internal.kt$c
      public class_288.class_950 method_1902() {
         return this;
      }

      // $FF: renamed from: kf () java.util.Set
      Set<Integer> method_1903() {
         return this.acp;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_618 var10000 = CREATOR;
         class_618.method_3602(this, var1, var2);
      }
   }

   public static final class class_951 extends class_285 implements SafeParcelable, Person.Name {
      public static final class_617 CREATOR = new class_617();
      private static final HashMap<String, class_285.class_944<?, ?>> aco = new HashMap();
      private String acN;
      private String acQ;
      private final Set<Integer> acp;
      private String adN;
      private String adO;
      private String adP;
      private String adQ;
      // $FF: renamed from: xJ int
      private final int field_965;

      static {
         aco.put("familyName", class_285.class_944.method_3210("familyName", 2));
         aco.put("formatted", class_285.class_944.method_3210("formatted", 3));
         aco.put("givenName", class_285.class_944.method_3210("givenName", 4));
         aco.put("honorificPrefix", class_285.class_944.method_3210("honorificPrefix", 5));
         aco.put("honorificSuffix", class_285.class_944.method_3210("honorificSuffix", 6));
         aco.put("middleName", class_285.class_944.method_3210("middleName", 7));
      }

      public class_951() {
         this.field_965 = 1;
         this.acp = new HashSet();
      }

      class_951(Set<Integer> var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8) {
         this.acp = var1;
         this.field_965 = var2;
         this.acN = var3;
         this.adN = var4;
         this.acQ = var5;
         this.adO = var6;
         this.adP = var7;
         this.adQ = var8;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.hz$a) boolean
      protected boolean method_1880(class_285.class_944 var1) {
         return this.acp.contains(Integer.valueOf(var1.method_3218()));
      }

      // $FF: renamed from: aF (java.lang.String) java.lang.Object
      protected Object method_1881(String var1) {
         return null;
      }

      // $FF: renamed from: aG (java.lang.String) boolean
      protected boolean method_1882(String var1) {
         return false;
      }

      // $FF: renamed from: b (com.google.android.gms.internal.hz$a) java.lang.Object
      protected Object method_1885(class_285.class_944 var1) {
         switch(var1.method_3218()) {
         case 2:
            return this.acN;
         case 3:
            return this.adN;
         case 4:
            return this.acQ;
         case 5:
            return this.adO;
         case 6:
            return this.adP;
         case 7:
            return this.adQ;
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3218());
         }
      }

      public int describeContents() {
         class_617 var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_288.class_951)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_288.class_951 var2 = (class_288.class_951)var1;
            Iterator var3 = aco.values().iterator();

            while(var3.hasNext()) {
               class_285.class_944 var4 = (class_285.class_944)var3.next();
               if(this.method_1880(var4)) {
                  if(!var2.method_1880(var4)) {
                     return false;
                  }

                  if(!this.method_1885(var4).equals(var2.method_1885(var4))) {
                     return false;
                  }
               } else if(var2.method_1880(var4)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: renamed from: fB () java.util.HashMap
      public HashMap<String, class_285.class_944<?, ?>> method_1886() {
         return aco;
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.method_1900();
      }

      public String getFamilyName() {
         return this.acN;
      }

      public String getFormatted() {
         return this.adN;
      }

      public String getGivenName() {
         return this.acQ;
      }

      public String getHonorificPrefix() {
         return this.adO;
      }

      public String getHonorificSuffix() {
         return this.adP;
      }

      public String getMiddleName() {
         return this.adQ;
      }

      int getVersionCode() {
         return this.field_965;
      }

      public boolean hasFamilyName() {
         return this.acp.contains(Integer.valueOf(2));
      }

      public boolean hasFormatted() {
         return this.acp.contains(Integer.valueOf(3));
      }

      public boolean hasGivenName() {
         return this.acp.contains(Integer.valueOf(4));
      }

      public boolean hasHonorificPrefix() {
         return this.acp.contains(Integer.valueOf(5));
      }

      public boolean hasHonorificSuffix() {
         return this.acp.contains(Integer.valueOf(6));
      }

      public boolean hasMiddleName() {
         return this.acp.contains(Integer.valueOf(7));
      }

      public int hashCode() {
         Iterator var1 = aco.values().iterator();

         int var2;
         int var4;
         for(var2 = 0; var1.hasNext(); var2 = var4) {
            class_285.class_944 var3 = (class_285.class_944)var1.next();
            if(this.method_1880(var3)) {
               var4 = var2 + var3.method_3218() + this.method_1885(var3).hashCode();
            } else {
               var4 = var2;
            }
         }

         return var2;
      }

      public boolean isDataValid() {
         return true;
      }

      // $FF: renamed from: kP () com.google.android.gms.internal.kt$d
      public class_288.class_951 method_1900() {
         return this;
      }

      // $FF: renamed from: kf () java.util.Set
      Set<Integer> method_1901() {
         return this.acp;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_617 var10000 = CREATOR;
         class_617.method_3599(this, var1, var2);
      }
   }

   public static class class_952 {
      // $FF: renamed from: bA (java.lang.String) int
      public static int method_4526(String var0) {
         if(var0.equals("person")) {
            return 0;
         } else if(var0.equals("page")) {
            return 1;
         } else {
            throw new IllegalArgumentException("Unknown objectType string: " + var0);
         }
      }
   }

   public static final class class_953 extends class_285 implements SafeParcelable, Person.Organizations {
      public static final class_616 CREATOR = new class_616();
      private static final HashMap<String, class_285.class_944<?, ?>> aco = new HashMap();
      // $FF: renamed from: AQ int
      private int field_968;
      // $FF: renamed from: HV java.lang.String
      private String field_969;
      // $FF: renamed from: Mm java.lang.String
      private String field_970;
      private String acM;
      private final Set<Integer> acp;
      private String adR;
      private String adS;
      private boolean adT;
      private String adc;
      private String mName;
      // $FF: renamed from: xJ int
      private final int field_971;

      static {
         aco.put("department", class_285.class_944.method_3210("department", 2));
         aco.put("description", class_285.class_944.method_3210("description", 3));
         aco.put("endDate", class_285.class_944.method_3210("endDate", 4));
         aco.put("location", class_285.class_944.method_3210("location", 5));
         aco.put("name", class_285.class_944.method_3210("name", 6));
         aco.put("primary", class_285.class_944.method_3209("primary", 7));
         aco.put("startDate", class_285.class_944.method_3210("startDate", 8));
         aco.put("title", class_285.class_944.method_3210("title", 9));
         aco.put("type", class_285.class_944.method_3203("type", 10, (new class_344()).method_2148("work", 0).method_2148("school", 1), false));
      }

      public class_953() {
         this.field_971 = 1;
         this.acp = new HashSet();
      }

      class_953(Set<Integer> var1, int var2, String var3, String var4, String var5, String var6, String var7, boolean var8, String var9, String var10, int var11) {
         this.acp = var1;
         this.field_971 = var2;
         this.adR = var3;
         this.field_970 = var4;
         this.acM = var5;
         this.adS = var6;
         this.mName = var7;
         this.adT = var8;
         this.adc = var9;
         this.field_969 = var10;
         this.field_968 = var11;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.hz$a) boolean
      protected boolean method_1880(class_285.class_944 var1) {
         return this.acp.contains(Integer.valueOf(var1.method_3218()));
      }

      // $FF: renamed from: aF (java.lang.String) java.lang.Object
      protected Object method_1881(String var1) {
         return null;
      }

      // $FF: renamed from: aG (java.lang.String) boolean
      protected boolean method_1882(String var1) {
         return false;
      }

      // $FF: renamed from: b (com.google.android.gms.internal.hz$a) java.lang.Object
      protected Object method_1885(class_285.class_944 var1) {
         switch(var1.method_3218()) {
         case 2:
            return this.adR;
         case 3:
            return this.field_970;
         case 4:
            return this.acM;
         case 5:
            return this.adS;
         case 6:
            return this.mName;
         case 7:
            return Boolean.valueOf(this.adT);
         case 8:
            return this.adc;
         case 9:
            return this.field_969;
         case 10:
            return Integer.valueOf(this.field_968);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3218());
         }
      }

      public int describeContents() {
         class_616 var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_288.class_953)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_288.class_953 var2 = (class_288.class_953)var1;
            Iterator var3 = aco.values().iterator();

            while(var3.hasNext()) {
               class_285.class_944 var4 = (class_285.class_944)var3.next();
               if(this.method_1880(var4)) {
                  if(!var2.method_1880(var4)) {
                     return false;
                  }

                  if(!this.method_1885(var4).equals(var2.method_1885(var4))) {
                     return false;
                  }
               } else if(var2.method_1880(var4)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: renamed from: fB () java.util.HashMap
      public HashMap<String, class_285.class_944<?, ?>> method_1886() {
         return aco;
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.method_1904();
      }

      public String getDepartment() {
         return this.adR;
      }

      public String getDescription() {
         return this.field_970;
      }

      public String getEndDate() {
         return this.acM;
      }

      public String getLocation() {
         return this.adS;
      }

      public String getName() {
         return this.mName;
      }

      public String getStartDate() {
         return this.adc;
      }

      public String getTitle() {
         return this.field_969;
      }

      public int getType() {
         return this.field_968;
      }

      int getVersionCode() {
         return this.field_971;
      }

      public boolean hasDepartment() {
         return this.acp.contains(Integer.valueOf(2));
      }

      public boolean hasDescription() {
         return this.acp.contains(Integer.valueOf(3));
      }

      public boolean hasEndDate() {
         return this.acp.contains(Integer.valueOf(4));
      }

      public boolean hasLocation() {
         return this.acp.contains(Integer.valueOf(5));
      }

      public boolean hasName() {
         return this.acp.contains(Integer.valueOf(6));
      }

      public boolean hasPrimary() {
         return this.acp.contains(Integer.valueOf(7));
      }

      public boolean hasStartDate() {
         return this.acp.contains(Integer.valueOf(8));
      }

      public boolean hasTitle() {
         return this.acp.contains(Integer.valueOf(9));
      }

      public boolean hasType() {
         return this.acp.contains(Integer.valueOf(10));
      }

      public int hashCode() {
         Iterator var1 = aco.values().iterator();

         int var2;
         int var4;
         for(var2 = 0; var1.hasNext(); var2 = var4) {
            class_285.class_944 var3 = (class_285.class_944)var1.next();
            if(this.method_1880(var3)) {
               var4 = var2 + var3.method_3218() + this.method_1885(var3).hashCode();
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
         return this.adT;
      }

      // $FF: renamed from: kQ () com.google.android.gms.internal.kt$f
      public class_288.class_953 method_1904() {
         return this;
      }

      // $FF: renamed from: kf () java.util.Set
      Set<Integer> method_1905() {
         return this.acp;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_616 var10000 = CREATOR;
         class_616.method_3596(this, var1, var2);
      }
   }

   public static final class class_954 extends class_285 implements SafeParcelable, Person.PlacesLived {
      public static final class_615 CREATOR = new class_615();
      private static final HashMap<String, class_285.class_944<?, ?>> aco = new HashMap();
      private final Set<Integer> acp;
      private boolean adT;
      private String mValue;
      // $FF: renamed from: xJ int
      private final int field_964;

      static {
         aco.put("primary", class_285.class_944.method_3209("primary", 2));
         aco.put("value", class_285.class_944.method_3210("value", 3));
      }

      public class_954() {
         this.field_964 = 1;
         this.acp = new HashSet();
      }

      class_954(Set<Integer> var1, int var2, boolean var3, String var4) {
         this.acp = var1;
         this.field_964 = var2;
         this.adT = var3;
         this.mValue = var4;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.hz$a) boolean
      protected boolean method_1880(class_285.class_944 var1) {
         return this.acp.contains(Integer.valueOf(var1.method_3218()));
      }

      // $FF: renamed from: aF (java.lang.String) java.lang.Object
      protected Object method_1881(String var1) {
         return null;
      }

      // $FF: renamed from: aG (java.lang.String) boolean
      protected boolean method_1882(String var1) {
         return false;
      }

      // $FF: renamed from: b (com.google.android.gms.internal.hz$a) java.lang.Object
      protected Object method_1885(class_285.class_944 var1) {
         switch(var1.method_3218()) {
         case 2:
            return Boolean.valueOf(this.adT);
         case 3:
            return this.mValue;
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3218());
         }
      }

      public int describeContents() {
         class_615 var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_288.class_954)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_288.class_954 var2 = (class_288.class_954)var1;
            Iterator var3 = aco.values().iterator();

            while(var3.hasNext()) {
               class_285.class_944 var4 = (class_285.class_944)var3.next();
               if(this.method_1880(var4)) {
                  if(!var2.method_1880(var4)) {
                     return false;
                  }

                  if(!this.method_1885(var4).equals(var2.method_1885(var4))) {
                     return false;
                  }
               } else if(var2.method_1880(var4)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: renamed from: fB () java.util.HashMap
      public HashMap<String, class_285.class_944<?, ?>> method_1886() {
         return aco;
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.method_1898();
      }

      public String getValue() {
         return this.mValue;
      }

      int getVersionCode() {
         return this.field_964;
      }

      public boolean hasPrimary() {
         return this.acp.contains(Integer.valueOf(2));
      }

      public boolean hasValue() {
         return this.acp.contains(Integer.valueOf(3));
      }

      public int hashCode() {
         Iterator var1 = aco.values().iterator();

         int var2;
         int var4;
         for(var2 = 0; var1.hasNext(); var2 = var4) {
            class_285.class_944 var3 = (class_285.class_944)var1.next();
            if(this.method_1880(var3)) {
               var4 = var2 + var3.method_3218() + this.method_1885(var3).hashCode();
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
         return this.adT;
      }

      // $FF: renamed from: kR () com.google.android.gms.internal.kt$g
      public class_288.class_954 method_1898() {
         return this;
      }

      // $FF: renamed from: kf () java.util.Set
      Set<Integer> method_1899() {
         return this.acp;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_615 var10000 = CREATOR;
         class_615.method_3593(this, var1, var2);
      }
   }

   public static final class class_955 extends class_285 implements SafeParcelable, Person.Urls {
      public static final class_614 CREATOR = new class_614();
      private static final HashMap<String, class_285.class_944<?, ?>> aco = new HashMap();
      // $FF: renamed from: AQ int
      private int field_962;
      private final Set<Integer> acp;
      private String adU;
      private final int adV = 4;
      private String mValue;
      // $FF: renamed from: xJ int
      private final int field_963;

      static {
         aco.put("label", class_285.class_944.method_3210("label", 5));
         aco.put("type", class_285.class_944.method_3203("type", 6, (new class_344()).method_2148("home", 0).method_2148("work", 1).method_2148("blog", 2).method_2148("profile", 3).method_2148("other", 4).method_2148("otherProfile", 5).method_2148("contributor", 6).method_2148("website", 7), false));
         aco.put("value", class_285.class_944.method_3210("value", 4));
      }

      public class_955() {
         this.field_963 = 2;
         this.acp = new HashSet();
      }

      class_955(Set<Integer> var1, int var2, String var3, int var4, String var5, int var6) {
         this.acp = var1;
         this.field_963 = var2;
         this.adU = var3;
         this.field_962 = var4;
         this.mValue = var5;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.hz$a) boolean
      protected boolean method_1880(class_285.class_944 var1) {
         return this.acp.contains(Integer.valueOf(var1.method_3218()));
      }

      // $FF: renamed from: aF (java.lang.String) java.lang.Object
      protected Object method_1881(String var1) {
         return null;
      }

      // $FF: renamed from: aG (java.lang.String) boolean
      protected boolean method_1882(String var1) {
         return false;
      }

      // $FF: renamed from: b (com.google.android.gms.internal.hz$a) java.lang.Object
      protected Object method_1885(class_285.class_944 var1) {
         switch(var1.method_3218()) {
         case 4:
            return this.mValue;
         case 5:
            return this.adU;
         case 6:
            return Integer.valueOf(this.field_962);
         default:
            throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3218());
         }
      }

      public int describeContents() {
         class_614 var10000 = CREATOR;
         return 0;
      }

      public boolean equals(Object var1) {
         if(!(var1 instanceof class_288.class_955)) {
            return false;
         } else if(this == var1) {
            return true;
         } else {
            class_288.class_955 var2 = (class_288.class_955)var1;
            Iterator var3 = aco.values().iterator();

            while(var3.hasNext()) {
               class_285.class_944 var4 = (class_285.class_944)var3.next();
               if(this.method_1880(var4)) {
                  if(!var2.method_1880(var4)) {
                     return false;
                  }

                  if(!this.method_1885(var4).equals(var2.method_1885(var4))) {
                     return false;
                  }
               } else if(var2.method_1880(var4)) {
                  return false;
               }
            }

            return true;
         }
      }

      // $FF: renamed from: fB () java.util.HashMap
      public HashMap<String, class_285.class_944<?, ?>> method_1886() {
         return aco;
      }

      // $FF: synthetic method
      public Object freeze() {
         return this.method_1896();
      }

      public String getLabel() {
         return this.adU;
      }

      public int getType() {
         return this.field_962;
      }

      public String getValue() {
         return this.mValue;
      }

      int getVersionCode() {
         return this.field_963;
      }

      public boolean hasLabel() {
         return this.acp.contains(Integer.valueOf(5));
      }

      public boolean hasType() {
         return this.acp.contains(Integer.valueOf(6));
      }

      public boolean hasValue() {
         return this.acp.contains(Integer.valueOf(4));
      }

      public int hashCode() {
         Iterator var1 = aco.values().iterator();

         int var2;
         int var4;
         for(var2 = 0; var1.hasNext(); var2 = var4) {
            class_285.class_944 var3 = (class_285.class_944)var1.next();
            if(this.method_1880(var3)) {
               var4 = var2 + var3.method_3218() + this.method_1885(var3).hashCode();
            } else {
               var4 = var2;
            }
         }

         return var2;
      }

      public boolean isDataValid() {
         return true;
      }

      // $FF: renamed from: kS () int
      @Deprecated
      public int method_1895() {
         return 4;
      }

      // $FF: renamed from: kT () com.google.android.gms.internal.kt$h
      public class_288.class_955 method_1896() {
         return this;
      }

      // $FF: renamed from: kf () java.util.Set
      Set<Integer> method_1897() {
         return this.acp;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_614 var10000 = CREATOR;
         class_614.method_3589(this, var1, var2);
      }
   }
}
