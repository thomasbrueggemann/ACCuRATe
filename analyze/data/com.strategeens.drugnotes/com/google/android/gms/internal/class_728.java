package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.internal.class_726;
import com.google.android.gms.internal.class_727;
import com.google.android.gms.internal.class_806;
import com.google.android.gms.internal.pd;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.pd
public final class class_728 extends class_727 implements ItemScope {
   public static final class_806 CREATOR = new class_806();
   private static final HashMap<String, class_726.class_1680<?, ?>> aom = new HashMap();
   // $FF: renamed from: CE java.lang.String
   String field_3352;
   // $FF: renamed from: CK int
   final int field_3353;
   // $FF: renamed from: UO java.lang.String
   String field_3354;
   double agg;
   double agh;
   String aoA;
   class_728 aoB;
   String aoC;
   String aoD;
   List<pd> aoE;
   String aoF;
   String aoG;
   String aoH;
   String aoI;
   String aoJ;
   String aoK;
   String aoL;
   String aoM;
   class_728 aoN;
   String aoO;
   String aoP;
   String aoQ;
   class_728 aoR;
   class_728 aoS;
   class_728 aoT;
   List<pd> aoU;
   String aoV;
   String aoW;
   String aoX;
   String aoY;
   class_728 aoZ;
   final Set<Integer> aon;
   class_728 aoo;
   List<String> aop;
   class_728 aoq;
   String aor;
   String aos;
   String aot;
   List<pd> aou;
   int aov;
   List<pd> aow;
   class_728 aox;
   List<pd> aoy;
   String aoz;
   String apa;
   String apb;
   String apc;
   class_728 apd;
   String ape;
   String apf;
   String apg;
   String aph;
   String mName;
   // $FF: renamed from: ov java.lang.String
   String field_3355;
   // $FF: renamed from: vc java.lang.String
   String field_3356;
   // $FF: renamed from: vf java.lang.String
   String field_3357;

   static {
      aom.put("about", class_726.class_1680.method_5310("about", 2, pd.class));
      aom.put("additionalName", class_726.class_1680.method_5317("additionalName", 3));
      aom.put("address", class_726.class_1680.method_5310("address", 4, pd.class));
      aom.put("addressCountry", class_726.class_1680.method_5316("addressCountry", 5));
      aom.put("addressLocality", class_726.class_1680.method_5316("addressLocality", 6));
      aom.put("addressRegion", class_726.class_1680.method_5316("addressRegion", 7));
      aom.put("associated_media", class_726.class_1680.method_5311("associated_media", 8, pd.class));
      aom.put("attendeeCount", class_726.class_1680.method_5313("attendeeCount", 9));
      aom.put("attendees", class_726.class_1680.method_5311("attendees", 10, pd.class));
      aom.put("audio", class_726.class_1680.method_5310("audio", 11, pd.class));
      aom.put("author", class_726.class_1680.method_5311("author", 12, pd.class));
      aom.put("bestRating", class_726.class_1680.method_5316("bestRating", 13));
      aom.put("birthDate", class_726.class_1680.method_5316("birthDate", 14));
      aom.put("byArtist", class_726.class_1680.method_5310("byArtist", 15, pd.class));
      aom.put("caption", class_726.class_1680.method_5316("caption", 16));
      aom.put("contentSize", class_726.class_1680.method_5316("contentSize", 17));
      aom.put("contentUrl", class_726.class_1680.method_5316("contentUrl", 18));
      aom.put("contributor", class_726.class_1680.method_5311("contributor", 19, pd.class));
      aom.put("dateCreated", class_726.class_1680.method_5316("dateCreated", 20));
      aom.put("dateModified", class_726.class_1680.method_5316("dateModified", 21));
      aom.put("datePublished", class_726.class_1680.method_5316("datePublished", 22));
      aom.put("description", class_726.class_1680.method_5316("description", 23));
      aom.put("duration", class_726.class_1680.method_5316("duration", 24));
      aom.put("embedUrl", class_726.class_1680.method_5316("embedUrl", 25));
      aom.put("endDate", class_726.class_1680.method_5316("endDate", 26));
      aom.put("familyName", class_726.class_1680.method_5316("familyName", 27));
      aom.put("gender", class_726.class_1680.method_5316("gender", 28));
      aom.put("geo", class_726.class_1680.method_5310("geo", 29, pd.class));
      aom.put("givenName", class_726.class_1680.method_5316("givenName", 30));
      aom.put("height", class_726.class_1680.method_5316("height", 31));
      aom.put("id", class_726.class_1680.method_5316("id", 32));
      aom.put("image", class_726.class_1680.method_5316("image", 33));
      aom.put("inAlbum", class_726.class_1680.method_5310("inAlbum", 34, pd.class));
      aom.put("latitude", class_726.class_1680.method_5314("latitude", 36));
      aom.put("location", class_726.class_1680.method_5310("location", 37, pd.class));
      aom.put("longitude", class_726.class_1680.method_5314("longitude", 38));
      aom.put("name", class_726.class_1680.method_5316("name", 39));
      aom.put("partOfTVSeries", class_726.class_1680.method_5310("partOfTVSeries", 40, pd.class));
      aom.put("performers", class_726.class_1680.method_5311("performers", 41, pd.class));
      aom.put("playerType", class_726.class_1680.method_5316("playerType", 42));
      aom.put("postOfficeBoxNumber", class_726.class_1680.method_5316("postOfficeBoxNumber", 43));
      aom.put("postalCode", class_726.class_1680.method_5316("postalCode", 44));
      aom.put("ratingValue", class_726.class_1680.method_5316("ratingValue", 45));
      aom.put("reviewRating", class_726.class_1680.method_5310("reviewRating", 46, pd.class));
      aom.put("startDate", class_726.class_1680.method_5316("startDate", 47));
      aom.put("streetAddress", class_726.class_1680.method_5316("streetAddress", 48));
      aom.put("text", class_726.class_1680.method_5316("text", 49));
      aom.put("thumbnail", class_726.class_1680.method_5310("thumbnail", 50, pd.class));
      aom.put("thumbnailUrl", class_726.class_1680.method_5316("thumbnailUrl", 51));
      aom.put("tickerSymbol", class_726.class_1680.method_5316("tickerSymbol", 52));
      aom.put("type", class_726.class_1680.method_5316("type", 53));
      aom.put("url", class_726.class_1680.method_5316("url", 54));
      aom.put("width", class_726.class_1680.method_5316("width", 55));
      aom.put("worstRating", class_726.class_1680.method_5316("worstRating", 56));
   }

   public class_728() {
      this.field_3353 = 1;
      this.aon = new HashSet();
   }

   class_728(Set<Integer> var1, int var2, pd var3, List<String> var4, pd var5, String var6, String var7, String var8, List<pd> var9, int var10, List<pd> var11, pd var12, List<pd> var13, String var14, String var15, pd var16, String var17, String var18, String var19, List<pd> var20, String var21, String var22, String var23, String var24, String var25, String var26, String var27, String var28, String var29, pd var30, String var31, String var32, String var33, String var34, pd var35, double var36, pd var38, double var39, String var41, pd var42, List<pd> var43, String var44, String var45, String var46, String var47, pd var48, String var49, String var50, String var51, pd var52, String var53, String var54, String var55, String var56, String var57, String var58) {
      this.aon = var1;
      this.field_3353 = var2;
      this.aoo = var3;
      this.aop = var4;
      this.aoq = var5;
      this.aor = var6;
      this.aos = var7;
      this.aot = var8;
      this.aou = var9;
      this.aov = var10;
      this.aow = var11;
      this.aox = var12;
      this.aoy = var13;
      this.aoz = var14;
      this.aoA = var15;
      this.aoB = var16;
      this.aoC = var17;
      this.aoD = var18;
      this.field_3355 = var19;
      this.aoE = var20;
      this.aoF = var21;
      this.aoG = var22;
      this.aoH = var23;
      this.field_3354 = var24;
      this.aoI = var25;
      this.aoJ = var26;
      this.aoK = var27;
      this.aoL = var28;
      this.aoM = var29;
      this.aoN = var30;
      this.aoO = var31;
      this.aoP = var32;
      this.field_3352 = var33;
      this.aoQ = var34;
      this.aoR = var35;
      this.agg = var36;
      this.aoS = var38;
      this.agh = var39;
      this.mName = var41;
      this.aoT = var42;
      this.aoU = var43;
      this.aoV = var44;
      this.aoW = var45;
      this.aoX = var46;
      this.aoY = var47;
      this.aoZ = var48;
      this.apa = var49;
      this.apb = var50;
      this.apc = var51;
      this.apd = var52;
      this.ape = var53;
      this.apf = var54;
      this.field_3356 = var55;
      this.field_3357 = var56;
      this.apg = var57;
      this.aph = var58;
   }

   public class_728(Set<Integer> var1, pd var2, List<String> var3, pd var4, String var5, String var6, String var7, List<pd> var8, int var9, List<pd> var10, pd var11, List<pd> var12, String var13, String var14, pd var15, String var16, String var17, String var18, List<pd> var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, String var27, String var28, pd var29, String var30, String var31, String var32, String var33, pd var34, double var35, pd var37, double var38, String var40, pd var41, List<pd> var42, String var43, String var44, String var45, String var46, pd var47, String var48, String var49, String var50, pd var51, String var52, String var53, String var54, String var55, String var56, String var57) {
      this.aon = var1;
      this.field_3353 = 1;
      this.aoo = var2;
      this.aop = var3;
      this.aoq = var4;
      this.aor = var5;
      this.aos = var6;
      this.aot = var7;
      this.aou = var8;
      this.aov = var9;
      this.aow = var10;
      this.aox = var11;
      this.aoy = var12;
      this.aoz = var13;
      this.aoA = var14;
      this.aoB = var15;
      this.aoC = var16;
      this.aoD = var17;
      this.field_3355 = var18;
      this.aoE = var19;
      this.aoF = var20;
      this.aoG = var21;
      this.aoH = var22;
      this.field_3354 = var23;
      this.aoI = var24;
      this.aoJ = var25;
      this.aoK = var26;
      this.aoL = var27;
      this.aoM = var28;
      this.aoN = var29;
      this.aoO = var30;
      this.aoP = var31;
      this.field_3352 = var32;
      this.aoQ = var33;
      this.aoR = var34;
      this.agg = var35;
      this.aoS = var37;
      this.agh = var38;
      this.mName = var40;
      this.aoT = var41;
      this.aoU = var42;
      this.aoV = var43;
      this.aoW = var44;
      this.aoX = var45;
      this.aoY = var46;
      this.aoZ = var47;
      this.apa = var48;
      this.apb = var49;
      this.apc = var50;
      this.apd = var51;
      this.ape = var52;
      this.apf = var53;
      this.field_3356 = var54;
      this.field_3357 = var55;
      this.apg = var56;
      this.aph = var57;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.kr$a) boolean
   protected boolean method_4224(class_726.class_1680 var1) {
      return this.aon.contains(Integer.valueOf(var1.method_5325()));
   }

   // $FF: renamed from: b (com.google.android.gms.internal.kr$a) java.lang.Object
   protected Object method_4225(class_726.class_1680 var1) {
      switch(var1.method_5325()) {
      case 2:
         return this.aoo;
      case 3:
         return this.aop;
      case 4:
         return this.aoq;
      case 5:
         return this.aor;
      case 6:
         return this.aos;
      case 7:
         return this.aot;
      case 8:
         return this.aou;
      case 9:
         return Integer.valueOf(this.aov);
      case 10:
         return this.aow;
      case 11:
         return this.aox;
      case 12:
         return this.aoy;
      case 13:
         return this.aoz;
      case 14:
         return this.aoA;
      case 15:
         return this.aoB;
      case 16:
         return this.aoC;
      case 17:
         return this.aoD;
      case 18:
         return this.field_3355;
      case 19:
         return this.aoE;
      case 20:
         return this.aoF;
      case 21:
         return this.aoG;
      case 22:
         return this.aoH;
      case 23:
         return this.field_3354;
      case 24:
         return this.aoI;
      case 25:
         return this.aoJ;
      case 26:
         return this.aoK;
      case 27:
         return this.aoL;
      case 28:
         return this.aoM;
      case 29:
         return this.aoN;
      case 30:
         return this.aoO;
      case 31:
         return this.aoP;
      case 32:
         return this.field_3352;
      case 33:
         return this.aoQ;
      case 34:
         return this.aoR;
      case 35:
      default:
         throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_5325());
      case 36:
         return Double.valueOf(this.agg);
      case 37:
         return this.aoS;
      case 38:
         return Double.valueOf(this.agh);
      case 39:
         return this.mName;
      case 40:
         return this.aoT;
      case 41:
         return this.aoU;
      case 42:
         return this.aoV;
      case 43:
         return this.aoW;
      case 44:
         return this.aoX;
      case 45:
         return this.aoY;
      case 46:
         return this.aoZ;
      case 47:
         return this.apa;
      case 48:
         return this.apb;
      case 49:
         return this.apc;
      case 50:
         return this.apd;
      case 51:
         return this.ape;
      case 52:
         return this.apf;
      case 53:
         return this.field_3356;
      case 54:
         return this.field_3357;
      case 55:
         return this.apg;
      case 56:
         return this.aph;
      }
   }

   public int describeContents() {
      class_806 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class_728)) {
         return false;
      } else if(this == var1) {
         return true;
      } else {
         class_728 var2 = (class_728)var1;
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
      return this.method_4243();
   }

   public ItemScope getAbout() {
      return this.aoo;
   }

   public List<String> getAdditionalName() {
      return this.aop;
   }

   public ItemScope getAddress() {
      return this.aoq;
   }

   public String getAddressCountry() {
      return this.aor;
   }

   public String getAddressLocality() {
      return this.aos;
   }

   public String getAddressRegion() {
      return this.aot;
   }

   public List<ItemScope> getAssociated_media() {
      return (ArrayList)this.aou;
   }

   public int getAttendeeCount() {
      return this.aov;
   }

   public List<ItemScope> getAttendees() {
      return (ArrayList)this.aow;
   }

   public ItemScope getAudio() {
      return this.aox;
   }

   public List<ItemScope> getAuthor() {
      return (ArrayList)this.aoy;
   }

   public String getBestRating() {
      return this.aoz;
   }

   public String getBirthDate() {
      return this.aoA;
   }

   public ItemScope getByArtist() {
      return this.aoB;
   }

   public String getCaption() {
      return this.aoC;
   }

   public String getContentSize() {
      return this.aoD;
   }

   public String getContentUrl() {
      return this.field_3355;
   }

   public List<ItemScope> getContributor() {
      return (ArrayList)this.aoE;
   }

   public String getDateCreated() {
      return this.aoF;
   }

   public String getDateModified() {
      return this.aoG;
   }

   public String getDatePublished() {
      return this.aoH;
   }

   public String getDescription() {
      return this.field_3354;
   }

   public String getDuration() {
      return this.aoI;
   }

   public String getEmbedUrl() {
      return this.aoJ;
   }

   public String getEndDate() {
      return this.aoK;
   }

   public String getFamilyName() {
      return this.aoL;
   }

   public String getGender() {
      return this.aoM;
   }

   public ItemScope getGeo() {
      return this.aoN;
   }

   public String getGivenName() {
      return this.aoO;
   }

   public String getHeight() {
      return this.aoP;
   }

   public String getId() {
      return this.field_3352;
   }

   public String getImage() {
      return this.aoQ;
   }

   public ItemScope getInAlbum() {
      return this.aoR;
   }

   public double getLatitude() {
      return this.agg;
   }

   public ItemScope getLocation() {
      return this.aoS;
   }

   public double getLongitude() {
      return this.agh;
   }

   public String getName() {
      return this.mName;
   }

   public ItemScope getPartOfTVSeries() {
      return this.aoT;
   }

   public List<ItemScope> getPerformers() {
      return (ArrayList)this.aoU;
   }

   public String getPlayerType() {
      return this.aoV;
   }

   public String getPostOfficeBoxNumber() {
      return this.aoW;
   }

   public String getPostalCode() {
      return this.aoX;
   }

   public String getRatingValue() {
      return this.aoY;
   }

   public ItemScope getReviewRating() {
      return this.aoZ;
   }

   public String getStartDate() {
      return this.apa;
   }

   public String getStreetAddress() {
      return this.apb;
   }

   public String getText() {
      return this.apc;
   }

   public ItemScope getThumbnail() {
      return this.apd;
   }

   public String getThumbnailUrl() {
      return this.ape;
   }

   public String getTickerSymbol() {
      return this.apf;
   }

   public String getType() {
      return this.field_3356;
   }

   public String getUrl() {
      return this.field_3357;
   }

   public String getWidth() {
      return this.apg;
   }

   public String getWorstRating() {
      return this.aph;
   }

   // $FF: renamed from: hK () java.util.HashMap
   public HashMap<String, class_726.class_1680<?, ?>> method_4230() {
      return aom;
   }

   public boolean hasAbout() {
      return this.aon.contains(Integer.valueOf(2));
   }

   public boolean hasAdditionalName() {
      return this.aon.contains(Integer.valueOf(3));
   }

   public boolean hasAddress() {
      return this.aon.contains(Integer.valueOf(4));
   }

   public boolean hasAddressCountry() {
      return this.aon.contains(Integer.valueOf(5));
   }

   public boolean hasAddressLocality() {
      return this.aon.contains(Integer.valueOf(6));
   }

   public boolean hasAddressRegion() {
      return this.aon.contains(Integer.valueOf(7));
   }

   public boolean hasAssociated_media() {
      return this.aon.contains(Integer.valueOf(8));
   }

   public boolean hasAttendeeCount() {
      return this.aon.contains(Integer.valueOf(9));
   }

   public boolean hasAttendees() {
      return this.aon.contains(Integer.valueOf(10));
   }

   public boolean hasAudio() {
      return this.aon.contains(Integer.valueOf(11));
   }

   public boolean hasAuthor() {
      return this.aon.contains(Integer.valueOf(12));
   }

   public boolean hasBestRating() {
      return this.aon.contains(Integer.valueOf(13));
   }

   public boolean hasBirthDate() {
      return this.aon.contains(Integer.valueOf(14));
   }

   public boolean hasByArtist() {
      return this.aon.contains(Integer.valueOf(15));
   }

   public boolean hasCaption() {
      return this.aon.contains(Integer.valueOf(16));
   }

   public boolean hasContentSize() {
      return this.aon.contains(Integer.valueOf(17));
   }

   public boolean hasContentUrl() {
      return this.aon.contains(Integer.valueOf(18));
   }

   public boolean hasContributor() {
      return this.aon.contains(Integer.valueOf(19));
   }

   public boolean hasDateCreated() {
      return this.aon.contains(Integer.valueOf(20));
   }

   public boolean hasDateModified() {
      return this.aon.contains(Integer.valueOf(21));
   }

   public boolean hasDatePublished() {
      return this.aon.contains(Integer.valueOf(22));
   }

   public boolean hasDescription() {
      return this.aon.contains(Integer.valueOf(23));
   }

   public boolean hasDuration() {
      return this.aon.contains(Integer.valueOf(24));
   }

   public boolean hasEmbedUrl() {
      return this.aon.contains(Integer.valueOf(25));
   }

   public boolean hasEndDate() {
      return this.aon.contains(Integer.valueOf(26));
   }

   public boolean hasFamilyName() {
      return this.aon.contains(Integer.valueOf(27));
   }

   public boolean hasGender() {
      return this.aon.contains(Integer.valueOf(28));
   }

   public boolean hasGeo() {
      return this.aon.contains(Integer.valueOf(29));
   }

   public boolean hasGivenName() {
      return this.aon.contains(Integer.valueOf(30));
   }

   public boolean hasHeight() {
      return this.aon.contains(Integer.valueOf(31));
   }

   public boolean hasId() {
      return this.aon.contains(Integer.valueOf(32));
   }

   public boolean hasImage() {
      return this.aon.contains(Integer.valueOf(33));
   }

   public boolean hasInAlbum() {
      return this.aon.contains(Integer.valueOf(34));
   }

   public boolean hasLatitude() {
      return this.aon.contains(Integer.valueOf(36));
   }

   public boolean hasLocation() {
      return this.aon.contains(Integer.valueOf(37));
   }

   public boolean hasLongitude() {
      return this.aon.contains(Integer.valueOf(38));
   }

   public boolean hasName() {
      return this.aon.contains(Integer.valueOf(39));
   }

   public boolean hasPartOfTVSeries() {
      return this.aon.contains(Integer.valueOf(40));
   }

   public boolean hasPerformers() {
      return this.aon.contains(Integer.valueOf(41));
   }

   public boolean hasPlayerType() {
      return this.aon.contains(Integer.valueOf(42));
   }

   public boolean hasPostOfficeBoxNumber() {
      return this.aon.contains(Integer.valueOf(43));
   }

   public boolean hasPostalCode() {
      return this.aon.contains(Integer.valueOf(44));
   }

   public boolean hasRatingValue() {
      return this.aon.contains(Integer.valueOf(45));
   }

   public boolean hasReviewRating() {
      return this.aon.contains(Integer.valueOf(46));
   }

   public boolean hasStartDate() {
      return this.aon.contains(Integer.valueOf(47));
   }

   public boolean hasStreetAddress() {
      return this.aon.contains(Integer.valueOf(48));
   }

   public boolean hasText() {
      return this.aon.contains(Integer.valueOf(49));
   }

   public boolean hasThumbnail() {
      return this.aon.contains(Integer.valueOf(50));
   }

   public boolean hasThumbnailUrl() {
      return this.aon.contains(Integer.valueOf(51));
   }

   public boolean hasTickerSymbol() {
      return this.aon.contains(Integer.valueOf(52));
   }

   public boolean hasType() {
      return this.aon.contains(Integer.valueOf(53));
   }

   public boolean hasUrl() {
      return this.aon.contains(Integer.valueOf(54));
   }

   public boolean hasWidth() {
      return this.aon.contains(Integer.valueOf(55));
   }

   public boolean hasWorstRating() {
      return this.aon.contains(Integer.valueOf(56));
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

   // $FF: renamed from: oI () com.google.android.gms.internal.pd
   public class_728 method_4243() {
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_806 var10000 = CREATOR;
      class_806.method_4452(this, var1, var2);
   }
}
