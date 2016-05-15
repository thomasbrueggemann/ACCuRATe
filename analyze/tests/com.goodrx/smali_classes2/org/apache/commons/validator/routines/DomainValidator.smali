.class public Lorg/apache/commons/validator/routines/DomainValidator;
.super Ljava/lang/Object;
.source "DomainValidator.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/apache/commons/validator/routines/DomainValidator$IDNBUGHOLDER;
    }
.end annotation


# static fields
.field private static final COUNTRY_CODE_TLDS:[Ljava/lang/String;

.field private static volatile COUNTRY_CODE_TLDS_MINUS:[Ljava/lang/String;

.field private static volatile COUNTRY_CODE_TLDS_PLUS:[Ljava/lang/String;

.field private static final DOMAIN_VALIDATOR:Lorg/apache/commons/validator/routines/DomainValidator;

.field private static final DOMAIN_VALIDATOR_WITH_LOCAL:Lorg/apache/commons/validator/routines/DomainValidator;

.field private static final EMPTY_STRING_ARRAY:[Ljava/lang/String;

.field private static final GENERIC_TLDS:[Ljava/lang/String;

.field private static volatile GENERIC_TLDS_MINUS:[Ljava/lang/String;

.field private static volatile GENERIC_TLDS_PLUS:[Ljava/lang/String;

.field private static final INFRASTRUCTURE_TLDS:[Ljava/lang/String;

.field private static final LOCAL_TLDS:[Ljava/lang/String;

.field private static inUse:Z


# instance fields
.field private final allowLocal:Z

.field private final domainRegex:Lorg/apache/commons/validator/routines/RegexValidator;

.field private final hostnameRegex:Lorg/apache/commons/validator/routines/RegexValidator;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 66
    new-array v0, v3, [Ljava/lang/String;

    sput-object v0, Lorg/apache/commons/validator/routines/DomainValidator;->EMPTY_STRING_ARRAY:[Ljava/lang/String;

    .line 94
    new-instance v0, Lorg/apache/commons/validator/routines/DomainValidator;

    invoke-direct {v0, v3}, Lorg/apache/commons/validator/routines/DomainValidator;-><init>(Z)V

    sput-object v0, Lorg/apache/commons/validator/routines/DomainValidator;->DOMAIN_VALIDATOR:Lorg/apache/commons/validator/routines/DomainValidator;

    .line 100
    new-instance v0, Lorg/apache/commons/validator/routines/DomainValidator;

    invoke-direct {v0, v4}, Lorg/apache/commons/validator/routines/DomainValidator;-><init>(Z)V

    sput-object v0, Lorg/apache/commons/validator/routines/DomainValidator;->DOMAIN_VALIDATOR_WITH_LOCAL:Lorg/apache/commons/validator/routines/DomainValidator;

    .line 278
    new-array v0, v4, [Ljava/lang/String;

    const-string v1, "arpa"

    aput-object v1, v0, v3

    sput-object v0, Lorg/apache/commons/validator/routines/DomainValidator;->INFRASTRUCTURE_TLDS:[Ljava/lang/String;

    .line 283
    const/16 v0, 0x328

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "aaa"

    aput-object v1, v0, v3

    const-string v1, "aarp"

    aput-object v1, v0, v4

    const-string v1, "abb"

    aput-object v1, v0, v5

    const-string v1, "abbott"

    aput-object v1, v0, v6

    const-string v1, "abogado"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "academy"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "accenture"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "accountant"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "accountants"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "aco"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "active"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "actor"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "ads"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "adult"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string v2, "aeg"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string v2, "aero"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string v2, "afl"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    const-string v2, "agency"

    aput-object v2, v0, v1

    const/16 v1, 0x12

    const-string v2, "aig"

    aput-object v2, v0, v1

    const/16 v1, 0x13

    const-string v2, "airforce"

    aput-object v2, v0, v1

    const/16 v1, 0x14

    const-string v2, "airtel"

    aput-object v2, v0, v1

    const/16 v1, 0x15

    const-string v2, "allfinanz"

    aput-object v2, v0, v1

    const/16 v1, 0x16

    const-string v2, "alsace"

    aput-object v2, v0, v1

    const/16 v1, 0x17

    const-string v2, "amica"

    aput-object v2, v0, v1

    const/16 v1, 0x18

    const-string v2, "amsterdam"

    aput-object v2, v0, v1

    const/16 v1, 0x19

    const-string v2, "android"

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    const-string v2, "apartments"

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    const-string v2, "app"

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    const-string v2, "apple"

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    const-string v2, "aquarelle"

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    const-string v2, "aramco"

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    const-string v2, "archi"

    aput-object v2, v0, v1

    const/16 v1, 0x20

    const-string v2, "army"

    aput-object v2, v0, v1

    const/16 v1, 0x21

    const-string v2, "arte"

    aput-object v2, v0, v1

    const/16 v1, 0x22

    const-string v2, "asia"

    aput-object v2, v0, v1

    const/16 v1, 0x23

    const-string v2, "associates"

    aput-object v2, v0, v1

    const/16 v1, 0x24

    const-string v2, "attorney"

    aput-object v2, v0, v1

    const/16 v1, 0x25

    const-string v2, "auction"

    aput-object v2, v0, v1

    const/16 v1, 0x26

    const-string v2, "audio"

    aput-object v2, v0, v1

    const/16 v1, 0x27

    const-string v2, "auto"

    aput-object v2, v0, v1

    const/16 v1, 0x28

    const-string v2, "autos"

    aput-object v2, v0, v1

    const/16 v1, 0x29

    const-string v2, "axa"

    aput-object v2, v0, v1

    const/16 v1, 0x2a

    const-string v2, "azure"

    aput-object v2, v0, v1

    const/16 v1, 0x2b

    const-string v2, "band"

    aput-object v2, v0, v1

    const/16 v1, 0x2c

    const-string v2, "bank"

    aput-object v2, v0, v1

    const/16 v1, 0x2d

    const-string v2, "bar"

    aput-object v2, v0, v1

    const/16 v1, 0x2e

    const-string v2, "barcelona"

    aput-object v2, v0, v1

    const/16 v1, 0x2f

    const-string v2, "barclaycard"

    aput-object v2, v0, v1

    const/16 v1, 0x30

    const-string v2, "barclays"

    aput-object v2, v0, v1

    const/16 v1, 0x31

    const-string v2, "bargains"

    aput-object v2, v0, v1

    const/16 v1, 0x32

    const-string v2, "bauhaus"

    aput-object v2, v0, v1

    const/16 v1, 0x33

    const-string v2, "bayern"

    aput-object v2, v0, v1

    const/16 v1, 0x34

    const-string v2, "bbc"

    aput-object v2, v0, v1

    const/16 v1, 0x35

    const-string v2, "bbva"

    aput-object v2, v0, v1

    const/16 v1, 0x36

    const-string v2, "bcn"

    aput-object v2, v0, v1

    const/16 v1, 0x37

    const-string v2, "beats"

    aput-object v2, v0, v1

    const/16 v1, 0x38

    const-string v2, "beer"

    aput-object v2, v0, v1

    const/16 v1, 0x39

    const-string v2, "bentley"

    aput-object v2, v0, v1

    const/16 v1, 0x3a

    const-string v2, "berlin"

    aput-object v2, v0, v1

    const/16 v1, 0x3b

    const-string v2, "best"

    aput-object v2, v0, v1

    const/16 v1, 0x3c

    const-string v2, "bet"

    aput-object v2, v0, v1

    const/16 v1, 0x3d

    const-string v2, "bharti"

    aput-object v2, v0, v1

    const/16 v1, 0x3e

    const-string v2, "bible"

    aput-object v2, v0, v1

    const/16 v1, 0x3f

    const-string v2, "bid"

    aput-object v2, v0, v1

    const/16 v1, 0x40

    const-string v2, "bike"

    aput-object v2, v0, v1

    const/16 v1, 0x41

    const-string v2, "bing"

    aput-object v2, v0, v1

    const/16 v1, 0x42

    const-string v2, "bingo"

    aput-object v2, v0, v1

    const/16 v1, 0x43

    const-string v2, "bio"

    aput-object v2, v0, v1

    const/16 v1, 0x44

    const-string v2, "biz"

    aput-object v2, v0, v1

    const/16 v1, 0x45

    const-string v2, "black"

    aput-object v2, v0, v1

    const/16 v1, 0x46

    const-string v2, "blackfriday"

    aput-object v2, v0, v1

    const/16 v1, 0x47

    const-string v2, "bloomberg"

    aput-object v2, v0, v1

    const/16 v1, 0x48

    const-string v2, "blue"

    aput-object v2, v0, v1

    const/16 v1, 0x49

    const-string v2, "bms"

    aput-object v2, v0, v1

    const/16 v1, 0x4a

    const-string v2, "bmw"

    aput-object v2, v0, v1

    const/16 v1, 0x4b

    const-string v2, "bnl"

    aput-object v2, v0, v1

    const/16 v1, 0x4c

    const-string v2, "bnpparibas"

    aput-object v2, v0, v1

    const/16 v1, 0x4d

    const-string v2, "boats"

    aput-object v2, v0, v1

    const/16 v1, 0x4e

    const-string v2, "bom"

    aput-object v2, v0, v1

    const/16 v1, 0x4f

    const-string v2, "bond"

    aput-object v2, v0, v1

    const/16 v1, 0x50

    const-string v2, "boo"

    aput-object v2, v0, v1

    const/16 v1, 0x51

    const-string v2, "boots"

    aput-object v2, v0, v1

    const/16 v1, 0x52

    const-string v2, "boutique"

    aput-object v2, v0, v1

    const/16 v1, 0x53

    const-string v2, "bradesco"

    aput-object v2, v0, v1

    const/16 v1, 0x54

    const-string v2, "bridgestone"

    aput-object v2, v0, v1

    const/16 v1, 0x55

    const-string v2, "broker"

    aput-object v2, v0, v1

    const/16 v1, 0x56

    const-string v2, "brother"

    aput-object v2, v0, v1

    const/16 v1, 0x57

    const-string v2, "brussels"

    aput-object v2, v0, v1

    const/16 v1, 0x58

    const-string v2, "budapest"

    aput-object v2, v0, v1

    const/16 v1, 0x59

    const-string v2, "build"

    aput-object v2, v0, v1

    const/16 v1, 0x5a

    const-string v2, "builders"

    aput-object v2, v0, v1

    const/16 v1, 0x5b

    const-string v2, "business"

    aput-object v2, v0, v1

    const/16 v1, 0x5c

    const-string v2, "buzz"

    aput-object v2, v0, v1

    const/16 v1, 0x5d

    const-string v2, "bzh"

    aput-object v2, v0, v1

    const/16 v1, 0x5e

    const-string v2, "cab"

    aput-object v2, v0, v1

    const/16 v1, 0x5f

    const-string v2, "cafe"

    aput-object v2, v0, v1

    const/16 v1, 0x60

    const-string v2, "cal"

    aput-object v2, v0, v1

    const/16 v1, 0x61

    const-string v2, "camera"

    aput-object v2, v0, v1

    const/16 v1, 0x62

    const-string v2, "camp"

    aput-object v2, v0, v1

    const/16 v1, 0x63

    const-string v2, "cancerresearch"

    aput-object v2, v0, v1

    const/16 v1, 0x64

    const-string v2, "canon"

    aput-object v2, v0, v1

    const/16 v1, 0x65

    const-string v2, "capetown"

    aput-object v2, v0, v1

    const/16 v1, 0x66

    const-string v2, "capital"

    aput-object v2, v0, v1

    const/16 v1, 0x67

    const-string v2, "car"

    aput-object v2, v0, v1

    const/16 v1, 0x68

    const-string v2, "caravan"

    aput-object v2, v0, v1

    const/16 v1, 0x69

    const-string v2, "cards"

    aput-object v2, v0, v1

    const/16 v1, 0x6a

    const-string v2, "care"

    aput-object v2, v0, v1

    const/16 v1, 0x6b

    const-string v2, "career"

    aput-object v2, v0, v1

    const/16 v1, 0x6c

    const-string v2, "careers"

    aput-object v2, v0, v1

    const/16 v1, 0x6d

    const-string v2, "cars"

    aput-object v2, v0, v1

    const/16 v1, 0x6e

    const-string v2, "cartier"

    aput-object v2, v0, v1

    const/16 v1, 0x6f

    const-string v2, "casa"

    aput-object v2, v0, v1

    const/16 v1, 0x70

    const-string v2, "cash"

    aput-object v2, v0, v1

    const/16 v1, 0x71

    const-string v2, "casino"

    aput-object v2, v0, v1

    const/16 v1, 0x72

    const-string v2, "cat"

    aput-object v2, v0, v1

    const/16 v1, 0x73

    const-string v2, "catering"

    aput-object v2, v0, v1

    const/16 v1, 0x74

    const-string v2, "cba"

    aput-object v2, v0, v1

    const/16 v1, 0x75

    const-string v2, "cbn"

    aput-object v2, v0, v1

    const/16 v1, 0x76

    const-string v2, "ceb"

    aput-object v2, v0, v1

    const/16 v1, 0x77

    const-string v2, "center"

    aput-object v2, v0, v1

    const/16 v1, 0x78

    const-string v2, "ceo"

    aput-object v2, v0, v1

    const/16 v1, 0x79

    const-string v2, "cern"

    aput-object v2, v0, v1

    const/16 v1, 0x7a

    const-string v2, "cfa"

    aput-object v2, v0, v1

    const/16 v1, 0x7b

    const-string v2, "cfd"

    aput-object v2, v0, v1

    const/16 v1, 0x7c

    const-string v2, "chanel"

    aput-object v2, v0, v1

    const/16 v1, 0x7d

    const-string v2, "channel"

    aput-object v2, v0, v1

    const/16 v1, 0x7e

    const-string v2, "chat"

    aput-object v2, v0, v1

    const/16 v1, 0x7f

    const-string v2, "cheap"

    aput-object v2, v0, v1

    const/16 v1, 0x80

    const-string v2, "chloe"

    aput-object v2, v0, v1

    const/16 v1, 0x81

    const-string v2, "christmas"

    aput-object v2, v0, v1

    const/16 v1, 0x82

    const-string v2, "chrome"

    aput-object v2, v0, v1

    const/16 v1, 0x83

    const-string v2, "church"

    aput-object v2, v0, v1

    const/16 v1, 0x84

    const-string v2, "cipriani"

    aput-object v2, v0, v1

    const/16 v1, 0x85

    const-string v2, "cisco"

    aput-object v2, v0, v1

    const/16 v1, 0x86

    const-string v2, "citic"

    aput-object v2, v0, v1

    const/16 v1, 0x87

    const-string v2, "city"

    aput-object v2, v0, v1

    const/16 v1, 0x88

    const-string v2, "claims"

    aput-object v2, v0, v1

    const/16 v1, 0x89

    const-string v2, "cleaning"

    aput-object v2, v0, v1

    const/16 v1, 0x8a

    const-string v2, "click"

    aput-object v2, v0, v1

    const/16 v1, 0x8b

    const-string v2, "clinic"

    aput-object v2, v0, v1

    const/16 v1, 0x8c

    const-string v2, "clothing"

    aput-object v2, v0, v1

    const/16 v1, 0x8d

    const-string v2, "cloud"

    aput-object v2, v0, v1

    const/16 v1, 0x8e

    const-string v2, "club"

    aput-object v2, v0, v1

    const/16 v1, 0x8f

    const-string v2, "clubmed"

    aput-object v2, v0, v1

    const/16 v1, 0x90

    const-string v2, "coach"

    aput-object v2, v0, v1

    const/16 v1, 0x91

    const-string v2, "codes"

    aput-object v2, v0, v1

    const/16 v1, 0x92

    const-string v2, "coffee"

    aput-object v2, v0, v1

    const/16 v1, 0x93

    const-string v2, "college"

    aput-object v2, v0, v1

    const/16 v1, 0x94

    const-string v2, "cologne"

    aput-object v2, v0, v1

    const/16 v1, 0x95

    const-string v2, "com"

    aput-object v2, v0, v1

    const/16 v1, 0x96

    const-string v2, "commbank"

    aput-object v2, v0, v1

    const/16 v1, 0x97

    const-string v2, "community"

    aput-object v2, v0, v1

    const/16 v1, 0x98

    const-string v2, "company"

    aput-object v2, v0, v1

    const/16 v1, 0x99

    const-string v2, "computer"

    aput-object v2, v0, v1

    const/16 v1, 0x9a

    const-string v2, "condos"

    aput-object v2, v0, v1

    const/16 v1, 0x9b

    const-string v2, "construction"

    aput-object v2, v0, v1

    const/16 v1, 0x9c

    const-string v2, "consulting"

    aput-object v2, v0, v1

    const/16 v1, 0x9d

    const-string v2, "contractors"

    aput-object v2, v0, v1

    const/16 v1, 0x9e

    const-string v2, "cooking"

    aput-object v2, v0, v1

    const/16 v1, 0x9f

    const-string v2, "cool"

    aput-object v2, v0, v1

    const/16 v1, 0xa0

    const-string v2, "coop"

    aput-object v2, v0, v1

    const/16 v1, 0xa1

    const-string v2, "corsica"

    aput-object v2, v0, v1

    const/16 v1, 0xa2

    const-string v2, "country"

    aput-object v2, v0, v1

    const/16 v1, 0xa3

    const-string v2, "coupons"

    aput-object v2, v0, v1

    const/16 v1, 0xa4

    const-string v2, "courses"

    aput-object v2, v0, v1

    const/16 v1, 0xa5

    const-string v2, "credit"

    aput-object v2, v0, v1

    const/16 v1, 0xa6

    const-string v2, "creditcard"

    aput-object v2, v0, v1

    const/16 v1, 0xa7

    const-string v2, "cricket"

    aput-object v2, v0, v1

    const/16 v1, 0xa8

    const-string v2, "crown"

    aput-object v2, v0, v1

    const/16 v1, 0xa9

    const-string v2, "crs"

    aput-object v2, v0, v1

    const/16 v1, 0xaa

    const-string v2, "cruises"

    aput-object v2, v0, v1

    const/16 v1, 0xab

    const-string v2, "csc"

    aput-object v2, v0, v1

    const/16 v1, 0xac

    const-string v2, "cuisinella"

    aput-object v2, v0, v1

    const/16 v1, 0xad

    const-string v2, "cymru"

    aput-object v2, v0, v1

    const/16 v1, 0xae

    const-string v2, "cyou"

    aput-object v2, v0, v1

    const/16 v1, 0xaf

    const-string v2, "dabur"

    aput-object v2, v0, v1

    const/16 v1, 0xb0

    const-string v2, "dad"

    aput-object v2, v0, v1

    const/16 v1, 0xb1

    const-string v2, "dance"

    aput-object v2, v0, v1

    const/16 v1, 0xb2

    const-string v2, "date"

    aput-object v2, v0, v1

    const/16 v1, 0xb3

    const-string v2, "dating"

    aput-object v2, v0, v1

    const/16 v1, 0xb4

    const-string v2, "datsun"

    aput-object v2, v0, v1

    const/16 v1, 0xb5

    const-string v2, "day"

    aput-object v2, v0, v1

    const/16 v1, 0xb6

    const-string v2, "dclk"

    aput-object v2, v0, v1

    const/16 v1, 0xb7

    const-string v2, "deals"

    aput-object v2, v0, v1

    const/16 v1, 0xb8

    const-string v2, "degree"

    aput-object v2, v0, v1

    const/16 v1, 0xb9

    const-string v2, "delivery"

    aput-object v2, v0, v1

    const/16 v1, 0xba

    const-string v2, "dell"

    aput-object v2, v0, v1

    const/16 v1, 0xbb

    const-string v2, "delta"

    aput-object v2, v0, v1

    const/16 v1, 0xbc

    const-string v2, "democrat"

    aput-object v2, v0, v1

    const/16 v1, 0xbd

    const-string v2, "dental"

    aput-object v2, v0, v1

    const/16 v1, 0xbe

    const-string v2, "dentist"

    aput-object v2, v0, v1

    const/16 v1, 0xbf

    const-string v2, "desi"

    aput-object v2, v0, v1

    const/16 v1, 0xc0

    const-string v2, "design"

    aput-object v2, v0, v1

    const/16 v1, 0xc1

    const-string v2, "dev"

    aput-object v2, v0, v1

    const/16 v1, 0xc2

    const-string v2, "diamonds"

    aput-object v2, v0, v1

    const/16 v1, 0xc3

    const-string v2, "diet"

    aput-object v2, v0, v1

    const/16 v1, 0xc4

    const-string v2, "digital"

    aput-object v2, v0, v1

    const/16 v1, 0xc5

    const-string v2, "direct"

    aput-object v2, v0, v1

    const/16 v1, 0xc6

    const-string v2, "directory"

    aput-object v2, v0, v1

    const/16 v1, 0xc7

    const-string v2, "discount"

    aput-object v2, v0, v1

    const/16 v1, 0xc8

    const-string v2, "dnp"

    aput-object v2, v0, v1

    const/16 v1, 0xc9

    const-string v2, "docs"

    aput-object v2, v0, v1

    const/16 v1, 0xca

    const-string v2, "dog"

    aput-object v2, v0, v1

    const/16 v1, 0xcb

    const-string v2, "doha"

    aput-object v2, v0, v1

    const/16 v1, 0xcc

    const-string v2, "domains"

    aput-object v2, v0, v1

    const/16 v1, 0xcd

    const-string v2, "doosan"

    aput-object v2, v0, v1

    const/16 v1, 0xce

    const-string v2, "download"

    aput-object v2, v0, v1

    const/16 v1, 0xcf

    const-string v2, "drive"

    aput-object v2, v0, v1

    const/16 v1, 0xd0

    const-string v2, "durban"

    aput-object v2, v0, v1

    const/16 v1, 0xd1

    const-string v2, "dvag"

    aput-object v2, v0, v1

    const/16 v1, 0xd2

    const-string v2, "earth"

    aput-object v2, v0, v1

    const/16 v1, 0xd3

    const-string v2, "eat"

    aput-object v2, v0, v1

    const/16 v1, 0xd4

    const-string v2, "edu"

    aput-object v2, v0, v1

    const/16 v1, 0xd5

    const-string v2, "education"

    aput-object v2, v0, v1

    const/16 v1, 0xd6

    const-string v2, "email"

    aput-object v2, v0, v1

    const/16 v1, 0xd7

    const-string v2, "emerck"

    aput-object v2, v0, v1

    const/16 v1, 0xd8

    const-string v2, "energy"

    aput-object v2, v0, v1

    const/16 v1, 0xd9

    const-string v2, "engineer"

    aput-object v2, v0, v1

    const/16 v1, 0xda

    const-string v2, "engineering"

    aput-object v2, v0, v1

    const/16 v1, 0xdb

    const-string v2, "enterprises"

    aput-object v2, v0, v1

    const/16 v1, 0xdc

    const-string v2, "epson"

    aput-object v2, v0, v1

    const/16 v1, 0xdd

    const-string v2, "equipment"

    aput-object v2, v0, v1

    const/16 v1, 0xde

    const-string v2, "erni"

    aput-object v2, v0, v1

    const/16 v1, 0xdf

    const-string v2, "esq"

    aput-object v2, v0, v1

    const/16 v1, 0xe0

    const-string v2, "estate"

    aput-object v2, v0, v1

    const/16 v1, 0xe1

    const-string v2, "eurovision"

    aput-object v2, v0, v1

    const/16 v1, 0xe2

    const-string v2, "eus"

    aput-object v2, v0, v1

    const/16 v1, 0xe3

    const-string v2, "events"

    aput-object v2, v0, v1

    const/16 v1, 0xe4

    const-string v2, "everbank"

    aput-object v2, v0, v1

    const/16 v1, 0xe5

    const-string v2, "exchange"

    aput-object v2, v0, v1

    const/16 v1, 0xe6

    const-string v2, "expert"

    aput-object v2, v0, v1

    const/16 v1, 0xe7

    const-string v2, "exposed"

    aput-object v2, v0, v1

    const/16 v1, 0xe8

    const-string v2, "express"

    aput-object v2, v0, v1

    const/16 v1, 0xe9

    const-string v2, "fage"

    aput-object v2, v0, v1

    const/16 v1, 0xea

    const-string v2, "fail"

    aput-object v2, v0, v1

    const/16 v1, 0xeb

    const-string v2, "faith"

    aput-object v2, v0, v1

    const/16 v1, 0xec

    const-string v2, "family"

    aput-object v2, v0, v1

    const/16 v1, 0xed

    const-string v2, "fan"

    aput-object v2, v0, v1

    const/16 v1, 0xee

    const-string v2, "fans"

    aput-object v2, v0, v1

    const/16 v1, 0xef

    const-string v2, "farm"

    aput-object v2, v0, v1

    const/16 v1, 0xf0

    const-string v2, "fashion"

    aput-object v2, v0, v1

    const/16 v1, 0xf1

    const-string v2, "feedback"

    aput-object v2, v0, v1

    const/16 v1, 0xf2

    const-string v2, "ferrero"

    aput-object v2, v0, v1

    const/16 v1, 0xf3

    const-string v2, "film"

    aput-object v2, v0, v1

    const/16 v1, 0xf4

    const-string v2, "final"

    aput-object v2, v0, v1

    const/16 v1, 0xf5

    const-string v2, "finance"

    aput-object v2, v0, v1

    const/16 v1, 0xf6

    const-string v2, "financial"

    aput-object v2, v0, v1

    const/16 v1, 0xf7

    const-string v2, "firmdale"

    aput-object v2, v0, v1

    const/16 v1, 0xf8

    const-string v2, "fish"

    aput-object v2, v0, v1

    const/16 v1, 0xf9

    const-string v2, "fishing"

    aput-object v2, v0, v1

    const/16 v1, 0xfa

    const-string v2, "fit"

    aput-object v2, v0, v1

    const/16 v1, 0xfb

    const-string v2, "fitness"

    aput-object v2, v0, v1

    const/16 v1, 0xfc

    const-string v2, "flights"

    aput-object v2, v0, v1

    const/16 v1, 0xfd

    const-string v2, "florist"

    aput-object v2, v0, v1

    const/16 v1, 0xfe

    const-string v2, "flowers"

    aput-object v2, v0, v1

    const/16 v1, 0xff

    const-string v2, "flsmidth"

    aput-object v2, v0, v1

    const/16 v1, 0x100

    const-string v2, "fly"

    aput-object v2, v0, v1

    const/16 v1, 0x101

    const-string v2, "foo"

    aput-object v2, v0, v1

    const/16 v1, 0x102

    const-string v2, "football"

    aput-object v2, v0, v1

    const/16 v1, 0x103

    const-string v2, "forex"

    aput-object v2, v0, v1

    const/16 v1, 0x104

    const-string v2, "forsale"

    aput-object v2, v0, v1

    const/16 v1, 0x105

    const-string v2, "forum"

    aput-object v2, v0, v1

    const/16 v1, 0x106

    const-string v2, "foundation"

    aput-object v2, v0, v1

    const/16 v1, 0x107

    const-string v2, "frl"

    aput-object v2, v0, v1

    const/16 v1, 0x108

    const-string v2, "frogans"

    aput-object v2, v0, v1

    const/16 v1, 0x109

    const-string v2, "fund"

    aput-object v2, v0, v1

    const/16 v1, 0x10a

    const-string v2, "furniture"

    aput-object v2, v0, v1

    const/16 v1, 0x10b

    const-string v2, "futbol"

    aput-object v2, v0, v1

    const/16 v1, 0x10c

    const-string v2, "fyi"

    aput-object v2, v0, v1

    const/16 v1, 0x10d

    const-string v2, "gal"

    aput-object v2, v0, v1

    const/16 v1, 0x10e

    const-string v2, "gallery"

    aput-object v2, v0, v1

    const/16 v1, 0x10f

    const-string v2, "game"

    aput-object v2, v0, v1

    const/16 v1, 0x110

    const-string v2, "garden"

    aput-object v2, v0, v1

    const/16 v1, 0x111

    const-string v2, "gbiz"

    aput-object v2, v0, v1

    const/16 v1, 0x112

    const-string v2, "gdn"

    aput-object v2, v0, v1

    const/16 v1, 0x113

    const-string v2, "gea"

    aput-object v2, v0, v1

    const/16 v1, 0x114

    const-string v2, "gent"

    aput-object v2, v0, v1

    const/16 v1, 0x115

    const-string v2, "genting"

    aput-object v2, v0, v1

    const/16 v1, 0x116

    const-string v2, "ggee"

    aput-object v2, v0, v1

    const/16 v1, 0x117

    const-string v2, "gift"

    aput-object v2, v0, v1

    const/16 v1, 0x118

    const-string v2, "gifts"

    aput-object v2, v0, v1

    const/16 v1, 0x119

    const-string v2, "gives"

    aput-object v2, v0, v1

    const/16 v1, 0x11a

    const-string v2, "giving"

    aput-object v2, v0, v1

    const/16 v1, 0x11b

    const-string v2, "glass"

    aput-object v2, v0, v1

    const/16 v1, 0x11c

    const-string v2, "gle"

    aput-object v2, v0, v1

    const/16 v1, 0x11d

    const-string v2, "global"

    aput-object v2, v0, v1

    const/16 v1, 0x11e

    const-string v2, "globo"

    aput-object v2, v0, v1

    const/16 v1, 0x11f

    const-string v2, "gmail"

    aput-object v2, v0, v1

    const/16 v1, 0x120

    const-string v2, "gmo"

    aput-object v2, v0, v1

    const/16 v1, 0x121

    const-string v2, "gmx"

    aput-object v2, v0, v1

    const/16 v1, 0x122

    const-string v2, "gold"

    aput-object v2, v0, v1

    const/16 v1, 0x123

    const-string v2, "goldpoint"

    aput-object v2, v0, v1

    const/16 v1, 0x124

    const-string v2, "golf"

    aput-object v2, v0, v1

    const/16 v1, 0x125

    const-string v2, "goo"

    aput-object v2, v0, v1

    const/16 v1, 0x126

    const-string v2, "goog"

    aput-object v2, v0, v1

    const/16 v1, 0x127

    const-string v2, "google"

    aput-object v2, v0, v1

    const/16 v1, 0x128

    const-string v2, "gop"

    aput-object v2, v0, v1

    const/16 v1, 0x129

    const-string v2, "gov"

    aput-object v2, v0, v1

    const/16 v1, 0x12a

    const-string v2, "graphics"

    aput-object v2, v0, v1

    const/16 v1, 0x12b

    const-string v2, "gratis"

    aput-object v2, v0, v1

    const/16 v1, 0x12c

    const-string v2, "green"

    aput-object v2, v0, v1

    const/16 v1, 0x12d

    const-string v2, "gripe"

    aput-object v2, v0, v1

    const/16 v1, 0x12e

    const-string v2, "group"

    aput-object v2, v0, v1

    const/16 v1, 0x12f

    const-string v2, "gucci"

    aput-object v2, v0, v1

    const/16 v1, 0x130

    const-string v2, "guge"

    aput-object v2, v0, v1

    const/16 v1, 0x131

    const-string v2, "guide"

    aput-object v2, v0, v1

    const/16 v1, 0x132

    const-string v2, "guitars"

    aput-object v2, v0, v1

    const/16 v1, 0x133

    const-string v2, "guru"

    aput-object v2, v0, v1

    const/16 v1, 0x134

    const-string v2, "hamburg"

    aput-object v2, v0, v1

    const/16 v1, 0x135

    const-string v2, "hangout"

    aput-object v2, v0, v1

    const/16 v1, 0x136

    const-string v2, "haus"

    aput-object v2, v0, v1

    const/16 v1, 0x137

    const-string v2, "healthcare"

    aput-object v2, v0, v1

    const/16 v1, 0x138

    const-string v2, "help"

    aput-object v2, v0, v1

    const/16 v1, 0x139

    const-string v2, "here"

    aput-object v2, v0, v1

    const/16 v1, 0x13a

    const-string v2, "hermes"

    aput-object v2, v0, v1

    const/16 v1, 0x13b

    const-string v2, "hiphop"

    aput-object v2, v0, v1

    const/16 v1, 0x13c

    const-string v2, "hitachi"

    aput-object v2, v0, v1

    const/16 v1, 0x13d

    const-string v2, "hiv"

    aput-object v2, v0, v1

    const/16 v1, 0x13e

    const-string v2, "hockey"

    aput-object v2, v0, v1

    const/16 v1, 0x13f

    const-string v2, "holdings"

    aput-object v2, v0, v1

    const/16 v1, 0x140

    const-string v2, "holiday"

    aput-object v2, v0, v1

    const/16 v1, 0x141

    const-string v2, "homedepot"

    aput-object v2, v0, v1

    const/16 v1, 0x142

    const-string v2, "homes"

    aput-object v2, v0, v1

    const/16 v1, 0x143

    const-string v2, "honda"

    aput-object v2, v0, v1

    const/16 v1, 0x144

    const-string v2, "horse"

    aput-object v2, v0, v1

    const/16 v1, 0x145

    const-string v2, "host"

    aput-object v2, v0, v1

    const/16 v1, 0x146

    const-string v2, "hosting"

    aput-object v2, v0, v1

    const/16 v1, 0x147

    const-string v2, "hoteles"

    aput-object v2, v0, v1

    const/16 v1, 0x148

    const-string v2, "hotmail"

    aput-object v2, v0, v1

    const/16 v1, 0x149

    const-string v2, "house"

    aput-object v2, v0, v1

    const/16 v1, 0x14a

    const-string v2, "how"

    aput-object v2, v0, v1

    const/16 v1, 0x14b

    const-string v2, "hsbc"

    aput-object v2, v0, v1

    const/16 v1, 0x14c

    const-string v2, "hyundai"

    aput-object v2, v0, v1

    const/16 v1, 0x14d

    const-string v2, "ibm"

    aput-object v2, v0, v1

    const/16 v1, 0x14e

    const-string v2, "icbc"

    aput-object v2, v0, v1

    const/16 v1, 0x14f

    const-string v2, "ice"

    aput-object v2, v0, v1

    const/16 v1, 0x150

    const-string v2, "icu"

    aput-object v2, v0, v1

    const/16 v1, 0x151

    const-string v2, "ifm"

    aput-object v2, v0, v1

    const/16 v1, 0x152

    const-string v2, "iinet"

    aput-object v2, v0, v1

    const/16 v1, 0x153

    const-string v2, "immo"

    aput-object v2, v0, v1

    const/16 v1, 0x154

    const-string v2, "immobilien"

    aput-object v2, v0, v1

    const/16 v1, 0x155

    const-string v2, "industries"

    aput-object v2, v0, v1

    const/16 v1, 0x156

    const-string v2, "infiniti"

    aput-object v2, v0, v1

    const/16 v1, 0x157

    const-string v2, "info"

    aput-object v2, v0, v1

    const/16 v1, 0x158

    const-string v2, "ing"

    aput-object v2, v0, v1

    const/16 v1, 0x159

    const-string v2, "ink"

    aput-object v2, v0, v1

    const/16 v1, 0x15a

    const-string v2, "institute"

    aput-object v2, v0, v1

    const/16 v1, 0x15b

    const-string v2, "insure"

    aput-object v2, v0, v1

    const/16 v1, 0x15c

    const-string v2, "int"

    aput-object v2, v0, v1

    const/16 v1, 0x15d

    const-string v2, "international"

    aput-object v2, v0, v1

    const/16 v1, 0x15e

    const-string v2, "investments"

    aput-object v2, v0, v1

    const/16 v1, 0x15f

    const-string v2, "ipiranga"

    aput-object v2, v0, v1

    const/16 v1, 0x160

    const-string v2, "irish"

    aput-object v2, v0, v1

    const/16 v1, 0x161

    const-string v2, "ist"

    aput-object v2, v0, v1

    const/16 v1, 0x162

    const-string v2, "istanbul"

    aput-object v2, v0, v1

    const/16 v1, 0x163

    const-string v2, "itau"

    aput-object v2, v0, v1

    const/16 v1, 0x164

    const-string v2, "iwc"

    aput-object v2, v0, v1

    const/16 v1, 0x165

    const-string v2, "jaguar"

    aput-object v2, v0, v1

    const/16 v1, 0x166

    const-string v2, "java"

    aput-object v2, v0, v1

    const/16 v1, 0x167

    const-string v2, "jcb"

    aput-object v2, v0, v1

    const/16 v1, 0x168

    const-string v2, "jetzt"

    aput-object v2, v0, v1

    const/16 v1, 0x169

    const-string v2, "jewelry"

    aput-object v2, v0, v1

    const/16 v1, 0x16a

    const-string v2, "jlc"

    aput-object v2, v0, v1

    const/16 v1, 0x16b

    const-string v2, "jll"

    aput-object v2, v0, v1

    const/16 v1, 0x16c

    const-string v2, "jobs"

    aput-object v2, v0, v1

    const/16 v1, 0x16d

    const-string v2, "joburg"

    aput-object v2, v0, v1

    const/16 v1, 0x16e

    const-string v2, "jprs"

    aput-object v2, v0, v1

    const/16 v1, 0x16f

    const-string v2, "juegos"

    aput-object v2, v0, v1

    const/16 v1, 0x170

    const-string v2, "kaufen"

    aput-object v2, v0, v1

    const/16 v1, 0x171

    const-string v2, "kddi"

    aput-object v2, v0, v1

    const/16 v1, 0x172

    const-string v2, "kia"

    aput-object v2, v0, v1

    const/16 v1, 0x173

    const-string v2, "kim"

    aput-object v2, v0, v1

    const/16 v1, 0x174

    const-string v2, "kinder"

    aput-object v2, v0, v1

    const/16 v1, 0x175

    const-string v2, "kitchen"

    aput-object v2, v0, v1

    const/16 v1, 0x176

    const-string v2, "kiwi"

    aput-object v2, v0, v1

    const/16 v1, 0x177

    const-string v2, "koeln"

    aput-object v2, v0, v1

    const/16 v1, 0x178

    const-string v2, "komatsu"

    aput-object v2, v0, v1

    const/16 v1, 0x179

    const-string v2, "krd"

    aput-object v2, v0, v1

    const/16 v1, 0x17a

    const-string v2, "kred"

    aput-object v2, v0, v1

    const/16 v1, 0x17b

    const-string v2, "kyoto"

    aput-object v2, v0, v1

    const/16 v1, 0x17c

    const-string v2, "lacaixa"

    aput-object v2, v0, v1

    const/16 v1, 0x17d

    const-string v2, "lancaster"

    aput-object v2, v0, v1

    const/16 v1, 0x17e

    const-string v2, "land"

    aput-object v2, v0, v1

    const/16 v1, 0x17f

    const-string v2, "landrover"

    aput-object v2, v0, v1

    const/16 v1, 0x180

    const-string v2, "lasalle"

    aput-object v2, v0, v1

    const/16 v1, 0x181

    const-string v2, "lat"

    aput-object v2, v0, v1

    const/16 v1, 0x182

    const-string v2, "latrobe"

    aput-object v2, v0, v1

    const/16 v1, 0x183

    const-string v2, "law"

    aput-object v2, v0, v1

    const/16 v1, 0x184

    const-string v2, "lawyer"

    aput-object v2, v0, v1

    const/16 v1, 0x185

    const-string v2, "lds"

    aput-object v2, v0, v1

    const/16 v1, 0x186

    const-string v2, "lease"

    aput-object v2, v0, v1

    const/16 v1, 0x187

    const-string v2, "leclerc"

    aput-object v2, v0, v1

    const/16 v1, 0x188

    const-string v2, "legal"

    aput-object v2, v0, v1

    const/16 v1, 0x189

    const-string v2, "lexus"

    aput-object v2, v0, v1

    const/16 v1, 0x18a

    const-string v2, "lgbt"

    aput-object v2, v0, v1

    const/16 v1, 0x18b

    const-string v2, "liaison"

    aput-object v2, v0, v1

    const/16 v1, 0x18c

    const-string v2, "lidl"

    aput-object v2, v0, v1

    const/16 v1, 0x18d

    const-string v2, "life"

    aput-object v2, v0, v1

    const/16 v1, 0x18e

    const-string v2, "lighting"

    aput-object v2, v0, v1

    const/16 v1, 0x18f

    const-string v2, "limited"

    aput-object v2, v0, v1

    const/16 v1, 0x190

    const-string v2, "limo"

    aput-object v2, v0, v1

    const/16 v1, 0x191

    const-string v2, "linde"

    aput-object v2, v0, v1

    const/16 v1, 0x192

    const-string v2, "link"

    aput-object v2, v0, v1

    const/16 v1, 0x193

    const-string v2, "live"

    aput-object v2, v0, v1

    const/16 v1, 0x194

    const-string v2, "lixil"

    aput-object v2, v0, v1

    const/16 v1, 0x195

    const-string v2, "loan"

    aput-object v2, v0, v1

    const/16 v1, 0x196

    const-string v2, "loans"

    aput-object v2, v0, v1

    const/16 v1, 0x197

    const-string v2, "lol"

    aput-object v2, v0, v1

    const/16 v1, 0x198

    const-string v2, "london"

    aput-object v2, v0, v1

    const/16 v1, 0x199

    const-string v2, "lotte"

    aput-object v2, v0, v1

    const/16 v1, 0x19a

    const-string v2, "lotto"

    aput-object v2, v0, v1

    const/16 v1, 0x19b

    const-string v2, "love"

    aput-object v2, v0, v1

    const/16 v1, 0x19c

    const-string v2, "ltd"

    aput-object v2, v0, v1

    const/16 v1, 0x19d

    const-string v2, "ltda"

    aput-object v2, v0, v1

    const/16 v1, 0x19e

    const-string v2, "lupin"

    aput-object v2, v0, v1

    const/16 v1, 0x19f

    const-string v2, "luxe"

    aput-object v2, v0, v1

    const/16 v1, 0x1a0

    const-string v2, "luxury"

    aput-object v2, v0, v1

    const/16 v1, 0x1a1

    const-string v2, "madrid"

    aput-object v2, v0, v1

    const/16 v1, 0x1a2

    const-string v2, "maif"

    aput-object v2, v0, v1

    const/16 v1, 0x1a3

    const-string v2, "maison"

    aput-object v2, v0, v1

    const/16 v1, 0x1a4

    const-string v2, "man"

    aput-object v2, v0, v1

    const/16 v1, 0x1a5

    const-string v2, "management"

    aput-object v2, v0, v1

    const/16 v1, 0x1a6

    const-string v2, "mango"

    aput-object v2, v0, v1

    const/16 v1, 0x1a7

    const-string v2, "market"

    aput-object v2, v0, v1

    const/16 v1, 0x1a8

    const-string v2, "marketing"

    aput-object v2, v0, v1

    const/16 v1, 0x1a9

    const-string v2, "markets"

    aput-object v2, v0, v1

    const/16 v1, 0x1aa

    const-string v2, "marriott"

    aput-object v2, v0, v1

    const/16 v1, 0x1ab

    const-string v2, "mba"

    aput-object v2, v0, v1

    const/16 v1, 0x1ac

    const-string v2, "media"

    aput-object v2, v0, v1

    const/16 v1, 0x1ad

    const-string v2, "meet"

    aput-object v2, v0, v1

    const/16 v1, 0x1ae

    const-string v2, "melbourne"

    aput-object v2, v0, v1

    const/16 v1, 0x1af

    const-string v2, "meme"

    aput-object v2, v0, v1

    const/16 v1, 0x1b0

    const-string v2, "memorial"

    aput-object v2, v0, v1

    const/16 v1, 0x1b1

    const-string v2, "men"

    aput-object v2, v0, v1

    const/16 v1, 0x1b2

    const-string v2, "menu"

    aput-object v2, v0, v1

    const/16 v1, 0x1b3

    const-string v2, "meo"

    aput-object v2, v0, v1

    const/16 v1, 0x1b4

    const-string v2, "miami"

    aput-object v2, v0, v1

    const/16 v1, 0x1b5

    const-string v2, "microsoft"

    aput-object v2, v0, v1

    const/16 v1, 0x1b6

    const-string v2, "mil"

    aput-object v2, v0, v1

    const/16 v1, 0x1b7

    const-string v2, "mini"

    aput-object v2, v0, v1

    const/16 v1, 0x1b8

    const-string v2, "mma"

    aput-object v2, v0, v1

    const/16 v1, 0x1b9

    const-string v2, "mobi"

    aput-object v2, v0, v1

    const/16 v1, 0x1ba

    const-string v2, "moda"

    aput-object v2, v0, v1

    const/16 v1, 0x1bb

    const-string v2, "moe"

    aput-object v2, v0, v1

    const/16 v1, 0x1bc

    const-string v2, "moi"

    aput-object v2, v0, v1

    const/16 v1, 0x1bd

    const-string v2, "mom"

    aput-object v2, v0, v1

    const/16 v1, 0x1be

    const-string v2, "monash"

    aput-object v2, v0, v1

    const/16 v1, 0x1bf

    const-string v2, "money"

    aput-object v2, v0, v1

    const/16 v1, 0x1c0

    const-string v2, "montblanc"

    aput-object v2, v0, v1

    const/16 v1, 0x1c1

    const-string v2, "mormon"

    aput-object v2, v0, v1

    const/16 v1, 0x1c2

    const-string v2, "mortgage"

    aput-object v2, v0, v1

    const/16 v1, 0x1c3

    const-string v2, "moscow"

    aput-object v2, v0, v1

    const/16 v1, 0x1c4

    const-string v2, "motorcycles"

    aput-object v2, v0, v1

    const/16 v1, 0x1c5

    const-string v2, "mov"

    aput-object v2, v0, v1

    const/16 v1, 0x1c6

    const-string v2, "movie"

    aput-object v2, v0, v1

    const/16 v1, 0x1c7

    const-string v2, "movistar"

    aput-object v2, v0, v1

    const/16 v1, 0x1c8

    const-string v2, "mtn"

    aput-object v2, v0, v1

    const/16 v1, 0x1c9

    const-string v2, "mtpc"

    aput-object v2, v0, v1

    const/16 v1, 0x1ca

    const-string v2, "mtr"

    aput-object v2, v0, v1

    const/16 v1, 0x1cb

    const-string v2, "museum"

    aput-object v2, v0, v1

    const/16 v1, 0x1cc

    const-string v2, "mutuelle"

    aput-object v2, v0, v1

    const/16 v1, 0x1cd

    const-string v2, "nadex"

    aput-object v2, v0, v1

    const/16 v1, 0x1ce

    const-string v2, "nagoya"

    aput-object v2, v0, v1

    const/16 v1, 0x1cf

    const-string v2, "name"

    aput-object v2, v0, v1

    const/16 v1, 0x1d0

    const-string v2, "navy"

    aput-object v2, v0, v1

    const/16 v1, 0x1d1

    const-string v2, "nec"

    aput-object v2, v0, v1

    const/16 v1, 0x1d2

    const-string v2, "net"

    aput-object v2, v0, v1

    const/16 v1, 0x1d3

    const-string v2, "netbank"

    aput-object v2, v0, v1

    const/16 v1, 0x1d4

    const-string v2, "network"

    aput-object v2, v0, v1

    const/16 v1, 0x1d5

    const-string v2, "neustar"

    aput-object v2, v0, v1

    const/16 v1, 0x1d6

    const-string v2, "new"

    aput-object v2, v0, v1

    const/16 v1, 0x1d7

    const-string v2, "news"

    aput-object v2, v0, v1

    const/16 v1, 0x1d8

    const-string v2, "nexus"

    aput-object v2, v0, v1

    const/16 v1, 0x1d9

    const-string v2, "ngo"

    aput-object v2, v0, v1

    const/16 v1, 0x1da

    const-string v2, "nhk"

    aput-object v2, v0, v1

    const/16 v1, 0x1db

    const-string v2, "nico"

    aput-object v2, v0, v1

    const/16 v1, 0x1dc

    const-string v2, "ninja"

    aput-object v2, v0, v1

    const/16 v1, 0x1dd

    const-string v2, "nissan"

    aput-object v2, v0, v1

    const/16 v1, 0x1de

    const-string v2, "nokia"

    aput-object v2, v0, v1

    const/16 v1, 0x1df

    const-string v2, "nra"

    aput-object v2, v0, v1

    const/16 v1, 0x1e0

    const-string v2, "nrw"

    aput-object v2, v0, v1

    const/16 v1, 0x1e1

    const-string v2, "ntt"

    aput-object v2, v0, v1

    const/16 v1, 0x1e2

    const-string v2, "nyc"

    aput-object v2, v0, v1

    const/16 v1, 0x1e3

    const-string v2, "obi"

    aput-object v2, v0, v1

    const/16 v1, 0x1e4

    const-string v2, "office"

    aput-object v2, v0, v1

    const/16 v1, 0x1e5

    const-string v2, "okinawa"

    aput-object v2, v0, v1

    const/16 v1, 0x1e6

    const-string v2, "omega"

    aput-object v2, v0, v1

    const/16 v1, 0x1e7

    const-string v2, "one"

    aput-object v2, v0, v1

    const/16 v1, 0x1e8

    const-string v2, "ong"

    aput-object v2, v0, v1

    const/16 v1, 0x1e9

    const-string v2, "onl"

    aput-object v2, v0, v1

    const/16 v1, 0x1ea

    const-string v2, "online"

    aput-object v2, v0, v1

    const/16 v1, 0x1eb

    const-string v2, "ooo"

    aput-object v2, v0, v1

    const/16 v1, 0x1ec

    const-string v2, "oracle"

    aput-object v2, v0, v1

    const/16 v1, 0x1ed

    const-string v2, "orange"

    aput-object v2, v0, v1

    const/16 v1, 0x1ee

    const-string v2, "org"

    aput-object v2, v0, v1

    const/16 v1, 0x1ef

    const-string v2, "organic"

    aput-object v2, v0, v1

    const/16 v1, 0x1f0

    const-string v2, "osaka"

    aput-object v2, v0, v1

    const/16 v1, 0x1f1

    const-string v2, "otsuka"

    aput-object v2, v0, v1

    const/16 v1, 0x1f2

    const-string v2, "ovh"

    aput-object v2, v0, v1

    const/16 v1, 0x1f3

    const-string v2, "page"

    aput-object v2, v0, v1

    const/16 v1, 0x1f4

    const-string v2, "panerai"

    aput-object v2, v0, v1

    const/16 v1, 0x1f5

    const-string v2, "paris"

    aput-object v2, v0, v1

    const/16 v1, 0x1f6

    const-string v2, "partners"

    aput-object v2, v0, v1

    const/16 v1, 0x1f7

    const-string v2, "parts"

    aput-object v2, v0, v1

    const/16 v1, 0x1f8

    const-string v2, "party"

    aput-object v2, v0, v1

    const/16 v1, 0x1f9

    const-string v2, "pet"

    aput-object v2, v0, v1

    const/16 v1, 0x1fa

    const-string v2, "pharmacy"

    aput-object v2, v0, v1

    const/16 v1, 0x1fb

    const-string v2, "philips"

    aput-object v2, v0, v1

    const/16 v1, 0x1fc

    const-string v2, "photo"

    aput-object v2, v0, v1

    const/16 v1, 0x1fd

    const-string v2, "photography"

    aput-object v2, v0, v1

    const/16 v1, 0x1fe

    const-string v2, "photos"

    aput-object v2, v0, v1

    const/16 v1, 0x1ff

    const-string v2, "physio"

    aput-object v2, v0, v1

    const/16 v1, 0x200

    const-string v2, "piaget"

    aput-object v2, v0, v1

    const/16 v1, 0x201

    const-string v2, "pics"

    aput-object v2, v0, v1

    const/16 v1, 0x202

    const-string v2, "pictet"

    aput-object v2, v0, v1

    const/16 v1, 0x203

    const-string v2, "pictures"

    aput-object v2, v0, v1

    const/16 v1, 0x204

    const-string v2, "ping"

    aput-object v2, v0, v1

    const/16 v1, 0x205

    const-string v2, "pink"

    aput-object v2, v0, v1

    const/16 v1, 0x206

    const-string v2, "pizza"

    aput-object v2, v0, v1

    const/16 v1, 0x207

    const-string v2, "place"

    aput-object v2, v0, v1

    const/16 v1, 0x208

    const-string v2, "play"

    aput-object v2, v0, v1

    const/16 v1, 0x209

    const-string v2, "playstation"

    aput-object v2, v0, v1

    const/16 v1, 0x20a

    const-string v2, "plumbing"

    aput-object v2, v0, v1

    const/16 v1, 0x20b

    const-string v2, "plus"

    aput-object v2, v0, v1

    const/16 v1, 0x20c

    const-string v2, "pohl"

    aput-object v2, v0, v1

    const/16 v1, 0x20d

    const-string v2, "poker"

    aput-object v2, v0, v1

    const/16 v1, 0x20e

    const-string v2, "porn"

    aput-object v2, v0, v1

    const/16 v1, 0x20f

    const-string v2, "post"

    aput-object v2, v0, v1

    const/16 v1, 0x210

    const-string v2, "praxi"

    aput-object v2, v0, v1

    const/16 v1, 0x211

    const-string v2, "press"

    aput-object v2, v0, v1

    const/16 v1, 0x212

    const-string v2, "pro"

    aput-object v2, v0, v1

    const/16 v1, 0x213

    const-string v2, "prod"

    aput-object v2, v0, v1

    const/16 v1, 0x214

    const-string v2, "productions"

    aput-object v2, v0, v1

    const/16 v1, 0x215

    const-string v2, "prof"

    aput-object v2, v0, v1

    const/16 v1, 0x216

    const-string v2, "properties"

    aput-object v2, v0, v1

    const/16 v1, 0x217

    const-string v2, "property"

    aput-object v2, v0, v1

    const/16 v1, 0x218

    const-string v2, "protection"

    aput-object v2, v0, v1

    const/16 v1, 0x219

    const-string v2, "pub"

    aput-object v2, v0, v1

    const/16 v1, 0x21a

    const-string v2, "qpon"

    aput-object v2, v0, v1

    const/16 v1, 0x21b

    const-string v2, "quebec"

    aput-object v2, v0, v1

    const/16 v1, 0x21c

    const-string v2, "racing"

    aput-object v2, v0, v1

    const/16 v1, 0x21d

    const-string v2, "realtor"

    aput-object v2, v0, v1

    const/16 v1, 0x21e

    const-string v2, "realty"

    aput-object v2, v0, v1

    const/16 v1, 0x21f

    const-string v2, "recipes"

    aput-object v2, v0, v1

    const/16 v1, 0x220

    const-string v2, "red"

    aput-object v2, v0, v1

    const/16 v1, 0x221

    const-string v2, "redstone"

    aput-object v2, v0, v1

    const/16 v1, 0x222

    const-string v2, "rehab"

    aput-object v2, v0, v1

    const/16 v1, 0x223

    const-string v2, "reise"

    aput-object v2, v0, v1

    const/16 v1, 0x224

    const-string v2, "reisen"

    aput-object v2, v0, v1

    const/16 v1, 0x225

    const-string v2, "reit"

    aput-object v2, v0, v1

    const/16 v1, 0x226

    const-string v2, "ren"

    aput-object v2, v0, v1

    const/16 v1, 0x227

    const-string v2, "rent"

    aput-object v2, v0, v1

    const/16 v1, 0x228

    const-string v2, "rentals"

    aput-object v2, v0, v1

    const/16 v1, 0x229

    const-string v2, "repair"

    aput-object v2, v0, v1

    const/16 v1, 0x22a

    const-string v2, "report"

    aput-object v2, v0, v1

    const/16 v1, 0x22b

    const-string v2, "republican"

    aput-object v2, v0, v1

    const/16 v1, 0x22c

    const-string v2, "rest"

    aput-object v2, v0, v1

    const/16 v1, 0x22d

    const-string v2, "restaurant"

    aput-object v2, v0, v1

    const/16 v1, 0x22e

    const-string v2, "review"

    aput-object v2, v0, v1

    const/16 v1, 0x22f

    const-string v2, "reviews"

    aput-object v2, v0, v1

    const/16 v1, 0x230

    const-string v2, "rich"

    aput-object v2, v0, v1

    const/16 v1, 0x231

    const-string v2, "ricoh"

    aput-object v2, v0, v1

    const/16 v1, 0x232

    const-string v2, "rio"

    aput-object v2, v0, v1

    const/16 v1, 0x233

    const-string v2, "rip"

    aput-object v2, v0, v1

    const/16 v1, 0x234

    const-string v2, "rocher"

    aput-object v2, v0, v1

    const/16 v1, 0x235

    const-string v2, "rocks"

    aput-object v2, v0, v1

    const/16 v1, 0x236

    const-string v2, "rodeo"

    aput-object v2, v0, v1

    const/16 v1, 0x237

    const-string v2, "rsvp"

    aput-object v2, v0, v1

    const/16 v1, 0x238

    const-string v2, "ruhr"

    aput-object v2, v0, v1

    const/16 v1, 0x239

    const-string v2, "run"

    aput-object v2, v0, v1

    const/16 v1, 0x23a

    const-string v2, "rwe"

    aput-object v2, v0, v1

    const/16 v1, 0x23b

    const-string v2, "ryukyu"

    aput-object v2, v0, v1

    const/16 v1, 0x23c

    const-string v2, "saarland"

    aput-object v2, v0, v1

    const/16 v1, 0x23d

    const-string v2, "sakura"

    aput-object v2, v0, v1

    const/16 v1, 0x23e

    const-string v2, "sale"

    aput-object v2, v0, v1

    const/16 v1, 0x23f

    const-string v2, "samsung"

    aput-object v2, v0, v1

    const/16 v1, 0x240

    const-string v2, "sandvik"

    aput-object v2, v0, v1

    const/16 v1, 0x241

    const-string v2, "sandvikcoromant"

    aput-object v2, v0, v1

    const/16 v1, 0x242

    const-string v2, "sanofi"

    aput-object v2, v0, v1

    const/16 v1, 0x243

    const-string v2, "sap"

    aput-object v2, v0, v1

    const/16 v1, 0x244

    const-string v2, "sapo"

    aput-object v2, v0, v1

    const/16 v1, 0x245

    const-string v2, "sarl"

    aput-object v2, v0, v1

    const/16 v1, 0x246

    const-string v2, "saxo"

    aput-object v2, v0, v1

    const/16 v1, 0x247

    const-string v2, "sbs"

    aput-object v2, v0, v1

    const/16 v1, 0x248

    const-string v2, "sca"

    aput-object v2, v0, v1

    const/16 v1, 0x249

    const-string v2, "scb"

    aput-object v2, v0, v1

    const/16 v1, 0x24a

    const-string v2, "schmidt"

    aput-object v2, v0, v1

    const/16 v1, 0x24b

    const-string v2, "scholarships"

    aput-object v2, v0, v1

    const/16 v1, 0x24c

    const-string v2, "school"

    aput-object v2, v0, v1

    const/16 v1, 0x24d

    const-string v2, "schule"

    aput-object v2, v0, v1

    const/16 v1, 0x24e

    const-string v2, "schwarz"

    aput-object v2, v0, v1

    const/16 v1, 0x24f

    const-string v2, "science"

    aput-object v2, v0, v1

    const/16 v1, 0x250

    const-string v2, "scor"

    aput-object v2, v0, v1

    const/16 v1, 0x251

    const-string v2, "scot"

    aput-object v2, v0, v1

    const/16 v1, 0x252

    const-string v2, "seat"

    aput-object v2, v0, v1

    const/16 v1, 0x253

    const-string v2, "security"

    aput-object v2, v0, v1

    const/16 v1, 0x254

    const-string v2, "seek"

    aput-object v2, v0, v1

    const/16 v1, 0x255

    const-string v2, "sener"

    aput-object v2, v0, v1

    const/16 v1, 0x256

    const-string v2, "services"

    aput-object v2, v0, v1

    const/16 v1, 0x257

    const-string v2, "seven"

    aput-object v2, v0, v1

    const/16 v1, 0x258

    const-string v2, "sew"

    aput-object v2, v0, v1

    const/16 v1, 0x259

    const-string v2, "sex"

    aput-object v2, v0, v1

    const/16 v1, 0x25a

    const-string v2, "sexy"

    aput-object v2, v0, v1

    const/16 v1, 0x25b

    const-string v2, "shiksha"

    aput-object v2, v0, v1

    const/16 v1, 0x25c

    const-string v2, "shoes"

    aput-object v2, v0, v1

    const/16 v1, 0x25d

    const-string v2, "show"

    aput-object v2, v0, v1

    const/16 v1, 0x25e

    const-string v2, "shriram"

    aput-object v2, v0, v1

    const/16 v1, 0x25f

    const-string v2, "singles"

    aput-object v2, v0, v1

    const/16 v1, 0x260

    const-string v2, "site"

    aput-object v2, v0, v1

    const/16 v1, 0x261

    const-string v2, "ski"

    aput-object v2, v0, v1

    const/16 v1, 0x262

    const-string v2, "sky"

    aput-object v2, v0, v1

    const/16 v1, 0x263

    const-string v2, "skype"

    aput-object v2, v0, v1

    const/16 v1, 0x264

    const-string v2, "sncf"

    aput-object v2, v0, v1

    const/16 v1, 0x265

    const-string v2, "soccer"

    aput-object v2, v0, v1

    const/16 v1, 0x266

    const-string v2, "social"

    aput-object v2, v0, v1

    const/16 v1, 0x267

    const-string v2, "software"

    aput-object v2, v0, v1

    const/16 v1, 0x268

    const-string v2, "sohu"

    aput-object v2, v0, v1

    const/16 v1, 0x269

    const-string v2, "solar"

    aput-object v2, v0, v1

    const/16 v1, 0x26a

    const-string v2, "solutions"

    aput-object v2, v0, v1

    const/16 v1, 0x26b

    const-string v2, "sony"

    aput-object v2, v0, v1

    const/16 v1, 0x26c

    const-string v2, "soy"

    aput-object v2, v0, v1

    const/16 v1, 0x26d

    const-string v2, "space"

    aput-object v2, v0, v1

    const/16 v1, 0x26e

    const-string v2, "spiegel"

    aput-object v2, v0, v1

    const/16 v1, 0x26f

    const-string v2, "spreadbetting"

    aput-object v2, v0, v1

    const/16 v1, 0x270

    const-string v2, "srl"

    aput-object v2, v0, v1

    const/16 v1, 0x271

    const-string v2, "stada"

    aput-object v2, v0, v1

    const/16 v1, 0x272

    const-string v2, "starhub"

    aput-object v2, v0, v1

    const/16 v1, 0x273

    const-string v2, "statoil"

    aput-object v2, v0, v1

    const/16 v1, 0x274

    const-string v2, "stc"

    aput-object v2, v0, v1

    const/16 v1, 0x275

    const-string v2, "stcgroup"

    aput-object v2, v0, v1

    const/16 v1, 0x276

    const-string v2, "stockholm"

    aput-object v2, v0, v1

    const/16 v1, 0x277

    const-string v2, "studio"

    aput-object v2, v0, v1

    const/16 v1, 0x278

    const-string v2, "study"

    aput-object v2, v0, v1

    const/16 v1, 0x279

    const-string v2, "style"

    aput-object v2, v0, v1

    const/16 v1, 0x27a

    const-string v2, "sucks"

    aput-object v2, v0, v1

    const/16 v1, 0x27b

    const-string v2, "supplies"

    aput-object v2, v0, v1

    const/16 v1, 0x27c

    const-string v2, "supply"

    aput-object v2, v0, v1

    const/16 v1, 0x27d

    const-string v2, "support"

    aput-object v2, v0, v1

    const/16 v1, 0x27e

    const-string v2, "surf"

    aput-object v2, v0, v1

    const/16 v1, 0x27f

    const-string v2, "surgery"

    aput-object v2, v0, v1

    const/16 v1, 0x280

    const-string v2, "suzuki"

    aput-object v2, v0, v1

    const/16 v1, 0x281

    const-string v2, "swatch"

    aput-object v2, v0, v1

    const/16 v1, 0x282

    const-string v2, "swiss"

    aput-object v2, v0, v1

    const/16 v1, 0x283

    const-string v2, "sydney"

    aput-object v2, v0, v1

    const/16 v1, 0x284

    const-string v2, "systems"

    aput-object v2, v0, v1

    const/16 v1, 0x285

    const-string v2, "taipei"

    aput-object v2, v0, v1

    const/16 v1, 0x286

    const-string v2, "tatamotors"

    aput-object v2, v0, v1

    const/16 v1, 0x287

    const-string v2, "tatar"

    aput-object v2, v0, v1

    const/16 v1, 0x288

    const-string v2, "tattoo"

    aput-object v2, v0, v1

    const/16 v1, 0x289

    const-string v2, "tax"

    aput-object v2, v0, v1

    const/16 v1, 0x28a

    const-string v2, "taxi"

    aput-object v2, v0, v1

    const/16 v1, 0x28b

    const-string v2, "team"

    aput-object v2, v0, v1

    const/16 v1, 0x28c

    const-string v2, "tech"

    aput-object v2, v0, v1

    const/16 v1, 0x28d

    const-string v2, "technology"

    aput-object v2, v0, v1

    const/16 v1, 0x28e

    const-string v2, "tel"

    aput-object v2, v0, v1

    const/16 v1, 0x28f

    const-string v2, "telefonica"

    aput-object v2, v0, v1

    const/16 v1, 0x290

    const-string v2, "temasek"

    aput-object v2, v0, v1

    const/16 v1, 0x291

    const-string v2, "tennis"

    aput-object v2, v0, v1

    const/16 v1, 0x292

    const-string v2, "thd"

    aput-object v2, v0, v1

    const/16 v1, 0x293

    const-string v2, "theater"

    aput-object v2, v0, v1

    const/16 v1, 0x294

    const-string v2, "theatre"

    aput-object v2, v0, v1

    const/16 v1, 0x295

    const-string v2, "tickets"

    aput-object v2, v0, v1

    const/16 v1, 0x296

    const-string v2, "tienda"

    aput-object v2, v0, v1

    const/16 v1, 0x297

    const-string v2, "tips"

    aput-object v2, v0, v1

    const/16 v1, 0x298

    const-string v2, "tires"

    aput-object v2, v0, v1

    const/16 v1, 0x299

    const-string v2, "tirol"

    aput-object v2, v0, v1

    const/16 v1, 0x29a

    const-string v2, "today"

    aput-object v2, v0, v1

    const/16 v1, 0x29b

    const-string v2, "tokyo"

    aput-object v2, v0, v1

    const/16 v1, 0x29c

    const-string v2, "tools"

    aput-object v2, v0, v1

    const/16 v1, 0x29d

    const-string v2, "top"

    aput-object v2, v0, v1

    const/16 v1, 0x29e

    const-string v2, "toray"

    aput-object v2, v0, v1

    const/16 v1, 0x29f

    const-string v2, "toshiba"

    aput-object v2, v0, v1

    const/16 v1, 0x2a0

    const-string v2, "tours"

    aput-object v2, v0, v1

    const/16 v1, 0x2a1

    const-string v2, "town"

    aput-object v2, v0, v1

    const/16 v1, 0x2a2

    const-string v2, "toyota"

    aput-object v2, v0, v1

    const/16 v1, 0x2a3

    const-string v2, "toys"

    aput-object v2, v0, v1

    const/16 v1, 0x2a4

    const-string v2, "trade"

    aput-object v2, v0, v1

    const/16 v1, 0x2a5

    const-string v2, "trading"

    aput-object v2, v0, v1

    const/16 v1, 0x2a6

    const-string v2, "training"

    aput-object v2, v0, v1

    const/16 v1, 0x2a7

    const-string v2, "travel"

    aput-object v2, v0, v1

    const/16 v1, 0x2a8

    const-string v2, "trust"

    aput-object v2, v0, v1

    const/16 v1, 0x2a9

    const-string v2, "tui"

    aput-object v2, v0, v1

    const/16 v1, 0x2aa

    const-string v2, "ubs"

    aput-object v2, v0, v1

    const/16 v1, 0x2ab

    const-string v2, "university"

    aput-object v2, v0, v1

    const/16 v1, 0x2ac

    const-string v2, "uno"

    aput-object v2, v0, v1

    const/16 v1, 0x2ad

    const-string v2, "uol"

    aput-object v2, v0, v1

    const/16 v1, 0x2ae

    const-string v2, "vacations"

    aput-object v2, v0, v1

    const/16 v1, 0x2af

    const-string v2, "vegas"

    aput-object v2, v0, v1

    const/16 v1, 0x2b0

    const-string v2, "ventures"

    aput-object v2, v0, v1

    const/16 v1, 0x2b1

    const-string v2, "versicherung"

    aput-object v2, v0, v1

    const/16 v1, 0x2b2

    const-string v2, "vet"

    aput-object v2, v0, v1

    const/16 v1, 0x2b3

    const-string v2, "viajes"

    aput-object v2, v0, v1

    const/16 v1, 0x2b4

    const-string v2, "video"

    aput-object v2, v0, v1

    const/16 v1, 0x2b5

    const-string v2, "villas"

    aput-object v2, v0, v1

    const/16 v1, 0x2b6

    const-string v2, "vin"

    aput-object v2, v0, v1

    const/16 v1, 0x2b7

    const-string v2, "virgin"

    aput-object v2, v0, v1

    const/16 v1, 0x2b8

    const-string v2, "vision"

    aput-object v2, v0, v1

    const/16 v1, 0x2b9

    const-string v2, "vista"

    aput-object v2, v0, v1

    const/16 v1, 0x2ba

    const-string v2, "vistaprint"

    aput-object v2, v0, v1

    const/16 v1, 0x2bb

    const-string v2, "viva"

    aput-object v2, v0, v1

    const/16 v1, 0x2bc

    const-string v2, "vlaanderen"

    aput-object v2, v0, v1

    const/16 v1, 0x2bd

    const-string v2, "vodka"

    aput-object v2, v0, v1

    const/16 v1, 0x2be

    const-string v2, "vote"

    aput-object v2, v0, v1

    const/16 v1, 0x2bf

    const-string v2, "voting"

    aput-object v2, v0, v1

    const/16 v1, 0x2c0

    const-string v2, "voto"

    aput-object v2, v0, v1

    const/16 v1, 0x2c1

    const-string v2, "voyage"

    aput-object v2, v0, v1

    const/16 v1, 0x2c2

    const-string v2, "wales"

    aput-object v2, v0, v1

    const/16 v1, 0x2c3

    const-string v2, "walter"

    aput-object v2, v0, v1

    const/16 v1, 0x2c4

    const-string v2, "wang"

    aput-object v2, v0, v1

    const/16 v1, 0x2c5

    const-string v2, "watch"

    aput-object v2, v0, v1

    const/16 v1, 0x2c6

    const-string v2, "webcam"

    aput-object v2, v0, v1

    const/16 v1, 0x2c7

    const-string v2, "website"

    aput-object v2, v0, v1

    const/16 v1, 0x2c8

    const-string v2, "wed"

    aput-object v2, v0, v1

    const/16 v1, 0x2c9

    const-string v2, "wedding"

    aput-object v2, v0, v1

    const/16 v1, 0x2ca

    const-string v2, "weir"

    aput-object v2, v0, v1

    const/16 v1, 0x2cb

    const-string v2, "whoswho"

    aput-object v2, v0, v1

    const/16 v1, 0x2cc

    const-string v2, "wien"

    aput-object v2, v0, v1

    const/16 v1, 0x2cd

    const-string v2, "wiki"

    aput-object v2, v0, v1

    const/16 v1, 0x2ce

    const-string v2, "williamhill"

    aput-object v2, v0, v1

    const/16 v1, 0x2cf

    const-string v2, "win"

    aput-object v2, v0, v1

    const/16 v1, 0x2d0

    const-string v2, "windows"

    aput-object v2, v0, v1

    const/16 v1, 0x2d1

    const-string v2, "wine"

    aput-object v2, v0, v1

    const/16 v1, 0x2d2

    const-string v2, "wme"

    aput-object v2, v0, v1

    const/16 v1, 0x2d3

    const-string v2, "work"

    aput-object v2, v0, v1

    const/16 v1, 0x2d4

    const-string v2, "works"

    aput-object v2, v0, v1

    const/16 v1, 0x2d5

    const-string v2, "world"

    aput-object v2, v0, v1

    const/16 v1, 0x2d6

    const-string v2, "wtc"

    aput-object v2, v0, v1

    const/16 v1, 0x2d7

    const-string v2, "wtf"

    aput-object v2, v0, v1

    const/16 v1, 0x2d8

    const-string v2, "xbox"

    aput-object v2, v0, v1

    const/16 v1, 0x2d9

    const-string v2, "xerox"

    aput-object v2, v0, v1

    const/16 v1, 0x2da

    const-string v2, "xin"

    aput-object v2, v0, v1

    const/16 v1, 0x2db

    const-string v2, "xn--11b4c3d"

    aput-object v2, v0, v1

    const/16 v1, 0x2dc

    const-string v2, "xn--1qqw23a"

    aput-object v2, v0, v1

    const/16 v1, 0x2dd

    const-string v2, "xn--30rr7y"

    aput-object v2, v0, v1

    const/16 v1, 0x2de

    const-string v2, "xn--3bst00m"

    aput-object v2, v0, v1

    const/16 v1, 0x2df

    const-string v2, "xn--3ds443g"

    aput-object v2, v0, v1

    const/16 v1, 0x2e0

    const-string v2, "xn--3pxu8k"

    aput-object v2, v0, v1

    const/16 v1, 0x2e1

    const-string v2, "xn--42c2d9a"

    aput-object v2, v0, v1

    const/16 v1, 0x2e2

    const-string v2, "xn--45q11c"

    aput-object v2, v0, v1

    const/16 v1, 0x2e3

    const-string v2, "xn--4gbrim"

    aput-object v2, v0, v1

    const/16 v1, 0x2e4

    const-string v2, "xn--55qw42g"

    aput-object v2, v0, v1

    const/16 v1, 0x2e5

    const-string v2, "xn--55qx5d"

    aput-object v2, v0, v1

    const/16 v1, 0x2e6

    const-string v2, "xn--6frz82g"

    aput-object v2, v0, v1

    const/16 v1, 0x2e7

    const-string v2, "xn--6qq986b3xl"

    aput-object v2, v0, v1

    const/16 v1, 0x2e8

    const-string v2, "xn--80adxhks"

    aput-object v2, v0, v1

    const/16 v1, 0x2e9

    const-string v2, "xn--80asehdb"

    aput-object v2, v0, v1

    const/16 v1, 0x2ea

    const-string v2, "xn--80aswg"

    aput-object v2, v0, v1

    const/16 v1, 0x2eb

    const-string v2, "xn--9dbq2a"

    aput-object v2, v0, v1

    const/16 v1, 0x2ec

    const-string v2, "xn--9et52u"

    aput-object v2, v0, v1

    const/16 v1, 0x2ed

    const-string v2, "xn--b4w605ferd"

    aput-object v2, v0, v1

    const/16 v1, 0x2ee

    const-string v2, "xn--c1avg"

    aput-object v2, v0, v1

    const/16 v1, 0x2ef

    const-string v2, "xn--c2br7g"

    aput-object v2, v0, v1

    const/16 v1, 0x2f0

    const-string v2, "xn--cg4bki"

    aput-object v2, v0, v1

    const/16 v1, 0x2f1

    const-string v2, "xn--czr694b"

    aput-object v2, v0, v1

    const/16 v1, 0x2f2

    const-string v2, "xn--czrs0t"

    aput-object v2, v0, v1

    const/16 v1, 0x2f3

    const-string v2, "xn--czru2d"

    aput-object v2, v0, v1

    const/16 v1, 0x2f4

    const-string v2, "xn--d1acj3b"

    aput-object v2, v0, v1

    const/16 v1, 0x2f5

    const-string v2, "xn--efvy88h"

    aput-object v2, v0, v1

    const/16 v1, 0x2f6

    const-string v2, "xn--estv75g"

    aput-object v2, v0, v1

    const/16 v1, 0x2f7

    const-string v2, "xn--fhbei"

    aput-object v2, v0, v1

    const/16 v1, 0x2f8

    const-string v2, "xn--fiq228c5hs"

    aput-object v2, v0, v1

    const/16 v1, 0x2f9

    const-string v2, "xn--fiq64b"

    aput-object v2, v0, v1

    const/16 v1, 0x2fa

    const-string v2, "xn--fjq720a"

    aput-object v2, v0, v1

    const/16 v1, 0x2fb

    const-string v2, "xn--flw351e"

    aput-object v2, v0, v1

    const/16 v1, 0x2fc

    const-string v2, "xn--hxt814e"

    aput-object v2, v0, v1

    const/16 v1, 0x2fd

    const-string v2, "xn--i1b6b1a6a2e"

    aput-object v2, v0, v1

    const/16 v1, 0x2fe

    const-string v2, "xn--imr513n"

    aput-object v2, v0, v1

    const/16 v1, 0x2ff

    const-string v2, "xn--io0a7i"

    aput-object v2, v0, v1

    const/16 v1, 0x300

    const-string v2, "xn--j1aef"

    aput-object v2, v0, v1

    const/16 v1, 0x301

    const-string v2, "xn--kcrx77d1x4a"

    aput-object v2, v0, v1

    const/16 v1, 0x302

    const-string v2, "xn--kput3i"

    aput-object v2, v0, v1

    const/16 v1, 0x303

    const-string v2, "xn--mgba3a3ejt"

    aput-object v2, v0, v1

    const/16 v1, 0x304

    const-string v2, "xn--mgbab2bd"

    aput-object v2, v0, v1

    const/16 v1, 0x305

    const-string v2, "xn--mk1bu44c"

    aput-object v2, v0, v1

    const/16 v1, 0x306

    const-string v2, "xn--mxtq1m"

    aput-object v2, v0, v1

    const/16 v1, 0x307

    const-string v2, "xn--ngbc5azd"

    aput-object v2, v0, v1

    const/16 v1, 0x308

    const-string v2, "xn--nqv7f"

    aput-object v2, v0, v1

    const/16 v1, 0x309

    const-string v2, "xn--nqv7fs00ema"

    aput-object v2, v0, v1

    const/16 v1, 0x30a

    const-string v2, "xn--nyqy26a"

    aput-object v2, v0, v1

    const/16 v1, 0x30b

    const-string v2, "xn--p1acf"

    aput-object v2, v0, v1

    const/16 v1, 0x30c

    const-string v2, "xn--pssy2u"

    aput-object v2, v0, v1

    const/16 v1, 0x30d

    const-string v2, "xn--q9jyb4c"

    aput-object v2, v0, v1

    const/16 v1, 0x30e

    const-string v2, "xn--qcka1pmc"

    aput-object v2, v0, v1

    const/16 v1, 0x30f

    const-string v2, "xn--rhqv96g"

    aput-object v2, v0, v1

    const/16 v1, 0x310

    const-string v2, "xn--ses554g"

    aput-object v2, v0, v1

    const/16 v1, 0x311

    const-string v2, "xn--t60b56a"

    aput-object v2, v0, v1

    const/16 v1, 0x312

    const-string v2, "xn--tckwe"

    aput-object v2, v0, v1

    const/16 v1, 0x313

    const-string v2, "xn--unup4y"

    aput-object v2, v0, v1

    const/16 v1, 0x314

    const-string v2, "xn--vermgensberater-ctb"

    aput-object v2, v0, v1

    const/16 v1, 0x315

    const-string v2, "xn--vermgensberatung-pwb"

    aput-object v2, v0, v1

    const/16 v1, 0x316

    const-string v2, "xn--vhquv"

    aput-object v2, v0, v1

    const/16 v1, 0x317

    const-string v2, "xn--vuq861b"

    aput-object v2, v0, v1

    const/16 v1, 0x318

    const-string v2, "xn--xhq521b"

    aput-object v2, v0, v1

    const/16 v1, 0x319

    const-string v2, "xn--zfr164b"

    aput-object v2, v0, v1

    const/16 v1, 0x31a

    const-string v2, "xperia"

    aput-object v2, v0, v1

    const/16 v1, 0x31b

    const-string v2, "xxx"

    aput-object v2, v0, v1

    const/16 v1, 0x31c

    const-string v2, "xyz"

    aput-object v2, v0, v1

    const/16 v1, 0x31d

    const-string v2, "yachts"

    aput-object v2, v0, v1

    const/16 v1, 0x31e

    const-string v2, "yamaxun"

    aput-object v2, v0, v1

    const/16 v1, 0x31f

    const-string v2, "yandex"

    aput-object v2, v0, v1

    const/16 v1, 0x320

    const-string v2, "yodobashi"

    aput-object v2, v0, v1

    const/16 v1, 0x321

    const-string v2, "yoga"

    aput-object v2, v0, v1

    const/16 v1, 0x322

    const-string v2, "yokohama"

    aput-object v2, v0, v1

    const/16 v1, 0x323

    const-string v2, "youtube"

    aput-object v2, v0, v1

    const/16 v1, 0x324

    const-string v2, "zara"

    aput-object v2, v0, v1

    const/16 v1, 0x325

    const-string v2, "zip"

    aput-object v2, v0, v1

    const/16 v1, 0x326

    const-string v2, "zone"

    aput-object v2, v0, v1

    const/16 v1, 0x327

    const-string v2, "zuerich"

    aput-object v2, v0, v1

    sput-object v0, Lorg/apache/commons/validator/routines/DomainValidator;->GENERIC_TLDS:[Ljava/lang/String;

    .line 1096
    const/16 v0, 0x122

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "ac"

    aput-object v1, v0, v3

    const-string v1, "ad"

    aput-object v1, v0, v4

    const-string v1, "ae"

    aput-object v1, v0, v5

    const-string v1, "af"

    aput-object v1, v0, v6

    const-string v1, "ag"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "ai"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "al"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "am"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "ao"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "aq"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "ar"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "as"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "at"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "au"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string v2, "aw"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string v2, "ax"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string v2, "az"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    const-string v2, "ba"

    aput-object v2, v0, v1

    const/16 v1, 0x12

    const-string v2, "bb"

    aput-object v2, v0, v1

    const/16 v1, 0x13

    const-string v2, "bd"

    aput-object v2, v0, v1

    const/16 v1, 0x14

    const-string v2, "be"

    aput-object v2, v0, v1

    const/16 v1, 0x15

    const-string v2, "bf"

    aput-object v2, v0, v1

    const/16 v1, 0x16

    const-string v2, "bg"

    aput-object v2, v0, v1

    const/16 v1, 0x17

    const-string v2, "bh"

    aput-object v2, v0, v1

    const/16 v1, 0x18

    const-string v2, "bi"

    aput-object v2, v0, v1

    const/16 v1, 0x19

    const-string v2, "bj"

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    const-string v2, "bm"

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    const-string v2, "bn"

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    const-string v2, "bo"

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    const-string v2, "br"

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    const-string v2, "bs"

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    const-string v2, "bt"

    aput-object v2, v0, v1

    const/16 v1, 0x20

    const-string v2, "bv"

    aput-object v2, v0, v1

    const/16 v1, 0x21

    const-string v2, "bw"

    aput-object v2, v0, v1

    const/16 v1, 0x22

    const-string v2, "by"

    aput-object v2, v0, v1

    const/16 v1, 0x23

    const-string v2, "bz"

    aput-object v2, v0, v1

    const/16 v1, 0x24

    const-string v2, "ca"

    aput-object v2, v0, v1

    const/16 v1, 0x25

    const-string v2, "cc"

    aput-object v2, v0, v1

    const/16 v1, 0x26

    const-string v2, "cd"

    aput-object v2, v0, v1

    const/16 v1, 0x27

    const-string v2, "cf"

    aput-object v2, v0, v1

    const/16 v1, 0x28

    const-string v2, "cg"

    aput-object v2, v0, v1

    const/16 v1, 0x29

    const-string v2, "ch"

    aput-object v2, v0, v1

    const/16 v1, 0x2a

    const-string v2, "ci"

    aput-object v2, v0, v1

    const/16 v1, 0x2b

    const-string v2, "ck"

    aput-object v2, v0, v1

    const/16 v1, 0x2c

    const-string v2, "cl"

    aput-object v2, v0, v1

    const/16 v1, 0x2d

    const-string v2, "cm"

    aput-object v2, v0, v1

    const/16 v1, 0x2e

    const-string v2, "cn"

    aput-object v2, v0, v1

    const/16 v1, 0x2f

    const-string v2, "co"

    aput-object v2, v0, v1

    const/16 v1, 0x30

    const-string v2, "cr"

    aput-object v2, v0, v1

    const/16 v1, 0x31

    const-string v2, "cu"

    aput-object v2, v0, v1

    const/16 v1, 0x32

    const-string v2, "cv"

    aput-object v2, v0, v1

    const/16 v1, 0x33

    const-string v2, "cw"

    aput-object v2, v0, v1

    const/16 v1, 0x34

    const-string v2, "cx"

    aput-object v2, v0, v1

    const/16 v1, 0x35

    const-string v2, "cy"

    aput-object v2, v0, v1

    const/16 v1, 0x36

    const-string v2, "cz"

    aput-object v2, v0, v1

    const/16 v1, 0x37

    const-string v2, "de"

    aput-object v2, v0, v1

    const/16 v1, 0x38

    const-string v2, "dj"

    aput-object v2, v0, v1

    const/16 v1, 0x39

    const-string v2, "dk"

    aput-object v2, v0, v1

    const/16 v1, 0x3a

    const-string v2, "dm"

    aput-object v2, v0, v1

    const/16 v1, 0x3b

    const-string v2, "do"

    aput-object v2, v0, v1

    const/16 v1, 0x3c

    const-string v2, "dz"

    aput-object v2, v0, v1

    const/16 v1, 0x3d

    const-string v2, "ec"

    aput-object v2, v0, v1

    const/16 v1, 0x3e

    const-string v2, "ee"

    aput-object v2, v0, v1

    const/16 v1, 0x3f

    const-string v2, "eg"

    aput-object v2, v0, v1

    const/16 v1, 0x40

    const-string v2, "er"

    aput-object v2, v0, v1

    const/16 v1, 0x41

    const-string v2, "es"

    aput-object v2, v0, v1

    const/16 v1, 0x42

    const-string v2, "et"

    aput-object v2, v0, v1

    const/16 v1, 0x43

    const-string v2, "eu"

    aput-object v2, v0, v1

    const/16 v1, 0x44

    const-string v2, "fi"

    aput-object v2, v0, v1

    const/16 v1, 0x45

    const-string v2, "fj"

    aput-object v2, v0, v1

    const/16 v1, 0x46

    const-string v2, "fk"

    aput-object v2, v0, v1

    const/16 v1, 0x47

    const-string v2, "fm"

    aput-object v2, v0, v1

    const/16 v1, 0x48

    const-string v2, "fo"

    aput-object v2, v0, v1

    const/16 v1, 0x49

    const-string v2, "fr"

    aput-object v2, v0, v1

    const/16 v1, 0x4a

    const-string v2, "ga"

    aput-object v2, v0, v1

    const/16 v1, 0x4b

    const-string v2, "gb"

    aput-object v2, v0, v1

    const/16 v1, 0x4c

    const-string v2, "gd"

    aput-object v2, v0, v1

    const/16 v1, 0x4d

    const-string v2, "ge"

    aput-object v2, v0, v1

    const/16 v1, 0x4e

    const-string v2, "gf"

    aput-object v2, v0, v1

    const/16 v1, 0x4f

    const-string v2, "gg"

    aput-object v2, v0, v1

    const/16 v1, 0x50

    const-string v2, "gh"

    aput-object v2, v0, v1

    const/16 v1, 0x51

    const-string v2, "gi"

    aput-object v2, v0, v1

    const/16 v1, 0x52

    const-string v2, "gl"

    aput-object v2, v0, v1

    const/16 v1, 0x53

    const-string v2, "gm"

    aput-object v2, v0, v1

    const/16 v1, 0x54

    const-string v2, "gn"

    aput-object v2, v0, v1

    const/16 v1, 0x55

    const-string v2, "gp"

    aput-object v2, v0, v1

    const/16 v1, 0x56

    const-string v2, "gq"

    aput-object v2, v0, v1

    const/16 v1, 0x57

    const-string v2, "gr"

    aput-object v2, v0, v1

    const/16 v1, 0x58

    const-string v2, "gs"

    aput-object v2, v0, v1

    const/16 v1, 0x59

    const-string v2, "gt"

    aput-object v2, v0, v1

    const/16 v1, 0x5a

    const-string v2, "gu"

    aput-object v2, v0, v1

    const/16 v1, 0x5b

    const-string v2, "gw"

    aput-object v2, v0, v1

    const/16 v1, 0x5c

    const-string v2, "gy"

    aput-object v2, v0, v1

    const/16 v1, 0x5d

    const-string v2, "hk"

    aput-object v2, v0, v1

    const/16 v1, 0x5e

    const-string v2, "hm"

    aput-object v2, v0, v1

    const/16 v1, 0x5f

    const-string v2, "hn"

    aput-object v2, v0, v1

    const/16 v1, 0x60

    const-string v2, "hr"

    aput-object v2, v0, v1

    const/16 v1, 0x61

    const-string v2, "ht"

    aput-object v2, v0, v1

    const/16 v1, 0x62

    const-string v2, "hu"

    aput-object v2, v0, v1

    const/16 v1, 0x63

    const-string v2, "id"

    aput-object v2, v0, v1

    const/16 v1, 0x64

    const-string v2, "ie"

    aput-object v2, v0, v1

    const/16 v1, 0x65

    const-string v2, "il"

    aput-object v2, v0, v1

    const/16 v1, 0x66

    const-string v2, "im"

    aput-object v2, v0, v1

    const/16 v1, 0x67

    const-string v2, "in"

    aput-object v2, v0, v1

    const/16 v1, 0x68

    const-string v2, "io"

    aput-object v2, v0, v1

    const/16 v1, 0x69

    const-string v2, "iq"

    aput-object v2, v0, v1

    const/16 v1, 0x6a

    const-string v2, "ir"

    aput-object v2, v0, v1

    const/16 v1, 0x6b

    const-string v2, "is"

    aput-object v2, v0, v1

    const/16 v1, 0x6c

    const-string v2, "it"

    aput-object v2, v0, v1

    const/16 v1, 0x6d

    const-string v2, "je"

    aput-object v2, v0, v1

    const/16 v1, 0x6e

    const-string v2, "jm"

    aput-object v2, v0, v1

    const/16 v1, 0x6f

    const-string v2, "jo"

    aput-object v2, v0, v1

    const/16 v1, 0x70

    const-string v2, "jp"

    aput-object v2, v0, v1

    const/16 v1, 0x71

    const-string v2, "ke"

    aput-object v2, v0, v1

    const/16 v1, 0x72

    const-string v2, "kg"

    aput-object v2, v0, v1

    const/16 v1, 0x73

    const-string v2, "kh"

    aput-object v2, v0, v1

    const/16 v1, 0x74

    const-string v2, "ki"

    aput-object v2, v0, v1

    const/16 v1, 0x75

    const-string v2, "km"

    aput-object v2, v0, v1

    const/16 v1, 0x76

    const-string v2, "kn"

    aput-object v2, v0, v1

    const/16 v1, 0x77

    const-string v2, "kp"

    aput-object v2, v0, v1

    const/16 v1, 0x78

    const-string v2, "kr"

    aput-object v2, v0, v1

    const/16 v1, 0x79

    const-string v2, "kw"

    aput-object v2, v0, v1

    const/16 v1, 0x7a

    const-string v2, "ky"

    aput-object v2, v0, v1

    const/16 v1, 0x7b

    const-string v2, "kz"

    aput-object v2, v0, v1

    const/16 v1, 0x7c

    const-string v2, "la"

    aput-object v2, v0, v1

    const/16 v1, 0x7d

    const-string v2, "lb"

    aput-object v2, v0, v1

    const/16 v1, 0x7e

    const-string v2, "lc"

    aput-object v2, v0, v1

    const/16 v1, 0x7f

    const-string v2, "li"

    aput-object v2, v0, v1

    const/16 v1, 0x80

    const-string v2, "lk"

    aput-object v2, v0, v1

    const/16 v1, 0x81

    const-string v2, "lr"

    aput-object v2, v0, v1

    const/16 v1, 0x82

    const-string v2, "ls"

    aput-object v2, v0, v1

    const/16 v1, 0x83

    const-string v2, "lt"

    aput-object v2, v0, v1

    const/16 v1, 0x84

    const-string v2, "lu"

    aput-object v2, v0, v1

    const/16 v1, 0x85

    const-string v2, "lv"

    aput-object v2, v0, v1

    const/16 v1, 0x86

    const-string v2, "ly"

    aput-object v2, v0, v1

    const/16 v1, 0x87

    const-string v2, "ma"

    aput-object v2, v0, v1

    const/16 v1, 0x88

    const-string v2, "mc"

    aput-object v2, v0, v1

    const/16 v1, 0x89

    const-string v2, "md"

    aput-object v2, v0, v1

    const/16 v1, 0x8a

    const-string v2, "me"

    aput-object v2, v0, v1

    const/16 v1, 0x8b

    const-string v2, "mg"

    aput-object v2, v0, v1

    const/16 v1, 0x8c

    const-string v2, "mh"

    aput-object v2, v0, v1

    const/16 v1, 0x8d

    const-string v2, "mk"

    aput-object v2, v0, v1

    const/16 v1, 0x8e

    const-string v2, "ml"

    aput-object v2, v0, v1

    const/16 v1, 0x8f

    const-string v2, "mm"

    aput-object v2, v0, v1

    const/16 v1, 0x90

    const-string v2, "mn"

    aput-object v2, v0, v1

    const/16 v1, 0x91

    const-string v2, "mo"

    aput-object v2, v0, v1

    const/16 v1, 0x92

    const-string v2, "mp"

    aput-object v2, v0, v1

    const/16 v1, 0x93

    const-string v2, "mq"

    aput-object v2, v0, v1

    const/16 v1, 0x94

    const-string v2, "mr"

    aput-object v2, v0, v1

    const/16 v1, 0x95

    const-string v2, "ms"

    aput-object v2, v0, v1

    const/16 v1, 0x96

    const-string v2, "mt"

    aput-object v2, v0, v1

    const/16 v1, 0x97

    const-string v2, "mu"

    aput-object v2, v0, v1

    const/16 v1, 0x98

    const-string v2, "mv"

    aput-object v2, v0, v1

    const/16 v1, 0x99

    const-string v2, "mw"

    aput-object v2, v0, v1

    const/16 v1, 0x9a

    const-string v2, "mx"

    aput-object v2, v0, v1

    const/16 v1, 0x9b

    const-string v2, "my"

    aput-object v2, v0, v1

    const/16 v1, 0x9c

    const-string v2, "mz"

    aput-object v2, v0, v1

    const/16 v1, 0x9d

    const-string v2, "na"

    aput-object v2, v0, v1

    const/16 v1, 0x9e

    const-string v2, "nc"

    aput-object v2, v0, v1

    const/16 v1, 0x9f

    const-string v2, "ne"

    aput-object v2, v0, v1

    const/16 v1, 0xa0

    const-string v2, "nf"

    aput-object v2, v0, v1

    const/16 v1, 0xa1

    const-string v2, "ng"

    aput-object v2, v0, v1

    const/16 v1, 0xa2

    const-string v2, "ni"

    aput-object v2, v0, v1

    const/16 v1, 0xa3

    const-string v2, "nl"

    aput-object v2, v0, v1

    const/16 v1, 0xa4

    const-string v2, "no"

    aput-object v2, v0, v1

    const/16 v1, 0xa5

    const-string v2, "np"

    aput-object v2, v0, v1

    const/16 v1, 0xa6

    const-string v2, "nr"

    aput-object v2, v0, v1

    const/16 v1, 0xa7

    const-string v2, "nu"

    aput-object v2, v0, v1

    const/16 v1, 0xa8

    const-string v2, "nz"

    aput-object v2, v0, v1

    const/16 v1, 0xa9

    const-string v2, "om"

    aput-object v2, v0, v1

    const/16 v1, 0xaa

    const-string v2, "pa"

    aput-object v2, v0, v1

    const/16 v1, 0xab

    const-string v2, "pe"

    aput-object v2, v0, v1

    const/16 v1, 0xac

    const-string v2, "pf"

    aput-object v2, v0, v1

    const/16 v1, 0xad

    const-string v2, "pg"

    aput-object v2, v0, v1

    const/16 v1, 0xae

    const-string v2, "ph"

    aput-object v2, v0, v1

    const/16 v1, 0xaf

    const-string v2, "pk"

    aput-object v2, v0, v1

    const/16 v1, 0xb0

    const-string v2, "pl"

    aput-object v2, v0, v1

    const/16 v1, 0xb1

    const-string v2, "pm"

    aput-object v2, v0, v1

    const/16 v1, 0xb2

    const-string v2, "pn"

    aput-object v2, v0, v1

    const/16 v1, 0xb3

    const-string v2, "pr"

    aput-object v2, v0, v1

    const/16 v1, 0xb4

    const-string v2, "ps"

    aput-object v2, v0, v1

    const/16 v1, 0xb5

    const-string v2, "pt"

    aput-object v2, v0, v1

    const/16 v1, 0xb6

    const-string v2, "pw"

    aput-object v2, v0, v1

    const/16 v1, 0xb7

    const-string v2, "py"

    aput-object v2, v0, v1

    const/16 v1, 0xb8

    const-string v2, "qa"

    aput-object v2, v0, v1

    const/16 v1, 0xb9

    const-string v2, "re"

    aput-object v2, v0, v1

    const/16 v1, 0xba

    const-string v2, "ro"

    aput-object v2, v0, v1

    const/16 v1, 0xbb

    const-string v2, "rs"

    aput-object v2, v0, v1

    const/16 v1, 0xbc

    const-string v2, "ru"

    aput-object v2, v0, v1

    const/16 v1, 0xbd

    const-string v2, "rw"

    aput-object v2, v0, v1

    const/16 v1, 0xbe

    const-string v2, "sa"

    aput-object v2, v0, v1

    const/16 v1, 0xbf

    const-string v2, "sb"

    aput-object v2, v0, v1

    const/16 v1, 0xc0

    const-string v2, "sc"

    aput-object v2, v0, v1

    const/16 v1, 0xc1

    const-string v2, "sd"

    aput-object v2, v0, v1

    const/16 v1, 0xc2

    const-string v2, "se"

    aput-object v2, v0, v1

    const/16 v1, 0xc3

    const-string v2, "sg"

    aput-object v2, v0, v1

    const/16 v1, 0xc4

    const-string v2, "sh"

    aput-object v2, v0, v1

    const/16 v1, 0xc5

    const-string v2, "si"

    aput-object v2, v0, v1

    const/16 v1, 0xc6

    const-string v2, "sj"

    aput-object v2, v0, v1

    const/16 v1, 0xc7

    const-string v2, "sk"

    aput-object v2, v0, v1

    const/16 v1, 0xc8

    const-string v2, "sl"

    aput-object v2, v0, v1

    const/16 v1, 0xc9

    const-string v2, "sm"

    aput-object v2, v0, v1

    const/16 v1, 0xca

    const-string v2, "sn"

    aput-object v2, v0, v1

    const/16 v1, 0xcb

    const-string v2, "so"

    aput-object v2, v0, v1

    const/16 v1, 0xcc

    const-string v2, "sr"

    aput-object v2, v0, v1

    const/16 v1, 0xcd

    const-string v2, "st"

    aput-object v2, v0, v1

    const/16 v1, 0xce

    const-string v2, "su"

    aput-object v2, v0, v1

    const/16 v1, 0xcf

    const-string v2, "sv"

    aput-object v2, v0, v1

    const/16 v1, 0xd0

    const-string v2, "sx"

    aput-object v2, v0, v1

    const/16 v1, 0xd1

    const-string v2, "sy"

    aput-object v2, v0, v1

    const/16 v1, 0xd2

    const-string v2, "sz"

    aput-object v2, v0, v1

    const/16 v1, 0xd3

    const-string v2, "tc"

    aput-object v2, v0, v1

    const/16 v1, 0xd4

    const-string v2, "td"

    aput-object v2, v0, v1

    const/16 v1, 0xd5

    const-string v2, "tf"

    aput-object v2, v0, v1

    const/16 v1, 0xd6

    const-string v2, "tg"

    aput-object v2, v0, v1

    const/16 v1, 0xd7

    const-string v2, "th"

    aput-object v2, v0, v1

    const/16 v1, 0xd8

    const-string v2, "tj"

    aput-object v2, v0, v1

    const/16 v1, 0xd9

    const-string v2, "tk"

    aput-object v2, v0, v1

    const/16 v1, 0xda

    const-string v2, "tl"

    aput-object v2, v0, v1

    const/16 v1, 0xdb

    const-string v2, "tm"

    aput-object v2, v0, v1

    const/16 v1, 0xdc

    const-string v2, "tn"

    aput-object v2, v0, v1

    const/16 v1, 0xdd

    const-string v2, "to"

    aput-object v2, v0, v1

    const/16 v1, 0xde

    const-string v2, "tr"

    aput-object v2, v0, v1

    const/16 v1, 0xdf

    const-string v2, "tt"

    aput-object v2, v0, v1

    const/16 v1, 0xe0

    const-string v2, "tv"

    aput-object v2, v0, v1

    const/16 v1, 0xe1

    const-string v2, "tw"

    aput-object v2, v0, v1

    const/16 v1, 0xe2

    const-string v2, "tz"

    aput-object v2, v0, v1

    const/16 v1, 0xe3

    const-string v2, "ua"

    aput-object v2, v0, v1

    const/16 v1, 0xe4

    const-string v2, "ug"

    aput-object v2, v0, v1

    const/16 v1, 0xe5

    const-string v2, "uk"

    aput-object v2, v0, v1

    const/16 v1, 0xe6

    const-string v2, "us"

    aput-object v2, v0, v1

    const/16 v1, 0xe7

    const-string v2, "uy"

    aput-object v2, v0, v1

    const/16 v1, 0xe8

    const-string v2, "uz"

    aput-object v2, v0, v1

    const/16 v1, 0xe9

    const-string v2, "va"

    aput-object v2, v0, v1

    const/16 v1, 0xea

    const-string v2, "vc"

    aput-object v2, v0, v1

    const/16 v1, 0xeb

    const-string v2, "ve"

    aput-object v2, v0, v1

    const/16 v1, 0xec

    const-string v2, "vg"

    aput-object v2, v0, v1

    const/16 v1, 0xed

    const-string v2, "vi"

    aput-object v2, v0, v1

    const/16 v1, 0xee

    const-string v2, "vn"

    aput-object v2, v0, v1

    const/16 v1, 0xef

    const-string v2, "vu"

    aput-object v2, v0, v1

    const/16 v1, 0xf0

    const-string v2, "wf"

    aput-object v2, v0, v1

    const/16 v1, 0xf1

    const-string v2, "ws"

    aput-object v2, v0, v1

    const/16 v1, 0xf2

    const-string v2, "xn--3e0b707e"

    aput-object v2, v0, v1

    const/16 v1, 0xf3

    const-string v2, "xn--45brj9c"

    aput-object v2, v0, v1

    const/16 v1, 0xf4

    const-string v2, "xn--80ao21a"

    aput-object v2, v0, v1

    const/16 v1, 0xf5

    const-string v2, "xn--90a3ac"

    aput-object v2, v0, v1

    const/16 v1, 0xf6

    const-string v2, "xn--90ais"

    aput-object v2, v0, v1

    const/16 v1, 0xf7

    const-string v2, "xn--clchc0ea0b2g2a9gcd"

    aput-object v2, v0, v1

    const/16 v1, 0xf8

    const-string v2, "xn--d1alf"

    aput-object v2, v0, v1

    const/16 v1, 0xf9

    const-string v2, "xn--fiqs8s"

    aput-object v2, v0, v1

    const/16 v1, 0xfa

    const-string v2, "xn--fiqz9s"

    aput-object v2, v0, v1

    const/16 v1, 0xfb

    const-string v2, "xn--fpcrj9c3d"

    aput-object v2, v0, v1

    const/16 v1, 0xfc

    const-string v2, "xn--fzc2c9e2c"

    aput-object v2, v0, v1

    const/16 v1, 0xfd

    const-string v2, "xn--gecrj9c"

    aput-object v2, v0, v1

    const/16 v1, 0xfe

    const-string v2, "xn--h2brj9c"

    aput-object v2, v0, v1

    const/16 v1, 0xff

    const-string v2, "xn--j1amh"

    aput-object v2, v0, v1

    const/16 v1, 0x100

    const-string v2, "xn--j6w193g"

    aput-object v2, v0, v1

    const/16 v1, 0x101

    const-string v2, "xn--kprw13d"

    aput-object v2, v0, v1

    const/16 v1, 0x102

    const-string v2, "xn--kpry57d"

    aput-object v2, v0, v1

    const/16 v1, 0x103

    const-string v2, "xn--l1acc"

    aput-object v2, v0, v1

    const/16 v1, 0x104

    const-string v2, "xn--lgbbat1ad8j"

    aput-object v2, v0, v1

    const/16 v1, 0x105

    const-string v2, "xn--mgb9awbf"

    aput-object v2, v0, v1

    const/16 v1, 0x106

    const-string v2, "xn--mgba3a4f16a"

    aput-object v2, v0, v1

    const/16 v1, 0x107

    const-string v2, "xn--mgbaam7a8h"

    aput-object v2, v0, v1

    const/16 v1, 0x108

    const-string v2, "xn--mgbayh7gpa"

    aput-object v2, v0, v1

    const/16 v1, 0x109

    const-string v2, "xn--mgbbh1a71e"

    aput-object v2, v0, v1

    const/16 v1, 0x10a

    const-string v2, "xn--mgbc0a9azcg"

    aput-object v2, v0, v1

    const/16 v1, 0x10b

    const-string v2, "xn--mgberp4a5d4ar"

    aput-object v2, v0, v1

    const/16 v1, 0x10c

    const-string v2, "xn--mgbpl2fh"

    aput-object v2, v0, v1

    const/16 v1, 0x10d

    const-string v2, "xn--mgbtx2b"

    aput-object v2, v0, v1

    const/16 v1, 0x10e

    const-string v2, "xn--mgbx4cd0ab"

    aput-object v2, v0, v1

    const/16 v1, 0x10f

    const-string v2, "xn--node"

    aput-object v2, v0, v1

    const/16 v1, 0x110

    const-string v2, "xn--o3cw4h"

    aput-object v2, v0, v1

    const/16 v1, 0x111

    const-string v2, "xn--ogbpf8fl"

    aput-object v2, v0, v1

    const/16 v1, 0x112

    const-string v2, "xn--p1ai"

    aput-object v2, v0, v1

    const/16 v1, 0x113

    const-string v2, "xn--pgbs0dh"

    aput-object v2, v0, v1

    const/16 v1, 0x114

    const-string v2, "xn--qxam"

    aput-object v2, v0, v1

    const/16 v1, 0x115

    const-string v2, "xn--s9brj9c"

    aput-object v2, v0, v1

    const/16 v1, 0x116

    const-string v2, "xn--wgbh1c"

    aput-object v2, v0, v1

    const/16 v1, 0x117

    const-string v2, "xn--wgbl6a"

    aput-object v2, v0, v1

    const/16 v1, 0x118

    const-string v2, "xn--xkc2al3hye2a"

    aput-object v2, v0, v1

    const/16 v1, 0x119

    const-string v2, "xn--xkc2dl3a5ee0h"

    aput-object v2, v0, v1

    const/16 v1, 0x11a

    const-string v2, "xn--y9a3aq"

    aput-object v2, v0, v1

    const/16 v1, 0x11b

    const-string v2, "xn--yfro4i67o"

    aput-object v2, v0, v1

    const/16 v1, 0x11c

    const-string v2, "xn--ygbi2ammx"

    aput-object v2, v0, v1

    const/16 v1, 0x11d

    const-string v2, "ye"

    aput-object v2, v0, v1

    const/16 v1, 0x11e

    const-string v2, "yt"

    aput-object v2, v0, v1

    const/16 v1, 0x11f

    const-string v2, "za"

    aput-object v2, v0, v1

    const/16 v1, 0x120

    const-string v2, "zm"

    aput-object v2, v0, v1

    const/16 v1, 0x121

    const-string v2, "zw"

    aput-object v2, v0, v1

    sput-object v0, Lorg/apache/commons/validator/routines/DomainValidator;->COUNTRY_CODE_TLDS:[Ljava/lang/String;

    .line 1392
    new-array v0, v5, [Ljava/lang/String;

    const-string v1, "localdomain"

    aput-object v1, v0, v3

    const-string v1, "localhost"

    aput-object v1, v0, v4

    sput-object v0, Lorg/apache/commons/validator/routines/DomainValidator;->LOCAL_TLDS:[Ljava/lang/String;

    .line 1406
    sput-boolean v3, Lorg/apache/commons/validator/routines/DomainValidator;->inUse:Z

    .line 1414
    sget-object v0, Lorg/apache/commons/validator/routines/DomainValidator;->EMPTY_STRING_ARRAY:[Ljava/lang/String;

    sput-object v0, Lorg/apache/commons/validator/routines/DomainValidator;->COUNTRY_CODE_TLDS_PLUS:[Ljava/lang/String;

    .line 1417
    sget-object v0, Lorg/apache/commons/validator/routines/DomainValidator;->EMPTY_STRING_ARRAY:[Ljava/lang/String;

    sput-object v0, Lorg/apache/commons/validator/routines/DomainValidator;->GENERIC_TLDS_PLUS:[Ljava/lang/String;

    .line 1420
    sget-object v0, Lorg/apache/commons/validator/routines/DomainValidator;->EMPTY_STRING_ARRAY:[Ljava/lang/String;

    sput-object v0, Lorg/apache/commons/validator/routines/DomainValidator;->COUNTRY_CODE_TLDS_MINUS:[Ljava/lang/String;

    .line 1423
    sget-object v0, Lorg/apache/commons/validator/routines/DomainValidator;->EMPTY_STRING_ARRAY:[Ljava/lang/String;

    sput-object v0, Lorg/apache/commons/validator/routines/DomainValidator;->GENERIC_TLDS_MINUS:[Ljava/lang/String;

    return-void
.end method

.method private constructor <init>(Z)V
    .locals 2
    .param p1, "allowLocal"    # Z

    .prologue
    .line 139
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 105
    new-instance v0, Lorg/apache/commons/validator/routines/RegexValidator;

    const-string v1, "^(?:\\p{Alnum}(?>[\\p{Alnum}-]{0,61}\\p{Alnum})?\\.)+(\\p{Alpha}(?>[\\p{Alnum}-]{0,61}\\p{Alnum})?)\\.?$"

    invoke-direct {v0, v1}, Lorg/apache/commons/validator/routines/RegexValidator;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lorg/apache/commons/validator/routines/DomainValidator;->domainRegex:Lorg/apache/commons/validator/routines/RegexValidator;

    .line 111
    new-instance v0, Lorg/apache/commons/validator/routines/RegexValidator;

    const-string v1, "\\p{Alnum}(?>[\\p{Alnum}-]{0,61}\\p{Alnum})?"

    invoke-direct {v0, v1}, Lorg/apache/commons/validator/routines/RegexValidator;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lorg/apache/commons/validator/routines/DomainValidator;->hostnameRegex:Lorg/apache/commons/validator/routines/RegexValidator;

    .line 140
    iput-boolean p1, p0, Lorg/apache/commons/validator/routines/DomainValidator;->allowLocal:Z

    .line 141
    return-void
.end method

.method private static arrayContains([Ljava/lang/String;Ljava/lang/String;)Z
    .locals 1
    .param p0, "sortedArray"    # [Ljava/lang/String;
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 1563
    invoke-static {p0, p1}, Ljava/util/Arrays;->binarySearch([Ljava/lang/Object;Ljava/lang/Object;)I

    move-result v0

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private chompLeadingDot(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "str"    # Ljava/lang/String;

    .prologue
    .line 256
    const-string v0, "."

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 257
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p1

    .line 259
    .end local p1    # "str":Ljava/lang/String;
    :cond_0
    return-object p1
.end method

.method public static declared-synchronized getInstance(Z)Lorg/apache/commons/validator/routines/DomainValidator;
    .locals 2
    .param p0, "allowLocal"    # Z

    .prologue
    .line 131
    const-class v1, Lorg/apache/commons/validator/routines/DomainValidator;

    monitor-enter v1

    const/4 v0, 0x1

    :try_start_0
    sput-boolean v0, Lorg/apache/commons/validator/routines/DomainValidator;->inUse:Z

    .line 132
    if-eqz p0, :cond_0

    .line 133
    sget-object v0, Lorg/apache/commons/validator/routines/DomainValidator;->DOMAIN_VALIDATOR_WITH_LOCAL:Lorg/apache/commons/validator/routines/DomainValidator;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 135
    :goto_0
    monitor-exit v1

    return-object v0

    :cond_0
    :try_start_1
    sget-object v0, Lorg/apache/commons/validator/routines/DomainValidator;->DOMAIN_VALIDATOR:Lorg/apache/commons/validator/routines/DomainValidator;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 131
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private static isOnlyASCII(Ljava/lang/String;)Z
    .locals 4
    .param p0, "input"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x1

    .line 1544
    if-nez p0, :cond_1

    .line 1552
    :cond_0
    :goto_0
    return v1

    .line 1547
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 1548
    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v3, 0x7f

    if-le v2, v3, :cond_2

    .line 1549
    const/4 v1, 0x0

    goto :goto_0

    .line 1547
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method static unicodeToASCII(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p0, "input"    # Ljava/lang/String;

    .prologue
    .line 1499
    invoke-static {p0}, Lorg/apache/commons/validator/routines/DomainValidator;->isOnlyASCII(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 1527
    .end local p0    # "input":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object p0

    .line 1503
    .restart local p0    # "input":Ljava/lang/String;
    :cond_1
    :try_start_0
    invoke-static {p0}, Ljava/net/IDN;->toASCII(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1504
    .local v0, "ascii":Ljava/lang/String;
    # getter for: Lorg/apache/commons/validator/routines/DomainValidator$IDNBUGHOLDER;->IDN_TOASCII_PRESERVES_TRAILING_DOTS:Z
    invoke-static {}, Lorg/apache/commons/validator/routines/DomainValidator$IDNBUGHOLDER;->access$000()Z

    move-result v4

    if-eqz v4, :cond_2

    move-object p0, v0

    .line 1505
    goto :goto_0

    .line 1507
    :cond_2
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    .line 1508
    .local v3, "length":I
    if-eqz v3, :cond_0

    .line 1516
    add-int/lit8 v4, v3, -0x1

    invoke-virtual {p0, v4}, Ljava/lang/String;->charAt(I)C

    move-result v2

    .line 1517
    .local v2, "lastChar":C
    sparse-switch v2, :sswitch_data_0

    move-object p0, v0

    .line 1524
    goto :goto_0

    .line 1522
    :sswitch_0
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p0

    goto :goto_0

    .line 1526
    .end local v0    # "ascii":Ljava/lang/String;
    .end local v2    # "lastChar":C
    .end local v3    # "length":I
    :catch_0
    move-exception v1

    .line 1527
    .local v1, "e":Ljava/lang/IllegalArgumentException;
    goto :goto_0

    .line 1517
    :sswitch_data_0
    .sparse-switch
        0x2e -> :sswitch_0
        0x3002 -> :sswitch_0
        0xff0e -> :sswitch_0
        0xff61 -> :sswitch_0
    .end sparse-switch
.end method


# virtual methods
.method public isValid(Ljava/lang/String;)Z
    .locals 4
    .param p1, "domain"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 151
    if-nez p1, :cond_1

    .line 166
    :cond_0
    :goto_0
    return v1

    .line 154
    :cond_1
    invoke-static {p1}, Lorg/apache/commons/validator/routines/DomainValidator;->unicodeToASCII(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 159
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    const/16 v3, 0xfd

    if-gt v2, v3, :cond_0

    .line 162
    iget-object v2, p0, Lorg/apache/commons/validator/routines/DomainValidator;->domainRegex:Lorg/apache/commons/validator/routines/RegexValidator;

    invoke-virtual {v2, p1}, Lorg/apache/commons/validator/routines/RegexValidator;->match(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 163
    .local v0, "groups":[Ljava/lang/String;
    if-eqz v0, :cond_2

    array-length v2, v0

    if-lez v2, :cond_2

    .line 164
    aget-object v1, v0, v1

    invoke-virtual {p0, v1}, Lorg/apache/commons/validator/routines/DomainValidator;->isValidTld(Ljava/lang/String;)Z

    move-result v1

    goto :goto_0

    .line 166
    :cond_2
    iget-boolean v2, p0, Lorg/apache/commons/validator/routines/DomainValidator;->allowLocal:Z

    if-eqz v2, :cond_0

    iget-object v2, p0, Lorg/apache/commons/validator/routines/DomainValidator;->hostnameRegex:Lorg/apache/commons/validator/routines/RegexValidator;

    invoke-virtual {v2, p1}, Lorg/apache/commons/validator/routines/RegexValidator;->isValid(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    goto :goto_0
.end method

.method public isValidCountryCodeTld(Ljava/lang/String;)Z
    .locals 3
    .param p1, "ccTld"    # Ljava/lang/String;

    .prologue
    .line 238
    invoke-static {p1}, Lorg/apache/commons/validator/routines/DomainValidator;->unicodeToASCII(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lorg/apache/commons/validator/routines/DomainValidator;->chompLeadingDot(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 239
    .local v0, "key":Ljava/lang/String;
    sget-object v1, Lorg/apache/commons/validator/routines/DomainValidator;->COUNTRY_CODE_TLDS:[Ljava/lang/String;

    invoke-static {v1, v0}, Lorg/apache/commons/validator/routines/DomainValidator;->arrayContains([Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    sget-object v1, Lorg/apache/commons/validator/routines/DomainValidator;->COUNTRY_CODE_TLDS_PLUS:[Ljava/lang/String;

    invoke-static {v1, v0}, Lorg/apache/commons/validator/routines/DomainValidator;->arrayContains([Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    sget-object v1, Lorg/apache/commons/validator/routines/DomainValidator;->COUNTRY_CODE_TLDS_MINUS:[Ljava/lang/String;

    invoke-static {v1, v0}, Lorg/apache/commons/validator/routines/DomainValidator;->arrayContains([Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public isValidGenericTld(Ljava/lang/String;)Z
    .locals 3
    .param p1, "gTld"    # Ljava/lang/String;

    .prologue
    .line 225
    invoke-static {p1}, Lorg/apache/commons/validator/routines/DomainValidator;->unicodeToASCII(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lorg/apache/commons/validator/routines/DomainValidator;->chompLeadingDot(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 226
    .local v0, "key":Ljava/lang/String;
    sget-object v1, Lorg/apache/commons/validator/routines/DomainValidator;->GENERIC_TLDS:[Ljava/lang/String;

    invoke-static {v1, v0}, Lorg/apache/commons/validator/routines/DomainValidator;->arrayContains([Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    sget-object v1, Lorg/apache/commons/validator/routines/DomainValidator;->GENERIC_TLDS_PLUS:[Ljava/lang/String;

    invoke-static {v1, v0}, Lorg/apache/commons/validator/routines/DomainValidator;->arrayContains([Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    sget-object v1, Lorg/apache/commons/validator/routines/DomainValidator;->GENERIC_TLDS_MINUS:[Ljava/lang/String;

    invoke-static {v1, v0}, Lorg/apache/commons/validator/routines/DomainValidator;->arrayContains([Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public isValidInfrastructureTld(Ljava/lang/String;)Z
    .locals 3
    .param p1, "iTld"    # Ljava/lang/String;

    .prologue
    .line 213
    invoke-static {p1}, Lorg/apache/commons/validator/routines/DomainValidator;->unicodeToASCII(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lorg/apache/commons/validator/routines/DomainValidator;->chompLeadingDot(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 214
    .local v0, "key":Ljava/lang/String;
    sget-object v1, Lorg/apache/commons/validator/routines/DomainValidator;->INFRASTRUCTURE_TLDS:[Ljava/lang/String;

    invoke-static {v1, v0}, Lorg/apache/commons/validator/routines/DomainValidator;->arrayContains([Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    return v1
.end method

.method public isValidLocalTld(Ljava/lang/String;)Z
    .locals 3
    .param p1, "lTld"    # Ljava/lang/String;

    .prologue
    .line 251
    invoke-static {p1}, Lorg/apache/commons/validator/routines/DomainValidator;->unicodeToASCII(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lorg/apache/commons/validator/routines/DomainValidator;->chompLeadingDot(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 252
    .local v0, "key":Ljava/lang/String;
    sget-object v1, Lorg/apache/commons/validator/routines/DomainValidator;->LOCAL_TLDS:[Ljava/lang/String;

    invoke-static {v1, v0}, Lorg/apache/commons/validator/routines/DomainValidator;->arrayContains([Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    return v1
.end method

.method public isValidTld(Ljava/lang/String;)Z
    .locals 2
    .param p1, "tld"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x1

    .line 196
    invoke-static {p1}, Lorg/apache/commons/validator/routines/DomainValidator;->unicodeToASCII(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 197
    iget-boolean v1, p0, Lorg/apache/commons/validator/routines/DomainValidator;->allowLocal:Z

    if-eqz v1, :cond_1

    invoke-virtual {p0, p1}, Lorg/apache/commons/validator/routines/DomainValidator;->isValidLocalTld(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 200
    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-virtual {p0, p1}, Lorg/apache/commons/validator/routines/DomainValidator;->isValidInfrastructureTld(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {p0, p1}, Lorg/apache/commons/validator/routines/DomainValidator;->isValidGenericTld(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {p0, p1}, Lorg/apache/commons/validator/routines/DomainValidator;->isValidCountryCodeTld(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v0, 0x0

    goto :goto_0
.end method
