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

public class FragmentExcreUrea extends Fragment {
   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      LayoutParams var2 = new LayoutParams(-1, -2);
      final EditText var3 = new EditText(this.getActivity().getBaseContext());
      var3.setInputType(8194);
      var3.setLayoutParams(var2);
      var3.setActivated(true);
      var3.setHint(this.getResources().getText(2131034223).toString());
      var3.setTextColor(17170444);
      var3.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentExcreUrea.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentExcreUrea.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16777216);
            }
         }
      });
      var3.setBackgroundColor(-1);
      var3.setTextAppearance(this.getActivity(), 16973890);
      final EditText var4 = new EditText(this.getActivity().getBaseContext());
      var4.setInputType(8194);
      var4.setLayoutParams(var2);
      var4.setActivated(true);
      var4.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentExcreUrea.this.getActivity().findViewById(2131296264)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentExcreUrea.this.getActivity().findViewById(2131296264)).setBackgroundColor(-16777216);
            }
         }
      });
      var4.setBackgroundColor(-1);
      var4.setHint(this.getResources().getText(2131034224).toString());
      var4.setTextColor(17170444);
      var4.setTextAppearance(this.getActivity(), 16973890);
      final EditText var5 = new EditText(this.getActivity().getBaseContext());
      var5.setInputType(8194);
      var5.setLayoutParams(var2);
      var5.setActivated(true);
      var5.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentExcreUrea.this.getActivity().findViewById(2131296267)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentExcreUrea.this.getActivity().findViewById(2131296267)).setBackgroundColor(-16777216);
            }
         }
      });
      var5.setBackgroundColor(-1);
      var5.setHint(this.getResources().getText(2131034221).toString());
      var5.setTextColor(17170444);
      var5.setTextAppearance(this.getActivity(), 16973890);
      final EditText var6 = new EditText(this.getActivity().getBaseContext());
      var6.setInputType(8194);
      var6.setLayoutParams(var2);
      var6.setBackgroundColor(-1);
      var6.setActivated(true);
      var6.setHint(this.getResources().getText(2131034222).toString());
      var6.setTextColor(17170444);
      var6.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentExcreUrea.this.getActivity().findViewById(2131296472)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentExcreUrea.this.getActivity().findViewById(2131296472)).setBackgroundColor(-16777216);
            }
         }
      });
      var6.setTextAppearance(this.getActivity(), 16973890);
      final TextView var7 = new TextView(this.getActivity().getBaseContext());
      var7.setVisibility(8);
      Button var8 = new Button(this.getActivity().getBaseContext());
      var8.setText(this.getResources().getText(2131034148).toString());
      var8.setBackgroundColor(Color.parseColor("#1a237e"));
      var8.setTextColor(-1);
      var8.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(!var3.getText().toString().isEmpty() && !var4.getText().toString().isEmpty() && !var5.getText().toString().isEmpty() && !var6.getText().toString().isEmpty()) {
               float var2 = Float.parseFloat(var3.getText().toString());
               float var3x = Float.parseFloat(var4.getText().toString());
               float var4x = Float.parseFloat(var5.getText().toString());
               float var5x = Float.parseFloat(var6.getText().toString());
               var7.setVisibility(0);
               float var6x = 100.0F * var2 * var5x / (var3x * var4x);
               var7.setText(Float.toString(var6x));
            } else {
               Toast.makeText(FragmentExcreUrea.this.getActivity(), FragmentExcreUrea.this.getResources().getText(2131034150).toString(), 0).show();
            }
         }
      });
      Typeface var9 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Bold.ttf");
      Typeface var10 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Thin.ttf");
      ((TextView)this.getActivity().findViewById(2131296258)).setTypeface(var10);
      ((TextView)this.getActivity().findViewById(2131296258)).setText(this.getResources().getText(2131034226).toString());
      var8.setTypeface(var9);
      var3.setTypeface(var10);
      var4.setTypeface(var10);
      var5.setTypeface(var10);
      var6.setTypeface(var10);
      var7.setTypeface(var10);
      var7.setTextColor(-16777216);
      var7.setTextSize(22.0F);
      ((LinearLayout)this.getActivity().findViewById(2131296474)).addView(var8);
      ((LinearLayout)this.getActivity().findViewById(2131296465)).addView(var3);
      ((LinearLayout)this.getActivity().findViewById(2131296467)).addView(var4);
      ((LinearLayout)this.getActivity().findViewById(2131296469)).addView(var5);
      ((LinearLayout)this.getActivity().findViewById(2131296471)).addView(var6);
      ((LinearLayout)this.getActivity().findViewById(2131296476)).addView(var7);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2130903054, var2, false);
   }

   public void onStart() {
      super.onStart();
   }

   public void onStop() {
      super.onStop();
   }
}
