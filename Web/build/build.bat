@echo off
@echo [quiz-business]Run Maven Install
@echo ----------------------------------
call cd /d ../quiz-business
call mvn clean install -Dmaven.test.skip=true
call mvn -f pom-client.xml install -Dmaven.test.skip=true

@echo [quiz-web] Run Maven Install
call cd /d ../quiz-web
call mvn clean install -Dmaven.test.skip=true

