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
import android.widget.RadioGroup;
import android.widget.TextView;

public class FragmentGrace extends Fragment implements OnClickListener {
   public EditText age;
   public EditText crea;
   public Typeface myTypeface;
   public Typeface myTypeface2;

   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      ((TextView)this.getActivity().findViewById(2131296258)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296258)).setText(this.getResources().getText(2131034168).toString());
      Button var2 = (Button)this.getActivity().findViewById(2131296273);
      var2.setText(2131034148);
      var2.setTypeface(this.myTypeface);
   }

   public void onClick(View var1) {
      if(var1.getId() == 2131296273) {
         int var2 = ((RadioGroup)this.getActivity().findViewById(2131296408)).getCheckedRadioButtonId();
         int var3 = ((RadioGroup)this.getActivity().findViewById(2131296412)).getCheckedRadioButtonId();
         int var4 = ((RadioGroup)this.getActivity().findViewById(2131296416)).getCheckedRadioButtonId();
         int var5 = ((RadioGroup)this.getActivity().findViewById(2131296421)).getCheckedRadioButtonId();
         int var6 = ((RadioGroup)this.getActivity().findViewById(2131296425)).getCheckedRadioButtonId();
         int var7 = ((RadioGroup)this.getActivity().findViewById(2131296429)).getCheckedRadioButtonId();
         int var8 = ((RadioGroup)this.getActivity().findViewById(2131296432)).getCheckedRadioButtonId();
         int var9 = 0;
         if(var2 == 2131296409) {
            var9 = 0 + 1;
         }

         if(var3 == 2131296413) {
            ++var9;
         }

         if(var4 == 2131296418) {
            ++var9;
         } else if(var4 == 2131296419) {
            var9 += 2;
         }

         if(var5 == 2131296422) {
            ++var9;
         }

         if(var6 == 2131296426) {
            ++var9;
         }

         if(var7 == 2131296430) {
            ++var9;
         }

         if(var8 == 2131296271) {
            ++var9;
         }

         String var10;
         switch(var9) {
         case 0:
            var10 = this.getResources().getText(2131034169).toString();
            break;
         case 1:
            var10 = this.getResources().getText(2131034170).toString();
            break;
         case 2:
            var10 = this.getResources().getText(2131034171).toString();
            break;
         case 3:
            var10 = this.getResources().getText(2131034172).toString();
            break;
         case 4:
            var10 = this.getResources().getText(2131034173).toString();
            break;
         case 5:
            var10 = this.getResources().getText(2131034174).toString();
            break;
         case 6:
            var10 = this.getResources().getText(2131034175).toString();
            break;
         case 7:
            var10 = this.getResources().getText(2131034176).toString();
            break;
         case 8:
            var10 = this.getResources().getText(2131034177).toString();
            break;
         case 9:
            var10 = this.getResources().getText(2131034178).toString();
            break;
         default:
            var10 = "Error";
         }

         ((TextView)this.getActivity().findViewById(2131296275)).setText(var10);
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
