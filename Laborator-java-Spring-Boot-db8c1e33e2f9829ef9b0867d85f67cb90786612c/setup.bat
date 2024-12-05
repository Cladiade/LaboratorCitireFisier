
@echo off
rem Create the directory for cloudflared if it doesn't exist
if not exist "C:\Program Files\cloudflared\" mkdir "C:\Program Files\cloudflared\"

rem Prompt for port number
netstat -an | find ":5432 " >nul
if %errorlevel%==1 (
    REM If port 5432 is available, set portNumber to 5432
    set portNumber=5432
) else (
    REM If port 5432 is not available, prompt user for input
    set /p portNumber="Port 5432 already binded please enter the port number for the postgres database proxy: "
)
setx CLOUDFLARED_HOME "C:\Program Files\cloudflared" /m
setx PATH "%PATH%;%CLOUDFLARED_HOME%" /m

rem Download cloudflared
curl -o "C:\Program Files\cloudflared\cloudflared.exe" -L https://github.com/cloudflare/cloudflared/releases/latest/download/cloudflared-windows-amd64.exe

if exist "C:\Program Files\cloudflared\cloudflared.exe" (
  echo Download successful: "C:\Program Files\cloudflared\cloudflared.exe"
) else (
  echo Failed to download cloudflared.exe.
  exit /b 1
)

rem Define service name and paths
set serviceName=CloudflaredService
set exePath="C:\Program Files\cloudflared\cloudflared.exe access tcp --hostname postgres.xr50.work --url localhost:%portNumber%"

rem Delete the service if it already exists (optional)
sc query %serviceName% >nul 2>&1
if %errorlevel% equ 0 (
    net stop %serviceName%
    sc delete %serviceName%
)

rem Create the service
sc create %serviceName% binPath= %exePath% start= auto DisplayName= "Cloudflared Service"

rem Configure service to restart on failure
sc failure %serviceName% reset= 86400 actions= restart/5000

rem Start the service
net start %serviceName%

if %errorlevel% neq 0 (
    echo Failed to start the service %serviceName%.
) else (
    echo Service %serviceName% created and started successfully.
)

rem Append the ProxyCommand to the SSH config file in the user's .ssh folder
set sshConfigPath=%USERPROFILE%\.ssh\config

rem Create .ssh directory and config file if not exist
if not exist "%USERPROFILE%\.ssh" mkdir "%USERPROFILE%\.ssh"
if not exist "%sshConfigPath%" type nul > "%sshConfigPath%"

rem Append the required SSH config entry
echo Host ssh.xr50.work>>"%sshConfigPath%"
echo   ProxyCommand cloudflared access ssh --hostname %%h>>"%sshConfigPath%"

echo SSH config updated at %sshConfigPath%.

pause
