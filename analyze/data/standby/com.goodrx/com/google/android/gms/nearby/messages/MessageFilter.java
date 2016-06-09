package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.zzb;
import com.google.android.gms.nearby.messages.devices.NearbyDeviceFilter;
import com.google.android.gms.nearby.messages.internal.MessageType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageFilter implements SafeParcelable {
   public static final Creator<MessageFilter> CREATOR = new zzb();
   public static final MessageFilter INCLUDE_ALL_MY_TYPES = (new MessageFilter.Builder()).includeAllMyTypes().build();
   final int mVersionCode;
   private final List<MessageType> zzbbB;
   private final List<NearbyDeviceFilter> zzbbC;
   private final boolean zzbbD;

   MessageFilter(int var1, List<MessageType> var2, List<NearbyDeviceFilter> var3, boolean var4) {
      this.mVersionCode = var1;
      this.zzbbB = Collections.unmodifiableList((List)zzx.zzz(var2));
      this.zzbbD = var4;
      if(var3 == null) {
         var3 = Collections.emptyList();
      }

      this.zzbbC = Collections.unmodifiableList(var3);
   }

   private MessageFilter(List<MessageType> var1, List<NearbyDeviceFilter> var2, boolean var3) {
      this(1, var1, var2, var3);
   }

   // $FF: synthetic method
   MessageFilter(List var1, List var2, boolean var3, Object var4) {
      this(var1, var2, var3);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof MessageFilter)) {
            return false;
         }

         MessageFilter var2 = (MessageFilter)var1;
         if(this.zzbbD != var2.zzbbD || !zzw.equal(this.zzbbB, var2.zzbbB) || !zzw.equal(this.zzbbC, var2.zzbbC)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzbbB, this.zzbbC, Boolean.valueOf(this.zzbbD)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return "MessageFilter{includeAllMyTypes=" + this.zzbbD + ", messageTypes=" + this.zzbbB + "}";
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }

   List<MessageType> zzEo() {
      return this.zzbbB;
   }

   boolean zzEp() {
      return this.zzbbD;
   }

   List<NearbyDeviceFilter> zzEq() {
      return this.zzbbC;
   }

   public static final class Builder {
      private final List<NearbyDeviceFilter> zzbbC = new ArrayList();
      private boolean zzbbD;
      private final List<MessageType> zzbbE = new ArrayList();

      public MessageFilter build() {
         boolean var1;
         if(!this.zzbbD && this.zzbbE.isEmpty()) {
            var1 = false;
         } else {
            var1 = true;
         }

         zzx.zza(var1, "At least one of the include methods must be called.");
         return new MessageFilter(this.zzbbE, this.zzbbC, this.zzbbD);
      }

      public MessageFilter.Builder includeAllMyTypes() {
         this.zzbbD = true;
         return this;
      }
   }
}
