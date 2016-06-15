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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import java.util.Locale;

public class FragmentAxis extends Fragment {
   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      LayoutParams var2 = new LayoutParams(-1, -2);
      final EditText var3 = new EditText(this.getActivity().getBaseContext());
      var3.setInputType(4098);
      var3.setLayoutParams(var2);
      var3.setActivated(true);
      var3.setHint(this.getResources().getText(2131034157).toString());
      var3.setTextColor(17170444);
      var3.setBackgroundColor(-1);
      var3.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentAxis.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentAxis.this.getActivity().findViewById(2131296261)).setBackgroundColor(-16777216);
            }
         }
      });
      var3.setTextAppearance(this.getActivity(), 16974257);
      final EditText var4 = new EditText(this.getActivity().getBaseContext());
      var4.setInputType(4098);
      var4.setLayoutParams(var2);
      var4.setActivated(true);
      var4.setBackgroundColor(-1);
      var4.setHint(this.getResources().getText(2131034158).toString());
      var4.setTextColor(17170444);
      var4.setOnFocusChangeListener(new OnFocusChangeListener() {
         public void onFocusChange(View var1, boolean var2) {
            if(var2) {
               ((Button)FragmentAxis.this.getActivity().findViewById(2131296264)).setBackgroundColor(-16711681);
            } else {
               ((Button)FragmentAxis.this.getActivity().findViewById(2131296264)).setBackgroundColor(-16777216);
            }
         }
      });
      var4.setTextAppearance(this.getActivity(), 16974257);
      final TextView var5 = new TextView(this.getActivity().getBaseContext());
      var5.setVisibility(8);
      final TextView var6 = new TextView(this.getActivity().getBaseContext());
      Button var7 = new Button(this.getActivity().getBaseContext());
      var7.setText(this.getResources().getText(2131034148).toString());
      var7.setBackgroundColor(Color.parseColor("#1a237e"));
      var7.setTextColor(-1);
      var7.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(!var3.getText().toString().isEmpty() && !var4.getText().toString().isEmpty()) {
               float var2 = Float.parseFloat(var3.getText().toString());
               float var3x = Float.parseFloat(var4.getText().toString());
               var5.setVisibility(0);
               double var4x = 180.0D * Math.atan((double)(var3x / var2)) / 3.141592653589793D;
               if(var2 < 0.0F && var3x < 0.0F) {
                  var4x -= 180.0D;
               } else if(var2 < 0.0F) {
                  var4x += 180.0D;
               }

               var5.setText(Double.toString(var4x));
               if(Locale.getDefault().getDisplayLanguage().equals("Deutsch")) {
                  if(var4x > 120.0D) {
                     var6.setText(FragmentAxis.this.getResources().getText(2131034486).toString());
                     var6.setTextColor(-65536);
                  } else if(var4x < -150.0D) {
                     var6.setText(FragmentAxis.this.getResources().getText(2131034486).toString());
                     var6.setTextColor(-65536);
                  } else if(var4x > 90.0D) {
                     var6.setText(FragmentAxis.this.getResources().getText(2131034489).toString());
                     var6.setTextColor(Color.argb(255, 255, 153, 0));
                  } else if(var4x > 60.0D) {
                     var6.setText(FragmentAxis.this.getResources().getText(2131034487).toString());
                     var6.setTextColor(-256);
                  } else if(var4x > 30.0D) {
                     var6.setText(FragmentAxis.this.getResources().getText(2131034161).toString());
                     var6.setTextColor(-16711936);
                  } else {
                     var6.setText(FragmentAxis.this.getResources().getText(2131034488).toString());
                     var6.setTextColor(-16776961);
                  }
               } else if(var4x > 130.0D) {
                  var6.setText(FragmentAxis.this.getResources().getText(2131034160).toString());
                  var6.setTextColor(-65536);
               } else if(var4x < -90.0D) {
                  var6.setText(FragmentAxis.this.getResources().getText(2131034162).toString());
                  var6.setTextColor(-256);
                  Toast.makeText(FragmentAxis.this.getActivity(), FragmentAxis.this.getResources().getText(2131034164).toString(), 0).show();
               } else if(var4x < -30.0D) {
                  var6.setText(FragmentAxis.this.getResources().getText(2131034161).toString());
                  var6.setTextColor(-65536);
               } else {
                  var6.setText(FragmentAxis.this.getResources().getText(2131034163).toString());
                  var6.setTextColor(-16711936);
               }
            } else {
               Toast.makeText(FragmentAxis.this.getActivity(), FragmentAxis.this.getResources().getText(2131034150).toString(), 0).show();
            }
         }
      });
      Typeface var8 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Bold.ttf");
      Typeface var9 = Typeface.createFromAsset(this.getActivity().getAssets(), "font/Roboto-Thin.ttf");
      ((TextView)this.getActivity().findViewById(2131296258)).setTypeface(var9);
      ((TextView)this.getActivity().findViewById(2131296258)).setText(this.getResources().getText(2131034159).toString());
      var7.setTypeface(var8);
      var3.setTypeface(var9);
      var4.setTypeface(var9);
      var5.setTypeface(var9);
      var6.setTypeface(var8);
      var5.setTextColor(-16777216);
      var5.setTextSize(22.0F);
      var6.setTextSize(22.0F);
      ((LinearLayout)this.getActivity().findViewById(2131296352)).addView(var7);
      ((LinearLayout)this.getActivity().findViewById(2131296348)).addView(var3);
      ((LinearLayout)this.getActivity().findViewById(2131296350)).addView(var4);
      ((LinearLayout)this.getActivity().findViewById(2131296354)).addView(var5);
      ((LinearLayout)this.getActivity().findViewById(2131296356)).addView(var6);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2130903049, var2, false);
   }

   public void onStart() {
      super.onStart();
   }

   public void onStop() {
      super.onStop();
   }
}
