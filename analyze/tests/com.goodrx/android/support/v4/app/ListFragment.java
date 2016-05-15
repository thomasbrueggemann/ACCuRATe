package android.support.v4.app;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout.LayoutParams;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;

public class ListFragment extends Fragment implements TraceFieldInterface {
   static final int INTERNAL_EMPTY_ID = 16711681;
   static final int INTERNAL_LIST_CONTAINER_ID = 16711683;
   static final int INTERNAL_PROGRESS_CONTAINER_ID = 16711682;
   ListAdapter mAdapter;
   CharSequence mEmptyText;
   View mEmptyView;
   private final Handler mHandler = new Handler();
   ListView mList;
   View mListContainer;
   boolean mListShown;
   private final OnItemClickListener mOnClickListener = new OnItemClickListener() {
      public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
         ListFragment.this.onListItemClick((ListView)var1, var2, var3, var4);
      }
   };
   View mProgressContainer;
   private final Runnable mRequestFocus = new Runnable() {
      public void run() {
         ListFragment.this.mList.focusableViewAvailable(ListFragment.this.mList);
      }
   };
   TextView mStandardEmptyView;

   private void ensureList() {
      if(this.mList == null) {
         View var1 = this.getView();
         if(var1 == null) {
            throw new IllegalStateException("Content view not yet created");
         } else {
            if(var1 instanceof ListView) {
               this.mList = (ListView)var1;
            } else {
               this.mStandardEmptyView = (TextView)var1.findViewById(16711681);
               if(this.mStandardEmptyView == null) {
                  this.mEmptyView = var1.findViewById(16908292);
               } else {
                  this.mStandardEmptyView.setVisibility(8);
               }

               this.mProgressContainer = var1.findViewById(16711682);
               this.mListContainer = var1.findViewById(16711683);
               View var2 = var1.findViewById(16908298);
               if(!(var2 instanceof ListView)) {
                  if(var2 == null) {
                     throw new RuntimeException("Your content must have a ListView whose id attribute is \'android.R.id.list\'");
                  }

                  throw new RuntimeException("Content has view with id attribute \'android.R.id.list\' that is not a ListView class");
               }

               this.mList = (ListView)var2;
               if(this.mEmptyView != null) {
                  this.mList.setEmptyView(this.mEmptyView);
               } else if(this.mEmptyText != null) {
                  this.mStandardEmptyView.setText(this.mEmptyText);
                  this.mList.setEmptyView(this.mStandardEmptyView);
               }
            }

            this.mListShown = true;
            this.mList.setOnItemClickListener(this.mOnClickListener);
            if(this.mAdapter != null) {
               ListAdapter var4 = this.mAdapter;
               this.mAdapter = null;
               this.setListAdapter(var4);
            } else if(this.mProgressContainer != null) {
               this.setListShown(false, false);
            }

            this.mHandler.post(this.mRequestFocus);
         }
      }
   }

   private void setListShown(boolean var1, boolean var2) {
      this.ensureList();
      if(this.mProgressContainer == null) {
         throw new IllegalStateException("Can\'t be used with a custom content view");
      } else if(this.mListShown != var1) {
         this.mListShown = var1;
         if(var1) {
            if(var2) {
               this.mProgressContainer.startAnimation(AnimationUtils.loadAnimation(this.getActivity(), 17432577));
               this.mListContainer.startAnimation(AnimationUtils.loadAnimation(this.getActivity(), 17432576));
            } else {
               this.mProgressContainer.clearAnimation();
               this.mListContainer.clearAnimation();
            }

            this.mProgressContainer.setVisibility(8);
            this.mListContainer.setVisibility(0);
         } else {
            if(var2) {
               this.mProgressContainer.startAnimation(AnimationUtils.loadAnimation(this.getActivity(), 17432576));
               this.mListContainer.startAnimation(AnimationUtils.loadAnimation(this.getActivity(), 17432577));
            } else {
               this.mProgressContainer.clearAnimation();
               this.mListContainer.clearAnimation();
            }

            this.mProgressContainer.setVisibility(0);
            this.mListContainer.setVisibility(8);
         }
      }
   }

   public ListAdapter getListAdapter() {
      return this.mAdapter;
   }

   public ListView getListView() {
      this.ensureList();
      return this.mList;
   }

   public long getSelectedItemId() {
      this.ensureList();
      return this.mList.getSelectedItemId();
   }

   public int getSelectedItemPosition() {
      this.ensureList();
      return this.mList.getSelectedItemPosition();
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      FragmentActivity var4 = this.getActivity();
      FrameLayout var5 = new FrameLayout(var4);
      LinearLayout var6 = new LinearLayout(var4);
      var6.setId(16711682);
      var6.setOrientation(1);
      var6.setVisibility(8);
      var6.setGravity(17);
      var6.addView(new ProgressBar(var4, (AttributeSet)null, 16842874), new LayoutParams(-2, -2));
      var5.addView(var6, new LayoutParams(-1, -1));
      FrameLayout var7 = new FrameLayout(var4);
      var7.setId(16711683);
      TextView var8 = new TextView(this.getActivity());
      var8.setId(16711681);
      var8.setGravity(17);
      var7.addView(var8, new LayoutParams(-1, -1));
      ListView var9 = new ListView(this.getActivity());
      var9.setId(16908298);
      var9.setDrawSelectorOnTop(false);
      var7.addView(var9, new LayoutParams(-1, -1));
      var5.addView(var7, new LayoutParams(-1, -1));
      var5.setLayoutParams(new LayoutParams(-1, -1));
      return var5;
   }

   public void onDestroyView() {
      this.mHandler.removeCallbacks(this.mRequestFocus);
      this.mList = null;
      this.mListShown = false;
      this.mListContainer = null;
      this.mProgressContainer = null;
      this.mEmptyView = null;
      this.mStandardEmptyView = null;
      super.onDestroyView();
   }

   public void onListItemClick(ListView var1, View var2, int var3, long var4) {
   }

   protected void onStart() {
      super.onStart();
      ApplicationStateMonitor.getInstance().activityStarted();
   }

   protected void onStop() {
      super.onStop();
      ApplicationStateMonitor.getInstance().activityStopped();
   }

   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.ensureList();
   }

   public void setEmptyText(CharSequence var1) {
      this.ensureList();
      if(this.mStandardEmptyView == null) {
         throw new IllegalStateException("Can\'t be used with a custom content view");
      } else {
         this.mStandardEmptyView.setText(var1);
         if(this.mEmptyText == null) {
            this.mList.setEmptyView(this.mStandardEmptyView);
         }

         this.mEmptyText = var1;
      }
   }

   public void setListAdapter(ListAdapter var1) {
      boolean var2;
      if(this.mAdapter != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.mAdapter = var1;
      if(this.mList != null) {
         this.mList.setAdapter(var1);
         if(!this.mListShown && !var2) {
            IBinder var3 = this.getView().getWindowToken();
            boolean var4 = false;
            if(var3 != null) {
               var4 = true;
            }

            this.setListShown(true, var4);
         }
      }

   }

   public void setListShown(boolean var1) {
      this.setListShown(var1, true);
   }

   public void setListShownNoAnimation(boolean var1) {
      this.setListShown(var1, false);
   }

   public void setSelection(int var1) {
      this.ensureList();
      this.mList.setSelection(var1);
   }
}
