@echo off
@ECHO:
@ECHO:
@ECHO -----------------------------------------
@echo [quiz-business] Run Maven Profile Generate JIBX
@ECHO -----------------------------------------
call del ..\quiz-business\src\main\jibx\business\binding.xml
call mvn -f ..\quiz-business\pom.xml generate-sources -P generate-jibx


@ECHO:
@ECHO:
@ECHO -----------------------------------------
@ECHO quiz-business] Moving all file to package entities
@ECHO -----------------------------------------
call xcopy ..\quiz-business\src\main\jibx\business\com\zet\business\base\entities\*.java ..\quiz-business\src\main\java\com\zet\business\base\entities\ /E /Y
call del ..\quiz-business\src\main\jibx\business\com\zet\business\base\entities\ /Q
call ../build/tool/REPL.bat "trim-whitespace=\qtrue\q" "trim-whitespace=\qtrue\q force-classes=\qtrue\q" /x /f ..\quiz-business\src\main\jibx\business\binding.xml /o -


@ECHO:
@ECHO:
@ECHO -----------------------------------------
@echo [quiz-business] Run Maven Profile Generate Axis
@ECHO -----------------------------------------

call cd /d ..\quiz-business
call mvn generate-sources -P generate-axis


@ECHO:
@ECHO:
@ECHO -----------------------------------------
@ECHO quiz-business] Moving all file server, client, service's files
@ECHO -----------------------------------------
call xcopy ..\quiz-business\target\generated-sources\axis2\wsdl2code\src\com\zet\business\server\BusinessService.java ..\quiz-business\src\main\java\com\zet\business\client\BusinessService.java /F /Y

call xcopy ..\quiz-business\target\generated-sources\axis2\wsdl2code\src\com\zet\business\server\BusinessServiceCallbackHandler.java ..\quiz-business\src\main\java\com\zet\business\client\ /F /Y

call xcopy ..\quiz-business\target\generated-sources\axis2\wsdl2code\src\com\zet\business\server\BusinessServiceStub.java ..\quiz-business\src\main\java\com\zet\business\client\ /F /Y

rem Replace Package
call cd ../build/tool
call REPL.bat "com.zet.business.server" "com.zet.business.client" /f ..\..\quiz-business\src\main\java\com\zet\business\client\BusinessService.java /o -

call REPL.bat "com.zet.business.server" "com.zet.business.client" /f ..\..\quiz-business\src\main\java\com\zet\business\client\BusinessServiceCallbackHandler.java /o -

call REPL.bat "com.zet.business.server" "com.zet.business.client" /f ..\..\quiz-business\src\main\java\com\zet\business\client\BusinessServiceStub.java /o -

call xcopy ..\..\quiz-business\target\generated-sources\axis2\wsdl2code\src\com\zet\business\server\BusinessServiceSkeletonInterface.java ..\..\quiz-business\src\main\java\com\zet\business\server\ /F /Y

call xcopy ..\..\quiz-business\target\generated-sources\axis2\wsdl2code\src\com\zet\business\server\BusinessServiceMessageReceiverInOut.java ..\..\quiz-business\src\main\java\com\zet\business\server\ /F /Y

call xcopy ..\..\quiz-business\target\generated-sources\axis2\wsdl2code\resources\BusinessService.wsdl ..\..\quiz-business\src\main\webapp\WEB-INF\services\BusinessService\META-INF\ /F /Y

call xcopy ..\..\quiz-business\target\generated-sources\axis2\wsdl2code\resources\scylla.xsd ..\..\quiz-business\src\main\webapp\WEB-INF\services\BusinessService\META-INF\ /F /Y

call xcopy ..\..\quiz-business\target\generated-sources\axis2\wsdl2code\resources\services.xml ..\..\quiz-business\src\main\webapp\WEB-INF\services\BusinessService\META-INF\ /F /Y

rem Add java.io.Serializable
call REPL.bat "class Menu" "class Menu implements java.io.Serializable" /f ..\..\quiz-business\src\main\java\com\zet\business\base\entities\Menu.java /o -
