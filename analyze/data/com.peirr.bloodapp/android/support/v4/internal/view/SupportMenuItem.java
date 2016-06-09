package android.support.v4.internal.view;

import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.view.MenuItem;
import android.view.View;

public interface SupportMenuItem extends MenuItem {
   int SHOW_AS_ACTION_ALWAYS = 2;
   int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
   int SHOW_AS_ACTION_IF_ROOM = 1;
   int SHOW_AS_ACTION_NEVER = 0;
   int SHOW_AS_ACTION_WITH_TEXT = 4;

   boolean collapseActionView();

   boolean expandActionView();

   View getActionView();

   ActionProvider getSupportActionProvider();

   boolean isActionViewExpanded();

   MenuItem setActionView(int var1);

   MenuItem setActionView(View var1);

   void setShowAsAction(int var1);

   MenuItem setShowAsActionFlags(int var1);

   SupportMenuItem setSupportActionProvider(ActionProvider var1);

   SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener var1);
}
