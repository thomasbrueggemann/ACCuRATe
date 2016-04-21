package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.class_192;
import com.google.android.gms.common.internal.class_291;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.c;
import com.google.android.gms.drive.events.class_813;
import com.google.android.gms.drive.internal.AddEventListenerRequest;
import com.google.android.gms.drive.internal.DisconnectRequest;
import com.google.android.gms.drive.internal.RemoveEventListenerRequest;
import com.google.android.gms.drive.internal.ab;
import com.google.android.gms.drive.internal.class_197;
import com.google.android.gms.drive.internal.class_199;
import com.google.android.gms.drive.internal.class_211;
import com.google.android.gms.drive.internal.class_277;
import com.google.android.gms.drive.internal.y;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.drive.internal.q
public class class_305 extends e<ab> {
    // $FF: renamed from: Dd java.lang.String
    private final String field_938;
    // $FF: renamed from: IM java.lang.String
    private final String field_939;
    // $FF: renamed from: OA android.os.Bundle
    private final Bundle field_940;
    // $FF: renamed from: OB boolean
    private final boolean field_941;
    // $FF: renamed from: OC com.google.android.gms.drive.DriveId
    private DriveId field_942;
    // $FF: renamed from: OD com.google.android.gms.drive.DriveId
    private DriveId field_943;
    // $FF: renamed from: OE com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks
    final GoogleApiClient.ConnectionCallbacks field_944;
    // $FF: renamed from: OF java.util.Map
    final Map<DriveId, Map<c, y>> field_945 = new HashMap();

    public class_305(Context var1, Looper var2, ClientSettings var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5, String[] var6, Bundle var7) {
        super(var1, var2, var4, var5, var6);
        this.field_938 = (String)class_1090.method_5681(var3.getAccountNameOrDefault(), "Must call Api.ClientBuilder.setAccountName()");
        this.field_939 = var3.getRealClientPackageName();
        this.field_944 = var4;
        this.field_940 = var7;
        Intent var8 = new Intent("com.google.android.gms.drive.events.HANDLE_EVENT");
        var8.setPackage(var1.getPackageName());
        List var10 = var1.getPackageManager().queryIntentServices(var8, 0);
        switch(var10.size()) {
            case 0:
                this.field_941 = false;
                return;
            case 1:
                ServiceInfo var11 = ((ResolveInfo)var10.get(0)).serviceInfo;
                if(!var11.exported) {
                    throw new IllegalStateException("Drive event service " + var11.name + " must be exported in AndroidManifest.xml");
                }

                this.field_941 = true;
                return;
            default:
                throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + var8.getAction() + " action");
        }
    }

    // $FF: renamed from: T (android.os.IBinder) com.google.android.gms.drive.internal.ab
    protected class_199 method_2086(IBinder var1) {
        return class_199.class_1152.method_1617(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.drive.DriveId, int) com.google.android.gms.common.api.PendingResult
    PendingResult<Status> method_2087(GoogleApiClient var1, final DriveId var2, final int var3) {
        class_1090.method_5683(class_813.method_4212(var3, var2), "id");
        class_1090.method_5685("eventService");
        class_1090.method_5676(this.isConnected(), "Client must be connected");
        if(!this.field_941) {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
        } else {
            return var1.method_899(new class_211.class_1699() {
                // $FF: renamed from: a (com.google.android.gms.drive.internal.q) void
                protected void method_1301(class_305 var1) throws RemoteException {
                    var1.method_2091().method_1016(new AddEventListenerRequest(var2, var3), (class_197)null, (String)null, new class_277(this));
                }
            });
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.drive.DriveId, int, com.google.android.gms.drive.events.c) com.google.android.gms.common.api.PendingResult
    PendingResult<Status> method_2088(GoogleApiClient param1, DriveId param2, int param3, c param4) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (int, android.os.IBinder, android.os.Bundle) void
    protected void method_1812(int var1, IBinder var2, Bundle var3) {
        if(var3 != null) {
            var3.setClassLoader(this.getClass().getClassLoader());
            this.field_942 = (DriveId)var3.getParcelable("com.google.android.gms.drive.root_id");
            this.field_943 = (DriveId)var3.getParcelable("com.google.android.gms.drive.appdata_id");
        }

        super.method_1812(var1, var2, var3);
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.l, com.google.android.gms.common.internal.e$e) void
    protected void method_1814(class_192 var1, class_291.class_1750 var2) throws RemoteException {
        String var3 = this.getContext().getPackageName();
        class_1090.method_5685(var2);
        class_1090.method_5685(var3);
        class_1090.method_5685(this.gR());
        Bundle var7 = new Bundle();
        if(!var3.equals(this.field_939)) {
            var7.putString("proxy_package_name", this.field_939);
        }

        var7.putAll(this.field_940);
        var1.method_965(var2, 6171000, var3, this.gR(), this.field_938, var7);
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.drive.DriveId, int) com.google.android.gms.common.api.PendingResult
    PendingResult<Status> method_2089(GoogleApiClient var1, final DriveId var2, final int var3) {
        class_1090.method_5683(class_813.method_4212(var3, var2), "id");
        class_1090.method_5685("eventService");
        class_1090.method_5676(this.isConnected(), "Client must be connected");
        return var1.method_899(new class_211.class_1699() {
            // $FF: renamed from: a (com.google.android.gms.drive.internal.q) void
            protected void method_1303(class_305 var1) throws RemoteException {
                var1.method_2091().method_1032(new RemoveEventListenerRequest(var2, var3), (class_197)null, (String)null, new class_277(this));
            }
        });
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.drive.DriveId, int, com.google.android.gms.drive.events.c) com.google.android.gms.common.api.PendingResult
    PendingResult<Status> method_2090(GoogleApiClient param1, DriveId param2, int param3, c param4) {
        // $FF: Couldn't be decompiled
    }

    public void disconnect() {
        class_199 var1 = (class_199)this.gS();
        if(var1 != null) {
            try {
                var1.method_1025(new DisconnectRequest());
            } catch (RemoteException var3) {
                ;
            }
        }

        super.disconnect();
        this.field_945.clear();
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    // $FF: renamed from: hY () com.google.android.gms.drive.internal.ab
    public class_199 method_2091() {
        return (class_199)this.gS();
    }

    // $FF: renamed from: hZ () com.google.android.gms.drive.DriveId
    public DriveId method_2092() {
        return this.field_942;
    }

    // $FF: renamed from: ia () com.google.android.gms.drive.DriveId
    public DriveId method_2093() {
        return this.field_943;
    }

    // $FF: renamed from: ib () boolean
    public boolean method_2094() {
        return this.field_941;
    }

    // $FF: renamed from: j (android.os.IBinder) android.os.IInterface
    // $FF: synthetic method
    protected IInterface method_1820(IBinder var1) {
        return this.method_2086(var1);
    }
}
