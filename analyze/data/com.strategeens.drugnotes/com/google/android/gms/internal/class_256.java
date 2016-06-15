package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_251;
import com.google.android.gms.internal.class_730;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.pt
public final class class_256 extends class_251 implements Person {
   public class_256(DataHolder var1, int var2) {
      super(var1, var2);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1679();
   }

   public String getAboutMe() {
      return null;
   }

   public Person.AgeRange getAgeRange() {
      return null;
   }

   public String getBirthday() {
      return null;
   }

   public String getBraggingRights() {
      return null;
   }

   public int getCircledByCount() {
      return 0;
   }

   public Person.Cover getCover() {
      return null;
   }

   public String getCurrentLocation() {
      return null;
   }

   public String getDisplayName() {
      return this.getString("displayName");
   }

   public int getGender() {
      return 0;
   }

   public String getId() {
      return this.getString("personId");
   }

   public Person.Image getImage() {
      return new class_730.class_1703(this.getString("image"));
   }

   public String getLanguage() {
      return null;
   }

   public Person.Name getName() {
      return null;
   }

   public String getNickname() {
      return null;
   }

   public int getObjectType() {
      return class_730.class_1701.method_5764(this.getString("objectType"));
   }

   // $FF: synthetic method
   public List getOrganizations() {
      return this.method_1676();
   }

   // $FF: synthetic method
   public List getPlacesLived() {
      return this.method_1677();
   }

   public int getPlusOneCount() {
      return 0;
   }

   public int getRelationshipStatus() {
      return 0;
   }

   public String getTagline() {
      return null;
   }

   public String getUrl() {
      return this.getString("url");
   }

   // $FF: synthetic method
   public List getUrls() {
      return this.method_1678();
   }

   public boolean hasAboutMe() {
      return false;
   }

   public boolean hasAgeRange() {
      return false;
   }

   public boolean hasBirthday() {
      return false;
   }

   public boolean hasBraggingRights() {
      return false;
   }

   public boolean hasCircledByCount() {
      return false;
   }

   public boolean hasCover() {
      return false;
   }

   public boolean hasCurrentLocation() {
      return false;
   }

   public boolean hasDisplayName() {
      return true;
   }

   public boolean hasGender() {
      return false;
   }

   public boolean hasId() {
      return true;
   }

   public boolean hasImage() {
      return true;
   }

   public boolean hasIsPlusUser() {
      return false;
   }

   public boolean hasLanguage() {
      return false;
   }

   public boolean hasName() {
      return false;
   }

   public boolean hasNickname() {
      return false;
   }

   public boolean hasObjectType() {
      return true;
   }

   public boolean hasOrganizations() {
      return false;
   }

   public boolean hasPlacesLived() {
      return false;
   }

   public boolean hasPlusOneCount() {
      return false;
   }

   public boolean hasRelationshipStatus() {
      return false;
   }

   public boolean hasTagline() {
      return false;
   }

   public boolean hasUrl() {
      return true;
   }

   public boolean hasUrls() {
      return false;
   }

   public boolean hasVerified() {
      return false;
   }

   public boolean isPlusUser() {
      return false;
   }

   public boolean isVerified() {
      return false;
   }

   // $FF: renamed from: oW () java.util.ArrayList
   public ArrayList<Person.Organizations> method_1676() {
      return null;
   }

   // $FF: renamed from: oX () java.util.ArrayList
   public ArrayList<Person.PlacesLived> method_1677() {
      return null;
   }

   // $FF: renamed from: oY () java.util.ArrayList
   public ArrayList<Person.Urls> method_1678() {
      return null;
   }

   // $FF: renamed from: oZ () com.google.android.gms.plus.model.people.Person
   public Person method_1679() {
      return new class_730(this.getDisplayName(), this.getId(), (class_730.class_1703)this.getImage(), this.getObjectType(), this.getUrl());
   }
}
