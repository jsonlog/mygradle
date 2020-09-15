<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="add.aspx.cs" Inherits="crud.add" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div style="height: 219px; width: 466px;left:40%;top:20%;position:absolute">
            编号:<asp:TextBox ID="Code" runat="server" Width="100px"></asp:TextBox>
            <br />
            名字:<asp:TextBox ID="Name" runat="server" Width="100px"></asp:TextBox>
            <br />
            年龄:<asp:TextBox ID="Age" runat="server" Width="100px"></asp:TextBox>
            <br />
            部门:<asp:TextBox ID="Dept" runat="server" Width="100px"></asp:TextBox>
            <br />
            备注:<asp:TextBox ID="Memo" runat="server" Width="100px"></asp:TextBox>
            <br />
            <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="保存" />
            <asp:Button ID="Cancel" runat="server" OnClick="Cancel_Click" Text="取消" />
        </div>
    </form>
</body>
</html>
