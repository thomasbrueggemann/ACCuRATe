package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.du
@ey
public final class class_465 extends FrameLayout implements OnClickListener {
   // $FF: renamed from: nB android.app.Activity
   private final Activity field_1585;
   // $FF: renamed from: sx android.widget.ImageButton
   private final ImageButton field_1586;

   public class_465(Activity var1, int var2) {
      super(var1);
      this.field_1585 = var1;
      this.setOnClickListener(this);
      this.field_1586 = new ImageButton(var1);
      this.field_1586.setImageResource(17301527);
      this.field_1586.setBackgroundColor(0);
      this.field_1586.setOnClickListener(this);
      this.field_1586.setPadding(0, 0, 0, 0);
      this.field_1586.setContentDescription("Interstitial close button");
      int var3 = class_367.method_2494(var1, var2);
      this.addView(this.field_1586, new LayoutParams(var3, var3, 17));
   }

   public void onClick(View var1) {
      this.field_1585.finish();
   }

   // $FF: renamed from: q (boolean) void
   public void method_2962(boolean var1) {
      ImageButton var2 = this.field_1586;
      byte var3;
      if(var1) {
         var3 = 4;
      } else {
         var3 = 0;
      }

      var2.setVisibility(var3);
   }
}
