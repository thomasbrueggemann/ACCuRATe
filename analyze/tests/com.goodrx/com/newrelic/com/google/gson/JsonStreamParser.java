package com.newrelic.com.google.gson;

import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonParseException;
import com.newrelic.com.google.gson.internal.Streams;
import com.newrelic.com.google.gson.stream.JsonReader;
import java.io.EOFException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class JsonStreamParser implements Iterator<JsonElement> {
   private final Object lock;
   private final JsonReader parser;

   public JsonStreamParser(Reader var1) {
      this.parser = new JsonReader(var1);
      this.parser.setLenient(true);
      this.lock = new Object();
   }

   public JsonStreamParser(String var1) {
      this((Reader)(new StringReader(var1)));
   }

   public boolean hasNext() {
      // $FF: Couldn't be decompiled
   }

   public JsonElement next() throws JsonParseException {
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         try {
            JsonElement var4 = Streams.parse(this.parser);
            return var4;
         } catch (StackOverflowError var5) {
            throw new JsonParseException("Failed parsing JSON source to Json", var5);
         } catch (OutOfMemoryError var6) {
            throw new JsonParseException("Failed parsing JSON source to Json", var6);
         } catch (JsonParseException var7) {
            Object var1 = var7;
            if(var7.getCause() instanceof EOFException) {
               var1 = new NoSuchElementException();
            }

            throw var1;
         }
      }
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }
}
