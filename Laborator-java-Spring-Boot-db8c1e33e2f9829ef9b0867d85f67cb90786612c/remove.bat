
@echo off
rem Define service name
set serviceName=CloudflaredService

rem Stop and delete the cloudflared service if it exists
sc query %serviceName% >nul 2>&1
if %errorlevel% equ 0 (
    net stop %serviceName%
    sc delete %serviceName%
    echo Service %serviceName% stopped and deleted.
) else (
    echo Service %serviceName% does not exist.
)

rem Remove cloudflared from the PATH and environment variable
set CLOUDFLARED_HOME="C:\Program Files\cloudflared"
reg delete "HKCU\Environment" /F /V CLOUDFLARED_HOME
reg delete "HKCU\Environment" /F /V PATH /F

rem Remove cloudflared.exe
if exist "C:\Program Files\cloudflared\" (
    rd /s /q "C:\Program Files\cloudflared\"
    echo cloudflared.exe deleted.
) else (
    echo cloudflared.exe does not exist.
)

rem Remove SSH config modifications
set sshConfigPath=%USERPROFILE%\.ssh\config
if exist "%sshConfigPath%" (
    findstr /v "Host ssh.xr50.work" "%sshConfigPath%" > "%sshConfigPath%.tmp" && move "%sshConfigPath%.tmp" "%sshConfigPath%"
    echo SSH config updated.
) else (
    echo SSH config file does not exist.
)

pause
