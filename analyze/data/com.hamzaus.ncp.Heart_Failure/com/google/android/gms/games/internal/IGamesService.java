package com.google.android.gms.games.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.IGamesCallbacks;
import com.google.android.gms.games.internal.multiplayer.ZInvitationCluster;
import com.google.android.gms.games.internal.request.GameRequestCluster;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;

public interface IGamesService extends IInterface {
   // $FF: renamed from: E (boolean) void
   void method_407(boolean var1) throws RemoteException;

   // $FF: renamed from: F (boolean) void
   void method_408(boolean var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, byte[], java.lang.String, java.lang.String) int
   int method_409(IGamesCallbacks var1, byte[] var2, String var3, String var4) throws RemoteException;

   // $FF: renamed from: a (int, int, boolean) android.content.Intent
   Intent method_410(int var1, int var2, boolean var3) throws RemoteException;

   // $FF: renamed from: a (int, byte[], int, java.lang.String) android.content.Intent
   Intent method_411(int var1, byte[] var2, int var3, String var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.multiplayer.ZInvitationCluster, java.lang.String, java.lang.String) android.content.Intent
   Intent method_412(ZInvitationCluster var1, String var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.request.GameRequestCluster, java.lang.String) android.content.Intent
   Intent method_413(GameRequestCluster var1, String var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomEntity, int) android.content.Intent
   Intent method_414(RoomEntity var1, int var2) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, boolean, boolean, int) android.content.Intent
   Intent method_415(String var1, boolean var2, boolean var3, int var4) throws RemoteException;

   // $FF: renamed from: a (int[]) android.content.Intent
   Intent method_416(int[] var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.ParticipantEntity[], java.lang.String, java.lang.String, android.net.Uri, android.net.Uri) android.content.Intent
   Intent method_417(ParticipantEntity[] var1, String var2, String var3, Uri var4, Uri var5) throws RemoteException;

   // $FF: renamed from: a (long, java.lang.String) void
   void method_418(long var1, String var3) throws RemoteException;

   // $FF: renamed from: a (android.os.IBinder, android.os.Bundle) void
   void method_419(IBinder var1, Bundle var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.Contents) void
   void method_420(Contents var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks) void
   void method_421(IGamesCallbacks var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int) void
   void method_422(IGamesCallbacks var1, int var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int, int) void
   void method_423(IGamesCallbacks var1, int var2, int var3, int var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int, boolean, boolean) void
   void method_424(IGamesCallbacks var1, int var2, int var3, boolean var4, boolean var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int, java.lang.String[], android.os.Bundle) void
   void method_425(IGamesCallbacks var1, int var2, int var3, String[] var4, Bundle var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
   void method_426(IGamesCallbacks var1, int var2, boolean var3, boolean var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int[]) void
   void method_427(IGamesCallbacks var1, int var2, int[] var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, long) void
   void method_428(IGamesCallbacks var1, long var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
   void method_429(IGamesCallbacks var1, long var2, String var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, android.os.Bundle, int, int) void
   void method_430(IGamesCallbacks var1, Bundle var2, int var3, int var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, android.os.IBinder, int, java.lang.String[], android.os.Bundle, boolean, long) void
   void method_431(IGamesCallbacks var1, IBinder var2, int var3, String[] var4, Bundle var5, boolean var6, long var7) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, android.os.IBinder, java.lang.String, boolean, long) void
   void method_432(IGamesCallbacks var1, IBinder var2, String var3, boolean var4, long var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_433(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int) void
   void method_434(IGamesCallbacks var1, String var2, int var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, int, int, boolean) void
   void method_435(IGamesCallbacks var1, String var2, int var3, int var4, int var5, boolean var6) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, android.os.IBinder, android.os.Bundle) void
   void method_436(IGamesCallbacks var1, String var2, int var3, IBinder var4, Bundle var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean) void
   void method_437(IGamesCallbacks var1, String var2, int var3, boolean var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
   void method_438(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean, boolean, boolean) void
   void method_439(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5, boolean var6, boolean var7) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, int[]) void
   void method_440(IGamesCallbacks var1, String var2, int var3, int[] var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, long) void
   void method_441(IGamesCallbacks var1, String var2, long var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, long, java.lang.String) void
   void method_442(IGamesCallbacks var1, String var2, long var3, String var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, android.os.IBinder, android.os.Bundle) void
   void method_443(IGamesCallbacks var1, String var2, IBinder var3, Bundle var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, com.google.android.gms.games.snapshot.SnapshotMetadataChange, com.google.android.gms.drive.Contents) void
   void method_444(IGamesCallbacks var1, String var2, SnapshotMetadataChange var3, Contents var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
   void method_445(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int) void
   void method_446(IGamesCallbacks var1, String var2, String var3, int var4, int var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int, int) void
   void method_447(IGamesCallbacks var1, String var2, String var3, int var4, int var5, int var6) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int, int, boolean) void
   void method_448(IGamesCallbacks var1, String var2, String var3, int var4, int var5, int var6, boolean var7) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, boolean, boolean) void
   void method_449(IGamesCallbacks var1, String var2, String var3, int var4, boolean var5, boolean var6) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, com.google.android.gms.games.snapshot.SnapshotMetadataChange, com.google.android.gms.drive.Contents) void
   void method_450(IGamesCallbacks var1, String var2, String var3, SnapshotMetadataChange var4, Contents var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, boolean) void
   void method_451(IGamesCallbacks var1, String var2, String var3, boolean var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int[], int, boolean) void
   void method_452(IGamesCallbacks var1, String var2, String var3, int[] var4, int var5, boolean var6) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, java.lang.String[]) void
   void method_453(IGamesCallbacks var1, String var2, String var3, String[] var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, java.lang.String[], boolean) void
   void method_454(IGamesCallbacks var1, String var2, String var3, String[] var4, boolean var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
   void method_455(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, byte[], java.lang.String, com.google.android.gms.games.multiplayer.ParticipantResult[]) void
   void method_456(IGamesCallbacks var1, String var2, byte[] var3, String var4, ParticipantResult[] var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, byte[], com.google.android.gms.games.multiplayer.ParticipantResult[]) void
   void method_457(IGamesCallbacks var1, String var2, byte[] var3, ParticipantResult[] var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int[]) void
   void method_458(IGamesCallbacks var1, String var2, int[] var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String[], int, byte[], int) void
   void method_459(IGamesCallbacks var1, String var2, String[] var3, int var4, byte[] var5, int var6) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
   void method_460(IGamesCallbacks var1, boolean var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, boolean, android.os.Bundle) void
   void method_461(IGamesCallbacks var1, boolean var2, Bundle var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, boolean, java.lang.String[]) void
   void method_462(IGamesCallbacks var1, boolean var2, String[] var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int[]) void
   void method_463(IGamesCallbacks var1, int[] var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int[], int, boolean) void
   void method_464(IGamesCallbacks var1, int[] var2, int var3, boolean var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[]) void
   void method_465(IGamesCallbacks var1, String[] var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[], boolean) void
   void method_466(IGamesCallbacks var1, String[] var2, boolean var3) throws RemoteException;

   // $FF: renamed from: aR (java.lang.String) android.content.Intent
   Intent method_467(String var1) throws RemoteException;

   // $FF: renamed from: aU (java.lang.String) android.content.Intent
   Intent method_468(String var1) throws RemoteException;

   // $FF: renamed from: aV (java.lang.String) java.lang.String
   String method_469(String var1) throws RemoteException;

   // $FF: renamed from: aW (java.lang.String) java.lang.String
   String method_470(String var1) throws RemoteException;

   // $FF: renamed from: aX (java.lang.String) void
   void method_471(String var1) throws RemoteException;

   // $FF: renamed from: aY (java.lang.String) int
   int method_472(String var1) throws RemoteException;

   // $FF: renamed from: aZ (java.lang.String) android.net.Uri
   Uri method_473(String var1) throws RemoteException;

   // $FF: renamed from: b (byte[], java.lang.String, java.lang.String[]) int
   int method_474(byte[] var1, String var2, String[] var3) throws RemoteException;

   // $FF: renamed from: b (int, int, boolean) android.content.Intent
   Intent method_475(int var1, int var2, boolean var3) throws RemoteException;

   // $FF: renamed from: b (long, java.lang.String) void
   void method_476(long var1, String var3) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks) void
   void method_477(IGamesCallbacks var1) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
   void method_478(IGamesCallbacks var1, int var2, boolean var3, boolean var4) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, long) void
   void method_479(IGamesCallbacks var1, long var2) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
   void method_480(IGamesCallbacks var1, long var2, String var4) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_481(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int) void
   void method_482(IGamesCallbacks var1, String var2, int var3) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, int, int, boolean) void
   void method_483(IGamesCallbacks var1, String var2, int var3, int var4, int var5, boolean var6) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, android.os.IBinder, android.os.Bundle) void
   void method_484(IGamesCallbacks var1, String var2, int var3, IBinder var4, Bundle var5) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean) void
   void method_485(IGamesCallbacks var1, String var2, int var3, boolean var4) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
   void method_486(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, android.os.IBinder, android.os.Bundle) void
   void method_487(IGamesCallbacks var1, String var2, IBinder var3, Bundle var4) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
   void method_488(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int, int, boolean) void
   void method_489(IGamesCallbacks var1, String var2, String var3, int var4, int var5, int var6, boolean var7) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, boolean, boolean) void
   void method_490(IGamesCallbacks var1, String var2, String var3, int var4, boolean var5, boolean var6) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, boolean) void
   void method_491(IGamesCallbacks var1, String var2, String var3, boolean var4) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
   void method_492(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
   void method_493(IGamesCallbacks var1, boolean var2) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[]) void
   void method_494(IGamesCallbacks var1, String[] var2) throws RemoteException;

   // $FF: renamed from: b (java.lang.String, java.lang.String, int) void
   void method_495(String var1, String var2, int var3) throws RemoteException;

   // $FF: renamed from: ba (java.lang.String) void
   void method_496(String var1) throws RemoteException;

   // $FF: renamed from: bb (java.lang.String) android.os.ParcelFileDescriptor
   ParcelFileDescriptor method_497(String var1) throws RemoteException;

   // $FF: renamed from: c (long, java.lang.String) void
   void method_498(long var1, String var3) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks) void
   void method_499(IGamesCallbacks var1) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
   void method_500(IGamesCallbacks var1, int var2, boolean var3, boolean var4) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, long) void
   void method_501(IGamesCallbacks var1, long var2) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
   void method_502(IGamesCallbacks var1, long var2, String var4) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_503(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int) void
   void method_504(IGamesCallbacks var1, String var2, int var3) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
   void method_505(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
   void method_506(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, boolean) void
   void method_507(IGamesCallbacks var1, String var2, String var3, boolean var4) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
   void method_508(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
   void method_509(IGamesCallbacks var1, boolean var2) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[]) void
   void method_510(IGamesCallbacks var1, String[] var2) throws RemoteException;

   // $FF: renamed from: c (java.lang.String, java.lang.String, int) void
   void method_511(String var1, String var2, int var3) throws RemoteException;

   // $FF: renamed from: ch (int) void
   void method_512(int var1) throws RemoteException;

   // $FF: renamed from: d (long, java.lang.String) void
   void method_513(long var1, String var3) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks) void
   void method_514(IGamesCallbacks var1) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
   void method_515(IGamesCallbacks var1, int var2, boolean var3, boolean var4) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, long) void
   void method_516(IGamesCallbacks var1, long var2) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
   void method_517(IGamesCallbacks var1, long var2, String var4) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_518(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
   void method_519(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
   void method_520(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
   void method_521(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
   void method_522(IGamesCallbacks var1, boolean var2) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks) void
   void method_523(IGamesCallbacks var1) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
   void method_524(IGamesCallbacks var1, int var2, boolean var3, boolean var4) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_525(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
   void method_526(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
   void method_527(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
   void method_528(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
   void method_529(IGamesCallbacks var1, boolean var2) throws RemoteException;

   // $FF: renamed from: ea () android.os.Bundle
   Bundle method_530() throws RemoteException;

   // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks) void
   void method_531(IGamesCallbacks var1) throws RemoteException;

   // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_532(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
   void method_533(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

   // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
   void method_534(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

   // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
   void method_535(IGamesCallbacks var1, boolean var2) throws RemoteException;

   // $FF: renamed from: g (android.net.Uri) android.os.ParcelFileDescriptor
   ParcelFileDescriptor method_536(Uri var1) throws RemoteException;

   // $FF: renamed from: g (com.google.android.gms.games.internal.IGamesCallbacks) void
   void method_537(IGamesCallbacks var1) throws RemoteException;

   // $FF: renamed from: g (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_538(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: gU () java.lang.String
   String method_539() throws RemoteException;

   // $FF: renamed from: gV () java.lang.String
   String method_540() throws RemoteException;

   // $FF: renamed from: gY () android.content.Intent
   Intent method_541() throws RemoteException;

   // $FF: renamed from: gZ () android.content.Intent
   Intent method_542() throws RemoteException;

   // $FF: renamed from: h (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) com.google.android.gms.games.multiplayer.realtime.RoomEntity
   RoomEntity method_543(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: h (com.google.android.gms.games.internal.IGamesCallbacks) void
   void method_544(IGamesCallbacks var1) throws RemoteException;

   // $FF: renamed from: ha () android.content.Intent
   Intent method_545() throws RemoteException;

   // $FF: renamed from: hb () android.content.Intent
   Intent method_546() throws RemoteException;

   // $FF: renamed from: hg () android.content.Intent
   Intent method_547() throws RemoteException;

   // $FF: renamed from: hh () android.content.Intent
   Intent method_548() throws RemoteException;

   // $FF: renamed from: hi () int
   int method_549() throws RemoteException;

   // $FF: renamed from: hj () java.lang.String
   String method_550() throws RemoteException;

   // $FF: renamed from: hk () int
   int method_551() throws RemoteException;

   // $FF: renamed from: hl () android.content.Intent
   Intent method_552() throws RemoteException;

   // $FF: renamed from: hm () int
   int method_553() throws RemoteException;

   // $FF: renamed from: hn () int
   int method_554() throws RemoteException;

   // $FF: renamed from: ho () int
   int method_555() throws RemoteException;

   // $FF: renamed from: hp () int
   int method_556() throws RemoteException;

   // $FF: renamed from: hr () void
   void method_557() throws RemoteException;

   // $FF: renamed from: ht () com.google.android.gms.common.data.DataHolder
   DataHolder method_558() throws RemoteException;

   // $FF: renamed from: hu () boolean
   boolean method_559() throws RemoteException;

   // $FF: renamed from: hv () com.google.android.gms.common.data.DataHolder
   DataHolder method_560() throws RemoteException;

   // $FF: renamed from: hw () void
   void method_561() throws RemoteException;

   // $FF: renamed from: hx () android.content.Intent
   Intent method_562() throws RemoteException;

   // $FF: renamed from: hy () void
   void method_563() throws RemoteException;

   // $FF: renamed from: hz () boolean
   boolean method_564() throws RemoteException;

   // $FF: renamed from: i (com.google.android.gms.games.internal.IGamesCallbacks) void
   void method_565(IGamesCallbacks var1) throws RemoteException;

   // $FF: renamed from: i (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_566(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: j (com.google.android.gms.games.internal.IGamesCallbacks) void
   void method_567(IGamesCallbacks var1) throws RemoteException;

   // $FF: renamed from: j (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_568(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: k (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_569(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: l (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_570(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: l (java.lang.String, int) void
   void method_571(String var1, int var2) throws RemoteException;

   // $FF: renamed from: m (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_572(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: m (java.lang.String, int) void
   void method_573(String var1, int var2) throws RemoteException;

   // $FF: renamed from: m (java.lang.String, java.lang.String) void
   void method_574(String var1, String var2) throws RemoteException;

   // $FF: renamed from: n (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_575(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: n (java.lang.String, int) void
   void method_576(String var1, int var2) throws RemoteException;

   // $FF: renamed from: n (java.lang.String, java.lang.String) void
   void method_577(String var1, String var2) throws RemoteException;

   // $FF: renamed from: o (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_578(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: p (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_579(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: p (java.lang.String, int) void
   void method_580(String var1, int var2) throws RemoteException;

   // $FF: renamed from: q (long) void
   void method_581(long var1) throws RemoteException;

   // $FF: renamed from: q (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_582(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: q (java.lang.String, int) void
   void method_583(String var1, int var2) throws RemoteException;

   // $FF: renamed from: r (long) void
   void method_584(long var1) throws RemoteException;

   // $FF: renamed from: r (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_585(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: s (long) void
   void method_586(long var1) throws RemoteException;

   // $FF: renamed from: s (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_587(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: t (long) void
   void method_588(long var1) throws RemoteException;

   // $FF: renamed from: t (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_589(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: u (long) void
   void method_590(long var1) throws RemoteException;

   // $FF: renamed from: u (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_591(IGamesCallbacks var1, String var2) throws RemoteException;

   public abstract static class Stub extends Binder implements IGamesService {
      public Stub() {
         this.attachInterface(this, "com.google.android.gms.games.internal.IGamesService");
      }

      // $FF: renamed from: aj (android.os.IBinder) com.google.android.gms.games.internal.IGamesService
      public static IGamesService method_4014(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
            return (IGamesService)(var1 != null && var1 instanceof IGamesService?(IGamesService)var1:new IGamesService.Proxy(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 5001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.q(var2.readLong());
            var3.writeNoException();
            return true;
         case 5002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            String var323 = this.hj();
            var3.writeNoException();
            var3.writeString(var323);
            return true;
         case 5004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Bundle var322 = this.ea();
            var3.writeNoException();
            if(var322 != null) {
               var3.writeInt(1);
               var322.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 5005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IBinder var320 = var2.readStrongBinder();
            Bundle var321;
            if(var2.readInt() != 0) {
               var321 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var321 = null;
            }

            this.a(var320, var321);
            var3.writeNoException();
            return true;
         case 5006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.hr();
            var3.writeNoException();
            return true;
         case 5007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            String var319 = this.gU();
            var3.writeNoException();
            var3.writeString(var319);
            return true;
         case 5012:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            String var317 = this.gV();
            var3.writeNoException();
            var3.writeString(var317);
            return true;
         case 5013:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            DataHolder var316 = this.ht();
            var3.writeNoException();
            if(var316 != null) {
               var3.writeInt(1);
               var316.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 5014:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5015:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var311 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            int var312 = var2.readInt();
            boolean var313;
            if(var2.readInt() != 0) {
               var313 = true;
            } else {
               var313 = false;
            }

            int var314 = var2.readInt();
            boolean var315 = false;
            if(var314 != 0) {
               var315 = true;
            }

            this.a(var311, var312, var313, var315);
            var3.writeNoException();
            return true;
         case 5016:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString(), var2.readLong());
            var3.writeNoException();
            return true;
         case 5017:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5018:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5019:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var305 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var306 = var2.readString();
            int var307 = var2.readInt();
            int var308 = var2.readInt();
            int var309 = var2.readInt();
            boolean var310;
            if(var2.readInt() != 0) {
               var310 = true;
            } else {
               var310 = false;
            }

            this.a(var305, var306, var307, var308, var309, var310);
            var3.writeNoException();
            return true;
         case 5020:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var299 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var300 = var2.readString();
            int var301 = var2.readInt();
            int var302 = var2.readInt();
            int var303 = var2.readInt();
            boolean var304;
            if(var2.readInt() != 0) {
               var304 = true;
            } else {
               var304 = false;
            }

            this.b(var299, var300, var301, var302, var303, var304);
            var3.writeNoException();
            return true;
         case 5021:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var297 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            Bundle var298;
            if(var2.readInt() != 0) {
               var298 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var298 = null;
            }

            this.a(var297, var298, var2.readInt(), var2.readInt());
            var3.writeNoException();
            return true;
         case 5022:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5023:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var293 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var294 = var2.readString();
            IBinder var295 = var2.readStrongBinder();
            Bundle var296;
            if(var2.readInt() != 0) {
               var296 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var296 = null;
            }

            this.a(var293, var294, var295, var296);
            var3.writeNoException();
            return true;
         case 5024:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var289 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var290 = var2.readString();
            IBinder var291 = var2.readStrongBinder();
            Bundle var292;
            if(var2.readInt() != 0) {
               var292 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var292 = null;
            }

            this.b(var289, var290, var291, var292);
            var3.writeNoException();
            return true;
         case 5025:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var283 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var284 = var2.readString();
            int var285 = var2.readInt();
            IBinder var286 = var2.readStrongBinder();
            int var287 = var2.readInt();
            Bundle var288 = null;
            if(var287 != 0) {
               var288 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.a(var283, var284, var285, var286, var288);
            var3.writeNoException();
            return true;
         case 5026:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.d(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5027:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.e(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5028:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.n(var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 5029:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.m(var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 5030:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var276 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            IBinder var277 = var2.readStrongBinder();
            int var278 = var2.readInt();
            String[] var279 = var2.createStringArray();
            int var280 = var2.readInt();
            Bundle var281 = null;
            if(var280 != 0) {
               var281 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            boolean var282;
            if(var2.readInt() != 0) {
               var282 = true;
            } else {
               var282 = false;
            }

            this.a(var276, var277, var278, var279, var281, var282, var2.readLong());
            var3.writeNoException();
            return true;
         case 5031:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var272 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            IBinder var273 = var2.readStrongBinder();
            String var274 = var2.readString();
            boolean var275;
            if(var2.readInt() != 0) {
               var275 = true;
            } else {
               var275 = false;
            }

            this.a(var272, var273, var274, var275, var2.readLong());
            var3.writeNoException();
            return true;
         case 5032:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5033:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var271 = this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.createByteArray(), var2.readString(), var2.readString());
            var3.writeNoException();
            var3.writeInt(var271);
            return true;
         case 5034:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var270 = this.b(var2.createByteArray(), var2.readString(), var2.createStringArray());
            var3.writeNoException();
            var3.writeInt(var270);
            return true;
         case 5035:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            String var269 = this.aW(var2.readString());
            var3.writeNoException();
            var3.writeString(var269);
            return true;
         case 5036:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.ch(var2.readInt());
            var3.writeNoException();
            return true;
         case 5037:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.d(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5038:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 5039:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var261 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var262 = var2.readString();
            String var263 = var2.readString();
            int var264 = var2.readInt();
            int var265 = var2.readInt();
            int var266 = var2.readInt();
            int var267 = var2.readInt();
            boolean var268 = false;
            if(var267 != 0) {
               var268 = true;
            }

            this.a(var261, var262, var263, var264, var265, var266, var268);
            var3.writeNoException();
            return true;
         case 5040:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var253 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var254 = var2.readString();
            String var255 = var2.readString();
            int var256 = var2.readInt();
            int var257 = var2.readInt();
            int var258 = var2.readInt();
            int var259 = var2.readInt();
            boolean var260 = false;
            if(var259 != 0) {
               var260 = true;
            }

            this.b(var253, var254, var255, var256, var257, var258, var260);
            var3.writeNoException();
            return true;
         case 5041:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 5042:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.e(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5043:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.f(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5044:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var248 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            int var249 = var2.readInt();
            int var250 = var2.readInt();
            boolean var251;
            if(var2.readInt() != 0) {
               var251 = true;
            } else {
               var251 = false;
            }

            boolean var252;
            if(var2.readInt() != 0) {
               var252 = true;
            } else {
               var252 = false;
            }

            this.a(var248, var249, var250, var251, var252);
            var3.writeNoException();
            return true;
         case 5045:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var243 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var244 = var2.readString();
            int var245 = var2.readInt();
            boolean var246;
            if(var2.readInt() != 0) {
               var246 = true;
            } else {
               var246 = false;
            }

            boolean var247;
            if(var2.readInt() != 0) {
               var247 = true;
            } else {
               var247 = false;
            }

            this.a(var243, var244, var245, var246, var247);
            var3.writeNoException();
            return true;
         case 5046:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var238 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            int var239 = var2.readInt();
            boolean var240;
            if(var2.readInt() != 0) {
               var240 = true;
            } else {
               var240 = false;
            }

            int var241 = var2.readInt();
            boolean var242 = false;
            if(var241 != 0) {
               var242 = true;
            }

            this.b(var238, var239, var240, var242);
            var3.writeNoException();
            return true;
         case 5047:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.f(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5048:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var233 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            int var234 = var2.readInt();
            boolean var235;
            if(var2.readInt() != 0) {
               var235 = true;
            } else {
               var235 = false;
            }

            int var236 = var2.readInt();
            boolean var237 = false;
            if(var236 != 0) {
               var237 = true;
            }

            this.c(var233, var234, var235, var237);
            var3.writeNoException();
            return true;
         case 5049:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.g(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5050:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.aX(var2.readString());
            var3.writeNoException();
            return true;
         case 5051:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(var2.readString(), var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 5052:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.g(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5053:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            RoomEntity var232 = this.h(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            if(var232 != null) {
               var3.writeInt(1);
               var232.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 5054:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var227 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var228 = var2.readString();
            int var229 = var2.readInt();
            boolean var230 = false;
            if(var229 != 0) {
               var230 = true;
            }

            this.a(var227, var228, var230);
            var3.writeNoException();
            return true;
         case 5055:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.p(var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 5056:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.h(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5057:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.j(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5058:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readLong());
            var3.writeNoException();
            return true;
         case 5059:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.r(var2.readLong());
            var3.writeNoException();
            return true;
         case 5060:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var231 = this.aY(var2.readString());
            var3.writeNoException();
            var3.writeInt(var231);
            return true;
         case 5061:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.i(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5062:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.i(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5063:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var219 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            int var220 = var2.readInt();
            boolean var221 = false;
            if(var220 != 0) {
               var221 = true;
            }

            Bundle var222;
            if(var2.readInt() != 0) {
               var222 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var222 = null;
            }

            this.a(var219, var221, var222);
            var3.writeNoException();
            return true;
         case 5064:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            String var318 = this.aV(var2.readString());
            var3.writeNoException();
            var3.writeString(var318);
            return true;
         case 5065:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.m(var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 5066:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Uri var218 = this.aZ(var2.readString());
            var3.writeNoException();
            if(var218 != null) {
               var3.writeInt(1);
               var218.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 5067:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            boolean var225 = this.hu();
            var3.writeNoException();
            byte var226 = 0;
            if(var225) {
               var226 = 1;
            }

            var3.writeInt(var226);
            return true;
         case 5068:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var223 = var2.readInt();
            boolean var224 = false;
            if(var223 != 0) {
               var224 = true;
            }

            this.E(var224);
            var3.writeNoException();
            return true;
         case 5501:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var213 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var214 = var2.readString();
            int var215 = var2.readInt();
            boolean var216;
            if(var2.readInt() != 0) {
               var216 = true;
            } else {
               var216 = false;
            }

            boolean var217;
            if(var2.readInt() != 0) {
               var217 = true;
            } else {
               var217 = false;
            }

            this.b(var213, var214, var215, var216, var217);
            var3.writeNoException();
            return true;
         case 5502:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            DataHolder var212 = this.hv();
            var3.writeNoException();
            if(var212 != null) {
               var3.writeInt(1);
               var212.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 6001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var209 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            int var210 = var2.readInt();
            boolean var211 = false;
            if(var210 != 0) {
               var211 = true;
            }

            this.a(var209, var211);
            var3.writeNoException();
            return true;
         case 6002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var204 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var205 = var2.readString();
            String var206 = var2.readString();
            int var207 = var2.readInt();
            boolean var208 = false;
            if(var207 != 0) {
               var208 = true;
            }

            this.a(var204, var205, var206, var208);
            var3.writeNoException();
            return true;
         case 6003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var199 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            int var200 = var2.readInt();
            boolean var201;
            if(var2.readInt() != 0) {
               var201 = true;
            } else {
               var201 = false;
            }

            int var202 = var2.readInt();
            boolean var203 = false;
            if(var202 != 0) {
               var203 = true;
            }

            this.d(var199, var200, var201, var203);
            var3.writeNoException();
            return true;
         case 6004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var194 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            int var195 = var2.readInt();
            boolean var196;
            if(var2.readInt() != 0) {
               var196 = true;
            } else {
               var196 = false;
            }

            int var197 = var2.readInt();
            boolean var198 = false;
            if(var197 != 0) {
               var198 = true;
            }

            this.e(var194, var195, var196, var198);
            var3.writeNoException();
            return true;
         case 6501:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var186 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var187 = var2.readString();
            int var188 = var2.readInt();
            boolean var189;
            if(var2.readInt() != 0) {
               var189 = true;
            } else {
               var189 = false;
            }

            boolean var190;
            if(var2.readInt() != 0) {
               var190 = true;
            } else {
               var190 = false;
            }

            boolean var191;
            if(var2.readInt() != 0) {
               var191 = true;
            } else {
               var191 = false;
            }

            int var192 = var2.readInt();
            boolean var193 = false;
            if(var192 != 0) {
               var193 = true;
            }

            this.a(var186, var187, var188, var189, var190, var191, var193);
            var3.writeNoException();
            return true;
         case 6502:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var182 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var183 = var2.readString();
            int var184 = var2.readInt();
            boolean var185 = false;
            if(var184 != 0) {
               var185 = true;
            }

            this.b(var182, var183, var185);
            var3.writeNoException();
            return true;
         case 6503:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var179 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            int var180 = var2.readInt();
            boolean var181 = false;
            if(var180 != 0) {
               var181 = true;
            }

            this.b(var179, var181);
            var3.writeNoException();
            return true;
         case 6504:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var175 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var176 = var2.readString();
            int var177 = var2.readInt();
            boolean var178 = false;
            if(var177 != 0) {
               var178 = true;
            }

            this.c(var175, var176, var178);
            var3.writeNoException();
            return true;
         case 6505:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var171 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var172 = var2.readString();
            int var173 = var2.readInt();
            boolean var174 = false;
            if(var173 != 0) {
               var174 = true;
            }

            this.d(var171, var172, var174);
            var3.writeNoException();
            return true;
         case 6506:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var166 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var167 = var2.readString();
            String var168 = var2.readString();
            int var169 = var2.readInt();
            boolean var170 = false;
            if(var169 != 0) {
               var170 = true;
            }

            this.b(var166, var167, var168, var170);
            var3.writeNoException();
            return true;
         case 6507:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Uri var164;
            if(var2.readInt() != 0) {
               var164 = (Uri)Uri.CREATOR.createFromParcel(var2);
            } else {
               var164 = null;
            }

            ParcelFileDescriptor var165 = this.g(var164);
            var3.writeNoException();
            if(var165 != null) {
               var3.writeInt(1);
               var165.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 7001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.k(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 7002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString(), var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 7003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var158 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var159 = var2.readString();
            int var160 = var2.readInt();
            IBinder var161 = var2.readStrongBinder();
            int var162 = var2.readInt();
            Bundle var163 = null;
            if(var162 != 0) {
               var163 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.b(var158, var159, var160, var161, var163);
            var3.writeNoException();
            return true;
         case 8001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.readInt(), var2.readInt());
            var3.writeNoException();
            return true;
         case 8002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.ba(var2.readString());
            var3.writeNoException();
            return true;
         case 8003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.createIntArray());
            var3.writeNoException();
            return true;
         case 8004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var152 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            int var153 = var2.readInt();
            int var154 = var2.readInt();
            String[] var155 = var2.createStringArray();
            int var156 = var2.readInt();
            Bundle var157 = null;
            if(var156 != 0) {
               var157 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.a(var152, var153, var154, var155, var157);
            var3.writeNoException();
            return true;
         case 8005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.l(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 8006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.m(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 8007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString(), var2.createByteArray(), var2.readString(), (ParticipantResult[])var2.createTypedArray(ParticipantResult.CREATOR));
            var3.writeNoException();
            return true;
         case 8008:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString(), var2.createByteArray(), (ParticipantResult[])var2.createTypedArray(ParticipantResult.CREATOR));
            var3.writeNoException();
            return true;
         case 8009:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.n(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 8010:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.o(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 8011:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 8012:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readLong());
            var3.writeNoException();
            return true;
         case 8013:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.s(var2.readLong());
            var3.writeNoException();
            return true;
         case 8014:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.p(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 8015:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.d(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 8016:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.e(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 8017:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString(), var2.createIntArray());
            var3.writeNoException();
            return true;
         case 8018:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 8019:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 8020:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 8021:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 8022:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.hw();
            var3.writeNoException();
            return true;
         case 8023:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var146 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var147 = var2.readString();
            int var148 = var2.readInt();
            int var149 = var2.readInt();
            boolean var150 = false;
            if(var149 != 0) {
               var150 = true;
            }

            this.a(var146, var147, var148, var150);
            var3.writeNoException();
            return true;
         case 8024:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var151 = this.hk();
            var3.writeNoException();
            var3.writeInt(var151);
            return true;
         case 8025:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.n(var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 8026:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(var2.readString(), var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 8027:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var143 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            int var144 = var2.readInt();
            boolean var145 = false;
            if(var144 != 0) {
               var145 = true;
            }

            this.c(var143, var145);
            var3.writeNoException();
            return true;
         case 9001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var138 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var139 = var2.readString();
            int var140 = var2.readInt();
            boolean var141;
            if(var2.readInt() != 0) {
               var141 = true;
            } else {
               var141 = false;
            }

            boolean var142;
            if(var2.readInt() != 0) {
               var142 = true;
            } else {
               var142 = false;
            }

            this.c(var138, var139, var140, var141, var142);
            var3.writeNoException();
            return true;
         case 9002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.q(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 9003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var137 = this.gY();
            var3.writeNoException();
            if(var137 != null) {
               var3.writeInt(1);
               var137.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var136 = this.aR(var2.readString());
            var3.writeNoException();
            if(var136 != null) {
               var3.writeInt(1);
               var136.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var135 = this.gZ();
            var3.writeNoException();
            if(var135 != null) {
               var3.writeInt(1);
               var135.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var134 = this.ha();
            var3.writeNoException();
            if(var134 != null) {
               var3.writeInt(1);
               var134.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var133 = this.hb();
            var3.writeNoException();
            if(var133 != null) {
               var3.writeInt(1);
               var133.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9008:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var129 = var2.readInt();
            int var130 = var2.readInt();
            boolean var131;
            if(var2.readInt() != 0) {
               var131 = true;
            } else {
               var131 = false;
            }

            Intent var132 = this.a(var129, var130, var131);
            var3.writeNoException();
            if(var132 != null) {
               var3.writeInt(1);
               var132.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9009:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var125 = var2.readInt();
            int var126 = var2.readInt();
            boolean var127;
            if(var2.readInt() != 0) {
               var127 = true;
            } else {
               var127 = false;
            }

            Intent var128 = this.b(var125, var126, var127);
            var3.writeNoException();
            if(var128 != null) {
               var3.writeInt(1);
               var128.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9010:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var124 = this.hg();
            var3.writeNoException();
            if(var124 != null) {
               var3.writeInt(1);
               var124.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9011:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            RoomEntity var122;
            if(var2.readInt() != 0) {
               var122 = (RoomEntity)RoomEntity.CREATOR.createFromParcel(var2);
            } else {
               var122 = null;
            }

            Intent var123 = this.a(var122, var2.readInt());
            var3.writeNoException();
            if(var123 != null) {
               var3.writeInt(1);
               var123.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9012:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var121 = this.hh();
            var3.writeNoException();
            if(var121 != null) {
               var3.writeInt(1);
               var121.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9013:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var120 = this.hx();
            var3.writeNoException();
            if(var120 != null) {
               var3.writeInt(1);
               var120.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9019:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var112 = this.hi();
            var3.writeNoException();
            var3.writeInt(var112);
            return true;
         case 9020:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var107 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var108 = var2.readString();
            int var109 = var2.readInt();
            boolean var110;
            if(var2.readInt() != 0) {
               var110 = true;
            } else {
               var110 = false;
            }

            boolean var111;
            if(var2.readInt() != 0) {
               var111 = true;
            } else {
               var111 = false;
            }

            this.d(var107, var108, var109, var110, var111);
            var3.writeNoException();
            return true;
         case 9028:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var101 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var102 = var2.readString();
            String var103 = var2.readString();
            int var104 = var2.readInt();
            boolean var105;
            if(var2.readInt() != 0) {
               var105 = true;
            } else {
               var105 = false;
            }

            boolean var106;
            if(var2.readInt() != 0) {
               var106 = true;
            } else {
               var106 = false;
            }

            this.a(var101, var102, var103, var104, var105, var106);
            var3.writeNoException();
            return true;
         case 9030:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ParcelFileDescriptor var100 = this.bb(var2.readString());
            var3.writeNoException();
            if(var100 != null) {
               var3.writeInt(1);
               var100.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9031:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ParticipantEntity[] var113 = (ParticipantEntity[])var2.createTypedArray(ParticipantEntity.CREATOR);
            String var114 = var2.readString();
            String var115 = var2.readString();
            Uri var116;
            if(var2.readInt() != 0) {
               var116 = (Uri)Uri.CREATOR.createFromParcel(var2);
            } else {
               var116 = null;
            }

            int var117 = var2.readInt();
            Uri var118 = null;
            if(var117 != 0) {
               var118 = (Uri)Uri.CREATOR.createFromParcel(var2);
            }

            Intent var119 = this.a(var113, var114, var115, var116, var118);
            var3.writeNoException();
            if(var119 != null) {
               var3.writeInt(1);
               var119.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 10001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readLong());
            var3.writeNoException();
            return true;
         case 10002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.t(var2.readLong());
            var3.writeNoException();
            return true;
         case 10003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 10004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 10005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString(), var2.createStringArray(), var2.readInt(), var2.createByteArray(), var2.readInt());
            var3.writeNoException();
            return true;
         case 10006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 10007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 10008:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 10009:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readInt(), var2.readInt(), var2.readInt());
            var3.writeNoException();
            return true;
         case 10010:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.readInt(), var2.readInt(), var2.readInt());
            var3.writeNoException();
            return true;
         case 10011:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 10012:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var99 = this.a(var2.readInt(), var2.createByteArray(), var2.readInt(), var2.readString());
            var3.writeNoException();
            if(var99 != null) {
               var3.writeInt(1);
               var99.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 10013:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var98 = this.hm();
            var3.writeNoException();
            var3.writeInt(var98);
            return true;
         case 10014:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.q(var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 10015:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var96 = this.hl();
            var3.writeNoException();
            if(var96 != null) {
               var3.writeInt(1);
               var96.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 10016:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readInt());
            var3.writeNoException();
            return true;
         case 10017:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var88 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var89 = var2.readString();
            int var90 = var2.readInt();
            int var91 = var2.readInt();
            boolean var92 = false;
            if(var91 != 0) {
               var92 = true;
            }

            this.b(var88, var89, var90, var92);
            var3.writeNoException();
            return true;
         case 10018:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readInt(), var2.createIntArray());
            var3.writeNoException();
            return true;
         case 10019:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString(), var2.readInt(), var2.createIntArray());
            var3.writeNoException();
            return true;
         case 10020:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 10021:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var85 = var2.readInt();
            ZInvitationCluster var86 = null;
            if(var85 != 0) {
               var86 = ZInvitationCluster.CREATOR.method_3803(var2);
            }

            Intent var87 = this.a(var86, var2.readString(), var2.readString());
            var3.writeNoException();
            if(var87 != null) {
               var3.writeInt(1);
               var87.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 10022:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var93 = var2.readInt();
            GameRequestCluster var94 = null;
            if(var93 != 0) {
               var94 = GameRequestCluster.CREATOR.method_4360(var2);
            }

            Intent var95 = this.a(var94, var2.readString());
            var3.writeNoException();
            if(var95 != null) {
               var3.writeInt(1);
               var95.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 10023:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var97 = this.hn();
            var3.writeNoException();
            var3.writeInt(var97);
            return true;
         case 11001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.j(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 11002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.hy();
            var3.writeNoException();
            return true;
         case 12001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            String var81 = var2.readString();
            boolean var82;
            if(var2.readInt() != 0) {
               var82 = true;
            } else {
               var82 = false;
            }

            boolean var83;
            if(var2.readInt() != 0) {
               var83 = true;
            } else {
               var83 = false;
            }

            Intent var84 = this.a(var81, var82, var83, var2.readInt());
            var3.writeNoException();
            if(var84 != null) {
               var3.writeInt(1);
               var84.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 12002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var78 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            int var79 = var2.readInt();
            boolean var80 = false;
            if(var79 != 0) {
               var80 = true;
            }

            this.d(var78, var80);
            var3.writeNoException();
            return true;
         case 12003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var73 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var74 = var2.readString();
            String var75 = var2.readString();
            int var76 = var2.readInt();
            boolean var77 = false;
            if(var76 != 0) {
               var77 = true;
            }

            this.c(var73, var74, var75, var77);
            var3.writeNoException();
            return true;
         case 12005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.s(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 12006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var69 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var70 = var2.readString();
            int var71 = var2.readInt();
            boolean var72 = false;
            if(var71 != 0) {
               var72 = true;
            }

            this.e(var69, var70, var72);
            var3.writeNoException();
            return true;
         case 12007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var65 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var66 = var2.readString();
            SnapshotMetadataChange var67;
            if(var2.readInt() != 0) {
               var67 = SnapshotMetadataChange.CREATOR.createFromParcel(var2);
            } else {
               var67 = null;
            }

            Contents var68;
            if(var2.readInt() != 0) {
               var68 = (Contents)Contents.CREATOR.createFromParcel(var2);
            } else {
               var68 = null;
            }

            this.a(var65, var66, var67, var68);
            var3.writeNoException();
            return true;
         case 12008:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.u(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 12009:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.f(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 12010:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var28 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            int[] var29 = var2.createIntArray();
            int var30 = var2.readInt();
            int var31 = var2.readInt();
            boolean var32 = false;
            if(var31 != 0) {
               var32 = true;
            }

            this.a(var28, var29, var30, var32);
            var3.writeNoException();
            return true;
         case 12011:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.d(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readLong());
            var3.writeNoException();
            return true;
         case 12012:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.u(var2.readLong());
            var3.writeNoException();
            return true;
         case 12013:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.d(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 12014:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.d(var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 12015:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var18 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var19 = var2.readString();
            String var20 = var2.readString();
            int[] var21 = var2.createIntArray();
            int var22 = var2.readInt();
            boolean var23;
            if(var2.readInt() != 0) {
               var23 = true;
            } else {
               var23 = false;
            }

            this.a(var18, var19, var20, var21, var22, var23);
            var3.writeNoException();
            return true;
         case 12016:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var36 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            int var37 = var2.readInt();
            boolean var38 = false;
            if(var37 != 0) {
               var38 = true;
            }

            this.f(var36, var38);
            var3.writeNoException();
            return true;
         case 12017:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.l(var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 12018:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var5 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var6 = var2.readString();
            String var7 = var2.readString();
            int var8 = var2.readInt();
            boolean var9;
            if(var2.readInt() != 0) {
               var9 = true;
            } else {
               var9 = false;
            }

            boolean var10;
            if(var2.readInt() != 0) {
               var10 = true;
            } else {
               var10 = false;
            }

            this.b(var5, var6, var7, var8, var9, var10);
            var3.writeNoException();
            return true;
         case 12019:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Contents var64;
            if(var2.readInt() != 0) {
               var64 = (Contents)Contents.CREATOR.createFromParcel(var2);
            } else {
               var64 = null;
            }

            this.a(var64);
            var3.writeNoException();
            return true;
         case 12020:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.r(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 12021:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var51 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var52 = var2.readString();
            int var53 = var2.readInt();
            boolean var54;
            if(var2.readInt() != 0) {
               var54 = true;
            } else {
               var54 = false;
            }

            boolean var55;
            if(var2.readInt() != 0) {
               var55 = true;
            } else {
               var55 = false;
            }

            this.e(var51, var52, var53, var54, var55);
            var3.writeNoException();
            return true;
         case 12022:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var46 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var47 = var2.readString();
            int var48 = var2.readInt();
            boolean var49;
            if(var2.readInt() != 0) {
               var49 = true;
            } else {
               var49 = false;
            }

            boolean var50;
            if(var2.readInt() != 0) {
               var50 = true;
            } else {
               var50 = false;
            }

            this.f(var46, var47, var48, var49, var50);
            var3.writeNoException();
            return true;
         case 12023:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 12024:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 12025:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            boolean var44 = this.hz();
            var3.writeNoException();
            byte var45 = 0;
            if(var44) {
               var45 = 1;
            }

            var3.writeInt(var45);
            return true;
         case 12026:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var42 = var2.readInt();
            boolean var43 = false;
            if(var42 != 0) {
               var43 = true;
            }

            this.F(var43);
            var3.writeNoException();
            return true;
         case 12027:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.t(IGamesCallbacks.Stub.method_2022(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 12028:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var13 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var14 = var2.readString();
            String var15 = var2.readString();
            String[] var16 = var2.createStringArray();
            boolean var17;
            if(var2.readInt() != 0) {
               var17 = true;
            } else {
               var17 = false;
            }

            this.a(var13, var14, var15, var16, var17);
            var3.writeNoException();
            return true;
         case 12029:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var24 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String[] var25 = var2.createStringArray();
            int var26 = var2.readInt();
            boolean var27 = false;
            if(var26 != 0) {
               var27 = true;
            }

            this.a(var24, var25, var27);
            var3.writeNoException();
            return true;
         case 12030:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var12 = this.a(var2.createIntArray());
            var3.writeNoException();
            if(var12 != null) {
               var3.writeInt(1);
               var12.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 12031:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var33 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            int var34 = var2.readInt();
            boolean var35 = false;
            if(var34 != 0) {
               var35 = true;
            }

            this.a(var33, var35, var2.createStringArray());
            var3.writeNoException();
            return true;
         case 12032:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var39 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            int var40 = var2.readInt();
            boolean var41 = false;
            if(var40 != 0) {
               var41 = true;
            }

            this.e(var39, var41);
            var3.writeNoException();
            return true;
         case 12033:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var58 = IGamesCallbacks.Stub.method_2022(var2.readStrongBinder());
            String var59 = var2.readString();
            String var60 = var2.readString();
            SnapshotMetadataChange var61;
            if(var2.readInt() != 0) {
               var61 = SnapshotMetadataChange.CREATOR.createFromParcel(var2);
            } else {
               var61 = null;
            }

            int var62 = var2.readInt();
            Contents var63 = null;
            if(var62 != 0) {
               var63 = (Contents)Contents.CREATOR.createFromParcel(var2);
            }

            this.a(var58, var59, var60, var61, var63);
            var3.writeNoException();
            return true;
         case 12034:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var11 = this.aU(var2.readString());
            var3.writeNoException();
            if(var11 != null) {
               var3.writeInt(1);
               var11.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 12035:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var57 = this.ho();
            var3.writeNoException();
            var3.writeInt(var57);
            return true;
         case 12036:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var56 = this.hp();
            var3.writeNoException();
            var3.writeInt(var56);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.games.internal.IGamesService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class Proxy implements IGamesService {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_4004;

      Proxy(IBinder var1) {
         this.field_4004 = var1;
      }

      // $FF: renamed from: E (boolean) void
      public void method_407(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: F (boolean) void
      public void method_408(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, byte[], java.lang.String, java.lang.String) int
      public int method_409(IGamesCallbacks param1, byte[] param2, String param3, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (int, int, boolean) android.content.Intent
      public Intent method_410(int param1, int param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (int, byte[], int, java.lang.String) android.content.Intent
      public Intent method_411(int var1, byte[] var2, int var3, String var4) throws RemoteException {
         Parcel var5 = Parcel.obtain();
         Parcel var6 = Parcel.obtain();
         boolean var11 = false;

         Intent var9;
         label36: {
            try {
               var11 = true;
               var5.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               var5.writeInt(var1);
               var5.writeByteArray(var2);
               var5.writeInt(var3);
               var5.writeString(var4);
               this.field_4004.transact(10012, var5, var6, 0);
               var6.readException();
               if(var6.readInt() != 0) {
                  var9 = (Intent)Intent.CREATOR.createFromParcel(var6);
                  var11 = false;
                  break label36;
               }

               var11 = false;
            } finally {
               if(var11) {
                  var6.recycle();
                  var5.recycle();
               }
            }

            var9 = null;
         }

         var6.recycle();
         var5.recycle();
         return var9;
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.multiplayer.ZInvitationCluster, java.lang.String, java.lang.String) android.content.Intent
      public Intent method_412(ZInvitationCluster param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.request.GameRequestCluster, java.lang.String) android.content.Intent
      public Intent method_413(GameRequestCluster param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomEntity, int) android.content.Intent
      public Intent method_414(RoomEntity param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, boolean, boolean, int) android.content.Intent
      public Intent method_415(String param1, boolean param2, boolean param3, int param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (int[]) android.content.Intent
      public Intent method_416(int[] var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var8 = false;

         Intent var6;
         label36: {
            try {
               var8 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               var2.writeIntArray(var1);
               this.field_4004.transact(12030, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var6 = (Intent)Intent.CREATOR.createFromParcel(var3);
                  var8 = false;
                  break label36;
               }

               var8 = false;
            } finally {
               if(var8) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var6 = null;
         }

         var3.recycle();
         var2.recycle();
         return var6;
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.ParticipantEntity[], java.lang.String, java.lang.String, android.net.Uri, android.net.Uri) android.content.Intent
      public Intent method_417(ParticipantEntity[] param1, String param2, String param3, Uri param4, Uri param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (long, java.lang.String) void
      public void method_418(long var1, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var4.writeLong(var1);
            var4.writeString(var3);
            this.field_4004.transact(8019, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      // $FF: renamed from: a (android.os.IBinder, android.os.Bundle) void
      public void method_419(IBinder param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.Contents) void
      public void method_420(Contents param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks) void
      public void method_421(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int) void
      public void method_422(IGamesCallbacks param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int, int) void
      public void method_423(IGamesCallbacks param1, int param2, int param3, int param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int, boolean, boolean) void
      public void method_424(IGamesCallbacks param1, int param2, int param3, boolean param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int, java.lang.String[], android.os.Bundle) void
      public void method_425(IGamesCallbacks param1, int param2, int param3, String[] param4, Bundle param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
      public void method_426(IGamesCallbacks param1, int param2, boolean param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int[]) void
      public void method_427(IGamesCallbacks param1, int param2, int[] param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, long) void
      public void method_428(IGamesCallbacks param1, long param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
      public void method_429(IGamesCallbacks param1, long param2, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, android.os.Bundle, int, int) void
      public void method_430(IGamesCallbacks param1, Bundle param2, int param3, int param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, android.os.IBinder, int, java.lang.String[], android.os.Bundle, boolean, long) void
      public void method_431(IGamesCallbacks param1, IBinder param2, int param3, String[] param4, Bundle param5, boolean param6, long param7) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, android.os.IBinder, java.lang.String, boolean, long) void
      public void method_432(IGamesCallbacks param1, IBinder param2, String param3, boolean param4, long param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_433(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int) void
      public void method_434(IGamesCallbacks param1, String param2, int param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, int, int, boolean) void
      public void method_435(IGamesCallbacks param1, String param2, int param3, int param4, int param5, boolean param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, android.os.IBinder, android.os.Bundle) void
      public void method_436(IGamesCallbacks param1, String param2, int param3, IBinder param4, Bundle param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean) void
      public void method_437(IGamesCallbacks param1, String param2, int param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
      public void method_438(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean, boolean, boolean) void
      public void method_439(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5, boolean param6, boolean param7) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, int[]) void
      public void method_440(IGamesCallbacks param1, String param2, int param3, int[] param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, long) void
      public void method_441(IGamesCallbacks param1, String param2, long param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, long, java.lang.String) void
      public void method_442(IGamesCallbacks param1, String param2, long param3, String param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, android.os.IBinder, android.os.Bundle) void
      public void method_443(IGamesCallbacks param1, String param2, IBinder param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, com.google.android.gms.games.snapshot.SnapshotMetadataChange, com.google.android.gms.drive.Contents) void
      public void method_444(IGamesCallbacks param1, String param2, SnapshotMetadataChange param3, Contents param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
      public void method_445(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int) void
      public void method_446(IGamesCallbacks param1, String param2, String param3, int param4, int param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int, int) void
      public void method_447(IGamesCallbacks param1, String param2, String param3, int param4, int param5, int param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int, int, boolean) void
      public void method_448(IGamesCallbacks param1, String param2, String param3, int param4, int param5, int param6, boolean param7) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, boolean, boolean) void
      public void method_449(IGamesCallbacks param1, String param2, String param3, int param4, boolean param5, boolean param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, com.google.android.gms.games.snapshot.SnapshotMetadataChange, com.google.android.gms.drive.Contents) void
      public void method_450(IGamesCallbacks param1, String param2, String param3, SnapshotMetadataChange param4, Contents param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, boolean) void
      public void method_451(IGamesCallbacks param1, String param2, String param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int[], int, boolean) void
      public void method_452(IGamesCallbacks param1, String param2, String param3, int[] param4, int param5, boolean param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, java.lang.String[]) void
      public void method_453(IGamesCallbacks param1, String param2, String param3, String[] param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, java.lang.String[], boolean) void
      public void method_454(IGamesCallbacks param1, String param2, String param3, String[] param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
      public void method_455(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, byte[], java.lang.String, com.google.android.gms.games.multiplayer.ParticipantResult[]) void
      public void method_456(IGamesCallbacks param1, String param2, byte[] param3, String param4, ParticipantResult[] param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, byte[], com.google.android.gms.games.multiplayer.ParticipantResult[]) void
      public void method_457(IGamesCallbacks param1, String param2, byte[] param3, ParticipantResult[] param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int[]) void
      public void method_458(IGamesCallbacks param1, String param2, int[] param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String[], int, byte[], int) void
      public void method_459(IGamesCallbacks param1, String param2, String[] param3, int param4, byte[] param5, int param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
      public void method_460(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, boolean, android.os.Bundle) void
      public void method_461(IGamesCallbacks param1, boolean param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, boolean, java.lang.String[]) void
      public void method_462(IGamesCallbacks param1, boolean param2, String[] param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int[]) void
      public void method_463(IGamesCallbacks param1, int[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int[], int, boolean) void
      public void method_464(IGamesCallbacks param1, int[] param2, int param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[]) void
      public void method_465(IGamesCallbacks param1, String[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[], boolean) void
      public void method_466(IGamesCallbacks param1, String[] param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: aR (java.lang.String) android.content.Intent
      public Intent method_467(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var8 = false;

         Intent var6;
         label36: {
            try {
               var8 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               var2.writeString(var1);
               this.field_4004.transact(9004, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var6 = (Intent)Intent.CREATOR.createFromParcel(var3);
                  var8 = false;
                  break label36;
               }

               var8 = false;
            } finally {
               if(var8) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var6 = null;
         }

         var3.recycle();
         var2.recycle();
         return var6;
      }

      // $FF: renamed from: aU (java.lang.String) android.content.Intent
      public Intent method_468(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var8 = false;

         Intent var6;
         label36: {
            try {
               var8 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               var2.writeString(var1);
               this.field_4004.transact(12034, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var6 = (Intent)Intent.CREATOR.createFromParcel(var3);
                  var8 = false;
                  break label36;
               }

               var8 = false;
            } finally {
               if(var8) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var6 = null;
         }

         var3.recycle();
         var2.recycle();
         return var6;
      }

      // $FF: renamed from: aV (java.lang.String) java.lang.String
      public String method_469(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         String var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var2.writeString(var1);
            this.field_4004.transact(5064, var2, var3, 0);
            var3.readException();
            var6 = var3.readString();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      // $FF: renamed from: aW (java.lang.String) java.lang.String
      public String method_470(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         String var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var2.writeString(var1);
            this.field_4004.transact(5035, var2, var3, 0);
            var3.readException();
            var6 = var3.readString();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      // $FF: renamed from: aX (java.lang.String) void
      public void method_471(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var2.writeString(var1);
            this.field_4004.transact(5050, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      // $FF: renamed from: aY (java.lang.String) int
      public int method_472(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var2.writeString(var1);
            this.field_4004.transact(5060, var2, var3, 0);
            var3.readException();
            var6 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      // $FF: renamed from: aZ (java.lang.String) android.net.Uri
      public Uri method_473(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var8 = false;

         Uri var6;
         label36: {
            try {
               var8 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               var2.writeString(var1);
               this.field_4004.transact(5066, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var6 = (Uri)Uri.CREATOR.createFromParcel(var3);
                  var8 = false;
                  break label36;
               }

               var8 = false;
            } finally {
               if(var8) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var6 = null;
         }

         var3.recycle();
         var2.recycle();
         return var6;
      }

      public IBinder asBinder() {
         return this.field_4004;
      }

      // $FF: renamed from: b (byte[], java.lang.String, java.lang.String[]) int
      public int method_474(byte[] var1, String var2, String[] var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         int var8;
         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var4.writeByteArray(var1);
            var4.writeString(var2);
            var4.writeStringArray(var3);
            this.field_4004.transact(5034, var4, var5, 0);
            var5.readException();
            var8 = var5.readInt();
         } finally {
            var5.recycle();
            var4.recycle();
         }

         return var8;
      }

      // $FF: renamed from: b (int, int, boolean) android.content.Intent
      public Intent method_475(int param1, int param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (long, java.lang.String) void
      public void method_476(long var1, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var4.writeLong(var1);
            var4.writeString(var3);
            this.field_4004.transact(8021, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks) void
      public void method_477(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
      public void method_478(IGamesCallbacks param1, int param2, boolean param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, long) void
      public void method_479(IGamesCallbacks param1, long param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
      public void method_480(IGamesCallbacks param1, long param2, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_481(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int) void
      public void method_482(IGamesCallbacks param1, String param2, int param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, int, int, boolean) void
      public void method_483(IGamesCallbacks param1, String param2, int param3, int param4, int param5, boolean param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, android.os.IBinder, android.os.Bundle) void
      public void method_484(IGamesCallbacks param1, String param2, int param3, IBinder param4, Bundle param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean) void
      public void method_485(IGamesCallbacks param1, String param2, int param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
      public void method_486(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, android.os.IBinder, android.os.Bundle) void
      public void method_487(IGamesCallbacks param1, String param2, IBinder param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
      public void method_488(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int, int, boolean) void
      public void method_489(IGamesCallbacks param1, String param2, String param3, int param4, int param5, int param6, boolean param7) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, boolean, boolean) void
      public void method_490(IGamesCallbacks param1, String param2, String param3, int param4, boolean param5, boolean param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, boolean) void
      public void method_491(IGamesCallbacks param1, String param2, String param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
      public void method_492(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
      public void method_493(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[]) void
      public void method_494(IGamesCallbacks param1, String[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (java.lang.String, java.lang.String, int) void
      public void method_495(String var1, String var2, int var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var4.writeString(var1);
            var4.writeString(var2);
            var4.writeInt(var3);
            this.field_4004.transact(5051, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      // $FF: renamed from: ba (java.lang.String) void
      public void method_496(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var2.writeString(var1);
            this.field_4004.transact(8002, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      // $FF: renamed from: bb (java.lang.String) android.os.ParcelFileDescriptor
      public ParcelFileDescriptor method_497(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var8 = false;

         ParcelFileDescriptor var6;
         label36: {
            try {
               var8 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               var2.writeString(var1);
               this.field_4004.transact(9030, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var6 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(var3);
                  var8 = false;
                  break label36;
               }

               var8 = false;
            } finally {
               if(var8) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var6 = null;
         }

         var3.recycle();
         var2.recycle();
         return var6;
      }

      // $FF: renamed from: c (long, java.lang.String) void
      public void method_498(long var1, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var4.writeLong(var1);
            var4.writeString(var3);
            this.field_4004.transact(10004, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks) void
      public void method_499(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
      public void method_500(IGamesCallbacks param1, int param2, boolean param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, long) void
      public void method_501(IGamesCallbacks param1, long param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
      public void method_502(IGamesCallbacks param1, long param2, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_503(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int) void
      public void method_504(IGamesCallbacks param1, String param2, int param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
      public void method_505(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
      public void method_506(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, boolean) void
      public void method_507(IGamesCallbacks param1, String param2, String param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
      public void method_508(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
      public void method_509(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[]) void
      public void method_510(IGamesCallbacks param1, String[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (java.lang.String, java.lang.String, int) void
      public void method_511(String var1, String var2, int var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var4.writeString(var1);
            var4.writeString(var2);
            var4.writeInt(var3);
            this.field_4004.transact(8026, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      // $FF: renamed from: ch (int) void
      public void method_512(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var2.writeInt(var1);
            this.field_4004.transact(5036, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      // $FF: renamed from: d (long, java.lang.String) void
      public void method_513(long var1, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var4.writeLong(var1);
            var4.writeString(var3);
            this.field_4004.transact(12014, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks) void
      public void method_514(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
      public void method_515(IGamesCallbacks param1, int param2, boolean param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, long) void
      public void method_516(IGamesCallbacks param1, long param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
      public void method_517(IGamesCallbacks param1, long param2, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_518(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
      public void method_519(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
      public void method_520(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
      public void method_521(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
      public void method_522(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks) void
      public void method_523(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
      public void method_524(IGamesCallbacks param1, int param2, boolean param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_525(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
      public void method_526(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
      public void method_527(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
      public void method_528(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
      public void method_529(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: ea () android.os.Bundle
      public Bundle method_530() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Bundle var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.field_4004.transact(5004, var1, var2, 0);
               var2.readException();
               if(var2.readInt() != 0) {
                  var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                  var7 = false;
                  break label36;
               }

               var7 = false;
            } finally {
               if(var7) {
                  var2.recycle();
                  var1.recycle();
               }
            }

            var5 = null;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks) void
      public void method_531(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_532(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
      public void method_533(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
      public void method_534(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
      public void method_535(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: g (android.net.Uri) android.os.ParcelFileDescriptor
      public ParcelFileDescriptor method_536(Uri param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: g (com.google.android.gms.games.internal.IGamesCallbacks) void
      public void method_537(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: g (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_538(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: gU () java.lang.String
      public String method_539() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4004.transact(5007, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: gV () java.lang.String
      public String method_540() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4004.transact(5012, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: gY () android.content.Intent
      public Intent method_541() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Intent var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.field_4004.transact(9003, var1, var2, 0);
               var2.readException();
               if(var2.readInt() != 0) {
                  var5 = (Intent)Intent.CREATOR.createFromParcel(var2);
                  var7 = false;
                  break label36;
               }

               var7 = false;
            } finally {
               if(var7) {
                  var2.recycle();
                  var1.recycle();
               }
            }

            var5 = null;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      // $FF: renamed from: gZ () android.content.Intent
      public Intent method_542() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Intent var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.field_4004.transact(9005, var1, var2, 0);
               var2.readException();
               if(var2.readInt() != 0) {
                  var5 = (Intent)Intent.CREATOR.createFromParcel(var2);
                  var7 = false;
                  break label36;
               }

               var7 = false;
            } finally {
               if(var7) {
                  var2.recycle();
                  var1.recycle();
               }
            }

            var5 = null;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      // $FF: renamed from: h (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) com.google.android.gms.games.multiplayer.realtime.RoomEntity
      public RoomEntity method_543(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: h (com.google.android.gms.games.internal.IGamesCallbacks) void
      public void method_544(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: ha () android.content.Intent
      public Intent method_545() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Intent var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.field_4004.transact(9006, var1, var2, 0);
               var2.readException();
               if(var2.readInt() != 0) {
                  var5 = (Intent)Intent.CREATOR.createFromParcel(var2);
                  var7 = false;
                  break label36;
               }

               var7 = false;
            } finally {
               if(var7) {
                  var2.recycle();
                  var1.recycle();
               }
            }

            var5 = null;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      // $FF: renamed from: hb () android.content.Intent
      public Intent method_546() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Intent var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.field_4004.transact(9007, var1, var2, 0);
               var2.readException();
               if(var2.readInt() != 0) {
                  var5 = (Intent)Intent.CREATOR.createFromParcel(var2);
                  var7 = false;
                  break label36;
               }

               var7 = false;
            } finally {
               if(var7) {
                  var2.recycle();
                  var1.recycle();
               }
            }

            var5 = null;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      // $FF: renamed from: hg () android.content.Intent
      public Intent method_547() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Intent var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.field_4004.transact(9010, var1, var2, 0);
               var2.readException();
               if(var2.readInt() != 0) {
                  var5 = (Intent)Intent.CREATOR.createFromParcel(var2);
                  var7 = false;
                  break label36;
               }

               var7 = false;
            } finally {
               if(var7) {
                  var2.recycle();
                  var1.recycle();
               }
            }

            var5 = null;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      // $FF: renamed from: hh () android.content.Intent
      public Intent method_548() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Intent var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.field_4004.transact(9012, var1, var2, 0);
               var2.readException();
               if(var2.readInt() != 0) {
                  var5 = (Intent)Intent.CREATOR.createFromParcel(var2);
                  var7 = false;
                  break label36;
               }

               var7 = false;
            } finally {
               if(var7) {
                  var2.recycle();
                  var1.recycle();
               }
            }

            var5 = null;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      // $FF: renamed from: hi () int
      public int method_549() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4004.transact(9019, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: hj () java.lang.String
      public String method_550() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4004.transact(5003, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: hk () int
      public int method_551() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4004.transact(8024, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: hl () android.content.Intent
      public Intent method_552() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Intent var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.field_4004.transact(10015, var1, var2, 0);
               var2.readException();
               if(var2.readInt() != 0) {
                  var5 = (Intent)Intent.CREATOR.createFromParcel(var2);
                  var7 = false;
                  break label36;
               }

               var7 = false;
            } finally {
               if(var7) {
                  var2.recycle();
                  var1.recycle();
               }
            }

            var5 = null;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      // $FF: renamed from: hm () int
      public int method_553() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4004.transact(10013, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: hn () int
      public int method_554() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4004.transact(10023, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: ho () int
      public int method_555() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4004.transact(12035, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: hp () int
      public int method_556() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4004.transact(12036, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: hr () void
      public void method_557() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4004.transact(5006, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      // $FF: renamed from: ht () com.google.android.gms.common.data.DataHolder
      public DataHolder method_558() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         DataHolder var5;
         label42: {
            DataHolder var6;
            label41: {
               try {
                  var8 = true;
                  var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                  this.field_4004.transact(5013, var1, var2, 0);
                  var2.readException();
                  if(var2.readInt() != 0) {
                     var6 = DataHolder.CREATOR.method_4283(var2);
                     var8 = false;
                     break label41;
                  }

                  var8 = false;
               } finally {
                  if(var8) {
                     var2.recycle();
                     var1.recycle();
                  }
               }

               var5 = null;
               break label42;
            }

            var5 = var6;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      // $FF: renamed from: hu () boolean
      public boolean method_559() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4004.transact(5067, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
            var8 = false;
         } finally {
            if(var8) {
               var2.recycle();
               var1.recycle();
            }
         }

         boolean var6 = false;
         if(var5 != 0) {
            var6 = true;
         }

         var2.recycle();
         var1.recycle();
         return var6;
      }

      // $FF: renamed from: hv () com.google.android.gms.common.data.DataHolder
      public DataHolder method_560() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         DataHolder var5;
         label42: {
            DataHolder var6;
            label41: {
               try {
                  var8 = true;
                  var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                  this.field_4004.transact(5502, var1, var2, 0);
                  var2.readException();
                  if(var2.readInt() != 0) {
                     var6 = DataHolder.CREATOR.method_4283(var2);
                     var8 = false;
                     break label41;
                  }

                  var8 = false;
               } finally {
                  if(var8) {
                     var2.recycle();
                     var1.recycle();
                  }
               }

               var5 = null;
               break label42;
            }

            var5 = var6;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      // $FF: renamed from: hw () void
      public void method_561() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4004.transact(8022, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      // $FF: renamed from: hx () android.content.Intent
      public Intent method_562() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Intent var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.field_4004.transact(9013, var1, var2, 0);
               var2.readException();
               if(var2.readInt() != 0) {
                  var5 = (Intent)Intent.CREATOR.createFromParcel(var2);
                  var7 = false;
                  break label36;
               }

               var7 = false;
            } finally {
               if(var7) {
                  var2.recycle();
                  var1.recycle();
               }
            }

            var5 = null;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      // $FF: renamed from: hy () void
      public void method_563() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4004.transact(11002, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      // $FF: renamed from: hz () boolean
      public boolean method_564() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4004.transact(12025, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
            var8 = false;
         } finally {
            if(var8) {
               var2.recycle();
               var1.recycle();
            }
         }

         boolean var6 = false;
         if(var5 != 0) {
            var6 = true;
         }

         var2.recycle();
         var1.recycle();
         return var6;
      }

      // $FF: renamed from: i (com.google.android.gms.games.internal.IGamesCallbacks) void
      public void method_565(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: i (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_566(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: j (com.google.android.gms.games.internal.IGamesCallbacks) void
      public void method_567(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: j (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_568(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: k (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_569(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: l (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_570(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: l (java.lang.String, int) void
      public void method_571(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.field_4004.transact(12017, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: m (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_572(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: m (java.lang.String, int) void
      public void method_573(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.field_4004.transact(5029, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: m (java.lang.String, java.lang.String) void
      public void method_574(String var1, String var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            var3.writeString(var2);
            this.field_4004.transact(5065, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: n (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_575(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: n (java.lang.String, int) void
      public void method_576(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.field_4004.transact(5028, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: n (java.lang.String, java.lang.String) void
      public void method_577(String var1, String var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            var3.writeString(var2);
            this.field_4004.transact(8025, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: o (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_578(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: p (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_579(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: p (java.lang.String, int) void
      public void method_580(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.field_4004.transact(5055, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: q (long) void
      public void method_581(long var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeLong(var1);
            this.field_4004.transact(5001, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: q (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_582(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: q (java.lang.String, int) void
      public void method_583(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.field_4004.transact(10014, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: r (long) void
      public void method_584(long var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeLong(var1);
            this.field_4004.transact(5059, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: r (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_585(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: s (long) void
      public void method_586(long var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeLong(var1);
            this.field_4004.transact(8013, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: s (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_587(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: t (long) void
      public void method_588(long var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeLong(var1);
            this.field_4004.transact(10002, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: t (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_589(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: u (long) void
      public void method_590(long var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeLong(var1);
            this.field_4004.transact(12012, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: u (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_591(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
