package com.example.demo.domain;

import java.sql.Timestamp;

public class Membership {
    private Type type;

    private final Timestamp startDate;

    private final Timestamp expirationDate;

    public Membership(Type type, Timestamp startDate, Timestamp expirationDate) {
        this.type = type;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
    }

    public static Membership createFree() {
        return new Membership(Type.FREE, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
    }

    public void upgrade() {
        type = Type.PREMIUM;
    }

    public void downgrade() {
        type = Type.BASIC;
    }

    public boolean isFree() {
        return type == Type.FREE;
    }

    public boolean isBasic() {
        return type == Type.BASIC;
    }

    public boolean isPremium() {
        return type == Type.PREMIUM;
    }

    public boolean isStarted() {
        return startDate.before(new Timestamp(System.currentTimeMillis()));
    }

    public boolean isExpired() {
        return expirationDate.before(new Timestamp(System.currentTimeMillis()));
    }

    public boolean isFreeAndExpired() {
        return isFree() && isExpired();
    }

    public int getLimit() {
        return type.getLimit();
    }
}
