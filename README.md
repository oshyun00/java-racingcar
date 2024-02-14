# java-racingcar

자동차 경주 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

---
## 단어 정의
- 시도(try): 각 라운드를 의미한다. 매 라운드(시도)마다 자동차들은 전진하거나 멈춰있는다.
- 전진(forward): 실제로 차량이 앞으로 한칸 움직인다.

## 📄 기능 요구사항 정의

### 게임 시작
- [x] 자동차 이름을 입력받는다
  - [x] 자동차 이름은 쉼표로 구분해야 한다
  - [x] 자동차 이름은 공백 포함 5자 이하여야 한다
  - [x] 자동차 이름은 중복될 수 없다
  - [x] 자동차는 한 대 이상어야아 한다
- [x] 시도 횟수를 입력받는다
  - [x] 시도 횟수는 숫자여야 한다
  - [x] 시도 횟수는 1 이상이어야한다

### 게임 진행
- [x] 각 라운드마다 모든 자동차가 전진을 시도한다
  - [x] 0~9 사이의 랜덤값을 구해 4 이상인 경우 전진 가능하다고 판단한다
  - [x] 전진 가능 여부에 따라 전진한다
  - [x] 전진 결과를 출력한다

### 게임 종료
- [ ] 우승자를 출력한다
  - [ ] 우승자는 한 명 이상일 수 있다

---
## 부록
### 생각 로그
- 요구사항 정의 목표: 유저가 게임 동작 과정을 이해할 수 있게 작성한다.