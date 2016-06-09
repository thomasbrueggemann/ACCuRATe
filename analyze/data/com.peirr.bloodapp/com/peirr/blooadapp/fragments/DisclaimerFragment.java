package com.peirr.blooadapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.peirr.blooadapp.fragments.LoginAndRegisterFragment;
import com.peirr.blooadapp.io.Settings;

public class DisclaimerFragment extends Fragment {
   private Settings settings;

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130903045, var2, false);
      if(this.getActivity() != null) {
         this.getActivity().getActionBar().setTitle("Blood App");
      }

      this.settings = new Settings(this.getActivity());
      ((CheckBox)var4.findViewById(2131427339)).setOnCheckedChangeListener(new OnCheckedChangeListener() {
         public void onCheckedChanged(CompoundButton var1, boolean var2) {
            DisclaimerFragment.this.settings.setBoolean("accepted", var2);
            if(var2) {
               DisclaimerFragment.this.getFragmentManager().beginTransaction().replace(2131427331, new LoginAndRegisterFragment()).commit();
            }

         }
      });
      return var4;
   }
}
