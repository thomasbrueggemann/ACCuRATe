package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.event.Event;
import com.google.android.gms.games.event.EventEntityCreator;

public final class EventEntity implements SafeParcelable, Event {
   public static final EventEntityCreator CREATOR = new EventEntityCreator();
   private final String mName;
   private final int mVersionCode;
   private final Uri zzaCd;
   private final String zzaCo;
   private final String zzaDU;
   private final long zzaDV;
   private final String zzaDW;
   private final PlayerEntity zzaDq;
   private final String zzaxl;
   private final boolean zzsj;

   EventEntity(int var1, String var2, String var3, String var4, Uri var5, String var6, Player var7, long var8, String var10, boolean var11) {
      this.mVersionCode = var1;
      this.zzaDU = var2;
      this.mName = var3;
      this.zzaxl = var4;
      this.zzaCd = var5;
      this.zzaCo = var6;
      this.zzaDq = new PlayerEntity(var7);
      this.zzaDV = var8;
      this.zzaDW = var10;
      this.zzsj = var11;
   }

   public EventEntity(Event var1) {
      this.mVersionCode = 1;
      this.zzaDU = var1.getEventId();
      this.mName = var1.getName();
      this.zzaxl = var1.getDescription();
      this.zzaCd = var1.getIconImageUri();
      this.zzaCo = var1.getIconImageUrl();
      this.zzaDq = (PlayerEntity)var1.getPlayer().freeze();
      this.zzaDV = var1.getValue();
      this.zzaDW = var1.getFormattedValue();
      this.zzsj = var1.isVisible();
   }

   static int zza(Event var0) {
      Object[] var1 = new Object[]{var0.getEventId(), var0.getName(), var0.getDescription(), var0.getIconImageUri(), var0.getIconImageUrl(), var0.getPlayer(), Long.valueOf(var0.getValue()), var0.getFormattedValue(), Boolean.valueOf(var0.isVisible())};
      return zzw.hashCode(var1);
   }

   static boolean zza(Event var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Event)) {
         var2 = false;
      } else if(var0 != var1) {
         Event var3 = (Event)var1;
         if(!zzw.equal(var3.getEventId(), var0.getEventId()) || !zzw.equal(var3.getName(), var0.getName()) || !zzw.equal(var3.getDescription(), var0.getDescription()) || !zzw.equal(var3.getIconImageUri(), var0.getIconImageUri()) || !zzw.equal(var3.getIconImageUrl(), var0.getIconImageUrl()) || !zzw.equal(var3.getPlayer(), var0.getPlayer()) || !zzw.equal(Long.valueOf(var3.getValue()), Long.valueOf(var0.getValue())) || !zzw.equal(var3.getFormattedValue(), var0.getFormattedValue()) || !zzw.equal(Boolean.valueOf(var3.isVisible()), Boolean.valueOf(var0.isVisible()))) {
            return false;
         }
      }

      return var2;
   }

   static String zzb(Event var0) {
      return zzw.zzy(var0).zzg("Id", var0.getEventId()).zzg("Name", var0.getName()).zzg("Description", var0.getDescription()).zzg("IconImageUri", var0.getIconImageUri()).zzg("IconImageUrl", var0.getIconImageUrl()).zzg("Player", var0.getPlayer()).zzg("Value", Long.valueOf(var0.getValue())).zzg("FormattedValue", var0.getFormattedValue()).zzg("isVisible", Boolean.valueOf(var0.isVisible())).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   public Event freeze() {
      return this;
   }

   public String getDescription() {
      return this.zzaxl;
   }

   public String getEventId() {
      return this.zzaDU;
   }

   public String getFormattedValue() {
      return this.zzaDW;
   }

   public Uri getIconImageUri() {
      return this.zzaCd;
   }

   public String getIconImageUrl() {
      return this.zzaCo;
   }

   public String getName() {
      return this.mName;
   }

   public Player getPlayer() {
      return this.zzaDq;
   }

   public long getValue() {
      return this.zzaDV;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      return zza(this);
   }

   public boolean isVisible() {
      return this.zzsj;
   }

   public String toString() {
      return zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      EventEntityCreator.zza(this, var1, var2);
   }
}
