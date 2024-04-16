package com.java.seb.lol_solution;

public class TextRpgGame {
    private final Player player1;
    private final Player player2;

    public TextRpgGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void PlayGame() {
        // 조건 1. 적군의 체력이 0 이하면 [유닛 제거] 가 됩니다.
        // 조건 2. 적군 체력이 0 이하가 아니라면 공격을 성공적으로 수행합니다.
        // 공격 정책 수식 : 적군 체력 -= 아군 유닛 공격력 / 적군 유닛 방어력

        // 개선 포인트
        // 조건 1. 아군 or 적군의 체력이 0 이하라면 [유닛 제거]가 됩니다.
        // 조건 2. 아군 or 적군의 체력이 0 이하가 아니라면 공격을 수행합니다.
            //조건 2-1. 아군이 공격하고, 적국도 공격해야 합니다.
        // 공격 정책 수식 : 적군 체력 -= 아군 유닛 공격력 / 적군 유닛 방어력
        while (player1.getHealthPower() > 0 && player2.getHealthPower() > 0) {
            int healthOfPlayer1 = player1.getHealthPower();
            int healthOfPlayer2 = player2.getHealthPower();
            int attackPowerOfPlayer1 = player1.getAttackPower();
            int attackPowerOfPlayer2 = player2.getAttackPower();
            int defensePowerOfPlayer1 = player1.getDefensePower();
            int defensePowerOfPlayer2 = player2.getDefensePower();

            System.out.println("-".repeat(40));
            System.out.printf("[안내] [%s]유닛이 [%s]유닛을 [공격] 하였습니다.%n", player1.getName(), player2.getName());

            player2.setHealthPower(healthOfPlayer2 - getAttackPoint(attackPowerOfPlayer1, defensePowerOfPlayer2));
            if(player2.getHealthPower() > 0) {
                System.out.printf("[안내] %s 유닛의 남은 [체력]은 %d입니다.%n", player2.getName(), player2.getAttackPower());
            }

            System.out.println("-".repeat(40));
            System.out.printf("[안내] [%s]유닛이 [%s]유닛을 [공격] 하였습니다.%n", player2.getName(), player1.getName());

            player1.setHealthPower(healthOfPlayer1 - getAttackPoint(attackPowerOfPlayer2, defensePowerOfPlayer1));
            if(player1.getHealthPower() > 0) {
                System.out.printf("[안내] %s 유닛의 남은 [체력]은 %d입니다.%n", player1.getName(), player2.getAttackPower());
            }
        }

        String currentDeathPlayerName = player1.getHealthPower() <= 0 ? player2.getName() : player1.getName();

        System.out.println("-".repeat(40));
        System.out.println("[안내] 더 이상 공격할 수 없습니다.");
        System.out.printf("[안내] %s 유닛이 사망했습니다.", currentDeathPlayerName);
    }
    private int getAttackPoint(int attackPowerPlayer1, int defensePowerPlayer2) {
        return attackPowerPlayer1 / defensePowerPlayer2;
    }
}
