package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.class_286;
import com.google.android.gms.internal.ko;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface ItemScope extends Freezable<ItemScope> {
   ItemScope getAbout();

   List<String> getAdditionalName();

   ItemScope getAddress();

   String getAddressCountry();

   String getAddressLocality();

   String getAddressRegion();

   List<ItemScope> getAssociated_media();

   int getAttendeeCount();

   List<ItemScope> getAttendees();

   ItemScope getAudio();

   List<ItemScope> getAuthor();

   String getBestRating();

   String getBirthDate();

   ItemScope getByArtist();

   String getCaption();

   String getContentSize();

   String getContentUrl();

   List<ItemScope> getContributor();

   String getDateCreated();

   String getDateModified();

   String getDatePublished();

   String getDescription();

   String getDuration();

   String getEmbedUrl();

   String getEndDate();

   String getFamilyName();

   String getGender();

   ItemScope getGeo();

   String getGivenName();

   String getHeight();

   String getId();

   String getImage();

   ItemScope getInAlbum();

   double getLatitude();

   ItemScope getLocation();

   double getLongitude();

   String getName();

   ItemScope getPartOfTVSeries();

   List<ItemScope> getPerformers();

   String getPlayerType();

   String getPostOfficeBoxNumber();

   String getPostalCode();

   String getRatingValue();

   ItemScope getReviewRating();

   String getStartDate();

   String getStreetAddress();

   String getText();

   ItemScope getThumbnail();

   String getThumbnailUrl();

   String getTickerSymbol();

   String getType();

   String getUrl();

   String getWidth();

   String getWorstRating();

   boolean hasAbout();

   boolean hasAdditionalName();

   boolean hasAddress();

   boolean hasAddressCountry();

   boolean hasAddressLocality();

   boolean hasAddressRegion();

   boolean hasAssociated_media();

   boolean hasAttendeeCount();

   boolean hasAttendees();

   boolean hasAudio();

   boolean hasAuthor();

   boolean hasBestRating();

   boolean hasBirthDate();

   boolean hasByArtist();

   boolean hasCaption();

   boolean hasContentSize();

   boolean hasContentUrl();

   boolean hasContributor();

   boolean hasDateCreated();

   boolean hasDateModified();

   boolean hasDatePublished();

   boolean hasDescription();

   boolean hasDuration();

   boolean hasEmbedUrl();

   boolean hasEndDate();

   boolean hasFamilyName();

   boolean hasGender();

   boolean hasGeo();

   boolean hasGivenName();

   boolean hasHeight();

   boolean hasId();

   boolean hasImage();

   boolean hasInAlbum();

   boolean hasLatitude();

   boolean hasLocation();

   boolean hasLongitude();

   boolean hasName();

   boolean hasPartOfTVSeries();

   boolean hasPerformers();

   boolean hasPlayerType();

   boolean hasPostOfficeBoxNumber();

   boolean hasPostalCode();

   boolean hasRatingValue();

   boolean hasReviewRating();

   boolean hasStartDate();

   boolean hasStreetAddress();

   boolean hasText();

   boolean hasThumbnail();

   boolean hasThumbnailUrl();

   boolean hasTickerSymbol();

   boolean hasType();

   boolean hasUrl();

   boolean hasWidth();

   boolean hasWorstRating();

   public static class Builder {
      // $FF: renamed from: Mm java.lang.String
      private String field_2807;
      // $FF: renamed from: Va double
      private double field_2808;
      // $FF: renamed from: Vb double
      private double field_2809;
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
      private final Set<Integer> acp = new HashSet();
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
      private String field_2810;
      // $FF: renamed from: qU java.lang.String
      private String field_2811;
      // $FF: renamed from: qV java.lang.String
      private String field_2812;
      // $FF: renamed from: xD java.lang.String
      private String field_2813;

      public ItemScope build() {
         return new class_286(this.acp, this.acq, this.acr, this.acs, this.act, this.acu, this.acv, this.acw, this.acx, this.acy, this.acz, this.acA, this.acB, this.acC, this.acD, this.acE, this.acF, this.field_2810, this.acG, this.acH, this.acI, this.acJ, this.field_2807, this.acK, this.acL, this.acM, this.acN, this.acO, this.acP, this.acQ, this.acR, this.field_2813, this.acS, this.acT, this.field_2808, this.acU, this.field_2809, this.mName, this.acV, this.acW, this.acX, this.acY, this.acZ, this.ada, this.adb, this.adc, this.add, this.ade, this.adf, this.adg, this.adh, this.field_2811, this.field_2812, this.adi, this.adj);
      }

      public ItemScope.Builder setAbout(ItemScope var1) {
         this.acq = (class_286)var1;
         this.acp.add(Integer.valueOf(2));
         return this;
      }

      public ItemScope.Builder setAdditionalName(List<String> var1) {
         this.acr = var1;
         this.acp.add(Integer.valueOf(3));
         return this;
      }

      public ItemScope.Builder setAddress(ItemScope var1) {
         this.acs = (class_286)var1;
         this.acp.add(Integer.valueOf(4));
         return this;
      }

      public ItemScope.Builder setAddressCountry(String var1) {
         this.act = var1;
         this.acp.add(Integer.valueOf(5));
         return this;
      }

      public ItemScope.Builder setAddressLocality(String var1) {
         this.acu = var1;
         this.acp.add(Integer.valueOf(6));
         return this;
      }

      public ItemScope.Builder setAddressRegion(String var1) {
         this.acv = var1;
         this.acp.add(Integer.valueOf(7));
         return this;
      }

      public ItemScope.Builder setAssociated_media(List<ItemScope> var1) {
         this.acw = var1;
         this.acp.add(Integer.valueOf(8));
         return this;
      }

      public ItemScope.Builder setAttendeeCount(int var1) {
         this.acx = var1;
         this.acp.add(Integer.valueOf(9));
         return this;
      }

      public ItemScope.Builder setAttendees(List<ItemScope> var1) {
         this.acy = var1;
         this.acp.add(Integer.valueOf(10));
         return this;
      }

      public ItemScope.Builder setAudio(ItemScope var1) {
         this.acz = (class_286)var1;
         this.acp.add(Integer.valueOf(11));
         return this;
      }

      public ItemScope.Builder setAuthor(List<ItemScope> var1) {
         this.acA = var1;
         this.acp.add(Integer.valueOf(12));
         return this;
      }

      public ItemScope.Builder setBestRating(String var1) {
         this.acB = var1;
         this.acp.add(Integer.valueOf(13));
         return this;
      }

      public ItemScope.Builder setBirthDate(String var1) {
         this.acC = var1;
         this.acp.add(Integer.valueOf(14));
         return this;
      }

      public ItemScope.Builder setByArtist(ItemScope var1) {
         this.acD = (class_286)var1;
         this.acp.add(Integer.valueOf(15));
         return this;
      }

      public ItemScope.Builder setCaption(String var1) {
         this.acE = var1;
         this.acp.add(Integer.valueOf(16));
         return this;
      }

      public ItemScope.Builder setContentSize(String var1) {
         this.acF = var1;
         this.acp.add(Integer.valueOf(17));
         return this;
      }

      public ItemScope.Builder setContentUrl(String var1) {
         this.field_2810 = var1;
         this.acp.add(Integer.valueOf(18));
         return this;
      }

      public ItemScope.Builder setContributor(List<ItemScope> var1) {
         this.acG = var1;
         this.acp.add(Integer.valueOf(19));
         return this;
      }

      public ItemScope.Builder setDateCreated(String var1) {
         this.acH = var1;
         this.acp.add(Integer.valueOf(20));
         return this;
      }

      public ItemScope.Builder setDateModified(String var1) {
         this.acI = var1;
         this.acp.add(Integer.valueOf(21));
         return this;
      }

      public ItemScope.Builder setDatePublished(String var1) {
         this.acJ = var1;
         this.acp.add(Integer.valueOf(22));
         return this;
      }

      public ItemScope.Builder setDescription(String var1) {
         this.field_2807 = var1;
         this.acp.add(Integer.valueOf(23));
         return this;
      }

      public ItemScope.Builder setDuration(String var1) {
         this.acK = var1;
         this.acp.add(Integer.valueOf(24));
         return this;
      }

      public ItemScope.Builder setEmbedUrl(String var1) {
         this.acL = var1;
         this.acp.add(Integer.valueOf(25));
         return this;
      }

      public ItemScope.Builder setEndDate(String var1) {
         this.acM = var1;
         this.acp.add(Integer.valueOf(26));
         return this;
      }

      public ItemScope.Builder setFamilyName(String var1) {
         this.acN = var1;
         this.acp.add(Integer.valueOf(27));
         return this;
      }

      public ItemScope.Builder setGender(String var1) {
         this.acO = var1;
         this.acp.add(Integer.valueOf(28));
         return this;
      }

      public ItemScope.Builder setGeo(ItemScope var1) {
         this.acP = (class_286)var1;
         this.acp.add(Integer.valueOf(29));
         return this;
      }

      public ItemScope.Builder setGivenName(String var1) {
         this.acQ = var1;
         this.acp.add(Integer.valueOf(30));
         return this;
      }

      public ItemScope.Builder setHeight(String var1) {
         this.acR = var1;
         this.acp.add(Integer.valueOf(31));
         return this;
      }

      public ItemScope.Builder setId(String var1) {
         this.field_2813 = var1;
         this.acp.add(Integer.valueOf(32));
         return this;
      }

      public ItemScope.Builder setImage(String var1) {
         this.acS = var1;
         this.acp.add(Integer.valueOf(33));
         return this;
      }

      public ItemScope.Builder setInAlbum(ItemScope var1) {
         this.acT = (class_286)var1;
         this.acp.add(Integer.valueOf(34));
         return this;
      }

      public ItemScope.Builder setLatitude(double var1) {
         this.field_2808 = var1;
         this.acp.add(Integer.valueOf(36));
         return this;
      }

      public ItemScope.Builder setLocation(ItemScope var1) {
         this.acU = (class_286)var1;
         this.acp.add(Integer.valueOf(37));
         return this;
      }

      public ItemScope.Builder setLongitude(double var1) {
         this.field_2809 = var1;
         this.acp.add(Integer.valueOf(38));
         return this;
      }

      public ItemScope.Builder setName(String var1) {
         this.mName = var1;
         this.acp.add(Integer.valueOf(39));
         return this;
      }

      public ItemScope.Builder setPartOfTVSeries(ItemScope var1) {
         this.acV = (class_286)var1;
         this.acp.add(Integer.valueOf(40));
         return this;
      }

      public ItemScope.Builder setPerformers(List<ItemScope> var1) {
         this.acW = var1;
         this.acp.add(Integer.valueOf(41));
         return this;
      }

      public ItemScope.Builder setPlayerType(String var1) {
         this.acX = var1;
         this.acp.add(Integer.valueOf(42));
         return this;
      }

      public ItemScope.Builder setPostOfficeBoxNumber(String var1) {
         this.acY = var1;
         this.acp.add(Integer.valueOf(43));
         return this;
      }

      public ItemScope.Builder setPostalCode(String var1) {
         this.acZ = var1;
         this.acp.add(Integer.valueOf(44));
         return this;
      }

      public ItemScope.Builder setRatingValue(String var1) {
         this.ada = var1;
         this.acp.add(Integer.valueOf(45));
         return this;
      }

      public ItemScope.Builder setReviewRating(ItemScope var1) {
         this.adb = (class_286)var1;
         this.acp.add(Integer.valueOf(46));
         return this;
      }

      public ItemScope.Builder setStartDate(String var1) {
         this.adc = var1;
         this.acp.add(Integer.valueOf(47));
         return this;
      }

      public ItemScope.Builder setStreetAddress(String var1) {
         this.add = var1;
         this.acp.add(Integer.valueOf(48));
         return this;
      }

      public ItemScope.Builder setText(String var1) {
         this.ade = var1;
         this.acp.add(Integer.valueOf(49));
         return this;
      }

      public ItemScope.Builder setThumbnail(ItemScope var1) {
         this.adf = (class_286)var1;
         this.acp.add(Integer.valueOf(50));
         return this;
      }

      public ItemScope.Builder setThumbnailUrl(String var1) {
         this.adg = var1;
         this.acp.add(Integer.valueOf(51));
         return this;
      }

      public ItemScope.Builder setTickerSymbol(String var1) {
         this.adh = var1;
         this.acp.add(Integer.valueOf(52));
         return this;
      }

      public ItemScope.Builder setType(String var1) {
         this.field_2811 = var1;
         this.acp.add(Integer.valueOf(53));
         return this;
      }

      public ItemScope.Builder setUrl(String var1) {
         this.field_2812 = var1;
         this.acp.add(Integer.valueOf(54));
         return this;
      }

      public ItemScope.Builder setWidth(String var1) {
         this.adi = var1;
         this.acp.add(Integer.valueOf(55));
         return this;
      }

      public ItemScope.Builder setWorstRating(String var1) {
         this.adj = var1;
         this.acp.add(Integer.valueOf(56));
         return this;
      }
   }
}
