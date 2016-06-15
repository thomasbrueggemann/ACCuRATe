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

public class Bronquiolitis extends Fragment implements OnClickListener {
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
      ((TextView)this.getActivity().findViewById(2131296258)).setText(this.getResources().getText(2131034351).toString());
      ((TextView)this.getActivity().findViewById(2131296312)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296312)).setText(this.getResources().getText(2131034352).toString());
      ((TextView)this.getActivity().findViewById(2131296318)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296318)).setText(this.getResources().getText(2131034353).toString());
      ((TextView)this.getActivity().findViewById(2131296324)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296324)).setText(this.getResources().getText(2131034354).toString());
      ((TextView)this.getActivity().findViewById(2131296330)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296330)).setText(this.getResources().getText(2131034355).toString());
      ((TextView)this.getActivity().findViewById(2131296336)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296388)).setText(this.getResources().getText(2131034357).toString());
      ((TextView)this.getActivity().findViewById(2131296388)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296336)).setText(this.getResources().getText(2131034356).toString());
      ((TextView)this.getActivity().findViewById(2131296275)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296361)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296363)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296362)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296364)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296367)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296368)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296369)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296370)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296373)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296374)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296375)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296376)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296379)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296380)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296383)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296385)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296386)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296384)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296391)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296390)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296361)).setText(2131034358);
      ((RadioButton)this.getActivity().findViewById(2131296363)).setText(2131034359);
      ((RadioButton)this.getActivity().findViewById(2131296362)).setText(2131034360);
      ((RadioButton)this.getActivity().findViewById(2131296364)).setText(2131034361);
      ((RadioButton)this.getActivity().findViewById(2131296367)).setText(2131034362);
      ((RadioButton)this.getActivity().findViewById(2131296368)).setText(2131034363);
      ((RadioButton)this.getActivity().findViewById(2131296369)).setText(2131034364);
      ((RadioButton)this.getActivity().findViewById(2131296370)).setText(2131034365);
      ((RadioButton)this.getActivity().findViewById(2131296373)).setText(2131034366);
      ((RadioButton)this.getActivity().findViewById(2131296374)).setText(2131034367);
      ((RadioButton)this.getActivity().findViewById(2131296375)).setText(2131034368);
      ((RadioButton)this.getActivity().findViewById(2131296376)).setText(2131034369);
      ((RadioButton)this.getActivity().findViewById(2131296379)).setText(2131034370);
      ((RadioButton)this.getActivity().findViewById(2131296380)).setText(2131034371);
      ((RadioButton)this.getActivity().findViewById(2131296383)).setText(2131034372);
      ((RadioButton)this.getActivity().findViewById(2131296385)).setText(2131034373);
      ((RadioButton)this.getActivity().findViewById(2131296386)).setText(2131034374);
      ((RadioButton)this.getActivity().findViewById(2131296384)).setText(2131034375);
      ((RadioButton)this.getActivity().findViewById(2131296391)).setText(2131034376);
      ((RadioButton)this.getActivity().findViewById(2131296390)).setText(2131034377);
   }

   public void onClick(View var1) {
      if(var1.getId() == 2131296273) {
         int var2 = ((RadioGroup)this.getActivity().findViewById(2131296360)).getCheckedRadioButtonId();
         int var3 = ((RadioGroup)this.getActivity().findViewById(2131296366)).getCheckedRadioButtonId();
         int var4 = ((RadioGroup)this.getActivity().findViewById(2131296372)).getCheckedRadioButtonId();
         int var5 = ((RadioGroup)this.getActivity().findViewById(2131296378)).getCheckedRadioButtonId();
         int var6 = ((RadioGroup)this.getActivity().findViewById(2131296382)).getCheckedRadioButtonId();
         int var7 = ((RadioGroup)this.getActivity().findViewById(2131296389)).getCheckedRadioButtonId();
         int var8;
         if(var2 == 2131296362) {
            var8 = 0 + 1;
         } else if(var2 == 2131296363) {
            var8 = 0 + 2;
         } else {
            var8 = 0;
            if(var2 == 2131296364) {
               var8 = 0 + 3;
            }
         }

         if(var3 == 2131296368) {
            ++var8;
         } else if(var3 == 2131296369) {
            var8 += 2;
         } else if(var3 == 2131296370) {
            var8 += 3;
         }

         if(var4 == 2131296374) {
            ++var8;
         } else if(var4 == 2131296375) {
            var8 += 2;
         } else if(var4 == 2131296376) {
            var8 += 3;
         }

         if(var5 == 2131296380) {
            ++var8;
         }

         if(var6 == 2131296384) {
            ++var8;
         } else if(var6 == 2131296385) {
            var8 += 2;
         } else if(var6 == 2131296386) {
            var8 += 3;
         }

         if(var7 == 2131296390) {
            ++var8;
         }

         String var9;
         switch(var8) {
         case 0:
            var9 = this.getResources().getText(2131034378).toString();
            break;
         case 1:
            var9 = this.getResources().getText(2131034379).toString();
            break;
         case 2:
            var9 = this.getResources().getText(2131034380).toString();
            break;
         case 3:
            var9 = this.getResources().getText(2131034381).toString();
            break;
         case 4:
            var9 = this.getResources().getText(2131034382).toString();
            break;
         case 5:
            var9 = this.getResources().getText(2131034383).toString();
            break;
         case 6:
            var9 = this.getResources().getText(2131034384).toString();
            break;
         case 7:
            var9 = this.getResources().getText(2131034385).toString();
            break;
         case 8:
            var9 = this.getResources().getText(2131034386).toString();
            break;
         case 9:
            var9 = this.getResources().getText(2131034387).toString();
            break;
         case 10:
            var9 = this.getResources().getText(2131034388).toString();
            break;
         case 11:
            var9 = this.getResources().getText(2131034389).toString();
            break;
         case 12:
            var9 = this.getResources().getText(2131034390).toString();
            break;
         case 13:
            var9 = this.getResources().getText(2131034391).toString();
            break;
         case 14:
            var9 = this.getResources().getText(2131034392).toString();
            break;
         default:
            var9 = "Error";
         }

         ((TextView)this.getActivity().findViewById(2131296275)).setText(var9);
         ((TextView)this.getActivity().findViewById(2131296275)).setTypeface(this.myTypeface2);
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130903050, var2, false);
      this.myTypeface = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Bold.ttf");
      this.myTypeface2 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Thin.ttf");
      Button var5 = (Button)var4.findViewById(2131296273);
      var5.setOnClickListener(this);
      var5.setBackgroundColor(Color.parseColor("#1a237e"));
      var5.setTextColor(-1);
      return var4;
   }
}
