package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public final class MediationAdRequest {
    // $FF: renamed from: d java.util.Date
    private final Date field_4048;
    // $FF: renamed from: e com.google.ads.AdRequest$Gender
    private final AdRequest.Gender field_4049;
    // $FF: renamed from: f java.util.Set
    private final Set<String> field_4050;
    // $FF: renamed from: g boolean
    private final boolean field_4051;
    // $FF: renamed from: h android.location.Location
    private final Location field_4052;

    public MediationAdRequest(Date var1, AdRequest.Gender var2, Set<String> var3, boolean var4, Location var5) {
        this.field_4048 = var1;
        this.field_4049 = var2;
        this.field_4050 = var3;
        this.field_4051 = var4;
        this.field_4052 = var5;
    }

    public Integer getAgeInYears() {
        if(this.field_4048 == null) {
            return null;
        } else {
            Calendar var1 = Calendar.getInstance();
            Calendar var2 = Calendar.getInstance();
            var1.setTime(this.field_4048);
            Integer var3 = Integer.valueOf(var2.get(1) - var1.get(1));
            if(var2.get(2) < var1.get(2) || var2.get(2) == var1.get(2) && var2.get(5) < var1.get(5)) {
                var3 = Integer.valueOf(-1 + var3.intValue());
            }

            return var3;
        }
    }

    public Date getBirthday() {
        return this.field_4048;
    }

    public AdRequest.Gender getGender() {
        return this.field_4049;
    }

    public Set<String> getKeywords() {
        return this.field_4050;
    }

    public Location getLocation() {
        return this.field_4052;
    }

    public boolean isTesting() {
        return this.field_4051;
    }
}
