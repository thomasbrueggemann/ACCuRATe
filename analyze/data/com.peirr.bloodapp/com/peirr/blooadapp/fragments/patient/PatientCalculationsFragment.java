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
import com.peirr.blooadapp.io.Cache;
import com.peirr.blooadapp.io.ViewUtil;
import com.peirr.blooadapp.wizard.model.Page;
import com.peirr.blooadapp.wizard.model.patient.PatientCalculationsPage;
import com.peirr.blooadapp.wizard.ui.BATextWatcher;
import com.peirr.blooadapp.wizard.ui.PageFragmentCallbacks;

public class PatientCalculationsFragment extends BasePatientFragment {
   private static final String ARG_KEY = "key";
   private PageFragmentCallbacks mCallbacks;
   private String mKey;
   private PatientCalculationsPage mPage;
   private TextView patient_anaesthetic_fluid;
   private TextView patient_first_pass_blood;
   private TextView patient_haemoglobin_level;
   private TextView patient_prime_volume;
   private TextView patient_rbc;
   private TextView patient_required;
   private TextView patient_urine_output;
   private View rootView;

   public static PatientCalculationsFragment create(String var0) {
      Bundle var1 = new Bundle();
      var1.putString("key", var0);
      PatientCalculationsFragment var2 = new PatientCalculationsFragment();
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
      this.mPage = (PatientCalculationsPage)this.mCallbacks.onGetPage(this.mKey);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.init();
      this.rootView = var1.inflate(2130903051, var2, false);
      TextView var4 = (TextView)this.rootView.findViewById(2131427351);
      TextView var5 = (TextView)this.rootView.findViewById(2131427353);
      TextView var6 = (TextView)this.rootView.findViewById(2131427355);
      TextView var7 = (TextView)this.rootView.findViewById(2131427357);
      TextView var8 = (TextView)this.rootView.findViewById(2131427359);
      TextView var9 = (TextView)this.rootView.findViewById(2131427361);
      TextView var10000 = (TextView)this.rootView.findViewById(2131427363);
      this.patient_haemoglobin_level = (TextView)this.rootView.findViewById(2131427352);
      this.patient_first_pass_blood = (TextView)this.rootView.findViewById(2131427354);
      this.patient_prime_volume = (TextView)this.rootView.findViewById(2131427356);
      this.patient_anaesthetic_fluid = (TextView)this.rootView.findViewById(2131427358);
      this.patient_urine_output = (TextView)this.rootView.findViewById(2131427360);
      this.patient_rbc = (TextView)this.rootView.findViewById(2131427362);
      this.patient_required = (TextView)this.rootView.findViewById(2131427364);
      if(var3 == null) {
         ((TextView)this.rootView.findViewById(16908310)).setText(this.mPage.getTitle());
         this.patient_haemoglobin_level.setText(this.mPage.getData().getString("preop_lab_level"));
         this.patient_first_pass_blood.setText(this.mPage.getData().getString("first_pass_removed"));
         this.patient_prime_volume.setText(this.mPage.getData().getString("prime_volume"));
         this.patient_anaesthetic_fluid.setText(this.mPage.getData().getString("fluid_prebypass"));
         this.patient_urine_output.setText(this.mPage.getData().getString("urine_prebypass"));
         this.patient_rbc.setText(this.mPage.getData().getString("rbc_required"));
         this.patient_required.setText(this.mPage.getData().getString("required_hb"));
      }

      if(Cache.getInstance().isCardiac()) {
         var4.setText(this.getString(2131230778));
         var5.setText(this.getString(2131230737));
         var6.setText(this.getString(2131230780));
         var7.setText(this.getString(2131230725));
         this.patient_urine_output.setVisibility(0);
         var8.setVisibility(0);
         var6.setVisibility(0);
         this.patient_prime_volume.setVisibility(0);
         var7.setVisibility(0);
         this.patient_rbc.setVisibility(0);
         this.patient_required.setVisibility(0);
         var9.setVisibility(0);
         this.patient_anaesthetic_fluid.setVisibility(0);
      } else {
         var4.setText(this.getString(2131230747));
         var5.setText(this.getString(2131230746));
         var6.setVisibility(8);
         this.patient_prime_volume.setVisibility(8);
         var7.setVisibility(8);
         this.patient_urine_output.setVisibility(8);
         var8.setVisibility(8);
         var9.setVisibility(8);
         this.patient_anaesthetic_fluid.setVisibility(8);
         this.patient_rbc.setVisibility(8);
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
      this.patient_haemoglobin_level.addTextChangedListener(new BATextWatcher() {
         public void afterTextChanged(Editable var1) {
            Bundle var2 = PatientCalculationsFragment.this.mPage.getData();
            String var3;
            if(var1 != null) {
               var3 = var1.toString();
            } else {
               var3 = null;
            }

            var2.putString("preop_lab_level", var3);
            PatientCalculationsFragment.this.mPage.notifyDataChanged();
         }
      });
      this.patient_first_pass_blood.addTextChangedListener(new BATextWatcher() {
         public void afterTextChanged(Editable var1) {
            Bundle var2 = PatientCalculationsFragment.this.mPage.getData();
            String var3;
            if(var1 != null) {
               var3 = var1.toString();
            } else {
               var3 = null;
            }

            var2.putString("first_pass_removed", var3);
            PatientCalculationsFragment.this.mPage.notifyDataChanged();
         }
      });
      this.patient_prime_volume.addTextChangedListener(new BATextWatcher() {
         public void afterTextChanged(Editable var1) {
            Bundle var2 = PatientCalculationsFragment.this.mPage.getData();
            String var3;
            if(var1 != null) {
               var3 = var1.toString();
            } else {
               var3 = null;
            }

            var2.putString("prime_volume", var3);
            PatientCalculationsFragment.this.mPage.notifyDataChanged();
         }
      });
      this.patient_anaesthetic_fluid.addTextChangedListener(new BATextWatcher() {
         public void afterTextChanged(Editable var1) {
            Bundle var2 = PatientCalculationsFragment.this.mPage.getData();
            String var3;
            if(var1 != null) {
               var3 = var1.toString();
            } else {
               var3 = null;
            }

            var2.putString("fluid_prebypass", var3);
            PatientCalculationsFragment.this.mPage.notifyDataChanged();
         }
      });
      this.patient_urine_output.addTextChangedListener(new BATextWatcher() {
         public void afterTextChanged(Editable var1) {
            Bundle var2 = PatientCalculationsFragment.this.mPage.getData();
            String var3;
            if(var1 != null) {
               var3 = var1.toString();
            } else {
               var3 = null;
            }

            var2.putString("urine_prebypass", var3);
            PatientCalculationsFragment.this.mPage.notifyDataChanged();
         }
      });
      this.patient_rbc.addTextChangedListener(new BATextWatcher() {
         public void afterTextChanged(Editable var1) {
            Bundle var2 = PatientCalculationsFragment.this.mPage.getData();
            String var3;
            if(var1 != null) {
               var3 = var1.toString();
            } else {
               var3 = null;
            }

            var2.putString("rbc_required", var3);
            PatientCalculationsFragment.this.mPage.notifyDataChanged();
         }
      });
      this.patient_required.addTextChangedListener(new BATextWatcher() {
         public void afterTextChanged(Editable var1) {
            Bundle var2 = PatientCalculationsFragment.this.mPage.getData();
            String var3;
            if(var1 != null) {
               var3 = var1.toString();
            } else {
               var3 = null;
            }

            var2.putString("required_hb", var3);
            PatientCalculationsFragment.this.mPage.notifyDataChanged();
         }
      });
   }

   public void setMenuVisibility(boolean var1) {
      super.setMenuVisibility(var1);
      if(this.patient_haemoglobin_level != null) {
         InputMethodManager var2 = (InputMethodManager)this.getActivity().getSystemService("input_method");
         if(!var1) {
            var2.hideSoftInputFromWindow(this.getView().getWindowToken(), 0);
         }
      }

   }
}
