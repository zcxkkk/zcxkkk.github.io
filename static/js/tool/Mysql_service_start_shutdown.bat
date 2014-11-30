@echo off
:dosmenu
REM 选择菜单
echo #**********************************************************************#
echo       Mysql 服务启动关闭脚本 
echo #**********************************************************************#
echo       命令相关参数说明如下 快速切换
echo #**********************************************************************#
echo.
echo [1]启动mysql   [2]关闭mysql 
echo [1]Startup Mysql   [2]Shutdown Mysql 
echo press other key to exit... 
echo.
echo #**********************************************************************#
set /P CHS= press [1] or [2] then enter

if /I "%CHS%"=="1" (
  goto sumysql
)
if /I "%CHS%"=="2" (
  goto sdmysql
)
goto endla

:sumysql
REM  Startup Mysql
net start MySQL
pause
cls
goto dosmenu

:sdmysql
REM  Shutdown Mysql
net stop MySQL
pause
cls
goto dosmenu

:endla
REM Exit...
exit
