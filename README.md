#MadCamp-1

##Major Features
   같은 그림 찾기 게임을 할 수 있습니니다.
   야바위 게임을 할 수 있습니다.
   두더지 잡기 게임을 할 수 있습니다.
   가위,바위,보 게임을 할 수 있습니다.
   
   
  #가술 설명
  
  ##1.같은 그림 찾기 게임
      이미지 리스트를 배열형식으로 받았습니다.
      각 자리에 인덱스 부여, 이미지 리스트 총 8 칸에 4쌍의 같은 이미지 데이터 등록하여 카드를 섞었습니다.
      뒤집힌 카드는 중복으로 클릭을 못하게 방지하였고 , 두 장의 선택한 카드가 매치되지 않을 시 카드를 다시 뒤집는 기능을 넣었습니다.
      기회 3번 , 클리어 횟수를 xml에 표현하였습니다.
    
   ##2.야바위 게임
       컵과 공을 View.VISIBLE/INVISIBLE을 사용하여 게임을 표현하였습니다.
       duration으로 섞는 속도를 조절하였고 맞추면 속도 업, 틀리면 속도 다운 하여주어 level 단계를 왼쪽 상단에 표현하였습니다.
       두개의 컵을 섞는 애니메이션은 라디안 함수를 사용하여 다음과 같이 구현하였습니다. 
        
        ```java
       
            xPosition = fromXPosition;
            yPosition = fromYPosition;
            centerXPosition = fromXPosition + (toXPosition - fromXPosition)/2;
            centerYPosition = fromYPosition + (toYPosition - fromYPosition)/2;
            radius = (float) Math.sqrt(Math.pow(centerXPosition - toXPosition, 2) + Math.pow(centerYPosition - toYPosition, 2));
            oneCycleDegree = 180 / (duration * 250);
            if (fromXPosition == toXPosition && fromYPosition > toYPosition) {
                degree = (float) Math.toDegrees(Math.acos((fromXPosition - centerXPosition) / radius));
            } else {
                degree = (float) Math.toDegrees(Math.acos((fromXPosition - centerXPosition) / radius)) * -1;
            }
            isFinish = false;
            while (true) {
                if (xPosition >= toXPosition - 5 / duration && xPosition <= toXPosition + 5 / duration
                        && yPosition >= toYPosition - 5 / duration && yPosition <= toYPosition + 5 / duration) {
                    xPosition = toXPosition;
                    yPosition = toYPosition;
                    isFinish = true;
                }
            ```
            목숨과 클리어 횟수로 점수를 표현하였습니다.
            
     ##3.두더지게임
            Thread handler를 이용하였습니다.
            각 두더지마다 쓰레드를 주고 랜덤으로 튀어나오는 횟수와 시간을 부여했습니다.
            두더지게임을 위한 두더지사진 2장 (들어가있는 모습/튀어나온 모습) 을 구해 넣어놓고 배열에 아이디를 넣었습니다.
            게임이 끝나면 결과성적을 가지고 ResultActivity.java로 이동하게 하였습니다.
            기록을 저장하기 위해 SharedPreference 을 사용하였고, 신기록을 달성하는 경우 문구를 띄워주게 하였습니다.
            
            
            
     ##4.가위바위보

           CountDownTimer 라이브러리를 이용하여 COM이 사용자가 가위/바위/보를 선택하는 순간 결정되어 논리를 비교를 구현하였습니다.
            
              
