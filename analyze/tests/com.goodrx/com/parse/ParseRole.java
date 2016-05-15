package com.parse;

import com.parse.ParseACL;
import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseRelation;
import com.parse.ParseUser;
import java.util.regex.Pattern;

@ParseClassName("_Role")
public class ParseRole extends ParseObject {
   private static final Pattern NAME_PATTERN = Pattern.compile("^[0-9a-zA-Z_\\- ]+$");

   ParseRole() {
   }

   public ParseRole(String var1) {
      this();
      this.setName(var1);
   }

   public ParseRole(String var1, ParseACL var2) {
      this(var1);
      this.setACL(var2);
   }

   public static ParseQuery<ParseRole> getQuery() {
      return ParseQuery.getQuery(ParseRole.class);
   }

   public String getName() {
      return this.getString("name");
   }

   public ParseRelation<ParseRole> getRoles() {
      return this.getRelation("roles");
   }

   public ParseRelation<ParseUser> getUsers() {
      return this.getRelation("users");
   }

   public void put(String var1, Object var2) {
      if("name".equals(var1)) {
         if(this.getObjectId() != null) {
            throw new IllegalArgumentException("A role\'s name can only be set before it has been saved.");
         }

         if(!(var2 instanceof String)) {
            throw new IllegalArgumentException("A role\'s name must be a String.");
         }

         if(!NAME_PATTERN.matcher((String)var2).matches()) {
            throw new IllegalArgumentException("A role\'s name can only contain alphanumeric characters, _, -, and spaces.");
         }
      }

      super.put(var1, var2);
   }

   public void setName(String var1) {
      this.put("name", var1);
   }

   void validateSave() {
      // $FF: Couldn't be decompiled
   }
}
