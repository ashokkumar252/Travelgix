c:
for /r "C:\Travlogix\Filetoexecute" %%a in (*.bat) do (
   cd "%%~pa"
   call "%%~a"
)
