package com.peirr.blooadapp.fragments.patient;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Switch;
import android.widget.TextView;
import com.peirr.blooadapp.fragments.patient.BasePatientFragment;
import com.peirr.blooadapp.io.ViewUtil;
import com.peirr.blooadapp.wizard.model.Page;
import com.peirr.blooadapp.wizard.model.patient.PatientHeightWeightPage;
import com.peirr.blooadapp.wizard.ui.BATextWatcher;
import com.peirr.blooadapp.wizard.ui.PageFragmentCallbacks;

public class PatientHeightWeightFragment extends BasePatientFragment {
   private static final String ARG_KEY = "key";
   private PageFragmentCallbacks mCallbacks;
   private String mKey;
   private PatientHeightWeightPage mPage;
   private TextView patient_height;
   private TextView patient_weight;
   private View rootView;

   public static PatientHeightWeightFragment create(String var0) {
      Bundle var1 = new Bundle();
      var1.putString("key", var0);
      PatientHeightWeightFragment var2 = new PatientHeightWeightFragment();
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
      return null;
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
      this.mPage = (PatientHeightWeightPage)this.mCallbacks.onGetPage(this.mKey);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.init();
      this.rootView = var1.inflate(2130903053, var2, false);
      ((TextView)this.rootView.findViewById(16908310)).setText(this.mPage.getTitle());
      this.patient_height = (TextView)this.rootView.findViewById(2131427366);
      this.patient_height.setText(this.mPage.getData().getString("height"));
      this.patient_weight = (TextView)this.rootView.findViewById(2131427367);
      this.patient_weight.setText(this.mPage.getData().getString("weight"));
      if(var3 == null) {
         ViewUtil.changeBackGround(this.getActivity(), this.getRootView(), (Switch)null, this.gender);
      }

      return this.rootView;
   }

   public void onDetach() {
      super.onDetach();
      this.mCallbacks = null;
   }

   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.patient_height.addTextChangedListener(new BATextWatcher() {
         public void afterTextChanged(Editable var1) {
            Bundle var2 = PatientHeightWeightFragment.this.mPage.getData();
            String var3;
            if(var1 != null) {
               var3 = var1.toString();
            } else {
               var3 = null;
            }

            var2.putString("height", var3);
            PatientHeightWeightFragment.this.mPage.notifyDataChanged();
         }
      });
      this.patient_weight.addTextChangedListener(new BATextWatcher() {
         public void afterTextChanged(Editable var1) {
            Bundle var2 = PatientHeightWeightFragment.this.mPage.getData();
            String var3;
            if(var1 != null) {
               var3 = var1.toString();
            } else {
               var3 = null;
            }

            var2.putString("weight", var3);
            PatientHeightWeightFragment.this.mPage.notifyDataChanged();
         }
      });
   }

   public void setMenuVisibility(boolean var1) {
      super.setMenuVisibility(var1);
      if(this.patient_height != null) {
         InputMethodManager var2 = (InputMethodManager)this.getActivity().getSystemService("input_method");
         if(!var1) {
            var2.hideSoftInputFromWindow(this.getView().getWindowToken(), 0);
         }
      }

   }
}
