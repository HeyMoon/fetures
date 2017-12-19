package com.dyh.transaction.api.enums;

public enum GlobalTransactionProcessExpectedStatusEnum{

    /**
     *
     **/
    Success((byte)1,"成功"),

    /**
     *
     **/
    HasRollback((byte)2,"已回滚");


    private final byte value;
    private final String desc;

    GlobalTransactionProcessExpectedStatusEnum(byte value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public byte getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static GlobalTransactionProcessExpectedStatusEnum findByValue(byte value) {
        switch (value) {

            case 1:
                return Success;

            case 2:
                return HasRollback;

            default:
                return null;
        }
    }
}
      