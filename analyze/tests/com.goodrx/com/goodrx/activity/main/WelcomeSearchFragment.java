package com.goodrx.activity.main;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.activity.main.SearchResultFragment;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class WelcomeSearchFragment extends Fragment implements TraceFieldInterface {
   ImageView imgTitle;
   TextView txtSubtitle;
   View viewSearchbox;

   public static WelcomeSearchFragment newInstance() {
      return new WelcomeSearchFragment();
   }

   public void onCreate(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   public View onCreateView(LayoutInflater param1, ViewGroup param2, Bundle param3) {
      // $FF: Couldn't be decompiled
   }

   public void onDestroyView() {
      super.onDestroyView();
      ButterKnife.unbind(this);
   }

   public void onSearchViewClicked() {
      ImageView var1 = this.imgTitle;
      PropertyValuesHolder[] var2 = new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("y", new float[]{0.0F}), PropertyValuesHolder.ofFloat("alpha", new float[]{0.0F})};
      ObjectAnimator var3 = ObjectAnimator.ofPropertyValuesHolder(var1, var2);
      TextView var4 = this.txtSubtitle;
      PropertyValuesHolder[] var5 = new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("y", new float[]{0.0F}), PropertyValuesHolder.ofFloat("alpha", new float[]{0.0F})};
      ObjectAnimator var6 = ObjectAnimator.ofPropertyValuesHolder(var4, var5);
      var6.setStartDelay(100L);
      View var7 = this.viewSearchbox;
      PropertyValuesHolder[] var8 = new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("y", new float[]{0.0F}), PropertyValuesHolder.ofFloat("alpha", new float[]{0.0F})};
      ObjectAnimator var9 = ObjectAnimator.ofPropertyValuesHolder(var7, var8);
      var9.setStartDelay(200L);
      AnimatorSet var10 = new AnimatorSet();
      var10.playTogether(new Animator[]{var3, var6, var9});
      var10.start();
      var10.addListener(new AnimatorListenerAdapter() {
         public void onAnimationEnd(Animator var1) {
            super.onAnimationEnd(var1);
            if(WelcomeSearchFragment.this.isAdded()) {
               AppCompatActivity var2 = (AppCompatActivity)WelcomeSearchFragment.this.getActivity();
               SearchResultFragment var3 = SearchResultFragment.newInstance();
               FragmentTransaction var4 = var2.getSupportFragmentManager().beginTransaction();
               var4.setTransition(0);
               var4.replace(2131886271, var3).commitAllowingStateLoss();
            }
         }
      });
   }

   protected void onStart() {
      super.onStart();
      ApplicationStateMonitor.getInstance().activityStarted();
   }

   protected void onStop() {
      super.onStop();
      ApplicationStateMonitor.getInstance().activityStopped();
   }
}
