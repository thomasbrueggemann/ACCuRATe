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

public class FragmentFiltrado extends Fragment implements OnClickListener {
   public EditText age;
   public EditText crea;

   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      LayoutParams var2 = new LayoutParams(-1, -2);
      this.age = new EditText(this.getActivity().getBaseContext());
      this.age.setInputType(8194);
      this.age.setLayoutParams(var2);
      this.age.setActivated(true);
      this.age.setHint(this.getResources().getText(2131034143).toString());
      this.age.setTextColor(17170444);
      this.age.setBackgroundColor(-1);
      this.age.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentFiltrado.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentFiltrado.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16777216);
            }
         }
      });
      this.age.setTextAppearance(this.getActivity(), 16973890);
      this.crea = new EditText(this.getActivity().getBaseContext());
      this.crea.setInputType(8194);
      this.crea.setLayoutParams(var2);
      this.crea.setHint(this.getResources().getText(2131034144).toString());
      this.crea.setActivated(true);
      this.crea.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentFiltrado.this.getActivity().findViewById(2131296264)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentFiltrado.this.getActivity().findViewById(2131296264)).setBackgroundColor(-16777216);
            }
         }
      });
      this.crea.setTextColor(17170444);
      this.crea.setBackgroundColor(-1);
      this.crea.setTextAppearance(this.getActivity(), 16973890);
      Typeface var3 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Bold.ttf");
      Typeface var4 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Thin.ttf");
      ((TextView)this.getActivity().findViewById(2131296258)).setTypeface(var4);
      ((TextView)this.getActivity().findViewById(2131296258)).setText(this.getResources().getText(2131034232).toString());
      Button var5 = (Button)this.getActivity().findViewById(2131296273);
      ((TextView)this.getActivity().findViewById(2131296275)).setTypeface(var4);
      ((TextView)this.getActivity().findViewById(2131296344)).setTypeface(var4);
      ((RadioButton)this.getActivity().findViewById(2131296271)).setTypeface(var4);
      ((RadioButton)this.getActivity().findViewById(2131296270)).setTypeface(var4);
      ((RadioButton)this.getActivity().findViewById(2131296493)).setTypeface(var4);
      ((RadioButton)this.getActivity().findViewById(2131296494)).setTypeface(var4);
      ((RadioButton)this.getActivity().findViewById(2131296270)).setText(2131034204);
      ((RadioButton)this.getActivity().findViewById(2131296271)).setText(2131034205);
      ((RadioButton)this.getActivity().findViewById(2131296494)).setText(2131034234);
      ((RadioButton)this.getActivity().findViewById(2131296493)).setText(2131034233);
      this.age.setTypeface(var4);
      this.crea.setTypeface(var4);
      var5.setTypeface(var3);
      var5.setText(this.getResources().getText(2131034148).toString());
      ((LinearLayout)this.getActivity().findViewById(2131296487)).addView(this.age);
      ((LinearLayout)this.getActivity().findViewById(2131296489)).addView(this.crea);
   }

   public void onClick(View var1) {
      if(var1.getId() == 2131296273) {
         if(this.age.getText().toString().isEmpty() || this.crea.getText().toString().isEmpty()) {
            Toast.makeText(this.getActivity(), "Introduce ambos parametros", 0).show();
            return;
         }

         float var2 = Float.parseFloat(this.age.getText().toString());
         float var3 = Float.parseFloat(this.crea.getText().toString());
         int var4 = ((RadioGroup)this.getActivity().findViewById(2131296269)).getCheckedRadioButtonId();
         int var5 = ((RadioGroup)this.getActivity().findViewById(2131296492)).getCheckedRadioButtonId();
         String var6 = null;
         switch(var4) {
         case 2131296270:
            if(var5 == 2131296493) {
               var6 = Double.toString(225.06D * Math.pow((double)var3, -1.154D) * Math.pow((double)var2, -0.203D));
            } else {
               var6 = Double.toString(186.0D * Math.pow((double)var3, -1.154D) * Math.pow((double)var2, -0.203D));
            }
            break;
         case 2131296271:
            if(var5 == 2131296493) {
               var6 = Double.toString(166.99452D * Math.pow((double)var3, -1.154D) * Math.pow((double)var2, -0.203D));
            } else {
               var6 = Double.toString(138.012D * Math.pow((double)var3, -1.154D) * Math.pow((double)var2, -0.203D));
            }
         }

         ((TextView)this.getActivity().findViewById(2131296275)).setText(var6);
         ((TextView)this.getActivity().findViewById(2131296275)).setTextColor(-16777216);
         ((TextView)this.getActivity().findViewById(2131296275)).setTextSize(22.0F);
         TextView var7 = (TextView)this.getActivity().findViewById(2131296344);
         var7.setTextSize(22.0F);
         if(Float.parseFloat(var6) >= 90.0F) {
            var7.setText(this.getResources().getText(2131034333).toString());
         } else {
            if(Float.parseFloat(var6) < 15.0F) {
               var7.setText(this.getResources().getText(2131034337).toString());
               return;
            }

            if(Float.parseFloat(var6) < 30.0F) {
               var7.setText(this.getResources().getText(2131034336).toString());
               return;
            }

            if(Float.parseFloat(var6) < 60.0F) {
               var7.setText(this.getResources().getText(2131034335).toString());
               return;
            }

            if(Float.parseFloat(var6) < 90.0F) {
               var7.setText(this.getResources().getText(2131034334).toString());
               return;
            }
         }
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130903056, var2, false);
      Button var5 = (Button)var4.findViewById(2131296273);
      var5.setOnClickListener(this);
      var5.setBackgroundColor(Color.parseColor("#1a237e"));
      var5.setTextColor(-1);
      return var4;
   }
}
