package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.internal.class_268;
import com.google.android.gms.internal.class_270;
import com.google.android.gms.internal.class_862;
import com.google.android.gms.internal.nu;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.nu
public final class class_271 extends class_270 implements ItemScope {
    public static final class_862 CREATOR = new class_862();
    private static final HashMap<String, class_268.class_1299<?, ?>> amb = new HashMap();
    // $FF: renamed from: BL java.lang.String
    String field_807;
    // $FF: renamed from: BR int
    final int field_808;
    // $FF: renamed from: Tr java.lang.String
    String field_809;
    double aek;
    double ael;
    String amA;
    String amB;
    class_271 amC;
    String amD;
    String amE;
    String amF;
    class_271 amG;
    class_271 amH;
    class_271 amI;
    List<nu> amJ;
    String amK;
    String amL;
    String amM;
    String amN;
    class_271 amO;
    String amP;
    String amQ;
    String amR;
    class_271 amS;
    String amT;
    String amU;
    String amV;
    String amW;
    final Set<Integer> amc;
    class_271 amd;
    List<String> ame;
    class_271 amf;
    String amg;
    String amh;
    String ami;
    List<nu> amj;
    int amk;
    List<nu> aml;
    class_271 amm;
    List<nu> amn;
    String amo;
    String amp;
    class_271 amq;
    String amr;
    String ams;
    List<nu> amt;
    String amu;
    String amv;
    String amw;
    String amx;
    String amy;
    String amz;
    String mName;
    // $FF: renamed from: ol java.lang.String
    String field_810;
    // $FF: renamed from: uO java.lang.String
    String field_811;
    // $FF: renamed from: uR java.lang.String
    String field_812;

    static {
        amb.put("about", class_268.class_1299.method_3867("about", 2, nu.class));
        amb.put("additionalName", class_268.class_1299.method_3874("additionalName", 3));
        amb.put("address", class_268.class_1299.method_3867("address", 4, nu.class));
        amb.put("addressCountry", class_268.class_1299.method_3873("addressCountry", 5));
        amb.put("addressLocality", class_268.class_1299.method_3873("addressLocality", 6));
        amb.put("addressRegion", class_268.class_1299.method_3873("addressRegion", 7));
        amb.put("associated_media", class_268.class_1299.method_3868("associated_media", 8, nu.class));
        amb.put("attendeeCount", class_268.class_1299.method_3870("attendeeCount", 9));
        amb.put("attendees", class_268.class_1299.method_3868("attendees", 10, nu.class));
        amb.put("audio", class_268.class_1299.method_3867("audio", 11, nu.class));
        amb.put("author", class_268.class_1299.method_3868("author", 12, nu.class));
        amb.put("bestRating", class_268.class_1299.method_3873("bestRating", 13));
        amb.put("birthDate", class_268.class_1299.method_3873("birthDate", 14));
        amb.put("byArtist", class_268.class_1299.method_3867("byArtist", 15, nu.class));
        amb.put("caption", class_268.class_1299.method_3873("caption", 16));
        amb.put("contentSize", class_268.class_1299.method_3873("contentSize", 17));
        amb.put("contentUrl", class_268.class_1299.method_3873("contentUrl", 18));
        amb.put("contributor", class_268.class_1299.method_3868("contributor", 19, nu.class));
        amb.put("dateCreated", class_268.class_1299.method_3873("dateCreated", 20));
        amb.put("dateModified", class_268.class_1299.method_3873("dateModified", 21));
        amb.put("datePublished", class_268.class_1299.method_3873("datePublished", 22));
        amb.put("description", class_268.class_1299.method_3873("description", 23));
        amb.put("duration", class_268.class_1299.method_3873("duration", 24));
        amb.put("embedUrl", class_268.class_1299.method_3873("embedUrl", 25));
        amb.put("endDate", class_268.class_1299.method_3873("endDate", 26));
        amb.put("familyName", class_268.class_1299.method_3873("familyName", 27));
        amb.put("gender", class_268.class_1299.method_3873("gender", 28));
        amb.put("geo", class_268.class_1299.method_3867("geo", 29, nu.class));
        amb.put("givenName", class_268.class_1299.method_3873("givenName", 30));
        amb.put("height", class_268.class_1299.method_3873("height", 31));
        amb.put("id", class_268.class_1299.method_3873("id", 32));
        amb.put("image", class_268.class_1299.method_3873("image", 33));
        amb.put("inAlbum", class_268.class_1299.method_3867("inAlbum", 34, nu.class));
        amb.put("latitude", class_268.class_1299.method_3871("latitude", 36));
        amb.put("location", class_268.class_1299.method_3867("location", 37, nu.class));
        amb.put("longitude", class_268.class_1299.method_3871("longitude", 38));
        amb.put("name", class_268.class_1299.method_3873("name", 39));
        amb.put("partOfTVSeries", class_268.class_1299.method_3867("partOfTVSeries", 40, nu.class));
        amb.put("performers", class_268.class_1299.method_3868("performers", 41, nu.class));
        amb.put("playerType", class_268.class_1299.method_3873("playerType", 42));
        amb.put("postOfficeBoxNumber", class_268.class_1299.method_3873("postOfficeBoxNumber", 43));
        amb.put("postalCode", class_268.class_1299.method_3873("postalCode", 44));
        amb.put("ratingValue", class_268.class_1299.method_3873("ratingValue", 45));
        amb.put("reviewRating", class_268.class_1299.method_3867("reviewRating", 46, nu.class));
        amb.put("startDate", class_268.class_1299.method_3873("startDate", 47));
        amb.put("streetAddress", class_268.class_1299.method_3873("streetAddress", 48));
        amb.put("text", class_268.class_1299.method_3873("text", 49));
        amb.put("thumbnail", class_268.class_1299.method_3867("thumbnail", 50, nu.class));
        amb.put("thumbnailUrl", class_268.class_1299.method_3873("thumbnailUrl", 51));
        amb.put("tickerSymbol", class_268.class_1299.method_3873("tickerSymbol", 52));
        amb.put("type", class_268.class_1299.method_3873("type", 53));
        amb.put("url", class_268.class_1299.method_3873("url", 54));
        amb.put("width", class_268.class_1299.method_3873("width", 55));
        amb.put("worstRating", class_268.class_1299.method_3873("worstRating", 56));
    }

    public class_271() {
        this.field_808 = 1;
        this.amc = new HashSet();
    }

    class_271(Set<Integer> var1, int var2, nu var3, List<String> var4, nu var5, String var6, String var7, String var8, List<nu> var9, int var10, List<nu> var11, nu var12, List<nu> var13, String var14, String var15, nu var16, String var17, String var18, String var19, List<nu> var20, String var21, String var22, String var23, String var24, String var25, String var26, String var27, String var28, String var29, nu var30, String var31, String var32, String var33, String var34, nu var35, double var36, nu var38, double var39, String var41, nu var42, List<nu> var43, String var44, String var45, String var46, String var47, nu var48, String var49, String var50, String var51, nu var52, String var53, String var54, String var55, String var56, String var57, String var58) {
        this.amc = var1;
        this.field_808 = var2;
        this.amd = var3;
        this.ame = var4;
        this.amf = var5;
        this.amg = var6;
        this.amh = var7;
        this.ami = var8;
        this.amj = var9;
        this.amk = var10;
        this.aml = var11;
        this.amm = var12;
        this.amn = var13;
        this.amo = var14;
        this.amp = var15;
        this.amq = var16;
        this.amr = var17;
        this.ams = var18;
        this.field_810 = var19;
        this.amt = var20;
        this.amu = var21;
        this.amv = var22;
        this.amw = var23;
        this.field_809 = var24;
        this.amx = var25;
        this.amy = var26;
        this.amz = var27;
        this.amA = var28;
        this.amB = var29;
        this.amC = var30;
        this.amD = var31;
        this.amE = var32;
        this.field_807 = var33;
        this.amF = var34;
        this.amG = var35;
        this.aek = var36;
        this.amH = var38;
        this.ael = var39;
        this.mName = var41;
        this.amI = var42;
        this.amJ = var43;
        this.amK = var44;
        this.amL = var45;
        this.amM = var46;
        this.amN = var47;
        this.amO = var48;
        this.amP = var49;
        this.amQ = var50;
        this.amR = var51;
        this.amS = var52;
        this.amT = var53;
        this.amU = var54;
        this.field_811 = var55;
        this.field_812 = var56;
        this.amV = var57;
        this.amW = var58;
    }

    public class_271(Set<Integer> var1, nu var2, List<String> var3, nu var4, String var5, String var6, String var7, List<nu> var8, int var9, List<nu> var10, nu var11, List<nu> var12, String var13, String var14, nu var15, String var16, String var17, String var18, List<nu> var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, String var27, String var28, nu var29, String var30, String var31, String var32, String var33, nu var34, double var35, nu var37, double var38, String var40, nu var41, List<nu> var42, String var43, String var44, String var45, String var46, nu var47, String var48, String var49, String var50, nu var51, String var52, String var53, String var54, String var55, String var56, String var57) {
        this.amc = var1;
        this.field_808 = 1;
        this.amd = var2;
        this.ame = var3;
        this.amf = var4;
        this.amg = var5;
        this.amh = var6;
        this.ami = var7;
        this.amj = var8;
        this.amk = var9;
        this.aml = var10;
        this.amm = var11;
        this.amn = var12;
        this.amo = var13;
        this.amp = var14;
        this.amq = var15;
        this.amr = var16;
        this.ams = var17;
        this.field_810 = var18;
        this.amt = var19;
        this.amu = var20;
        this.amv = var21;
        this.amw = var22;
        this.field_809 = var23;
        this.amx = var24;
        this.amy = var25;
        this.amz = var26;
        this.amA = var27;
        this.amB = var28;
        this.amC = var29;
        this.amD = var30;
        this.amE = var31;
        this.field_807 = var32;
        this.amF = var33;
        this.amG = var34;
        this.aek = var35;
        this.amH = var37;
        this.ael = var38;
        this.mName = var40;
        this.amI = var41;
        this.amJ = var42;
        this.amK = var43;
        this.amL = var44;
        this.amM = var45;
        this.amN = var46;
        this.amO = var47;
        this.amP = var48;
        this.amQ = var49;
        this.amR = var50;
        this.amS = var51;
        this.amT = var52;
        this.amU = var53;
        this.field_811 = var54;
        this.field_812 = var55;
        this.amV = var56;
        this.amW = var57;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ji$a) boolean
    protected boolean method_1691(class_268.class_1299 var1) {
        return this.amc.contains(Integer.valueOf(var1.method_3882()));
    }

    // $FF: renamed from: b (com.google.android.gms.internal.ji$a) java.lang.Object
    protected Object method_1692(class_268.class_1299 var1) {
        switch(var1.method_3882()) {
            case 2:
                return this.amd;
            case 3:
                return this.ame;
            case 4:
                return this.amf;
            case 5:
                return this.amg;
            case 6:
                return this.amh;
            case 7:
                return this.ami;
            case 8:
                return this.amj;
            case 9:
                return Integer.valueOf(this.amk);
            case 10:
                return this.aml;
            case 11:
                return this.amm;
            case 12:
                return this.amn;
            case 13:
                return this.amo;
            case 14:
                return this.amp;
            case 15:
                return this.amq;
            case 16:
                return this.amr;
            case 17:
                return this.ams;
            case 18:
                return this.field_810;
            case 19:
                return this.amt;
            case 20:
                return this.amu;
            case 21:
                return this.amv;
            case 22:
                return this.amw;
            case 23:
                return this.field_809;
            case 24:
                return this.amx;
            case 25:
                return this.amy;
            case 26:
                return this.amz;
            case 27:
                return this.amA;
            case 28:
                return this.amB;
            case 29:
                return this.amC;
            case 30:
                return this.amD;
            case 31:
                return this.amE;
            case 32:
                return this.field_807;
            case 33:
                return this.amF;
            case 34:
                return this.amG;
            case 35:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3882());
            case 36:
                return Double.valueOf(this.aek);
            case 37:
                return this.amH;
            case 38:
                return Double.valueOf(this.ael);
            case 39:
                return this.mName;
            case 40:
                return this.amI;
            case 41:
                return this.amJ;
            case 42:
                return this.amK;
            case 43:
                return this.amL;
            case 44:
                return this.amM;
            case 45:
                return this.amN;
            case 46:
                return this.amO;
            case 47:
                return this.amP;
            case 48:
                return this.amQ;
            case 49:
                return this.amR;
            case 50:
                return this.amS;
            case 51:
                return this.amT;
            case 52:
                return this.amU;
            case 53:
                return this.field_811;
            case 54:
                return this.field_812;
            case 55:
                return this.amV;
            case 56:
                return this.amW;
        }
    }

    public int describeContents() {
        class_862 var10000 = CREATOR;
        return 0;
    }

    public boolean equals(Object var1) {
        if(!(var1 instanceof class_271)) {
            return false;
        } else if(this == var1) {
            return true;
        } else {
            class_271 var2 = (class_271)var1;
            Iterator var3 = amb.values().iterator();

            while(var3.hasNext()) {
                class_268.class_1299 var4 = (class_268.class_1299)var3.next();
                if(this.method_1691(var4)) {
                    if(!var2.method_1691(var4)) {
                        return false;
                    }

                    if(!this.method_1692(var4).equals(var2.method_1692(var4))) {
                        return false;
                    }
                } else if(var2.method_1691(var4)) {
                    return false;
                }
            }

            return true;
        }
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_1722();
    }

    public ItemScope getAbout() {
        return this.amd;
    }

    public List<String> getAdditionalName() {
        return this.ame;
    }

    public ItemScope getAddress() {
        return this.amf;
    }

    public String getAddressCountry() {
        return this.amg;
    }

    public String getAddressLocality() {
        return this.amh;
    }

    public String getAddressRegion() {
        return this.ami;
    }

    public List<ItemScope> getAssociated_media() {
        return (ArrayList)this.amj;
    }

    public int getAttendeeCount() {
        return this.amk;
    }

    public List<ItemScope> getAttendees() {
        return (ArrayList)this.aml;
    }

    public ItemScope getAudio() {
        return this.amm;
    }

    public List<ItemScope> getAuthor() {
        return (ArrayList)this.amn;
    }

    public String getBestRating() {
        return this.amo;
    }

    public String getBirthDate() {
        return this.amp;
    }

    public ItemScope getByArtist() {
        return this.amq;
    }

    public String getCaption() {
        return this.amr;
    }

    public String getContentSize() {
        return this.ams;
    }

    public String getContentUrl() {
        return this.field_810;
    }

    public List<ItemScope> getContributor() {
        return (ArrayList)this.amt;
    }

    public String getDateCreated() {
        return this.amu;
    }

    public String getDateModified() {
        return this.amv;
    }

    public String getDatePublished() {
        return this.amw;
    }

    public String getDescription() {
        return this.field_809;
    }

    public String getDuration() {
        return this.amx;
    }

    public String getEmbedUrl() {
        return this.amy;
    }

    public String getEndDate() {
        return this.amz;
    }

    public String getFamilyName() {
        return this.amA;
    }

    public String getGender() {
        return this.amB;
    }

    public ItemScope getGeo() {
        return this.amC;
    }

    public String getGivenName() {
        return this.amD;
    }

    public String getHeight() {
        return this.amE;
    }

    public String getId() {
        return this.field_807;
    }

    public String getImage() {
        return this.amF;
    }

    public ItemScope getInAlbum() {
        return this.amG;
    }

    public double getLatitude() {
        return this.aek;
    }

    public ItemScope getLocation() {
        return this.amH;
    }

    public double getLongitude() {
        return this.ael;
    }

    public String getName() {
        return this.mName;
    }

    public ItemScope getPartOfTVSeries() {
        return this.amI;
    }

    public List<ItemScope> getPerformers() {
        return (ArrayList)this.amJ;
    }

    public String getPlayerType() {
        return this.amK;
    }

    public String getPostOfficeBoxNumber() {
        return this.amL;
    }

    public String getPostalCode() {
        return this.amM;
    }

    public String getRatingValue() {
        return this.amN;
    }

    public ItemScope getReviewRating() {
        return this.amO;
    }

    public String getStartDate() {
        return this.amP;
    }

    public String getStreetAddress() {
        return this.amQ;
    }

    public String getText() {
        return this.amR;
    }

    public ItemScope getThumbnail() {
        return this.amS;
    }

    public String getThumbnailUrl() {
        return this.amT;
    }

    public String getTickerSymbol() {
        return this.amU;
    }

    public String getType() {
        return this.field_811;
    }

    public String getUrl() {
        return this.field_812;
    }

    public String getWidth() {
        return this.amV;
    }

    public String getWorstRating() {
        return this.amW;
    }

    public boolean hasAbout() {
        return this.amc.contains(Integer.valueOf(2));
    }

    public boolean hasAdditionalName() {
        return this.amc.contains(Integer.valueOf(3));
    }

    public boolean hasAddress() {
        return this.amc.contains(Integer.valueOf(4));
    }

    public boolean hasAddressCountry() {
        return this.amc.contains(Integer.valueOf(5));
    }

    public boolean hasAddressLocality() {
        return this.amc.contains(Integer.valueOf(6));
    }

    public boolean hasAddressRegion() {
        return this.amc.contains(Integer.valueOf(7));
    }

    public boolean hasAssociated_media() {
        return this.amc.contains(Integer.valueOf(8));
    }

    public boolean hasAttendeeCount() {
        return this.amc.contains(Integer.valueOf(9));
    }

    public boolean hasAttendees() {
        return this.amc.contains(Integer.valueOf(10));
    }

    public boolean hasAudio() {
        return this.amc.contains(Integer.valueOf(11));
    }

    public boolean hasAuthor() {
        return this.amc.contains(Integer.valueOf(12));
    }

    public boolean hasBestRating() {
        return this.amc.contains(Integer.valueOf(13));
    }

    public boolean hasBirthDate() {
        return this.amc.contains(Integer.valueOf(14));
    }

    public boolean hasByArtist() {
        return this.amc.contains(Integer.valueOf(15));
    }

    public boolean hasCaption() {
        return this.amc.contains(Integer.valueOf(16));
    }

    public boolean hasContentSize() {
        return this.amc.contains(Integer.valueOf(17));
    }

    public boolean hasContentUrl() {
        return this.amc.contains(Integer.valueOf(18));
    }

    public boolean hasContributor() {
        return this.amc.contains(Integer.valueOf(19));
    }

    public boolean hasDateCreated() {
        return this.amc.contains(Integer.valueOf(20));
    }

    public boolean hasDateModified() {
        return this.amc.contains(Integer.valueOf(21));
    }

    public boolean hasDatePublished() {
        return this.amc.contains(Integer.valueOf(22));
    }

    public boolean hasDescription() {
        return this.amc.contains(Integer.valueOf(23));
    }

    public boolean hasDuration() {
        return this.amc.contains(Integer.valueOf(24));
    }

    public boolean hasEmbedUrl() {
        return this.amc.contains(Integer.valueOf(25));
    }

    public boolean hasEndDate() {
        return this.amc.contains(Integer.valueOf(26));
    }

    public boolean hasFamilyName() {
        return this.amc.contains(Integer.valueOf(27));
    }

    public boolean hasGender() {
        return this.amc.contains(Integer.valueOf(28));
    }

    public boolean hasGeo() {
        return this.amc.contains(Integer.valueOf(29));
    }

    public boolean hasGivenName() {
        return this.amc.contains(Integer.valueOf(30));
    }

    public boolean hasHeight() {
        return this.amc.contains(Integer.valueOf(31));
    }

    public boolean hasId() {
        return this.amc.contains(Integer.valueOf(32));
    }

    public boolean hasImage() {
        return this.amc.contains(Integer.valueOf(33));
    }

    public boolean hasInAlbum() {
        return this.amc.contains(Integer.valueOf(34));
    }

    public boolean hasLatitude() {
        return this.amc.contains(Integer.valueOf(36));
    }

    public boolean hasLocation() {
        return this.amc.contains(Integer.valueOf(37));
    }

    public boolean hasLongitude() {
        return this.amc.contains(Integer.valueOf(38));
    }

    public boolean hasName() {
        return this.amc.contains(Integer.valueOf(39));
    }

    public boolean hasPartOfTVSeries() {
        return this.amc.contains(Integer.valueOf(40));
    }

    public boolean hasPerformers() {
        return this.amc.contains(Integer.valueOf(41));
    }

    public boolean hasPlayerType() {
        return this.amc.contains(Integer.valueOf(42));
    }

    public boolean hasPostOfficeBoxNumber() {
        return this.amc.contains(Integer.valueOf(43));
    }

    public boolean hasPostalCode() {
        return this.amc.contains(Integer.valueOf(44));
    }

    public boolean hasRatingValue() {
        return this.amc.contains(Integer.valueOf(45));
    }

    public boolean hasReviewRating() {
        return this.amc.contains(Integer.valueOf(46));
    }

    public boolean hasStartDate() {
        return this.amc.contains(Integer.valueOf(47));
    }

    public boolean hasStreetAddress() {
        return this.amc.contains(Integer.valueOf(48));
    }

    public boolean hasText() {
        return this.amc.contains(Integer.valueOf(49));
    }

    public boolean hasThumbnail() {
        return this.amc.contains(Integer.valueOf(50));
    }

    public boolean hasThumbnailUrl() {
        return this.amc.contains(Integer.valueOf(51));
    }

    public boolean hasTickerSymbol() {
        return this.amc.contains(Integer.valueOf(52));
    }

    public boolean hasType() {
        return this.amc.contains(Integer.valueOf(53));
    }

    public boolean hasUrl() {
        return this.amc.contains(Integer.valueOf(54));
    }

    public boolean hasWidth() {
        return this.amc.contains(Integer.valueOf(55));
    }

    public boolean hasWorstRating() {
        return this.amc.contains(Integer.valueOf(56));
    }

    public int hashCode() {
        Iterator var1 = amb.values().iterator();

        int var2;
        int var4;
        for(var2 = 0; var1.hasNext(); var2 = var4) {
            class_268.class_1299 var3 = (class_268.class_1299)var1.next();
            if(this.method_1691(var3)) {
                var4 = var2 + var3.method_3882() + this.method_1692(var3).hashCode();
            } else {
                var4 = var2;
            }
        }

        return var2;
    }

    // $FF: renamed from: hf () java.util.HashMap
    public HashMap<String, class_268.class_1299<?, ?>> method_1697() {
        return amb;
    }

    public boolean isDataValid() {
        return true;
    }

    // $FF: renamed from: nr () com.google.android.gms.internal.nu
    public class_271 method_1722() {
        return this;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_862 var10000 = CREATOR;
        class_862.method_4519(this, var1, var2);
    }
}
