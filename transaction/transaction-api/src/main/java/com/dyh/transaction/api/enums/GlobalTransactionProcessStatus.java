package com.dyh.transaction.api.enums;


public enum GlobalTransactionProcessStatus {

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
    Unknown((byte)4,""),

    /**
     *
     **/
    HasRollback((byte)5,"");


    private final byte value;
    private final String desc;


    GlobalTransactionProcessStatus(byte value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public byte getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static GlobalTransactionProcessStatus findByValue(byte value) {
        switch (value) {

            case (byte)1:
                return New;

            case (byte)2:
                return Success;

            case (byte)3:
                return Fail;

            case (byte)4:
                return Unknown;

            case (byte)5:
                return HasRollback;

            default:
                return null;
        }
    }
}
      