'传入文件名，并行线程播放声音

'Call Play(SoundFile)
Sub Play(SoundFile)
    Dim oPlayer
    Set oPlayer = CreateObject("WMPlayer.OCX")
' Play audio
    oPlayer.URL = SoundFile
    oPlayer.settings.volume = 100
    oPlayer.controls.play 
   While oPlayer.playState <> 1 ' 1 = Stopped
    WScript.Sleep 100
   Wend
' Release the audio file
    oPlayer.close
End Sub


Dim SoundFile
SoundFile = WSH.Arguments(0)
Call Play(SoundFile)
WSH.quit