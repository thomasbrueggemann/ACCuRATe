package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.event.Event;
import com.google.android.gms.games.event.EventEntityCreator;
import com.google.android.gms.internal.class_284;
import com.google.android.gms.internal.class_349;

public final class EventEntity implements SafeParcelable, Event {
   public static final EventEntityCreator CREATOR = new EventEntityCreator();
   // $FF: renamed from: Mm java.lang.String
   private final String field_3988;
   // $FF: renamed from: Mo android.net.Uri
   private final Uri field_3989;
   // $FF: renamed from: Mz java.lang.String
   private final String field_3990;
   // $FF: renamed from: Nf java.lang.String
   private final String field_3991;
   // $FF: renamed from: Ng com.google.android.gms.games.PlayerEntity
   private final PlayerEntity field_3992;
   // $FF: renamed from: Nh long
   private final long field_3993;
   // $FF: renamed from: Ni java.lang.String
   private final String field_3994;
   // $FF: renamed from: Nj boolean
   private final boolean field_3995;
   private final String mName;
   // $FF: renamed from: xJ int
   private final int field_3996;

   EventEntity(int var1, String var2, String var3, String var4, Uri var5, String var6, Player var7, long var8, String var10, boolean var11) {
      this.field_3996 = var1;
      this.field_3991 = var2;
      this.mName = var3;
      this.field_3988 = var4;
      this.field_3989 = var5;
      this.field_3990 = var6;
      this.field_3992 = new PlayerEntity(var7);
      this.field_3993 = var8;
      this.field_3994 = var10;
      this.field_3995 = var11;
   }

   public EventEntity(Event var1) {
      this.field_3996 = 1;
      this.field_3991 = var1.getEventId();
      this.mName = var1.getName();
      this.field_3988 = var1.getDescription();
      this.field_3989 = var1.getIconImageUri();
      this.field_3990 = var1.getIconImageUrl();
      this.field_3992 = (PlayerEntity)var1.getPlayer().freeze();
      this.field_3993 = var1.getValue();
      this.field_3994 = var1.getFormattedValue();
      this.field_3995 = var1.isVisible();
   }

   // $FF: renamed from: a (com.google.android.gms.games.event.Event) int
   static int method_4253(Event var0) {
      Object[] var1 = new Object[]{var0.getEventId(), var0.getName(), var0.getDescription(), var0.getIconImageUri(), var0.getIconImageUrl(), var0.getPlayer(), Long.valueOf(var0.getValue()), var0.getFormattedValue(), Boolean.valueOf(var0.isVisible())};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.event.Event, java.lang.Object) boolean
   static boolean method_4254(Event var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Event)) {
         var2 = false;
      } else if(var0 != var1) {
         Event var3 = (Event)var1;
         if(!class_349.equal(var3.getEventId(), var0.getEventId()) || !class_349.equal(var3.getName(), var0.getName()) || !class_349.equal(var3.getDescription(), var0.getDescription()) || !class_349.equal(var3.getIconImageUri(), var0.getIconImageUri()) || !class_349.equal(var3.getIconImageUrl(), var0.getIconImageUrl()) || !class_349.equal(var3.getPlayer(), var0.getPlayer()) || !class_349.equal(Long.valueOf(var3.getValue()), Long.valueOf(var0.getValue())) || !class_349.equal(var3.getFormattedValue(), var0.getFormattedValue()) || !class_349.equal(Boolean.valueOf(var3.isVisible()), Boolean.valueOf(var0.isVisible()))) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.event.Event) java.lang.String
   static String method_4255(Event var0) {
      return class_349.method_2174(var0).method_4301("Id", var0.getEventId()).method_4301("Name", var0.getName()).method_4301("Description", var0.getDescription()).method_4301("IconImageUri", var0.getIconImageUri()).method_4301("IconImageUrl", var0.getIconImageUrl()).method_4301("Player", var0.getPlayer()).method_4301("Value", Long.valueOf(var0.getValue())).method_4301("FormattedValue", var0.getFormattedValue()).method_4301("isVisible", Boolean.valueOf(var0.isVisible())).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_4254(this, var1);
   }

   public Event freeze() {
      return this;
   }

   public String getDescription() {
      return this.field_3988;
   }

   public void getDescription(CharArrayBuffer var1) {
      class_284.method_1876(this.field_3988, var1);
   }

   public String getEventId() {
      return this.field_3991;
   }

   public String getFormattedValue() {
      return this.field_3994;
   }

   public void getFormattedValue(CharArrayBuffer var1) {
      class_284.method_1876(this.field_3994, var1);
   }

   public Uri getIconImageUri() {
      return this.field_3989;
   }

   public String getIconImageUrl() {
      return this.field_3990;
   }

   public String getName() {
      return this.mName;
   }

   public void getName(CharArrayBuffer var1) {
      class_284.method_1876(this.mName, var1);
   }

   public Player getPlayer() {
      return this.field_3992;
   }

   public long getValue() {
      return this.field_3993;
   }

   public int getVersionCode() {
      return this.field_3996;
   }

   public int hashCode() {
      return method_4253(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public boolean isVisible() {
      return this.field_3995;
   }

   public String toString() {
      return method_4255(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      EventEntityCreator.method_4516(this, var1, var2);
   }
}
