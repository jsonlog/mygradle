﻿<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="crud.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <style type="text/css">
        #Password {
            width: 100px;
        }
        #Password_confirm {
            width: 100px;
        }
    </style>
</head>
<body>
    <OBJECT id="obj" height="50%" width="100%" classid="clsid:08D91289-1761-4006-8294-FDE48B9F29BD"
	    VIEWASTEXT>
	    <PARAM NAME="_Version" VALUE="65536">
	    <PARAM NAME="_ExtentX" VALUE="26">
	    <PARAM NAME="_ExtentY" VALUE="26">
	    <PARAM NAME="_StockProps" VALUE="0">
    </OBJECT>
    <form  style="text-align:center" id="form1" runat="server">
    <div  style="text-align:center; font-size: large; color: #000000;">
        <div  style="text-align:center" >
        Code: 
        <asp:TextBox ID="TextBoxSelect" runat="server"></asp:TextBox>
        Name:
        <asp:TextBox ID="TextBoxName" runat="server"></asp:TextBox>
        <asp:Button ID="Btn_select" runat="server" OnClick="Btn_select_Click" Text="查询" />
        </div>
        <hr />
        <asp:Button ID="Button2" runat="server" OnClick="Button2_Click" Text="添加" />
		<asp:button id="btnPrint" runat="server" CssClass="bginput" Text="打印" onclick="btnPrint_Click" />
        <asp:GridView ID="GridView2" runat="server" AutoGenerateDeleteButton="True" OnRowDataBound="GridView2_RowDataBound" OnRowDeleting="GridView2_RowDeleting" OnRowEditing="GridView2_RowEditing" CellPadding ="8" CellSpacing="4" ForeColor="#333333" HorizontalAlign="Center" Width="534px" >
            <Columns>
                <asp:CommandField showEditButton="true" />
            </Columns>
            <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
            <%--<EditRowStyle BackColor="#999999" />--%>
            <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" HorizontalAlign="Center" VerticalAlign="Middle" />
            <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" HorizontalAlign="Center" VerticalAlign="Middle" />
            <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" VerticalAlign="Middle" />
            <RowStyle BackColor="#F7F6F3" ForeColor="#333333" HorizontalAlign="Center" VerticalAlign="Middle" />
            <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
            <SortedAscendingCellStyle BackColor="#E9E7E2" />
            <SortedAscendingHeaderStyle BackColor="#506C8C" />
            <SortedDescendingCellStyle BackColor="#FFFDF8" />
            <SortedDescendingHeaderStyle BackColor="#6F8DAE" />
        </asp:GridView>

    </div>
    </form>
</body>
</html>