package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_348;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.CommonWalletObject;
import com.google.android.gms.wallet.wobs.class_703;
import com.google.android.gms.wallet.wobs.class_705;
import com.google.android.gms.wallet.wobs.class_707;
import com.google.android.gms.wallet.wobs.class_709;
import com.google.android.gms.wallet.wobs.class_711;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.wallet.wobs.a
public class class_704 implements Creator<CommonWalletObject> {
    // $FF: renamed from: a (com.google.android.gms.wallet.wobs.CommonWalletObject, android.os.Parcel, int) void
    static void method_3845(CommonWalletObject var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.field_5285, false);
        class_823.method_4313(var1, 3, var0.ata, false);
        class_823.method_4313(var1, 4, var0.name, false);
        class_823.method_4313(var1, 5, var0.asU, false);
        class_823.method_4313(var1, 6, var0.asW, false);
        class_823.method_4313(var1, 7, var0.asX, false);
        class_823.method_4313(var1, 8, var0.asY, false);
        class_823.method_4313(var1, 9, var0.asZ, false);
        class_823.method_4325(var1, 10, var0.state);
        class_823.method_4326(var1, 11, var0.atb, false);
        class_823.method_4309(var1, 12, var0.atc, var2, false);
        class_823.method_4326(var1, 13, var0.atd, false);
        class_823.method_4313(var1, 14, var0.ate, false);
        class_823.method_4313(var1, 15, var0.atf, false);
        class_823.method_4316(var1, 17, var0.ath);
        class_823.method_4326(var1, 16, var0.atg, false);
        class_823.method_4326(var1, 19, var0.atj, false);
        class_823.method_4326(var1, 18, var0.ati, false);
        class_823.method_4326(var1, 20, var0.atk, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3846(var1);
    }

    // $FF: renamed from: dG (android.os.Parcel) com.google.android.gms.wallet.wobs.CommonWalletObject
    public CommonWalletObject method_3846(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        String var4 = null;
        String var5 = null;
        String var6 = null;
        String var7 = null;
        String var8 = null;
        String var9 = null;
        String var10 = null;
        String var11 = null;
        int var12 = 0;
        ArrayList var13 = class_348.method_2342();
        class_711 var14 = null;
        ArrayList var15 = class_348.method_2342();
        String var16 = null;
        String var17 = null;
        ArrayList var18 = class_348.method_2342();
        boolean var19 = false;
        ArrayList var20 = class_348.method_2342();
        ArrayList var21 = class_348.method_2342();
        ArrayList var22 = class_348.method_2342();

        while(var1.dataPosition() < var2) {
            int var23 = class_824.method_4329(var1);
            switch(class_824.method_4340(var23)) {
                case 1:
                    var3 = class_824.method_4348(var1, var23);
                    break;
                case 2:
                    var4 = class_824.method_4356(var1, var23);
                    break;
                case 3:
                    var5 = class_824.method_4356(var1, var23);
                    break;
                case 4:
                    var6 = class_824.method_4356(var1, var23);
                    break;
                case 5:
                    var7 = class_824.method_4356(var1, var23);
                    break;
                case 6:
                    var8 = class_824.method_4356(var1, var23);
                    break;
                case 7:
                    var9 = class_824.method_4356(var1, var23);
                    break;
                case 8:
                    var10 = class_824.method_4356(var1, var23);
                    break;
                case 9:
                    var11 = class_824.method_4356(var1, var23);
                    break;
                case 10:
                    var12 = class_824.method_4348(var1, var23);
                    break;
                case 11:
                    var13 = class_824.method_4343(var1, var23, class_707.CREATOR);
                    break;
                case 12:
                    var14 = (class_711)class_824.method_4336(var1, var23, class_711.CREATOR);
                    break;
                case 13:
                    var15 = class_824.method_4343(var1, var23, LatLng.CREATOR);
                    break;
                case 14:
                    var16 = class_824.method_4356(var1, var23);
                    break;
                case 15:
                    var17 = class_824.method_4356(var1, var23);
                    break;
                case 16:
                    var18 = class_824.method_4343(var1, var23, class_703.CREATOR);
                    break;
                case 17:
                    var19 = class_824.method_4344(var1, var23);
                    break;
                case 18:
                    var20 = class_824.method_4343(var1, var23, class_705.CREATOR);
                    break;
                case 19:
                    var21 = class_824.method_4343(var1, var23, class_709.CREATOR);
                    break;
                case 20:
                    var22 = class_824.method_4343(var1, var23, class_705.CREATOR);
                    break;
                default:
                    class_824.method_4341(var1, var23);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new CommonWalletObject(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22);
        }
    }

    // $FF: renamed from: fJ (int) com.google.android.gms.wallet.wobs.CommonWalletObject[]
    public CommonWalletObject[] method_3847(int var1) {
        return new CommonWalletObject[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3847(var1);
    }
}
