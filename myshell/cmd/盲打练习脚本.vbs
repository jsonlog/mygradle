Set objectShell = CreateObject("Wscript.Shell")
Set fso = CreateObject("Scripting.FileSystemObject")

'��ʼ��
	PunishmentSoun_count = 1	'����ͷ�����������
	EncourageSound_count = 1	'���������ļ�������
	
	Dim tempRead
	Dim tempPrint
	Dim tempInput
	
	Set dataFile = fso.openTextFile("data.txt" , 1)	'���ֵ�
	
Call Body()
	
	



Sub Body()

	Call Play("misc\ready\����ͼ.wav")
	
	tempRead = dataFile.ReadLine	'��ȡһ��
	Do while (datafile.AtEndOfStream <> true)
		tempRead = dataFile.ReadLine	'��ȡһ��
		Call TenTimesPractice()
	Loop
	
	dataFile.close
	MsgBox "ÿ����һ�� ���쵽�˽���"
	WSH.quit

End Sub






'Call Play(SoundFile)
Sub Play(SoundFile)
	objectShell.run "playSound.vbs " & SoundFile
End Sub



Sub TenTimesPractice()

	'ÿ��������ϰ���飿�������������и���maxTimes��ֵ��
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


