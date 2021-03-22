# Capston_Design
### The Design and Implementation of a Mobile Healthcare Application For Pregnants
**2020 Capstone Design, Dept. of Computer Science &amp; Engineering, Incheon National University**
  
# 소개
### 임산부 건강관리의 필요성
  * 산모의 평균 연령이 높아짐에 따라 영양 관리 및 운동에 대한 중요성이 더욱 높아짐
  * 임산부는 건강관리가 중요함을 인지하고 있지만 관련 지식에 무지한 경우가 대부분임
### 스마트한 식단 관리와 요가 기능
  * 산모 나이와 출산예정일에 기반한 임산부 일일 영양소 섭취기준과 추천 알고리즘을 바탕으로 식단 관리
  * Tensorflow-Lite의 학습된 모델을 이용한 요가자세추정
### 임산부의 편의를 위한 기능
  * 인근 산부인과 검색(위치 기반)과 일정 관리

# 성과

# 요구사항
<details>
  <summary>상세 내용 확인</summary>
  <div markdown="1">

| 기능 | 설명 |
| --------------- | -------------------------------------------------- |
|출산 예정일 등록|출산 주차에 따라 산모에게 필요한 정보를 제공|
|산모 나이 등록|산모의 나이에 따라 식단 정보를 제공|
|식단 추천|일일 영양소 섭취기준과 추천 알고리즘을 바탕으로 식단 추천|
|요가|임산부에게 도움이 되는 요가를 볼 수 있음|
|자세추정|카메라를 사용해 자세를 인식하고, 주어지는 요가 이미지와 일치하는지 판별|
|인근 산부인과 검색|인근 산부인과 검색을 통해 응급시 신속히 가까운 병원을 찾을 수 있음|
|병원 일정 알리미|다음 병원 선생님과의 예약날짜를 입력하여 일정을 잊지 않도록 알려줌|
|회원정보 관리|회원가입, 로그인, 회원정보 수정, 알림 설정|

  </div>
</details>


# 설계

# 개발환경
<details>
  <summary>상세 내용 확인</summary>
  <div markdown="1">
       
### BE
| 구분 | 개발환경 | 개발도구 | 개발언어 |
| ----- | --------- | --------- | --------- |
|Server|VSCode|Node.js|JavaScript|
|DB|Robo 3T|MongoDB|MongoDB|
|\*HF|Pycharm|-|Python|

\*CF : Hybrid Filtering
  
### INFRA-AWS
| 구분 | 서비스 |
| --------- | ------------- |
|Computing|EC2 CentOS7|
|Storage|S3|
|CDN|CloudFront|
  
### FE
|구분|개발환경|개발도구|개발언어|
|--|--| -- |--|
|Front|Android Studio| - | Java & Kotlin |
  
  </div>
</details>

# API DOCS

