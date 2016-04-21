package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_255;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.games.internal.notification.GameNotification;

public final class GameNotificationRef extends class_255 implements GameNotification {
    GameNotificationRef(DataHolder var1, int var2) {
        super(var1, var2);
    }

    public long getId() {
        return this.getLong("_id");
    }

    public String getText() {
        return this.getString("text");
    }

    public String getTitle() {
        return this.getString("title");
    }

    public int getType() {
        return this.getInteger("type");
    }

    // $FF: renamed from: lk () java.lang.String
    public String method_1662() {
        return this.getString("notification_id");
    }

    // $FF: renamed from: ll () java.lang.String
    public String method_1663() {
        return this.getString("ticker");
    }

    // $FF: renamed from: lm () java.lang.String
    public String method_1664() {
        return this.getString("coalesced_text");
    }

    // $FF: renamed from: ln () boolean
    public boolean method_1665() {
        return this.getInteger("acknowledged") > 0;
    }

    // $FF: renamed from: lo () boolean
    public boolean method_1666() {
        return this.getInteger("alert_level") == 0;
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("Id", Long.valueOf(this.getId())).method_5425("NotificationId", this.method_1662()).method_5425("Type", Integer.valueOf(this.getType())).method_5425("Title", this.getTitle()).method_5425("Ticker", this.method_1663()).method_5425("Text", this.getText()).method_5425("CoalescedText", this.method_1664()).method_5425("isAcknowledged", Boolean.valueOf(this.method_1665())).method_5425("isSilent", Boolean.valueOf(this.method_1666())).toString();
    }
}
