package com.google.android.gms.internal;

import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.qv
public class class_833 extends IOException {
   public class_833(String var1) {
      super(var1);
   }

   // $FF: renamed from: rR () com.google.android.gms.internal.qv
   static class_833 method_4617() {
      return new class_833("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
   }

   // $FF: renamed from: rS () com.google.android.gms.internal.qv
   static class_833 method_4618() {
      return new class_833("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
   }

   // $FF: renamed from: rT () com.google.android.gms.internal.qv
   static class_833 method_4619() {
      return new class_833("CodedInputStream encountered a malformed varint.");
   }

   // $FF: renamed from: rU () com.google.android.gms.internal.qv
   static class_833 method_4620() {
      return new class_833("Protocol message contained an invalid tag (zero).");
   }

   // $FF: renamed from: rV () com.google.android.gms.internal.qv
   static class_833 method_4621() {
      return new class_833("Protocol message end-group tag did not match expected tag.");
   }

   // $FF: renamed from: rW () com.google.android.gms.internal.qv
   static class_833 method_4622() {
      return new class_833("Protocol message tag had invalid wire type.");
   }

   // $FF: renamed from: rX () com.google.android.gms.internal.qv
   static class_833 method_4623() {
      return new class_833("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
   }
}
