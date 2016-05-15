package com.parse;

import com.parse.ParseByteArrayHttpBody;
import com.parse.ParseCountingByteArrayHttpBody;
import com.parse.ParseCountingFileHttpBody;
import com.parse.ParseFileHttpBody;
import com.parse.ParseRESTCommand;
import com.parse.ProgressCallback;
import com.parse.http.ParseHttpBody;
import com.parse.http.ParseHttpRequest;
import java.io.File;

class ParseRESTFileCommand extends ParseRESTCommand {
   private final String contentType;
   private final byte[] data;
   private final File file;

   public ParseRESTFileCommand(ParseRESTFileCommand.Builder var1) {
      super(var1);
      if(var1.file != null && var1.data != null) {
         throw new IllegalArgumentException("File and data can not be set at the same time");
      } else {
         this.data = var1.data;
         this.contentType = var1.contentType;
         this.file = var1.file;
      }
   }

   protected ParseHttpBody newBody(ProgressCallback var1) {
      return (ParseHttpBody)(var1 == null?(this.data != null?new ParseByteArrayHttpBody(this.data, this.contentType):new ParseFileHttpBody(this.file, this.contentType)):(this.data != null?new ParseCountingByteArrayHttpBody(this.data, this.contentType, var1):new ParseCountingFileHttpBody(this.file, this.contentType, var1)));
   }

   public static class Builder extends ParseRESTCommand.Init<ParseRESTFileCommand.Builder> {
      private String contentType = null;
      private byte[] data = null;
      private File file;

      public Builder() {
         this.method(ParseHttpRequest.Method.POST);
      }

      public ParseRESTFileCommand build() {
         return new ParseRESTFileCommand(this);
      }

      public ParseRESTFileCommand.Builder contentType(String var1) {
         this.contentType = var1;
         return this;
      }

      public ParseRESTFileCommand.Builder data(byte[] var1) {
         this.data = var1;
         return this;
      }

      public ParseRESTFileCommand.Builder file(File var1) {
         this.file = var1;
         return this;
      }

      public ParseRESTFileCommand.Builder fileName(String var1) {
         return (ParseRESTFileCommand.Builder)this.httpPath(String.format("files/%s", new Object[]{var1}));
      }

      ParseRESTFileCommand.Builder self() {
         return this;
      }
   }
}
