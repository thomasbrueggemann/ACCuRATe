package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.drive.internal.class_199;
import com.google.android.gms.drive.internal.class_305;

// $FF: renamed from: com.google.android.gms.drive.internal.h
public class class_283 {
    // $FF: renamed from: Nw java.lang.String
    private String field_858;
    // $FF: renamed from: Ny com.google.android.gms.drive.DriveId
    private DriveId field_859;
    // $FF: renamed from: Oi com.google.android.gms.drive.MetadataChangeSet
    protected MetadataChangeSet field_860;
    // $FF: renamed from: Oj java.lang.Integer
    private Integer field_861;
    // $FF: renamed from: Ok int
    private final int field_862;

    public class_283(int var1) {
        this.field_862 = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.drive.DriveId) void
    public void method_1770(DriveId var1) {
        this.field_859 = (DriveId)class_1090.method_5685(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.drive.MetadataChangeSet) void
    public void method_1771(MetadataChangeSet var1) {
        this.field_860 = (MetadataChangeSet)class_1090.method_5685(var1);
    }

    // $FF: renamed from: bi (java.lang.String) void
    public void method_1772(String var1) {
        this.field_858 = (String)class_1090.method_5685(var1);
    }

    // $FF: renamed from: bk (int) void
    public void method_1773(int var1) {
        this.field_861 = Integer.valueOf(var1);
    }

    public IntentSender build(GoogleApiClient var1) {
        class_1090.method_5681(this.field_860, "Must provide initial metadata to CreateFileActivityBuilder.");
        class_1090.method_5676(var1.isConnected(), "Client must be connected");
        class_305 var3 = (class_305)var1.method_896(Drive.field_3554);
        this.field_860.method_2945().setContext(var3.getContext());
        class_199 var4 = var3.method_2091();
        int var5;
        if(this.field_861 == null) {
            var5 = -1;
        } else {
            var5 = this.field_861.intValue();
        }

        try {
            IntentSender var7 = var4.method_1013(new CreateFileIntentSenderRequest(this.field_860.method_2945(), var5, this.field_858, this.field_859, this.field_862));
            return var7;
        } catch (RemoteException var8) {
            throw new RuntimeException("Unable to connect Drive Play Service", var8);
        }
    }
}
