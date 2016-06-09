package com.peirr.blooadapp.io;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.peirr.blooadapp.io.Doctor;
import com.peirr.blooadapp.io.NetworkResponse;
import com.peirr.blooadapp.io.Patient;
import com.peirr.blooadapp.io.Response;
import com.peirr.blooadapp.io.ResponseType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

public class ResponseHelper {
   public static Map<String, String> createPatientHash(Patient var0) {
      HashMap var1 = new HashMap();
      var1.put("age", String.valueOf(var0.age));
      var1.put("gender", String.valueOf(var0.gender));
      var1.put("height", String.valueOf(var0.height));
      var1.put("weight", String.valueOf(var0.weight));
      var1.put("cardiac", String.valueOf(var0.cardiac));
      var1.put("operation", String.valueOf(var0.operation));
      var1.put("preop_lab_level", String.valueOf(var0.preop_lab_level));
      var1.put("first_pass_removed", String.valueOf(var0.first_pass_removed));
      var1.put("prime_volume", String.valueOf(var0.prime_volume));
      var1.put("fluid_prebypass", String.valueOf(var0.fluid_prebypass));
      var1.put("urine_prebypass", String.valueOf(var0.urine_prebypass));
      var1.put("rbc_required", String.valueOf(var0.rbc_required));
      var1.put("required_hb", String.valueOf(var0.required_hb));
      return var1;
   }

   public static NetworkResponse createResponse(JsonObject var0) throws JSONException {
      NetworkResponse var1 = new NetworkResponse();
      if(var0 != null) {
         JsonObject var2 = var0.get("response").getAsJsonObject();
         var1.response.description = var2.get("description").getAsString();
         Response var3 = var1.response;
         ResponseType var4;
         if(var2.get("responsetype").getAsString().equals("DATA")) {
            var4 = ResponseType.DATA;
         } else {
            var4 = ResponseType.INFO;
         }

         var3.responseType = var4;
         var1.response.stamp = var2.get("stamp").getAsString();
         var1.response.total = var2.get("total").getAsInt();
         if(var1.response.responseType == ResponseType.DATA) {
            var1.data = var0.get("data").getAsJsonArray();
         }

         return var1;
      } else {
         var1.response.description = "unknown error";
         return var1;
      }
   }

   private static Doctor getDoctor(JsonObject var0) {
      Doctor var1 = new Doctor();
      var1.country = var0.get("country").getAsString();
      var1.docid = var0.get("docid").getAsInt();
      var1.email = var0.get("email").getAsString();
      var1.hospital = var0.get("hospital").getAsString();
      var1.name = var0.get("name").getAsString();
      var1.position = var0.get("position").getAsString();
      var1.profession = var0.get("profession").getAsString();
      var1.registration_ts = var0.get("registration_ts").getAsString();
      return var1;
   }

   public static List<Doctor> getDoctors(JsonArray var0) {
      ArrayList var1 = new ArrayList();

      for(int var2 = 0; var2 < var0.size(); ++var2) {
         var1.add(getDoctor(var0.get(var2).getAsJsonObject()));
      }

      return var1;
   }

   private static Patient getPatient(JsonObject var0) {
      Patient var1 = new Patient();
      var1.age = var0.get("age").getAsInt();
      var1.calc_ts = var0.get("calc_ts").getAsString();
      var1.calcid = var0.get("calcid").getAsInt();
      var1.first_pass_removed = var0.get("first_pass_removed").getAsFloat();
      var1.fluid_prebypass = var0.get("fluid_prebypass").getAsFloat();
      var1.gender = var0.get("gender").getAsInt();
      var1.height = var0.get("height").getAsFloat();
      var1.nc_blood_loss = var0.get("nc_blood_loss").getAsFloat();
      var1.nc_blood_vol = var0.get("nc_blood_vol").getAsFloat();
      var1.nc_required_post_op_level = var0.get("nc_required_post_op_level").getAsFloat();
      var1.operation = var0.get("operation").getAsString();
      var1.preop_lab_level = var0.get("preop_lab_level").getAsFloat();
      var1.prime_volume = var0.get("prime_volume").getAsFloat();
      var1.urine_prebypass = var0.get("urine_prebypass").getAsFloat();
      var1.weight = var0.get("weight").getAsFloat();
      var1.cardiac = var0.get("cardiac").getAsInt();
      var1.required_hb = var0.get("required_hb").getAsFloat();
      var1.rbc_required = var0.get("rbc_required").getAsFloat();
      return var1;
   }

   public static List<Patient> getPatients(JsonArray var0) {
      ArrayList var1 = new ArrayList();

      for(int var2 = 0; var2 < var0.size(); ++var2) {
         var1.add(getPatient(var0.get(var2).getAsJsonObject()));
      }

      return var1;
   }
}
