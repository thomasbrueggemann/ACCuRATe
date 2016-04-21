package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.event.Event;
import com.google.android.gms.games.event.EventEntityCreator;
import com.google.android.gms.internal.class_345;

public final class EventEntity implements SafeParcelable, Event {
    public static final EventEntityCreator CREATOR = new EventEntityCreator();
    // $FF: renamed from: BR int
    private final int field_4867;
    // $FF: renamed from: Tr java.lang.String
    private final String field_4868;
    // $FF: renamed from: Vh android.net.Uri
    private final Uri field_4869;
    // $FF: renamed from: Vs java.lang.String
    private final String field_4870;
    // $FF: renamed from: Wh com.google.android.gms.games.PlayerEntity
    private final PlayerEntity field_4871;
    // $FF: renamed from: Wm java.lang.String
    private final String field_4872;
    // $FF: renamed from: Wn long
    private final long field_4873;
    // $FF: renamed from: Wo java.lang.String
    private final String field_4874;
    // $FF: renamed from: Wp boolean
    private final boolean field_4875;
    private final String mName;

    EventEntity(int var1, String var2, String var3, String var4, Uri var5, String var6, Player var7, long var8, String var10, boolean var11) {
        this.field_4867 = var1;
        this.field_4872 = var2;
        this.mName = var3;
        this.field_4868 = var4;
        this.field_4869 = var5;
        this.field_4870 = var6;
        this.field_4871 = new PlayerEntity(var7);
        this.field_4873 = var8;
        this.field_4874 = var10;
        this.field_4875 = var11;
    }

    public EventEntity(Event var1) {
        this.field_4867 = 1;
        this.field_4872 = var1.getEventId();
        this.mName = var1.getName();
        this.field_4868 = var1.getDescription();
        this.field_4869 = var1.getIconImageUri();
        this.field_4870 = var1.getIconImageUrl();
        this.field_4871 = (PlayerEntity)var1.getPlayer().freeze();
        this.field_4873 = var1.getValue();
        this.field_4874 = var1.getFormattedValue();
        this.field_4875 = var1.isVisible();
    }

    // $FF: renamed from: a (com.google.android.gms.games.event.Event) int
    static int method_5475(Event var0) {
        Object[] var1 = new Object[] {var0.getEventId(), var0.getName(), var0.getDescription(), var0.getIconImageUri(), var0.getIconImageUrl(), var0.getPlayer(), Long.valueOf(var0.getValue()), var0.getFormattedValue(), Boolean.valueOf(var0.isVisible())};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.games.event.Event, java.lang.Object) boolean
    static boolean method_5476(Event var0, Object var1) {
        boolean var2 = true;
        if(!(var1 instanceof Event)) {
            var2 = false;
        } else if(var0 != var1) {
            Event var3 = (Event)var1;
            if(!class_1089.equal(var3.getEventId(), var0.getEventId()) || !class_1089.equal(var3.getName(), var0.getName()) || !class_1089.equal(var3.getDescription(), var0.getDescription()) || !class_1089.equal(var3.getIconImageUri(), var0.getIconImageUri()) || !class_1089.equal(var3.getIconImageUrl(), var0.getIconImageUrl()) || !class_1089.equal(var3.getPlayer(), var0.getPlayer()) || !class_1089.equal(Long.valueOf(var3.getValue()), Long.valueOf(var0.getValue())) || !class_1089.equal(var3.getFormattedValue(), var0.getFormattedValue()) || !class_1089.equal(Boolean.valueOf(var3.isVisible()), Boolean.valueOf(var0.isVisible()))) {
                return false;
            }
        }

        return var2;
    }

    // $FF: renamed from: b (com.google.android.gms.games.event.Event) java.lang.String
    static String method_5477(Event var0) {
        return class_1089.method_5673(var0).method_5425("Id", var0.getEventId()).method_5425("Name", var0.getName()).method_5425("Description", var0.getDescription()).method_5425("IconImageUri", var0.getIconImageUri()).method_5425("IconImageUrl", var0.getIconImageUrl()).method_5425("Player", var0.getPlayer()).method_5425("Value", Long.valueOf(var0.getValue())).method_5425("FormattedValue", var0.getFormattedValue()).method_5425("isVisible", Boolean.valueOf(var0.isVisible())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return method_5476(this, var1);
    }

    public Event freeze() {
        return this;
    }

    public String getDescription() {
        return this.field_4868;
    }

    public void getDescription(CharArrayBuffer var1) {
        class_345.method_2325(this.field_4868, var1);
    }

    public String getEventId() {
        return this.field_4872;
    }

    public String getFormattedValue() {
        return this.field_4874;
    }

    public void getFormattedValue(CharArrayBuffer var1) {
        class_345.method_2325(this.field_4874, var1);
    }

    public Uri getIconImageUri() {
        return this.field_4869;
    }

    public String getIconImageUrl() {
        return this.field_4870;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer var1) {
        class_345.method_2325(this.mName, var1);
    }

    public Player getPlayer() {
        return this.field_4871;
    }

    public long getValue() {
        return this.field_4873;
    }

    public int getVersionCode() {
        return this.field_4867;
    }

    public int hashCode() {
        return method_5475(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isVisible() {
        return this.field_4875;
    }

    public String toString() {
        return method_5477(this);
    }

    public void writeToParcel(Parcel var1, int var2) {
        EventEntityCreator.method_5948(this, var1, var2);
    }
}
