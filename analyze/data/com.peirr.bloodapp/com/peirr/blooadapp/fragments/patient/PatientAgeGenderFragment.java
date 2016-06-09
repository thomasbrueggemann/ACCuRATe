package com.peirr.blooadapp.fragments.patient;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.peirr.blooadapp.fragments.patient.BasePatientFragment;
import com.peirr.blooadapp.io.Cache;
import com.peirr.blooadapp.io.ViewUtil;
import com.peirr.blooadapp.wizard.model.Page;
import com.peirr.blooadapp.wizard.model.patient.PatientAgeGenderPage;
import com.peirr.blooadapp.wizard.ui.BATextWatcher;
import com.peirr.blooadapp.wizard.ui.PageFragmentCallbacks;

public class PatientAgeGenderFragment extends BasePatientFragment {
   private static final String ARG_KEY = "key";
   private PageFragmentCallbacks mCallbacks;
   private String mKey;
   private PatientAgeGenderPage mPage;
   private TextView patient_age;
   private Switch patient_gender;
   private View rootView;

   public static PatientAgeGenderFragment create(String var0) {
      Bundle var1 = new Bundle();
      var1.putString("key", var0);
      PatientAgeGenderFragment var2 = new PatientAgeGenderFragment();
      var2.setArguments(var1);
      return var2;
   }

   public Page getPage() {
      return this.mPage;
   }

   public View getRootView() {
      return this.rootView;
   }

   public Switch getSwitch() {
      return this.patient_gender;
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
      this.mPage = (PatientAgeGenderPage)this.mCallbacks.onGetPage(this.mKey);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.init();
      this.rootView = var1.inflate(2130903050, var2, false);
      ((TextView)this.rootView.findViewById(16908310)).setText(this.mPage.getTitle());
      this.patient_age = (TextView)this.rootView.findViewById(2131427349);
      this.patient_age.setText(this.mPage.getData().getString("age"));
      this.patient_gender = (Switch)this.rootView.findViewById(2131427350);
      Bundle var4 = this.mPage.getData();
      String var5;
      if(Cache.getInstance().isFemale()) {
         var5 = "1";
      } else {
         var5 = "0";
      }

      var4.putString("gender", var5);
      if(var3 == null) {
         ViewUtil.changeBackGround(this.getActivity(), this.getRootView(), this.patient_gender, this.gender);
      }

      return this.rootView;
   }

   public void onDetach() {
      super.onDetach();
      this.mCallbacks = null;
   }

   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.patient_age.addTextChangedListener(new BATextWatcher() {
         public void afterTextChanged(Editable var1) {
            Bundle var2 = PatientAgeGenderFragment.this.mPage.getData();
            String var3;
            if(var1 != null) {
               var3 = var1.toString();
            } else {
               var3 = null;
            }

            var2.putString("age", var3);
            PatientAgeGenderFragment.this.mPage.notifyDataChanged();
         }
      });
      this.patient_gender.setOnCheckedChangeListener(new OnCheckedChangeListener() {
         public void onCheckedChanged(CompoundButton var1, boolean var2) {
            Bundle var3 = PatientAgeGenderFragment.this.mPage.getData();
            String var4;
            if(PatientAgeGenderFragment.this.patient_gender.isChecked()) {
               var4 = "0";
            } else {
               var4 = "1";
            }

            var3.putString("gender", var4);
            Cache var5 = Cache.getInstance();
            boolean var6;
            if(!var2) {
               var6 = true;
            } else {
               var6 = false;
            }

            var5.setFemale(var6);
            Activity var7 = PatientAgeGenderFragment.this.getActivity();
            View var8 = PatientAgeGenderFragment.this.getRootView();
            String var9;
            if(PatientAgeGenderFragment.this.patient_gender.isChecked()) {
               var9 = "0";
            } else {
               var9 = "1";
            }

            ViewUtil.changeBackGround(var7, var8, (Switch)null, var9);
            PatientAgeGenderFragment.this.mPage.notifyDataChanged();
         }
      });
   }

   public void setMenuVisibility(boolean var1) {
      super.setMenuVisibility(var1);
      if(this.patient_age != null) {
         InputMethodManager var2 = (InputMethodManager)this.getActivity().getSystemService("input_method");
         if(!var1) {
            var2.hideSoftInputFromWindow(this.getView().getWindowToken(), 0);
         }
      }

   }
}
