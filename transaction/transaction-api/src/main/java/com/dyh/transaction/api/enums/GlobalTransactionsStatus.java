package com.dyh.transaction.api.enums;


public enum GlobalTransactionsStatus {

    /**
     *
     **/
    New((byte)1,""),

    /**
     *
     **/
    Success((byte)2,""),

    /**
     *
     **/
    Fail((byte)3,""),

    /**
     *
     **/
    HasRollback((byte)4,""),

    /**
     *
     **/
    PartiallyRollback((byte)5,""),

    /**
     *
     **/
    Suspend((byte)99,"");


    private final byte value;
    private final String desc;

    GlobalTransactionsStatus(byte value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public byte getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static GlobalTransactionsStatus findByValue(byte value) {
        switch (value) {

            case 1:
                return New;

            case 2:
                return Success;

            case 3:
                return Fail;

            case 4:
                return HasRollback;

            case 5:
                return PartiallyRollback;

            case 99:
                return Suspend;

            default:
                return null;
        }
    }
}
      