package org.urruti.WebClinicCalc.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import org.urruti.WebClinicCalc.fragments.FragmentIdealWeight;

public class FragmentStatis extends Fragment {
   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      LayoutParams var2 = new LayoutParams(-1, -2);
      final boolean var3 = this.getActivity().getBaseContext().getSharedPreferences("shprefreg", 0).getBoolean("isImperial", false);
      final EditText var4 = new EditText(this.getActivity().getBaseContext());
      var4.setInputType(8194);
      var4.setLayoutParams(var2);
      var4.setActivated(true);
      var4.setHint(this.getResources().getText(2131034146).toString());
      var4.setTextColor(17170444);
      var4.setBackgroundColor(-1);
      var4.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentStatis.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentStatis.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16777216);
            }
         }
      });
      var4.setHintTextColor(-16777216);
      var4.setTextAppearance(this.getActivity(), 16973890);
      final EditText var5 = new EditText(this.getActivity().getBaseContext());
      var5.setInputType(8194);
      var5.setLayoutParams(var2);
      var5.setActivated(true);
      var5.setHint(this.getResources().getText(2131034145).toString());
      var5.setTextColor(17170444);
      var5.setBackgroundColor(-1);
      var5.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentStatis.this.getActivity().findViewById(2131296264)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentStatis.this.getActivity().findViewById(2131296264)).setBackgroundColor(-16777216);
            }
         }
      });
      var5.setTextAppearance(this.getActivity(), 16973890);
      final EditText var6 = new EditText(this.getActivity().getBaseContext());
      if(var3) {
         var4.setHint(this.getResources().getText(2131034230).toString());
         var5.setHint(this.getResources().getText(2131034229).toString());
         var6.setInputType(8194);
         var6.setLayoutParams(var2);
         var6.setActivated(true);
         var6.setHint(this.getResources().getText(2131034146).toString());
         var6.setTextColor(17170444);
         var6.setBackgroundColor(-1);
         var6.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View var1, boolean var2) {
               if(var2) {
                  ((Button)FragmentStatis.this.getActivity().findViewById(2131296573)).setBackgroundColor(-16711681);
               } else {
                  ((Button)FragmentStatis.this.getActivity().findViewById(2131296573)).setBackgroundColor(-16777216);
               }
            }
         });
         var6.setTextAppearance(this.getActivity(), 16973890);
         var6.setHint(this.getResources().getText(2131034231).toString());
         ((LinearLayout)this.getActivity().findViewById(2131296572)).setVisibility(0);
         ((Button)this.getActivity().findViewById(2131296573)).setVisibility(0);
      } else {
         ((LinearLayout)this.getActivity().findViewById(2131296572)).setVisibility(8);
         ((Button)this.getActivity().findViewById(2131296573)).setVisibility(8);
      }

      final TextView var7 = new TextView(this.getActivity().getBaseContext());
      var7.setVisibility(8);
      final TextView var8 = new TextView(this.getActivity().getBaseContext());
      Button var9 = new Button(this.getActivity().getBaseContext());
      var9.setText("Peso ideal");
      var9.setBackgroundColor(Color.parseColor("#1a237e"));
      var9.setTextColor(-1);
      var9.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            FragmentManager var2 = FragmentStatis.this.getFragmentManager();
            FragmentIdealWeight var3 = new FragmentIdealWeight();
            var2.beginTransaction().replace(2131296277, var3).commit();
         }
      });
      Button var10 = new Button(this.getActivity().getBaseContext());
      var10.setText(this.getResources().getText(2131034148).toString());
      var10.setBackgroundColor(Color.parseColor("#1a237e"));
      var10.setTextColor(-1);
      var10.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(!var4.getText().toString().isEmpty() && !var5.getText().toString().isEmpty()) {
               double var2 = (double)Float.parseFloat(var4.getText().toString());
               double var4x = (double)Float.parseFloat(var5.getText().toString());
               if(var3) {
                  double var8x = (double)Float.parseFloat(var6.getText().toString());
                  var4x *= 0.45359237D;
                  var2 = 0.3048D * var2 + 0.0254D * var8x;
               }

               var7.setVisibility(0);
               double var6x = var4x / (var2 * var2);
               var7.setText(Double.toString(var6x));
               if(var6x < 18.5D) {
                  var8.setText(FragmentStatis.this.getResources().getText(2131034151).toString());
                  var8.setTextColor(-256);
               } else if(var6x < 25.0D) {
                  var8.setText(FragmentStatis.this.getResources().getText(2131034152).toString());
                  var8.setTextColor(-16711936);
               } else if(var6x < 30.0D) {
                  var8.setText(FragmentStatis.this.getResources().getText(2131034153).toString());
                  var8.setTextColor(-256);
               } else if(var6x < 35.0D) {
                  var8.setText(FragmentStatis.this.getResources().getText(2131034154).toString());
                  var8.setTextColor(-65536);
               } else if(var6x < 40.0D) {
                  var8.setText(FragmentStatis.this.getResources().getText(2131034155).toString());
                  var8.setTextColor(-65536);
               } else {
                  var8.setText(FragmentStatis.this.getResources().getText(2131034156).toString());
                  var8.setTextColor(-65536);
               }
            } else {
               Toast.makeText(FragmentStatis.this.getActivity(), FragmentStatis.this.getResources().getText(2131034150).toString(), 0).show();
            }
         }
      });
      Typeface var11 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Bold.ttf");
      Typeface var12 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Thin.ttf");
      ((TextView)this.getActivity().findViewById(2131296258)).setTypeface(var12);
      ((TextView)this.getActivity().findViewById(2131296258)).setText(this.getResources().getText(2131034142).toString());
      var10.setTypeface(var11);
      var9.setTypeface(var12);
      var4.setTypeface(var12);
      var6.setTypeface(var12);
      var5.setTypeface(var12);
      var7.setTypeface(var12);
      var8.setTypeface(var11);
      ((LinearLayout)this.getActivity().findViewById(2131296577)).addView(var10);
      ((LinearLayout)this.getActivity().findViewById(2131296579)).addView(var9);
      ((LinearLayout)this.getActivity().findViewById(2131296570)).addView(var4);
      ((LinearLayout)this.getActivity().findViewById(2131296572)).addView(var6);
      ((LinearLayout)this.getActivity().findViewById(2131296575)).addView(var5);
      var7.setTextColor(-16777216);
      var7.setTextSize(22.0F);
      var8.setTextSize(22.0F);
      ((LinearLayout)this.getActivity().findViewById(2131296581)).addView(var7);
      ((LinearLayout)this.getActivity().findViewById(2131296583)).addView(var8);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2130903061, var2, false);
   }

   public void onStart() {
      super.onStart();
   }

   public void onStop() {
      super.onStop();
   }
}
