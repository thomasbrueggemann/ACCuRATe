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

public class FragmentFCMax extends Fragment {
   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      LayoutParams var2 = new LayoutParams(-1, -2);
      final EditText var3 = new EditText(this.getActivity().getBaseContext());
      var3.setInputType(2);
      var3.setLayoutParams(var2);
      var3.setActivated(true);
      var3.setHint(this.getResources().getText(2131034143).toString());
      var3.setTextColor(17170444);
      var3.setBackgroundColor(-1);
      var3.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentFCMax.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentFCMax.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16777216);
            }
         }
      });
      var3.setTextAppearance(this.getActivity(), 16973890);
      final TextView var4 = new TextView(this.getActivity().getBaseContext());
      var4.setVisibility(8);
      Button var5 = new Button(this.getActivity().getBaseContext());
      var5.setText(this.getResources().getText(2131034148).toString());
      var5.setBackgroundColor(Color.parseColor("#1a237e"));
      var5.setTextColor(-1);
      var5.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(!var3.getText().toString().isEmpty()) {
               float var2 = Float.parseFloat(var3.getText().toString());
               var4.setVisibility(0);
               float var3x = 220.0F - var2;
               var4.setText(Float.toString(var3x));
            } else {
               Toast.makeText(FragmentFCMax.this.getActivity(), FragmentFCMax.this.getResources().getText(2131034150).toString(), 0).show();
            }
         }
      });
      Typeface var6 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Bold.ttf");
      Typeface var7 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Thin.ttf");
      ((TextView)this.getActivity().findViewById(2131296258)).setTypeface(var7);
      ((TextView)this.getActivity().findViewById(2131296258)).setText(this.getResources().getText(2131034227).toString());
      var3.setTypeface(var7);
      var5.setTypeface(var7);
      var4.setTypeface(var7);
      var4.setTextColor(-16777216);
      var4.setTextSize(22.0F);
      var5.setTypeface(var6);
      ((LinearLayout)this.getActivity().findViewById(2131296479)).addView(var3);
      ((LinearLayout)this.getActivity().findViewById(2131296481)).addView(var5);
      ((LinearLayout)this.getActivity().findViewById(2131296483)).addView(var4);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2130903055, var2, false);
   }

   public void onStart() {
      super.onStart();
   }

   public void onStop() {
      super.onStop();
   }
}
