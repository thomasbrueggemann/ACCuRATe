package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;

public final class Streams {
   public static JsonElement parse(JsonReader param0) throws JsonParseException {
      // $FF: Couldn't be decompiled
   }

   public static void write(JsonElement var0, JsonWriter var1) throws IOException {
      TypeAdapters.JSON_ELEMENT.write(var1, var0);
   }

   public static Writer writerForAppendable(Appendable var0) {
      return (Writer)(var0 instanceof Writer?(Writer)var0:new Streams.AppendableWriter(var0));
   }

   private static final class AppendableWriter extends Writer {
      private final Appendable appendable;
      private final Streams.CurrentWrite currentWrite = new Streams.CurrentWrite();

      AppendableWriter(Appendable var1) {
         this.appendable = var1;
      }

      public void close() {
      }

      public void flush() {
      }

      public void write(int var1) throws IOException {
         this.appendable.append((char)var1);
      }

      public void write(char[] var1, int var2, int var3) throws IOException {
         this.currentWrite.chars = var1;
         this.appendable.append(this.currentWrite, var2, var2 + var3);
      }
   }

   static class CurrentWrite implements CharSequence {
      char[] chars;

      public char charAt(int var1) {
         return this.chars[var1];
      }

      public int length() {
         return this.chars.length;
      }

      public CharSequence subSequence(int var1, int var2) {
         return new String(this.chars, var1, var2 - var1);
      }
   }
}
