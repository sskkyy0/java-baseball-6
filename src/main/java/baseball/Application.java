package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static int menu = 1;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (menu == 1) {
            game();
        }
    }

    public static void game() throws IllegalArgumentException {
        int strike, ball;
        //정답 3자리숫자 만들기
        List<Integer> correct = new ArrayList<>();
        while (correct.size() < 3) {
            int ranNum = Randoms.pickNumberInRange(1, 9);
            if (!correct.contains(ranNum)) {
                correct.add(ranNum);
            }
        }
        //정답확인
        while (true) {
            strike = 0;
            ball = 0;
            System.out.print("숫자를 입력해주세요 : ");

            String answer = readLine();

            int[] numbers = new int[answer.length()];
            for (int i = 0; i < answer.length(); i++) {
                numbers[i] = answer.charAt(i) - '0'; //정수 배열에 저장
            }
            for (int i = 0; i < 3; i++) { //확인과정
                if (correct.contains(numbers[i])) {
                    if (correct.get(i) == numbers[i])
                        strike++;
                    else ball++;
                }
            }

            //확인 결과 출력
            if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            if (strike == 0) {
                if (ball == 0)
                    System.out.println("낫싱");
                else System.out.println(ball + "볼");
            } else {
                if (ball == 0)
                    System.out.println(strike + "스트라이크");
                else System.out.println(ball + "볼 " + strike + "스트라이크");
            }

        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        menu = Integer.parseInt(readLine());
    }


}
