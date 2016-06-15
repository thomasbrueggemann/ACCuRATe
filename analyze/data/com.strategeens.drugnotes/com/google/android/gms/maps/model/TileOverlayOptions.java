package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.class_1056;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import com.google.android.gms.maps.model.class_880;
import com.google.android.gms.maps.model.class_884;
import com.google.android.gms.maps.model.internal.class_58;

public final class TileOverlayOptions implements SafeParcelable {
   public static final class_884 CREATOR = new class_884();
   // $FF: renamed from: CK int
   private final int field_3214;
   private float alX;
   private boolean alY = true;
   private class_58 amD;
   private TileProvider amE;
   private boolean amF = true;

   public TileOverlayOptions() {
      this.field_3214 = 1;
   }

   TileOverlayOptions(int var1, IBinder var2, boolean var3, float var4, boolean var5) {
      this.field_3214 = var1;
      this.amD = class_58.class_1563.method_3092(var2);
      TileProvider var6;
      if(this.amD == null) {
         var6 = null;
      } else {
         var6 = new TileProvider() {
            private final class_58 amG;

            {
               this.amG = TileOverlayOptions.this.amD;
            }

            public Tile getTile(int var1, int var2, int var3) {
               try {
                  Tile var5 = this.amG.getTile(var1, var2, var3);
                  return var5;
               } catch (RemoteException var6) {
                  return null;
               }
            }
         };
      }

      this.amE = var6;
      this.alY = var3;
      this.alX = var4;
      this.amF = var5;
   }

   public int describeContents() {
      return 0;
   }

   public TileOverlayOptions fadeIn(boolean var1) {
      this.amF = var1;
      return this;
   }

   public boolean getFadeIn() {
      return this.amF;
   }

   public TileProvider getTileProvider() {
      return this.amE;
   }

   int getVersionCode() {
      return this.field_3214;
   }

   public float getZIndex() {
      return this.alX;
   }

   public boolean isVisible() {
      return this.alY;
   }

   // $FF: renamed from: og () android.os.IBinder
   IBinder method_4137() {
      return this.amD.asBinder();
   }

   public TileOverlayOptions tileProvider(final TileProvider var1) {
      this.amE = var1;
      class_58.class_1563 var2;
      if(this.amE == null) {
         var2 = null;
      } else {
         var2 = new class_58.class_1563() {
            public Tile getTile(int var1x, int var2, int var3) {
               return var1.getTile(var1x, var2, var3);
            }
         };
      }

      this.amD = var2;
      return this;
   }

   public TileOverlayOptions visible(boolean var1) {
      this.alY = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(class_1056.method_5858()) {
         class_880.method_4968(this, var1, var2);
      } else {
         class_884.method_4976(this, var1, var2);
      }
   }

   public TileOverlayOptions zIndex(float var1) {
      this.alX = var1;
      return this;
   }
}
