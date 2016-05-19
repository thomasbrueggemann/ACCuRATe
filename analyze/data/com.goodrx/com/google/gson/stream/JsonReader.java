package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class JsonReader implements Closeable {
   private static final char[] NON_EXECUTE_PREFIX = ")]}\'\n".toCharArray();
   private final char[] buffer = new char[1024];
   // $FF: renamed from: in java.io.Reader
   private final Reader field_427;
   private boolean lenient = false;
   private int limit = 0;
   private int lineNumber = 0;
   private int lineStart = 0;
   private int[] pathIndices;
   private String[] pathNames;
   int peeked = 0;
   private long peekedLong;
   private int peekedNumberLength;
   private String peekedString;
   private int pos = 0;
   private int[] stack = new int[32];
   private int stackSize = 0;

   static {
      JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() {
         public void promoteNameToValue(JsonReader var1) throws IOException {
            if(var1 instanceof JsonTreeReader) {
               ((JsonTreeReader)var1).promoteNameToValue();
            } else {
               int var2 = var1.peeked;
               if(var2 == 0) {
                  var2 = var1.doPeek();
               }

               if(var2 == 13) {
                  var1.peeked = 9;
               } else if(var2 == 12) {
                  var1.peeked = 8;
               } else if(var2 == 14) {
                  var1.peeked = 10;
               } else {
                  throw new IllegalStateException("Expected a name but was " + var1.peek() + " " + " at line " + var1.getLineNumber() + " column " + var1.getColumnNumber() + " path " + var1.getPath());
               }
            }
         }
      };
   }

   public JsonReader(Reader var1) {
      int[] var2 = this.stack;
      int var3 = this.stackSize;
      this.stackSize = var3 + 1;
      var2[var3] = 6;
      this.pathNames = new String[32];
      this.pathIndices = new int[32];
      if(var1 == null) {
         throw new NullPointerException("in == null");
      } else {
         this.field_427 = var1;
      }
   }

   private void checkLenient() throws IOException {
      if(!this.lenient) {
         throw this.syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
      }
   }

   private void consumeNonExecutePrefix() throws IOException {
      this.nextNonWhitespace(true);
      this.pos += -1;
      if(this.pos + NON_EXECUTE_PREFIX.length <= this.limit || this.fillBuffer(NON_EXECUTE_PREFIX.length)) {
         int var2 = 0;

         while(true) {
            if(var2 >= NON_EXECUTE_PREFIX.length) {
               this.pos += NON_EXECUTE_PREFIX.length;
               return;
            }

            if(this.buffer[var2 + this.pos] != NON_EXECUTE_PREFIX[var2]) {
               break;
            }

            ++var2;
         }
      }

   }

   private boolean fillBuffer(int var1) throws IOException {
      char[] var2 = this.buffer;
      this.lineStart -= this.pos;
      if(this.limit != this.pos) {
         this.limit -= this.pos;
         System.arraycopy(var2, this.pos, var2, 0, this.limit);
      } else {
         this.limit = 0;
      }

      this.pos = 0;

      boolean var4;
      while(true) {
         int var3 = this.field_427.read(var2, this.limit, var2.length - this.limit);
         var4 = false;
         if(var3 == -1) {
            break;
         }

         this.limit += var3;
         if(this.lineNumber == 0 && this.lineStart == 0 && this.limit > 0 && var2[0] == '\ufeff') {
            ++this.pos;
            ++this.lineStart;
            ++var1;
         }

         if(this.limit >= var1) {
            var4 = true;
            break;
         }
      }

      return var4;
   }

   private boolean isLiteral(char var1) throws IOException {
      switch(var1) {
      case '#':
      case '/':
      case ';':
      case '=':
      case '\\':
         this.checkLenient();
      case '\t':
      case '\n':
      case '\f':
      case '\r':
      case ' ':
      case ',':
      case ':':
      case '[':
      case ']':
      case '{':
      case '}':
         return false;
      default:
         return true;
      }
   }

   private int nextNonWhitespace(boolean var1) throws IOException {
      char[] var2 = this.buffer;
      int var3 = this.pos;
      int var4 = this.limit;

      while(true) {
         while(true) {
            if(var3 == var4) {
               this.pos = var3;
               if(!this.fillBuffer(1)) {
                  if(var1) {
                     throw new EOFException("End of input at line " + this.getLineNumber() + " column " + this.getColumnNumber());
                  }

                  return -1;
               }

               var3 = this.pos;
               var4 = this.limit;
            }

            int var5 = var3 + 1;
            char var6 = var2[var3];
            if(var6 == 10) {
               ++this.lineNumber;
               this.lineStart = var5;
               var3 = var5;
            } else if(var6 != 32 && var6 != 13) {
               if(var6 == 9) {
                  var3 = var5;
               } else if(var6 == 47) {
                  this.pos = var5;
                  if(var5 == var4) {
                     this.pos += -1;
                     boolean var7 = this.fillBuffer(2);
                     ++this.pos;
                     if(!var7) {
                        return var6;
                     }
                  }

                  this.checkLenient();
                  switch(var2[this.pos]) {
                  case '*':
                     ++this.pos;
                     if(!this.skipTo("*/")) {
                        throw this.syntaxError("Unterminated comment");
                     }

                     var3 = 2 + this.pos;
                     var4 = this.limit;
                     break;
                  case '/':
                     ++this.pos;
                     this.skipToEndOfLine();
                     var3 = this.pos;
                     var4 = this.limit;
                     break;
                  default:
                     return var6;
                  }
               } else {
                  if(var6 != 35) {
                     this.pos = var5;
                     return var6;
                  }

                  this.pos = var5;
                  this.checkLenient();
                  this.skipToEndOfLine();
                  var3 = this.pos;
                  var4 = this.limit;
               }
            } else {
               var3 = var5;
            }
         }
      }
   }

   private String nextQuotedValue(char var1) throws IOException {
      char[] var2 = this.buffer;
      StringBuilder var3 = new StringBuilder();

      do {
         int var4 = this.pos;
         int var5 = this.limit;
         int var6 = var4;

         int var7;
         int var9;
         for(var7 = var4; var7 < var5; var7 = var9) {
            var9 = var7 + 1;
            char var10 = var2[var7];
            if(var10 == var1) {
               this.pos = var9;
               var3.append(var2, var6, -1 + (var9 - var6));
               return var3.toString();
            }

            if(var10 == 92) {
               this.pos = var9;
               var3.append(var2, var6, -1 + (var9 - var6));
               var3.append(this.readEscapeCharacter());
               var9 = this.pos;
               var5 = this.limit;
               var6 = var9;
            } else if(var10 == 10) {
               ++this.lineNumber;
               this.lineStart = var9;
            }
         }

         var3.append(var2, var6, var7 - var6);
         this.pos = var7;
      } while(this.fillBuffer(1));

      throw this.syntaxError("Unterminated string");
   }

   private String nextUnquotedValue() throws IOException {
      StringBuilder var1 = null;
      int var2 = 0;

      label35:
      while(true) {
         if(var2 + this.pos < this.limit) {
            switch(this.buffer[var2 + this.pos]) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
               break label35;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
               this.checkLenient();
               break label35;
            default:
               ++var2;
            }
         } else if(var2 < this.buffer.length) {
            if(this.fillBuffer(var2 + 1)) {
               continue;
            }
            break;
         } else {
            if(var1 == null) {
               var1 = new StringBuilder();
            }

            var1.append(this.buffer, this.pos, var2);
            this.pos += var2;
            boolean var4 = this.fillBuffer(1);
            var2 = 0;
            if(!var4) {
               var2 = 0;
               break;
            }
         }
      }

      String var5;
      if(var1 == null) {
         var5 = new String(this.buffer, this.pos, var2);
      } else {
         var1.append(this.buffer, this.pos, var2);
         var5 = var1.toString();
      }

      this.pos += var2;
      return var5;
   }

   private int peekKeyword() throws IOException {
      char var1 = this.buffer[this.pos];
      String var2;
      String var3;
      byte var4;
      if(var1 != 116 && var1 != 84) {
         if(var1 != 102 && var1 != 70) {
            if(var1 != 110 && var1 != 78) {
               return 0;
            }

            var2 = "null";
            var3 = "NULL";
            var4 = 7;
         } else {
            var2 = "false";
            var3 = "FALSE";
            var4 = 6;
         }
      } else {
         var2 = "true";
         var3 = "TRUE";
         var4 = 5;
      }

      int var5 = var2.length();

      for(int var6 = 1; var6 < var5; ++var6) {
         if(var6 + this.pos >= this.limit && !this.fillBuffer(var6 + 1)) {
            return 0;
         }

         char var7 = this.buffer[var6 + this.pos];
         if(var7 != var2.charAt(var6) && var7 != var3.charAt(var6)) {
            return 0;
         }
      }

      if((var5 + this.pos < this.limit || this.fillBuffer(var5 + 1)) && this.isLiteral(this.buffer[var5 + this.pos])) {
         return 0;
      } else {
         this.pos += var5;
         this.peeked = var4;
         return var4;
      }
   }

   private int peekNumber() throws IOException {
      char[] var1 = this.buffer;
      int var2 = this.pos;
      int var3 = this.limit;
      long var4 = 0L;
      boolean var6 = false;
      boolean var7 = true;
      byte var8 = 0;
      int var9 = 0;

      label122:
      while(true) {
         if(var2 + var9 == var3) {
            if(var9 == var1.length) {
               return 0;
            }

            if(!this.fillBuffer(var9 + 1)) {
               break;
            }

            var2 = this.pos;
            var3 = this.limit;
         }

         char var10 = var1[var2 + var9];
         switch(var10) {
         case '+':
            if(var8 != 5) {
               return 0;
            }

            var8 = 6;
            break;
         case '-':
            if(var8 == 0) {
               var6 = true;
               var8 = 1;
            } else {
               if(var8 != 5) {
                  return 0;
               }

               var8 = 6;
            }
            break;
         case '.':
            if(var8 != 2) {
               return 0;
            }

            var8 = 3;
            break;
         case 'E':
         case 'e':
            if(var8 != 2 && var8 != 4) {
               return 0;
            }

            var8 = 5;
            break;
         default:
            if(var10 < 48 || var10 > 57) {
               if(this.isLiteral(var10)) {
                  return 0;
               }
               break label122;
            }

            if(var8 != 1 && var8 != 0) {
               if(var8 == 2) {
                  if(var4 == 0L) {
                     return 0;
                  }

                  long var11 = 10L * var4 - (long)(var10 - 48);
                  boolean var13;
                  if(var4 <= -922337203685477580L && (var4 != -922337203685477580L || var11 >= var4)) {
                     var13 = false;
                  } else {
                     var13 = true;
                  }

                  var7 &= var13;
                  var4 = var11;
               } else if(var8 == 3) {
                  var8 = 4;
               } else if(var8 == 5 || var8 == 6) {
                  var8 = 7;
               }
            } else {
               var4 = (long)(-(var10 - 48));
               var8 = 2;
            }
         }

         ++var9;
      }

      if(var8 == 2 && var7 && (var4 != Long.MIN_VALUE || var6)) {
         if(!var6) {
            var4 = -var4;
         }

         this.peekedLong = var4;
         this.pos += var9;
         this.peeked = 15;
         return 15;
      } else if(var8 != 2 && var8 != 4 && var8 != 7) {
         return 0;
      } else {
         this.peekedNumberLength = var9;
         this.peeked = 16;
         return 16;
      }
   }

   private void push(int var1) {
      if(this.stackSize == this.stack.length) {
         int[] var4 = new int[2 * this.stackSize];
         int[] var5 = new int[2 * this.stackSize];
         String[] var6 = new String[2 * this.stackSize];
         System.arraycopy(this.stack, 0, var4, 0, this.stackSize);
         System.arraycopy(this.pathIndices, 0, var5, 0, this.stackSize);
         System.arraycopy(this.pathNames, 0, var6, 0, this.stackSize);
         this.stack = var4;
         this.pathIndices = var5;
         this.pathNames = var6;
      }

      int[] var2 = this.stack;
      int var3 = this.stackSize;
      this.stackSize = var3 + 1;
      var2[var3] = var1;
   }

   private char readEscapeCharacter() throws IOException {
      if(this.pos == this.limit && !this.fillBuffer(1)) {
         throw this.syntaxError("Unterminated escape sequence");
      } else {
         char[] var1 = this.buffer;
         int var2 = this.pos;
         this.pos = var2 + 1;
         char var3 = var1[var2];
         switch(var3) {
         case '\n':
            ++this.lineNumber;
            this.lineStart = this.pos;
         default:
            return var3;
         case 'b':
            return '\b';
         case 'f':
            return '\f';
         case 'n':
            return '\n';
         case 'r':
            return '\r';
         case 't':
            return '\t';
         case 'u':
            if(4 + this.pos > this.limit && !this.fillBuffer(4)) {
               throw this.syntaxError("Unterminated escape sequence");
            } else {
               char var4 = 0;
               int var5 = this.pos;

               for(int var6 = var5 + 4; var5 < var6; ++var5) {
                  char var7 = this.buffer[var5];
                  char var8 = (char)(var4 << 4);
                  if(var7 >= 48 && var7 <= 57) {
                     var4 = (char)(var8 + (var7 - 48));
                  } else if(var7 >= 97 && var7 <= 102) {
                     var4 = (char)(var8 + 10 + (var7 - 97));
                  } else {
                     if(var7 < 65 || var7 > 70) {
                        throw new NumberFormatException("\\u" + new String(this.buffer, this.pos, 4));
                     }

                     var4 = (char)(var8 + 10 + (var7 - 65));
                  }
               }

               this.pos += 4;
               return var4;
            }
         }
      }
   }

   private void skipQuotedValue(char var1) throws IOException {
      char[] var2 = this.buffer;

      do {
         int var3 = this.pos;
         int var4 = this.limit;

         int var5;
         int var6;
         for(var5 = var3; var5 < var4; var5 = var6) {
            var6 = var5 + 1;
            char var7 = var2[var5];
            if(var7 == var1) {
               this.pos = var6;
               return;
            }

            if(var7 == 92) {
               this.pos = var6;
               this.readEscapeCharacter();
               var6 = this.pos;
               var4 = this.limit;
            } else if(var7 == 10) {
               ++this.lineNumber;
               this.lineStart = var6;
            }
         }

         this.pos = var5;
      } while(this.fillBuffer(1));

      throw this.syntaxError("Unterminated string");
   }

   private boolean skipTo(String var1) throws IOException {
      label27:
      for(; this.pos + var1.length() <= this.limit || this.fillBuffer(var1.length()); ++this.pos) {
         if(this.buffer[this.pos] == 10) {
            ++this.lineNumber;
            this.lineStart = 1 + this.pos;
         } else {
            for(int var2 = 0; var2 < var1.length(); ++var2) {
               if(this.buffer[var2 + this.pos] != var1.charAt(var2)) {
                  continue label27;
               }
            }

            return true;
         }
      }

      return false;
   }

   private void skipToEndOfLine() throws IOException {
      while(this.pos < this.limit || this.fillBuffer(1)) {
         char[] var1 = this.buffer;
         int var2 = this.pos;
         this.pos = var2 + 1;
         char var3 = var1[var2];
         if(var3 != 10) {
            if(var3 != 13) {
               continue;
            }

            return;
         }

         ++this.lineNumber;
         this.lineStart = this.pos;
         break;
      }

   }

   private void skipUnquotedValue() throws IOException {
      do {
         int var1 = 0;

         while(var1 + this.pos < this.limit) {
            switch(this.buffer[var1 + this.pos]) {
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
               this.checkLenient();
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
               this.pos += var1;
               return;
            default:
               ++var1;
            }
         }

         this.pos += var1;
      } while(this.fillBuffer(1));

   }

   private IOException syntaxError(String var1) throws IOException {
      throw new MalformedJsonException(var1 + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
   }

   public void beginArray() throws IOException {
      int var1 = this.peeked;
      if(var1 == 0) {
         var1 = this.doPeek();
      }

      if(var1 == 3) {
         this.push(1);
         this.pathIndices[-1 + this.stackSize] = 0;
         this.peeked = 0;
      } else {
         throw new IllegalStateException("Expected BEGIN_ARRAY but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
      }
   }

   public void beginObject() throws IOException {
      int var1 = this.peeked;
      if(var1 == 0) {
         var1 = this.doPeek();
      }

      if(var1 == 1) {
         this.push(3);
         this.peeked = 0;
      } else {
         throw new IllegalStateException("Expected BEGIN_OBJECT but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
      }
   }

   public void close() throws IOException {
      this.peeked = 0;
      this.stack[0] = 8;
      this.stackSize = 1;
      this.field_427.close();
   }

   int doPeek() throws IOException {
      int var1 = this.stack[-1 + this.stackSize];
      if(var1 == 1) {
         this.stack[-1 + this.stackSize] = 2;
      } else if(var1 == 2) {
         switch(this.nextNonWhitespace(true)) {
         case 44:
            break;
         case 59:
            this.checkLenient();
            break;
         case 93:
            this.peeked = 4;
            return 4;
         default:
            throw this.syntaxError("Unterminated array");
         }
      } else {
         if(var1 == 3 || var1 == 5) {
            this.stack[-1 + this.stackSize] = 4;
            if(var1 == 5) {
               switch(this.nextNonWhitespace(true)) {
               case 44:
                  break;
               case 59:
                  this.checkLenient();
                  break;
               case 125:
                  this.peeked = 2;
                  return 2;
               default:
                  throw this.syntaxError("Unterminated object");
               }
            }

            int var2 = this.nextNonWhitespace(true);
            switch(var2) {
            case 34:
               this.peeked = 13;
               return 13;
            case 39:
               this.checkLenient();
               this.peeked = 12;
               return 12;
            case 125:
               if(var1 != 5) {
                  this.peeked = 2;
                  return 2;
               }

               throw this.syntaxError("Expected name");
            default:
               this.checkLenient();
               this.pos += -1;
               if(this.isLiteral((char)var2)) {
                  this.peeked = 14;
                  return 14;
               }

               throw this.syntaxError("Expected name");
            }
         }

         if(var1 == 4) {
            this.stack[-1 + this.stackSize] = 5;
            switch(this.nextNonWhitespace(true)) {
            case 58:
               break;
            case 59:
            case 60:
            default:
               throw this.syntaxError("Expected \':\'");
            case 61:
               this.checkLenient();
               if((this.pos < this.limit || this.fillBuffer(1)) && this.buffer[this.pos] == 62) {
                  ++this.pos;
               }
            }
         } else if(var1 == 6) {
            if(this.lenient) {
               this.consumeNonExecutePrefix();
            }

            this.stack[-1 + this.stackSize] = 7;
         } else if(var1 == 7) {
            if(this.nextNonWhitespace(false) == -1) {
               this.peeked = 17;
               return 17;
            }

            this.checkLenient();
            this.pos += -1;
         } else if(var1 == 8) {
            throw new IllegalStateException("JsonReader is closed");
         }
      }

      switch(this.nextNonWhitespace(true)) {
      case 34:
         this.peeked = 9;
         return 9;
      case 39:
         this.checkLenient();
         this.peeked = 8;
         return 8;
      case 91:
         this.peeked = 3;
         return 3;
      case 93:
         if(var1 == 1) {
            this.peeked = 4;
            return 4;
         }
      case 44:
      case 59:
         if(var1 != 1 && var1 != 2) {
            throw this.syntaxError("Unexpected value");
         }

         this.checkLenient();
         this.pos += -1;
         this.peeked = 7;
         return 7;
      case 123:
         this.peeked = 1;
         return 1;
      default:
         this.pos += -1;
         int var3 = this.peekKeyword();
         if(var3 == 0) {
            var3 = this.peekNumber();
            if(var3 == 0) {
               if(!this.isLiteral(this.buffer[this.pos])) {
                  throw this.syntaxError("Expected value");
               }

               this.checkLenient();
               this.peeked = 10;
               return 10;
            }
         }

         return var3;
      }
   }

   public void endArray() throws IOException {
      int var1 = this.peeked;
      if(var1 == 0) {
         var1 = this.doPeek();
      }

      if(var1 == 4) {
         this.stackSize += -1;
         int[] var2 = this.pathIndices;
         int var3 = -1 + this.stackSize;
         ++var2[var3];
         this.peeked = 0;
      } else {
         throw new IllegalStateException("Expected END_ARRAY but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
      }
   }

   public void endObject() throws IOException {
      int var1 = this.peeked;
      if(var1 == 0) {
         var1 = this.doPeek();
      }

      if(var1 == 2) {
         this.stackSize += -1;
         this.pathNames[this.stackSize] = null;
         int[] var2 = this.pathIndices;
         int var3 = -1 + this.stackSize;
         ++var2[var3];
         this.peeked = 0;
      } else {
         throw new IllegalStateException("Expected END_OBJECT but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
      }
   }

   int getColumnNumber() {
      return 1 + (this.pos - this.lineStart);
   }

   int getLineNumber() {
      return 1 + this.lineNumber;
   }

   public String getPath() {
      StringBuilder var1 = (new StringBuilder()).append('$');
      int var2 = 0;

      for(int var3 = this.stackSize; var2 < var3; ++var2) {
         switch(this.stack[var2]) {
         case 1:
         case 2:
            var1.append('[').append(this.pathIndices[var2]).append(']');
            break;
         case 3:
         case 4:
         case 5:
            var1.append('.');
            if(this.pathNames[var2] != null) {
               var1.append(this.pathNames[var2]);
            }
         }
      }

      return var1.toString();
   }

   public boolean hasNext() throws IOException {
      int var1 = this.peeked;
      if(var1 == 0) {
         var1 = this.doPeek();
      }

      return var1 != 2 && var1 != 4;
   }

   public final boolean isLenient() {
      return this.lenient;
   }

   public boolean nextBoolean() throws IOException {
      int var1 = this.peeked;
      if(var1 == 0) {
         var1 = this.doPeek();
      }

      if(var1 == 5) {
         this.peeked = 0;
         int[] var4 = this.pathIndices;
         int var5 = -1 + this.stackSize;
         ++var4[var5];
         return true;
      } else if(var1 == 6) {
         this.peeked = 0;
         int[] var2 = this.pathIndices;
         int var3 = -1 + this.stackSize;
         ++var2[var3];
         return false;
      } else {
         throw new IllegalStateException("Expected a boolean but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
      }
   }

   public double nextDouble() throws IOException {
      int var1 = this.peeked;
      if(var1 == 0) {
         var1 = this.doPeek();
      }

      if(var1 == 15) {
         this.peeked = 0;
         int[] var7 = this.pathIndices;
         int var8 = -1 + this.stackSize;
         ++var7[var8];
         return (double)this.peekedLong;
      } else {
         if(var1 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
         } else if(var1 != 8 && var1 != 9) {
            if(var1 == 10) {
               this.peekedString = this.nextUnquotedValue();
            } else if(var1 != 11) {
               throw new IllegalStateException("Expected a double but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
            }
         } else {
            char var2;
            if(var1 == 8) {
               var2 = 39;
            } else {
               var2 = 34;
            }

            this.peekedString = this.nextQuotedValue(var2);
         }

         this.peeked = 11;
         double var3 = Double.parseDouble(this.peekedString);
         if(!this.lenient && (Double.isNaN(var3) || Double.isInfinite(var3))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + var3 + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
         } else {
            this.peekedString = null;
            this.peeked = 0;
            int[] var5 = this.pathIndices;
            int var6 = -1 + this.stackSize;
            ++var5[var6];
            return var3;
         }
      }
   }

   public int nextInt() throws IOException {
      int var1 = this.peeked;
      if(var1 == 0) {
         var1 = this.doPeek();
      }

      if(var1 == 15) {
         int var12 = (int)this.peekedLong;
         if(this.peekedLong != (long)var12) {
            throw new NumberFormatException("Expected an int but was " + this.peekedLong + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
         } else {
            this.peeked = 0;
            int[] var13 = this.pathIndices;
            int var14 = -1 + this.stackSize;
            ++var13[var14];
            return var12;
         }
      } else {
         if(var1 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
         } else {
            if(var1 != 8 && var1 != 9) {
               throw new IllegalStateException("Expected an int but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
            }

            char var2;
            if(var1 == 8) {
               var2 = 39;
            } else {
               var2 = 34;
            }

            this.peekedString = this.nextQuotedValue(var2);

            try {
               int var9 = Integer.parseInt(this.peekedString);
               this.peeked = 0;
               int[] var10 = this.pathIndices;
               int var11 = -1 + this.stackSize;
               ++var10[var11];
               return var9;
            } catch (NumberFormatException var15) {
               ;
            }
         }

         this.peeked = 11;
         double var4 = Double.parseDouble(this.peekedString);
         int var6 = (int)var4;
         if((double)var6 != var4) {
            throw new NumberFormatException("Expected an int but was " + this.peekedString + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
         } else {
            this.peekedString = null;
            this.peeked = 0;
            int[] var7 = this.pathIndices;
            int var8 = -1 + this.stackSize;
            ++var7[var8];
            return var6;
         }
      }
   }

   public long nextLong() throws IOException {
      int var1 = this.peeked;
      if(var1 == 0) {
         var1 = this.doPeek();
      }

      if(var1 == 15) {
         this.peeked = 0;
         int[] var14 = this.pathIndices;
         int var15 = -1 + this.stackSize;
         ++var14[var15];
         return this.peekedLong;
      } else {
         if(var1 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
         } else {
            if(var1 != 8 && var1 != 9) {
               throw new IllegalStateException("Expected a long but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
            }

            char var2;
            if(var1 == 8) {
               var2 = 39;
            } else {
               var2 = 34;
            }

            this.peekedString = this.nextQuotedValue(var2);

            try {
               long var10 = Long.parseLong(this.peekedString);
               this.peeked = 0;
               int[] var12 = this.pathIndices;
               int var13 = -1 + this.stackSize;
               ++var12[var13];
               return var10;
            } catch (NumberFormatException var16) {
               ;
            }
         }

         this.peeked = 11;
         double var4 = Double.parseDouble(this.peekedString);
         long var6 = (long)var4;
         if((double)var6 != var4) {
            throw new NumberFormatException("Expected a long but was " + this.peekedString + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
         } else {
            this.peekedString = null;
            this.peeked = 0;
            int[] var8 = this.pathIndices;
            int var9 = -1 + this.stackSize;
            ++var8[var9];
            return var6;
         }
      }
   }

   public String nextName() throws IOException {
      int var1 = this.peeked;
      if(var1 == 0) {
         var1 = this.doPeek();
      }

      String var2;
      if(var1 == 14) {
         var2 = this.nextUnquotedValue();
      } else if(var1 == 12) {
         var2 = this.nextQuotedValue('\'');
      } else {
         if(var1 != 13) {
            throw new IllegalStateException("Expected a name but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
         }

         var2 = this.nextQuotedValue('\"');
      }

      this.peeked = 0;
      this.pathNames[-1 + this.stackSize] = var2;
      return var2;
   }

   public void nextNull() throws IOException {
      int var1 = this.peeked;
      if(var1 == 0) {
         var1 = this.doPeek();
      }

      if(var1 == 7) {
         this.peeked = 0;
         int[] var2 = this.pathIndices;
         int var3 = -1 + this.stackSize;
         ++var2[var3];
      } else {
         throw new IllegalStateException("Expected null but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
      }
   }

   public String nextString() throws IOException {
      int var1 = this.peeked;
      if(var1 == 0) {
         var1 = this.doPeek();
      }

      String var2;
      if(var1 == 10) {
         var2 = this.nextUnquotedValue();
      } else if(var1 == 8) {
         var2 = this.nextQuotedValue('\'');
      } else if(var1 == 9) {
         var2 = this.nextQuotedValue('\"');
      } else if(var1 == 11) {
         var2 = this.peekedString;
         this.peekedString = null;
      } else if(var1 == 15) {
         var2 = Long.toString(this.peekedLong);
      } else {
         if(var1 != 16) {
            throw new IllegalStateException("Expected a string but was " + this.peek() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber() + " path " + this.getPath());
         }

         var2 = new String(this.buffer, this.pos, this.peekedNumberLength);
         this.pos += this.peekedNumberLength;
      }

      this.peeked = 0;
      int[] var3 = this.pathIndices;
      int var4 = -1 + this.stackSize;
      ++var3[var4];
      return var2;
   }

   public JsonToken peek() throws IOException {
      int var1 = this.peeked;
      if(var1 == 0) {
         var1 = this.doPeek();
      }

      switch(var1) {
      case 1:
         return JsonToken.BEGIN_OBJECT;
      case 2:
         return JsonToken.END_OBJECT;
      case 3:
         return JsonToken.BEGIN_ARRAY;
      case 4:
         return JsonToken.END_ARRAY;
      case 5:
      case 6:
         return JsonToken.BOOLEAN;
      case 7:
         return JsonToken.NULL;
      case 8:
      case 9:
      case 10:
      case 11:
         return JsonToken.STRING;
      case 12:
      case 13:
      case 14:
         return JsonToken.NAME;
      case 15:
      case 16:
         return JsonToken.NUMBER;
      case 17:
         return JsonToken.END_DOCUMENT;
      default:
         throw new AssertionError();
      }
   }

   public final void setLenient(boolean var1) {
      this.lenient = var1;
   }

   public void skipValue() throws IOException {
      int var1 = 0;

      do {
         int var2 = this.peeked;
         if(var2 == 0) {
            var2 = this.doPeek();
         }

         if(var2 == 3) {
            this.push(1);
            ++var1;
         } else if(var2 == 1) {
            this.push(3);
            ++var1;
         } else if(var2 == 4) {
            this.stackSize += -1;
            --var1;
         } else if(var2 == 2) {
            this.stackSize += -1;
            --var1;
         } else if(var2 != 14 && var2 != 10) {
            if(var2 != 8 && var2 != 12) {
               if(var2 != 9 && var2 != 13) {
                  if(var2 == 16) {
                     this.pos += this.peekedNumberLength;
                  }
               } else {
                  this.skipQuotedValue('\"');
               }
            } else {
               this.skipQuotedValue('\'');
            }
         } else {
            this.skipUnquotedValue();
         }

         this.peeked = 0;
      } while(var1 != 0);

      int[] var3 = this.pathIndices;
      int var4 = -1 + this.stackSize;
      ++var3[var4];
      this.pathNames[-1 + this.stackSize] = "null";
   }

   public String toString() {
      return this.getClass().getSimpleName() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber();
   }
}
