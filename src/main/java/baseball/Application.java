package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        int[] userNumbersArray = new int[3]; // 유저가 입력한 숫자 배열
        int[] randomNumbersArray = new int[3];

        int strike = 0;
        int ball = 0;

        while (true) {

            for (int i = 0; i < 3; i++) {
                randomNumbersArray[i] = Randoms.pickNumberInRange(1,9);
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


            //유저한테 숫자 받기
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String inputNumbers = Console.readLine();

                // 3자리 확인
                if(inputNumbers.length() != 3) {
                    throw new IllegalArgumentException();
                }

                //숫자가 아닌 경우
                for (int i = 0; i < userNumbersArray.length; i++) {
                    char numberChar = inputNumbers.charAt(i);

                    if (!Character.isDigit(numberChar)) {
                        throw new IllegalArgumentException();
                    }
                    userNumbersArray[i] = Character.getNumericValue(numberChar);
                }

                    // 동일 숫자 확인
                    for (int j = 0; j < userNumbersArray.length; j++) {
                        for (int k = j + 1 ; k < userNumbersArray.length; k++) {
                            if (userNumbersArray[j] == userNumbersArray[k]) {
                                throw new IllegalArgumentException();
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
            String choiceInput = Console.readLine();
            int choice = Integer.parseInt(choiceInput);

            if (choice == 1) {
                continue;
            } else if (choice == 2) {
                break;
            } else {
                throw new IllegalArgumentException();
            }

        }

    }

}
