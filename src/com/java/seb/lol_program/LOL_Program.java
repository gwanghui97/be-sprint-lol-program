package com.java.seb.lol_program;

import java.util.Scanner;

public class LOL_Program {
  public static void main(String[] args) {
    //TODO:
    System.out.println("[안내] TRG 스타크래프트 시작합니다.");
    System.out.println("[안내] 자신의 유닛 정보를 입력해 주세요.");

    LoL_char myChar = new LoL_char();

    String[] user1 = myChar.user_create();
    System.out.println();
    myChar.user_print(user1);
    int[] myPower = myChar.user_info_int(user1);

    System.out.println("==================================");

    System.out.println("[안내] 상대 유닛 정보를 입력해 주세요.");
    LoL_char enChar = new LoL_char();

    String[] user2 = enChar.user_create();
    System.out.println();
    enChar.user_print(user2);
    int[] enPower = enChar.user_info_int(user2);
    System.out.println("==================================");

    myChar.attack(myPower, enPower);
    myChar.attack(myPower, enPower);
    myChar.attack(myPower, enPower);
  }
}