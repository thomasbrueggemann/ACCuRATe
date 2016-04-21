package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.class_283;
import com.google.android.gms.drive.internal.class_306;
import com.google.android.gms.internal.class_344;

public class CreateFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    // $FF: renamed from: Na com.google.android.gms.drive.internal.h
    private final class_283 field_3894 = new class_283(0);
    // $FF: renamed from: Nb com.google.android.gms.drive.DriveContents
    private DriveContents field_3895;

    public IntentSender build(GoogleApiClient var1) {
        class_1090.method_5681(this.field_3895, "Must provide initial contents to CreateFileActivityBuilder.");
        boolean var3;
        if(!var1.method_898(Drive.SCOPE_FILE) && !var1.method_898(Drive.field_3555)) {
            var3 = false;
        } else {
            var3 = true;
        }

        class_1090.method_5683(var3, "The apiClient must have suitable scope to create files");
        class_344.method_2321(this.field_3895.getParcelFileDescriptor());
        this.field_3895.getContents().method_4245();
        return this.field_3894.build(var1);
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId var1) {
        this.field_3894.method_1770(var1);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String var1) {
        this.field_3894.method_1772(var1);
        return this;
    }

    @Deprecated
    public CreateFileActivityBuilder setInitialContents(Contents var1) {
        return this.setInitialDriveContents(new class_306(var1));
    }

    public CreateFileActivityBuilder setInitialDriveContents(DriveContents var1) {
        if(var1 == null) {
            throw new IllegalArgumentException("DriveContents must be provided.");
        } else if(!(var1 instanceof class_306)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if(var1.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if(var1.getContents().method_4246()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        } else {
            this.field_3894.method_1773(var1.getContents().getRequestId());
            this.field_3895 = var1;
            return this;
        }
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet var1) {
        this.field_3894.method_1771(var1);
        return this;
    }
}
