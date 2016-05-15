package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.games.event.Event;
import com.google.android.gms.games.event.EventEntity;

public final class EventRef extends zzc implements Event {
   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return EventEntity.zza(this, var1);
   }

   public Event freeze() {
      return new EventEntity(this);
   }

   public String getDescription() {
      return this.getString("description");
   }

   public String getEventId() {
      return this.getString("external_event_id");
   }

   public String getFormattedValue() {
      return this.getString("formatted_value");
   }

   public Uri getIconImageUri() {
      return this.zzcA("icon_image_uri");
   }

   public String getIconImageUrl() {
      return this.getString("icon_image_url");
   }

   public String getName() {
      return this.getString("name");
   }

   public Player getPlayer() {
      return new PlayerRef(this.zzahi, this.zzaje);
   }

   public long getValue() {
      return this.getLong("value");
   }

   public int hashCode() {
      return EventEntity.zza(this);
   }

   public boolean isVisible() {
      return this.getBoolean("visibility");
   }

   public String toString() {
      return EventEntity.zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((EventEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
