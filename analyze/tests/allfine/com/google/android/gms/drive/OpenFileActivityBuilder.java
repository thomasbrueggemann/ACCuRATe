package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.class_199;
import com.google.android.gms.drive.internal.class_305;

public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    // $FF: renamed from: Nw java.lang.String
    private String field_4514;
    // $FF: renamed from: Nx java.lang.String[]
    private String[] field_4515;
    // $FF: renamed from: Ny com.google.android.gms.drive.DriveId
    private DriveId field_4516;

    public IntentSender build(GoogleApiClient var1) {
        class_1090.method_5676(var1.isConnected(), "Client must be connected");
        if(this.field_4515 == null) {
            this.field_4515 = new String[0];
        }

        class_199 var2 = ((class_305)var1.method_896(Drive.field_3554)).method_2091();

        try {
            IntentSender var4 = var2.method_1014(new OpenFileIntentSenderRequest(this.field_4514, this.field_4515, this.field_4516));
            return var4;
        } catch (RemoteException var5) {
            throw new RuntimeException("Unable to connect Drive Play Service", var5);
        }
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId var1) {
        this.field_4516 = (DriveId)class_1090.method_5685(var1);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String var1) {
        this.field_4514 = (String)class_1090.method_5685(var1);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] var1) {
        boolean var2;
        if(var1 != null) {
            var2 = true;
        } else {
            var2 = false;
        }

        class_1090.method_5683(var2, "mimeTypes may not be null");
        this.field_4515 = var1;
        return this;
    }
}
