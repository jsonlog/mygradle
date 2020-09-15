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
        EmployeeDataContext context = new EmployeeDataContext();
        protected void Page_Load(object sender, EventArgs e)
        {
            bind();
        }
        protected void bind()
        {
                //using GridView2.DataSource = from E in context.Employee select E;
                GridView2.DataSource = context.Employee;
                GridView2.DataKeyNames = new string[] { "ID" };
                GridView2.DataBind();
        }

        //插入数据
        protected void Button2_Click(object sender, EventArgs e)
        {
                this.bind();
        }
        //查询功能
        protected void Btn_select_Click(object sender, EventArgs e)
        {
            if (this.TextBoxSelect.Text != "")       //判断输入框是否为空
            {

                using (EmployeeDataContext context = new EmployeeDataContext())
                {
                    GridView2.DataSource = (from E in context.Employee where E.Code.Contains(this.TextBoxSelect.Text.Trim()) select E).ToList();
                    GridView2.DataKeyNames = new string[] { "ID" };
                    GridView2.DataBind();
                }
            }

        }

        protected void GridView2_RowDeleting(object sender, GridViewDeleteEventArgs e)
        {
            // string userN =GridView2.DataKeys[e.RowIndex].Value.ToString();
            //获取删除字段所在行的关键字段的值
            int id = Convert.ToInt32(GridView2.DataKeys[e.RowIndex].Value);


            EmployeeDataContext employeeDataContext = new EmployeeDataContext();
            employeeDataContext.Employee.DeleteOnSubmit(getEmployee(id));
            employeeDataContext.SubmitChanges();
            this.bind();
        }

        protected Employee getEmployee(int ID)
        {
            return (from E in context.Employee where E.ID == ID select E).FirstOrDefault();
        }

        protected void GridView2_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            //if (e.Row.RowType == DataControlRowType.DataRow)
            //{
            //    ((LinkButton)e.Row.Cells[0].Controls[0]).Attributes.Add("onclick", "javascript:return confirm('确认删除：\"" + e.Row.Cells[1].Text + "\"吗?')");
            //    //((LinkButton)e.Row.Cells[1].Controls[0]).Attributes.Add("onclick", "return confirm('确定要删除吗？')");
            //}
        }

        protected void GridView2_RowEditing(object sender, GridViewEditEventArgs e)
        {
            //GridView2.EditIndex = e.NewEditIndex;
            this.bind();
        }

        protected void GridView2_RowUpdating(object sender, GridViewUpdateEventArgs e)
        {
            //更新操作时会对页面进行刷新

            int id = Convert.ToInt32(GridView2.DataKeys[e.RowIndex].Value);

            string Code = ((TextBox)(GridView2.Rows[e.RowIndex].Cells[2].Controls[0])).Text.ToString();
            string Name = ((TextBox)(GridView2.Rows[e.RowIndex].Cells[3].Controls[0])).Text.ToString();
            string Age = ((TextBox)(GridView2.Rows[e.RowIndex].Cells[4].Controls[0])).Text.ToString();
            string Dept = ((TextBox)(GridView2.Rows[e.RowIndex].Cells[5].Controls[0])).Text.ToString();
            string Memo = ((TextBox)(GridView2.Rows[e.RowIndex].Cells[6].Controls[0])).Text.ToString();
            Response.Redirect("add.aspx?ID="+id+"&Code="+Code + "&Name=" + Name + "&Age=" + Age + "&Dept=" + Dept + "&Memo=" + Memo);
            //GridView2.EditIndex = -1;
            this.bind();

        }

        protected void GridView2_RowCancelingEdit(object sender, GridViewCancelEditEventArgs e)
        {
            //GridView2.EditIndex = -1;
            this.bind();
        }
    }
}