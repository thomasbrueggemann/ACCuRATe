package com.peirr.blooadapp.wizard.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.peirr.blooadapp.wizard.model.doctor.DoctorInfoPage;
import com.peirr.blooadapp.wizard.ui.PageFragmentCallbacks;

public class DoctorInfoFragment extends Fragment {
   private static final String ARG_KEY = "key";
   private PageFragmentCallbacks mCallbacks;
   private TextView mEmailView;
   private String mKey;
   private TextView mNameView;
   private DoctorInfoPage mPage;
   private TextView passwordView;

   public static DoctorInfoFragment create(String var0) {
      Bundle var1 = new Bundle();
      var1.putString("key", var0);
      DoctorInfoFragment var2 = new DoctorInfoFragment();
      var2.setArguments(var1);
      return var2;
   }

   public void onAttach(Activity var1) {
      super.onAttach(var1);
      if(!(var1 instanceof PageFragmentCallbacks)) {
         throw new ClassCastException("Activity must implement PageFragmentCallbacks");
      } else {
         this.mCallbacks = (PageFragmentCallbacks)var1;
      }
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.mKey = this.getArguments().getString("key");
      this.mPage = (DoctorInfoPage)this.mCallbacks.onGetPage(this.mKey);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130903049, var2, false);
      ((TextView)var4.findViewById(16908310)).setText(this.mPage.getTitle());
      this.mNameView = (TextView)var4.findViewById(2131427346);
      this.mNameView.setText(this.mPage.getData().getString("name"));
      this.mEmailView = (TextView)var4.findViewById(2131427347);
      this.mEmailView.setText(this.mPage.getData().getString("email"));
      this.passwordView = (TextView)var4.findViewById(2131427348);
      this.passwordView.setText(this.mPage.getData().getString("password"));
      return var4;
   }

   public void onDetach() {
      super.onDetach();
      this.mCallbacks = null;
   }

   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.mNameView.addTextChangedListener(new TextWatcher() {
         public void afterTextChanged(Editable var1) {
            Bundle var2 = DoctorInfoFragment.this.mPage.getData();
            String var3;
            if(var1 != null) {
               var3 = var1.toString();
            } else {
               var3 = null;
            }

            var2.putString("name", var3);
            DoctorInfoFragment.this.mPage.notifyDataChanged();
         }

         public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }
      });
      this.mEmailView.addTextChangedListener(new TextWatcher() {
         public void afterTextChanged(Editable var1) {
            Bundle var2 = DoctorInfoFragment.this.mPage.getData();
            String var3;
            if(var1 != null) {
               var3 = var1.toString();
            } else {
               var3 = null;
            }

            var2.putString("email", var3);
            DoctorInfoFragment.this.mPage.notifyDataChanged();
         }

         public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }
      });
      this.passwordView.addTextChangedListener(new TextWatcher() {
         public void afterTextChanged(Editable var1) {
            Bundle var2 = DoctorInfoFragment.this.mPage.getData();
            String var3;
            if(var1 != null) {
               var3 = var1.toString();
            } else {
               var3 = null;
            }

            var2.putString("password", var3);
            DoctorInfoFragment.this.mPage.notifyDataChanged();
         }

         public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }
      });
   }

   public void setMenuVisibility(boolean var1) {
      super.setMenuVisibility(var1);
      if(this.mNameView != null) {
         InputMethodManager var2 = (InputMethodManager)this.getActivity().getSystemService("input_method");
         if(!var1) {
            var2.hideSoftInputFromWindow(this.getView().getWindowToken(), 0);
         }
      }

   }
}
