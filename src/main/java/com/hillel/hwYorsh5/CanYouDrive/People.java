package com.hillel.hwYorsh5.CanYouDrive;

import java.util.Objects;

public class People {

    private boolean driverLicense;
    private boolean passport;
    private int noPenalty;

    public People(boolean driverLicense, boolean passport, int noPenalty) {
        this.driverLicense = driverLicense;
        this.passport = passport;
        this.noPenalty = noPenalty;
    }

    public boolean isDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(boolean driverLicense) {
        this.driverLicense = driverLicense;
    }

    public boolean isPassport() {
        return passport;
    }

    public void setPassport(boolean passport) {
        this.passport = passport;
    }

    public int getNoPenalty() {
        return noPenalty;
    }

    public void setNoPenalty(int noPenalty) {
        this.noPenalty = noPenalty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return driverLicense == people.driverLicense && passport == people.passport && noPenalty == people.noPenalty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverLicense, passport, noPenalty);
    }

    @Override
    public String toString() {
        return "People {" +
                "driverLicense = " + driverLicense +
                ", passport = " + passport +
                ", noPenalty = " + noPenalty +
                '}';
    }
}
