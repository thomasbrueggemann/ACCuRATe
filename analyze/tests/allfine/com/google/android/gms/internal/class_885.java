package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_890;

// $FF: renamed from: com.google.android.gms.internal.mp
public final class class_885 implements SafeParcelable {
    public static final class_890 CREATOR = new class_890();
    public static final class_885 afC = method_4564("accounting");
    public static final class_885 afD = method_4564("airport");
    public static final class_885 afE = method_4564("amusement_park");
    public static final class_885 afF = method_4564("aquarium");
    public static final class_885 afG = method_4564("art_gallery");
    public static final class_885 afH = method_4564("atm");
    public static final class_885 afI = method_4564("bakery");
    public static final class_885 afJ = method_4564("bank");
    public static final class_885 afK = method_4564("bar");
    public static final class_885 afL = method_4564("beauty_salon");
    public static final class_885 afM = method_4564("bicycle_store");
    public static final class_885 afN = method_4564("book_store");
    public static final class_885 afO = method_4564("bowling_alley");
    public static final class_885 afP = method_4564("bus_station");
    public static final class_885 afQ = method_4564("cafe");
    public static final class_885 afR = method_4564("campground");
    public static final class_885 afS = method_4564("car_dealer");
    public static final class_885 afT = method_4564("car_rental");
    public static final class_885 afU = method_4564("car_repair");
    public static final class_885 afV = method_4564("car_wash");
    public static final class_885 afW = method_4564("casino");
    public static final class_885 afX = method_4564("cemetery");
    public static final class_885 afY = method_4564("church");
    public static final class_885 afZ = method_4564("city_hall");
    public static final class_885 agA = method_4564("insurance_agency");
    public static final class_885 agB = method_4564("jewelry_store");
    public static final class_885 agC = method_4564("laundry");
    public static final class_885 agD = method_4564("lawyer");
    public static final class_885 agE = method_4564("library");
    public static final class_885 agF = method_4564("liquor_store");
    public static final class_885 agG = method_4564("local_government_office");
    public static final class_885 agH = method_4564("locksmith");
    public static final class_885 agI = method_4564("lodging");
    public static final class_885 agJ = method_4564("meal_delivery");
    public static final class_885 agK = method_4564("meal_takeaway");
    public static final class_885 agL = method_4564("mosque");
    public static final class_885 agM = method_4564("movie_rental");
    public static final class_885 agN = method_4564("movie_theater");
    public static final class_885 agO = method_4564("moving_company");
    public static final class_885 agP = method_4564("museum");
    public static final class_885 agQ = method_4564("night_club");
    public static final class_885 agR = method_4564("painter");
    public static final class_885 agS = method_4564("park");
    public static final class_885 agT = method_4564("parking");
    public static final class_885 agU = method_4564("pet_store");
    public static final class_885 agV = method_4564("pharmacy");
    public static final class_885 agW = method_4564("physiotherapist");
    public static final class_885 agX = method_4564("place_of_worship");
    public static final class_885 agY = method_4564("plumber");
    public static final class_885 agZ = method_4564("police");
    public static final class_885 aga = method_4564("clothing_store");
    public static final class_885 agb = method_4564("convenience_store");
    public static final class_885 agc = method_4564("courthouse");
    public static final class_885 agd = method_4564("dentist");
    public static final class_885 age = method_4564("department_store");
    public static final class_885 agf = method_4564("doctor");
    public static final class_885 agg = method_4564("electrician");
    public static final class_885 agh = method_4564("electronics_store");
    public static final class_885 agi = method_4564("embassy");
    public static final class_885 agj = method_4564("establishment");
    public static final class_885 agk = method_4564("finance");
    public static final class_885 agl = method_4564("fire_station");
    public static final class_885 agm = method_4564("florist");
    public static final class_885 agn = method_4564("food");
    public static final class_885 ago = method_4564("funeral_home");
    public static final class_885 agp = method_4564("furniture_store");
    public static final class_885 agq = method_4564("gas_station");
    public static final class_885 agr = method_4564("general_contractor");
    public static final class_885 ags = method_4564("grocery_or_supermarket");
    public static final class_885 agt = method_4564("gym");
    public static final class_885 agu = method_4564("hair_care");
    public static final class_885 agv = method_4564("hardware_store");
    public static final class_885 agw = method_4564("health");
    public static final class_885 agx = method_4564("hindu_temple");
    public static final class_885 agy = method_4564("home_goods_store");
    public static final class_885 agz = method_4564("hospital");
    public static final class_885 ahA = method_4564("geocode");
    public static final class_885 ahB = method_4564("intersection");
    public static final class_885 ahC = method_4564("locality");
    public static final class_885 ahD = method_4564("natural_feature");
    public static final class_885 ahE = method_4564("neighborhood");
    public static final class_885 ahF = method_4564("political");
    public static final class_885 ahG = method_4564("point_of_interest");
    public static final class_885 ahH = method_4564("post_box");
    public static final class_885 ahI = method_4564("postal_code");
    public static final class_885 ahJ = method_4564("postal_code_prefix");
    public static final class_885 ahK = method_4564("postal_town");
    public static final class_885 ahL = method_4564("premise");
    public static final class_885 ahM = method_4564("room");
    public static final class_885 ahN = method_4564("route");
    public static final class_885 ahO = method_4564("street_address");
    public static final class_885 ahP = method_4564("sublocality");
    public static final class_885 ahQ = method_4564("sublocality_level_1");
    public static final class_885 ahR = method_4564("sublocality_level_2");
    public static final class_885 ahS = method_4564("sublocality_level_3");
    public static final class_885 ahT = method_4564("sublocality_level_4");
    public static final class_885 ahU = method_4564("sublocality_level_5");
    public static final class_885 ahV = method_4564("subpremise");
    public static final class_885 ahW = method_4564("transit_station");
    public static final class_885 ahX = method_4564("other");
    public static final class_885 aha = method_4564("post_office");
    public static final class_885 ahb = method_4564("real_estate_agency");
    public static final class_885 ahc = method_4564("restaurant");
    public static final class_885 ahd = method_4564("roofing_contractor");
    public static final class_885 ahe = method_4564("rv_park");
    public static final class_885 ahf = method_4564("school");
    public static final class_885 ahg = method_4564("shoe_store");
    public static final class_885 ahh = method_4564("shopping_mall");
    public static final class_885 ahi = method_4564("spa");
    public static final class_885 ahj = method_4564("stadium");
    public static final class_885 ahk = method_4564("storage");
    public static final class_885 ahl = method_4564("store");
    public static final class_885 ahm = method_4564("subway_station");
    public static final class_885 ahn = method_4564("synagogue");
    public static final class_885 aho = method_4564("taxi_stand");
    public static final class_885 ahp = method_4564("train_station");
    public static final class_885 ahq = method_4564("travel_agency");
    public static final class_885 ahr = method_4564("university");
    public static final class_885 ahs = method_4564("veterinary_care");
    public static final class_885 aht = method_4564("zoo");
    public static final class_885 ahu = method_4564("administrative_area_level_1");
    public static final class_885 ahv = method_4564("administrative_area_level_2");
    public static final class_885 ahw = method_4564("administrative_area_level_3");
    public static final class_885 ahx = method_4564("colloquial_area");
    public static final class_885 ahy = method_4564("country");
    public static final class_885 ahz = method_4564("floor");
    // $FF: renamed from: BR int
    final int field_4204;
    // $FF: renamed from: uO java.lang.String
    final String field_4205;

    class_885(int var1, String var2) {
        class_1090.method_5680(var2);
        this.field_4204 = var1;
        this.field_4205 = var2;
    }

    // $FF: renamed from: bZ (java.lang.String) com.google.android.gms.internal.mp
    public static class_885 method_4564(String var0) {
        return new class_885(0, var0);
    }

    public int describeContents() {
        class_890 var10000 = CREATOR;
        return 0;
    }

    public boolean equals(Object var1) {
        return var1 instanceof class_885 && this.field_4205.equals(((class_885)var1).field_4205);
    }

    public int hashCode() {
        return this.field_4205.hashCode();
    }

    public String toString() {
        return this.field_4205;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_890 var10000 = CREATOR;
        class_890.method_4573(this, var1, var2);
    }
}
