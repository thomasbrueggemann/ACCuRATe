package org.urruti.WebClinicCalc.fragments;

import android.app.Fragment;
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

public class FragmentTwo extends Fragment {
   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      LayoutParams var2 = new LayoutParams(-1, -2);
      final boolean var3 = this.getActivity().getBaseContext().getSharedPreferences("shprefreg", 0).getBoolean("isImperial", false);
      final EditText var4 = new EditText(this.getActivity().getBaseContext());
      var4.setInputType(8194);
      var4.setLayoutParams(var2);
      var4.setActivated(true);
      var4.setHint(this.getResources().getText(2131034147).toString());
      var4.setTextColor(17170444);
      var4.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentTwo.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentTwo.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16777216);
            }
         }
      });
      var4.setBackgroundColor(-1);
      var4.setTextAppearance(this.getActivity(), 16973890);
      final EditText var5 = new EditText(this.getActivity().getBaseContext());
      var5.setInputType(8194);
      var5.setLayoutParams(var2);
      var5.setHint(this.getResources().getText(2131034145).toString());
      var5.setActivated(true);
      var5.setBackgroundColor(-1);
      var5.setTextColor(17170444);
      var5.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentTwo.this.getActivity().findViewById(2131296264)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentTwo.this.getActivity().findViewById(2131296264)).setBackgroundColor(-16777216);
            }
         }
      });
      var5.setTextAppearance(this.getActivity(), 16973890);
      final TextView var6 = new TextView(this.getActivity().getBaseContext());
      var6.setVisibility(8);
      Button var7 = new Button(this.getActivity().getBaseContext());
      var7.setText(this.getResources().getText(2131034148).toString());
      var7.setBackgroundColor(Color.parseColor("#1a237e"));
      var7.setTextColor(-1);
      final EditText var8 = new EditText(this.getActivity().getBaseContext());
      if(var3) {
         var4.setHint(this.getResources().getText(2131034230).toString());
         var5.setHint(this.getResources().getText(2131034229).toString());
         var8.setInputType(8194);
         var8.setLayoutParams(var2);
         var8.setActivated(true);
         var8.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View var1, boolean var2) {
               if(var2) {
                  ((Button)FragmentTwo.this.getActivity().findViewById(2131296645)).setBackgroundColor(-16711681);
               } else {
                  ((Button)FragmentTwo.this.getActivity().findViewById(2131296645)).setBackgroundColor(-16777216);
               }
            }
         });
         var8.setHint(this.getResources().getText(2131034146).toString());
         var8.setTextColor(17170444);
         var8.setBackgroundColor(-1);
         var8.setTextAppearance(this.getActivity(), 16973890);
         var8.setHint(this.getResources().getText(2131034231).toString());
         ((LinearLayout)this.getActivity().findViewById(2131296644)).setVisibility(0);
         ((Button)this.getActivity().findViewById(2131296645)).setVisibility(0);
      } else {
         ((LinearLayout)this.getActivity().findViewById(2131296644)).setVisibility(8);
         ((Button)this.getActivity().findViewById(2131296645)).setVisibility(8);
      }

      var7.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(!var4.getText().toString().isEmpty() && !var5.getText().toString().isEmpty()) {
               double var2 = (double)Float.parseFloat(var4.getText().toString());
               double var4x = (double)Float.parseFloat(var5.getText().toString());
               if(var3) {
                  double var6x = (double)Float.parseFloat(var8.getText().toString());
                  var4x *= 0.45359237D;
                  var2 = (0.3048D * var2 + 0.0254D * var6x) / 100.0D;
               }

               var6.setText(Double.toString(Math.sqrt(var2 * var4x / 3600.0D)));
               var6.setVisibility(0);
            } else {
               Toast.makeText(FragmentTwo.this.getActivity(), FragmentTwo.this.getResources().getText(2131034150).toString(), 0).show();
            }
         }
      });
      Typeface var9 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Bold.ttf");
      Typeface var10 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Thin.ttf");
      ((TextView)this.getActivity().findViewById(2131296258)).setTypeface(var10);
      ((TextView)this.getActivity().findViewById(2131296258)).setText(this.getResources().getText(2131034149).toString());
      var4.setTypeface(var10);
      var5.setTypeface(var10);
      var6.setTypeface(var10);
      var8.setTypeface(var10);
      var6.setTextSize(22.0F);
      var6.setTextColor(-16777216);
      var7.setTypeface(var9);
      ((LinearLayout)this.getActivity().findViewById(2131296649)).addView(var7);
      ((LinearLayout)this.getActivity().findViewById(2131296642)).addView(var4);
      ((LinearLayout)this.getActivity().findViewById(2131296647)).addView(var5);
      ((LinearLayout)this.getActivity().findViewById(2131296644)).addView(var8);
      ((LinearLayout)this.getActivity().findViewById(2131296651)).addView(var6);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2130903066, var2, false);
   }

   public void onStart() {
      super.onStart();
   }

   public void onStop() {
      super.onStop();
   }
}
