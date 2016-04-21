package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.class_1062;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_334;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CastDevice implements SafeParcelable {
    public static final Creator<CastDevice> CREATOR = new class_1062();
    // $FF: renamed from: BR int
    private final int field_1945;
    // $FF: renamed from: ER java.lang.String
    private String field_1946;
    // $FF: renamed from: ES java.lang.String
    String field_1947;
    // $FF: renamed from: ET java.net.Inet4Address
    private Inet4Address field_1948;
    // $FF: renamed from: EU java.lang.String
    private String field_1949;
    // $FF: renamed from: EV java.lang.String
    private String field_1950;
    // $FF: renamed from: EW java.lang.String
    private String field_1951;
    // $FF: renamed from: EX int
    private int field_1952;
    // $FF: renamed from: EY java.util.List
    private List<WebImage> field_1953;
    // $FF: renamed from: EZ int
    private int field_1954;
    // $FF: renamed from: Fa int
    private int field_1955;

    private CastDevice() {
        this(3, (String)null, (String)null, (String)null, (String)null, (String)null, -1, new ArrayList(), 0, -1);
    }

    CastDevice(int var1, String var2, String var3, String var4, String var5, String var6, int var7, List<WebImage> var8, int var9, int var10) {
        this.field_1945 = var1;
        this.field_1946 = var2;
        this.field_1947 = var3;
        if(this.field_1947 != null) {
            try {
                InetAddress var12 = InetAddress.getByName(this.field_1947);
                if(var12 instanceof Inet4Address) {
                    this.field_1948 = (Inet4Address)var12;
                }
            } catch (UnknownHostException var13) {
                this.field_1948 = null;
            }
        }

        this.field_1949 = var4;
        this.field_1950 = var5;
        this.field_1951 = var6;
        this.field_1952 = var7;
        this.field_1953 = var8;
        this.field_1954 = var9;
        this.field_1955 = var10;
    }

    public static CastDevice getFromBundle(Bundle var0) {
        if(var0 == null) {
            return null;
        } else {
            var0.setClassLoader(CastDevice.class.getClassLoader());
            return (CastDevice)var0.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(var1 != this) {
            if(!(var1 instanceof CastDevice)) {
                return false;
            }

            CastDevice var2 = (CastDevice)var1;
            if(this.getDeviceId() == null) {
                if(var2.getDeviceId() != null) {
                    return false;
                }
            } else if(!class_334.method_2300(this.field_1946, var2.field_1946) || !class_334.method_2300(this.field_1948, var2.field_1948) || !class_334.method_2300(this.field_1950, var2.field_1950) || !class_334.method_2300(this.field_1949, var2.field_1949) || !class_334.method_2300(this.field_1951, var2.field_1951) || this.field_1952 != var2.field_1952 || !class_334.method_2300(this.field_1953, var2.field_1953) || this.field_1954 != var2.field_1954 || this.field_1955 != var2.field_1955) {
                return false;
            }
        }

        return true;
    }

    public int getCapabilities() {
        return this.field_1954;
    }

    public String getDeviceId() {
        return this.field_1946;
    }

    public String getDeviceVersion() {
        return this.field_1951;
    }

    public String getFriendlyName() {
        return this.field_1949;
    }

    public WebImage getIcon(int var1, int var2) {
        WebImage var3 = null;
        if(this.field_1953.isEmpty()) {
            return null;
        } else if(var1 > 0 && var2 > 0) {
            Iterator var4 = this.field_1953.iterator();

            WebImage var5;
            WebImage var6;
            for(var5 = null; var4.hasNext(); var3 = var6) {
                WebImage var9;
                label66: {
                    var6 = (WebImage)var4.next();
                    int var7 = var6.getWidth();
                    int var8 = var6.getHeight();
                    if(var7 >= var1 && var8 >= var2) {
                        if(var5 == null || var5.getWidth() > var7 && var5.getHeight() > var8) {
                            var9 = var6;
                            var6 = var3;
                            break label66;
                        }
                    } else if(var7 < var1 && var8 < var2 && (var3 == null || var3.getWidth() < var7 && var3.getHeight() < var8)) {
                        var9 = var5;
                        break label66;
                    }

                    var6 = var3;
                    var9 = var5;
                }

                var5 = var9;
            }

            if(var5 == null) {
                if(var3 != null) {
                    var5 = var3;
                } else {
                    var5 = (WebImage)this.field_1953.get(0);
                }
            }

            return var5;
        } else {
            return (WebImage)this.field_1953.get(0);
        }
    }

    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(this.field_1953);
    }

    public Inet4Address getIpAddress() {
        return this.field_1948;
    }

    public String getModelName() {
        return this.field_1950;
    }

    public int getServicePort() {
        return this.field_1952;
    }

    public int getStatus() {
        return this.field_1955;
    }

    int getVersionCode() {
        return this.field_1945;
    }

    public boolean hasIcons() {
        return !this.field_1953.isEmpty();
    }

    public int hashCode() {
        return this.field_1946 == null?0:this.field_1946.hashCode();
    }

    public boolean isSameDevice(CastDevice var1) {
        if(var1 != null) {
            if(this.getDeviceId() != null) {
                return class_334.method_2300(this.getDeviceId(), var1.getDeviceId());
            }

            if(var1.getDeviceId() == null) {
                return true;
            }
        }

        return false;
    }

    public void putInBundle(Bundle var1) {
        if(var1 != null) {
            var1.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
        }
    }

    public String toString() {
        Object[] var1 = new Object[] {this.field_1949, this.field_1946};
        return String.format("\"%s\" (%s)", var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1062.method_5556(this, var1, var2);
    }
}
