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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

public class FragmentCreatina extends Fragment implements OnClickListener {
   public EditText age;
   public EditText crea;
   public EditText weight;

   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      LayoutParams var2 = new LayoutParams(-1, -2);
      this.age = new EditText(this.getActivity().getBaseContext());
      this.age.setInputType(8194);
      this.age.setLayoutParams(var2);
      this.age.setActivated(true);
      this.age.setBackgroundColor(-1);
      this.age.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentCreatina.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentCreatina.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16777216);
            }
         }
      });
      this.age.setHint(this.getResources().getText(2131034143).toString());
      this.age.setTextColor(17170444);
      this.age.setTextAppearance(this.getActivity(), 16973890);
      this.weight = new EditText(this.getActivity().getBaseContext());
      this.weight.setInputType(8194);
      this.weight.setLayoutParams(var2);
      this.weight.setHint(this.getResources().getText(2131034145).toString());
      this.weight.setActivated(true);
      this.weight.setTextColor(17170444);
      this.weight.setBackgroundColor(-1);
      this.weight.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentCreatina.this.getActivity().findViewById(2131296264)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentCreatina.this.getActivity().findViewById(2131296264)).setBackgroundColor(-16777216);
            }
         }
      });
      this.weight.setTextAppearance(this.getActivity(), 16973890);
      this.crea = new EditText(this.getActivity().getBaseContext());
      this.crea.setInputType(8194);
      this.crea.setLayoutParams(var2);
      this.crea.setHint(this.getResources().getText(2131034144).toString());
      this.crea.setActivated(true);
      this.crea.setBackgroundColor(-1);
      this.crea.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentCreatina.this.getActivity().findViewById(2131296267)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentCreatina.this.getActivity().findViewById(2131296267)).setBackgroundColor(-16777216);
            }
         }
      });
      this.crea.setTextColor(17170444);
      this.crea.setTextAppearance(this.getActivity(), 16973890);
      Typeface var3 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Bold.ttf");
      Typeface var4 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Thin.ttf");
      new EditText(this.getActivity().getBaseContext());
      if(this.getActivity().getBaseContext().getSharedPreferences("shprefreg", 0).getBoolean("isImperial", false)) {
         this.weight.setHint(this.getResources().getText(2131034229).toString());
      }

      ((TextView)this.getActivity().findViewById(2131296258)).setTypeface(var4);
      ((TextView)this.getActivity().findViewById(2131296258)).setText(this.getResources().getText(2131034218).toString());
      this.age.setTypeface(var4);
      this.weight.setTypeface(var4);
      this.crea.setTypeface(var4);
      Button var6 = (Button)this.getActivity().findViewById(2131296273);
      var6.setTypeface(var3);
      var6.setText(this.getResources().getText(2131034148).toString());
      ((RadioButton)this.getActivity().findViewById(2131296271)).setTypeface(var4);
      ((RadioButton)this.getActivity().findViewById(2131296270)).setTypeface(var4);
      ((RadioButton)this.getActivity().findViewById(2131296270)).setText(2131034204);
      ((RadioButton)this.getActivity().findViewById(2131296271)).setText(2131034205);
      ((LinearLayout)this.getActivity().findViewById(2131296260)).addView(this.age);
      ((TextView)this.getActivity().findViewById(2131296275)).setTypeface(var4);
      ((LinearLayout)this.getActivity().findViewById(2131296263)).addView(this.weight);
      ((LinearLayout)this.getActivity().findViewById(2131296266)).addView(this.crea);
   }

   public void onClick(View var1) {
      if(var1.getId() == 2131296273) {
         if(!this.age.getText().toString().isEmpty() && !this.weight.getText().toString().isEmpty() && !this.crea.getText().toString().isEmpty()) {
            float var2 = Float.parseFloat(this.age.getText().toString());
            double var3 = (double)Float.parseFloat(this.weight.getText().toString());
            float var5 = Float.parseFloat(this.crea.getText().toString());
            if(this.getActivity().getBaseContext().getSharedPreferences("shprefreg", 0).getBoolean("isImperial", false)) {
               var3 *= 0.45359237D;
            }

            int var6 = ((RadioGroup)this.getActivity().findViewById(2131296269)).getCheckedRadioButtonId();
            String var7 = null;
            switch(var6) {
            case 2131296270:
               var7 = Double.toString(var3 * (double)(140.0F - var2) / (double)(72.0F * var5));
               break;
            case 2131296271:
               var7 = Double.toString(0.85D * var3 * (double)(140.0F - var2) / (double)(72.0F * var5));
            }

            ((TextView)this.getActivity().findViewById(2131296275)).setText(var7);
            ((TextView)this.getActivity().findViewById(2131296275)).setTextColor(-16777216);
            ((TextView)this.getActivity().findViewById(2131296275)).setTextSize(22.0F);
         }

      } else {
         Toast.makeText(this.getActivity(), this.getResources().getText(2131034150).toString(), 0).show();
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130903041, var2, false);
      Button var5 = (Button)var4.findViewById(2131296273);
      var5.setOnClickListener(this);
      var5.setBackgroundColor(Color.parseColor("#1a237e"));
      var5.setTextColor(-1);
      return var4;
   }
}
