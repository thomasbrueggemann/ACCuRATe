package com.facebook.common.util;

public enum TriState {
   // $FF: renamed from: NO com.facebook.common.util.TriState
   field_223,
   UNSET,
   YES;

   static {
      TriState[] var0 = new TriState[]{YES, field_223, UNSET};
   }

   public static TriState fromDbValue(int var0) {
      switch(var0) {
      case 1:
         return YES;
      case 2:
         return field_223;
      default:
         return UNSET;
      }
   }

   public static TriState valueOf(Boolean var0) {
      return var0 != null?valueOf(var0.booleanValue()):UNSET;
   }

   public static TriState valueOf(boolean var0) {
      return var0?YES:field_223;
   }

   public boolean asBoolean() {
      switch(null.$SwitchMap$com$facebook$common$util$TriState[this.ordinal()]) {
      case 1:
         return true;
      case 2:
         return false;
      case 3:
         throw new IllegalStateException("No boolean equivalent for UNSET");
      default:
         throw new IllegalStateException("Unrecognized TriState value: " + this);
      }
   }

   public boolean asBoolean(boolean var1) {
      switch(null.$SwitchMap$com$facebook$common$util$TriState[this.ordinal()]) {
      case 1:
         var1 = true;
      case 3:
         return var1;
      case 2:
         return false;
      default:
         throw new IllegalStateException("Unrecognized TriState value: " + this);
      }
   }

   public Boolean asBooleanObject() {
      switch(null.$SwitchMap$com$facebook$common$util$TriState[this.ordinal()]) {
      case 1:
         return Boolean.TRUE;
      case 2:
         return Boolean.FALSE;
      case 3:
         return null;
      default:
         throw new IllegalStateException("Unrecognized TriState value: " + this);
      }
   }

   public int getDbValue() {
      switch(null.$SwitchMap$com$facebook$common$util$TriState[this.ordinal()]) {
      case 1:
         return 1;
      case 2:
         return 2;
      default:
         return 3;
      }
   }

   public boolean isSet() {
      return this != UNSET;
   }
}
