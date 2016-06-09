package com.peirr.blooadapp.fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.builder.Builders;
import com.peirr.blooadapp.io.Settings;

public class RegisterFragment extends Fragment {
   protected static final String TAG = RegisterFragment.class.getSimpleName();
   private EditText edConfirmPassword;
   private Spinner edCountry;
   private EditText edEmail;
   private EditText edHospital;
   private EditText edName;
   private EditText edPassword;
   private EditText edPosition;
   private EditText edProfession;
   private ProgressDialog progress;
   private Settings settings;

   // $FF: synthetic method
   static ProgressDialog access$200(RegisterFragment var0) {
      return var0.progress;
   }

   // $FF: synthetic method
   static Settings access$300(RegisterFragment var0) {
      return var0.settings;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130903055, var2, false);
      if(this.getActivity() != null) {
         this.getActivity().getActionBar().setTitle("Blood App");
      }

      this.progress = new ProgressDialog(this.getActivity());
      this.progress.setMessage(this.getString(2131230792));
      this.settings = new Settings(this.getActivity());
      Button var5 = (Button)var4.findViewById(2131427377);
      this.edName = (EditText)var4.findViewById(2131427370);
      this.edCountry = (Spinner)var4.findViewById(2131427371);
      this.edHospital = (EditText)var4.findViewById(2131427372);
      this.edPosition = (EditText)var4.findViewById(2131427373);
      this.edProfession = (EditText)var4.findViewById(2131427373);
      this.edEmail = (EditText)var4.findViewById(2131427375);
      this.edPassword = (EditText)var4.findViewById(2131427341);
      this.edConfirmPassword = (EditText)var4.findViewById(2131427376);
      this.edCountry.setOnItemSelectedListener(new OnItemSelectedListener() {
         public void onItemSelected(AdapterView<?> var1, View var2, int var3, long var4) {
         }

         public void onNothingSelected(AdapterView<?> var1) {
         }
      });
      var5.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(RegisterFragment.this.edPassword.getText().toString().equals(RegisterFragment.this.edConfirmPassword.getText().toString())) {
               RegisterFragment.this.registerUser();
            } else {
               RegisterFragment.this.edConfirmPassword.setError("Password Mismatch");
            }
         }
      });
      return var4;
   }

   public void registerUser() {
      this.progress.show();
      ((Builders.class_8)((Builders.class_8)((Builders.class_8)((Builders.class_8)((Builders.class_8)((Builders.class_8)((Builders.class_8)((Builders.class_8)Ion.with(this.getActivity(), (String)"http://indigostorage.co.za/bloodapp/index.php/firehose/register").setBodyParameter("name", this.edName.getText().toString())).setBodyParameter("country", this.edCountry.getSelectedItem().toString())).setBodyParameter("hospital", this.edHospital.getText().toString())).setBodyParameter("position", this.edPosition.getText().toString())).setBodyParameter("profession", this.edProfession.getText().toString())).setBodyParameter("email", this.edEmail.getText().toString())).setBodyParameter("password", this.edPassword.getText().toString())).setBodyParameter("format", "json")).asJsonObject().setCallback(new FutureCallback() {
         public void onCompleted(Exception param1, JsonObject param2) {
            // $FF: Couldn't be decompiled
         }
      });
   }
}
