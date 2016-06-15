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

public class FragmentGOLD extends Fragment implements OnClickListener {
   public EditText age;
   public EditText crea;
   public Typeface myTypeface;
   public Typeface myTypeface2;

   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      ((TextView)this.getActivity().findViewById(2131296258)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296258)).setText(this.getResources().getText(2131034276).toString());
      ((TextView)this.getActivity().findViewById(2131296312)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296312)).setText(this.getResources().getText(2131034281).toString());
      ((TextView)this.getActivity().findViewById(2131296318)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296318)).setText(this.getResources().getText(2131034282).toString());
      ((TextView)this.getActivity().findViewById(2131296324)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296324)).setText(this.getResources().getText(2131034283).toString());
      Button var2 = (Button)this.getActivity().findViewById(2131296273);
      var2.setTypeface(this.myTypeface);
      var2.setText(2131034148);
      ((TextView)this.getActivity().findViewById(2131296275)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296525)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296526)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296529)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296530)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296533)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296534)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296525)).setText(2131034270);
      ((RadioButton)this.getActivity().findViewById(2131296526)).setText(2131034271);
      ((RadioButton)this.getActivity().findViewById(2131296529)).setText(2131034272);
      ((RadioButton)this.getActivity().findViewById(2131296530)).setText(2131034273);
      ((RadioButton)this.getActivity().findViewById(2131296533)).setText(2131034275);
      ((RadioButton)this.getActivity().findViewById(2131296534)).setText(2131034274);
   }

   public void onClick(View var1) {
      if(var1.getId() == 2131296273) {
         int var2 = ((RadioGroup)this.getActivity().findViewById(2131296524)).getCheckedRadioButtonId();
         int var3 = ((RadioGroup)this.getActivity().findViewById(2131296528)).getCheckedRadioButtonId();
         int var4 = ((RadioGroup)this.getActivity().findViewById(2131296532)).getCheckedRadioButtonId();
         String var5;
         if(var2 == 2131296525 && var3 == 2131296530) {
            if(var4 == 2131296533) {
               var5 = this.getResources().getText(2131034277).toString();
            } else {
               var5 = this.getResources().getText(2131034278).toString();
            }
         } else if(var4 == 2131296533) {
            var5 = this.getResources().getText(2131034279).toString();
         } else {
            var5 = this.getResources().getText(2131034280).toString();
         }

         ((TextView)this.getActivity().findViewById(2131296275)).setText(var5);
         ((TextView)this.getActivity().findViewById(2131296275)).setTypeface(this.myTypeface2);
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130903058, var2, false);
      this.myTypeface = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Bold.ttf");
      this.myTypeface2 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Thin.ttf");
      Button var5 = (Button)var4.findViewById(2131296273);
      var5.setOnClickListener(this);
      var5.setBackgroundColor(Color.parseColor("#1a237e"));
      var5.setTextColor(-1);
      return var4;
   }
}
