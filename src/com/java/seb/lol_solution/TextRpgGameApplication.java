package com.java.seb.lol_solution;

import java.util.Scanner;

public class TextRpgGameApplication {
    private static Scanner scanner = new Scanner(System.in);
    private final static String ME_PLAYER_INPUT_GUIDE_MESSEAGE = "[안내] 자신의 유닛 정보를 입력해 주세요.";
    private final static String ANOTHER_PLAYER_INPUT_GUIDE_MESSEAGE = "[안내] 상대의 유닛 정보를 입력해 주세요.";

    public static void main(String[] args) {
        displayWelcomeMessage();

        // 플레이어1 정보 입력 및 생성
        Player player1 = createPlayer(ME_PLAYER_INPUT_GUIDE_MESSEAGE);
        // 플레이어1 정보 출력
        displayPlayerInformation(player1);
        // 플레이어2 정보 입력 및 생성
        Player player2 = createPlayer(ANOTHER_PLAYER_INPUT_GUIDE_MESSEAGE);
        // 플레이어2 정보 출력
        displayPlayerInformation(player2);
        // 게임 시작
        playGame(player1, player2);
    }

    private static void playGame(Player player1, Player player2) {
        TextRpgGame textRpgGame = new TextRpgGame(player1, player2);
        textRpgGame.PlayGame();
    }

    private static void displayWelcomeMessage() {
        System.out.println("[안내] TRPG 스타크래프트 게임을 시작합니다.");
    }

    private static Player createPlayer(String str) {
        System.out.println(str);

        System.out.printf("[시스템] 유닛 [이름]을 입력해 주세요: ");
        String name = scanner.nextLine().trim();

        System.out.printf("[시스템] 유닛 [공격력]을 입력해 주세요: ");
        int attackPower = Integer.parseInt(scanner.nextLine().trim());

        System.out.printf("[시스템] 유닛 [방어력]을 입력해 주세요: ");
        int defensePower = Integer.parseInt(scanner.nextLine().trim());

        System.out.printf("[시스템] 유닛 [체력]을 입력해 주세요: ");
        int healthPower = Integer.parseInt(scanner.nextLine().trim());

        return new Player(name, attackPower, defensePower, healthPower);
    }

    private static void displayPlayerInformation(Player player) {
        System.out.println("[안내] 생성된 유닛의 정보는 다음과 같습니다.");
        System.out.printf("[안내] %s유닛이 게임에 참여하였습니다.%n", player.getName());
        System.out.printf("[공격력] : %d%n", player.getAttackPower());
        System.out.printf("[방어력] : %d%n", player.getDefensePower());
        System.out.printf("[체력] : %d%n", player.getHealthPower());
        System.out.println("=".repeat(40));
    }
}
