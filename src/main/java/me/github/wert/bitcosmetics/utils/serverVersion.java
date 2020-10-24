package me.github.wert.bitcosmetics.utils;

public enum serverVersion
{
    v1_8_R1("1.8.0"),
    v1_8_R2("1.8.3"),
    v1_8_R3("1.8.8"),
    v1_9_R1("1.9"),
    v1_9_R2("1.9.4"),
    v1_10_R1("1.10"),
    v1_11_R1("1.11"),
    v1_12_R1("1.12"),
    v1_13_R1("1.13"),
    v1_13_R2("1.13.2"),
    v1_14_R1("1.14.4"),
    v1_15_R1("1.15.2");

    String name;

    serverVersion(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}