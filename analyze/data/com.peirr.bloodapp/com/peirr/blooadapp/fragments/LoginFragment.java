package com.peirr.blooadapp.fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.builder.Builders;
import com.peirr.blooadapp.io.Settings;

public class LoginFragment extends Fragment {
   protected static final String TAG = LoginFragment.class.getSimpleName();
   private EditText edPassword;
   private EditText edUsername;
   private ProgressDialog progress;
   private Settings settings;

   // $FF: synthetic method
   static ProgressDialog access$100(LoginFragment var0) {
      return var0.progress;
   }

   // $FF: synthetic method
   static Settings access$200(LoginFragment var0) {
      return var0.settings;
   }

   private void fetchData() {
      this.progress.show();
      ((Builders.class_8)((Builders.class_8)((Builders.class_8)Ion.with(this.getActivity(), (String)"http://indigostorage.co.za/bloodapp/index.php/firehose/login").setBodyParameter("email", this.edUsername.getText().toString())).setBodyParameter("password", this.edPassword.getText().toString())).setBodyParameter("format", "json")).asJsonObject().setCallback(new FutureCallback() {
         public void onCompleted(Exception param1, JsonObject param2) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130903046, var2, false);
      if(this.getActivity() != null) {
         this.getActivity().getActionBar().setTitle(this.getString(2131230726));
      }

      this.settings = new Settings(this.getActivity());
      Button var5 = (Button)var4.findViewById(2131427343);
      Button var6 = (Button)var4.findViewById(2131427342);
      this.edUsername = (EditText)var4.findViewById(2131427340);
      this.edPassword = (EditText)var4.findViewById(2131427341);
      this.progress = new ProgressDialog(this.getActivity());
      this.progress.setMessage(this.getString(2131230792));
      var5.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            LoginFragment.this.fetchData();
         }
      });
      var6.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            LoginFragment.this.getFragmentManager().popBackStack();
         }
      });
      return var4;
   }
}
