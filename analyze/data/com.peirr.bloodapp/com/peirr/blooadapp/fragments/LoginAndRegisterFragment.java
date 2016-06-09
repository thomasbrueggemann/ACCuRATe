package com.peirr.blooadapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.peirr.blooadapp.fragments.LoginFragment;
import com.peirr.blooadapp.fragments.RegisterFragment;

public class LoginAndRegisterFragment extends Fragment {
   public static final String TAG = LoginAndRegisterFragment.class.getSimpleName();

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130903047, var2, false);
      this.getActivity().getActionBar().setTitle("Welcome");
      Button var5 = (Button)var4.findViewById(2131427344);
      Button var6 = (Button)var4.findViewById(2131427345);
      var5.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            LoginAndRegisterFragment.this.getFragmentManager().beginTransaction().replace(2131427331, new LoginFragment()).addToBackStack(LoginFragment.TAG).commit();
         }
      });
      var6.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            LoginAndRegisterFragment.this.getFragmentManager().beginTransaction().replace(2131427331, new RegisterFragment()).addToBackStack((String)null).commit();
         }
      });
      return var4;
   }
}
