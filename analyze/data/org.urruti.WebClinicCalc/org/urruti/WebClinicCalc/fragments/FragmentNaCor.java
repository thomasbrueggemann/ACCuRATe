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

public class FragmentNaCor extends Fragment {
   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      LayoutParams var2 = new LayoutParams(-1, -2);
      final EditText var3 = new EditText(this.getActivity().getBaseContext());
      var3.setInputType(8194);
      var3.setLayoutParams(var2);
      var3.setActivated(true);
      var3.setHint(this.getResources().getText(2131034165).toString());
      var3.setTextColor(17170444);
      var3.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentNaCor.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentNaCor.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16777216);
            }
         }
      });
      var3.setBackgroundColor(-1);
      var3.setTextAppearance(this.getActivity(), 16973890);
      final EditText var4 = new EditText(this.getActivity().getBaseContext());
      var4.setInputType(8194);
      var4.setLayoutParams(var2);
      var4.setActivated(true);
      var4.setHint(this.getResources().getText(2131034474).toString());
      var4.setTextColor(17170444);
      var4.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentNaCor.this.getActivity().findViewById(2131296264)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentNaCor.this.getActivity().findViewById(2131296264)).setBackgroundColor(-16777216);
            }
         }
      });
      var4.setBackgroundColor(-1);
      var4.setTextAppearance(this.getActivity(), 16973890);
      final TextView var5 = new TextView(this.getActivity().getBaseContext());
      var5.setVisibility(8);
      TextView var6 = new TextView(this.getActivity().getBaseContext());
      Button var7 = new Button(this.getActivity().getBaseContext());
      var7.setText(this.getResources().getText(2131034148).toString());
      var7.setBackgroundColor(Color.parseColor("#1a237e"));
      var7.setTextColor(-1);
      var7.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(!var3.getText().toString().isEmpty() && !var4.getText().toString().isEmpty()) {
               float var2 = Float.parseFloat(var3.getText().toString());
               float var3x = Float.parseFloat(var4.getText().toString());
               var5.setVisibility(0);
               double var4x = (double)var2 + 0.016D * (double)(var3x - 100.0F);
               var5.setText(Double.toString(var4x));
            } else {
               Toast.makeText(FragmentNaCor.this.getActivity(), FragmentNaCor.this.getResources().getText(2131034150).toString(), 0).show();
            }
         }
      });
      Typeface var8 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Bold.ttf");
      Typeface var9 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Thin.ttf");
      ((TextView)this.getActivity().findViewById(2131296258)).setTypeface(var9);
      ((TextView)this.getActivity().findViewById(2131296258)).setText(this.getResources().getText(2131034472).toString());
      var7.setTypeface(var8);
      var3.setTypeface(var9);
      var4.setTypeface(var9);
      var5.setTypeface(var9);
      var6.setTypeface(var8);
      var5.setTextColor(-16777216);
      var5.setTextSize(22.0F);
      var6.setTextSize(22.0F);
      ((LinearLayout)this.getActivity().findViewById(2131296604)).addView(var7);
      ((LinearLayout)this.getActivity().findViewById(2131296600)).addView(var3);
      ((LinearLayout)this.getActivity().findViewById(2131296602)).addView(var4);
      ((LinearLayout)this.getActivity().findViewById(2131296606)).addView(var5);
      ((LinearLayout)this.getActivity().findViewById(2131296608)).addView(var6);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2130903063, var2, false);
   }

   public void onStart() {
      super.onStart();
   }

   public void onStop() {
      super.onStop();
   }
}
