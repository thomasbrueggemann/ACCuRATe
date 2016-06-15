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

public class FragmentGlasgow extends Fragment implements OnClickListener {
   public EditText age;
   public EditText crea;
   public Typeface myTypeface;
   public Typeface myTypeface2;

   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      ((TextView)this.getActivity().findViewById(2131296258)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296258)).setText(this.getResources().getText(2131034265).toString());
      ((TextView)this.getActivity().findViewById(2131296312)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296312)).setText(this.getResources().getText(2131034266).toString());
      ((TextView)this.getActivity().findViewById(2131296318)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296318)).setText(this.getResources().getText(2131034267).toString());
      ((TextView)this.getActivity().findViewById(2131296324)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296324)).setText(this.getResources().getText(2131034268).toString());
      Button var2 = (Button)this.getActivity().findViewById(2131296273);
      var2.setText(this.getResources().getText(2131034148));
      var2.setTypeface(this.myTypeface);
      var2.setText(2131034148);
      ((TextView)this.getActivity().findViewById(2131296275)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296502)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296503)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296504)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296505)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296508)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296509)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296510)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296511)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296512)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296514)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296515)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296516)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296517)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296518)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296519)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296502)).setText(2131034250);
      ((RadioButton)this.getActivity().findViewById(2131296503)).setText(2131034251);
      ((RadioButton)this.getActivity().findViewById(2131296504)).setText(2131034252);
      ((RadioButton)this.getActivity().findViewById(2131296505)).setText(2131034253);
      ((RadioButton)this.getActivity().findViewById(2131296508)).setText(2131034254);
      ((RadioButton)this.getActivity().findViewById(2131296509)).setText(2131034255);
      ((RadioButton)this.getActivity().findViewById(2131296510)).setText(2131034256);
      ((RadioButton)this.getActivity().findViewById(2131296511)).setText(2131034257);
      ((RadioButton)this.getActivity().findViewById(2131296512)).setText(2131034258);
      ((RadioButton)this.getActivity().findViewById(2131296514)).setText(2131034259);
      ((RadioButton)this.getActivity().findViewById(2131296515)).setText(2131034260);
      ((RadioButton)this.getActivity().findViewById(2131296516)).setText(2131034261);
      ((RadioButton)this.getActivity().findViewById(2131296517)).setText(2131034262);
      ((RadioButton)this.getActivity().findViewById(2131296518)).setText(2131034263);
      ((RadioButton)this.getActivity().findViewById(2131296519)).setText(2131034264);
   }

   public void onClick(View var1) {
      if(var1.getId() == 2131296273) {
         int var2 = ((RadioGroup)this.getActivity().findViewById(2131296501)).getCheckedRadioButtonId();
         int var3 = ((RadioGroup)this.getActivity().findViewById(2131296507)).getCheckedRadioButtonId();
         int var4 = ((RadioGroup)this.getActivity().findViewById(2131296513)).getCheckedRadioButtonId();
         int var5 = 0;
         if(var2 == 2131296502) {
            var5 = 0 + 4;
         }

         if(var2 == 2131296503) {
            var5 += 3;
         }

         if(var2 == 2131296504) {
            var5 += 2;
         }

         if(var2 == 2131296505) {
            ++var5;
         }

         if(var3 == 2131296508) {
            var5 += 5;
         }

         if(var3 == 2131296509) {
            var5 += 4;
         }

         if(var3 == 2131296510) {
            var5 += 3;
         }

         if(var3 == 2131296511) {
            var5 += 2;
         }

         if(var3 == 2131296512) {
            ++var5;
         }

         if(var4 == 2131296514) {
            var5 += 6;
         }

         if(var4 == 2131296515) {
            var5 += 5;
         }

         if(var4 == 2131296516) {
            var5 += 4;
         }

         if(var4 == 2131296517) {
            var5 += 3;
         }

         if(var4 == 2131296518) {
            var5 += 2;
         }

         if(var4 == 2131296519) {
            ++var5;
         }

         String var6;
         switch(var5) {
         case 3:
            var6 = this.getResources().getText(2131034243).toString();
            break;
         case 4:
            var6 = this.getResources().getText(2131034243).toString();
            break;
         case 5:
            var6 = this.getResources().getText(2131034244).toString();
            break;
         case 6:
            var6 = this.getResources().getText(2131034244).toString();
            break;
         case 7:
            var6 = this.getResources().getText(2131034245).toString();
            break;
         case 8:
            var6 = this.getResources().getText(2131034245).toString();
            break;
         case 9:
            var6 = this.getResources().getText(2131034246).toString();
            break;
         case 10:
            var6 = this.getResources().getText(2131034246).toString();
            break;
         case 11:
            var6 = this.getResources().getText(2131034247).toString();
            break;
         case 12:
            var6 = this.getResources().getText(2131034247).toString();
            break;
         case 13:
            var6 = this.getResources().getText(2131034248).toString();
            break;
         case 14:
            var6 = this.getResources().getText(2131034248).toString();
            break;
         case 15:
            var6 = this.getResources().getText(2131034249).toString();
            break;
         default:
            var6 = "Error";
         }

         ((TextView)this.getActivity().findViewById(2131296275)).setText(Integer.toString(var5));
         ((TextView)this.getActivity().findViewById(2131296275)).setTypeface(this.myTypeface2);
         ((TextView)this.getActivity().findViewById(2131296344)).setText(var6);
         ((TextView)this.getActivity().findViewById(2131296344)).setTypeface(this.myTypeface2);
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130903057, var2, false);
      this.myTypeface = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Bold.ttf");
      this.myTypeface2 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Thin.ttf");
      Button var5 = (Button)var4.findViewById(2131296273);
      var5.setOnClickListener(this);
      var5.setBackgroundColor(Color.parseColor("#1a237e"));
      var5.setTextColor(-1);
      return var4;
   }
}
