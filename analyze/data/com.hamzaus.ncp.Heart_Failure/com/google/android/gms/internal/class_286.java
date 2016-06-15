package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_285;
import com.google.android.gms.internal.class_625;
import com.google.android.gms.internal.ko;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.ko
public final class class_286 extends class_285 implements SafeParcelable, ItemScope {
   public static final class_625 CREATOR = new class_625();
   private static final HashMap<String, class_285.class_944<?, ?>> aco = new HashMap();
   // $FF: renamed from: Mm java.lang.String
   private String field_977;
   // $FF: renamed from: Va double
   private double field_978;
   // $FF: renamed from: Vb double
   private double field_979;
   private List<ko> acA;
   private String acB;
   private String acC;
   private class_286 acD;
   private String acE;
   private String acF;
   private List<ko> acG;
   private String acH;
   private String acI;
   private String acJ;
   private String acK;
   private String acL;
   private String acM;
   private String acN;
   private String acO;
   private class_286 acP;
   private String acQ;
   private String acR;
   private String acS;
   private class_286 acT;
   private class_286 acU;
   private class_286 acV;
   private List<ko> acW;
   private String acX;
   private String acY;
   private String acZ;
   private final Set<Integer> acp;
   private class_286 acq;
   private List<String> acr;
   private class_286 acs;
   private String act;
   private String acu;
   private String acv;
   private List<ko> acw;
   private int acx;
   private List<ko> acy;
   private class_286 acz;
   private String ada;
   private class_286 adb;
   private String adc;
   private String add;
   private String ade;
   private class_286 adf;
   private String adg;
   private String adh;
   private String adi;
   private String adj;
   private String mName;
   // $FF: renamed from: mi java.lang.String
   private String field_980;
   // $FF: renamed from: qU java.lang.String
   private String field_981;
   // $FF: renamed from: qV java.lang.String
   private String field_982;
   // $FF: renamed from: xD java.lang.String
   private String field_983;
   // $FF: renamed from: xJ int
   private final int field_984;

   static {
      aco.put("about", class_285.class_944.method_3204("about", 2, ko.class));
      aco.put("additionalName", class_285.class_944.method_3211("additionalName", 3));
      aco.put("address", class_285.class_944.method_3204("address", 4, ko.class));
      aco.put("addressCountry", class_285.class_944.method_3210("addressCountry", 5));
      aco.put("addressLocality", class_285.class_944.method_3210("addressLocality", 6));
      aco.put("addressRegion", class_285.class_944.method_3210("addressRegion", 7));
      aco.put("associated_media", class_285.class_944.method_3205("associated_media", 8, ko.class));
      aco.put("attendeeCount", class_285.class_944.method_3207("attendeeCount", 9));
      aco.put("attendees", class_285.class_944.method_3205("attendees", 10, ko.class));
      aco.put("audio", class_285.class_944.method_3204("audio", 11, ko.class));
      aco.put("author", class_285.class_944.method_3205("author", 12, ko.class));
      aco.put("bestRating", class_285.class_944.method_3210("bestRating", 13));
      aco.put("birthDate", class_285.class_944.method_3210("birthDate", 14));
      aco.put("byArtist", class_285.class_944.method_3204("byArtist", 15, ko.class));
      aco.put("caption", class_285.class_944.method_3210("caption", 16));
      aco.put("contentSize", class_285.class_944.method_3210("contentSize", 17));
      aco.put("contentUrl", class_285.class_944.method_3210("contentUrl", 18));
      aco.put("contributor", class_285.class_944.method_3205("contributor", 19, ko.class));
      aco.put("dateCreated", class_285.class_944.method_3210("dateCreated", 20));
      aco.put("dateModified", class_285.class_944.method_3210("dateModified", 21));
      aco.put("datePublished", class_285.class_944.method_3210("datePublished", 22));
      aco.put("description", class_285.class_944.method_3210("description", 23));
      aco.put("duration", class_285.class_944.method_3210("duration", 24));
      aco.put("embedUrl", class_285.class_944.method_3210("embedUrl", 25));
      aco.put("endDate", class_285.class_944.method_3210("endDate", 26));
      aco.put("familyName", class_285.class_944.method_3210("familyName", 27));
      aco.put("gender", class_285.class_944.method_3210("gender", 28));
      aco.put("geo", class_285.class_944.method_3204("geo", 29, ko.class));
      aco.put("givenName", class_285.class_944.method_3210("givenName", 30));
      aco.put("height", class_285.class_944.method_3210("height", 31));
      aco.put("id", class_285.class_944.method_3210("id", 32));
      aco.put("image", class_285.class_944.method_3210("image", 33));
      aco.put("inAlbum", class_285.class_944.method_3204("inAlbum", 34, ko.class));
      aco.put("latitude", class_285.class_944.method_3208("latitude", 36));
      aco.put("location", class_285.class_944.method_3204("location", 37, ko.class));
      aco.put("longitude", class_285.class_944.method_3208("longitude", 38));
      aco.put("name", class_285.class_944.method_3210("name", 39));
      aco.put("partOfTVSeries", class_285.class_944.method_3204("partOfTVSeries", 40, ko.class));
      aco.put("performers", class_285.class_944.method_3205("performers", 41, ko.class));
      aco.put("playerType", class_285.class_944.method_3210("playerType", 42));
      aco.put("postOfficeBoxNumber", class_285.class_944.method_3210("postOfficeBoxNumber", 43));
      aco.put("postalCode", class_285.class_944.method_3210("postalCode", 44));
      aco.put("ratingValue", class_285.class_944.method_3210("ratingValue", 45));
      aco.put("reviewRating", class_285.class_944.method_3204("reviewRating", 46, ko.class));
      aco.put("startDate", class_285.class_944.method_3210("startDate", 47));
      aco.put("streetAddress", class_285.class_944.method_3210("streetAddress", 48));
      aco.put("text", class_285.class_944.method_3210("text", 49));
      aco.put("thumbnail", class_285.class_944.method_3204("thumbnail", 50, ko.class));
      aco.put("thumbnailUrl", class_285.class_944.method_3210("thumbnailUrl", 51));
      aco.put("tickerSymbol", class_285.class_944.method_3210("tickerSymbol", 52));
      aco.put("type", class_285.class_944.method_3210("type", 53));
      aco.put("url", class_285.class_944.method_3210("url", 54));
      aco.put("width", class_285.class_944.method_3210("width", 55));
      aco.put("worstRating", class_285.class_944.method_3210("worstRating", 56));
   }

   public class_286() {
      this.field_984 = 1;
      this.acp = new HashSet();
   }

   class_286(Set<Integer> var1, int var2, ko var3, List<String> var4, ko var5, String var6, String var7, String var8, List<ko> var9, int var10, List<ko> var11, ko var12, List<ko> var13, String var14, String var15, ko var16, String var17, String var18, String var19, List<ko> var20, String var21, String var22, String var23, String var24, String var25, String var26, String var27, String var28, String var29, ko var30, String var31, String var32, String var33, String var34, ko var35, double var36, ko var38, double var39, String var41, ko var42, List<ko> var43, String var44, String var45, String var46, String var47, ko var48, String var49, String var50, String var51, ko var52, String var53, String var54, String var55, String var56, String var57, String var58) {
      this.acp = var1;
      this.field_984 = var2;
      this.acq = var3;
      this.acr = var4;
      this.acs = var5;
      this.act = var6;
      this.acu = var7;
      this.acv = var8;
      this.acw = var9;
      this.acx = var10;
      this.acy = var11;
      this.acz = var12;
      this.acA = var13;
      this.acB = var14;
      this.acC = var15;
      this.acD = var16;
      this.acE = var17;
      this.acF = var18;
      this.field_980 = var19;
      this.acG = var20;
      this.acH = var21;
      this.acI = var22;
      this.acJ = var23;
      this.field_977 = var24;
      this.acK = var25;
      this.acL = var26;
      this.acM = var27;
      this.acN = var28;
      this.acO = var29;
      this.acP = var30;
      this.acQ = var31;
      this.acR = var32;
      this.field_983 = var33;
      this.acS = var34;
      this.acT = var35;
      this.field_978 = var36;
      this.acU = var38;
      this.field_979 = var39;
      this.mName = var41;
      this.acV = var42;
      this.acW = var43;
      this.acX = var44;
      this.acY = var45;
      this.acZ = var46;
      this.ada = var47;
      this.adb = var48;
      this.adc = var49;
      this.add = var50;
      this.ade = var51;
      this.adf = var52;
      this.adg = var53;
      this.adh = var54;
      this.field_981 = var55;
      this.field_982 = var56;
      this.adi = var57;
      this.adj = var58;
   }

   public class_286(Set<Integer> var1, ko var2, List<String> var3, ko var4, String var5, String var6, String var7, List<ko> var8, int var9, List<ko> var10, ko var11, List<ko> var12, String var13, String var14, ko var15, String var16, String var17, String var18, List<ko> var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, String var27, String var28, ko var29, String var30, String var31, String var32, String var33, ko var34, double var35, ko var37, double var38, String var40, ko var41, List<ko> var42, String var43, String var44, String var45, String var46, ko var47, String var48, String var49, String var50, ko var51, String var52, String var53, String var54, String var55, String var56, String var57) {
      this.acp = var1;
      this.field_984 = 1;
      this.acq = var2;
      this.acr = var3;
      this.acs = var4;
      this.act = var5;
      this.acu = var6;
      this.acv = var7;
      this.acw = var8;
      this.acx = var9;
      this.acy = var10;
      this.acz = var11;
      this.acA = var12;
      this.acB = var13;
      this.acC = var14;
      this.acD = var15;
      this.acE = var16;
      this.acF = var17;
      this.field_980 = var18;
      this.acG = var19;
      this.acH = var20;
      this.acI = var21;
      this.acJ = var22;
      this.field_977 = var23;
      this.acK = var24;
      this.acL = var25;
      this.acM = var26;
      this.acN = var27;
      this.acO = var28;
      this.acP = var29;
      this.acQ = var30;
      this.acR = var31;
      this.field_983 = var32;
      this.acS = var33;
      this.acT = var34;
      this.field_978 = var35;
      this.acU = var37;
      this.field_979 = var38;
      this.mName = var40;
      this.acV = var41;
      this.acW = var42;
      this.acX = var43;
      this.acY = var44;
      this.acZ = var45;
      this.ada = var46;
      this.adb = var47;
      this.adc = var48;
      this.add = var49;
      this.ade = var50;
      this.adf = var51;
      this.adg = var52;
      this.adh = var53;
      this.field_981 = var54;
      this.field_982 = var55;
      this.adi = var56;
      this.adj = var57;
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
         return this.acq;
      case 3:
         return this.acr;
      case 4:
         return this.acs;
      case 5:
         return this.act;
      case 6:
         return this.acu;
      case 7:
         return this.acv;
      case 8:
         return this.acw;
      case 9:
         return Integer.valueOf(this.acx);
      case 10:
         return this.acy;
      case 11:
         return this.acz;
      case 12:
         return this.acA;
      case 13:
         return this.acB;
      case 14:
         return this.acC;
      case 15:
         return this.acD;
      case 16:
         return this.acE;
      case 17:
         return this.acF;
      case 18:
         return this.field_980;
      case 19:
         return this.acG;
      case 20:
         return this.acH;
      case 21:
         return this.acI;
      case 22:
         return this.acJ;
      case 23:
         return this.field_977;
      case 24:
         return this.acK;
      case 25:
         return this.acL;
      case 26:
         return this.acM;
      case 27:
         return this.acN;
      case 28:
         return this.acO;
      case 29:
         return this.acP;
      case 30:
         return this.acQ;
      case 31:
         return this.acR;
      case 32:
         return this.field_983;
      case 33:
         return this.acS;
      case 34:
         return this.acT;
      case 35:
      default:
         throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3218());
      case 36:
         return Double.valueOf(this.field_978);
      case 37:
         return this.acU;
      case 38:
         return Double.valueOf(this.field_979);
      case 39:
         return this.mName;
      case 40:
         return this.acV;
      case 41:
         return this.acW;
      case 42:
         return this.acX;
      case 43:
         return this.acY;
      case 44:
         return this.acZ;
      case 45:
         return this.ada;
      case 46:
         return this.adb;
      case 47:
         return this.adc;
      case 48:
         return this.add;
      case 49:
         return this.ade;
      case 50:
         return this.adf;
      case 51:
         return this.adg;
      case 52:
         return this.adh;
      case 53:
         return this.field_981;
      case 54:
         return this.field_982;
      case 55:
         return this.adi;
      case 56:
         return this.adj;
      }
   }

   public int describeContents() {
      class_625 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class_286)) {
         return false;
      } else if(this == var1) {
         return true;
      } else {
         class_286 var2 = (class_286)var1;
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
      return this.method_1926();
   }

   public ItemScope getAbout() {
      return this.acq;
   }

   public List<String> getAdditionalName() {
      return this.acr;
   }

   public ItemScope getAddress() {
      return this.acs;
   }

   public String getAddressCountry() {
      return this.act;
   }

   public String getAddressLocality() {
      return this.acu;
   }

   public String getAddressRegion() {
      return this.acv;
   }

   public List<ItemScope> getAssociated_media() {
      return (ArrayList)this.acw;
   }

   public int getAttendeeCount() {
      return this.acx;
   }

   public List<ItemScope> getAttendees() {
      return (ArrayList)this.acy;
   }

   public ItemScope getAudio() {
      return this.acz;
   }

   public List<ItemScope> getAuthor() {
      return (ArrayList)this.acA;
   }

   public String getBestRating() {
      return this.acB;
   }

   public String getBirthDate() {
      return this.acC;
   }

   public ItemScope getByArtist() {
      return this.acD;
   }

   public String getCaption() {
      return this.acE;
   }

   public String getContentSize() {
      return this.acF;
   }

   public String getContentUrl() {
      return this.field_980;
   }

   public List<ItemScope> getContributor() {
      return (ArrayList)this.acG;
   }

   public String getDateCreated() {
      return this.acH;
   }

   public String getDateModified() {
      return this.acI;
   }

   public String getDatePublished() {
      return this.acJ;
   }

   public String getDescription() {
      return this.field_977;
   }

   public String getDuration() {
      return this.acK;
   }

   public String getEmbedUrl() {
      return this.acL;
   }

   public String getEndDate() {
      return this.acM;
   }

   public String getFamilyName() {
      return this.acN;
   }

   public String getGender() {
      return this.acO;
   }

   public ItemScope getGeo() {
      return this.acP;
   }

   public String getGivenName() {
      return this.acQ;
   }

   public String getHeight() {
      return this.acR;
   }

   public String getId() {
      return this.field_983;
   }

   public String getImage() {
      return this.acS;
   }

   public ItemScope getInAlbum() {
      return this.acT;
   }

   public double getLatitude() {
      return this.field_978;
   }

   public ItemScope getLocation() {
      return this.acU;
   }

   public double getLongitude() {
      return this.field_979;
   }

   public String getName() {
      return this.mName;
   }

   public ItemScope getPartOfTVSeries() {
      return this.acV;
   }

   public List<ItemScope> getPerformers() {
      return (ArrayList)this.acW;
   }

   public String getPlayerType() {
      return this.acX;
   }

   public String getPostOfficeBoxNumber() {
      return this.acY;
   }

   public String getPostalCode() {
      return this.acZ;
   }

   public String getRatingValue() {
      return this.ada;
   }

   public ItemScope getReviewRating() {
      return this.adb;
   }

   public String getStartDate() {
      return this.adc;
   }

   public String getStreetAddress() {
      return this.add;
   }

   public String getText() {
      return this.ade;
   }

   public ItemScope getThumbnail() {
      return this.adf;
   }

   public String getThumbnailUrl() {
      return this.adg;
   }

   public String getTickerSymbol() {
      return this.adh;
   }

   public String getType() {
      return this.field_981;
   }

   public String getUrl() {
      return this.field_982;
   }

   int getVersionCode() {
      return this.field_984;
   }

   public String getWidth() {
      return this.adi;
   }

   public String getWorstRating() {
      return this.adj;
   }

   public boolean hasAbout() {
      return this.acp.contains(Integer.valueOf(2));
   }

   public boolean hasAdditionalName() {
      return this.acp.contains(Integer.valueOf(3));
   }

   public boolean hasAddress() {
      return this.acp.contains(Integer.valueOf(4));
   }

   public boolean hasAddressCountry() {
      return this.acp.contains(Integer.valueOf(5));
   }

   public boolean hasAddressLocality() {
      return this.acp.contains(Integer.valueOf(6));
   }

   public boolean hasAddressRegion() {
      return this.acp.contains(Integer.valueOf(7));
   }

   public boolean hasAssociated_media() {
      return this.acp.contains(Integer.valueOf(8));
   }

   public boolean hasAttendeeCount() {
      return this.acp.contains(Integer.valueOf(9));
   }

   public boolean hasAttendees() {
      return this.acp.contains(Integer.valueOf(10));
   }

   public boolean hasAudio() {
      return this.acp.contains(Integer.valueOf(11));
   }

   public boolean hasAuthor() {
      return this.acp.contains(Integer.valueOf(12));
   }

   public boolean hasBestRating() {
      return this.acp.contains(Integer.valueOf(13));
   }

   public boolean hasBirthDate() {
      return this.acp.contains(Integer.valueOf(14));
   }

   public boolean hasByArtist() {
      return this.acp.contains(Integer.valueOf(15));
   }

   public boolean hasCaption() {
      return this.acp.contains(Integer.valueOf(16));
   }

   public boolean hasContentSize() {
      return this.acp.contains(Integer.valueOf(17));
   }

   public boolean hasContentUrl() {
      return this.acp.contains(Integer.valueOf(18));
   }

   public boolean hasContributor() {
      return this.acp.contains(Integer.valueOf(19));
   }

   public boolean hasDateCreated() {
      return this.acp.contains(Integer.valueOf(20));
   }

   public boolean hasDateModified() {
      return this.acp.contains(Integer.valueOf(21));
   }

   public boolean hasDatePublished() {
      return this.acp.contains(Integer.valueOf(22));
   }

   public boolean hasDescription() {
      return this.acp.contains(Integer.valueOf(23));
   }

   public boolean hasDuration() {
      return this.acp.contains(Integer.valueOf(24));
   }

   public boolean hasEmbedUrl() {
      return this.acp.contains(Integer.valueOf(25));
   }

   public boolean hasEndDate() {
      return this.acp.contains(Integer.valueOf(26));
   }

   public boolean hasFamilyName() {
      return this.acp.contains(Integer.valueOf(27));
   }

   public boolean hasGender() {
      return this.acp.contains(Integer.valueOf(28));
   }

   public boolean hasGeo() {
      return this.acp.contains(Integer.valueOf(29));
   }

   public boolean hasGivenName() {
      return this.acp.contains(Integer.valueOf(30));
   }

   public boolean hasHeight() {
      return this.acp.contains(Integer.valueOf(31));
   }

   public boolean hasId() {
      return this.acp.contains(Integer.valueOf(32));
   }

   public boolean hasImage() {
      return this.acp.contains(Integer.valueOf(33));
   }

   public boolean hasInAlbum() {
      return this.acp.contains(Integer.valueOf(34));
   }

   public boolean hasLatitude() {
      return this.acp.contains(Integer.valueOf(36));
   }

   public boolean hasLocation() {
      return this.acp.contains(Integer.valueOf(37));
   }

   public boolean hasLongitude() {
      return this.acp.contains(Integer.valueOf(38));
   }

   public boolean hasName() {
      return this.acp.contains(Integer.valueOf(39));
   }

   public boolean hasPartOfTVSeries() {
      return this.acp.contains(Integer.valueOf(40));
   }

   public boolean hasPerformers() {
      return this.acp.contains(Integer.valueOf(41));
   }

   public boolean hasPlayerType() {
      return this.acp.contains(Integer.valueOf(42));
   }

   public boolean hasPostOfficeBoxNumber() {
      return this.acp.contains(Integer.valueOf(43));
   }

   public boolean hasPostalCode() {
      return this.acp.contains(Integer.valueOf(44));
   }

   public boolean hasRatingValue() {
      return this.acp.contains(Integer.valueOf(45));
   }

   public boolean hasReviewRating() {
      return this.acp.contains(Integer.valueOf(46));
   }

   public boolean hasStartDate() {
      return this.acp.contains(Integer.valueOf(47));
   }

   public boolean hasStreetAddress() {
      return this.acp.contains(Integer.valueOf(48));
   }

   public boolean hasText() {
      return this.acp.contains(Integer.valueOf(49));
   }

   public boolean hasThumbnail() {
      return this.acp.contains(Integer.valueOf(50));
   }

   public boolean hasThumbnailUrl() {
      return this.acp.contains(Integer.valueOf(51));
   }

   public boolean hasTickerSymbol() {
      return this.acp.contains(Integer.valueOf(52));
   }

   public boolean hasType() {
      return this.acp.contains(Integer.valueOf(53));
   }

   public boolean hasUrl() {
      return this.acp.contains(Integer.valueOf(54));
   }

   public boolean hasWidth() {
      return this.acp.contains(Integer.valueOf(55));
   }

   public boolean hasWorstRating() {
      return this.acp.contains(Integer.valueOf(56));
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

   // $FF: renamed from: kf () java.util.Set
   Set<Integer> method_1910() {
      return this.acp;
   }

   // $FF: renamed from: kg () com.google.android.gms.internal.ko
   class_286 method_1911() {
      return this.acq;
   }

   // $FF: renamed from: kh () com.google.android.gms.internal.ko
   class_286 method_1912() {
      return this.acs;
   }

   // $FF: renamed from: ki () java.util.List
   List<ko> method_1913() {
      return this.acw;
   }

   // $FF: renamed from: kj () java.util.List
   List<ko> method_1914() {
      return this.acy;
   }

   // $FF: renamed from: kk () com.google.android.gms.internal.ko
   class_286 method_1915() {
      return this.acz;
   }

   // $FF: renamed from: kl () java.util.List
   List<ko> method_1916() {
      return this.acA;
   }

   // $FF: renamed from: km () com.google.android.gms.internal.ko
   class_286 method_1917() {
      return this.acD;
   }

   // $FF: renamed from: kn () java.util.List
   List<ko> method_1918() {
      return this.acG;
   }

   // $FF: renamed from: ko () com.google.android.gms.internal.ko
   class_286 method_1919() {
      return this.acP;
   }

   // $FF: renamed from: kp () com.google.android.gms.internal.ko
   class_286 method_1920() {
      return this.acT;
   }

   // $FF: renamed from: kq () com.google.android.gms.internal.ko
   class_286 method_1921() {
      return this.acU;
   }

   // $FF: renamed from: kr () com.google.android.gms.internal.ko
   class_286 method_1922() {
      return this.acV;
   }

   // $FF: renamed from: ks () java.util.List
   List<ko> method_1923() {
      return this.acW;
   }

   // $FF: renamed from: kt () com.google.android.gms.internal.ko
   class_286 method_1924() {
      return this.adb;
   }

   // $FF: renamed from: ku () com.google.android.gms.internal.ko
   class_286 method_1925() {
      return this.adf;
   }

   // $FF: renamed from: kv () com.google.android.gms.internal.ko
   public class_286 method_1926() {
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_625 var10000 = CREATOR;
      class_625.method_3623(this, var1, var2);
   }
}
