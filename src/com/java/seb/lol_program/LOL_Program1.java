package com.java.seb.lol_program;

import java.util.Scanner;

public class LOL_Program1 {
  public static void main(String[] args) {
    //TODO:
    System.out.println("[안내] TRG 스타크래프트 시작합니다.");
    System.out.println("[안내] 자신의 유닛 정보를 입력해 주세요.");

    LoL_char1 myUser = new LoL_char1();
    String[] myUserStringArray = myUser.user_create();
    myUser.user_print(myUserStringArray);

    int[] myUserIntegerArray = myUser.user_info_int(myUserStringArray);

    System.out.println("[안내] 상대의 유닛 정보를 입력해 주세요.");

    LoL_char1 anotherUser = new LoL_char1();
    String[] anotherUserStringArray = anotherUser.user_create();
    anotherUser.user_print(anotherUserStringArray);

    int[] anotherUserIntegerArray = anotherUser.user_info_int(anotherUserStringArray);

    Scanner sc = new Scanner(System.in);
    System.out.println("몇 번 공격하실 건가요?");
    int count = 0;
    count = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < count; i++) {
      if (anotherUserIntegerArray[2] <= 0) {
        myUser.attack(myUserIntegerArray, anotherUserIntegerArray);
      }
    }
  }
}