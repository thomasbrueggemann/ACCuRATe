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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

public class FragmentAlcohol extends Fragment implements OnClickListener {
   public EditText AGrad;
   public EditText AVol;
   public EditText AWeight;

   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      LayoutParams var2 = new LayoutParams(-1, -2);
      this.AGrad = new EditText(this.getActivity().getBaseContext());
      this.AGrad.setInputType(8194);
      this.AGrad.setLayoutParams(var2);
      this.AGrad.setActivated(true);
      this.AGrad.setHint(this.getResources().getText(2131034342).toString());
      this.AGrad.setTextColor(17170444);
      this.AGrad.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentAlcohol.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentAlcohol.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16777216);
            }
         }
      });
      this.AGrad.setBackgroundColor(-1);
      this.AGrad.setTextAppearance(this.getActivity(), 16973890);
      this.AVol = new EditText(this.getActivity().getBaseContext());
      this.AVol.setInputType(8194);
      this.AVol.setLayoutParams(var2);
      this.AVol.setActivated(true);
      this.AVol.setHint(this.getResources().getText(2131034343).toString());
      this.AVol.setTextColor(17170444);
      this.AVol.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentAlcohol.this.getActivity().findViewById(2131296264)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentAlcohol.this.getActivity().findViewById(2131296264)).setBackgroundColor(-16777216);
            }
         }
      });
      this.AVol.setBackgroundColor(-1);
      this.AVol.setTextAppearance(this.getActivity(), 16973890);
      this.AWeight = new EditText(this.getActivity().getBaseContext());
      this.AWeight.setInputType(8194);
      this.AWeight.setLayoutParams(var2);
      this.AWeight.setActivated(true);
      this.AWeight.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentAlcohol.this.getActivity().findViewById(2131296267)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentAlcohol.this.getActivity().findViewById(2131296267)).setBackgroundColor(-16777216);
            }
         }
      });
      this.AWeight.setHint(this.getResources().getText(2131034344).toString());
      this.AWeight.setTextColor(17170444);
      this.AWeight.setBackgroundColor(-1);
      this.AWeight.setTextAppearance(this.getActivity(), 16973890);
      ((RelativeLayout)this.getActivity().findViewById(2131296294)).setVisibility(8);
      Button var3 = new Button(this.getActivity().getBaseContext());
      var3.setText(this.getResources().getText(2131034148).toString());
      var3.setBackgroundColor(Color.parseColor("#1a237e"));
      var3.setTextColor(-1);
      Typeface var4 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Bold.ttf");
      Typeface var5 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Thin.ttf");
      ((TextView)this.getActivity().findViewById(2131296258)).setTypeface(var5);
      ((TextView)this.getActivity().findViewById(2131296258)).setText(this.getResources().getText(2131034341).toString());
      var3.setTypeface(var4);
      this.AVol.setTypeface(var5);
      this.AWeight.setTypeface(var5);
      this.AGrad.setTypeface(var5);
      ((RadioButton)this.getActivity().findViewById(2131296270)).setText(2131034204);
      ((RadioButton)this.getActivity().findViewById(2131296271)).setText(2131034205);
      ((RadioButton)this.getActivity().findViewById(2131296271)).setTypeface(var5);
      ((RadioButton)this.getActivity().findViewById(2131296270)).setTypeface(var5);
      ((LinearLayout)this.getActivity().findViewById(2131296287)).addView(this.AGrad);
      ((LinearLayout)this.getActivity().findViewById(2131296289)).addView(this.AVol);
      ((LinearLayout)this.getActivity().findViewById(2131296291)).addView(this.AWeight);
   }

   public void onClick(View var1) {
      if(var1.getId() == 2131296273) {
         if(this.AGrad.getText().toString().isEmpty() || this.AVol.getText().toString().isEmpty() || this.AWeight.getText().toString().isEmpty()) {
            Toast.makeText(this.getActivity(), "Introduce ambos parametros", 0).show();
            return;
         }

         float var2 = Float.parseFloat(this.AGrad.getText().toString());
         float var3 = Float.parseFloat(this.AVol.getText().toString());
         float var4 = Float.parseFloat(this.AWeight.getText().toString());
         int var5 = ((RadioGroup)this.getActivity().findViewById(2131296269)).getCheckedRadioButtonId();
         double var6 = 0.0D;
         switch(var5) {
         case 2131296270:
            var6 = 0.8D * (double)(var2 * var3) / (0.7D * (double)(10.0F * var4));
            break;
         case 2131296271:
            var6 = 0.8D * (double)(var2 * var3) / (0.6D * (double)(10.0F * var4));
         }

         String var8 = Double.toString(var6);
         ((RelativeLayout)this.getActivity().findViewById(2131296294)).setVisibility(0);
         TextView var9 = (TextView)this.getActivity().findViewById(2131296275);
         var9.setText(var8);
         var9.setTextColor(-16777216);
         var9.setTextSize(22.0F);
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130903046, var2, false);
      Button var5 = (Button)var4.findViewById(2131296273);
      var5.setOnClickListener(this);
      var5.setBackgroundColor(Color.parseColor("#1a237e"));
      var5.setTextColor(-1);
      return var4;
   }

   public void onStart() {
      super.onStart();
   }

   public void onStop() {
      super.onStop();
   }
}
