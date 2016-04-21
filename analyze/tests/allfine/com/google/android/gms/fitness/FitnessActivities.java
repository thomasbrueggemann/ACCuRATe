package com.google.android.gms.fitness;

import android.util.SparseArray;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.Field;

public class FitnessActivities {
    public static final String AEROBICS = "aerobics";
    public static final String BADMINTON = "badminton";
    public static final String BASEBALL = "baseball";
    public static final String BASKETBALL = "basketball";
    public static final String BIATHLON = "biathlon";
    public static final String BIKING = "biking";
    public static final String BIKING_HAND = "biking.hand";
    public static final String BIKING_MOUNTAIN = "biking.mountain";
    public static final String BIKING_ROAD = "biking.road";
    public static final String BIKING_SPINNING = "biking.spinning";
    public static final String BIKING_STATIONARY = "biking.stationary";
    public static final String BIKING_UTILITY = "biking.utility";
    public static final String BOXING = "boxing";
    public static final String CALISTHENICS = "calisthenics";
    public static final String CIRCUIT_TRAINING = "circuit_training";
    public static final String CRICKET = "cricket";
    public static final String CURLING = "curling";
    public static final String DANCING = "dancing";
    public static final String DIVING = "diving";
    public static final String ELLIPTICAL = "elliptical";
    public static final String ERGOMETER = "ergometer";
    public static final String EXTRA_STATUS = "actionStatus";
    public static final String FENCING = "fencing";
    public static final String FOOTBALL_AMERICAN = "football.american";
    public static final String FOOTBALL_AUSTRALIAN = "football.australian";
    public static final String FOOTBALL_SOCCER = "football.soccer";
    public static final String FRISBEE_DISC = "frisbee_disc";
    public static final String GARDENING = "gardening";
    public static final String GOLF = "golf";
    public static final String GYMNASTICS = "gymnastics";
    public static final String HANDBALL = "handball";
    public static final String HIKING = "hiking";
    public static final String HOCKEY = "hockey";
    public static final String HORSEBACK_RIDING = "horseback_riding";
    public static final String HOUSEWORK = "housework";
    public static final String ICE_SKATING = "ice_skating";
    public static final String IN_VEHICLE = "in_vehicle";
    public static final String JUMP_ROPE = "jump_rope";
    public static final String KAYAKING = "kayaking";
    public static final String KETTLEBELL_TRAINING = "kettlebell_training";
    public static final String KICKBOXING = "kickboxing";
    public static final String KICK_SCOOTER = "kick_scooter";
    public static final String KITESURFING = "kitesurfing";
    public static final String MARTIAL_ARTS = "martial_arts";
    public static final String MEDITATION = "meditation";
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.activity/";
    public static final String MIXED_MARTIAL_ARTS = "martial_arts.mixed";
    public static final String ON_FOOT = "on_foot";
    public static final String OTHER = "other";
    public static final String P90X = "p90x";
    public static final String PARAGLIDING = "paragliding";
    public static final String PILATES = "pilates";
    public static final String POLO = "polo";
    public static final String RACQUETBALL = "racquetball";
    public static final String ROCK_CLIMBING = "rock_climbing";
    public static final String ROWING = "rowing";
    public static final String ROWING_MACHINE = "rowing.machine";
    public static final String RUGBY = "rugby";
    public static final String RUNNING = "running";
    public static final String RUNNING_JOGGING = "running.jogging";
    public static final String RUNNING_SAND = "running.sand";
    public static final String RUNNING_TREADMILL = "running.treadmill";
    public static final String SAILING = "sailing";
    public static final String SCUBA_DIVING = "scuba_diving";
    public static final String SKATEBOARDING = "skateboarding";
    public static final String SKATING = "skating";
    public static final String SKATING_CROSS = "skating.cross";
    public static final String SKATING_INDOOR = "skating.indoor";
    public static final String SKATING_INLINE = "skating.inline";
    public static final String SKIING = "skiing";
    public static final String SKIING_BACK_COUNTRY = "skiing.back_country";
    public static final String SKIING_CROSS_COUNTRY = "skiing.cross_country";
    public static final String SKIING_DOWNHILL = "skiing.downhill";
    public static final String SKIING_KITE = "skiing.kite";
    public static final String SKIING_ROLLER = "skiing.roller";
    public static final String SLEDDING = "sledding";
    public static final String SLEEP = "sleep";
    public static final String SNOWBOARDING = "snowboarding";
    public static final String SNOWMOBILE = "snowmobile";
    public static final String SNOWSHOEING = "snowshoeing";
    public static final String SQUASH = "squash";
    public static final String STAIR_CLIMBING = "stair_climbing";
    public static final String STAIR_CLIMBING_MACHINE = "stair_climbing.machine";
    public static final String STANDUP_PADDLEBOARDING = "standup_paddleboarding";
    public static final String STATUS_ACTIVE = "ActiveActionStatus";
    public static final String STATUS_COMPLETED = "CompletedActionStatus";
    public static final String STILL = "still";
    public static final String STRENGTH_TRAINING = "strength_training";
    public static final String SURFING = "surfing";
    public static final String SWIMMING = "swimming";
    public static final String SWIMMING_OPEN_WATER = "swimming.open_water";
    public static final String SWIMMING_POOL = "swimming.pool";
    // $FF: renamed from: So android.util.SparseArray
    private static final SparseArray<String> field_2213 = new SparseArray(109);
    public static final String TABLE_TENNIS = "table_tennis";
    public static final String TEAM_SPORTS = "team_sports";
    public static final String TENNIS = "tennis";
    public static final String TILTING = "tilting";
    public static final String TREADMILL = "treadmill";
    public static final String UNKNOWN = "unknown";
    public static final String VOLLEYBALL = "volleyball";
    public static final String VOLLEYBALL_BEACH = "volleyball.beach";
    public static final String VOLLEYBALL_INDOOR = "volleyball.indoor";
    public static final String WAKEBOARDING = "wakeboarding";
    public static final String WALKING = "walking";
    public static final String WALKING_FITNESS = "walking.fitness";
    public static final String WALKING_NORDIC = "walking.nordic";
    public static final String WALKING_TREADMILL = "walking.treadmill";
    public static final String WATER_POLO = "water_polo";
    public static final String WEIGHTLIFTING = "weightlifting";
    public static final String WHEELCHAIR = "wheelchair";
    public static final String WINDSURFING = "windsurfing";
    public static final String YOGA = "yoga";
    public static final String ZUMBA = "zumba";

    static {
        field_2213.put(9, "aerobics");
        field_2213.put(10, "badminton");
        field_2213.put(11, "baseball");
        field_2213.put(12, "basketball");
        field_2213.put(13, "biathlon");
        field_2213.put(1, "biking");
        field_2213.put(14, "biking.hand");
        field_2213.put(15, "biking.mountain");
        field_2213.put(16, "biking.road");
        field_2213.put(17, "biking.spinning");
        field_2213.put(18, "biking.stationary");
        field_2213.put(19, "biking.utility");
        field_2213.put(20, "boxing");
        field_2213.put(21, "calisthenics");
        field_2213.put(22, "circuit_training");
        field_2213.put(23, "cricket");
        field_2213.put(106, "curling");
        field_2213.put(24, "dancing");
        field_2213.put(102, "diving");
        field_2213.put(25, "elliptical");
        field_2213.put(103, "ergometer");
        field_2213.put(6, "exiting_vehicle");
        field_2213.put(26, "fencing");
        field_2213.put(27, "football.american");
        field_2213.put(28, "football.australian");
        field_2213.put(29, "football.soccer");
        field_2213.put(30, "frisbee_disc");
        field_2213.put(31, "gardening");
        field_2213.put(32, "golf");
        field_2213.put(33, "gymnastics");
        field_2213.put(34, "handball");
        field_2213.put(35, "hiking");
        field_2213.put(36, "hockey");
        field_2213.put(37, "horseback_riding");
        field_2213.put(38, "housework");
        field_2213.put(104, "ice_skating");
        field_2213.put(0, "in_vehicle");
        field_2213.put(39, "jump_rope");
        field_2213.put(40, "kayaking");
        field_2213.put(41, "kettlebell_training");
        field_2213.put(107, "kick_scooter");
        field_2213.put(42, "kickboxing");
        field_2213.put(43, "kitesurfing");
        field_2213.put(44, "martial_arts");
        field_2213.put(45, "meditation");
        field_2213.put(46, "martial_arts.mixed");
        field_2213.put(2, "on_foot");
        field_2213.put(108, "other");
        field_2213.put(47, "p90x");
        field_2213.put(48, "paragliding");
        field_2213.put(49, "pilates");
        field_2213.put(50, "polo");
        field_2213.put(51, "racquetball");
        field_2213.put(52, "rock_climbing");
        field_2213.put(53, "rowing");
        field_2213.put(54, "rowing.machine");
        field_2213.put(55, "rugby");
        field_2213.put(8, "running");
        field_2213.put(56, "running.jogging");
        field_2213.put(57, "running.sand");
        field_2213.put(58, "running.treadmill");
        field_2213.put(59, "sailing");
        field_2213.put(60, "scuba_diving");
        field_2213.put(61, "skateboarding");
        field_2213.put(62, "skating");
        field_2213.put(63, "skating.cross");
        field_2213.put(105, "skating.indoor");
        field_2213.put(64, "skating.inline");
        field_2213.put(65, "skiing");
        field_2213.put(66, "skiing.back_country");
        field_2213.put(67, "skiing.cross_country");
        field_2213.put(68, "skiing.downhill");
        field_2213.put(69, "skiing.kite");
        field_2213.put(70, "skiing.roller");
        field_2213.put(71, "sledding");
        field_2213.put(72, "sleep");
        field_2213.put(73, "snowboarding");
        field_2213.put(74, "snowmobile");
        field_2213.put(75, "snowshoeing");
        field_2213.put(76, "squash");
        field_2213.put(77, "stair_climbing");
        field_2213.put(78, "stair_climbing.machine");
        field_2213.put(79, "standup_paddleboarding");
        field_2213.put(3, "still");
        field_2213.put(80, "strength_training");
        field_2213.put(81, "surfing");
        field_2213.put(82, "swimming");
        field_2213.put(83, "swimming.pool");
        field_2213.put(84, "swimming.open_water");
        field_2213.put(85, "table_tennis");
        field_2213.put(86, "team_sports");
        field_2213.put(87, "tennis");
        field_2213.put(5, "tilting");
        field_2213.put(88, "treadmill");
        field_2213.put(4, "unknown");
        field_2213.put(89, "volleyball");
        field_2213.put(90, "volleyball.beach");
        field_2213.put(91, "volleyball.indoor");
        field_2213.put(92, "wakeboarding");
        field_2213.put(7, "walking");
        field_2213.put(93, "walking.fitness");
        field_2213.put(94, "walking.nordic");
        field_2213.put(95, "walking.treadmill");
        field_2213.put(96, "water_polo");
        field_2213.put(97, "weightlifting");
        field_2213.put(98, "wheelchair");
        field_2213.put(99, "windsurfing");
        field_2213.put(100, "yoga");
        field_2213.put(101, "zumba");
    }

    // $FF: renamed from: bp (java.lang.String) int
    public static int method_3152(String var0) {
        int var1 = field_2213.indexOfValue(var0);
        if(var1 >= 0) {
            int var2 = field_2213.keyAt(var1);
            if(var2 <= 108) {
                return var2;
            }
        }

        return 4;
    }

    public static String getMimeType(String var0) {
        return "vnd.google.fitness.activity/" + var0;
    }

    public static String getName(int var0) {
        String var1 = (String)field_2213.get(var0);
        if(var1 == null) {
            throw new IllegalArgumentException("Unknown activity " + var0);
        } else {
            return var1;
        }
    }

    public static String getValue(DataPoint var0) {
        return getName(var0.getValue(Field.FIELD_ACTIVITY).asInt());
    }

    public static void setValue(DataPoint var0, String var1) {
        var0.getValue(Field.FIELD_ACTIVITY).setInt(method_3152(var1));
    }
}
