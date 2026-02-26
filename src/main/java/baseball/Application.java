package baseball;

import java.lang.reflect.Array;
import java.util.*;

public class Application {
    public static void main(String[] args) {

        int[] userNumbersArray = new int[3]; // 유저가 입력한 숫자 배열
        int[] randomNumbersArray = new int[3]; //랜덤 숫자 배열
        int strike = 0;
        int ball = 0;

        while (true) {

            for (int i = 0; i < randomNumbersArray.length; i++) {
                randomNumbersArray[i] = (int) (Math.random() * 9 + 1);
                for (int j = 0; j < i; j++) {
                    if (randomNumbersArray[i] == randomNumbersArray[j]) {
                        i--;
                        break;
                    }
                }
            }
            for (int n : randomNumbersArray) { // 향상된 for문을 사용해야 마지막값만 담을수있음
                // System.out.println(n + "");
            }
            System.out.println(Arrays.toString(randomNumbersArray)); //향상된 for문 만들기 전 랜덤숫자 확인방법

            Scanner inputNumber = new Scanner(System.in); // >> scanner 쓰면 안됨 

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String inputNumbers = inputNumber.nextLine();
                for (int i = 0; i < userNumbersArray.length; i++) {
                    userNumbersArray[i] = inputNumbers.charAt(i) - '0'; //?

                    // 3자리 확인
                    if(inputNumbers.length() != userNumbersArray.length){
                        throw new IllegalArgumentException();
                    }

                    // 동일 숫자 확인
                    for (int j = 0; j < userNumbersArray.length; j++) {
                        for (int k = i + 1 ; k < userNumbersArray.length; k++) {
                            if (userNumbersArray[k] == userNumbersArray[j]) {
                                throw new IllegalArgumentException();
                            }
                        }
                    }
                }

                strike = 0;
                ball = 0;

                    for (int i = 0; i < randomNumbersArray.length; i++) {
                        for (int j = 0; j < userNumbersArray.length; j++) {
                            if (randomNumbersArray[i] == userNumbersArray[j] && i == j) {
                                strike++;
                            } else if (randomNumbersArray[i] == userNumbersArray[j] && i != j) {
                                ball++;
                            }
                        }
                    }

                if (strike == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
                if (strike == 0 && ball == 0) {
                        System.out.print("낫싱");
                        System.out.println("");
                    } else {
                        if (ball > 0) {
                            System.out.print(ball + "볼 ");
                        }
                        if (strike > 0 && strike <= 2) {
                            System.out.print(strike + "스트라이크");
                        }
                        System.out.println("");
                    }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Scanner choiceNumber = new Scanner(System.in);
            int choice = choiceNumber.nextInt();

            if (choice == 1) {
                continue;
            } else if (choice == 2) {
                break;
            }

        }

    }

}
