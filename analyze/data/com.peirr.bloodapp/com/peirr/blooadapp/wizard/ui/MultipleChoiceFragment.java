package com.peirr.blooadapp.wizard.ui;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.os.Handler;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.peirr.blooadapp.wizard.model.MultipleFixedChoicePage;
import com.peirr.blooadapp.wizard.model.Page;
import com.peirr.blooadapp.wizard.ui.PageFragmentCallbacks;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MultipleChoiceFragment extends ListFragment {
   private static final String ARG_KEY = "key";
   private PageFragmentCallbacks mCallbacks;
   private List<String> mChoices;
   private String mKey;
   private Page mPage;

   public static MultipleChoiceFragment create(String var0) {
      Bundle var1 = new Bundle();
      var1.putString("key", var0);
      MultipleChoiceFragment var2 = new MultipleChoiceFragment();
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
      MultipleFixedChoicePage var2 = (MultipleFixedChoicePage)this.mPage;
      this.mChoices = new ArrayList();

      for(int var3 = 0; var3 < var2.getOptionCount(); ++var3) {
         this.mChoices.add(var2.getOptionAt(var3));
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130903048, var2, false);
      ((TextView)var4.findViewById(16908310)).setText(this.mPage.getTitle());
      final ListView var5 = (ListView)var4.findViewById(16908298);
      this.setListAdapter(new ArrayAdapter(this.getActivity(), 17367056, 16908308, this.mChoices));
      var5.setChoiceMode(2);
      (new Handler()).post(new Runnable() {
         public void run() {
            ArrayList var1 = MultipleChoiceFragment.this.mPage.getData().getStringArrayList("_");
            if(var1 != null && var1.size() != 0) {
               HashSet var2 = new HashSet(var1);

               for(int var3 = 0; var3 < MultipleChoiceFragment.this.mChoices.size(); ++var3) {
                  if(var2.contains(MultipleChoiceFragment.this.mChoices.get(var3))) {
                     var5.setItemChecked(var3, true);
                  }
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
      SparseBooleanArray var6 = this.getListView().getCheckedItemPositions();
      ArrayList var7 = new ArrayList();

      for(int var8 = 0; var8 < var6.size(); ++var8) {
         if(var6.valueAt(var8)) {
            var7.add(this.getListAdapter().getItem(var6.keyAt(var8)).toString());
         }
      }

      this.mPage.getData().putStringArrayList("_", var7);
      this.mPage.notifyDataChanged();
   }
}
