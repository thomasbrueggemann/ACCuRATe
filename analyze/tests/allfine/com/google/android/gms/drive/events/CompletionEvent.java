package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ResourceEvent;
import com.google.android.gms.drive.events.class_812;
import com.google.android.gms.drive.internal.class_196;
import com.google.android.gms.drive.internal.class_266;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.class_344;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent implements SafeParcelable, ResourceEvent {
    public static final Creator<CompletionEvent> CREATOR = new class_812();
    public static final int STATUS_CONFLICT = 2;
    public static final int STATUS_FAILURE = 1;
    public static final int STATUS_SUCCESS;
    // $FF: renamed from: BR int
    final int field_706;
    // $FF: renamed from: Dd java.lang.String
    final String field_707;
    // $FF: renamed from: Fa int
    final int field_708;
    // $FF: renamed from: MW com.google.android.gms.drive.DriveId
    final DriveId field_709;
    // $FF: renamed from: NN android.os.ParcelFileDescriptor
    final ParcelFileDescriptor field_710;
    // $FF: renamed from: NO android.os.ParcelFileDescriptor
    final ParcelFileDescriptor field_711;
    // $FF: renamed from: NP com.google.android.gms.drive.metadata.internal.MetadataBundle
    final MetadataBundle field_712;
    // $FF: renamed from: NQ java.util.ArrayList
    final ArrayList<String> field_713;
    // $FF: renamed from: NR android.os.IBinder
    final IBinder field_714;
    // $FF: renamed from: NS boolean
    private boolean field_715 = false;
    // $FF: renamed from: NT boolean
    private boolean field_716 = false;
    // $FF: renamed from: NU boolean
    private boolean field_717 = false;

    CompletionEvent(int var1, DriveId var2, String var3, ParcelFileDescriptor var4, ParcelFileDescriptor var5, MetadataBundle var6, ArrayList<String> var7, int var8, IBinder var9) {
        this.field_706 = var1;
        this.field_709 = var2;
        this.field_707 = var3;
        this.field_710 = var4;
        this.field_711 = var5;
        this.field_712 = var6;
        this.field_713 = var7;
        this.field_708 = var8;
        this.field_714 = var9;
    }

    // $FF: renamed from: L (boolean) void
    private void method_1628(boolean var1) {
        this.method_1629();
        this.field_717 = true;
        class_344.method_2321(this.field_710);
        class_344.method_2321(this.field_711);
        if(this.field_714 == null) {
            StringBuilder var5 = (new StringBuilder()).append("No callback on ");
            String var6;
            if(var1) {
                var6 = "snooze";
            } else {
                var6 = "dismiss";
            }

            class_266.method_1687("CompletionEvent", var5.append(var6).toString());
        } else {
            try {
                class_196.class_1303.method_5958(this.field_714).method_999(var1);
            } catch (RemoteException var7) {
                StringBuilder var3 = (new StringBuilder()).append("RemoteException on ");
                String var4;
                if(var1) {
                    var4 = "snooze";
                } else {
                    var4 = "dismiss";
                }

                class_266.method_1687("CompletionEvent", var3.append(var4).append(": ").append(var7).toString());
            }
        }
    }

    // $FF: renamed from: hU () void
    private void method_1629() {
        if(this.field_717) {
            throw new IllegalStateException("Event has already been dismissed or snoozed.");
        }
    }

    public int describeContents() {
        return 0;
    }

    public void dismiss() {
        this.method_1628(false);
    }

    public String getAccountName() {
        this.method_1629();
        return this.field_707;
    }

    public InputStream getBaseContentsInputStream() {
        this.method_1629();
        if(this.field_710 == null) {
            return null;
        } else if(this.field_715) {
            throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
        } else {
            this.field_715 = true;
            return new FileInputStream(this.field_710.getFileDescriptor());
        }
    }

    public DriveId getDriveId() {
        this.method_1629();
        return this.field_709;
    }

    public InputStream getModifiedContentsInputStream() {
        this.method_1629();
        if(this.field_711 == null) {
            return null;
        } else if(this.field_716) {
            throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
        } else {
            this.field_716 = true;
            return new FileInputStream(this.field_711.getFileDescriptor());
        }
    }

    public MetadataChangeSet getModifiedMetadataChangeSet() {
        this.method_1629();
        return this.field_712 != null?new MetadataChangeSet(this.field_712):null;
    }

    public int getStatus() {
        this.method_1629();
        return this.field_708;
    }

    public List<String> getTrackingTags() {
        this.method_1629();
        return new ArrayList(this.field_713);
    }

    public int getType() {
        return 2;
    }

    public void snooze() {
        this.method_1628(true);
    }

    public String toString() {
        String var1;
        if(this.field_713 == null) {
            var1 = "<null>";
        } else {
            var1 = "\'" + TextUtils.join("\',\'", this.field_713) + "\'";
        }

        Locale var2 = Locale.US;
        Object[] var3 = new Object[] {this.field_709, Integer.valueOf(this.field_708), var1};
        return String.format(var2, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", var3);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_812.method_4209(this, var1, var2);
    }
}
