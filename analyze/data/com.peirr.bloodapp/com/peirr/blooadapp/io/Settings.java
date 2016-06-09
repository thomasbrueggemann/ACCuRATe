package com.peirr.blooadapp.io;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashSet;
import java.util.Set;

public class Settings {
   public static final String ACCEPTED = "accepted";
   public static final String CARDIAC = "cardiac";
   public static final String DOCID = "docid";
   public static final String LOGGED_IN = "loggedin";
   public static final String PAYLOAD = "payload";
   public static final String PREFS_NAME = "flags";
   private Editor editor;
   private SharedPreferences settings;

   public Settings(Context var1) {
      this.settings = var1.getSharedPreferences("flags", 0);
   }

   public void clear() {
      this.editor = this.settings.edit();
      this.editor.clear();
      this.editor.commit();
   }

   public boolean getBoolean(String var1) {
      return this.settings.getBoolean(var1, false);
   }

   public int getInt(String var1) {
      return this.settings.getInt(var1, -1);
   }

   public int getInt(String var1, int var2) {
      return this.settings.getInt(var1, var2);
   }

   public long getLong(String var1) {
      return this.settings.getLong(var1, -1L);
   }

   public String getString(String var1) {
      return this.settings.getString(var1, (String)null);
   }

   public Set<String> getStringSet(String var1) {
      return this.settings.getStringSet(var1, new HashSet());
   }

   public void setBoolean(String var1, boolean var2) {
      this.editor = this.settings.edit();
      this.editor.putBoolean(var1, var2);
      this.editor.commit();
   }

   public void setInt(String var1, int var2) {
      this.editor = this.settings.edit();
      this.editor.putInt(var1, var2);
      this.editor.commit();
   }

   public void setLong(String var1, long var2) {
      this.editor = this.settings.edit();
      this.editor.putLong(var1, var2);
      this.editor.commit();
   }

   public void setString(String var1, String var2) {
      this.editor = this.settings.edit();
      this.editor.putString(var1, var2);
      this.editor.commit();
   }

   public void setStringSet(String var1, Set<String> var2) {
      this.editor = this.settings.edit();
      this.editor.putStringSet(var1, var2);
      this.editor.commit();
   }
}
