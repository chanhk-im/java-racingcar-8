# java-racingcar-precourse

## 요구 사항

- 차 이름 입력
    - 이름은 쉼표를 기준으로 구분, 5자 이하만 가능
    - 잘못된 값 입력 시 예외처리
- 시도 횟수
    - 양의 정수만 가능
    - 잘못된 값 입력 시 예외처리

- 각 횟수마다
    - 각 차마다 무작위 값을 가지고 옴
    - 각 차는 조건에 맞으면 전진하고, 그렇지 않으면 가만히 있음
        - 전진 조건: 0~9 사이 무작위 값을 구한 후, 그 값이 4 이상일 경우

- 모든 이동을 마치면, 우승자를 선정함.
    - 우승자는 가장 많이 전진한 자동차
    - 한 명 이상일 수 있음

## Classes

-`Car`
  - 변수: 이름, 위치
  - 움직이기: 위치 + 1

-`InputManager`
  - name을 받고 입력받은 데이터를 리턴
  - 횟수 입력받아 리턴

- `UserView`
  - 콘솔 상에 프린트하는 유틸리티 매서드 모아 둠

- `UserViewConstant`
  - UserView에서 사용되는 String 모아 둠

- `NameParser`
  - raw 데이터를 name list로 변환

- `RacingConstant`
  - `RANDOM_NUMBER_MAX`(최대 랜덤값 = 9)
  - `MOVEMENT_THRESHOLD`(이동하는 기준 = 4)

-`RacingService`
  - 랜덤 값 받아오기
  - 조건 체크(4 이상인지)
  - 조건 만족하면 한칸 이동
  - 우승자 반환(WinnerSelector 호출해서)

- `WinnerSelector`
  - `Car` 객체 `ArrayList` 받아와서 우승자 반환

- `RandomPicker`
  - 0~N까지 숫자 중 하나 랜덤 받아오기

- `RacingController`
  - 유저에게 이름 입력받기(`InputManager` 호출)
  - 횟수 입력받기(`InputManager` 호출)
  - racing 로직 실행(`RacingService` 호출), `RacingWinners` 가져오기
  - Winner 출력(`UserView` 호출)

- `RacingInformation`(DTO)
  - `Controller` -> `Service`로 전달하는 객체
  - 참여 `Car`의 `ArrayList`
  - 시도 횟수

- `RacingWinners`(VO)
  - `Service`->`Controller`로 전달하는 객체
  - 우승자 `ArrayList`

- `RacingWinnersToUserView`(VO)
  - `Controller`->`UserView`로 전달하는 객체
  - 우승자 `ArrayList`