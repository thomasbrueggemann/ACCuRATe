package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.class_730;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@Deprecated
public class Contents implements SafeParcelable {
    public static final Creator<Contents> CREATOR = new class_730();
    // $FF: renamed from: BR int
    final int field_3913;
    // $FF: renamed from: KE android.os.ParcelFileDescriptor
    final ParcelFileDescriptor field_3914;
    // $FF: renamed from: MV int
    final int field_3915;
    // $FF: renamed from: MW com.google.android.gms.drive.DriveId
    final DriveId field_3916;
    // $FF: renamed from: MX boolean
    final boolean field_3917;
    // $FF: renamed from: MY boolean
    private boolean field_3918 = false;
    // $FF: renamed from: MZ boolean
    private boolean field_3919 = false;
    private boolean mClosed = false;
    // $FF: renamed from: uQ int
    final int field_3920;

    Contents(int var1, ParcelFileDescriptor var2, int var3, int var4, DriveId var5, boolean var6) {
        this.field_3913 = var1;
        this.field_3914 = var2;
        this.field_3920 = var3;
        this.field_3915 = var4;
        this.field_3916 = var5;
        this.field_3917 = var6;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.field_3916;
    }

    public InputStream getInputStream() {
        if(this.mClosed) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        } else if(this.field_3915 != 268435456) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        } else if(this.field_3918) {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        } else {
            this.field_3918 = true;
            return new FileInputStream(this.field_3914.getFileDescriptor());
        }
    }

    public int getMode() {
        return this.field_3915;
    }

    public OutputStream getOutputStream() {
        if(this.mClosed) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        } else if(this.field_3915 != 536870912) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        } else if(this.field_3919) {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        } else {
            this.field_3919 = true;
            return new FileOutputStream(this.field_3914.getFileDescriptor());
        }
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        if(this.mClosed) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        } else {
            return this.field_3914;
        }
    }

    public int getRequestId() {
        return this.field_3920;
    }

    // $FF: renamed from: hJ () void
    public void method_4245() {
        this.mClosed = true;
    }

    // $FF: renamed from: hK () boolean
    public boolean method_4246() {
        return this.mClosed;
    }

    // $FF: renamed from: hL () boolean
    public boolean method_4247() {
        return this.field_3917;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_730.method_3963(this, var1, var2);
    }
}
