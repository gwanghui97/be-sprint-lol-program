package com.java.seb.lol_solution;

public class Player {
    private String name;
    private int attackPower;
    private int defensePower;
    private int healthPower;

    public Player(String name, int attackPower, int defensePower, int healthPower) {
        this.name = name;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.healthPower = healthPower;
    }

    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public int getHealthPower() {
        return healthPower;
    }

    public void setHealthPower(int healthPower) {
        this.healthPower = healthPower;
    }
}
