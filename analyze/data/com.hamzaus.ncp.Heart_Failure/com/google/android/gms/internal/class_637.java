package com.google.android.gms.internal;

import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.me
public class class_637 extends IOException {
   public class_637(String var1) {
      super(var1);
   }

   // $FF: renamed from: nN () com.google.android.gms.internal.me
   static class_637 method_3649() {
      return new class_637("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
   }

   // $FF: renamed from: nO () com.google.android.gms.internal.me
   static class_637 method_3650() {
      return new class_637("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
   }

   // $FF: renamed from: nP () com.google.android.gms.internal.me
   static class_637 method_3651() {
      return new class_637("CodedInputStream encountered a malformed varint.");
   }

   // $FF: renamed from: nQ () com.google.android.gms.internal.me
   static class_637 method_3652() {
      return new class_637("Protocol message contained an invalid tag (zero).");
   }

   // $FF: renamed from: nR () com.google.android.gms.internal.me
   static class_637 method_3653() {
      return new class_637("Protocol message end-group tag did not match expected tag.");
   }

   // $FF: renamed from: nS () com.google.android.gms.internal.me
   static class_637 method_3654() {
      return new class_637("Protocol message tag had invalid wire type.");
   }

   // $FF: renamed from: nT () com.google.android.gms.internal.me
   static class_637 method_3655() {
      return new class_637("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
   }
}
