# kt_study2
코틀린 소리/진동알림
버튼을 누를 때 소리, 진동 알림이 울림

헤더에 추가해줘야 함
```
import androidx.annotation.RequiresApi
```

1. 소리 알림
- 안드로이드 시스템 알림
- 자체 음원 재생

2. 진동 알림
- 31 이전 버전 : VIBRATOR_SERVICE로 식별되는 시스템 서비스 이용
- 31 및 이후 버전 : VIBRATOR_MANAGER_SERVICE로 식별되는 VibratorManager이라는 시스템 서비스를 얻고
이 서비스에서 Vibrator을 이용
