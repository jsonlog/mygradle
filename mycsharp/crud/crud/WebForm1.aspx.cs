using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace crud
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        //static int count = 0;
        EmployeeDataContext context = new EmployeeDataContext();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack) {
                bind();
            }
        }
        protected void bind()
        {
            GridView2.DataSource = getEmployeeList().ToList();
            GridView2.DataKeyNames = new string[] { "ID" };
            GridView2.DataBind();
        }

        protected Employee getEmployee(long ID)
        {
            return (from E in context.Employee where E.ID == ID select E).FirstOrDefault();
        }

        protected IQueryable<Employee> getEmployeeList()
        {
            var query = from E in context.Employee where E.Name.Contains(this.TextBoxName.Text.Trim()) select E; //IEnumerable
            query = query.Where(E => E.Code.Contains(this.TextBoxSelect.Text.Trim()));
            //IQueryable<Employee> query = from E in context.Employee where E.Name.Contains(this.TextBoxName.Text.Trim()) && E.Code.Contains(this.TextBoxSelect.Text.Trim()) select E;
            return query;
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            Response.Redirect("add.aspx");
        }
        protected void Btn_select_Click(object sender, EventArgs e)
        {
            bind();
        }

        protected void GridView2_RowDeleting(object sender, GridViewDeleteEventArgs e)
        {
            int id = Convert.ToInt32(GridView2.DataKeys[e.RowIndex].Value);
            context.Employee.DeleteOnSubmit(getEmployee(id));
            context.SubmitChanges();
            this.bind();
        }

        protected void GridView2_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                //Response.Redirect("add.aspx");
                //((LinkButton)e.Row.Cells[0].Controls[0]).Attributes.Add("onclick", "javascript:return confirm('确认删除：\"" + e.Row.Cells[1].Text + "\"吗?')");
            }
        }
        protected void GridView2_RowEditing(object sender, GridViewEditEventArgs e)
        {
            int id = Convert.ToInt32(GridView2.DataKeys[e.NewEditIndex].Value);
            Response.Redirect("add.aspx?ID=" + id);
        }

        protected void btnPrint_Click(object sender, System.EventArgs e)
        {
            this.ClientScript.RegisterStartupScript(this.GetType(), "onLoad", "<script language = VBScript>"
                + this.PrintScript(getEmployeeList().ToList()) + "\t\t</script><script language = VBScript>WebPrint002()</script>");
        }
        private string PrintScript(List<Employee> entityList)
        {
            System.Text.StringBuilder sb = new System.Text.StringBuilder();
            sb.Append("\n\t\tfunction WebPrint002() \n");
            sb.Append("\t\t\tobj.Init\n");
            sb.Append("\t\t\tobj.PageSize = 3\n");
            sb.Append("\t\t\tobj.CurrentPosY = 20\n");
            sb.Append("\t\t\tobj.UseAutoPrintPaper = false '自定义纸张，减少浪费\n");
            sb.Append("\t\t\tobj.LeftMargin = 30 '纸张左边距\n");
            sb.Append("\t\t\tobj.RightMargin = 0 '纸张右边距\n");
            sb.Append("\t\t\tobj.TopMargin = 0 '纸张顶边距\n");
            sb.Append("\t\t\tobj.BottomMargin = 1 '页面底边距\n");
            sb.Append("\t\t\tobj.LineInterval = 0 '行距\n");
            sb.Append("\t\t\tobj.OutlineOffset = 0 '单元格框线与文本内容外扩展距离\n");
            sb.Append("\t\t\tobj.PFToMain = 1 '页注脚与正文区距离\n");
            sb.Append("\t\t\tobj.PHToMain = 0 '页眉与正文区距离\n");

            sb.Append("\t\t\tobj.SetFontSize 28\n");
            sb.Append("\t\t\tobj.SetTextColor RGB(0, 0, 0)\n");
            sb.Append("\t\t\tobj.SetFont \"宋体\", 1 '设置字体\n");
            sb.Append("\t\t\tobj.DrawObject \"\", \"\", 1, \"770,30\", 5, \"\", \"\", \"True,1\"\n");
            sb.Append("\t\t\tobj.SetFontStyle 0, 1, 0\n");
            sb.Append("\t\t\tobj.DrawObject \"现 场 配 方 成 本\", \"\", 1, \"760,30\", 5, \"\", \"\", \"True,1\"\n");

            sb.Append("\t\t\tobj.SetFontSize 15 \n");
            sb.Append("\t\t\tobj.SetFontStyle 0, 0, 0\n");
            sb.Append("\t\t\tobj.DrawObject \"\", \"\", 1, \"550,30\", 5, \"1,2,3,4\", \"\", \"false,1\"\n");
            sb.Append("\t\t\tobj.DrawObject \"制单时间:" + DateTime.Now.ToString("yyyy-MM-dd") + "\", \"\", 1, \"200,30\", 5, \"1,2,3,4\", \"\", \"true,1\"\n");

            sb.Append("\t\t\tobj.SetOutline 0, 0, 1, 0, RGB(0, 0, 0)\n");
            sb.Append("\t\t\tobj.SetFontStyle 0, 1, 0\n");
            sb.Append("\t\t\tobj.SetFontSize 16 \n");
            sb.Append("\t\t\tobj.DrawObject \"色号\", \"\", 1, \"120,30\", 5, \"2\", \"\", \"false,1\" '\n");
            sb.Append("\t\t\tobj.DrawObject \"客户\", \"\", 1, \"100,30\", 5, \"2\", \"\", \"false,1\" '\n");
            sb.Append("\t\t\tobj.DrawObject \"品名\", \"\", 1, \"180,30\", 5, \"2\", \"\", \"false,1\" '\n");
            sb.Append("\t\t\tobj.DrawObject \"颜色\", \"\", 1, \"100,30\", 5, \"2\", \"\", \"false,1\" '\n");
            sb.Append("\t\t\tobj.DrawObject \"现场配方成本\", \"\", 1, \"120,30\", 5, \"2\", \"\", \"false,1\" '\n");
            sb.Append("\t\t\tobj.DrawObject \"报价\", \"\", 1, \"130,30\", 5, \"2\", \"\", \"true,1\" '\n");

            sb.Append("\t\t\tobj.SetFontStyle 0, 0, 0\n");
            sb.Append("\t\t\tobj.SetFont \"楷体_GB2312\", 1 '设置字体\n");

            for (int i = 0; i < entityList.Count; i++)
            {
                sb.Append("\t\t\tobj.DrawObject \"" + entityList[i].Name + "\", \"\", 0, \"120,30\", 5, \"\", \"\", \"false,1\" '\n");
            }
                //sb.Append("\t\t\tobj.DoPrint()\n");
                sb.Append("\t\t\tobj.PrintPreview() \n");
            sb.Append("\t\t\tEnd Function \n");

            return sb.ToString();
        }
    }
}