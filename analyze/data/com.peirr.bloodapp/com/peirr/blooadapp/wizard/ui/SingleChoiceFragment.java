package com.peirr.blooadapp.wizard.ui;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.peirr.blooadapp.wizard.model.Page;
import com.peirr.blooadapp.wizard.model.SingleFixedChoicePage;
import com.peirr.blooadapp.wizard.ui.PageFragmentCallbacks;
import java.util.ArrayList;
import java.util.List;

public class SingleChoiceFragment extends ListFragment {
   private static final String ARG_KEY = "key";
   private PageFragmentCallbacks mCallbacks;
   private List<String> mChoices;
   private String mKey;
   private Page mPage;

   public static SingleChoiceFragment create(String var0) {
      Bundle var1 = new Bundle();
      var1.putString("key", var0);
      SingleChoiceFragment var2 = new SingleChoiceFragment();
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
      this.mPage = this.mCallbacks.onGetPage(this.mKey);
      SingleFixedChoicePage var2 = (SingleFixedChoicePage)this.mPage;
      this.mChoices = new ArrayList();

      for(int var3 = 0; var3 < var2.getOptionCount(); ++var3) {
         this.mChoices.add(var2.getOptionAt(var3));
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130903048, var2, false);
      ((TextView)var4.findViewById(16908310)).setText(this.mPage.getTitle());
      final ListView var5 = (ListView)var4.findViewById(16908298);
      this.setListAdapter(new ArrayAdapter(this.getActivity(), 17367055, 16908308, this.mChoices));
      var5.setChoiceMode(1);
      (new Handler()).post(new Runnable() {
         public void run() {
            String var1 = SingleChoiceFragment.this.mPage.getData().getString("_");

            for(int var2 = 0; var2 < SingleChoiceFragment.this.mChoices.size(); ++var2) {
               if(((String)SingleChoiceFragment.this.mChoices.get(var2)).equals(var1)) {
                  var5.setItemChecked(var2, true);
                  break;
               }
            }

         }
      });
      return var4;
   }

   public void onDetach() {
      super.onDetach();
      this.mCallbacks = null;
   }

   public void onListItemClick(ListView var1, View var2, int var3, long var4) {
      this.mPage.getData().putString("_", this.getListAdapter().getItem(var3).toString());
      this.mPage.notifyDataChanged();
   }
}
