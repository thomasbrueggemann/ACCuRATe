package com.goodrx.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import java.lang.ref.WeakReference;

public class MyProgressBar extends FrameLayout {
   private static final long FADE_OUT_DURATION = 1000L;
   private static final long SHOWUP_DELAY = 200L;
   private Handler handler;
   private int jobCounter = 0;
   private View layout;
   private ProgressBar progressBar;

   public MyProgressBar(Context var1) {
      super(var1);
      this.init(var1);
   }

   public MyProgressBar(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1);
   }

   public MyProgressBar(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1);
   }

   private int getJobCounter() {
      synchronized(this){}

      int var2;
      try {
         var2 = this.jobCounter;
      } finally {
         ;
      }

      return var2;
   }

   private void updateJobCounter(int var1) {
      synchronized(this){}

      try {
         this.jobCounter += var1;
         if(this.jobCounter < 0) {
            this.jobCounter = 0;
         }
      } finally {
         ;
      }

   }

   public void dismiss() {
      this.updateJobCounter(-1);
      if(this.getJobCounter() <= 0) {
         this.handler.removeMessages(1);
         if(this.progressBar.getVisibility() != 0) {
            this.layout.setVisibility(8);
         } else {
            this.layout.setClickable(false);
            this.progressBar.animate().alpha(0.0F).setDuration(1000L).setListener(new AnimatorListenerAdapter() {
               public void onAnimationEnd(Animator var1) {
                  MyProgressBar.this.layout.setVisibility(8);
                  MyProgressBar.this.progressBar.setAlpha(1.0F);
               }
            });
         }
      }
   }

   public void init(Context var1) {
      FrameLayout var2 = (FrameLayout)LayoutInflater.from(var1).inflate(2130968803, this, true);
      this.layout = var2.findViewById(2131886774);
      this.progressBar = (ProgressBar)var2.findViewById(2131886775);
      this.handler = new MyProgressBar.ProgressHandler(this);
   }

   public void show() {
      this.updateJobCounter(1);
      if(this.getJobCounter() <= 1) {
         this.progressBar.setVisibility(8);
         this.layout.setVisibility(0);
         this.layout.setClickable(true);
         this.handler.sendEmptyMessageDelayed(1, 200L);
      }
   }

   private static class ProgressHandler extends Handler {
      public static final int SHOW_PROGRESS_BAR = 1;
      private WeakReference<MyProgressBar> mRef;

      public ProgressHandler(MyProgressBar var1) {
         this.mRef = new WeakReference(var1);
      }

      public void handleMessage(Message var1) {
         if(var1.what == 1) {
            if(this.mRef.get() == null) {
               return;
            }

            ((MyProgressBar)this.mRef.get()).progressBar.setVisibility(0);
         }

         super.handleMessage(var1);
      }
   }
}
