package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.class_592;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileOverlayOptionsCreator;
import com.google.android.gms.maps.model.TileProvider;
import com.google.android.gms.maps.model.class_686;
import com.google.android.gms.maps.model.internal.class_54;

public final class TileOverlayOptions implements SafeParcelable {
   public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
   private float aau;
   private boolean aav = true;
   private class_54 aba;
   private TileProvider abb;
   private boolean abc = true;
   // $FF: renamed from: xJ int
   private final int field_3263;

   public TileOverlayOptions() {
      this.field_3263 = 1;
   }

   TileOverlayOptions(int var1, IBinder var2, boolean var3, float var4, boolean var5) {
      this.field_3263 = var1;
      this.aba = class_54.class_1319.method_2709(var2);
      TileProvider var6;
      if(this.aba == null) {
         var6 = null;
      } else {
         var6 = new TileProvider() {
            private final class_54 abd;

            {
               this.abd = TileOverlayOptions.this.aba;
            }

            public Tile getTile(int var1, int var2, int var3) {
               try {
                  Tile var5 = this.abd.getTile(var1, var2, var3);
                  return var5;
               } catch (RemoteException var6) {
                  return null;
               }
            }
         };
      }

      this.abb = var6;
      this.aav = var3;
      this.aau = var4;
      this.abc = var5;
   }

   public int describeContents() {
      return 0;
   }

   public TileOverlayOptions fadeIn(boolean var1) {
      this.abc = var1;
      return this;
   }

   public boolean getFadeIn() {
      return this.abc;
   }

   public TileProvider getTileProvider() {
      return this.abb;
   }

   int getVersionCode() {
      return this.field_3263;
   }

   public float getZIndex() {
      return this.aau;
   }

   public boolean isVisible() {
      return this.aav;
   }

   // $FF: renamed from: jL () android.os.IBinder
   IBinder method_3458() {
      return this.aba.asBinder();
   }

   public TileOverlayOptions tileProvider(final TileProvider var1) {
      this.abb = var1;
      class_54.class_1319 var2;
      if(this.abb == null) {
         var2 = null;
      } else {
         var2 = new class_54.class_1319() {
            public Tile getTile(int var1x, int var2, int var3) {
               return var1.getTile(var1x, var2, var3);
            }
         };
      }

      this.aba = var2;
      return this;
   }

   public TileOverlayOptions visible(boolean var1) {
      this.aav = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(class_592.method_3332()) {
         class_686.method_4002(this, var1, var2);
      } else {
         TileOverlayOptionsCreator.method_2010(this, var1, var2);
      }
   }

   public TileOverlayOptions zIndex(float var1) {
      this.aau = var1;
      return this;
   }
}
