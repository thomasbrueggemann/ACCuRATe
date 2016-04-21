package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.internal.class_285;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileRequest implements SafeParcelable {
    public static final Creator<CreateFileRequest> CREATOR = new class_285();
    // $FF: renamed from: BR int
    final int field_4613;
    // $FF: renamed from: Nn java.lang.String
    final String field_4614;
    // $FF: renamed from: Of com.google.android.gms.drive.Contents
    final Contents field_4615;
    // $FF: renamed from: Ol com.google.android.gms.drive.metadata.internal.MetadataBundle
    final MetadataBundle field_4616;
    // $FF: renamed from: Om java.lang.Integer
    final Integer field_4617;
    // $FF: renamed from: On com.google.android.gms.drive.DriveId
    final DriveId field_4618;
    // $FF: renamed from: Oo boolean
    final boolean field_4619;
    // $FF: renamed from: Op int
    final int field_4620;
    // $FF: renamed from: Oq int
    final int field_4621;

    CreateFileRequest(int var1, DriveId var2, MetadataBundle var3, Contents var4, Integer var5, boolean var6, String var7, int var8, int var9) {
        if(var4 != null && var9 != 0) {
            boolean var10;
            if(var4.getRequestId() == var9) {
                var10 = true;
            } else {
                var10 = false;
            }

            class_1090.method_5683(var10, "inconsistent contents reference");
        }

        if((var5 == null || var5.intValue() == 0) && var4 == null && var9 == 0) {
            throw new IllegalArgumentException("Need a valid contents");
        } else {
            this.field_4613 = var1;
            this.field_4618 = (DriveId)class_1090.method_5685(var2);
            this.field_4616 = (MetadataBundle)class_1090.method_5685(var3);
            this.field_4615 = var4;
            this.field_4617 = var5;
            this.field_4614 = var7;
            this.field_4620 = var8;
            this.field_4619 = var6;
            this.field_4621 = var9;
        }
    }

    public CreateFileRequest(DriveId var1, MetadataBundle var2, int var3, int var4, ExecutionOptions var5) {
        this(2, var1, var2, (Contents)null, Integer.valueOf(var4), var5.method_4486(), var5.method_4485(), var5.method_4487(), var3);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_285.method_1777(this, var1, var2);
    }
}
