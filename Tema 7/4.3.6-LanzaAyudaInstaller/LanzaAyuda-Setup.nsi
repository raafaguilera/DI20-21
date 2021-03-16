;NSIS Modern User Interface
;Welcome/Finish Page Example Script
;Written by Joost Verburg

;--------------------------------
;Include Modern UI

  !include "MUI2.nsh"

;--------------------------------
;General

  ;Name and file
  Name "LanzaAyuda"
  OutFile "LanzaAyuda-Setup-1.0.exe"
  Unicode True

  ;Default installation folder
  InstallDir $PROGRAMFILES\LanzaAyuda

  ;Get installation folder from registry if available
  InstallDirRegKey HKLM "Software\NSIS_LanzaAyuda" "Install_Dir"



;--------------------------------

;Variables
Var StartMenuFolder


;--------------------------------
;Interface Settings

  !define MUI_ABORTWARNING
  !define MUI_WELCOMEPAGE_TITLE "Instalador LanzaAyuda"
  !define MUI_WELCOMEFINISHPAGE_BITMAP "welcomeImage.bmp"

;--------------------------------


; Pages
  !insertmacro MUI_PAGE_WELCOME
!insertmacro MUI_PAGE_LICENSE "${NSISDIR}\Docs\Modern UI\License.txt"
!insertmacro MUI_PAGE_COMPONENTS
!insertmacro MUI_PAGE_DIRECTORY

;Start Menu Folder Page Configuration
!define MUI_STARTMENUPAGE_REGISTRY_ROOT "HKCU" 
!define MUI_STARTMENUPAGE_REGISTRY_KEY "Software\LanzaAyuda" 
!define MUI_STARTMENUPAGE_REGISTRY_VALUENAME "Start Menu Folder"

!insertmacro MUI_PAGE_STARTMENU Application $StartMenuFolder
!insertmacro MUI_PAGE_INSTFILES

!insertmacro MUI_UNPAGE_CONFIRM
!insertmacro MUI_UNPAGE_INSTFILES

;--------------------------------
;Languages

  !insertmacro MUI_LANGUAGE "Spanish"

;--------------------------------
;Installer Sections

; The stuff to install
Section "LanzaAyuda (required)"

  SectionIn RO
  
  ; Set output path to the installation directory.
  SetOutPath $INSTDIR
  
  ; Put file there
  File LanzaAyuda.7z
  Nsis7z::ExtractWithDetails "$INSTDIR\LanzaAyuda.7z"
  Delete "$OUTDIR\LanzaAyuda.7z"
  
  ; Write the installation path into the registry
  WriteRegStr HKLM SOFTWARE\NSIS_LanzaAyuda "Install_Dir" "$INSTDIR"
  
  !insertmacro MUI_STARTMENU_WRITE_BEGIN Application
  
  CreateDirectory "$SMPROGRAMS\$StartMenuFolder"
  CreateShortcut "$SMPROGRAMS\$StartMenuFolder\uninstallLanzaAyuda.lnk" "$INSTDIR\uninstallLanzaAyuda.exe"
  CreateShortcut "$SMPROGRAMS\$StartMenuFolder\LanzaAyuda.lnk" "$INSTDIR\LanzaAyuda.jar"
  !insertmacro MUI_STARTMENU_WRITE_END
  
  ; Write the uninstall keys for Windows
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\LanzaAyuda" "DisplayName" "NSIS LanzaAyuda"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\LanzaAyuda" "UninstallString" '"$INSTDIR\uninstall.exe"'
  WriteRegDWORD HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\LanzaAyuda" "NoModify" 1
  WriteRegDWORD HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\LanzaAyuda" "NoRepair" 1
  WriteUninstaller "$INSTDIR\uninstallLanzaAyuda.exe"
  
SectionEnd

; Optional section (can be disabled by the user)
Section "Start Menu Shortcuts"

  CreateDirectory "$SMPROGRAMS\LanzaAyuda"
  CreateShortcut "$SMPROGRAMS\LanzaAyuda\uninstallLanzaAyuda.lnk" "$INSTDIR\uninstallLanzaAyuda.exe" "" "$INSTDIR\uninstallLanzaAyuda.exe" 0
  CreateShortcut "$SMPROGRAMS\LanzaAyuda\LanzaAyuda (MakeNSISW).lnk" "$INSTDIR\LanzaAyuda.jar" "" "$INSTDIR\LanzaAyuda.jar" 0
  
SectionEnd

;--------------------------------

; Uninstaller

Section "Uninstall"
  
  ; Remove registry keys
  DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\LanzaAyuda"
  DeleteRegKey HKLM SOFTWARE\NSIS_LanzaAyuda

  ; Remove shortcuts, if any
  Delete "$SMPROGRAMS\LanzaAyuda\*.*"
  Delete "$SMPROGRAMS\$StartMenuFolder\uninstallLanzaAyuda.lnk"
  Delete "$SMPROGRAMS\$StartMenuFolder\LanzaAyuda.lnk"
  RMDir "$SMPROGRAMS\$StartMenuFolder"

  ; Remove directories used
  RMDir "$SMPROGRAMS\LanzaAyuda"
  RMDir /r "$INSTDIR"

SectionEnd
