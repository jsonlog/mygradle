Set ap = CreateObject("Wscript.Shell")
Set fso = CreateObject("Scripting.FileSystemObject")

Set dataFile = fso.openTextFile("data.txt" , 1)

Dim tempPrint
Dim tempInput

Do while (datafile.AtEndOfStream <> true)

tempPrint = dataFile.ReadLine '读取一行
Call TenTimesPractice()

Loop



dataFile.close

MsgBox "每日练一遍 今天到此结束"

Wscript.quit

Sub TenTimesPractice()

Dim maxTimes
maxTimes = 10

for i = 1 to maxTimes
tempInput = InputBox(tempPrint & " " & i & "/" & maxTimes )
if isEmpty(tempInput) then wscript.quit
next

End Sub


