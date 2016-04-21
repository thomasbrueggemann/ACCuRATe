package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.data.f
public class class_1126 implements Creator<DataSet> {
    // $FF: renamed from: a (com.google.android.gms.fitness.data.DataSet, android.os.Parcel, int) void
    static void method_5868(DataSet var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4309(var1, 1, var0.getDataSource(), var2, false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4309(var1, 2, var0.getDataType(), var2, false);
        class_823.method_4327(var1, 3, var0.method_5284(), false);
        class_823.method_4326(var1, 4, var0.method_5285(), false);
        class_823.method_4316(var1, 5, var0.method_5283());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bm (android.os.Parcel) com.google.android.gms.fitness.data.DataSet
    public DataSet method_5869(Parcel var1) {
        boolean var2 = false;
        ArrayList var3 = null;
        int var4 = class_824.method_4331(var1);
        ArrayList var5 = new ArrayList();
        DataType var6 = null;
        DataSource var7 = null;
        int var8 = 0;

        while(var1.dataPosition() < var4) {
            int var9 = class_824.method_4329(var1);
            switch(class_824.method_4340(var9)) {
                case 1:
                    var7 = (DataSource)class_824.method_4336(var1, var9, DataSource.CREATOR);
                    break;
                case 2:
                    var6 = (DataType)class_824.method_4336(var1, var9, DataType.CREATOR);
                    break;
                case 3:
                    class_824.method_4339(var1, var9, var5, this.getClass().getClassLoader());
                    break;
                case 4:
                    var3 = class_824.method_4343(var1, var9, DataSource.CREATOR);
                    break;
                case 5:
                    var2 = class_824.method_4344(var1, var9);
                    break;
                case 1000:
                    var8 = class_824.method_4348(var1, var9);
                    break;
                default:
                    class_824.method_4341(var1, var9);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new DataSet(var8, var7, var6, var5, var3, var2);
        }
    }

    // $FF: renamed from: cC (int) com.google.android.gms.fitness.data.DataSet[]
    public DataSet[] method_5870(int var1) {
        return new DataSet[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5869(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5870(var1);
    }
}
