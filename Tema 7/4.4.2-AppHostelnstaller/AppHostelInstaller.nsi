
!include "MUI2.nsh"

; The name of the installer
Name "App Hostel"

; The file to write
OutFile "AppHostel-Dingo-Setup_1.0.exe"

; Request application privileges for Windows Vista
RequestExecutionLevel admin

; Build Unicode installer
Unicode True

; The default installation directory
InstallDir $PROGRAMFILES\AppHostel

; Registry key to check for directory (so if you install again, it will 
; overwrite the old one automatically)
InstallDirRegKey HKLM "Software\NSIS_AppHostel" "Install_Dir"

;--------------------------------
;Variables

Var StartMenuFolder

;Interface Settings

  !define MUI_WELCOMEPAGE_TITLE "Instalador App Hostel Dingo"
  !define MUI_WELCOMEFINISHPAGE_BITMAP "logoDingo.bmp"

;--------------------------------

; Pages
!insertmacro MUI_PAGE_WELCOME
!insertmacro MUI_PAGE_LICENSE "${NSISDIR}\Docs\Modern UI\License.txt"
!insertmacro MUI_PAGE_COMPONENTS
!insertmacro MUI_PAGE_DIRECTORY

;Start Menu Folder Page Configuration
!define MUI_STARTMENUPAGE_REGISTRY_ROOT "HKCU" 
!define MUI_STARTMENUPAGE_REGISTRY_KEY "Software\AppHostel" 
!define MUI_STARTMENUPAGE_REGISTRY_VALUENAME "Start Menu Folder"

!insertmacro MUI_PAGE_STARTMENU Application $StartMenuFolder
!insertmacro MUI_PAGE_INSTFILES

!insertmacro MUI_UNPAGE_CONFIRM
!insertmacro MUI_UNPAGE_INSTFILES

;--------------------------------
;Languages

!insertmacro MUI_LANGUAGE "Spanish"

;--------------------------------

; The stuff to install
Section "AppHostel (required)"

  SectionIn RO
  
  ; Set output path to the installation directory.
  SetOutPath $INSTDIR
  
  ; Put file there
  File AppHostel.7z
  Nsis7z::ExtractWithCallback "$INSTDIR\AppHostel.7z"
  Delete "$OUTDIR\AppHostel.7z"
  
  ; Write the installation path into the registry
  WriteRegStr HKLM SOFTWARE\NSIS_AppHostel "Install_Dir" "$INSTDIR"
  
  !insertmacro MUI_STARTMENU_WRITE_BEGIN Application
  
  CreateDirectory "$SMPROGRAMS\$StartMenuFolder"
  CreateShortcut "$SMPROGRAMS\$StartMenuFolder\uninstallAppHostel.lnk" "$INSTDIR\uninstallAppHostel.exe"
  CreateShortcut "$SMPROGRAMS\$StartMenuFolder\AppHostel.lnk" "$INSTDIR\AppHostel.jar"
  !insertmacro MUI_STARTMENU_WRITE_END
  
  ; Write the uninstall keys for Windows
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\AppHostel" "DisplayName" "NSIS AppHostel"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\AppHostel" "UninstallString" '"$INSTDIR\uninstall.exe"'
  WriteRegDWORD HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\AppHostel" "NoModify" 1
  WriteRegDWORD HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\AppHostel" "NoRepair" 1
  WriteUninstaller "$INSTDIR\uninstallAppHostel.exe"
  
SectionEnd

; Optional section (can be disabled by the user)
Section "Start Menu Shortcuts"

  CreateDirectory "$SMPROGRAMS\AppHostel"
  CreateShortcut "$SMPROGRAMS\AppHostel\uninstallAppHostel.lnk" "$INSTDIR\uninstallAppHostel.exe" "" "$INSTDIR\uninstallAppHostel.exe" 0

  
SectionEnd

;--------------------------------

; Uninstaller

Section "Uninstall"
  
  ; Remove registry keys
  DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\AppHostel"
  DeleteRegKey HKLM SOFTWARE\NSIS_AppHostel

  ; Remove shortcuts, if any
  Delete "$SMPROGRAMS\AppHostel\*.*"
  Delete "$SMPROGRAMS\$StartMenuFolder\uninstallAppHostel.lnk"
  Delete "$SMPROGRAMS\$StartMenuFolder\AppHostel.lnk"
  RMDir "$SMPROGRAMS\$StartMenuFolder"

  ; Remove directories used
  RMDir "$SMPROGRAMS\AppHostel"
  RMDir /r "$INSTDIR"

SectionEnd