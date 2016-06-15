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

public class FragmentIdealWeight extends Fragment {
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
               ((Button)FragmentIdealWeight.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentIdealWeight.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16777216);
            }
         }
      });
      var4.setHintTextColor(-16777216);
      var4.setTextAppearance(this.getActivity(), 16973890);
      final EditText var5 = new EditText(this.getActivity().getBaseContext());
      if(var3) {
         var4.setHint(this.getResources().getText(2131034230).toString());
         var5.setInputType(8194);
         var5.setLayoutParams(var2);
         var5.setActivated(true);
         var5.setHint(this.getResources().getText(2131034146).toString());
         var5.setTextColor(17170444);
         var5.setBackgroundColor(-1);
         var5.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View var1, boolean var2) {
               if(var2) {
                  ((Button)FragmentIdealWeight.this.getActivity().findViewById(2131296573)).setBackgroundColor(-16711681);
               } else {
                  ((Button)FragmentIdealWeight.this.getActivity().findViewById(2131296573)).setBackgroundColor(-16777216);
               }
            }
         });
         var5.setTextAppearance(this.getActivity(), 16973890);
         var5.setHint(this.getResources().getText(2131034231).toString());
         ((LinearLayout)this.getActivity().findViewById(2131296572)).setVisibility(0);
         ((Button)this.getActivity().findViewById(2131296573)).setVisibility(0);
      } else {
         ((LinearLayout)this.getActivity().findViewById(2131296572)).setVisibility(8);
         ((Button)this.getActivity().findViewById(2131296573)).setVisibility(8);
      }

      final TextView var6 = new TextView(this.getActivity().getBaseContext());
      var6.setVisibility(8);
      final TextView var7 = new TextView(this.getActivity().getBaseContext());
      Button var8 = new Button(this.getActivity().getBaseContext());
      var8.setText(this.getResources().getText(2131034148).toString());
      var8.setBackgroundColor(Color.parseColor("#1a237e"));
      var8.setTextColor(-1);
      var8.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(!var4.getText().toString().isEmpty()) {
               double var2 = (double)Float.parseFloat(var4.getText().toString());
               if(var3) {
                  double var8 = (double)Float.parseFloat(var5.getText().toString());
                  var2 = 0.3048D * var2 + 0.0254D * var8;
               }

               var6.setVisibility(0);
               double var4x = var2 * 19.0D * var2;
               double var6x = var2 * 25.0D * var2;
               var6.setText(Double.toString(var4x));
               var7.setText(Double.toString(var6x));
            } else {
               Toast.makeText(FragmentIdealWeight.this.getActivity(), FragmentIdealWeight.this.getResources().getText(2131034150).toString(), 0).show();
            }
         }
      });
      Typeface var9 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Bold.ttf");
      Typeface var10 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Thin.ttf");
      ((TextView)this.getActivity().findViewById(2131296258)).setTypeface(var10);
      ((TextView)this.getActivity().findViewById(2131296258)).setText(this.getResources().getText(2131034469).toString());
      var8.setTypeface(var9);
      var4.setTypeface(var10);
      var5.setTypeface(var10);
      var6.setTypeface(var10);
      var7.setTypeface(var9);
      ((LinearLayout)this.getActivity().findViewById(2131296577)).addView(var8);
      ((LinearLayout)this.getActivity().findViewById(2131296570)).addView(var4);
      ((LinearLayout)this.getActivity().findViewById(2131296572)).addView(var5);
      var6.setTextColor(-16777216);
      var7.setTextColor(-16777216);
      var6.setTextSize(22.0F);
      var7.setTextSize(22.0F);
      ((LinearLayout)this.getActivity().findViewById(2131296581)).addView(var6);
      ((LinearLayout)this.getActivity().findViewById(2131296583)).addView(var7);
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
