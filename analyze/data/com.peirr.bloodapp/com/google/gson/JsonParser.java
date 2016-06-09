package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class JsonParser {
   public JsonElement parse(JsonReader param1) throws JsonIOException, JsonSyntaxException {
      // $FF: Couldn't be decompiled
   }

   public JsonElement parse(Reader var1) throws JsonIOException, JsonSyntaxException {
      try {
         JsonReader var2 = new JsonReader(var1);
         JsonElement var6 = this.parse(var2);
         if(!var6.isJsonNull() && var2.peek() != JsonToken.END_DOCUMENT) {
            throw new JsonSyntaxException("Did not consume the entire document.");
         } else {
            return var6;
         }
      } catch (MalformedJsonException var7) {
         throw new JsonSyntaxException(var7);
      } catch (IOException var8) {
         throw new JsonIOException(var8);
      } catch (NumberFormatException var9) {
         throw new JsonSyntaxException(var9);
      }
   }

   public JsonElement parse(String var1) throws JsonSyntaxException {
      return this.parse((Reader)(new StringReader(var1)));
   }
}
