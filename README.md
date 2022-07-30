코스플레이어를 위한 맞춤 플랫폼

개요 

WEB 서비스를 담당하는 프로젝트. REST / PAGE 서비스 제공 한다.


개발환경

- Java 11 / Spring Boot / Gradle
- 인프라 : MySQL, REDIS, 

## Build & Deploy

```bash
# Costarica Build (Test 제외)
$ ./gradlew build -x test 

# Send JAR to EC2 Instance
$ scp -i ~/.ssh/costarica-api.pem /Users/beau.kim/workspace/costarica/build/libs/web-1.0.0.jar ubuntu@13.209.3.54:/home/ubuntu

# 프로세스 확인
$ ps -ef | grep java

# 프로세스 Kill
$ kill -9 PID

# nohup jar Background 실행
$ nohup java -jar web-1.0.0.jar -Dspring.profiles.active=default &> /dev/null 2>&1 &
```
