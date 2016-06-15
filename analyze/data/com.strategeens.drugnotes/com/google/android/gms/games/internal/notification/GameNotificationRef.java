package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_251;
import com.google.android.gms.games.internal.notification.GameNotification;
import com.google.android.gms.internal.class_336;

public final class GameNotificationRef extends class_251 implements GameNotification {
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

   // $FF: renamed from: mr () java.lang.String
   public String method_1670() {
      return this.getString("notification_id");
   }

   // $FF: renamed from: ms () java.lang.String
   public String method_1671() {
      return this.getString("ticker");
   }

   // $FF: renamed from: mt () java.lang.String
   public String method_1672() {
      return this.getString("coalesced_text");
   }

   // $FF: renamed from: mu () boolean
   public boolean method_1673() {
      return this.getInteger("acknowledged") > 0;
   }

   // $FF: renamed from: mv () boolean
   public boolean method_1674() {
      return this.getInteger("alert_level") == 0;
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("Id", Long.valueOf(this.getId())).method_3424("NotificationId", this.method_1670()).method_3424("Type", Integer.valueOf(this.getType())).method_3424("Title", this.getTitle()).method_3424("Ticker", this.method_1671()).method_3424("Text", this.getText()).method_3424("CoalescedText", this.method_1672()).method_3424("isAcknowledged", Boolean.valueOf(this.method_1673())).method_3424("isSilent", Boolean.valueOf(this.method_1674())).toString();
   }
}
