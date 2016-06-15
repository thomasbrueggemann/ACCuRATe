package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.event.Event;
import com.google.android.gms.games.event.EventEntityCreator;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_719;

public final class EventEntity implements SafeParcelable, Event {
   public static final EventEntityCreator CREATOR = new EventEntityCreator();
   // $FF: renamed from: CK int
   private final int field_4082;
   // $FF: renamed from: UO java.lang.String
   private final String field_4083;
   // $FF: renamed from: WD android.net.Uri
   private final Uri field_4084;
   // $FF: renamed from: WO java.lang.String
   private final String field_4085;
   // $FF: renamed from: XE com.google.android.gms.games.PlayerEntity
   private final PlayerEntity field_4086;
   // $FF: renamed from: Ye java.lang.String
   private final String field_4087;
   // $FF: renamed from: Yf long
   private final long field_4088;
   // $FF: renamed from: Yg java.lang.String
   private final String field_4089;
   // $FF: renamed from: Yh boolean
   private final boolean field_4090;
   private final String mName;

   EventEntity(int var1, String var2, String var3, String var4, Uri var5, String var6, Player var7, long var8, String var10, boolean var11) {
      this.field_4082 = var1;
      this.field_4087 = var2;
      this.mName = var3;
      this.field_4083 = var4;
      this.field_4084 = var5;
      this.field_4085 = var6;
      this.field_4086 = new PlayerEntity(var7);
      this.field_4088 = var8;
      this.field_4089 = var10;
      this.field_4090 = var11;
   }

   public EventEntity(Event var1) {
      this.field_4082 = 1;
      this.field_4087 = var1.getEventId();
      this.mName = var1.getName();
      this.field_4083 = var1.getDescription();
      this.field_4084 = var1.getIconImageUri();
      this.field_4085 = var1.getIconImageUrl();
      this.field_4086 = (PlayerEntity)var1.getPlayer().freeze();
      this.field_4088 = var1.getValue();
      this.field_4089 = var1.getFormattedValue();
      this.field_4090 = var1.isVisible();
   }

   // $FF: renamed from: a (com.google.android.gms.games.event.Event) int
   static int method_5358(Event var0) {
      Object[] var1 = new Object[]{var0.getEventId(), var0.getName(), var0.getDescription(), var0.getIconImageUri(), var0.getIconImageUrl(), var0.getPlayer(), Long.valueOf(var0.getValue()), var0.getFormattedValue(), Boolean.valueOf(var0.isVisible())};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.event.Event, java.lang.Object) boolean
   static boolean method_5359(Event var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Event)) {
         var2 = false;
      } else if(var0 != var1) {
         Event var3 = (Event)var1;
         if(!class_336.equal(var3.getEventId(), var0.getEventId()) || !class_336.equal(var3.getName(), var0.getName()) || !class_336.equal(var3.getDescription(), var0.getDescription()) || !class_336.equal(var3.getIconImageUri(), var0.getIconImageUri()) || !class_336.equal(var3.getIconImageUrl(), var0.getIconImageUrl()) || !class_336.equal(var3.getPlayer(), var0.getPlayer()) || !class_336.equal(Long.valueOf(var3.getValue()), Long.valueOf(var0.getValue())) || !class_336.equal(var3.getFormattedValue(), var0.getFormattedValue()) || !class_336.equal(Boolean.valueOf(var3.isVisible()), Boolean.valueOf(var0.isVisible()))) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.event.Event) java.lang.String
   static String method_5360(Event var0) {
      return class_336.method_2312(var0).method_3424("Id", var0.getEventId()).method_3424("Name", var0.getName()).method_3424("Description", var0.getDescription()).method_3424("IconImageUri", var0.getIconImageUri()).method_3424("IconImageUrl", var0.getIconImageUrl()).method_3424("Player", var0.getPlayer()).method_3424("Value", Long.valueOf(var0.getValue())).method_3424("FormattedValue", var0.getFormattedValue()).method_3424("isVisible", Boolean.valueOf(var0.isVisible())).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_5359(this, var1);
   }

   public Event freeze() {
      return this;
   }

   public String getDescription() {
      return this.field_4083;
   }

   public void getDescription(CharArrayBuffer var1) {
      class_719.method_4197(this.field_4083, var1);
   }

   public String getEventId() {
      return this.field_4087;
   }

   public String getFormattedValue() {
      return this.field_4089;
   }

   public void getFormattedValue(CharArrayBuffer var1) {
      class_719.method_4197(this.field_4089, var1);
   }

   public Uri getIconImageUri() {
      return this.field_4084;
   }

   public String getIconImageUrl() {
      return this.field_4085;
   }

   public String getName() {
      return this.mName;
   }

   public void getName(CharArrayBuffer var1) {
      class_719.method_4197(this.mName, var1);
   }

   public Player getPlayer() {
      return this.field_4086;
   }

   public long getValue() {
      return this.field_4088;
   }

   public int getVersionCode() {
      return this.field_4082;
   }

   public int hashCode() {
      return method_5358(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public boolean isVisible() {
      return this.field_4090;
   }

   public String toString() {
      return method_5360(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      EventEntityCreator.method_5782(this, var1, var2);
   }
}
