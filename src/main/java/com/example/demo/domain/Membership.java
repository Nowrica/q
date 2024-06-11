package com.example.demo.domain;

import java.sql.Timestamp;

public class Membership {
    private Type type;

    private Timestamp startDate;

    private Timestamp expirationDate;

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
