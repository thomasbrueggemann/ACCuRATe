package org.urruti.WebClinicCalc.fragments;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FragmentSilverman extends Fragment implements OnClickListener {
   public EditText age;
   public EditText crea;
   public Typeface myTypeface;
   public Typeface myTypeface2;

   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      ((TextView)this.getActivity().findViewById(2131296258)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296258)).setText(this.getResources().getText(2131034314).toString());
      ((TextView)this.getActivity().findViewById(2131296312)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296312)).setText(this.getResources().getText(2131034309).toString());
      ((TextView)this.getActivity().findViewById(2131296318)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296318)).setText(this.getResources().getText(2131034310).toString());
      ((TextView)this.getActivity().findViewById(2131296324)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296324)).setText(this.getResources().getText(2131034311).toString());
      ((TextView)this.getActivity().findViewById(2131296330)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296330)).setText(this.getResources().getText(2131034312).toString());
      ((TextView)this.getActivity().findViewById(2131296336)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296336)).setText(this.getResources().getText(2131034313).toString());
      Button var2 = (Button)this.getActivity().findViewById(2131296273);
      var2.setTypeface(this.myTypeface);
      var2.setText(2131034148);
      ((TextView)this.getActivity().findViewById(2131296275)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296615)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296614)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296613)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296620)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296619)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296618)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296625)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296624)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296623)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296630)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296629)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296628)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296635)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296634)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296633)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296615)).setText(2131034315);
      ((RadioButton)this.getActivity().findViewById(2131296614)).setText(2131034316);
      ((RadioButton)this.getActivity().findViewById(2131296613)).setText(2131034317);
      ((RadioButton)this.getActivity().findViewById(2131296620)).setText(2131034318);
      ((RadioButton)this.getActivity().findViewById(2131296619)).setText(2131034319);
      ((RadioButton)this.getActivity().findViewById(2131296618)).setText(2131034320);
      ((RadioButton)this.getActivity().findViewById(2131296625)).setText(2131034321);
      ((RadioButton)this.getActivity().findViewById(2131296624)).setText(2131034322);
      ((RadioButton)this.getActivity().findViewById(2131296623)).setText(2131034323);
      ((RadioButton)this.getActivity().findViewById(2131296630)).setText(2131034324);
      ((RadioButton)this.getActivity().findViewById(2131296629)).setText(2131034325);
      ((RadioButton)this.getActivity().findViewById(2131296628)).setText(2131034326);
      ((RadioButton)this.getActivity().findViewById(2131296635)).setText(2131034327);
      ((RadioButton)this.getActivity().findViewById(2131296634)).setText(2131034328);
      ((RadioButton)this.getActivity().findViewById(2131296633)).setText(2131034329);
   }

   public void onClick(View var1) {
      if(var1.getId() == 2131296273) {
         int var2 = ((RadioGroup)this.getActivity().findViewById(2131296612)).getCheckedRadioButtonId();
         int var3 = ((RadioGroup)this.getActivity().findViewById(2131296617)).getCheckedRadioButtonId();
         int var4 = ((RadioGroup)this.getActivity().findViewById(2131296622)).getCheckedRadioButtonId();
         int var5 = ((RadioGroup)this.getActivity().findViewById(2131296627)).getCheckedRadioButtonId();
         int var6 = ((RadioGroup)this.getActivity().findViewById(2131296632)).getCheckedRadioButtonId();
         int var7;
         if(var2 == 2131296613) {
            var7 = 0 + 2;
         } else {
            var7 = 0;
            if(var2 == 2131296614) {
               var7 = 0 + 1;
            }
         }

         if(var3 == 2131296618) {
            var7 += 2;
         } else if(var3 == 2131296619) {
            ++var7;
         }

         if(var4 == 2131296623) {
            var7 += 2;
         } else if(var4 == 2131296624) {
            ++var7;
         }

         if(var5 == 2131296628) {
            var7 += 2;
         } else if(var5 == 2131296629) {
            ++var7;
         }

         if(var6 == 2131296633) {
            var7 += 2;
         } else if(var6 == 2131296634) {
            ++var7;
         }

         String var8;
         if(var7 < 3) {
            var8 = this.getResources().getText(2131034330).toString();
         } else if(var7 > 4) {
            var8 = this.getResources().getText(2131034332).toString();
         } else {
            var8 = this.getResources().getText(2131034331).toString();
         }

         ((TextView)this.getActivity().findViewById(2131296275)).setText(Integer.toString(var7));
         ((TextView)this.getActivity().findViewById(2131296275)).setTypeface(this.myTypeface2);
         ((TextView)this.getActivity().findViewById(2131296344)).setText(var8);
         ((TextView)this.getActivity().findViewById(2131296344)).setTypeface(this.myTypeface2);
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130903065, var2, false);
      this.myTypeface = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Bold.ttf");
      this.myTypeface2 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Thin.ttf");
      Button var5 = (Button)var4.findViewById(2131296273);
      var5.setOnClickListener(this);
      var5.setBackgroundColor(Color.parseColor("#1a237e"));
      var5.setTextColor(-1);
      return var4;
   }
}
