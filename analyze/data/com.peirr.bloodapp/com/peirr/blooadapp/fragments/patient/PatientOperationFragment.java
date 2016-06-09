package com.peirr.blooadapp.fragments.patient;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
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
import com.peirr.blooadapp.wizard.model.patient.PatientOperationPage;
import com.peirr.blooadapp.wizard.ui.BATextWatcher;
import com.peirr.blooadapp.wizard.ui.PageFragmentCallbacks;

public class PatientOperationFragment extends BasePatientFragment {
   private static final String ARG_KEY = "key";
   private PageFragmentCallbacks mCallbacks;
   private String mKey;
   private PatientOperationPage mPage;
   private Switch patient_cardiac;
   private TextView patient_operation;
   private View rootView;

   public static PatientOperationFragment create(String var0) {
      Bundle var1 = new Bundle();
      var1.putString("key", var0);
      PatientOperationFragment var2 = new PatientOperationFragment();
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
      this.mPage = (PatientOperationPage)this.mCallbacks.onGetPage(this.mKey);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.init();
      this.rootView = var1.inflate(2130903054, var2, false);
      this.rootView.setBackgroundColor(this.getResources().getColor(2131099648));
      ((TextView)this.rootView.findViewById(16908310)).setText(this.mPage.getTitle());
      this.patient_operation = (TextView)this.rootView.findViewById(2131427368);
      this.patient_operation.setText(this.mPage.getData().getString("operation"));
      this.patient_cardiac = (Switch)this.rootView.findViewById(2131427369);
      String var4 = this.mPage.getData().getString("cardiac");
      if(!TextUtils.isEmpty(var4)) {
         this.patient_cardiac.setChecked(var4.equalsIgnoreCase("1"));
         Cache.getInstance().setCardiac(var4.equalsIgnoreCase("1"));
      } else {
         Cache.getInstance().setCardiac(false);
         this.mPage.getData().putString("cardiac", "0");
      }

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
      this.patient_operation.addTextChangedListener(new BATextWatcher() {
         public void afterTextChanged(Editable var1) {
            Bundle var2 = PatientOperationFragment.this.mPage.getData();
            String var3;
            if(var1 != null) {
               var3 = var1.toString();
            } else {
               var3 = null;
            }

            var2.putString("operation", var3);
            PatientOperationFragment.this.mPage.notifyDataChanged();
         }
      });
      this.patient_cardiac.setOnCheckedChangeListener(new OnCheckedChangeListener() {
         public void onCheckedChanged(CompoundButton var1, boolean var2) {
            Cache.getInstance().setCardiac(var2);
            Bundle var3 = PatientOperationFragment.this.mPage.getData();
            String var4;
            if(PatientOperationFragment.this.patient_cardiac.isChecked()) {
               var4 = "1";
            } else {
               var4 = "0";
            }

            var3.putString("cardiac", var4);
            PatientOperationFragment.this.mPage.notifyDataChanged();
         }
      });
   }

   public void setMenuVisibility(boolean var1) {
      super.setMenuVisibility(var1);
      if(this.patient_operation != null) {
         InputMethodManager var2 = (InputMethodManager)this.getActivity().getSystemService("input_method");
         if(!var1) {
            var2.hideSoftInputFromWindow(this.getView().getWindowToken(), 0);
         }
      }

   }
}
