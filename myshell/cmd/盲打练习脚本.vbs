Set objectShell = CreateObject("Wscript.Shell")
Set fso = CreateObject("Scripting.FileSystemObject")

'初始化
	PunishmentSoun_count = 1	'错误惩罚声音计数器
	EncourageSound_count = 1	'奖励声音的计数设置
	
	Dim tempRead
	Dim tempPrint
	Dim tempInput
	
	Set dataFile = fso.openTextFile("data.txt" , 1)	'打开字典
	
Call Body()
	
	



Sub Body()

	Call Play("misc\ready\卫星图.wav")
	
	tempRead = dataFile.ReadLine	'读取一行
	Do while (datafile.AtEndOfStream <> true)
		tempRead = dataFile.ReadLine	'读取一行
		Call TenTimesPractice()
	Loop
	
	dataFile.close
	MsgBox "每日练一遍 今天到此结束"
	WSH.quit

End Sub






'Call Play(SoundFile)
Sub Play(SoundFile)
	objectShell.run "playSound.vbs " & SoundFile
End Sub



Sub TenTimesPractice()

	'每个单词练习几遍？可以在这里自行更改maxTimes的值。
	Dim maxTimes
	maxTimes = 7

	for i = 1 to maxTimes
		tempPrint = tempRead & "	" & i & "/" & maxTimes
		tempInput = InputBox(tempPrint)
		
		if tempInput <> tempRead then
			i = i - 1
			Call PlayPunishmentSound()
		else
			Call PlayEncourageSound()
		end if
	next

End Sub



Sub PlayEncourageSound()

	Dim SoundFile
	SoundFile = "misc\EncourageSound\" & EncourageSound_count & ".mp3"
	Call Play(SoundFile)
	
	
	EncourageSound_count = EncourageSound_count + 1
	if EncourageSound_count > 14 then
	EncourageSound_count = 1
	end if
	
End Sub



Sub PlayPunishmentSound()

	Dim SoundFile
	SoundFile = "misc\PunishmentSound\" & PunishmentSoun_count & ".mp3"
	
	Call Play(SoundFile)
	
	
	PunishmentSoun_count = PunishmentSoun_count + 1
	if PunishmentSoun_count > 3 then
	PunishmentSoun_count = 1
	end if
End Sub


