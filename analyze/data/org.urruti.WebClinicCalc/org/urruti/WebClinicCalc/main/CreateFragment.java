package org.urruti.WebClinicCalc.main;

import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CreateFragment extends Fragment {
   public CreateFragment() {
      ActionBar var1 = this.getActivity().getActionBar();
      var1.setDisplayHomeAsUpEnabled(true);
      var1.setHomeButtonEnabled(true);
      var1.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1a237e")));
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2130903040, var2, false);
   }
}
