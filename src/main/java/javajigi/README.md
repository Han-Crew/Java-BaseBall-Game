### TODO 

* 1~9 의 숫자 중 랜덤으로 3개의 숫자를 구한다.
* 사용자로부터 입력받는 3개 숫자 예외 처리
    * 1~9의 숫자인가?
    * 중복 값이 있는가?
    * 3자리인가?
* 위치와 숫자값이 같은 경우 - 스트라이크
* 위치는 다른데 숫자값이 같은 경우 - 볼
* 숫자 값이 다른 경우 - 아웃
* 사용자가 입력한 값에 대한 실행 결과를 구하라


---
com / user <br>
123 / 456 -> 3 OUT <br>
123 / 245 -> 1 BALL 2 OUT <br>
123 / 145 -> 1 STRIKE , 2 OUT <br>

playResult result = BaseBall.play(List.of(1 , 2 , 3) , List.of(4 , 5 , 6));

--- 
com / user <br>
123 / 1 4 -> OUT <br>
123 / 1 2 -> BALL <br>
123 / 1 1 -> STRIKE

--- 
com / user <br>

(position , number) <br>
1 4 , 1 4 -> STRIKE
1 4 , 2 4 -> BALL
1 4 , 2 5 -> OUT