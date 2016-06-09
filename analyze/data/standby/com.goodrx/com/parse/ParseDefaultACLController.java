package com.parse;

import com.parse.ParseACL;
import com.parse.ParseUser;
import java.lang.ref.WeakReference;

class ParseDefaultACLController {
   ParseACL defaultACL;
   boolean defaultACLUsesCurrentUser;
   ParseACL defaultACLWithCurrentUser;
   WeakReference<ParseUser> lastCurrentUser;

   public ParseACL get() {
      if(this.defaultACLUsesCurrentUser && this.defaultACL != null) {
         ParseUser var1 = ParseUser.getCurrentUser();
         if(var1 != null) {
            ParseUser var2;
            if(this.lastCurrentUser != null) {
               var2 = (ParseUser)this.lastCurrentUser.get();
            } else {
               var2 = null;
            }

            if(var2 != var1) {
               ParseACL var3 = this.defaultACL.copy();
               var3.setShared(true);
               var3.setReadAccess(var1, true);
               var3.setWriteAccess(var1, true);
               this.defaultACLWithCurrentUser = var3;
               this.lastCurrentUser = new WeakReference(var1);
            }

            return this.defaultACLWithCurrentUser;
         }
      }

      return this.defaultACL;
   }

   public void set(ParseACL var1, boolean var2) {
      this.defaultACLWithCurrentUser = null;
      this.lastCurrentUser = null;
      if(var1 != null) {
         ParseACL var3 = var1.copy();
         var3.setShared(true);
         this.defaultACL = var3;
         this.defaultACLUsesCurrentUser = var2;
      } else {
         this.defaultACL = null;
      }
   }
}
