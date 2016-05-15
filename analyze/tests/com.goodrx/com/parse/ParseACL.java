package com.parse;

import com.parse.GetCallback;
import com.parse.ParseCorePlugins;
import com.parse.ParseDecoder;
import com.parse.ParseDefaultACLController;
import com.parse.ParseEncoder;
import com.parse.ParseException;
import com.parse.ParseJSONUtils;
import com.parse.ParseObject;
import com.parse.ParseRole;
import com.parse.ParseUser;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseACL {
   private static final String KEY_ROLE_PREFIX = "role:";
   private static final String PUBLIC_KEY = "*";
   private static final String UNRESOLVED_KEY = "*unresolved";
   private static final String UNRESOLVED_USER_JSON_KEY = "unresolvedUser";
   private final Map<String, ParseACL.Permissions> permissionsById;
   private boolean shared;
   private ParseUser unresolvedUser;

   public ParseACL() {
      this.permissionsById = new HashMap();
   }

   public ParseACL(ParseACL var1) {
      this.permissionsById = new HashMap();
      Iterator var2 = var1.permissionsById.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         this.permissionsById.put(var3, new ParseACL.Permissions((ParseACL.Permissions)var1.permissionsById.get(var3)));
      }

      this.unresolvedUser = var1.unresolvedUser;
      if(this.unresolvedUser != null) {
         this.unresolvedUser.registerSaveListener(new ParseACL.UserResolutionListener(this));
      }

   }

   public ParseACL(ParseUser var1) {
      this();
      this.setReadAccess(var1, true);
      this.setWriteAccess(var1, true);
   }

   static ParseACL createACLFromJSONObject(JSONObject var0, ParseDecoder var1) {
      ParseACL var2 = new ParseACL();
      Iterator var3 = ParseJSONUtils.keys(var0).iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         if(var4.equals("unresolvedUser")) {
            JSONObject var9;
            try {
               var9 = var0.getJSONObject(var4);
            } catch (JSONException var10) {
               throw new RuntimeException(var10);
            }

            var2.unresolvedUser = (ParseUser)var1.decode(var9);
         } else {
            try {
               ParseACL.Permissions var6 = ParseACL.Permissions.createPermissionsFromJSONObject(var0.getJSONObject(var4));
               var2.permissionsById.put(var4, var6);
            } catch (JSONException var11) {
               throw new RuntimeException("could not decode ACL: " + var11.getMessage());
            }
         }
      }

      return var2;
   }

   static ParseACL getDefaultACL() {
      return getDefaultACLController().get();
   }

   private static ParseDefaultACLController getDefaultACLController() {
      return ParseCorePlugins.getInstance().getDefaultACLController();
   }

   private void prepareUnresolvedUser(ParseUser var1) {
      if(this.unresolvedUser != var1) {
         this.permissionsById.remove("*unresolved");
         this.unresolvedUser = var1;
         var1.registerSaveListener(new ParseACL.UserResolutionListener(this));
      }

   }

   public static void setDefaultACL(ParseACL var0, boolean var1) {
      getDefaultACLController().set(var0, var1);
   }

   private void setPermissionsIfNonEmpty(String var1, boolean var2, boolean var3) {
      if(!var2 && !var3) {
         this.permissionsById.remove(var1);
      } else {
         this.permissionsById.put(var1, new ParseACL.Permissions(var2, var3));
      }
   }

   private void setUnresolvedReadAccess(ParseUser var1, boolean var2) {
      this.prepareUnresolvedUser(var1);
      this.setReadAccess("*unresolved", var2);
   }

   private void setUnresolvedWriteAccess(ParseUser var1, boolean var2) {
      this.prepareUnresolvedUser(var1);
      this.setWriteAccess("*unresolved", var2);
   }

   private static void validateRoleState(ParseRole var0) {
      if(var0 == null || var0.getObjectId() == null) {
         throw new IllegalArgumentException("Roles must be saved to the server before they can be used in an ACL.");
      }
   }

   ParseACL copy() {
      return new ParseACL(this);
   }

   Map<String, ParseACL.Permissions> getPermissionsById() {
      return this.permissionsById;
   }

   public boolean getPublicReadAccess() {
      return this.getReadAccess("*");
   }

   public boolean getPublicWriteAccess() {
      return this.getWriteAccess("*");
   }

   public boolean getReadAccess(ParseUser var1) {
      if(var1 == this.unresolvedUser) {
         return this.getReadAccess("*unresolved");
      } else if(var1.isLazy()) {
         return false;
      } else if(var1.getObjectId() == null) {
         throw new IllegalArgumentException("cannot getReadAccess for a user with null id");
      } else {
         return this.getReadAccess(var1.getObjectId());
      }
   }

   public boolean getReadAccess(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("cannot getReadAccess for null userId");
      } else {
         ParseACL.Permissions var2 = (ParseACL.Permissions)this.permissionsById.get(var1);
         return var2 != null && var2.getReadPermission();
      }
   }

   public boolean getRoleReadAccess(ParseRole var1) {
      validateRoleState(var1);
      return this.getRoleReadAccess(var1.getName());
   }

   public boolean getRoleReadAccess(String var1) {
      return this.getReadAccess("role:" + var1);
   }

   public boolean getRoleWriteAccess(ParseRole var1) {
      validateRoleState(var1);
      return this.getRoleWriteAccess(var1.getName());
   }

   public boolean getRoleWriteAccess(String var1) {
      return this.getWriteAccess("role:" + var1);
   }

   ParseUser getUnresolvedUser() {
      return this.unresolvedUser;
   }

   public boolean getWriteAccess(ParseUser var1) {
      if(var1 == this.unresolvedUser) {
         return this.getWriteAccess("*unresolved");
      } else if(var1.isLazy()) {
         return false;
      } else if(var1.getObjectId() == null) {
         throw new IllegalArgumentException("cannot getWriteAccess for a user with null id");
      } else {
         return this.getWriteAccess(var1.getObjectId());
      }
   }

   public boolean getWriteAccess(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("cannot getWriteAccess for null userId");
      } else {
         ParseACL.Permissions var2 = (ParseACL.Permissions)this.permissionsById.get(var1);
         return var2 != null && var2.getWritePermission();
      }
   }

   boolean hasUnresolvedUser() {
      return this.unresolvedUser != null;
   }

   boolean isShared() {
      return this.shared;
   }

   void resolveUser(ParseUser var1) {
      if(var1 == this.unresolvedUser) {
         if(this.permissionsById.containsKey("*unresolved")) {
            this.permissionsById.put(var1.getObjectId(), this.permissionsById.get("*unresolved"));
            this.permissionsById.remove("*unresolved");
         }

         this.unresolvedUser = null;
      }
   }

   public void setPublicReadAccess(boolean var1) {
      this.setReadAccess("*", var1);
   }

   public void setPublicWriteAccess(boolean var1) {
      this.setWriteAccess("*", var1);
   }

   public void setReadAccess(ParseUser var1, boolean var2) {
      if(var1.getObjectId() == null) {
         if(var1.isLazy()) {
            this.setUnresolvedReadAccess(var1, var2);
         } else {
            throw new IllegalArgumentException("cannot setReadAccess for a user with null id");
         }
      } else {
         this.setReadAccess(var1.getObjectId(), var2);
      }
   }

   public void setReadAccess(String var1, boolean var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("cannot setReadAccess for null userId");
      } else {
         this.setPermissionsIfNonEmpty(var1, var2, this.getWriteAccess(var1));
      }
   }

   public void setRoleReadAccess(ParseRole var1, boolean var2) {
      validateRoleState(var1);
      this.setRoleReadAccess(var1.getName(), var2);
   }

   public void setRoleReadAccess(String var1, boolean var2) {
      this.setReadAccess("role:" + var1, var2);
   }

   public void setRoleWriteAccess(ParseRole var1, boolean var2) {
      validateRoleState(var1);
      this.setRoleWriteAccess(var1.getName(), var2);
   }

   public void setRoleWriteAccess(String var1, boolean var2) {
      this.setWriteAccess("role:" + var1, var2);
   }

   void setShared(boolean var1) {
      this.shared = var1;
   }

   public void setWriteAccess(ParseUser var1, boolean var2) {
      if(var1.getObjectId() == null) {
         if(var1.isLazy()) {
            this.setUnresolvedWriteAccess(var1, var2);
         } else {
            throw new IllegalArgumentException("cannot setWriteAccess for a user with null id");
         }
      } else {
         this.setWriteAccess(var1.getObjectId(), var2);
      }
   }

   public void setWriteAccess(String var1, boolean var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("cannot setWriteAccess for null userId");
      } else {
         this.setPermissionsIfNonEmpty(var1, this.getReadAccess(var1), var2);
      }
   }

   JSONObject toJSONObject(ParseEncoder param1) {
      // $FF: Couldn't be decompiled
   }

   private static class Permissions {
      private static final String READ_PERMISSION = "read";
      private static final String WRITE_PERMISSION = "write";
      private final boolean readPermission;
      private final boolean writePermission;

      Permissions(ParseACL.Permissions var1) {
         this.readPermission = var1.readPermission;
         this.writePermission = var1.writePermission;
      }

      Permissions(boolean var1, boolean var2) {
         this.readPermission = var1;
         this.writePermission = var2;
      }

      static ParseACL.Permissions createPermissionsFromJSONObject(JSONObject var0) {
         return new ParseACL.Permissions(var0.optBoolean("read", false), var0.optBoolean("write", false));
      }

      boolean getReadPermission() {
         return this.readPermission;
      }

      boolean getWritePermission() {
         return this.writePermission;
      }

      JSONObject toJSONObject() {
         JSONObject var1 = new JSONObject();

         try {
            if(this.readPermission) {
               var1.put("read", true);
            }

            if(this.writePermission) {
               var1.put("write", true);
            }

            return var1;
         } catch (JSONException var3) {
            throw new RuntimeException(var3);
         }
      }
   }

   private static class UserResolutionListener implements GetCallback<ParseObject> {
      private final WeakReference<ParseACL> parent;

      public UserResolutionListener(ParseACL var1) {
         this.parent = new WeakReference(var1);
      }

      public void done(ParseObject param1, ParseException param2) {
         // $FF: Couldn't be decompiled
      }
   }
}
