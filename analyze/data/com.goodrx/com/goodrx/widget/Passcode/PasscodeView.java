package com.goodrx.widget.Passcode;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.goodrx.widget.PasscodePinCircle;
import com.goodrx.widget.Passcode.PasscodeInputFinishListener;
import java.util.ArrayList;

public class PasscodeView extends FrameLayout implements OnClickListener {
   private final int ANIMATION_DURATION = 300;
   private final int PIN_LENGTH = 4;
   private Button btnDelete;
   private Button[] btnNumbers;
   private ArrayList<Integer> code;
   private PasscodeInputFinishListener inputFinishListener;
   private boolean isInit;
   private View layoutPins;
   private PasscodePinCircle[] pins;
   private TextView txtTitle;

   public PasscodeView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1);
   }

   public void clear() {
      PasscodePinCircle[] var1 = this.pins;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         var1[var3].setActivate(false);
      }

      this.code.clear();
   }

   public void init(Context var1) {
      View var2 = LayoutInflater.from(var1).inflate(2130968801, this, true);
      this.isInit = true;
      this.code = new ArrayList();
      this.pins = new PasscodePinCircle[4];
      this.pins[0] = (PasscodePinCircle)var2.findViewById(2131886757);
      this.pins[1] = (PasscodePinCircle)var2.findViewById(2131886758);
      this.pins[2] = (PasscodePinCircle)var2.findViewById(2131886759);
      this.pins[3] = (PasscodePinCircle)var2.findViewById(2131886760);
      this.btnNumbers = new Button[10];
      this.btnNumbers[0] = (Button)var2.findViewById(2131886770);
      this.btnNumbers[1] = (Button)var2.findViewById(2131886761);
      this.btnNumbers[2] = (Button)var2.findViewById(2131886762);
      this.btnNumbers[3] = (Button)var2.findViewById(2131886763);
      this.btnNumbers[4] = (Button)var2.findViewById(2131886764);
      this.btnNumbers[5] = (Button)var2.findViewById(2131886765);
      this.btnNumbers[6] = (Button)var2.findViewById(2131886766);
      this.btnNumbers[7] = (Button)var2.findViewById(2131886767);
      this.btnNumbers[8] = (Button)var2.findViewById(2131886768);
      this.btnNumbers[9] = (Button)var2.findViewById(2131886769);

      for(int var3 = 0; var3 < this.btnNumbers.length; ++var3) {
         this.btnNumbers[var3].setOnClickListener(this);
         this.btnNumbers[var3].setTag(Integer.valueOf(var3));
         this.btnNumbers[var3].setAlpha(0.0F);
      }

      this.btnDelete = (Button)var2.findViewById(2131886771);
      this.btnDelete.setOnClickListener(this);
      this.btnDelete.setAlpha(0.0F);
      this.txtTitle = (TextView)var2.findViewById(2131886412);
      this.layoutPins = var2.findViewById(2131886756);
   }

   public void onClick(View var1) {
      if(var1.getId() == 2131886771) {
         this.clear();
      } else {
         int var2 = ((Integer)var1.getTag()).intValue();
         if(this.code.size() < 4) {
            this.code.add(Integer.valueOf(var2));
            this.pins[-1 + this.code.size()].setActivate(true);
         }

         if(this.code.size() == 4 && this.inputFinishListener != null) {
            this.inputFinishListener.onInputFinish(this.code);
            return;
         }
      }

   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      if(this.btnDelete.getY() > 0.0F && this.isInit) {
         this.slideIn();
         this.isInit = false;
      }

   }

   public void setOnInputFinishListener(PasscodeInputFinishListener var1) {
      this.inputFinishListener = var1;
   }

   public void setSlideAnimation(View var1, long var2) {
      float var4 = (float)var1.getTop();
      ObjectAnimator var5 = ObjectAnimator.ofFloat(var1, "alpha", new float[]{0.0F, 1.0F});
      float[] var6 = new float[]{150.0F + var4, var4};
      ObjectAnimator var7 = ObjectAnimator.ofFloat(var1, "y", var6);
      var7.setInterpolator(new FastOutSlowInInterpolator());
      AnimatorSet var8 = new AnimatorSet();
      var8.setStartDelay(200L + var2);
      var8.setDuration(300L).play(var5).with(var7);
      var8.start();
   }

   public void setTitle(int var1) {
      this.txtTitle.setText(var1);
   }

   public void setTitle(String var1) {
      this.txtTitle.setText(var1);
   }

   public void shake() {
      (new Handler()).postDelayed(new Runnable() {
         public void run() {
            PasscodeView.this.clear();
         }
      }, 200L);
      Animation var2 = AnimationUtils.loadAnimation(this.getContext(), 2131034142);
      this.layoutPins.startAnimation(var2);
   }

   public void slideIn() {
      for(int var1 = 1; var1 < this.btnNumbers.length; ++var1) {
         this.setSlideAnimation(this.btnNumbers[var1], (long)(60 * ((var1 - 1) / 3)));
      }

      this.setSlideAnimation(this.btnNumbers[0], (long)180);
      this.setSlideAnimation(this.btnDelete, (long)180);
   }
}
