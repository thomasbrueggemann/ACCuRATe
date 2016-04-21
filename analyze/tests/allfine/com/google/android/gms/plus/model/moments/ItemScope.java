package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.class_271;
import com.google.android.gms.internal.nu;
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
        // $FF: renamed from: BL java.lang.String
        private String field_3060;
        // $FF: renamed from: Tr java.lang.String
        private String field_3061;
        private double aek;
        private double ael;
        private String amA;
        private String amB;
        private class_271 amC;
        private String amD;
        private String amE;
        private String amF;
        private class_271 amG;
        private class_271 amH;
        private class_271 amI;
        private List<nu> amJ;
        private String amK;
        private String amL;
        private String amM;
        private String amN;
        private class_271 amO;
        private String amP;
        private String amQ;
        private String amR;
        private class_271 amS;
        private String amT;
        private String amU;
        private String amV;
        private String amW;
        private final Set<Integer> amc = new HashSet();
        private class_271 amd;
        private List<String> ame;
        private class_271 amf;
        private String amg;
        private String amh;
        private String ami;
        private List<nu> amj;
        private int amk;
        private List<nu> aml;
        private class_271 amm;
        private List<nu> amn;
        private String amo;
        private String amp;
        private class_271 amq;
        private String amr;
        private String ams;
        private List<nu> amt;
        private String amu;
        private String amv;
        private String amw;
        private String amx;
        private String amy;
        private String amz;
        private String mName;
        // $FF: renamed from: ol java.lang.String
        private String field_3062;
        // $FF: renamed from: uO java.lang.String
        private String field_3063;
        // $FF: renamed from: uR java.lang.String
        private String field_3064;

        public ItemScope build() {
            return new class_271(this.amc, this.amd, this.ame, this.amf, this.amg, this.amh, this.ami, this.amj, this.amk, this.aml, this.amm, this.amn, this.amo, this.amp, this.amq, this.amr, this.ams, this.field_3062, this.amt, this.amu, this.amv, this.amw, this.field_3061, this.amx, this.amy, this.amz, this.amA, this.amB, this.amC, this.amD, this.amE, this.field_3060, this.amF, this.amG, this.aek, this.amH, this.ael, this.mName, this.amI, this.amJ, this.amK, this.amL, this.amM, this.amN, this.amO, this.amP, this.amQ, this.amR, this.amS, this.amT, this.amU, this.field_3063, this.field_3064, this.amV, this.amW);
        }

        public ItemScope.Builder setAbout(ItemScope var1) {
            this.amd = (class_271)var1;
            this.amc.add(Integer.valueOf(2));
            return this;
        }

        public ItemScope.Builder setAdditionalName(List<String> var1) {
            this.ame = var1;
            this.amc.add(Integer.valueOf(3));
            return this;
        }

        public ItemScope.Builder setAddress(ItemScope var1) {
            this.amf = (class_271)var1;
            this.amc.add(Integer.valueOf(4));
            return this;
        }

        public ItemScope.Builder setAddressCountry(String var1) {
            this.amg = var1;
            this.amc.add(Integer.valueOf(5));
            return this;
        }

        public ItemScope.Builder setAddressLocality(String var1) {
            this.amh = var1;
            this.amc.add(Integer.valueOf(6));
            return this;
        }

        public ItemScope.Builder setAddressRegion(String var1) {
            this.ami = var1;
            this.amc.add(Integer.valueOf(7));
            return this;
        }

        public ItemScope.Builder setAssociated_media(List<ItemScope> var1) {
            this.amj = var1;
            this.amc.add(Integer.valueOf(8));
            return this;
        }

        public ItemScope.Builder setAttendeeCount(int var1) {
            this.amk = var1;
            this.amc.add(Integer.valueOf(9));
            return this;
        }

        public ItemScope.Builder setAttendees(List<ItemScope> var1) {
            this.aml = var1;
            this.amc.add(Integer.valueOf(10));
            return this;
        }

        public ItemScope.Builder setAudio(ItemScope var1) {
            this.amm = (class_271)var1;
            this.amc.add(Integer.valueOf(11));
            return this;
        }

        public ItemScope.Builder setAuthor(List<ItemScope> var1) {
            this.amn = var1;
            this.amc.add(Integer.valueOf(12));
            return this;
        }

        public ItemScope.Builder setBestRating(String var1) {
            this.amo = var1;
            this.amc.add(Integer.valueOf(13));
            return this;
        }

        public ItemScope.Builder setBirthDate(String var1) {
            this.amp = var1;
            this.amc.add(Integer.valueOf(14));
            return this;
        }

        public ItemScope.Builder setByArtist(ItemScope var1) {
            this.amq = (class_271)var1;
            this.amc.add(Integer.valueOf(15));
            return this;
        }

        public ItemScope.Builder setCaption(String var1) {
            this.amr = var1;
            this.amc.add(Integer.valueOf(16));
            return this;
        }

        public ItemScope.Builder setContentSize(String var1) {
            this.ams = var1;
            this.amc.add(Integer.valueOf(17));
            return this;
        }

        public ItemScope.Builder setContentUrl(String var1) {
            this.field_3062 = var1;
            this.amc.add(Integer.valueOf(18));
            return this;
        }

        public ItemScope.Builder setContributor(List<ItemScope> var1) {
            this.amt = var1;
            this.amc.add(Integer.valueOf(19));
            return this;
        }

        public ItemScope.Builder setDateCreated(String var1) {
            this.amu = var1;
            this.amc.add(Integer.valueOf(20));
            return this;
        }

        public ItemScope.Builder setDateModified(String var1) {
            this.amv = var1;
            this.amc.add(Integer.valueOf(21));
            return this;
        }

        public ItemScope.Builder setDatePublished(String var1) {
            this.amw = var1;
            this.amc.add(Integer.valueOf(22));
            return this;
        }

        public ItemScope.Builder setDescription(String var1) {
            this.field_3061 = var1;
            this.amc.add(Integer.valueOf(23));
            return this;
        }

        public ItemScope.Builder setDuration(String var1) {
            this.amx = var1;
            this.amc.add(Integer.valueOf(24));
            return this;
        }

        public ItemScope.Builder setEmbedUrl(String var1) {
            this.amy = var1;
            this.amc.add(Integer.valueOf(25));
            return this;
        }

        public ItemScope.Builder setEndDate(String var1) {
            this.amz = var1;
            this.amc.add(Integer.valueOf(26));
            return this;
        }

        public ItemScope.Builder setFamilyName(String var1) {
            this.amA = var1;
            this.amc.add(Integer.valueOf(27));
            return this;
        }

        public ItemScope.Builder setGender(String var1) {
            this.amB = var1;
            this.amc.add(Integer.valueOf(28));
            return this;
        }

        public ItemScope.Builder setGeo(ItemScope var1) {
            this.amC = (class_271)var1;
            this.amc.add(Integer.valueOf(29));
            return this;
        }

        public ItemScope.Builder setGivenName(String var1) {
            this.amD = var1;
            this.amc.add(Integer.valueOf(30));
            return this;
        }

        public ItemScope.Builder setHeight(String var1) {
            this.amE = var1;
            this.amc.add(Integer.valueOf(31));
            return this;
        }

        public ItemScope.Builder setId(String var1) {
            this.field_3060 = var1;
            this.amc.add(Integer.valueOf(32));
            return this;
        }

        public ItemScope.Builder setImage(String var1) {
            this.amF = var1;
            this.amc.add(Integer.valueOf(33));
            return this;
        }

        public ItemScope.Builder setInAlbum(ItemScope var1) {
            this.amG = (class_271)var1;
            this.amc.add(Integer.valueOf(34));
            return this;
        }

        public ItemScope.Builder setLatitude(double var1) {
            this.aek = var1;
            this.amc.add(Integer.valueOf(36));
            return this;
        }

        public ItemScope.Builder setLocation(ItemScope var1) {
            this.amH = (class_271)var1;
            this.amc.add(Integer.valueOf(37));
            return this;
        }

        public ItemScope.Builder setLongitude(double var1) {
            this.ael = var1;
            this.amc.add(Integer.valueOf(38));
            return this;
        }

        public ItemScope.Builder setName(String var1) {
            this.mName = var1;
            this.amc.add(Integer.valueOf(39));
            return this;
        }

        public ItemScope.Builder setPartOfTVSeries(ItemScope var1) {
            this.amI = (class_271)var1;
            this.amc.add(Integer.valueOf(40));
            return this;
        }

        public ItemScope.Builder setPerformers(List<ItemScope> var1) {
            this.amJ = var1;
            this.amc.add(Integer.valueOf(41));
            return this;
        }

        public ItemScope.Builder setPlayerType(String var1) {
            this.amK = var1;
            this.amc.add(Integer.valueOf(42));
            return this;
        }

        public ItemScope.Builder setPostOfficeBoxNumber(String var1) {
            this.amL = var1;
            this.amc.add(Integer.valueOf(43));
            return this;
        }

        public ItemScope.Builder setPostalCode(String var1) {
            this.amM = var1;
            this.amc.add(Integer.valueOf(44));
            return this;
        }

        public ItemScope.Builder setRatingValue(String var1) {
            this.amN = var1;
            this.amc.add(Integer.valueOf(45));
            return this;
        }

        public ItemScope.Builder setReviewRating(ItemScope var1) {
            this.amO = (class_271)var1;
            this.amc.add(Integer.valueOf(46));
            return this;
        }

        public ItemScope.Builder setStartDate(String var1) {
            this.amP = var1;
            this.amc.add(Integer.valueOf(47));
            return this;
        }

        public ItemScope.Builder setStreetAddress(String var1) {
            this.amQ = var1;
            this.amc.add(Integer.valueOf(48));
            return this;
        }

        public ItemScope.Builder setText(String var1) {
            this.amR = var1;
            this.amc.add(Integer.valueOf(49));
            return this;
        }

        public ItemScope.Builder setThumbnail(ItemScope var1) {
            this.amS = (class_271)var1;
            this.amc.add(Integer.valueOf(50));
            return this;
        }

        public ItemScope.Builder setThumbnailUrl(String var1) {
            this.amT = var1;
            this.amc.add(Integer.valueOf(51));
            return this;
        }

        public ItemScope.Builder setTickerSymbol(String var1) {
            this.amU = var1;
            this.amc.add(Integer.valueOf(52));
            return this;
        }

        public ItemScope.Builder setType(String var1) {
            this.field_3063 = var1;
            this.amc.add(Integer.valueOf(53));
            return this;
        }

        public ItemScope.Builder setUrl(String var1) {
            this.field_3064 = var1;
            this.amc.add(Integer.valueOf(54));
            return this;
        }

        public ItemScope.Builder setWidth(String var1) {
            this.amV = var1;
            this.amc.add(Integer.valueOf(55));
            return this;
        }

        public ItemScope.Builder setWorstRating(String var1) {
            this.amW = var1;
            this.amc.add(Integer.valueOf(56));
            return this;
        }
    }
}
