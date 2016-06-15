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

public class Fagerstrom extends Fragment implements OnClickListener {
   public EditText age;
   public EditText crea;
   public Typeface myTypeface;
   public Typeface myTypeface2;

   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      ((TextView)this.getActivity().findViewById(2131296258)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296258)).setText(this.getResources().getText(2131034394).toString());
      Button var2 = (Button)this.getActivity().findViewById(2131296273);
      var2.setText(2131034148);
      var2.setTypeface(this.myTypeface);
      ((TextView)this.getActivity().findViewById(2131296312)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296312)).setText(this.getResources().getText(2131034410).toString());
      ((TextView)this.getActivity().findViewById(2131296318)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296318)).setText(this.getResources().getText(2131034411).toString());
      ((TextView)this.getActivity().findViewById(2131296324)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296324)).setText(this.getResources().getText(2131034412).toString());
      ((TextView)this.getActivity().findViewById(2131296330)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296330)).setText(this.getResources().getText(2131034413).toString());
      ((TextView)this.getActivity().findViewById(2131296336)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296336)).setText(this.getResources().getText(2131034414).toString());
      ((TextView)this.getActivity().findViewById(2131296388)).setText(this.getResources().getText(2131034415).toString());
      ((TextView)this.getActivity().findViewById(2131296388)).setTypeface(this.myTypeface2);
      ((TextView)this.getActivity().findViewById(2131296275)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296656)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296657)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296658)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296661)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296662)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296665)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296666)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296669)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296670)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296671)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296672)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296675)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296676)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296679)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296680)).setTypeface(this.myTypeface2);
      ((RadioButton)this.getActivity().findViewById(2131296656)).setText(2131034395);
      ((RadioButton)this.getActivity().findViewById(2131296657)).setText(2131034396);
      ((RadioButton)this.getActivity().findViewById(2131296658)).setText(2131034397);
      ((RadioButton)this.getActivity().findViewById(2131296661)).setText(2131034398);
      ((RadioButton)this.getActivity().findViewById(2131296662)).setText(2131034399);
      ((RadioButton)this.getActivity().findViewById(2131296665)).setText(2131034400);
      ((RadioButton)this.getActivity().findViewById(2131296666)).setText(2131034401);
      ((RadioButton)this.getActivity().findViewById(2131296669)).setText(2131034402);
      ((RadioButton)this.getActivity().findViewById(2131296670)).setText(2131034403);
      ((RadioButton)this.getActivity().findViewById(2131296671)).setText(2131034404);
      ((RadioButton)this.getActivity().findViewById(2131296672)).setText(2131034405);
      ((RadioButton)this.getActivity().findViewById(2131296675)).setText(2131034406);
      ((RadioButton)this.getActivity().findViewById(2131296676)).setText(2131034407);
      ((RadioButton)this.getActivity().findViewById(2131296679)).setText(2131034408);
      ((RadioButton)this.getActivity().findViewById(2131296680)).setText(2131034409);
   }

   public void onClick(View var1) {
      if(var1.getId() == 2131296273) {
         int var2 = ((RadioGroup)this.getActivity().findViewById(2131296655)).getCheckedRadioButtonId();
         int var3 = ((RadioGroup)this.getActivity().findViewById(2131296660)).getCheckedRadioButtonId();
         int var4 = ((RadioGroup)this.getActivity().findViewById(2131296664)).getCheckedRadioButtonId();
         int var5 = ((RadioGroup)this.getActivity().findViewById(2131296668)).getCheckedRadioButtonId();
         int var6 = ((RadioGroup)this.getActivity().findViewById(2131296674)).getCheckedRadioButtonId();
         int var7 = ((RadioGroup)this.getActivity().findViewById(2131296678)).getCheckedRadioButtonId();
         int var8;
         if(var2 == 2131296656) {
            var8 = 0 + 3;
         } else if(var2 == 2131296657) {
            var8 = 0 + 2;
         } else {
            var8 = 0 + 1;
         }

         if(var3 == 2131296662) {
            ++var8;
         }

         if(var4 == 2131296665) {
            ++var8;
         }

         if(var5 == 2131296672) {
            var8 += 3;
         } else if(var5 == 2131296671) {
            var8 += 2;
         } else if(var5 == 2131296670) {
            ++var8;
         }

         if(var6 == 2131296675) {
            ++var8;
         }

         if(var7 == 2131296679) {
            ++var8;
         }

         String var9;
         switch(var8) {
         case 0:
            var9 = this.getResources().getText(2131034169).toString();
            break;
         case 1:
            var9 = this.getResources().getText(2131034416).toString();
            break;
         case 2:
            var9 = this.getResources().getText(2131034417).toString();
            break;
         case 3:
            var9 = this.getResources().getText(2131034418).toString();
            break;
         case 4:
            var9 = this.getResources().getText(2131034419).toString();
            break;
         case 5:
            var9 = this.getResources().getText(2131034420).toString();
            break;
         case 6:
            var9 = this.getResources().getText(2131034421).toString();
            break;
         case 7:
            var9 = this.getResources().getText(2131034422).toString();
            break;
         case 8:
            var9 = this.getResources().getText(2131034423).toString();
            break;
         case 9:
            var9 = this.getResources().getText(2131034424).toString();
            break;
         case 10:
            var9 = this.getResources().getText(2131034425).toString();
            break;
         default:
            var9 = "Error";
         }

         ((TextView)this.getActivity().findViewById(2131296275)).setText(var9);
         ((TextView)this.getActivity().findViewById(2131296275)).setTypeface(this.myTypeface2);
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130903067, var2, false);
      this.myTypeface = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Bold.ttf");
      this.myTypeface2 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Thin.ttf");
      Button var5 = (Button)var4.findViewById(2131296273);
      var5.setOnClickListener(this);
      var5.setBackgroundColor(Color.parseColor("#1a237e"));
      var5.setTextColor(-1);
      return var4;
   }
}
