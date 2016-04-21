package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.internal.class_268;
import com.google.android.gms.internal.class_270;
import com.google.android.gms.internal.class_359;
import com.google.android.gms.internal.class_856;
import com.google.android.gms.internal.class_857;
import com.google.android.gms.internal.class_858;
import com.google.android.gms.internal.class_859;
import com.google.android.gms.internal.class_860;
import com.google.android.gms.internal.class_861;
import com.google.android.gms.internal.class_915;
import com.google.android.gms.internal.class_916;
import com.google.android.gms.internal.class_917;
import com.google.android.gms.internal.class_918;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.nz
public final class class_272 extends class_270 implements Person {
    public static final class_857 CREATOR = new class_857();
    private static final HashMap<String, class_268.class_1299<?, ?>> amb = new HashMap();
    // $FF: renamed from: BL java.lang.String
    String field_813;
    // $FF: renamed from: BR int
    final int field_814;
    // $FF: renamed from: Fc java.lang.String
    String field_815;
    // $FF: renamed from: NH java.lang.String
    String field_816;
    final Set<Integer> amc;
    String ana;
    class_272.class_1290 anb;
    String anc;
    String and;
    int ane;
    class_272.class_1165 anf;
    String ang;
    class_272.class_1291 anh;
    boolean ani;
    class_272.class_1292 anj;
    String ank;
    int anl;
    List<class_272.class_1294> anm;
    List<class_272.class_1295> ann;
    int ano;
    int anp;
    String anq;
    List<class_272.class_1296> anr;
    boolean ans;
    // $FF: renamed from: om int
    int field_817;
    // $FF: renamed from: uR java.lang.String
    String field_818;

    static {
        amb.put("aboutMe", class_268.class_1299.method_3873("aboutMe", 2));
        amb.put("ageRange", class_268.class_1299.method_3867("ageRange", 3, class_272.class_1290.class));
        amb.put("birthday", class_268.class_1299.method_3873("birthday", 4));
        amb.put("braggingRights", class_268.class_1299.method_3873("braggingRights", 5));
        amb.put("circledByCount", class_268.class_1299.method_3870("circledByCount", 6));
        amb.put("cover", class_268.class_1299.method_3867("cover", 7, class_272.class_1165.class));
        amb.put("currentLocation", class_268.class_1299.method_3873("currentLocation", 8));
        amb.put("displayName", class_268.class_1299.method_3873("displayName", 9));
        amb.put("gender", class_268.class_1299.method_3866("gender", 12, (new class_359()).method_2382("male", 0).method_2382("female", 1).method_2382("other", 2), false));
        amb.put("id", class_268.class_1299.method_3873("id", 14));
        amb.put("image", class_268.class_1299.method_3867("image", 15, class_272.class_1291.class));
        amb.put("isPlusUser", class_268.class_1299.method_3872("isPlusUser", 16));
        amb.put("language", class_268.class_1299.method_3873("language", 18));
        amb.put("name", class_268.class_1299.method_3867("name", 19, class_272.class_1292.class));
        amb.put("nickname", class_268.class_1299.method_3873("nickname", 20));
        amb.put("objectType", class_268.class_1299.method_3866("objectType", 21, (new class_359()).method_2382("person", 0).method_2382("page", 1), false));
        amb.put("organizations", class_268.class_1299.method_3868("organizations", 22, class_272.class_1294.class));
        amb.put("placesLived", class_268.class_1299.method_3868("placesLived", 23, class_272.class_1295.class));
        amb.put("plusOneCount", class_268.class_1299.method_3870("plusOneCount", 24));
        amb.put("relationshipStatus", class_268.class_1299.method_3866("relationshipStatus", 25, (new class_359()).method_2382("single", 0).method_2382("in_a_relationship", 1).method_2382("engaged", 2).method_2382("married", 3).method_2382("its_complicated", 4).method_2382("open_relationship", 5).method_2382("widowed", 6).method_2382("in_domestic_partnership", 7).method_2382("in_civil_union", 8), false));
        amb.put("tagline", class_268.class_1299.method_3873("tagline", 26));
        amb.put("url", class_268.class_1299.method_3873("url", 27));
        amb.put("urls", class_268.class_1299.method_3868("urls", 28, class_272.class_1296.class));
        amb.put("verified", class_268.class_1299.method_3872("verified", 29));
    }

    public class_272() {
        this.field_814 = 1;
        this.amc = new HashSet();
    }

    public class_272(String var1, String var2, class_272.class_1291 var3, int var4, String var5) {
        this.field_814 = 1;
        this.amc = new HashSet();
        this.field_816 = var1;
        this.amc.add(Integer.valueOf(9));
        this.field_813 = var2;
        this.amc.add(Integer.valueOf(14));
        this.anh = var3;
        this.amc.add(Integer.valueOf(15));
        this.anl = var4;
        this.amc.add(Integer.valueOf(21));
        this.field_818 = var5;
        this.amc.add(Integer.valueOf(27));
    }

    class_272(Set<Integer> var1, int var2, String var3, class_272.class_1290 var4, String var5, String var6, int var7, class_272.class_1165 var8, String var9, String var10, int var11, String var12, class_272.class_1291 var13, boolean var14, String var15, class_272.class_1292 var16, String var17, int var18, List<class_272.class_1294> var19, List<class_272.class_1295> var20, int var21, int var22, String var23, String var24, List<class_272.class_1296> var25, boolean var26) {
        this.amc = var1;
        this.field_814 = var2;
        this.ana = var3;
        this.anb = var4;
        this.anc = var5;
        this.and = var6;
        this.ane = var7;
        this.anf = var8;
        this.ang = var9;
        this.field_816 = var10;
        this.field_817 = var11;
        this.field_813 = var12;
        this.anh = var13;
        this.ani = var14;
        this.field_815 = var15;
        this.anj = var16;
        this.ank = var17;
        this.anl = var18;
        this.anm = var19;
        this.ann = var20;
        this.ano = var21;
        this.anp = var22;
        this.anq = var23;
        this.field_818 = var24;
        this.anr = var25;
        this.ans = var26;
    }

    // $FF: renamed from: i (byte[]) com.google.android.gms.internal.nz
    public static class_272 method_1723(byte[] var0) {
        Parcel var1 = Parcel.obtain();
        var1.unmarshall(var0, 0, var0.length);
        var1.setDataPosition(0);
        class_272 var2 = CREATOR.method_4505(var1);
        var1.recycle();
        return var2;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ji$a) boolean
    protected boolean method_1691(class_268.class_1299 var1) {
        return this.amc.contains(Integer.valueOf(var1.method_3882()));
    }

    // $FF: renamed from: b (com.google.android.gms.internal.ji$a) java.lang.Object
    protected Object method_1692(class_268.class_1299 var1) {
        switch(var1.method_3882()) {
            case 2:
                return this.ana;
            case 3:
                return this.anb;
            case 4:
                return this.anc;
            case 5:
                return this.and;
            case 6:
                return Integer.valueOf(this.ane);
            case 7:
                return this.anf;
            case 8:
                return this.ang;
            case 9:
                return this.field_816;
            case 10:
            case 11:
            case 13:
            case 17:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3882());
            case 12:
                return Integer.valueOf(this.field_817);
            case 14:
                return this.field_813;
            case 15:
                return this.anh;
            case 16:
                return Boolean.valueOf(this.ani);
            case 18:
                return this.field_815;
            case 19:
                return this.anj;
            case 20:
                return this.ank;
            case 21:
                return Integer.valueOf(this.anl);
            case 22:
                return this.anm;
            case 23:
                return this.ann;
            case 24:
                return Integer.valueOf(this.ano);
            case 25:
                return Integer.valueOf(this.anp);
            case 26:
                return this.anq;
            case 27:
                return this.field_818;
            case 28:
                return this.anr;
            case 29:
                return Boolean.valueOf(this.ans);
        }
    }

    public int describeContents() {
        class_857 var10000 = CREATOR;
        return 0;
    }

    public boolean equals(Object var1) {
        if(!(var1 instanceof class_272)) {
            return false;
        } else if(this == var1) {
            return true;
        } else {
            class_272 var2 = (class_272)var1;
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
        return this.method_1724();
    }

    public String getAboutMe() {
        return this.ana;
    }

    public Person.AgeRange getAgeRange() {
        return this.anb;
    }

    public String getBirthday() {
        return this.anc;
    }

    public String getBraggingRights() {
        return this.and;
    }

    public int getCircledByCount() {
        return this.ane;
    }

    public Person.Cover getCover() {
        return this.anf;
    }

    public String getCurrentLocation() {
        return this.ang;
    }

    public String getDisplayName() {
        return this.field_816;
    }

    public int getGender() {
        return this.field_817;
    }

    public String getId() {
        return this.field_813;
    }

    public Person.Image getImage() {
        return this.anh;
    }

    public String getLanguage() {
        return this.field_815;
    }

    public Person.Name getName() {
        return this.anj;
    }

    public String getNickname() {
        return this.ank;
    }

    public int getObjectType() {
        return this.anl;
    }

    public List<Person.Organizations> getOrganizations() {
        return (ArrayList)this.anm;
    }

    public List<Person.PlacesLived> getPlacesLived() {
        return (ArrayList)this.ann;
    }

    public int getPlusOneCount() {
        return this.ano;
    }

    public int getRelationshipStatus() {
        return this.anp;
    }

    public String getTagline() {
        return this.anq;
    }

    public String getUrl() {
        return this.field_818;
    }

    public List<Person.Urls> getUrls() {
        return (ArrayList)this.anr;
    }

    public boolean hasAboutMe() {
        return this.amc.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange() {
        return this.amc.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday() {
        return this.amc.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights() {
        return this.amc.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount() {
        return this.amc.contains(Integer.valueOf(6));
    }

    public boolean hasCover() {
        return this.amc.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation() {
        return this.amc.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName() {
        return this.amc.contains(Integer.valueOf(9));
    }

    public boolean hasGender() {
        return this.amc.contains(Integer.valueOf(12));
    }

    public boolean hasId() {
        return this.amc.contains(Integer.valueOf(14));
    }

    public boolean hasImage() {
        return this.amc.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser() {
        return this.amc.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage() {
        return this.amc.contains(Integer.valueOf(18));
    }

    public boolean hasName() {
        return this.amc.contains(Integer.valueOf(19));
    }

    public boolean hasNickname() {
        return this.amc.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType() {
        return this.amc.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations() {
        return this.amc.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived() {
        return this.amc.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount() {
        return this.amc.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus() {
        return this.amc.contains(Integer.valueOf(25));
    }

    public boolean hasTagline() {
        return this.amc.contains(Integer.valueOf(26));
    }

    public boolean hasUrl() {
        return this.amc.contains(Integer.valueOf(27));
    }

    public boolean hasUrls() {
        return this.amc.contains(Integer.valueOf(28));
    }

    public boolean hasVerified() {
        return this.amc.contains(Integer.valueOf(29));
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

    public boolean isPlusUser() {
        return this.ani;
    }

    public boolean isVerified() {
        return this.ans;
    }

    // $FF: renamed from: nu () com.google.android.gms.internal.nz
    public class_272 method_1724() {
        return this;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_857 var10000 = CREATOR;
        class_857.method_4504(this, var1, var2);
    }

    public static final class class_1290 extends class_270 implements Person.AgeRange {
        public static final class_856 CREATOR = new class_856();
        private static final HashMap<String, class_268.class_1299<?, ?>> amb = new HashMap();
        // $FF: renamed from: BR int
        final int field_801;
        final Set<Integer> amc;
        int ant;
        int anu;

        static {
            amb.put("max", class_268.class_1299.method_3870("max", 2));
            amb.put("min", class_268.class_1299.method_3870("min", 3));
        }

        public class_1290() {
            this.field_801 = 1;
            this.amc = new HashSet();
        }

        class_1290(Set<Integer> var1, int var2, int var3, int var4) {
            this.amc = var1;
            this.field_801 = var2;
            this.ant = var3;
            this.anu = var4;
        }

        // $FF: renamed from: a (com.google.android.gms.internal.ji$a) boolean
        protected boolean method_1691(class_268.class_1299 var1) {
            return this.amc.contains(Integer.valueOf(var1.method_3882()));
        }

        // $FF: renamed from: b (com.google.android.gms.internal.ji$a) java.lang.Object
        protected Object method_1692(class_268.class_1299 var1) {
            switch(var1.method_3882()) {
                case 2:
                    return Integer.valueOf(this.ant);
                case 3:
                    return Integer.valueOf(this.anu);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3882());
            }
        }

        public int describeContents() {
            class_856 var10000 = CREATOR;
            return 0;
        }

        public boolean equals(Object var1) {
            if(!(var1 instanceof class_272.class_1290)) {
                return false;
            } else if(this == var1) {
                return true;
            } else {
                class_272.class_1290 var2 = (class_272.class_1290)var1;
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
            return this.method_1717();
        }

        public int getMax() {
            return this.ant;
        }

        public int getMin() {
            return this.anu;
        }

        public boolean hasMax() {
            return this.amc.contains(Integer.valueOf(2));
        }

        public boolean hasMin() {
            return this.amc.contains(Integer.valueOf(3));
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

        // $FF: renamed from: nv () com.google.android.gms.internal.nz$a
        public class_272.class_1290 method_1717() {
            return this;
        }

        public void writeToParcel(Parcel var1, int var2) {
            class_856 var10000 = CREATOR;
            class_856.method_4501(this, var1, var2);
        }
    }

    public static final class class_1165 extends class_270 implements Person.Cover {
        public static final class_859 CREATOR = new class_859();
        private static final HashMap<String, class_268.class_1299<?, ?>> amb = new HashMap();
        // $FF: renamed from: BR int
        final int field_802;
        final Set<Integer> amc;
        class_272.class_1166 anv;
        class_272.class_1169 anw;
        int anx;

        static {
            amb.put("coverInfo", class_268.class_1299.method_3867("coverInfo", 2, class_272.class_1166.class));
            amb.put("coverPhoto", class_268.class_1299.method_3867("coverPhoto", 3, class_272.class_1169.class));
            amb.put("layout", class_268.class_1299.method_3866("layout", 4, (new class_359()).method_2382("banner", 0), false));
        }

        public class_1165() {
            this.field_802 = 1;
            this.amc = new HashSet();
        }

        class_1165(Set<Integer> var1, int var2, class_272.class_1166 var3, class_272.class_1169 var4, int var5) {
            this.amc = var1;
            this.field_802 = var2;
            this.anv = var3;
            this.anw = var4;
            this.anx = var5;
        }

        // $FF: renamed from: a (com.google.android.gms.internal.ji$a) boolean
        protected boolean method_1691(class_268.class_1299 var1) {
            return this.amc.contains(Integer.valueOf(var1.method_3882()));
        }

        // $FF: renamed from: b (com.google.android.gms.internal.ji$a) java.lang.Object
        protected Object method_1692(class_268.class_1299 var1) {
            switch(var1.method_3882()) {
                case 2:
                    return this.anv;
                case 3:
                    return this.anw;
                case 4:
                    return Integer.valueOf(this.anx);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3882());
            }
        }

        public int describeContents() {
            class_859 var10000 = CREATOR;
            return 0;
        }

        public boolean equals(Object var1) {
            if(!(var1 instanceof class_272.class_1165)) {
                return false;
            } else if(this == var1) {
                return true;
            } else {
                class_272.class_1165 var2 = (class_272.class_1165)var1;
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
            return this.method_1718();
        }

        public Person.CoverInfo getCoverInfo() {
            return this.anv;
        }

        public Person.CoverPhoto getCoverPhoto() {
            return this.anw;
        }

        public int getLayout() {
            return this.anx;
        }

        public boolean hasCoverInfo() {
            return this.amc.contains(Integer.valueOf(2));
        }

        public boolean hasCoverPhoto() {
            return this.amc.contains(Integer.valueOf(3));
        }

        public boolean hasLayout() {
            return this.amc.contains(Integer.valueOf(4));
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

        // $FF: renamed from: nw () com.google.android.gms.internal.nz$b
        public class_272.class_1165 method_1718() {
            return this;
        }

        public void writeToParcel(Parcel var1, int var2) {
            class_859 var10000 = CREATOR;
            class_859.method_4510(this, var1, var2);
        }
    }

    public static final class class_1166 extends class_270 implements Person.CoverInfo {
        public static final class_858 CREATOR = new class_858();
        private static final HashMap<String, class_268.class_1299<?, ?>> amb = new HashMap();
        // $FF: renamed from: BR int
        final int field_826;
        final Set<Integer> amc;
        int any;
        int anz;

        static {
            amb.put("leftImageOffset", class_268.class_1299.method_3870("leftImageOffset", 2));
            amb.put("topImageOffset", class_268.class_1299.method_3870("topImageOffset", 3));
        }

        public class_1166() {
            this.field_826 = 1;
            this.amc = new HashSet();
        }

        class_1166(Set<Integer> var1, int var2, int var3, int var4) {
            this.amc = var1;
            this.field_826 = var2;
            this.any = var3;
            this.anz = var4;
        }

        // $FF: renamed from: a (com.google.android.gms.internal.ji$a) boolean
        protected boolean method_1691(class_268.class_1299 var1) {
            return this.amc.contains(Integer.valueOf(var1.method_3882()));
        }

        // $FF: renamed from: b (com.google.android.gms.internal.ji$a) java.lang.Object
        protected Object method_1692(class_268.class_1299 var1) {
            switch(var1.method_3882()) {
                case 2:
                    return Integer.valueOf(this.any);
                case 3:
                    return Integer.valueOf(this.anz);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3882());
            }
        }

        public int describeContents() {
            class_858 var10000 = CREATOR;
            return 0;
        }

        public boolean equals(Object var1) {
            if(!(var1 instanceof class_272.class_1166)) {
                return false;
            } else if(this == var1) {
                return true;
            } else {
                class_272.class_1166 var2 = (class_272.class_1166)var1;
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
            return this.method_1727();
        }

        public int getLeftImageOffset() {
            return this.any;
        }

        public int getTopImageOffset() {
            return this.anz;
        }

        public boolean hasLeftImageOffset() {
            return this.amc.contains(Integer.valueOf(2));
        }

        public boolean hasTopImageOffset() {
            return this.amc.contains(Integer.valueOf(3));
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

        // $FF: renamed from: nx () com.google.android.gms.internal.nz$b$a
        public class_272.class_1166 method_1727() {
            return this;
        }

        public void writeToParcel(Parcel var1, int var2) {
            class_858 var10000 = CREATOR;
            class_858.method_4507(this, var1, var2);
        }
    }

    public static final class class_1169 extends class_270 implements Person.CoverPhoto {
        public static final class_861 CREATOR = new class_861();
        private static final HashMap<String, class_268.class_1299<?, ?>> amb = new HashMap();
        // $FF: renamed from: BR int
        final int field_822;
        final Set<Integer> amc;
        // $FF: renamed from: lf int
        int field_823;
        // $FF: renamed from: lg int
        int field_824;
        // $FF: renamed from: uR java.lang.String
        String field_825;

        static {
            amb.put("height", class_268.class_1299.method_3870("height", 2));
            amb.put("url", class_268.class_1299.method_3873("url", 3));
            amb.put("width", class_268.class_1299.method_3870("width", 4));
        }

        public class_1169() {
            this.field_822 = 1;
            this.amc = new HashSet();
        }

        class_1169(Set<Integer> var1, int var2, int var3, String var4, int var5) {
            this.amc = var1;
            this.field_822 = var2;
            this.field_824 = var3;
            this.field_825 = var4;
            this.field_823 = var5;
        }

        // $FF: renamed from: a (com.google.android.gms.internal.ji$a) boolean
        protected boolean method_1691(class_268.class_1299 var1) {
            return this.amc.contains(Integer.valueOf(var1.method_3882()));
        }

        // $FF: renamed from: b (com.google.android.gms.internal.ji$a) java.lang.Object
        protected Object method_1692(class_268.class_1299 var1) {
            switch(var1.method_3882()) {
                case 2:
                    return Integer.valueOf(this.field_824);
                case 3:
                    return this.field_825;
                case 4:
                    return Integer.valueOf(this.field_823);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3882());
            }
        }

        public int describeContents() {
            class_861 var10000 = CREATOR;
            return 0;
        }

        public boolean equals(Object var1) {
            if(!(var1 instanceof class_272.class_1169)) {
                return false;
            } else if(this == var1) {
                return true;
            } else {
                class_272.class_1169 var2 = (class_272.class_1169)var1;
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
            return this.method_1726();
        }

        public int getHeight() {
            return this.field_824;
        }

        public String getUrl() {
            return this.field_825;
        }

        public int getWidth() {
            return this.field_823;
        }

        public boolean hasHeight() {
            return this.amc.contains(Integer.valueOf(2));
        }

        public boolean hasUrl() {
            return this.amc.contains(Integer.valueOf(3));
        }

        public boolean hasWidth() {
            return this.amc.contains(Integer.valueOf(4));
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

        // $FF: renamed from: ny () com.google.android.gms.internal.nz$b$b
        public class_272.class_1169 method_1726() {
            return this;
        }

        public void writeToParcel(Parcel var1, int var2) {
            class_861 var10000 = CREATOR;
            class_861.method_4516(this, var1, var2);
        }
    }

    public static final class class_1291 extends class_270 implements Person.Image {
        public static final class_860 CREATOR = new class_860();
        private static final HashMap<String, class_268.class_1299<?, ?>> amb = new HashMap();
        // $FF: renamed from: BR int
        final int field_803;
        final Set<Integer> amc;
        // $FF: renamed from: uR java.lang.String
        String field_804;

        static {
            amb.put("url", class_268.class_1299.method_3873("url", 2));
        }

        public class_1291() {
            this.field_803 = 1;
            this.amc = new HashSet();
        }

        public class_1291(String var1) {
            this.amc = new HashSet();
            this.field_803 = 1;
            this.field_804 = var1;
            this.amc.add(Integer.valueOf(2));
        }

        class_1291(Set<Integer> var1, int var2, String var3) {
            this.amc = var1;
            this.field_803 = var2;
            this.field_804 = var3;
        }

        // $FF: renamed from: a (com.google.android.gms.internal.ji$a) boolean
        protected boolean method_1691(class_268.class_1299 var1) {
            return this.amc.contains(Integer.valueOf(var1.method_3882()));
        }

        // $FF: renamed from: b (com.google.android.gms.internal.ji$a) java.lang.Object
        protected Object method_1692(class_268.class_1299 var1) {
            switch(var1.method_3882()) {
                case 2:
                    return this.field_804;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3882());
            }
        }

        public int describeContents() {
            class_860 var10000 = CREATOR;
            return 0;
        }

        public boolean equals(Object var1) {
            if(!(var1 instanceof class_272.class_1291)) {
                return false;
            } else if(this == var1) {
                return true;
            } else {
                class_272.class_1291 var2 = (class_272.class_1291)var1;
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
            return this.method_1719();
        }

        public String getUrl() {
            return this.field_804;
        }

        public boolean hasUrl() {
            return this.amc.contains(Integer.valueOf(2));
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

        // $FF: renamed from: nz () com.google.android.gms.internal.nz$c
        public class_272.class_1291 method_1719() {
            return this;
        }

        public void writeToParcel(Parcel var1, int var2) {
            class_860 var10000 = CREATOR;
            class_860.method_4513(this, var1, var2);
        }
    }

    public static final class class_1292 extends class_270 implements Person.Name {
        public static final class_918 CREATOR = new class_918();
        private static final HashMap<String, class_268.class_1299<?, ?>> amb = new HashMap();
        // $FF: renamed from: BR int
        final int field_795;
        String amA;
        String amD;
        final Set<Integer> amc;
        String anA;
        String anB;
        String anC;
        String anD;

        static {
            amb.put("familyName", class_268.class_1299.method_3873("familyName", 2));
            amb.put("formatted", class_268.class_1299.method_3873("formatted", 3));
            amb.put("givenName", class_268.class_1299.method_3873("givenName", 4));
            amb.put("honorificPrefix", class_268.class_1299.method_3873("honorificPrefix", 5));
            amb.put("honorificSuffix", class_268.class_1299.method_3873("honorificSuffix", 6));
            amb.put("middleName", class_268.class_1299.method_3873("middleName", 7));
        }

        public class_1292() {
            this.field_795 = 1;
            this.amc = new HashSet();
        }

        class_1292(Set<Integer> var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8) {
            this.amc = var1;
            this.field_795 = var2;
            this.amA = var3;
            this.anA = var4;
            this.amD = var5;
            this.anB = var6;
            this.anC = var7;
            this.anD = var8;
        }

        // $FF: renamed from: a (com.google.android.gms.internal.ji$a) boolean
        protected boolean method_1691(class_268.class_1299 var1) {
            return this.amc.contains(Integer.valueOf(var1.method_3882()));
        }

        // $FF: renamed from: b (com.google.android.gms.internal.ji$a) java.lang.Object
        protected Object method_1692(class_268.class_1299 var1) {
            switch(var1.method_3882()) {
                case 2:
                    return this.amA;
                case 3:
                    return this.anA;
                case 4:
                    return this.amD;
                case 5:
                    return this.anB;
                case 6:
                    return this.anC;
                case 7:
                    return this.anD;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3882());
            }
        }

        public int describeContents() {
            class_918 var10000 = CREATOR;
            return 0;
        }

        public boolean equals(Object var1) {
            if(!(var1 instanceof class_272.class_1292)) {
                return false;
            } else if(this == var1) {
                return true;
            } else {
                class_272.class_1292 var2 = (class_272.class_1292)var1;
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
            return this.method_1714();
        }

        public String getFamilyName() {
            return this.amA;
        }

        public String getFormatted() {
            return this.anA;
        }

        public String getGivenName() {
            return this.amD;
        }

        public String getHonorificPrefix() {
            return this.anB;
        }

        public String getHonorificSuffix() {
            return this.anC;
        }

        public String getMiddleName() {
            return this.anD;
        }

        public boolean hasFamilyName() {
            return this.amc.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted() {
            return this.amc.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName() {
            return this.amc.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix() {
            return this.amc.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix() {
            return this.amc.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName() {
            return this.amc.contains(Integer.valueOf(7));
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

        // $FF: renamed from: nA () com.google.android.gms.internal.nz$d
        public class_272.class_1292 method_1714() {
            return this;
        }

        public void writeToParcel(Parcel var1, int var2) {
            class_918 var10000 = CREATOR;
            class_918.method_4750(this, var1, var2);
        }
    }

    public static class class_1293 {
        // $FF: renamed from: ci (java.lang.String) int
        public static int method_6024(String var0) {
            if(var0.equals("person")) {
                return 0;
            } else if(var0.equals("page")) {
                return 1;
            } else {
                throw new IllegalArgumentException("Unknown objectType string: " + var0);
            }
        }
    }

    public static final class class_1294 extends class_270 implements Person.Organizations {
        public static final class_917 CREATOR = new class_917();
        private static final HashMap<String, class_268.class_1299<?, ?>> amb = new HashMap();
        // $FF: renamed from: BR int
        final int field_796;
        // $FF: renamed from: FD int
        int field_797;
        // $FF: renamed from: Nw java.lang.String
        String field_798;
        // $FF: renamed from: Tr java.lang.String
        String field_799;
        String amP;
        final Set<Integer> amc;
        String amz;
        String anE;
        String anF;
        boolean anG;
        String mName;

        static {
            amb.put("department", class_268.class_1299.method_3873("department", 2));
            amb.put("description", class_268.class_1299.method_3873("description", 3));
            amb.put("endDate", class_268.class_1299.method_3873("endDate", 4));
            amb.put("location", class_268.class_1299.method_3873("location", 5));
            amb.put("name", class_268.class_1299.method_3873("name", 6));
            amb.put("primary", class_268.class_1299.method_3872("primary", 7));
            amb.put("startDate", class_268.class_1299.method_3873("startDate", 8));
            amb.put("title", class_268.class_1299.method_3873("title", 9));
            amb.put("type", class_268.class_1299.method_3866("type", 10, (new class_359()).method_2382("work", 0).method_2382("school", 1), false));
        }

        public class_1294() {
            this.field_796 = 1;
            this.amc = new HashSet();
        }

        class_1294(Set<Integer> var1, int var2, String var3, String var4, String var5, String var6, String var7, boolean var8, String var9, String var10, int var11) {
            this.amc = var1;
            this.field_796 = var2;
            this.anE = var3;
            this.field_799 = var4;
            this.amz = var5;
            this.anF = var6;
            this.mName = var7;
            this.anG = var8;
            this.amP = var9;
            this.field_798 = var10;
            this.field_797 = var11;
        }

        // $FF: renamed from: a (com.google.android.gms.internal.ji$a) boolean
        protected boolean method_1691(class_268.class_1299 var1) {
            return this.amc.contains(Integer.valueOf(var1.method_3882()));
        }

        // $FF: renamed from: b (com.google.android.gms.internal.ji$a) java.lang.Object
        protected Object method_1692(class_268.class_1299 var1) {
            switch(var1.method_3882()) {
                case 2:
                    return this.anE;
                case 3:
                    return this.field_799;
                case 4:
                    return this.amz;
                case 5:
                    return this.anF;
                case 6:
                    return this.mName;
                case 7:
                    return Boolean.valueOf(this.anG);
                case 8:
                    return this.amP;
                case 9:
                    return this.field_798;
                case 10:
                    return Integer.valueOf(this.field_797);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3882());
            }
        }

        public int describeContents() {
            class_917 var10000 = CREATOR;
            return 0;
        }

        public boolean equals(Object var1) {
            if(!(var1 instanceof class_272.class_1294)) {
                return false;
            } else if(this == var1) {
                return true;
            } else {
                class_272.class_1294 var2 = (class_272.class_1294)var1;
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
            return this.method_1715();
        }

        public String getDepartment() {
            return this.anE;
        }

        public String getDescription() {
            return this.field_799;
        }

        public String getEndDate() {
            return this.amz;
        }

        public String getLocation() {
            return this.anF;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.amP;
        }

        public String getTitle() {
            return this.field_798;
        }

        public int getType() {
            return this.field_797;
        }

        public boolean hasDepartment() {
            return this.amc.contains(Integer.valueOf(2));
        }

        public boolean hasDescription() {
            return this.amc.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate() {
            return this.amc.contains(Integer.valueOf(4));
        }

        public boolean hasLocation() {
            return this.amc.contains(Integer.valueOf(5));
        }

        public boolean hasName() {
            return this.amc.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary() {
            return this.amc.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate() {
            return this.amc.contains(Integer.valueOf(8));
        }

        public boolean hasTitle() {
            return this.amc.contains(Integer.valueOf(9));
        }

        public boolean hasType() {
            return this.amc.contains(Integer.valueOf(10));
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

        public boolean isPrimary() {
            return this.anG;
        }

        // $FF: renamed from: nB () com.google.android.gms.internal.nz$f
        public class_272.class_1294 method_1715() {
            return this;
        }

        public void writeToParcel(Parcel var1, int var2) {
            class_917 var10000 = CREATOR;
            class_917.method_4747(this, var1, var2);
        }
    }

    public static final class class_1295 extends class_270 implements Person.PlacesLived {
        public static final class_916 CREATOR = new class_916();
        private static final HashMap<String, class_268.class_1299<?, ?>> amb = new HashMap();
        // $FF: renamed from: BR int
        final int field_800;
        final Set<Integer> amc;
        boolean anG;
        String mValue;

        static {
            amb.put("primary", class_268.class_1299.method_3872("primary", 2));
            amb.put("value", class_268.class_1299.method_3873("value", 3));
        }

        public class_1295() {
            this.field_800 = 1;
            this.amc = new HashSet();
        }

        class_1295(Set<Integer> var1, int var2, boolean var3, String var4) {
            this.amc = var1;
            this.field_800 = var2;
            this.anG = var3;
            this.mValue = var4;
        }

        // $FF: renamed from: a (com.google.android.gms.internal.ji$a) boolean
        protected boolean method_1691(class_268.class_1299 var1) {
            return this.amc.contains(Integer.valueOf(var1.method_3882()));
        }

        // $FF: renamed from: b (com.google.android.gms.internal.ji$a) java.lang.Object
        protected Object method_1692(class_268.class_1299 var1) {
            switch(var1.method_3882()) {
                case 2:
                    return Boolean.valueOf(this.anG);
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3882());
            }
        }

        public int describeContents() {
            class_916 var10000 = CREATOR;
            return 0;
        }

        public boolean equals(Object var1) {
            if(!(var1 instanceof class_272.class_1295)) {
                return false;
            } else if(this == var1) {
                return true;
            } else {
                class_272.class_1295 var2 = (class_272.class_1295)var1;
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
            return this.method_1716();
        }

        public String getValue() {
            return this.mValue;
        }

        public boolean hasPrimary() {
            return this.amc.contains(Integer.valueOf(2));
        }

        public boolean hasValue() {
            return this.amc.contains(Integer.valueOf(3));
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

        public boolean isPrimary() {
            return this.anG;
        }

        // $FF: renamed from: nC () com.google.android.gms.internal.nz$g
        public class_272.class_1295 method_1716() {
            return this;
        }

        public void writeToParcel(Parcel var1, int var2) {
            class_916 var10000 = CREATOR;
            class_916.method_4743(this, var1, var2);
        }
    }

    public static final class class_1296 extends class_270 implements Person.Urls {
        public static final class_915 CREATOR = new class_915();
        private static final HashMap<String, class_268.class_1299<?, ?>> amb = new HashMap();
        // $FF: renamed from: BR int
        final int field_805;
        // $FF: renamed from: FD int
        int field_806;
        final Set<Integer> amc;
        String anH;
        private final int anI = 4;
        String mValue;

        static {
            amb.put("label", class_268.class_1299.method_3873("label", 5));
            amb.put("type", class_268.class_1299.method_3866("type", 6, (new class_359()).method_2382("home", 0).method_2382("work", 1).method_2382("blog", 2).method_2382("profile", 3).method_2382("other", 4).method_2382("otherProfile", 5).method_2382("contributor", 6).method_2382("website", 7), false));
            amb.put("value", class_268.class_1299.method_3873("value", 4));
        }

        public class_1296() {
            this.field_805 = 1;
            this.amc = new HashSet();
        }

        class_1296(Set<Integer> var1, int var2, String var3, int var4, String var5, int var6) {
            this.amc = var1;
            this.field_805 = var2;
            this.anH = var3;
            this.field_806 = var4;
            this.mValue = var5;
        }

        // $FF: renamed from: a (com.google.android.gms.internal.ji$a) boolean
        protected boolean method_1691(class_268.class_1299 var1) {
            return this.amc.contains(Integer.valueOf(var1.method_3882()));
        }

        // $FF: renamed from: b (com.google.android.gms.internal.ji$a) java.lang.Object
        protected Object method_1692(class_268.class_1299 var1) {
            switch(var1.method_3882()) {
                case 4:
                    return this.mValue;
                case 5:
                    return this.anH;
                case 6:
                    return Integer.valueOf(this.field_806);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + var1.method_3882());
            }
        }

        public int describeContents() {
            class_915 var10000 = CREATOR;
            return 0;
        }

        public boolean equals(Object var1) {
            if(!(var1 instanceof class_272.class_1296)) {
                return false;
            } else if(this == var1) {
                return true;
            } else {
                class_272.class_1296 var2 = (class_272.class_1296)var1;
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
            return this.method_1721();
        }

        public String getLabel() {
            return this.anH;
        }

        public int getType() {
            return this.field_806;
        }

        public String getValue() {
            return this.mValue;
        }

        public boolean hasLabel() {
            return this.amc.contains(Integer.valueOf(5));
        }

        public boolean hasType() {
            return this.amc.contains(Integer.valueOf(6));
        }

        public boolean hasValue() {
            return this.amc.contains(Integer.valueOf(4));
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

        // $FF: renamed from: nD () int
        @Deprecated
        public int method_1720() {
            return 4;
        }

        // $FF: renamed from: nE () com.google.android.gms.internal.nz$h
        public class_272.class_1296 method_1721() {
            return this;
        }

        public void writeToParcel(Parcel var1, int var2) {
            class_915 var10000 = CREATOR;
            class_915.method_4740(this, var1, var2);
        }
    }
}
