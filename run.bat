@echo off
set profile=%1
if not defined profile set profile=dev
echo profile set to %profile%
@echo on
mvn -e spring-boot:run -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_shmem,address=tomcat,server=y,suspend=n -Dfile.encoding=UTF-8" -Dspring-boot.run.directories=../countonrd/target/classes   -Dspring-boot.run.profiles=%profile%

#mvn spring-boot:run -Dspring-boot.run.arguments="--debug"   -Dspring-boot.run.profiles=dev
