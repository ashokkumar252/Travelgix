set projectLocation=C:\\Travlogix\Project
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\Executivemaster.xml
pause