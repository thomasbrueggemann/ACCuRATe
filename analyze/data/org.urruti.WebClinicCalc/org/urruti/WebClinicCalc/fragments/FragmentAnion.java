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

public class FragmentAnion extends Fragment {
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
               ((Button)FragmentAnion.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentAnion.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16777216);
            }
         }
      });
      var3.setBackgroundColor(-1);
      var3.setTextAppearance(this.getActivity(), 16973890);
      final EditText var4 = new EditText(this.getActivity().getBaseContext());
      var4.setInputType(8194);
      var4.setLayoutParams(var2);
      var4.setActivated(true);
      var4.setHint(this.getResources().getText(2131034479).toString());
      var4.setTextColor(17170444);
      var4.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentAnion.this.getActivity().findViewById(2131296264)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentAnion.this.getActivity().findViewById(2131296264)).setBackgroundColor(-16777216);
            }
         }
      });
      var4.setBackgroundColor(-1);
      var4.setTextAppearance(this.getActivity(), 16973890);
      final EditText var5 = new EditText(this.getActivity().getBaseContext());
      var5.setInputType(8194);
      var5.setLayoutParams(var2);
      var5.setActivated(true);
      var5.setHint(this.getResources().getText(2131034480).toString());
      var5.setTextColor(17170444);
      var5.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentAnion.this.getActivity().findViewById(2131296267)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentAnion.this.getActivity().findViewById(2131296267)).setBackgroundColor(-16777216);
            }
         }
      });
      var5.setBackgroundColor(-1);
      var5.setTextAppearance(this.getActivity(), 16973890);
      final TextView var6 = new TextView(this.getActivity().getBaseContext());
      var6.setVisibility(8);
      TextView var7 = new TextView(this.getActivity().getBaseContext());
      Button var8 = new Button(this.getActivity().getBaseContext());
      var8.setText(this.getResources().getText(2131034148).toString());
      var8.setBackgroundColor(Color.parseColor("#1a237e"));
      var8.setTextColor(-1);
      var8.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(!var3.getText().toString().isEmpty() && !var5.getText().toString().isEmpty() && !var4.getText().toString().isEmpty()) {
               float var2 = Float.parseFloat(var3.getText().toString());
               float var3x = Float.parseFloat(var4.getText().toString());
               float var4x = Float.parseFloat(var5.getText().toString());
               var6.setVisibility(0);
               float var5x = var2 - var3x - var4x;
               var6.setText(Float.toString(var5x));
            } else {
               Toast.makeText(FragmentAnion.this.getActivity(), FragmentAnion.this.getResources().getText(2131034150).toString(), 0).show();
            }
         }
      });
      Typeface var9 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Bold.ttf");
      Typeface var10 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Thin.ttf");
      ((TextView)this.getActivity().findViewById(2131296258)).setTypeface(var10);
      ((TextView)this.getActivity().findViewById(2131296258)).setText(this.getResources().getText(2131034478).toString());
      var8.setTypeface(var9);
      var3.setTypeface(var10);
      var5.setTypeface(var10);
      var4.setTypeface(var10);
      var6.setTypeface(var10);
      var7.setTypeface(var9);
      var6.setTextColor(-16777216);
      var6.setTextSize(22.0F);
      var7.setTextSize(22.0F);
      ((LinearLayout)this.getActivity().findViewById(2131296304)).addView(var8);
      ((LinearLayout)this.getActivity().findViewById(2131296298)).addView(var3);
      ((LinearLayout)this.getActivity().findViewById(2131296300)).addView(var4);
      ((LinearLayout)this.getActivity().findViewById(2131296302)).addView(var5);
      ((LinearLayout)this.getActivity().findViewById(2131296306)).addView(var6);
      ((LinearLayout)this.getActivity().findViewById(2131296308)).addView(var7);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2130903047, var2, false);
   }

   public void onStart() {
      super.onStart();
   }

   public void onStop() {
      super.onStop();
   }
}
