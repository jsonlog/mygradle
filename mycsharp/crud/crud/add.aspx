<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="add.aspx.cs" Inherits="crud.add" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            编号:<asp:TextBox ID="Code" runat="server" Width="60px"></asp:TextBox>
            名字:<asp:TextBox ID="Name" runat="server" Width="100px"></asp:TextBox>
            年龄:<asp:TextBox ID="Age" runat="server" Width="100px"></asp:TextBox>
            部门:<asp:TextBox ID="Dept" runat="server" Width="100px"></asp:TextBox>
            备注:<asp:TextBox ID="Memo" runat="server" Width="100px"></asp:TextBox>
            <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="保存" />
            <asp:Button ID="Cancel" runat="server" OnClick="Cancel_Click" Text="取消" />
        </div>
    </form>
</body>
</html>
