package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.internal.class_371;

// $FF: renamed from: com.google.android.gms.internal.cl
public final class class_405 extends FrameLayout implements OnClickListener {
   // $FF: renamed from: oP android.widget.ImageButton
   private final ImageButton field_1789;
   // $FF: renamed from: oe android.app.Activity
   private final Activity field_1790;

   public class_405(Activity var1, int var2) {
      super(var1);
      this.field_1790 = var1;
      this.setOnClickListener(this);
      this.field_1789 = new ImageButton(var1);
      this.field_1789.setImageResource(17301527);
      this.field_1789.setBackgroundColor(0);
      this.field_1789.setOnClickListener(this);
      this.field_1789.setPadding(0, 0, 0, 0);
      int var3 = class_371.method_2364(var1, var2);
      this.addView(this.field_1789, new LayoutParams(var3, var3, 17));
   }

   // $FF: renamed from: j (boolean) void
   public void method_2493(boolean var1) {
      ImageButton var2 = this.field_1789;
      byte var3;
      if(var1) {
         var3 = 4;
      } else {
         var3 = 0;
      }

      var2.setVisibility(var3);
   }

   public void onClick(View var1) {
      this.field_1790.finish();
   }
}
