package com.peirr.blooadapp.io;

import com.peirr.blooadapp.io.ResponseType;

public class Response {
   public String description;
   public ResponseType responseType;
   public String stamp;
   public int total;

   public Response() {
      this.responseType = ResponseType.INFO;
   }

   public String toString() {
      return "Response{description=\'" + this.description + '\'' + ", responseType=" + this.responseType + ", stamp=\'" + this.stamp + '\'' + ", total=" + this.total + '}';
   }
}
