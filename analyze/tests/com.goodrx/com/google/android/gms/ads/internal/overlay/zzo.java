package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zzo extends FrameLayout implements OnClickListener {
   private final ImageButton zzEW;
   private final zzs zzEX;

   public zzo(Context var1, int var2, zzs var3) {
      super(var1);
      this.zzEX = var3;
      this.setOnClickListener(this);
      this.zzEW = new ImageButton(var1);
      this.zzEW.setImageResource(17301527);
      this.zzEW.setBackgroundColor(0);
      this.zzEW.setOnClickListener(this);
      this.zzEW.setPadding(0, 0, 0, 0);
      this.zzEW.setContentDescription("Interstitial close button");
      int var4 = zzn.zzcS().zzb(var1, var2);
      this.addView(this.zzEW, new LayoutParams(var4, var4, 17));
   }

   public void onClick(View var1) {
      if(this.zzEX != null) {
         this.zzEX.zzfm();
      }

   }

   public void zza(boolean var1, boolean var2) {
      if(var2) {
         if(var1) {
            this.zzEW.setVisibility(4);
         } else {
            this.zzEW.setVisibility(8);
         }
      } else {
         this.zzEW.setVisibility(0);
      }
   }
}
