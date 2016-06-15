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
import com.google.android.gms.games.achievement.AchievementEntity;
import com.google.android.gms.games.internal.IGamesCallbacks;
import com.google.android.gms.games.internal.multiplayer.ZInvitationCluster;
import com.google.android.gms.games.internal.request.GameRequestCluster;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;

public interface IGamesService extends IInterface {
   // $FF: renamed from: O (boolean) void
   void method_447(boolean var1) throws RemoteException;

   // $FF: renamed from: P (boolean) void
   void method_448(boolean var1) throws RemoteException;

   // $FF: renamed from: Q (boolean) void
   void method_449(boolean var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, byte[], java.lang.String, java.lang.String) int
   int method_450(IGamesCallbacks var1, byte[] var2, String var3, String var4) throws RemoteException;

   // $FF: renamed from: a (int, int, boolean) android.content.Intent
   Intent method_451(int var1, int var2, boolean var3) throws RemoteException;

   // $FF: renamed from: a (int, byte[], int, java.lang.String) android.content.Intent
   Intent method_452(int var1, byte[] var2, int var3, String var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.achievement.AchievementEntity) android.content.Intent
   Intent method_453(AchievementEntity var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.multiplayer.ZInvitationCluster, java.lang.String, java.lang.String) android.content.Intent
   Intent method_454(ZInvitationCluster var1, String var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.request.GameRequestCluster, java.lang.String) android.content.Intent
   Intent method_455(GameRequestCluster var1, String var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomEntity, int) android.content.Intent
   Intent method_456(RoomEntity var1, int var2) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, boolean, boolean, int) android.content.Intent
   Intent method_457(String var1, boolean var2, boolean var3, int var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.ParticipantEntity[], java.lang.String, java.lang.String, android.net.Uri, android.net.Uri) android.content.Intent
   Intent method_458(ParticipantEntity[] var1, String var2, String var3, Uri var4, Uri var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.ParticipantEntity[], java.lang.String, java.lang.String, android.net.Uri, android.net.Uri, java.lang.String) android.content.Intent
   Intent method_459(ParticipantEntity[] var1, String var2, String var3, Uri var4, Uri var5, String var6) throws RemoteException;

   // $FF: renamed from: a (long, java.lang.String) void
   void method_460(long var1, String var3) throws RemoteException;

   // $FF: renamed from: a (android.os.IBinder, android.os.Bundle) void
   void method_461(IBinder var1, Bundle var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.Contents) void
   void method_462(Contents var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks) void
   void method_463(IGamesCallbacks var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int) void
   void method_464(IGamesCallbacks var1, int var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int, int) void
   void method_465(IGamesCallbacks var1, int var2, int var3, int var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int, boolean, boolean) void
   void method_466(IGamesCallbacks var1, int var2, int var3, boolean var4, boolean var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int, java.lang.String[], android.os.Bundle) void
   void method_467(IGamesCallbacks var1, int var2, int var3, String[] var4, Bundle var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, java.lang.String, java.lang.String[], boolean) void
   void method_468(IGamesCallbacks var1, int var2, String var3, String[] var4, boolean var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
   void method_469(IGamesCallbacks var1, int var2, boolean var3, boolean var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int[]) void
   void method_470(IGamesCallbacks var1, int var2, int[] var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, long) void
   void method_471(IGamesCallbacks var1, long var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
   void method_472(IGamesCallbacks var1, long var2, String var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, android.os.Bundle, int, int) void
   void method_473(IGamesCallbacks var1, Bundle var2, int var3, int var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, android.os.IBinder, int, java.lang.String[], android.os.Bundle, boolean, long) void
   void method_474(IGamesCallbacks var1, IBinder var2, int var3, String[] var4, Bundle var5, boolean var6, long var7) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, android.os.IBinder, java.lang.String, boolean, long) void
   void method_475(IGamesCallbacks var1, IBinder var2, String var3, boolean var4, long var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_476(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int) void
   void method_477(IGamesCallbacks var1, String var2, int var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, int, int, boolean) void
   void method_478(IGamesCallbacks var1, String var2, int var3, int var4, int var5, boolean var6) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, android.os.IBinder, android.os.Bundle) void
   void method_479(IGamesCallbacks var1, String var2, int var3, IBinder var4, Bundle var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean) void
   void method_480(IGamesCallbacks var1, String var2, int var3, boolean var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
   void method_481(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean, boolean, boolean) void
   void method_482(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5, boolean var6, boolean var7) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, int[]) void
   void method_483(IGamesCallbacks var1, String var2, int var3, int[] var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, long) void
   void method_484(IGamesCallbacks var1, String var2, long var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, long, java.lang.String) void
   void method_485(IGamesCallbacks var1, String var2, long var3, String var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, android.os.IBinder, android.os.Bundle) void
   void method_486(IGamesCallbacks var1, String var2, IBinder var3, Bundle var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity, com.google.android.gms.drive.Contents) void
   void method_487(IGamesCallbacks var1, String var2, SnapshotMetadataChangeEntity var3, Contents var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
   void method_488(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int) void
   void method_489(IGamesCallbacks var1, String var2, String var3, int var4, int var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int, int) void
   void method_490(IGamesCallbacks var1, String var2, String var3, int var4, int var5, int var6) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int, int, boolean) void
   void method_491(IGamesCallbacks var1, String var2, String var3, int var4, int var5, int var6, boolean var7) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, boolean, boolean) void
   void method_492(IGamesCallbacks var1, String var2, String var3, int var4, boolean var5, boolean var6) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity, com.google.android.gms.drive.Contents) void
   void method_493(IGamesCallbacks var1, String var2, String var3, SnapshotMetadataChangeEntity var4, Contents var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, boolean) void
   void method_494(IGamesCallbacks var1, String var2, String var3, boolean var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int[], int, boolean) void
   void method_495(IGamesCallbacks var1, String var2, String var3, int[] var4, int var5, boolean var6) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, java.lang.String[]) void
   void method_496(IGamesCallbacks var1, String var2, String var3, String[] var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, java.lang.String[], boolean) void
   void method_497(IGamesCallbacks var1, String var2, String var3, String[] var4, boolean var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
   void method_498(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, byte[], java.lang.String, com.google.android.gms.games.multiplayer.ParticipantResult[]) void
   void method_499(IGamesCallbacks var1, String var2, byte[] var3, String var4, ParticipantResult[] var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, byte[], com.google.android.gms.games.multiplayer.ParticipantResult[]) void
   void method_500(IGamesCallbacks var1, String var2, byte[] var3, ParticipantResult[] var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int[]) void
   void method_501(IGamesCallbacks var1, String var2, int[] var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String[], int, byte[], int) void
   void method_502(IGamesCallbacks var1, String var2, String[] var3, int var4, byte[] var5, int var6) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
   void method_503(IGamesCallbacks var1, boolean var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, boolean, android.os.Bundle) void
   void method_504(IGamesCallbacks var1, boolean var2, Bundle var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, boolean, java.lang.String[]) void
   void method_505(IGamesCallbacks var1, boolean var2, String[] var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int[]) void
   void method_506(IGamesCallbacks var1, int[] var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int[], int, boolean) void
   void method_507(IGamesCallbacks var1, int[] var2, int var3, boolean var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[]) void
   void method_508(IGamesCallbacks var1, String[] var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[], boolean) void
   void method_509(IGamesCallbacks var1, String[] var2, boolean var3) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, android.os.IBinder, android.os.Bundle) void
   void method_510(String var1, IBinder var2, Bundle var3) throws RemoteException;

   // $FF: renamed from: b (byte[], java.lang.String, java.lang.String[]) int
   int method_511(byte[] var1, String var2, String[] var3) throws RemoteException;

   // $FF: renamed from: b (int, int, boolean) android.content.Intent
   Intent method_512(int var1, int var2, boolean var3) throws RemoteException;

   // $FF: renamed from: b (int[]) android.content.Intent
   Intent method_513(int[] var1) throws RemoteException;

   // $FF: renamed from: b (long, java.lang.String) void
   void method_514(long var1, String var3) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks) void
   void method_515(IGamesCallbacks var1) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
   void method_516(IGamesCallbacks var1, int var2, boolean var3, boolean var4) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, long) void
   void method_517(IGamesCallbacks var1, long var2) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
   void method_518(IGamesCallbacks var1, long var2, String var4) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_519(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int) void
   void method_520(IGamesCallbacks var1, String var2, int var3) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, int, int, boolean) void
   void method_521(IGamesCallbacks var1, String var2, int var3, int var4, int var5, boolean var6) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, android.os.IBinder, android.os.Bundle) void
   void method_522(IGamesCallbacks var1, String var2, int var3, IBinder var4, Bundle var5) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean) void
   void method_523(IGamesCallbacks var1, String var2, int var3, boolean var4) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
   void method_524(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, android.os.IBinder, android.os.Bundle) void
   void method_525(IGamesCallbacks var1, String var2, IBinder var3, Bundle var4) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
   void method_526(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int, int, boolean) void
   void method_527(IGamesCallbacks var1, String var2, String var3, int var4, int var5, int var6, boolean var7) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, boolean, boolean) void
   void method_528(IGamesCallbacks var1, String var2, String var3, int var4, boolean var5, boolean var6) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, boolean) void
   void method_529(IGamesCallbacks var1, String var2, String var3, boolean var4) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
   void method_530(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
   void method_531(IGamesCallbacks var1, boolean var2) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[]) void
   void method_532(IGamesCallbacks var1, String[] var2) throws RemoteException;

   // $FF: renamed from: b (java.lang.String, java.lang.String, int) void
   void method_533(String var1, String var2, int var3) throws RemoteException;

   // $FF: renamed from: bE (java.lang.String) android.content.Intent
   Intent method_534(String var1) throws RemoteException;

   // $FF: renamed from: bG (java.lang.String) java.lang.String
   String method_535(String var1) throws RemoteException;

   // $FF: renamed from: bH (java.lang.String) java.lang.String
   String method_536(String var1) throws RemoteException;

   // $FF: renamed from: bI (java.lang.String) void
   void method_537(String var1) throws RemoteException;

   // $FF: renamed from: bJ (java.lang.String) int
   int method_538(String var1) throws RemoteException;

   // $FF: renamed from: bK (java.lang.String) android.net.Uri
   Uri method_539(String var1) throws RemoteException;

   // $FF: renamed from: bL (java.lang.String) void
   void method_540(String var1) throws RemoteException;

   // $FF: renamed from: bM (java.lang.String) android.content.Intent
   Intent method_541(String var1) throws RemoteException;

   // $FF: renamed from: bN (java.lang.String) android.os.ParcelFileDescriptor
   ParcelFileDescriptor method_542(String var1) throws RemoteException;

   // $FF: renamed from: c (long, java.lang.String) void
   void method_543(long var1, String var3) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks) void
   void method_544(IGamesCallbacks var1) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
   void method_545(IGamesCallbacks var1, int var2, boolean var3, boolean var4) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, long) void
   void method_546(IGamesCallbacks var1, long var2) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
   void method_547(IGamesCallbacks var1, long var2, String var4) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_548(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int) void
   void method_549(IGamesCallbacks var1, String var2, int var3) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
   void method_550(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
   void method_551(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, boolean) void
   void method_552(IGamesCallbacks var1, String var2, String var3, boolean var4) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
   void method_553(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
   void method_554(IGamesCallbacks var1, boolean var2) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[]) void
   void method_555(IGamesCallbacks var1, String[] var2) throws RemoteException;

   // $FF: renamed from: c (java.lang.String, java.lang.String, int) void
   void method_556(String var1, String var2, int var3) throws RemoteException;

   // $FF: renamed from: d (long, java.lang.String) void
   void method_557(long var1, String var3) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks) void
   void method_558(IGamesCallbacks var1) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
   void method_559(IGamesCallbacks var1, int var2, boolean var3, boolean var4) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, long) void
   void method_560(IGamesCallbacks var1, long var2) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
   void method_561(IGamesCallbacks var1, long var2, String var4) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_562(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
   void method_563(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
   void method_564(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
   void method_565(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
   void method_566(IGamesCallbacks var1, boolean var2) throws RemoteException;

   // $FF: renamed from: dT (int) void
   void method_567(int var1) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks) void
   void method_568(IGamesCallbacks var1) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
   void method_569(IGamesCallbacks var1, int var2, boolean var3, boolean var4) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_570(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
   void method_571(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
   void method_572(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
   void method_573(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
   void method_574(IGamesCallbacks var1, boolean var2) throws RemoteException;

   // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks) void
   void method_575(IGamesCallbacks var1) throws RemoteException;

   // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_576(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
   void method_577(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

   // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
   void method_578(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

   // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
   void method_579(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

   // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
   void method_580(IGamesCallbacks var1, boolean var2) throws RemoteException;

   // $FF: renamed from: fX () android.os.Bundle
   Bundle method_581() throws RemoteException;

   // $FF: renamed from: g (com.google.android.gms.games.internal.IGamesCallbacks) void
   void method_582(IGamesCallbacks var1) throws RemoteException;

   // $FF: renamed from: g (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_583(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: g (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
   void method_584(IGamesCallbacks var1, boolean var2) throws RemoteException;

   // $FF: renamed from: h (android.net.Uri) android.os.ParcelFileDescriptor
   ParcelFileDescriptor method_585(Uri var1) throws RemoteException;

   // $FF: renamed from: h (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) com.google.android.gms.games.multiplayer.realtime.RoomEntity
   RoomEntity method_586(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: h (com.google.android.gms.games.internal.IGamesCallbacks) void
   void method_587(IGamesCallbacks var1) throws RemoteException;

   // $FF: renamed from: h (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
   void method_588(IGamesCallbacks var1, boolean var2) throws RemoteException;

   // $FF: renamed from: i (com.google.android.gms.games.internal.IGamesCallbacks) void
   void method_589(IGamesCallbacks var1) throws RemoteException;

   // $FF: renamed from: i (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_590(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: j (com.google.android.gms.games.internal.IGamesCallbacks) void
   void method_591(IGamesCallbacks var1) throws RemoteException;

   // $FF: renamed from: j (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_592(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: k (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_593(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: l (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_594(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: lA () int
   int method_595() throws RemoteException;

   // $FF: renamed from: lB () int
   int method_596() throws RemoteException;

   // $FF: renamed from: lC () int
   int method_597() throws RemoteException;

   // $FF: renamed from: lE () void
   void method_598() throws RemoteException;

   // $FF: renamed from: lG () com.google.android.gms.common.data.DataHolder
   DataHolder method_599() throws RemoteException;

   // $FF: renamed from: lH () boolean
   boolean method_600() throws RemoteException;

   // $FF: renamed from: lI () com.google.android.gms.common.data.DataHolder
   DataHolder method_601() throws RemoteException;

   // $FF: renamed from: lJ () void
   void method_602() throws RemoteException;

   // $FF: renamed from: lK () android.content.Intent
   Intent method_603() throws RemoteException;

   // $FF: renamed from: lL () void
   void method_604() throws RemoteException;

   // $FF: renamed from: lM () boolean
   boolean method_605() throws RemoteException;

   // $FF: renamed from: lh () java.lang.String
   String method_606() throws RemoteException;

   // $FF: renamed from: li () java.lang.String
   String method_607() throws RemoteException;

   // $FF: renamed from: ll () android.content.Intent
   Intent method_608() throws RemoteException;

   // $FF: renamed from: lm () android.content.Intent
   Intent method_609() throws RemoteException;

   // $FF: renamed from: ln () android.content.Intent
   Intent method_610() throws RemoteException;

   // $FF: renamed from: lo () android.content.Intent
   Intent method_611() throws RemoteException;

   // $FF: renamed from: lt () android.content.Intent
   Intent method_612() throws RemoteException;

   // $FF: renamed from: lu () android.content.Intent
   Intent method_613() throws RemoteException;

   // $FF: renamed from: lv () int
   int method_614() throws RemoteException;

   // $FF: renamed from: lw () java.lang.String
   String method_615() throws RemoteException;

   // $FF: renamed from: lx () int
   int method_616() throws RemoteException;

   // $FF: renamed from: ly () android.content.Intent
   Intent method_617() throws RemoteException;

   // $FF: renamed from: lz () int
   int method_618() throws RemoteException;

   // $FF: renamed from: m (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_619(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: n (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_620(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: o (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_621(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: o (java.lang.String, int) void
   void method_622(String var1, int var2) throws RemoteException;

   // $FF: renamed from: p (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_623(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: p (java.lang.String, int) void
   void method_624(String var1, int var2) throws RemoteException;

   // $FF: renamed from: q (long) void
   void method_625(long var1) throws RemoteException;

   // $FF: renamed from: q (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_626(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: q (java.lang.String, int) void
   void method_627(String var1, int var2) throws RemoteException;

   // $FF: renamed from: r (long) void
   void method_628(long var1) throws RemoteException;

   // $FF: renamed from: r (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_629(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: s (long) void
   void method_630(long var1) throws RemoteException;

   // $FF: renamed from: s (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_631(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: s (java.lang.String, int) void
   void method_632(String var1, int var2) throws RemoteException;

   // $FF: renamed from: t (long) void
   void method_633(long var1) throws RemoteException;

   // $FF: renamed from: t (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_634(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: t (java.lang.String, int) void
   void method_635(String var1, int var2) throws RemoteException;

   // $FF: renamed from: t (java.lang.String, java.lang.String) void
   void method_636(String var1, String var2) throws RemoteException;

   // $FF: renamed from: u (java.lang.String, int) android.content.Intent
   Intent method_637(String var1, int var2) throws RemoteException;

   // $FF: renamed from: u (long) void
   void method_638(long var1) throws RemoteException;

   // $FF: renamed from: u (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
   void method_639(IGamesCallbacks var1, String var2) throws RemoteException;

   // $FF: renamed from: u (java.lang.String, java.lang.String) void
   void method_640(String var1, String var2) throws RemoteException;

   public abstract static class Stub extends Binder implements IGamesService {
      public Stub() {
         this.attachInterface(this, "com.google.android.gms.games.internal.IGamesService");
      }

      // $FF: renamed from: aE (android.os.IBinder) com.google.android.gms.games.internal.IGamesService
      public static IGamesService method_5052(IBinder var0) {
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
            this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            String var349 = this.lw();
            var3.writeNoException();
            var3.writeString(var349);
            return true;
         case 5004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Bundle var348 = this.fX();
            var3.writeNoException();
            if(var348 != null) {
               var3.writeInt(1);
               var348.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 5005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IBinder var346 = var2.readStrongBinder();
            Bundle var347;
            if(var2.readInt() != 0) {
               var347 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var347 = null;
            }

            this.a(var346, var347);
            var3.writeNoException();
            return true;
         case 5006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.lE();
            var3.writeNoException();
            return true;
         case 5007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            String var345 = this.lh();
            var3.writeNoException();
            var3.writeString(var345);
            return true;
         case 5012:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            String var343 = this.li();
            var3.writeNoException();
            var3.writeString(var343);
            return true;
         case 5013:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            DataHolder var342 = this.lG();
            var3.writeNoException();
            if(var342 != null) {
               var3.writeInt(1);
               var342.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 5014:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5015:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var337 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            int var338 = var2.readInt();
            boolean var339;
            if(var2.readInt() != 0) {
               var339 = true;
            } else {
               var339 = false;
            }

            int var340 = var2.readInt();
            boolean var341 = false;
            if(var340 != 0) {
               var341 = true;
            }

            this.a(var337, var338, var339, var341);
            var3.writeNoException();
            return true;
         case 5016:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString(), var2.readLong());
            var3.writeNoException();
            return true;
         case 5017:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5018:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5019:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var331 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var332 = var2.readString();
            int var333 = var2.readInt();
            int var334 = var2.readInt();
            int var335 = var2.readInt();
            boolean var336;
            if(var2.readInt() != 0) {
               var336 = true;
            } else {
               var336 = false;
            }

            this.a(var331, var332, var333, var334, var335, var336);
            var3.writeNoException();
            return true;
         case 5020:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var325 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var326 = var2.readString();
            int var327 = var2.readInt();
            int var328 = var2.readInt();
            int var329 = var2.readInt();
            boolean var330;
            if(var2.readInt() != 0) {
               var330 = true;
            } else {
               var330 = false;
            }

            this.b(var325, var326, var327, var328, var329, var330);
            var3.writeNoException();
            return true;
         case 5021:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var323 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            Bundle var324;
            if(var2.readInt() != 0) {
               var324 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var324 = null;
            }

            this.a(var323, var324, var2.readInt(), var2.readInt());
            var3.writeNoException();
            return true;
         case 5022:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5023:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var319 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var320 = var2.readString();
            IBinder var321 = var2.readStrongBinder();
            Bundle var322;
            if(var2.readInt() != 0) {
               var322 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var322 = null;
            }

            this.a(var319, var320, var321, var322);
            var3.writeNoException();
            return true;
         case 5024:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var315 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var316 = var2.readString();
            IBinder var317 = var2.readStrongBinder();
            Bundle var318;
            if(var2.readInt() != 0) {
               var318 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var318 = null;
            }

            this.b(var315, var316, var317, var318);
            var3.writeNoException();
            return true;
         case 5025:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var310 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var311 = var2.readString();
            int var312 = var2.readInt();
            IBinder var313 = var2.readStrongBinder();
            Bundle var314;
            if(var2.readInt() != 0) {
               var314 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var314 = null;
            }

            this.a(var310, var311, var312, var313, var314);
            var3.writeNoException();
            return true;
         case 5026:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.d(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5027:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.e(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5028:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.q(var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 5029:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.p(var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 5030:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var302 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            IBinder var303 = var2.readStrongBinder();
            int var304 = var2.readInt();
            String[] var305 = var2.createStringArray();
            int var306 = var2.readInt();
            Bundle var307 = null;
            if(var306 != 0) {
               var307 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            int var308 = var2.readInt();
            boolean var309 = false;
            if(var308 != 0) {
               var309 = true;
            }

            this.a(var302, var303, var304, var305, var307, var309, var2.readLong());
            var3.writeNoException();
            return true;
         case 5031:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var298 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            IBinder var299 = var2.readStrongBinder();
            String var300 = var2.readString();
            boolean var301;
            if(var2.readInt() != 0) {
               var301 = true;
            } else {
               var301 = false;
            }

            this.a(var298, var299, var300, var301, var2.readLong());
            var3.writeNoException();
            return true;
         case 5032:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5033:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var297 = this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.createByteArray(), var2.readString(), var2.readString());
            var3.writeNoException();
            var3.writeInt(var297);
            return true;
         case 5034:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var296 = this.b(var2.createByteArray(), var2.readString(), var2.createStringArray());
            var3.writeNoException();
            var3.writeInt(var296);
            return true;
         case 5035:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            String var295 = this.bH(var2.readString());
            var3.writeNoException();
            var3.writeString(var295);
            return true;
         case 5036:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.dT(var2.readInt());
            var3.writeNoException();
            return true;
         case 5037:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.d(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5038:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 5039:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var287 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var288 = var2.readString();
            String var289 = var2.readString();
            int var290 = var2.readInt();
            int var291 = var2.readInt();
            int var292 = var2.readInt();
            int var293 = var2.readInt();
            boolean var294 = false;
            if(var293 != 0) {
               var294 = true;
            }

            this.a(var287, var288, var289, var290, var291, var292, var294);
            var3.writeNoException();
            return true;
         case 5040:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var279 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var280 = var2.readString();
            String var281 = var2.readString();
            int var282 = var2.readInt();
            int var283 = var2.readInt();
            int var284 = var2.readInt();
            int var285 = var2.readInt();
            boolean var286 = false;
            if(var285 != 0) {
               var286 = true;
            }

            this.b(var279, var280, var281, var282, var283, var284, var286);
            var3.writeNoException();
            return true;
         case 5041:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 5042:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.e(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5043:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.f(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5044:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var274 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            int var275 = var2.readInt();
            int var276 = var2.readInt();
            boolean var277;
            if(var2.readInt() != 0) {
               var277 = true;
            } else {
               var277 = false;
            }

            boolean var278;
            if(var2.readInt() != 0) {
               var278 = true;
            } else {
               var278 = false;
            }

            this.a(var274, var275, var276, var277, var278);
            var3.writeNoException();
            return true;
         case 5045:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var269 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var270 = var2.readString();
            int var271 = var2.readInt();
            boolean var272;
            if(var2.readInt() != 0) {
               var272 = true;
            } else {
               var272 = false;
            }

            boolean var273;
            if(var2.readInt() != 0) {
               var273 = true;
            } else {
               var273 = false;
            }

            this.a(var269, var270, var271, var272, var273);
            var3.writeNoException();
            return true;
         case 5046:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var264 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            int var265 = var2.readInt();
            boolean var266;
            if(var2.readInt() != 0) {
               var266 = true;
            } else {
               var266 = false;
            }

            int var267 = var2.readInt();
            boolean var268 = false;
            if(var267 != 0) {
               var268 = true;
            }

            this.b(var264, var265, var266, var268);
            var3.writeNoException();
            return true;
         case 5047:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.f(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5048:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var259 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            int var260 = var2.readInt();
            boolean var261;
            if(var2.readInt() != 0) {
               var261 = true;
            } else {
               var261 = false;
            }

            int var262 = var2.readInt();
            boolean var263 = false;
            if(var262 != 0) {
               var263 = true;
            }

            this.c(var259, var260, var261, var263);
            var3.writeNoException();
            return true;
         case 5049:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.g(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5050:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.bI(var2.readString());
            var3.writeNoException();
            return true;
         case 5051:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(var2.readString(), var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 5052:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.g(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5053:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            RoomEntity var258 = this.h(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            if(var258 != null) {
               var3.writeInt(1);
               var258.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 5054:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var253 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var254 = var2.readString();
            int var255 = var2.readInt();
            boolean var256 = false;
            if(var255 != 0) {
               var256 = true;
            }

            this.a(var253, var254, var256);
            var3.writeNoException();
            return true;
         case 5055:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.s(var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 5056:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.h(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5057:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.j(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5058:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readLong());
            var3.writeNoException();
            return true;
         case 5059:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.r(var2.readLong());
            var3.writeNoException();
            return true;
         case 5060:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var257 = this.bJ(var2.readString());
            var3.writeNoException();
            var3.writeInt(var257);
            return true;
         case 5061:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.i(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5062:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.i(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5063:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var245 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            int var246 = var2.readInt();
            boolean var247 = false;
            if(var246 != 0) {
               var247 = true;
            }

            Bundle var248;
            if(var2.readInt() != 0) {
               var248 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var248 = null;
            }

            this.a(var245, var247, var248);
            var3.writeNoException();
            return true;
         case 5064:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            String var344 = this.bG(var2.readString());
            var3.writeNoException();
            var3.writeString(var344);
            return true;
         case 5065:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.t(var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 5066:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Uri var244 = this.bK(var2.readString());
            var3.writeNoException();
            if(var244 != null) {
               var3.writeInt(1);
               var244.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 5067:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            boolean var251 = this.lH();
            var3.writeNoException();
            byte var252 = 0;
            if(var251) {
               var252 = 1;
            }

            var3.writeInt(var252);
            return true;
         case 5068:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var249 = var2.readInt();
            boolean var250 = false;
            if(var249 != 0) {
               var250 = true;
            }

            this.O(var250);
            var3.writeNoException();
            return true;
         case 5501:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var239 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var240 = var2.readString();
            int var241 = var2.readInt();
            boolean var242;
            if(var2.readInt() != 0) {
               var242 = true;
            } else {
               var242 = false;
            }

            boolean var243;
            if(var2.readInt() != 0) {
               var243 = true;
            } else {
               var243 = false;
            }

            this.b(var239, var240, var241, var242, var243);
            var3.writeNoException();
            return true;
         case 5502:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            DataHolder var238 = this.lI();
            var3.writeNoException();
            if(var238 != null) {
               var3.writeInt(1);
               var238.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 6001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var235 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            int var236 = var2.readInt();
            boolean var237 = false;
            if(var236 != 0) {
               var237 = true;
            }

            this.a(var235, var237);
            var3.writeNoException();
            return true;
         case 6002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var230 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var231 = var2.readString();
            String var232 = var2.readString();
            int var233 = var2.readInt();
            boolean var234 = false;
            if(var233 != 0) {
               var234 = true;
            }

            this.a(var230, var231, var232, var234);
            var3.writeNoException();
            return true;
         case 6003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var225 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            int var226 = var2.readInt();
            boolean var227;
            if(var2.readInt() != 0) {
               var227 = true;
            } else {
               var227 = false;
            }

            int var228 = var2.readInt();
            boolean var229 = false;
            if(var228 != 0) {
               var229 = true;
            }

            this.d(var225, var226, var227, var229);
            var3.writeNoException();
            return true;
         case 6004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var220 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            int var221 = var2.readInt();
            boolean var222;
            if(var2.readInt() != 0) {
               var222 = true;
            } else {
               var222 = false;
            }

            int var223 = var2.readInt();
            boolean var224 = false;
            if(var223 != 0) {
               var224 = true;
            }

            this.e(var220, var221, var222, var224);
            var3.writeNoException();
            return true;
         case 6501:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var212 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var213 = var2.readString();
            int var214 = var2.readInt();
            boolean var215;
            if(var2.readInt() != 0) {
               var215 = true;
            } else {
               var215 = false;
            }

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

            int var218 = var2.readInt();
            boolean var219 = false;
            if(var218 != 0) {
               var219 = true;
            }

            this.a(var212, var213, var214, var215, var216, var217, var219);
            var3.writeNoException();
            return true;
         case 6502:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var208 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var209 = var2.readString();
            int var210 = var2.readInt();
            boolean var211 = false;
            if(var210 != 0) {
               var211 = true;
            }

            this.b(var208, var209, var211);
            var3.writeNoException();
            return true;
         case 6503:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var205 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            int var206 = var2.readInt();
            boolean var207 = false;
            if(var206 != 0) {
               var207 = true;
            }

            this.b(var205, var207);
            var3.writeNoException();
            return true;
         case 6504:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var201 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var202 = var2.readString();
            int var203 = var2.readInt();
            boolean var204 = false;
            if(var203 != 0) {
               var204 = true;
            }

            this.c(var201, var202, var204);
            var3.writeNoException();
            return true;
         case 6505:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var197 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var198 = var2.readString();
            int var199 = var2.readInt();
            boolean var200 = false;
            if(var199 != 0) {
               var200 = true;
            }

            this.d(var197, var198, var200);
            var3.writeNoException();
            return true;
         case 6506:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var192 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var193 = var2.readString();
            String var194 = var2.readString();
            int var195 = var2.readInt();
            boolean var196 = false;
            if(var195 != 0) {
               var196 = true;
            }

            this.b(var192, var193, var194, var196);
            var3.writeNoException();
            return true;
         case 6507:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Uri var190;
            if(var2.readInt() != 0) {
               var190 = (Uri)Uri.CREATOR.createFromParcel(var2);
            } else {
               var190 = null;
            }

            ParcelFileDescriptor var191 = this.h(var190);
            var3.writeNoException();
            if(var191 != null) {
               var3.writeInt(1);
               var191.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 7001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.k(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 7002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString(), var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 7003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var185 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var186 = var2.readString();
            int var187 = var2.readInt();
            IBinder var188 = var2.readStrongBinder();
            Bundle var189;
            if(var2.readInt() != 0) {
               var189 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var189 = null;
            }

            this.b(var185, var186, var187, var188, var189);
            var3.writeNoException();
            return true;
         case 8001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.readInt(), var2.readInt());
            var3.writeNoException();
            return true;
         case 8002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.bL(var2.readString());
            var3.writeNoException();
            return true;
         case 8003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.createIntArray());
            var3.writeNoException();
            return true;
         case 8004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var180 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            int var181 = var2.readInt();
            int var182 = var2.readInt();
            String[] var183 = var2.createStringArray();
            Bundle var184;
            if(var2.readInt() != 0) {
               var184 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var184 = null;
            }

            this.a(var180, var181, var182, var183, var184);
            var3.writeNoException();
            return true;
         case 8005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.l(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 8006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.m(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 8007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString(), var2.createByteArray(), var2.readString(), (ParticipantResult[])var2.createTypedArray(ParticipantResult.CREATOR));
            var3.writeNoException();
            return true;
         case 8008:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString(), var2.createByteArray(), (ParticipantResult[])var2.createTypedArray(ParticipantResult.CREATOR));
            var3.writeNoException();
            return true;
         case 8009:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.n(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 8010:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.o(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 8011:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 8012:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readLong());
            var3.writeNoException();
            return true;
         case 8013:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.s(var2.readLong());
            var3.writeNoException();
            return true;
         case 8014:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.p(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 8015:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.d(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 8016:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.e(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 8017:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString(), var2.createIntArray());
            var3.writeNoException();
            return true;
         case 8018:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 8019:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 8020:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 8021:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 8022:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.lJ();
            var3.writeNoException();
            return true;
         case 8023:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var174 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var175 = var2.readString();
            int var176 = var2.readInt();
            int var177 = var2.readInt();
            boolean var178 = false;
            if(var177 != 0) {
               var178 = true;
            }

            this.a(var174, var175, var176, var178);
            var3.writeNoException();
            return true;
         case 8024:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var179 = this.lx();
            var3.writeNoException();
            var3.writeInt(var179);
            return true;
         case 8025:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.u(var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 8026:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(var2.readString(), var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 8027:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var171 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            int var172 = var2.readInt();
            boolean var173 = false;
            if(var172 != 0) {
               var173 = true;
            }

            this.c(var171, var173);
            var3.writeNoException();
            return true;
         case 9001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var166 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var167 = var2.readString();
            int var168 = var2.readInt();
            boolean var169;
            if(var2.readInt() != 0) {
               var169 = true;
            } else {
               var169 = false;
            }

            boolean var170;
            if(var2.readInt() != 0) {
               var170 = true;
            } else {
               var170 = false;
            }

            this.c(var166, var167, var168, var169, var170);
            var3.writeNoException();
            return true;
         case 9002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.q(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 9003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var165 = this.ll();
            var3.writeNoException();
            if(var165 != null) {
               var3.writeInt(1);
               var165.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var164 = this.bM(var2.readString());
            var3.writeNoException();
            if(var164 != null) {
               var3.writeInt(1);
               var164.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var163 = this.lm();
            var3.writeNoException();
            if(var163 != null) {
               var3.writeInt(1);
               var163.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var162 = this.ln();
            var3.writeNoException();
            if(var162 != null) {
               var3.writeInt(1);
               var162.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var161 = this.lo();
            var3.writeNoException();
            if(var161 != null) {
               var3.writeInt(1);
               var161.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9008:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var157 = var2.readInt();
            int var158 = var2.readInt();
            boolean var159;
            if(var2.readInt() != 0) {
               var159 = true;
            } else {
               var159 = false;
            }

            Intent var160 = this.a(var157, var158, var159);
            var3.writeNoException();
            if(var160 != null) {
               var3.writeInt(1);
               var160.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9009:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var153 = var2.readInt();
            int var154 = var2.readInt();
            boolean var155;
            if(var2.readInt() != 0) {
               var155 = true;
            } else {
               var155 = false;
            }

            Intent var156 = this.b(var153, var154, var155);
            var3.writeNoException();
            if(var156 != null) {
               var3.writeInt(1);
               var156.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9010:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var152 = this.lt();
            var3.writeNoException();
            if(var152 != null) {
               var3.writeInt(1);
               var152.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9011:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            RoomEntity var150;
            if(var2.readInt() != 0) {
               var150 = (RoomEntity)RoomEntity.CREATOR.createFromParcel(var2);
            } else {
               var150 = null;
            }

            Intent var151 = this.a(var150, var2.readInt());
            var3.writeNoException();
            if(var151 != null) {
               var3.writeInt(1);
               var151.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9012:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var149 = this.lu();
            var3.writeNoException();
            if(var149 != null) {
               var3.writeInt(1);
               var149.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9013:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var148 = this.lK();
            var3.writeNoException();
            if(var148 != null) {
               var3.writeInt(1);
               var148.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9019:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var141 = this.lv();
            var3.writeNoException();
            var3.writeInt(var141);
            return true;
         case 9020:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var136 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var137 = var2.readString();
            int var138 = var2.readInt();
            boolean var139;
            if(var2.readInt() != 0) {
               var139 = true;
            } else {
               var139 = false;
            }

            boolean var140;
            if(var2.readInt() != 0) {
               var140 = true;
            } else {
               var140 = false;
            }

            this.d(var136, var137, var138, var139, var140);
            var3.writeNoException();
            return true;
         case 9028:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var130 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var131 = var2.readString();
            String var132 = var2.readString();
            int var133 = var2.readInt();
            boolean var134;
            if(var2.readInt() != 0) {
               var134 = true;
            } else {
               var134 = false;
            }

            boolean var135;
            if(var2.readInt() != 0) {
               var135 = true;
            } else {
               var135 = false;
            }

            this.a(var130, var131, var132, var133, var134, var135);
            var3.writeNoException();
            return true;
         case 9030:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ParcelFileDescriptor var129 = this.bN(var2.readString());
            var3.writeNoException();
            if(var129 != null) {
               var3.writeInt(1);
               var129.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9031:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ParticipantEntity[] var142 = (ParticipantEntity[])var2.createTypedArray(ParticipantEntity.CREATOR);
            String var143 = var2.readString();
            String var144 = var2.readString();
            Uri var145;
            if(var2.readInt() != 0) {
               var145 = (Uri)Uri.CREATOR.createFromParcel(var2);
            } else {
               var145 = null;
            }

            Uri var146;
            if(var2.readInt() != 0) {
               var146 = (Uri)Uri.CREATOR.createFromParcel(var2);
            } else {
               var146 = null;
            }

            Intent var147 = this.a(var142, var143, var144, var145, var146);
            var3.writeNoException();
            if(var147 != null) {
               var3.writeInt(1);
               var147.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 10001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readLong());
            var3.writeNoException();
            return true;
         case 10002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.t(var2.readLong());
            var3.writeNoException();
            return true;
         case 10003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 10004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 10005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString(), var2.createStringArray(), var2.readInt(), var2.createByteArray(), var2.readInt());
            var3.writeNoException();
            return true;
         case 10006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 10007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 10008:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 10009:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readInt(), var2.readInt(), var2.readInt());
            var3.writeNoException();
            return true;
         case 10010:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.readInt(), var2.readInt(), var2.readInt());
            var3.writeNoException();
            return true;
         case 10011:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 10012:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var128 = this.a(var2.readInt(), var2.createByteArray(), var2.readInt(), var2.readString());
            var3.writeNoException();
            if(var128 != null) {
               var3.writeInt(1);
               var128.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 10013:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var127 = this.lz();
            var3.writeNoException();
            var3.writeInt(var127);
            return true;
         case 10014:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.t(var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 10015:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var125 = this.ly();
            var3.writeNoException();
            if(var125 != null) {
               var3.writeInt(1);
               var125.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 10016:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readInt());
            var3.writeNoException();
            return true;
         case 10017:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var117 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var118 = var2.readString();
            int var119 = var2.readInt();
            int var120 = var2.readInt();
            boolean var121 = false;
            if(var120 != 0) {
               var121 = true;
            }

            this.b(var117, var118, var119, var121);
            var3.writeNoException();
            return true;
         case 10018:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readInt(), var2.createIntArray());
            var3.writeNoException();
            return true;
         case 10019:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.a(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString(), var2.readInt(), var2.createIntArray());
            var3.writeNoException();
            return true;
         case 10020:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 10021:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var114 = var2.readInt();
            ZInvitationCluster var115 = null;
            if(var114 != 0) {
               var115 = ZInvitationCluster.CREATOR.method_4757(var2);
            }

            Intent var116 = this.a(var115, var2.readString(), var2.readString());
            var3.writeNoException();
            if(var116 != null) {
               var3.writeInt(1);
               var116.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 10022:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var122 = var2.readInt();
            GameRequestCluster var123 = null;
            if(var122 != 0) {
               var123 = GameRequestCluster.CREATOR.method_5522(var2);
            }

            Intent var124 = this.a(var123, var2.readString());
            var3.writeNoException();
            if(var124 != null) {
               var3.writeInt(1);
               var124.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 10023:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var126 = this.lA();
            var3.writeNoException();
            var3.writeInt(var126);
            return true;
         case 11001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.j(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 11002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.lL();
            var3.writeNoException();
            return true;
         case 12001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            String var110 = var2.readString();
            boolean var111;
            if(var2.readInt() != 0) {
               var111 = true;
            } else {
               var111 = false;
            }

            boolean var112;
            if(var2.readInt() != 0) {
               var112 = true;
            } else {
               var112 = false;
            }

            Intent var113 = this.a(var110, var111, var112, var2.readInt());
            var3.writeNoException();
            if(var113 != null) {
               var3.writeInt(1);
               var113.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 12002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var107 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            int var108 = var2.readInt();
            boolean var109 = false;
            if(var108 != 0) {
               var109 = true;
            }

            this.d(var107, var109);
            var3.writeNoException();
            return true;
         case 12003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var102 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var103 = var2.readString();
            String var104 = var2.readString();
            int var105 = var2.readInt();
            boolean var106 = false;
            if(var105 != 0) {
               var106 = true;
            }

            this.c(var102, var103, var104, var106);
            var3.writeNoException();
            return true;
         case 12005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.s(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 12006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var98 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var99 = var2.readString();
            int var100 = var2.readInt();
            boolean var101 = false;
            if(var100 != 0) {
               var101 = true;
            }

            this.e(var98, var99, var101);
            var3.writeNoException();
            return true;
         case 12007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var94 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var95 = var2.readString();
            SnapshotMetadataChangeEntity var96;
            if(var2.readInt() != 0) {
               var96 = SnapshotMetadataChangeEntity.CREATOR.method_5774(var2);
            } else {
               var96 = null;
            }

            Contents var97;
            if(var2.readInt() != 0) {
               var97 = (Contents)Contents.CREATOR.createFromParcel(var2);
            } else {
               var97 = null;
            }

            this.a(var94, var95, var96, var97);
            var3.writeNoException();
            return true;
         case 12008:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.u(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 12009:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.f(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 12010:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var58 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            int[] var59 = var2.createIntArray();
            int var60 = var2.readInt();
            int var61 = var2.readInt();
            boolean var62 = false;
            if(var61 != 0) {
               var62 = true;
            }

            this.a(var58, var59, var60, var62);
            var3.writeNoException();
            return true;
         case 12011:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.d(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readLong());
            var3.writeNoException();
            return true;
         case 12012:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.u(var2.readLong());
            var3.writeNoException();
            return true;
         case 12013:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.d(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 12014:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.d(var2.readLong(), var2.readString());
            var3.writeNoException();
            return true;
         case 12015:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var48 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var49 = var2.readString();
            String var50 = var2.readString();
            int[] var51 = var2.createIntArray();
            int var52 = var2.readInt();
            boolean var53;
            if(var2.readInt() != 0) {
               var53 = true;
            } else {
               var53 = false;
            }

            this.a(var48, var49, var50, var51, var52, var53);
            var3.writeNoException();
            return true;
         case 12016:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var66 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            int var67 = var2.readInt();
            boolean var68 = false;
            if(var67 != 0) {
               var68 = true;
            }

            this.f(var66, var68);
            var3.writeNoException();
            return true;
         case 12017:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.o(var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 12018:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var35 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var36 = var2.readString();
            String var37 = var2.readString();
            int var38 = var2.readInt();
            boolean var39;
            if(var2.readInt() != 0) {
               var39 = true;
            } else {
               var39 = false;
            }

            boolean var40;
            if(var2.readInt() != 0) {
               var40 = true;
            } else {
               var40 = false;
            }

            this.b(var35, var36, var37, var38, var39, var40);
            var3.writeNoException();
            return true;
         case 12019:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Contents var93;
            if(var2.readInt() != 0) {
               var93 = (Contents)Contents.CREATOR.createFromParcel(var2);
            } else {
               var93 = null;
            }

            this.a(var93);
            var3.writeNoException();
            return true;
         case 12020:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.r(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 12021:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var81 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var82 = var2.readString();
            int var83 = var2.readInt();
            boolean var84;
            if(var2.readInt() != 0) {
               var84 = true;
            } else {
               var84 = false;
            }

            boolean var85;
            if(var2.readInt() != 0) {
               var85 = true;
            } else {
               var85 = false;
            }

            this.e(var81, var82, var83, var84, var85);
            var3.writeNoException();
            return true;
         case 12022:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var76 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var77 = var2.readString();
            int var78 = var2.readInt();
            boolean var79;
            if(var2.readInt() != 0) {
               var79 = true;
            } else {
               var79 = false;
            }

            boolean var80;
            if(var2.readInt() != 0) {
               var80 = true;
            } else {
               var80 = false;
            }

            this.f(var76, var77, var78, var79, var80);
            var3.writeNoException();
            return true;
         case 12023:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.b(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 12024:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.c(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString(), var2.readInt());
            var3.writeNoException();
            return true;
         case 12025:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            boolean var74 = this.lM();
            var3.writeNoException();
            byte var75 = 0;
            if(var74) {
               var75 = 1;
            }

            var3.writeInt(var75);
            return true;
         case 12026:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var72 = var2.readInt();
            boolean var73 = false;
            if(var72 != 0) {
               var73 = true;
            }

            this.P(var73);
            var3.writeNoException();
            return true;
         case 12027:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            this.t(IGamesCallbacks.Stub.method_2348(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 12028:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var43 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var44 = var2.readString();
            String var45 = var2.readString();
            String[] var46 = var2.createStringArray();
            boolean var47;
            if(var2.readInt() != 0) {
               var47 = true;
            } else {
               var47 = false;
            }

            this.a(var43, var44, var45, var46, var47);
            var3.writeNoException();
            return true;
         case 12029:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var54 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String[] var55 = var2.createStringArray();
            int var56 = var2.readInt();
            boolean var57 = false;
            if(var56 != 0) {
               var57 = true;
            }

            this.a(var54, var55, var57);
            var3.writeNoException();
            return true;
         case 12030:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var42 = this.b(var2.createIntArray());
            var3.writeNoException();
            if(var42 != null) {
               var3.writeInt(1);
               var42.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 12031:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var63 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            int var64 = var2.readInt();
            boolean var65 = false;
            if(var64 != 0) {
               var65 = true;
            }

            this.a(var63, var65, var2.createStringArray());
            var3.writeNoException();
            return true;
         case 12032:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var69 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            int var70 = var2.readInt();
            boolean var71 = false;
            if(var70 != 0) {
               var71 = true;
            }

            this.e(var69, var71);
            var3.writeNoException();
            return true;
         case 12033:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var88 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var89 = var2.readString();
            String var90 = var2.readString();
            SnapshotMetadataChangeEntity var91;
            if(var2.readInt() != 0) {
               var91 = SnapshotMetadataChangeEntity.CREATOR.method_5774(var2);
            } else {
               var91 = null;
            }

            Contents var92;
            if(var2.readInt() != 0) {
               var92 = (Contents)Contents.CREATOR.createFromParcel(var2);
            } else {
               var92 = null;
            }

            this.a(var88, var89, var90, var91, var92);
            var3.writeNoException();
            return true;
         case 12034:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var41 = this.bE(var2.readString());
            var3.writeNoException();
            if(var41 != null) {
               var3.writeInt(1);
               var41.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 12035:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var87 = this.lB();
            var3.writeNoException();
            var3.writeInt(var87);
            return true;
         case 12036:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var86 = this.lC();
            var3.writeNoException();
            var3.writeInt(var86);
            return true;
         case 13001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var33 = var2.readInt();
            boolean var34 = false;
            if(var33 != 0) {
               var34 = true;
            }

            this.Q(var34);
            var3.writeNoException();
            return true;
         case 13002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            String var30 = var2.readString();
            IBinder var31 = var2.readStrongBinder();
            Bundle var32;
            if(var2.readInt() != 0) {
               var32 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var32 = null;
            }

            this.a(var30, var31, var32);
            var3.writeNoException();
            return true;
         case 13003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var27 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            int var28 = var2.readInt();
            boolean var29 = false;
            if(var28 != 0) {
               var29 = true;
            }

            this.g(var27, var29);
            var3.writeNoException();
            return true;
         case 13004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var24 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            int var25 = var2.readInt();
            boolean var26 = false;
            if(var25 != 0) {
               var26 = true;
            }

            this.h(var24, var26);
            var3.writeNoException();
            return true;
         case 13005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            int var21 = var2.readInt();
            AchievementEntity var22 = null;
            if(var21 != 0) {
               var22 = AchievementEntity.CREATOR.createFromParcel(var2);
            }

            Intent var23 = this.a(var22);
            var3.writeNoException();
            if(var23 != null) {
               var3.writeInt(1);
               var23.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 13006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var17 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            String var18 = var2.readString();
            int var19 = var2.readInt();
            boolean var20 = false;
            if(var19 != 0) {
               var20 = true;
            }

            this.f(var17, var18, var20);
            var3.writeNoException();
            return true;
         case 14001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Intent var16 = this.u(var2.readString(), var2.readInt());
            var3.writeNoException();
            if(var16 != null) {
               var3.writeInt(1);
               var16.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 14002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            IGamesCallbacks var11 = IGamesCallbacks.Stub.method_2348(var2.readStrongBinder());
            int var12 = var2.readInt();
            String var13 = var2.readString();
            String[] var14 = var2.createStringArray();
            boolean var15;
            if(var2.readInt() != 0) {
               var15 = true;
            } else {
               var15 = false;
            }

            this.a(var11, var12, var13, var14, var15);
            var3.writeNoException();
            return true;
         case 14003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ParticipantEntity[] var5 = (ParticipantEntity[])var2.createTypedArray(ParticipantEntity.CREATOR);
            String var6 = var2.readString();
            String var7 = var2.readString();
            Uri var8;
            if(var2.readInt() != 0) {
               var8 = (Uri)Uri.CREATOR.createFromParcel(var2);
            } else {
               var8 = null;
            }

            Uri var9;
            if(var2.readInt() != 0) {
               var9 = (Uri)Uri.CREATOR.createFromParcel(var2);
            } else {
               var9 = null;
            }

            Intent var10 = this.a(var5, var6, var7, var8, var9, var2.readString());
            var3.writeNoException();
            if(var10 != null) {
               var3.writeInt(1);
               var10.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
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
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_4113;

      Proxy(IBinder var1) {
         this.field_4113 = var1;
      }

      // $FF: renamed from: O (boolean) void
      public void method_447(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: P (boolean) void
      public void method_448(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: Q (boolean) void
      public void method_449(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, byte[], java.lang.String, java.lang.String) int
      public int method_450(IGamesCallbacks param1, byte[] param2, String param3, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (int, int, boolean) android.content.Intent
      public Intent method_451(int param1, int param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (int, byte[], int, java.lang.String) android.content.Intent
      public Intent method_452(int var1, byte[] var2, int var3, String var4) throws RemoteException {
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
               this.field_4113.transact(10012, var5, var6, 0);
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

      // $FF: renamed from: a (com.google.android.gms.games.achievement.AchievementEntity) android.content.Intent
      public Intent method_453(AchievementEntity param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.multiplayer.ZInvitationCluster, java.lang.String, java.lang.String) android.content.Intent
      public Intent method_454(ZInvitationCluster param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.request.GameRequestCluster, java.lang.String) android.content.Intent
      public Intent method_455(GameRequestCluster param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomEntity, int) android.content.Intent
      public Intent method_456(RoomEntity param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, boolean, boolean, int) android.content.Intent
      public Intent method_457(String param1, boolean param2, boolean param3, int param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.ParticipantEntity[], java.lang.String, java.lang.String, android.net.Uri, android.net.Uri) android.content.Intent
      public Intent method_458(ParticipantEntity[] param1, String param2, String param3, Uri param4, Uri param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.ParticipantEntity[], java.lang.String, java.lang.String, android.net.Uri, android.net.Uri, java.lang.String) android.content.Intent
      public Intent method_459(ParticipantEntity[] param1, String param2, String param3, Uri param4, Uri param5, String param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (long, java.lang.String) void
      public void method_460(long var1, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var4.writeLong(var1);
            var4.writeString(var3);
            this.field_4113.transact(8019, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      // $FF: renamed from: a (android.os.IBinder, android.os.Bundle) void
      public void method_461(IBinder param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.Contents) void
      public void method_462(Contents param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks) void
      public void method_463(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int) void
      public void method_464(IGamesCallbacks param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int, int) void
      public void method_465(IGamesCallbacks param1, int param2, int param3, int param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int, boolean, boolean) void
      public void method_466(IGamesCallbacks param1, int param2, int param3, boolean param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int, java.lang.String[], android.os.Bundle) void
      public void method_467(IGamesCallbacks param1, int param2, int param3, String[] param4, Bundle param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, java.lang.String, java.lang.String[], boolean) void
      public void method_468(IGamesCallbacks param1, int param2, String param3, String[] param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
      public void method_469(IGamesCallbacks param1, int param2, boolean param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int[]) void
      public void method_470(IGamesCallbacks param1, int param2, int[] param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, long) void
      public void method_471(IGamesCallbacks param1, long param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
      public void method_472(IGamesCallbacks param1, long param2, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, android.os.Bundle, int, int) void
      public void method_473(IGamesCallbacks param1, Bundle param2, int param3, int param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, android.os.IBinder, int, java.lang.String[], android.os.Bundle, boolean, long) void
      public void method_474(IGamesCallbacks param1, IBinder param2, int param3, String[] param4, Bundle param5, boolean param6, long param7) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, android.os.IBinder, java.lang.String, boolean, long) void
      public void method_475(IGamesCallbacks param1, IBinder param2, String param3, boolean param4, long param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_476(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int) void
      public void method_477(IGamesCallbacks param1, String param2, int param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, int, int, boolean) void
      public void method_478(IGamesCallbacks param1, String param2, int param3, int param4, int param5, boolean param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, android.os.IBinder, android.os.Bundle) void
      public void method_479(IGamesCallbacks param1, String param2, int param3, IBinder param4, Bundle param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean) void
      public void method_480(IGamesCallbacks param1, String param2, int param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
      public void method_481(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean, boolean, boolean) void
      public void method_482(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5, boolean param6, boolean param7) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, int[]) void
      public void method_483(IGamesCallbacks param1, String param2, int param3, int[] param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, long) void
      public void method_484(IGamesCallbacks param1, String param2, long param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, long, java.lang.String) void
      public void method_485(IGamesCallbacks param1, String param2, long param3, String param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, android.os.IBinder, android.os.Bundle) void
      public void method_486(IGamesCallbacks param1, String param2, IBinder param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity, com.google.android.gms.drive.Contents) void
      public void method_487(IGamesCallbacks param1, String param2, SnapshotMetadataChangeEntity param3, Contents param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
      public void method_488(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int) void
      public void method_489(IGamesCallbacks param1, String param2, String param3, int param4, int param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int, int) void
      public void method_490(IGamesCallbacks param1, String param2, String param3, int param4, int param5, int param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int, int, boolean) void
      public void method_491(IGamesCallbacks param1, String param2, String param3, int param4, int param5, int param6, boolean param7) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, boolean, boolean) void
      public void method_492(IGamesCallbacks param1, String param2, String param3, int param4, boolean param5, boolean param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity, com.google.android.gms.drive.Contents) void
      public void method_493(IGamesCallbacks param1, String param2, String param3, SnapshotMetadataChangeEntity param4, Contents param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, boolean) void
      public void method_494(IGamesCallbacks param1, String param2, String param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int[], int, boolean) void
      public void method_495(IGamesCallbacks param1, String param2, String param3, int[] param4, int param5, boolean param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, java.lang.String[]) void
      public void method_496(IGamesCallbacks param1, String param2, String param3, String[] param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, java.lang.String[], boolean) void
      public void method_497(IGamesCallbacks param1, String param2, String param3, String[] param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
      public void method_498(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, byte[], java.lang.String, com.google.android.gms.games.multiplayer.ParticipantResult[]) void
      public void method_499(IGamesCallbacks param1, String param2, byte[] param3, String param4, ParticipantResult[] param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, byte[], com.google.android.gms.games.multiplayer.ParticipantResult[]) void
      public void method_500(IGamesCallbacks param1, String param2, byte[] param3, ParticipantResult[] param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int[]) void
      public void method_501(IGamesCallbacks param1, String param2, int[] param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String[], int, byte[], int) void
      public void method_502(IGamesCallbacks param1, String param2, String[] param3, int param4, byte[] param5, int param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
      public void method_503(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, boolean, android.os.Bundle) void
      public void method_504(IGamesCallbacks param1, boolean param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, boolean, java.lang.String[]) void
      public void method_505(IGamesCallbacks param1, boolean param2, String[] param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int[]) void
      public void method_506(IGamesCallbacks param1, int[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int[], int, boolean) void
      public void method_507(IGamesCallbacks param1, int[] param2, int param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[]) void
      public void method_508(IGamesCallbacks param1, String[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[], boolean) void
      public void method_509(IGamesCallbacks param1, String[] param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, android.os.IBinder, android.os.Bundle) void
      public void method_510(String param1, IBinder param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_4113;
      }

      // $FF: renamed from: b (byte[], java.lang.String, java.lang.String[]) int
      public int method_511(byte[] var1, String var2, String[] var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         int var8;
         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var4.writeByteArray(var1);
            var4.writeString(var2);
            var4.writeStringArray(var3);
            this.field_4113.transact(5034, var4, var5, 0);
            var5.readException();
            var8 = var5.readInt();
         } finally {
            var5.recycle();
            var4.recycle();
         }

         return var8;
      }

      // $FF: renamed from: b (int, int, boolean) android.content.Intent
      public Intent method_512(int param1, int param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (int[]) android.content.Intent
      public Intent method_513(int[] var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var8 = false;

         Intent var6;
         label36: {
            try {
               var8 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               var2.writeIntArray(var1);
               this.field_4113.transact(12030, var2, var3, 0);
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

      // $FF: renamed from: b (long, java.lang.String) void
      public void method_514(long var1, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var4.writeLong(var1);
            var4.writeString(var3);
            this.field_4113.transact(8021, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks) void
      public void method_515(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
      public void method_516(IGamesCallbacks param1, int param2, boolean param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, long) void
      public void method_517(IGamesCallbacks param1, long param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
      public void method_518(IGamesCallbacks param1, long param2, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_519(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int) void
      public void method_520(IGamesCallbacks param1, String param2, int param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, int, int, boolean) void
      public void method_521(IGamesCallbacks param1, String param2, int param3, int param4, int param5, boolean param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, android.os.IBinder, android.os.Bundle) void
      public void method_522(IGamesCallbacks param1, String param2, int param3, IBinder param4, Bundle param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean) void
      public void method_523(IGamesCallbacks param1, String param2, int param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
      public void method_524(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, android.os.IBinder, android.os.Bundle) void
      public void method_525(IGamesCallbacks param1, String param2, IBinder param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
      public void method_526(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int, int, boolean) void
      public void method_527(IGamesCallbacks param1, String param2, String param3, int param4, int param5, int param6, boolean param7) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, boolean, boolean) void
      public void method_528(IGamesCallbacks param1, String param2, String param3, int param4, boolean param5, boolean param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, boolean) void
      public void method_529(IGamesCallbacks param1, String param2, String param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
      public void method_530(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
      public void method_531(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[]) void
      public void method_532(IGamesCallbacks param1, String[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (java.lang.String, java.lang.String, int) void
      public void method_533(String var1, String var2, int var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var4.writeString(var1);
            var4.writeString(var2);
            var4.writeInt(var3);
            this.field_4113.transact(5051, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      // $FF: renamed from: bE (java.lang.String) android.content.Intent
      public Intent method_534(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var8 = false;

         Intent var6;
         label36: {
            try {
               var8 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               var2.writeString(var1);
               this.field_4113.transact(12034, var2, var3, 0);
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

      // $FF: renamed from: bG (java.lang.String) java.lang.String
      public String method_535(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         String var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var2.writeString(var1);
            this.field_4113.transact(5064, var2, var3, 0);
            var3.readException();
            var6 = var3.readString();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      // $FF: renamed from: bH (java.lang.String) java.lang.String
      public String method_536(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         String var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var2.writeString(var1);
            this.field_4113.transact(5035, var2, var3, 0);
            var3.readException();
            var6 = var3.readString();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      // $FF: renamed from: bI (java.lang.String) void
      public void method_537(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var2.writeString(var1);
            this.field_4113.transact(5050, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      // $FF: renamed from: bJ (java.lang.String) int
      public int method_538(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var2.writeString(var1);
            this.field_4113.transact(5060, var2, var3, 0);
            var3.readException();
            var6 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      // $FF: renamed from: bK (java.lang.String) android.net.Uri
      public Uri method_539(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var8 = false;

         Uri var6;
         label36: {
            try {
               var8 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               var2.writeString(var1);
               this.field_4113.transact(5066, var2, var3, 0);
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

      // $FF: renamed from: bL (java.lang.String) void
      public void method_540(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var2.writeString(var1);
            this.field_4113.transact(8002, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      // $FF: renamed from: bM (java.lang.String) android.content.Intent
      public Intent method_541(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var8 = false;

         Intent var6;
         label36: {
            try {
               var8 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               var2.writeString(var1);
               this.field_4113.transact(9004, var2, var3, 0);
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

      // $FF: renamed from: bN (java.lang.String) android.os.ParcelFileDescriptor
      public ParcelFileDescriptor method_542(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var8 = false;

         ParcelFileDescriptor var6;
         label36: {
            try {
               var8 = true;
               var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               var2.writeString(var1);
               this.field_4113.transact(9030, var2, var3, 0);
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
      public void method_543(long var1, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var4.writeLong(var1);
            var4.writeString(var3);
            this.field_4113.transact(10004, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks) void
      public void method_544(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
      public void method_545(IGamesCallbacks param1, int param2, boolean param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, long) void
      public void method_546(IGamesCallbacks param1, long param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
      public void method_547(IGamesCallbacks param1, long param2, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_548(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int) void
      public void method_549(IGamesCallbacks param1, String param2, int param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
      public void method_550(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
      public void method_551(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, boolean) void
      public void method_552(IGamesCallbacks param1, String param2, String param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
      public void method_553(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
      public void method_554(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[]) void
      public void method_555(IGamesCallbacks param1, String[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (java.lang.String, java.lang.String, int) void
      public void method_556(String var1, String var2, int var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var4.writeString(var1);
            var4.writeString(var2);
            var4.writeInt(var3);
            this.field_4113.transact(8026, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      // $FF: renamed from: d (long, java.lang.String) void
      public void method_557(long var1, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var4.writeLong(var1);
            var4.writeString(var3);
            this.field_4113.transact(12014, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks) void
      public void method_558(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
      public void method_559(IGamesCallbacks param1, int param2, boolean param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, long) void
      public void method_560(IGamesCallbacks param1, long param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
      public void method_561(IGamesCallbacks param1, long param2, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_562(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
      public void method_563(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
      public void method_564(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
      public void method_565(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
      public void method_566(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: dT (int) void
      public void method_567(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var2.writeInt(var1);
            this.field_4113.transact(5036, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks) void
      public void method_568(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
      public void method_569(IGamesCallbacks param1, int param2, boolean param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_570(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
      public void method_571(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
      public void method_572(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
      public void method_573(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
      public void method_574(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks) void
      public void method_575(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_576(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
      public void method_577(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
      public void method_578(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
      public void method_579(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
      public void method_580(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: fX () android.os.Bundle
      public Bundle method_581() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Bundle var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.field_4113.transact(5004, var1, var2, 0);
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

      // $FF: renamed from: g (com.google.android.gms.games.internal.IGamesCallbacks) void
      public void method_582(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: g (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_583(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: g (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
      public void method_584(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: h (android.net.Uri) android.os.ParcelFileDescriptor
      public ParcelFileDescriptor method_585(Uri param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: h (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) com.google.android.gms.games.multiplayer.realtime.RoomEntity
      public RoomEntity method_586(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: h (com.google.android.gms.games.internal.IGamesCallbacks) void
      public void method_587(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: h (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
      public void method_588(IGamesCallbacks param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: i (com.google.android.gms.games.internal.IGamesCallbacks) void
      public void method_589(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: i (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_590(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: j (com.google.android.gms.games.internal.IGamesCallbacks) void
      public void method_591(IGamesCallbacks param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: j (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_592(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: k (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_593(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: l (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_594(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: lA () int
      public int method_595() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4113.transact(10023, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: lB () int
      public int method_596() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4113.transact(12035, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: lC () int
      public int method_597() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4113.transact(12036, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: lE () void
      public void method_598() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4113.transact(5006, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      // $FF: renamed from: lG () com.google.android.gms.common.data.DataHolder
      public DataHolder method_599() throws RemoteException {
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
                  this.field_4113.transact(5013, var1, var2, 0);
                  var2.readException();
                  if(var2.readInt() != 0) {
                     var6 = DataHolder.CREATOR.method_5394(var2);
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

      // $FF: renamed from: lH () boolean
      public boolean method_600() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4113.transact(5067, var1, var2, 0);
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

      // $FF: renamed from: lI () com.google.android.gms.common.data.DataHolder
      public DataHolder method_601() throws RemoteException {
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
                  this.field_4113.transact(5502, var1, var2, 0);
                  var2.readException();
                  if(var2.readInt() != 0) {
                     var6 = DataHolder.CREATOR.method_5394(var2);
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

      // $FF: renamed from: lJ () void
      public void method_602() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4113.transact(8022, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      // $FF: renamed from: lK () android.content.Intent
      public Intent method_603() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Intent var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.field_4113.transact(9013, var1, var2, 0);
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

      // $FF: renamed from: lL () void
      public void method_604() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4113.transact(11002, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      // $FF: renamed from: lM () boolean
      public boolean method_605() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4113.transact(12025, var1, var2, 0);
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

      // $FF: renamed from: lh () java.lang.String
      public String method_606() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4113.transact(5007, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: li () java.lang.String
      public String method_607() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4113.transact(5012, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: ll () android.content.Intent
      public Intent method_608() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Intent var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.field_4113.transact(9003, var1, var2, 0);
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

      // $FF: renamed from: lm () android.content.Intent
      public Intent method_609() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Intent var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.field_4113.transact(9005, var1, var2, 0);
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

      // $FF: renamed from: ln () android.content.Intent
      public Intent method_610() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Intent var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.field_4113.transact(9006, var1, var2, 0);
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

      // $FF: renamed from: lo () android.content.Intent
      public Intent method_611() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Intent var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.field_4113.transact(9007, var1, var2, 0);
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

      // $FF: renamed from: lt () android.content.Intent
      public Intent method_612() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Intent var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.field_4113.transact(9010, var1, var2, 0);
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

      // $FF: renamed from: lu () android.content.Intent
      public Intent method_613() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Intent var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.field_4113.transact(9012, var1, var2, 0);
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

      // $FF: renamed from: lv () int
      public int method_614() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4113.transact(9019, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: lw () java.lang.String
      public String method_615() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4113.transact(5003, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: lx () int
      public int method_616() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4113.transact(8024, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: ly () android.content.Intent
      public Intent method_617() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Intent var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               this.field_4113.transact(10015, var1, var2, 0);
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

      // $FF: renamed from: lz () int
      public int method_618() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            this.field_4113.transact(10013, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: m (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_619(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: n (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_620(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: o (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_621(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: o (java.lang.String, int) void
      public void method_622(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.field_4113.transact(12017, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: p (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_623(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: p (java.lang.String, int) void
      public void method_624(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.field_4113.transact(5029, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: q (long) void
      public void method_625(long var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeLong(var1);
            this.field_4113.transact(5001, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: q (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_626(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: q (java.lang.String, int) void
      public void method_627(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.field_4113.transact(5028, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: r (long) void
      public void method_628(long var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeLong(var1);
            this.field_4113.transact(5059, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: r (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_629(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: s (long) void
      public void method_630(long var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeLong(var1);
            this.field_4113.transact(8013, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: s (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_631(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: s (java.lang.String, int) void
      public void method_632(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.field_4113.transact(5055, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: t (long) void
      public void method_633(long var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeLong(var1);
            this.field_4113.transact(10002, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: t (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_634(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: t (java.lang.String, int) void
      public void method_635(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.field_4113.transact(10014, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: t (java.lang.String, java.lang.String) void
      public void method_636(String var1, String var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            var3.writeString(var2);
            this.field_4113.transact(5065, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: u (java.lang.String, int) android.content.Intent
      public Intent method_637(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var9 = false;

         Intent var7;
         label36: {
            try {
               var9 = true;
               var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
               var3.writeString(var1);
               var3.writeInt(var2);
               this.field_4113.transact(14001, var3, var4, 0);
               var4.readException();
               if(var4.readInt() != 0) {
                  var7 = (Intent)Intent.CREATOR.createFromParcel(var4);
                  var9 = false;
                  break label36;
               }

               var9 = false;
            } finally {
               if(var9) {
                  var4.recycle();
                  var3.recycle();
               }
            }

            var7 = null;
         }

         var4.recycle();
         var3.recycle();
         return var7;
      }

      // $FF: renamed from: u (long) void
      public void method_638(long var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeLong(var1);
            this.field_4113.transact(12012, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: u (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
      public void method_639(IGamesCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: u (java.lang.String, java.lang.String) void
      public void method_640(String var1, String var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            var3.writeString(var1);
            var3.writeString(var2);
            this.field_4113.transact(8025, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }
   }
}
