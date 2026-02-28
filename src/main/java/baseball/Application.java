package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        int[] userNumbersArray = new int[3]; // 유저가 입력한 숫자 배열
        int[] randomNumbersArray = new int[3];

        while (true) {

            computerRandomNumbers(randomNumbersArray);

            // 컴퓨터 랜덤 숫자 출력 > 완료 후 주석처리
            System.out.println(Arrays.toString(randomNumbersArray));

            //유저한테 숫자 받기
            while (true) {

                System.out.print("숫자를 입력해주세요 : ");
                String inputNumbers = Console.readLine();

                // 3자리 확인
                validateThreeNumber(inputNumbers);

                //숫자가 아닌 경우
                validateNumber(userNumbersArray,inputNumbers);

                // 동일 숫자 확인
                sameNumbers(userNumbersArray);

                //스트라이크,볼 숫자 세기
                int[] result = calculateStrikeAndBall(randomNumbersArray, userNumbersArray);

                int strike = result[0];
                int ball = result[1];

                //스트라이크,볼 값 조건에 맞춰서 출력하기
              printStrikeAndBall(strike, ball);

                if (strike == 3) {
                    break;
                }

            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choiceInput = Console.readLine();
            int choice = Integer.parseInt(choiceInput);

            validateChoice(choice);

            if (choice == 2) {
                break;
            }

        }

    }



    public static void computerRandomNumbers(int[] randomNumbersArray) {
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
    }

    public static void validateNumber(int[] userNumbersArray, String inputNumbers) {
        for (int i = 0; i < userNumbersArray.length; i++) {
            char numberChar = inputNumbers.charAt(i);

            if (!Character.isDigit(numberChar)) {
                throw new IllegalArgumentException();
            }
            userNumbersArray[i] = Character.getNumericValue(numberChar);
        }
    }

    public static void validateThreeNumber(String inputNumbers) {
        if(inputNumbers.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void sameNumbers(int[] userNumbersArray) {
        for (int j = 0; j < userNumbersArray.length; j++) {
            for (int k = j + 1 ; k < userNumbersArray.length; k++) {
                if (userNumbersArray[j] == userNumbersArray[k]) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public static int[] calculateStrikeAndBall(int[] randomNumbersArray, int[] userNumbersArray) {

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < randomNumbersArray.length; i++) {
            for (int j = 0; j < userNumbersArray.length; j++) {
                if (randomNumbersArray[i] == userNumbersArray[j] && i == j) {
                    strike++;
                } else if (randomNumbersArray[i] == userNumbersArray[j] && i != j) {
                    ball++;
                }
            }
        }

        return new int[]{strike,ball};
    }

    public static void printStrikeAndBall(int strike, int ball) {

            if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            } else if (strike == 0 && ball == 0) {
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

    public static void validateChoice(int choice) {
        if (choice == 1) {

        } else if (choice == 2) {

        } else {
            throw new IllegalArgumentException();
        }
    }

}
