package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.class_1056;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeCreator;

public final class SnapshotMetadataChange implements SafeParcelable {
    public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
    public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChange();
    // $FF: renamed from: BR int
    private final int field_2861;
    // $FF: renamed from: Tr java.lang.String
    private final String field_2862;
    private final Long adj;
    private final Uri adk;
    private class_1056 adl;

    SnapshotMetadataChange() {
        this(4, (String)null, (Long)null, (class_1056)null, (Uri)null);
    }

    SnapshotMetadataChange(int var1, String var2, Long var3, class_1056 var4, Uri var5) {
        boolean var6 = true;
        super();
        this.field_2861 = var1;
        this.field_2862 = var2;
        this.adj = var3;
        this.adl = var4;
        this.adk = var5;
        if(this.adl != null) {
            if(this.adk != null) {
                var6 = false;
            }

            class_1090.method_5676(var6, "Cannot set both a URI and an image");
        } else if(this.adk != null) {
            if(this.adl != null) {
                var6 = false;
            }

            class_1090.method_5676(var6, "Cannot set both a URI and an image");
            return;
        }

    }

    SnapshotMetadataChange(String var1, Long var2, class_1056 var3, Uri var4) {
        this(4, var1, var2, var3, var4);
    }

    public int describeContents() {
        return 0;
    }

    public Bitmap getCoverImage() {
        return this.adl == null?null:this.adl.method_5526();
    }

    public Uri getCoverImageUri() {
        return this.adk;
    }

    public String getDescription() {
        return this.field_2862;
    }

    public Long getPlayedTimeMillis() {
        return this.adj;
    }

    public int getVersionCode() {
        return this.field_2861;
    }

    // $FF: renamed from: lM () com.google.android.gms.common.data.a
    public class_1056 method_3260() {
        return this.adl;
    }

    public void writeToParcel(Parcel var1, int var2) {
        SnapshotMetadataChangeCreator.method_5940(this, var1, var2);
    }

    public static final class Builder {
        // $FF: renamed from: Tr java.lang.String
        private String field_4669;
        private Uri adk;
        private Long adm;
        private class_1056 adn;

        public SnapshotMetadataChange build() {
            return new SnapshotMetadataChange(this.field_4669, this.adm, this.adn, this.adk);
        }

        public SnapshotMetadataChange.Builder fromMetadata(SnapshotMetadata var1) {
            this.field_4669 = var1.getDescription();
            this.adm = Long.valueOf(var1.getPlayedTime());
            if(this.adm.longValue() == -1L) {
                this.adm = null;
            }

            this.adk = var1.getCoverImageUri();
            if(this.adk != null) {
                this.adn = null;
            }

            return this;
        }

        public SnapshotMetadataChange.Builder setCoverImage(Bitmap var1) {
            this.adn = new class_1056(var1);
            this.adk = null;
            return this;
        }

        public SnapshotMetadataChange.Builder setDescription(String var1) {
            this.field_4669 = var1;
            return this;
        }

        public SnapshotMetadataChange.Builder setPlayedTimeMillis(long var1) {
            this.adm = Long.valueOf(var1);
            return this;
        }
    }
}
