package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.zzb;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AddPlaceRequest implements SafeParcelable {
   public static final Creator<AddPlaceRequest> CREATOR = new zzb();
   private final String mName;
   final int mVersionCode;
   private final LatLng zzaPc;
   private final List<Integer> zzaPd;
   private final String zzaPe;
   private final Uri zzaPf;
   private final String zzawc;

   AddPlaceRequest(int var1, String var2, LatLng var3, String var4, List<Integer> var5, String var6, Uri var7) {
      this.mVersionCode = var1;
      this.mName = zzx.zzcM(var2);
      this.zzaPc = (LatLng)zzx.zzz(var3);
      this.zzawc = zzx.zzcM(var4);
      this.zzaPd = new ArrayList((Collection)zzx.zzz(var5));
      boolean var8;
      if(!this.zzaPd.isEmpty()) {
         var8 = true;
      } else {
         var8 = false;
      }

      boolean var9;
      label15: {
         zzx.zzb(var8, "At least one place type should be provided.");
         if(TextUtils.isEmpty(var6)) {
            var9 = false;
            if(var7 == null) {
               break label15;
            }
         }

         var9 = true;
      }

      zzx.zzb(var9, "One of phone number or URI should be provided.");
      this.zzaPe = var6;
      this.zzaPf = var7;
   }

   public int describeContents() {
      return 0;
   }

   public String getAddress() {
      return this.zzawc;
   }

   public LatLng getLatLng() {
      return this.zzaPc;
   }

   public String getName() {
      return this.mName;
   }

   @Nullable
   public String getPhoneNumber() {
      return this.zzaPe;
   }

   public List<Integer> getPlaceTypes() {
      return this.zzaPd;
   }

   @Nullable
   public Uri getWebsiteUri() {
      return this.zzaPf;
   }

   public String toString() {
      return zzw.zzy(this).zzg("name", this.mName).zzg("latLng", this.zzaPc).zzg("address", this.zzawc).zzg("placeTypes", this.zzaPd).zzg("phoneNumer", this.zzaPe).zzg("websiteUri", this.zzaPf).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
