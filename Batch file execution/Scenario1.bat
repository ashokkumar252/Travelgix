set projectLocation=C:\\shiplogix\Project
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\Scenario1.xml
pause