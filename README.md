## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

### 기능 목록
#### view
1. inputView
   1. 사용자가에게 점에 대한 좌표 정보를 입력요청 한다.
   2. 좌표값과 좌표값 사이는 '-' 문자로 구분한다.2~4개 제한기능
   3. 좌표 정보는 괄호"(", ")"로 둘러쌓여 있으며 쉼표(,)로 x값과 y값을 구분한다.(범위 제한  24)
   4. 입력 범위를 초과할 경우 에러 문구를 출력하고 다시 입요청을 한다.
2. outView
   1. 정상적인 좌표값을 입력한 경우, 해당 좌표에 특수문자를 표시한다.
#### model
1. 좌표(CoordinatePoint)
   1. X, Y 모두 1~24까지 제한기능 , 초과 IllegalArgumentException 예외 처리 
   2. 같은 좌표를 가지면 같아야 한다.
   3. 두점 사이의 거리 구하는 기능.
   4. 두점의 x가 같은지 기능
   5. 두정의 y가 같은지 기능
2. 면적 Area Interface
   1. 직선 , 직사각형 , 삼각형의 Interface
3. 직선길이구하기(StraightLengthCalculator)
   1. 두점 사이 거리를 리포트한다.
4. 직사각형 면적 계산한다.(RectangularAreaCalculator)
   1. 직사각형만 허용. 아니면 예외처리
   2. 직사각형 면적을 계산한다.
5. 삼각형 면적 계산한다.(TriangularAreaCalculator)
   1. 삼각형 면적을 계산한다.
6. 유효성 검사(Validator)
   1. 각 유형의 점 개수 맞는지 확인
   2. 중복된 점이 있는지 확인
#### controller
1. 좌표값을 두 개 입력한 경우, 두 점을 있는 직선으로 가정한다.
2. 좌표값을 네 개 입력한 경우, 네 점을 연결하는 사각형으로 가정한다.
3. 좌표값을 세 개 입력한 경우, 세 점을 연결하는 삼각형으로 가정한다.


---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```
