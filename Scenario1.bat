set projectLocation=C:\Wastaautomation\Project
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\Scenario4.xml
pause