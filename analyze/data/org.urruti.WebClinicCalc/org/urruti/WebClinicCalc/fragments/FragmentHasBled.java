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

public class FragmentHasBled extends Fragment implements OnClickListener {
   public EditText age;
   public EditText crea;
   public Typeface myTypeface;
   public Typeface myTypeface2;

   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      ((TextView)this.getActivity().findViewById(2131296258)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296258)).setText(this.getResources().getText(2131034228).toString());
      Button var2 = (Button)this.getActivity().findViewById(2131296565);
      var2.setTypeface(this.myTypeface);
      var2.setText(2131034148);
      ((RadioButton)this.getActivity().findViewById(2131296413)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296414)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296541)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296540)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296544)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296545)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296427)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296426)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296550)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296549)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296553)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296554)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296418)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296417)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296559)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296558)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296562)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296563)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296413)).setText(2131034192);
      ((RadioButton)this.getActivity().findViewById(2131296414)).setText(2131034193);
      ((RadioButton)this.getActivity().findViewById(2131296426)).setText(2131034200);
      ((RadioButton)this.getActivity().findViewById(2131296427)).setText(2131034201);
      ((RadioButton)this.getActivity().findViewById(2131296540)).setText(2131034208);
      ((RadioButton)this.getActivity().findViewById(2131296541)).setText(2131034209);
      ((RadioButton)this.getActivity().findViewById(2131296544)).setText(2131034206);
      ((RadioButton)this.getActivity().findViewById(2131296545)).setText(2131034207);
      ((RadioButton)this.getActivity().findViewById(2131296549)).setText(2131034210);
      ((RadioButton)this.getActivity().findViewById(2131296550)).setText(2131034211);
      ((RadioButton)this.getActivity().findViewById(2131296553)).setText(2131034212);
      ((RadioButton)this.getActivity().findViewById(2131296554)).setText(2131034213);
      ((RadioButton)this.getActivity().findViewById(2131296417)).setText(2131034194);
      ((RadioButton)this.getActivity().findViewById(2131296418)).setText(2131034196);
      ((RadioButton)this.getActivity().findViewById(2131296558)).setText(2131034202);
      ((RadioButton)this.getActivity().findViewById(2131296559)).setText(2131034203);
      ((RadioButton)this.getActivity().findViewById(2131296562)).setText(2131034216);
      ((RadioButton)this.getActivity().findViewById(2131296563)).setText(2131034217);
   }

   public void onClick(View var1) {
      if(var1.getId() == 2131296565) {
         int var2 = ((RadioGroup)this.getActivity().findViewById(2131296537)).getCheckedRadioButtonId();
         int var3 = ((RadioGroup)this.getActivity().findViewById(2131296539)).getCheckedRadioButtonId();
         int var4 = ((RadioGroup)this.getActivity().findViewById(2131296543)).getCheckedRadioButtonId();
         int var5 = ((RadioGroup)this.getActivity().findViewById(2131296425)).getCheckedRadioButtonId();
         int var6 = ((RadioGroup)this.getActivity().findViewById(2131296548)).getCheckedRadioButtonId();
         int var7 = ((RadioGroup)this.getActivity().findViewById(2131296552)).getCheckedRadioButtonId();
         int var8 = ((RadioGroup)this.getActivity().findViewById(2131296416)).getCheckedRadioButtonId();
         int var9 = ((RadioGroup)this.getActivity().findViewById(2131296557)).getCheckedRadioButtonId();
         int var10 = ((RadioGroup)this.getActivity().findViewById(2131296561)).getCheckedRadioButtonId();
         int var11 = 0;
         if(var2 == 2131296413) {
            var11 = 0 + 1;
         }

         if(var3 == 2131296540) {
            ++var11;
         }

         if(var4 == 2131296544) {
            ++var11;
         }

         if(var5 == 2131296426) {
            ++var11;
         }

         if(var6 == 2131296549) {
            ++var11;
         }

         if(var7 == 2131296553) {
            ++var11;
         }

         if(var8 == 2131296418) {
            ++var11;
         }

         if(var9 == 2131296558) {
            ++var11;
         }

         if(var10 == 2131296562) {
            ++var11;
         }

         String var12;
         switch(var11) {
         case 0:
            var12 = this.getResources().getText(2131034179).toString();
            break;
         case 1:
            var12 = this.getResources().getText(2131034180).toString();
            break;
         case 2:
            var12 = this.getResources().getText(2131034181).toString();
            break;
         case 3:
            var12 = this.getResources().getText(2131034182).toString();
            break;
         case 4:
            var12 = this.getResources().getText(2131034183).toString();
            break;
         case 5:
            var12 = this.getResources().getText(2131034184).toString();
            break;
         case 6:
            var12 = this.getResources().getText(2131034185).toString();
            break;
         case 7:
            var12 = this.getResources().getText(2131034186).toString();
            break;
         case 8:
            var12 = this.getResources().getText(2131034187).toString();
            break;
         case 9:
            var12 = this.getResources().getText(2131034188).toString();
            break;
         default:
            var12 = "Error";
         }

         ((TextView)this.getActivity().findViewById(2131296275)).setText(var12);
         ((TextView)this.getActivity().findViewById(2131296275)).setTypeface(this.myTypeface2);
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130903060, var2, false);
      this.myTypeface = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Bold.ttf");
      this.myTypeface2 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Thin.ttf");
      Button var5 = (Button)var4.findViewById(2131296565);
      var5.setOnClickListener(this);
      var5.setBackgroundColor(Color.parseColor("#1a237e"));
      var5.setTextColor(-1);
      return var4;
   }
}
