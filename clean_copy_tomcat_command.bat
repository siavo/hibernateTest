@ECHO OFF
SETLOCAL ENABLEDELAYEDEXPANSION
SET "sourcedir=%userprofile%\IdeaProjects\hibernate-test\build\libs"
SET "destdir=d:\apache-tomcat-10.1.28\webapps"
set olddir=%CD%
CD /d %destdir%
DEL /S /Q *.* 
RMDIR /S /Q %destdir%
cd /d "%olddir%"
COPY "%sourcedir%\ROOT.war" "%destdir%"