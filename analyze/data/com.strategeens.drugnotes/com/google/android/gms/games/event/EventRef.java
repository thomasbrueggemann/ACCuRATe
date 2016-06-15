package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_251;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.games.event.Event;
import com.google.android.gms.games.event.EventEntity;

public final class EventRef extends class_251 implements Event {
   EventRef(DataHolder var1, int var2) {
      super(var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return EventEntity.method_5359(this, var1);
   }

   public Event freeze() {
      return new EventEntity(this);
   }

   public String getDescription() {
      return this.getString("description");
   }

   public void getDescription(CharArrayBuffer var1) {
      this.a("description", var1);
   }

   public String getEventId() {
      return this.getString("external_event_id");
   }

   public String getFormattedValue() {
      return this.getString("formatted_value");
   }

   public void getFormattedValue(CharArrayBuffer var1) {
      this.a("formatted_value", var1);
   }

   public Uri getIconImageUri() {
      return this.aR("icon_image_uri");
   }

   public String getIconImageUrl() {
      return this.getString("icon_image_url");
   }

   public String getName() {
      return this.getString("name");
   }

   public void getName(CharArrayBuffer var1) {
      this.a("name", var1);
   }

   public Player getPlayer() {
      return new PlayerRef(this.JG, this.KZ);
   }

   public long getValue() {
      return this.getLong("value");
   }

   public int hashCode() {
      return EventEntity.method_5358(this);
   }

   public boolean isVisible() {
      return this.getBoolean("visibility");
   }

   public String toString() {
      return EventEntity.method_5360(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((EventEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
