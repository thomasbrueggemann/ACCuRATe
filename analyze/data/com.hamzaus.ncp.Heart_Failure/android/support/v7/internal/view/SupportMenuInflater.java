package android.support.v7.internal.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.class_639;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuItemWrapperICS;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.MenuItem.OnMenuItemClickListener;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SupportMenuInflater extends MenuInflater {
   private static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE;
   private static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class};
   private static final String LOG_TAG = "SupportMenuInflater";
   private static final int NO_ID = 0;
   private static final String XML_GROUP = "group";
   private static final String XML_ITEM = "item";
   private static final String XML_MENU = "menu";
   private final Object[] mActionProviderConstructorArguments;
   private final Object[] mActionViewConstructorArguments;
   private Context mContext;
   private Object mRealOwner;

   static {
      ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
   }

   public SupportMenuInflater(Context var1) {
      super(var1);
      this.mContext = var1;
      this.mRealOwner = var1;
      this.mActionViewConstructorArguments = new Object[]{var1};
      this.mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
   }

   private void parseMenu(XmlPullParser var1, AttributeSet var2, Menu var3) throws XmlPullParserException, IOException {
      SupportMenuInflater.MenuState var4 = new SupportMenuInflater.MenuState(var3);
      int var5 = var1.getEventType();
      boolean var6 = false;
      String var7 = null;

      do {
         if(var5 == 2) {
            String var12 = var1.getName();
            if(!var12.equals("menu")) {
               throw new RuntimeException("Expecting menu, got " + var12);
            }

            var5 = var1.next();
            break;
         }

         var5 = var1.next();
      } while(var5 != 1);

      for(boolean var8 = false; !var8; var5 = var1.next()) {
         switch(var5) {
         case 1:
            throw new RuntimeException("Unexpected end of document");
         case 2:
            if(!var6) {
               String var11 = var1.getName();
               if(var11.equals("group")) {
                  var4.readGroup(var2);
               } else if(var11.equals("item")) {
                  var4.readItem(var2);
               } else if(var11.equals("menu")) {
                  this.parseMenu(var1, var2, var4.addSubMenuItem());
               } else {
                  var6 = true;
                  var7 = var11;
               }
            }
            break;
         case 3:
            String var9 = var1.getName();
            if(var6 && var9.equals(var7)) {
               var6 = false;
               var7 = null;
            } else if(var9.equals("group")) {
               var4.resetGroup();
            } else if(var9.equals("item")) {
               if(!var4.hasAddedItem()) {
                  if(var4.itemActionProvider != null && var4.itemActionProvider.hasSubMenu()) {
                     var4.addSubMenuItem();
                  } else {
                     var4.addItem();
                  }
               }
            } else if(var9.equals("menu")) {
               var8 = true;
            }
         }
      }

   }

   public void inflate(int param1, Menu param2) {
      // $FF: Couldn't be decompiled
   }

   private static class InflatedOnMenuItemClickListener implements OnMenuItemClickListener {
      private static final Class<?>[] PARAM_TYPES = new Class[]{MenuItem.class};
      private Method mMethod;
      private Object mRealOwner;

      public InflatedOnMenuItemClickListener(Object var1, String var2) {
         this.mRealOwner = var1;
         Class var3 = var1.getClass();

         try {
            this.mMethod = var3.getMethod(var2, PARAM_TYPES);
         } catch (Exception var6) {
            InflateException var5 = new InflateException("Couldn\'t resolve menu item onClick handler " + var2 + " in class " + var3.getName());
            var5.initCause(var6);
            throw var5;
         }
      }

      public boolean onMenuItemClick(MenuItem var1) {
         try {
            if(this.mMethod.getReturnType() == Boolean.TYPE) {
               return ((Boolean)this.mMethod.invoke(this.mRealOwner, new Object[]{var1})).booleanValue();
            } else {
               this.mMethod.invoke(this.mRealOwner, new Object[]{var1});
               return true;
            }
         } catch (Exception var3) {
            throw new RuntimeException(var3);
         }
      }
   }

   private class MenuState {
      private static final int defaultGroupId = 0;
      private static final int defaultItemCategory = 0;
      private static final int defaultItemCheckable = 0;
      private static final boolean defaultItemChecked = false;
      private static final boolean defaultItemEnabled = true;
      private static final int defaultItemId = 0;
      private static final int defaultItemOrder = 0;
      private static final boolean defaultItemVisible = true;
      private int groupCategory;
      private int groupCheckable;
      private boolean groupEnabled;
      private int groupId;
      private int groupOrder;
      private boolean groupVisible;
      private ActionProvider itemActionProvider;
      private String itemActionProviderClassName;
      private String itemActionViewClassName;
      private int itemActionViewLayout;
      private boolean itemAdded;
      private char itemAlphabeticShortcut;
      private int itemCategoryOrder;
      private int itemCheckable;
      private boolean itemChecked;
      private boolean itemEnabled;
      private int itemIconResId;
      private int itemId;
      private String itemListenerMethodName;
      private char itemNumericShortcut;
      private int itemShowAsAction;
      private CharSequence itemTitle;
      private CharSequence itemTitleCondensed;
      private boolean itemVisible;
      private Menu menu;

      public MenuState(Menu var2) {
         this.menu = var2;
         this.resetGroup();
      }

      private char getShortcut(String var1) {
         return var1 == null?'\u0000':var1.charAt(0);
      }

      private <T> T newInstance(String var1, Class<?>[] var2, Object[] var3) {
         try {
            Object var6 = SupportMenuInflater.this.mContext.getClassLoader().loadClass(var1).getConstructor(var2).newInstance(var3);
            return var6;
         } catch (Exception var7) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + var1, var7);
            return null;
         }
      }

      private void setItem(MenuItem var1) {
         MenuItem var2 = var1.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
         boolean var3;
         if(this.itemCheckable >= 1) {
            var3 = true;
         } else {
            var3 = false;
         }

         var2.setCheckable(var3).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId).setAlphabeticShortcut(this.itemAlphabeticShortcut).setNumericShortcut(this.itemNumericShortcut);
         if(this.itemShowAsAction >= 0) {
            MenuItemCompat.setShowAsAction(var1, this.itemShowAsAction);
         }

         if(this.itemListenerMethodName != null) {
            if(SupportMenuInflater.this.mContext.isRestricted()) {
               throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }

            var1.setOnMenuItemClickListener(new SupportMenuInflater.InflatedOnMenuItemClickListener(SupportMenuInflater.this.mRealOwner, this.itemListenerMethodName));
         }

         if(var1 instanceof MenuItemImpl) {
            MenuItemImpl var10000 = (MenuItemImpl)var1;
         }

         if(this.itemCheckable >= 2) {
            if(var1 instanceof MenuItemImpl) {
               ((MenuItemImpl)var1).setExclusiveCheckable(true);
            } else if(var1 instanceof MenuItemWrapperICS) {
               ((MenuItemWrapperICS)var1).setExclusiveCheckable(true);
            }
         }

         String var5 = this.itemActionViewClassName;
         boolean var6 = false;
         if(var5 != null) {
            MenuItemCompat.setActionView(var1, (View)this.newInstance(this.itemActionViewClassName, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, SupportMenuInflater.this.mActionViewConstructorArguments));
            var6 = true;
         }

         if(this.itemActionViewLayout > 0) {
            if(!var6) {
               MenuItemCompat.setActionView(var1, this.itemActionViewLayout);
            } else {
               Log.w("SupportMenuInflater", "Ignoring attribute \'itemActionViewLayout\'. Action view already specified.");
            }
         }

         if(this.itemActionProvider != null) {
            MenuItemCompat.setActionProvider(var1, this.itemActionProvider);
         }

      }

      public void addItem() {
         this.itemAdded = true;
         this.setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
      }

      public SubMenu addSubMenuItem() {
         this.itemAdded = true;
         SubMenu var1 = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
         this.setItem(var1.getItem());
         return var1;
      }

      public boolean hasAddedItem() {
         return this.itemAdded;
      }

      public void readGroup(AttributeSet var1) {
         TypedArray var2 = SupportMenuInflater.this.mContext.obtainStyledAttributes(var1, class_639.styleable.MenuGroup);
         this.groupId = var2.getResourceId(1, 0);
         this.groupCategory = var2.getInt(3, 0);
         this.groupOrder = var2.getInt(4, 0);
         this.groupCheckable = var2.getInt(5, 0);
         this.groupVisible = var2.getBoolean(2, true);
         this.groupEnabled = var2.getBoolean(0, true);
         var2.recycle();
      }

      public void readItem(AttributeSet var1) {
         TypedArray var2 = SupportMenuInflater.this.mContext.obtainStyledAttributes(var1, class_639.styleable.MenuItem);
         this.itemId = var2.getResourceId(2, 0);
         int var3 = var2.getInt(5, this.groupCategory);
         int var4 = var2.getInt(6, this.groupOrder);
         this.itemCategoryOrder = -65536 & var3 | '\uffff' & var4;
         this.itemTitle = var2.getText(7);
         this.itemTitleCondensed = var2.getText(8);
         this.itemIconResId = var2.getResourceId(0, 0);
         this.itemAlphabeticShortcut = this.getShortcut(var2.getString(9));
         this.itemNumericShortcut = this.getShortcut(var2.getString(10));
         if(var2.hasValue(11)) {
            byte var7;
            if(var2.getBoolean(11, false)) {
               var7 = 1;
            } else {
               var7 = 0;
            }

            this.itemCheckable = var7;
         } else {
            this.itemCheckable = this.groupCheckable;
         }

         this.itemChecked = var2.getBoolean(3, false);
         this.itemVisible = var2.getBoolean(4, this.groupVisible);
         this.itemEnabled = var2.getBoolean(1, this.groupEnabled);
         this.itemShowAsAction = var2.getInt(13, -1);
         this.itemListenerMethodName = var2.getString(12);
         this.itemActionViewLayout = var2.getResourceId(14, 0);
         this.itemActionViewClassName = var2.getString(15);
         this.itemActionProviderClassName = var2.getString(16);
         boolean var5;
         if(this.itemActionProviderClassName != null) {
            var5 = true;
         } else {
            var5 = false;
         }

         if(var5 && this.itemActionViewLayout == 0 && this.itemActionViewClassName == null) {
            this.itemActionProvider = (ActionProvider)this.newInstance(this.itemActionProviderClassName, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, SupportMenuInflater.this.mActionProviderConstructorArguments);
         } else {
            if(var5) {
               Log.w("SupportMenuInflater", "Ignoring attribute \'actionProviderClass\'. Action view already specified.");
            }

            this.itemActionProvider = null;
         }

         var2.recycle();
         this.itemAdded = false;
      }

      public void resetGroup() {
         this.groupId = 0;
         this.groupCategory = 0;
         this.groupOrder = 0;
         this.groupCheckable = 0;
         this.groupVisible = true;
         this.groupEnabled = true;
      }
   }
}
