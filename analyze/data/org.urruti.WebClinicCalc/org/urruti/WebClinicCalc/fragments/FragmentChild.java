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

public class FragmentChild extends Fragment implements OnClickListener {
   public EditText age;
   public EditText crea;
   public Typeface myTypeface;
   public Typeface myTypeface2;

   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      Button var2 = (Button)this.getActivity().findViewById(2131296273);
      var2.setText(2131034148);
      var2.setTypeface(this.myTypeface);
      ((TextView)this.getActivity().findViewById(2131296258)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296258)).setText(this.getResources().getText(2131034426).toString());
      ((TextView)this.getActivity().findViewById(2131296312)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296312)).setText(this.getResources().getText(2131034428).toString());
      ((TextView)this.getActivity().findViewById(2131296318)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296318)).setText(this.getResources().getText(2131034427).toString());
      ((TextView)this.getActivity().findViewById(2131296324)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296324)).setText(this.getResources().getText(2131034429).toString());
      ((TextView)this.getActivity().findViewById(2131296330)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296330)).setText(this.getResources().getText(2131034430).toString());
      ((TextView)this.getActivity().findViewById(2131296336)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296336)).setText(this.getResources().getText(2131034431).toString());
      ((TextView)this.getActivity().findViewById(2131296275)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296438)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296439)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296440)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296443)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296444)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296445)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296448)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296449)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296450)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296453)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296454)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296455)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296458)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296459)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296460)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296438)).setText(2131034432);
      ((RadioButton)this.getActivity().findViewById(2131296439)).setText(2131034433);
      ((RadioButton)this.getActivity().findViewById(2131296440)).setText(2131034434);
      ((RadioButton)this.getActivity().findViewById(2131296443)).setText(2131034435);
      ((RadioButton)this.getActivity().findViewById(2131296444)).setText(2131034436);
      ((RadioButton)this.getActivity().findViewById(2131296445)).setText(2131034437);
      ((RadioButton)this.getActivity().findViewById(2131296448)).setText(2131034438);
      ((RadioButton)this.getActivity().findViewById(2131296449)).setText(2131034439);
      ((RadioButton)this.getActivity().findViewById(2131296450)).setText(2131034440);
      ((RadioButton)this.getActivity().findViewById(2131296453)).setText(2131034441);
      ((RadioButton)this.getActivity().findViewById(2131296454)).setText(2131034442);
      ((RadioButton)this.getActivity().findViewById(2131296455)).setText(2131034443);
      ((RadioButton)this.getActivity().findViewById(2131296458)).setText(2131034444);
      ((RadioButton)this.getActivity().findViewById(2131296459)).setText(2131034445);
      ((RadioButton)this.getActivity().findViewById(2131296460)).setText(2131034446);
   }

   public void onClick(View var1) {
      if(var1.getId() == 2131296273) {
         int var2 = ((RadioGroup)this.getActivity().findViewById(2131296437)).getCheckedRadioButtonId();
         int var3 = ((RadioGroup)this.getActivity().findViewById(2131296442)).getCheckedRadioButtonId();
         int var4 = ((RadioGroup)this.getActivity().findViewById(2131296447)).getCheckedRadioButtonId();
         int var5 = ((RadioGroup)this.getActivity().findViewById(2131296452)).getCheckedRadioButtonId();
         int var6 = ((RadioGroup)this.getActivity().findViewById(2131296457)).getCheckedRadioButtonId();
         int var7;
         if(var2 == 2131296438) {
            var7 = 0 + 1;
         } else if(var2 == 2131296439) {
            var7 = 0 + 2;
         } else {
            var7 = 0 + 3;
         }

         int var8;
         if(var3 == 2131296443) {
            var8 = var7 + 1;
         } else if(var3 == 2131296444) {
            var8 = var7 + 2;
         } else {
            var8 = var7 + 3;
         }

         int var9;
         if(var4 == 2131296448) {
            var9 = var8 + 1;
         } else if(var4 == 2131296449) {
            var9 = var8 + 2;
         } else {
            var9 = var8 + 3;
         }

         int var10;
         if(var5 == 2131296453) {
            var10 = var9 + 1;
         } else if(var5 == 2131296454) {
            var10 = var9 + 2;
         } else {
            var10 = var9 + 3;
         }

         int var11;
         if(var6 == 2131296458) {
            var11 = var10 + 1;
         } else if(var6 == 2131296459) {
            var11 = var10 + 2;
         } else {
            var11 = var10 + 3;
         }

         String var12;
         switch(var11) {
         case 5:
            var12 = this.getResources().getText(2131034447).toString();
            break;
         case 6:
            var12 = this.getResources().getText(2131034448).toString();
            break;
         case 7:
            var12 = this.getResources().getText(2131034449).toString();
            break;
         case 8:
            var12 = this.getResources().getText(2131034450).toString();
            break;
         case 9:
            var12 = this.getResources().getText(2131034451).toString();
            break;
         case 10:
            var12 = this.getResources().getText(2131034452).toString();
            break;
         case 11:
            var12 = this.getResources().getText(2131034453).toString();
            break;
         case 12:
            var12 = this.getResources().getText(2131034454).toString();
            break;
         case 13:
            var12 = this.getResources().getText(2131034455).toString();
            break;
         case 14:
            var12 = this.getResources().getText(2131034456).toString();
            break;
         case 15:
            var12 = this.getResources().getText(2131034457).toString();
            break;
         default:
            var12 = "Error";
         }

         ((TextView)this.getActivity().findViewById(2131296275)).setText(var12);
         ((TextView)this.getActivity().findViewById(2131296275)).setTypeface(this.myTypeface2);
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130903053, var2, false);
      this.myTypeface = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Bold.ttf");
      this.myTypeface2 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Thin.ttf");
      Button var5 = (Button)var4.findViewById(2131296273);
      var5.setOnClickListener(this);
      var5.setBackgroundColor(Color.parseColor("#1a237e"));
      var5.setTextColor(-1);
      return var4;
   }
}
