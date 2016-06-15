package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;
import com.google.android.gms.games.internal.notification.GameNotification;
import com.google.android.gms.internal.class_349;

public final class GameNotificationRef extends class_206 implements GameNotification {
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

   // $FF: renamed from: if () java.lang.String
   public String method_1363() {
      return this.getString("notification_id");
   }

   // $FF: renamed from: ig () java.lang.String
   public String method_1364() {
      return this.getString("ticker");
   }

   // $FF: renamed from: ih () java.lang.String
   public String method_1365() {
      return this.getString("coalesced_text");
   }

   // $FF: renamed from: ii () boolean
   public boolean method_1366() {
      return this.getInteger("acknowledged") > 0;
   }

   // $FF: renamed from: ij () boolean
   public boolean method_1367() {
      return this.getInteger("alert_level") == 0;
   }

   public String toString() {
      return class_349.method_2174(this).method_4301("Id", Long.valueOf(this.getId())).method_4301("NotificationId", this.method_1363()).method_4301("Type", Integer.valueOf(this.getType())).method_4301("Title", this.getTitle()).method_4301("Ticker", this.method_1364()).method_4301("Text", this.getText()).method_4301("CoalescedText", this.method_1365()).method_4301("isAcknowledged", Boolean.valueOf(this.method_1366())).method_4301("isSilent", Boolean.valueOf(this.method_1367())).toString();
   }
}
