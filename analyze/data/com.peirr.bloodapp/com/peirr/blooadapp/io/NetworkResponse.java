package com.peirr.blooadapp.io;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonArray;
import com.peirr.blooadapp.io.Response;
import com.peirr.blooadapp.io.ResponseType;

public class NetworkResponse implements Parcelable {
   public JsonArray data;
   public Response response = new Response();

   public int describeContents() {
      return 0;
   }

   public String getMessage() {
      return this.response.description;
   }

   public boolean isError() {
      return this.response.responseType == ResponseType.INFO;
   }

   public String toString() {
      return "NetworkResponse{data=\'" + this.data + '\'' + ", response=" + this.response + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
   }
}
