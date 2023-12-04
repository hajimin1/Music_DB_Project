# Music_DB_Project

### 1. Mini-World Problem
음원
: 사용자가 음원과 관련된 정보를 검색하고, 본다.

### 2. Requirements 정의
1. 한 명의 가수는 여러 개의 앨범을 발매할 수 있다.
2. 여러 가수가 모여 하나의 앨범을 낼 수 있다.
3. 가수는 고유한 식별번호, 가수 이름, 성별, 소속 그룹 이름을 갖는다.
4. 앨범은 고유한 발매 일자, 하트 수, 커버 이미지를 갖는다.
5. 앨범은 가수의 식별번호와 고유한 발매 일자로 구분한다.
6. 가수는 그룹을 이룰 수 있다.
7. 그룹은 고유한 이름, 프로필 이미지를 갖는다.
8. 하나의 앨범은 여러 노래를 가진다.
9. 하나의 노래는 고유한 식별번호, 이름, 여러 개의 장르를 가질 수 있다.
10. 어느 가수라도 같은 노래를 가질 수 없다.
11. 하나의 플레이리스트는 여러 노래를 담을 수 있다.
12. 하나의 플레이리스트는 하나의 커버 이미지를 갖는다.
13. 한 명의 사용자는 여러 노래를 플레이리스트에 담을 수 있다.
14. 사용자는 고유한 id, 비밀번호, 닉네임을 가지고 있다.
15. 플레이 로그는 재생 시간, 사용자 id, 노래 이름 가지고 있다.
16. 한 명의 사용자는 여러 개의 플레이 로그를 갖는다.
17. 한 명의 사용자는 여러 개의 플레이리스트를 갖는다.

### 3. ER Diagram 작성
![image](https://github.com/hajimin1/Music_DB_Project/assets/81867274/633755d1-95e4-4065-b9b7-40410487ae93)

### 4. Relation Schema 생성
![image](https://github.com/hajimin1/Music_DB_Project/assets/81867274/a0d34360-dcc8-4d09-bbef-91d548601862)

### 5. Normalization
- Before Normalization
![image](https://github.com/hajimin1/Music_DB_Project/assets/81867274/1f01c531-012b-4ed2-824d-86d0ab9d6119)

- Normalization
![image](https://github.com/hajimin1/Music_DB_Project/assets/81867274/5b17e0e6-4977-4faa-ba30-ab0ef8ea31bc)

2NF(fully functionally dependent on the primary key), 3NF(Transitive functional dependency 제거)를 만족한다.

- Note Foreign Key
![image](https://github.com/hajimin1/Music_DB_Project/assets/81867274/ee447458-5f6c-4929-af2d-06716d6d954e)
