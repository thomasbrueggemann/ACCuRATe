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

public class FragmentApgar extends Fragment implements OnClickListener {
   public EditText age;
   public EditText crea;
   public Typeface myTypeface;
   public Typeface myTypeface2;

   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      ((TextView)this.getActivity().findViewById(2131296258)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296258)).setText(this.getResources().getText(2131034287).toString());
      ((TextView)this.getActivity().findViewById(2131296312)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296312)).setText(this.getResources().getText(2131034288).toString());
      ((TextView)this.getActivity().findViewById(2131296318)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296318)).setText(this.getResources().getText(2131034289).toString());
      ((TextView)this.getActivity().findViewById(2131296324)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296324)).setText(this.getResources().getText(2131034290).toString());
      ((TextView)this.getActivity().findViewById(2131296330)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296330)).setText(this.getResources().getText(2131034291).toString());
      ((TextView)this.getActivity().findViewById(2131296336)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296336)).setText(this.getResources().getText(2131034292).toString());
      Button var2 = (Button)this.getActivity().findViewById(2131296273);
      var2.setTypeface(this.myTypeface);
      var2.setText(2131034148);
      ((TextView)this.getActivity().findViewById(2131296275)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296316)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296315)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296314)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296322)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296321)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296320)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296328)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296327)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296326)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296334)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296333)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296332)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296340)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296339)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296338)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296316)).setText(2131034293);
      ((RadioButton)this.getActivity().findViewById(2131296315)).setText(2131034294);
      ((RadioButton)this.getActivity().findViewById(2131296314)).setText(2131034295);
      ((RadioButton)this.getActivity().findViewById(2131296322)).setText(2131034296);
      ((RadioButton)this.getActivity().findViewById(2131296321)).setText(2131034297);
      ((RadioButton)this.getActivity().findViewById(2131296320)).setText(2131034298);
      ((RadioButton)this.getActivity().findViewById(2131296328)).setText(2131034299);
      ((RadioButton)this.getActivity().findViewById(2131296327)).setText(2131034300);
      ((RadioButton)this.getActivity().findViewById(2131296326)).setText(2131034301);
      ((RadioButton)this.getActivity().findViewById(2131296334)).setText(2131034302);
      ((RadioButton)this.getActivity().findViewById(2131296333)).setText(2131034303);
      ((RadioButton)this.getActivity().findViewById(2131296332)).setText(2131034304);
      ((RadioButton)this.getActivity().findViewById(2131296340)).setText(2131034305);
      ((RadioButton)this.getActivity().findViewById(2131296339)).setText(2131034306);
      ((RadioButton)this.getActivity().findViewById(2131296338)).setText(2131034307);
   }

   public void onClick(View var1) {
      if(var1.getId() == 2131296273) {
         int var2 = ((RadioGroup)this.getActivity().findViewById(2131296313)).getCheckedRadioButtonId();
         int var3 = ((RadioGroup)this.getActivity().findViewById(2131296319)).getCheckedRadioButtonId();
         int var4 = ((RadioGroup)this.getActivity().findViewById(2131296325)).getCheckedRadioButtonId();
         int var5 = ((RadioGroup)this.getActivity().findViewById(2131296331)).getCheckedRadioButtonId();
         int var6 = ((RadioGroup)this.getActivity().findViewById(2131296337)).getCheckedRadioButtonId();
         int var7;
         if(var2 == 2131296314) {
            var7 = 0 + 2;
         } else {
            var7 = 0;
            if(var2 == 2131296315) {
               var7 = 0 + 1;
            }
         }

         if(var3 == 2131296320) {
            var7 += 2;
         } else if(var3 == 2131296321) {
            ++var7;
         }

         if(var4 == 2131296326) {
            var7 += 2;
         } else if(var4 == 2131296327) {
            ++var7;
         }

         if(var5 == 2131296332) {
            var7 += 2;
         } else if(var5 == 2131296333) {
            ++var7;
         }

         if(var6 == 2131296338) {
            var7 += 2;
         } else if(var6 == 2131296339) {
            ++var7;
         }

         ((TextView)this.getActivity().findViewById(2131296275)).setText(Integer.toString(var7));
         ((TextView)this.getActivity().findViewById(2131296275)).setTypeface(this.myTypeface2);
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130903048, var2, false);
      this.myTypeface = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Bold.ttf");
      this.myTypeface2 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Thin.ttf");
      Button var5 = (Button)var4.findViewById(2131296273);
      var5.setOnClickListener(this);
      var5.setBackgroundColor(Color.parseColor("#1a237e"));
      var5.setTextColor(-1);
      return var4;
   }
}
