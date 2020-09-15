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
        int count = 0;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (count++ == 0)
            {
                Employee employee = new Employee();
                employee.Code = Server.HtmlEncode(Request.QueryString["Code"]);
                employee.Name = Server.HtmlEncode(Request.QueryString["Name"]);
                employee.Dept = Server.HtmlEncode(Request.QueryString["Dept"]);
                employee.Memo = Server.HtmlEncode(Request.QueryString["Memo"]);
                if (!(String.IsNullOrWhiteSpace(employee.Code) && String.IsNullOrWhiteSpace(employee.Name) && String.IsNullOrWhiteSpace(employee.Dept) && String.IsNullOrWhiteSpace(employee.Memo)))
                {
                    string Age = Server.HtmlEncode(Request.QueryString["Age"]);
                    if (!String.IsNullOrEmpty(Age)) { employee.Age = double.Parse(Age); }
                    string updateId = Server.HtmlEncode(Request.QueryString["ID"]);
                    if (!String.IsNullOrEmpty(updateId))
                    {
                        employee.ID = long.Parse(updateId);
                        update(employee);
                    }
                    else
                    {
                        insert(employee);
                    }
                }
            }
            bind();
        }
        protected void insert(Employee emp)
        {
            context.Employee.InsertOnSubmit(emp);
            context.SubmitChanges();
        }
        protected void update(Employee emp)
        {
            Employee toInsert = getEmployee(emp.ID);
            toInsert.Code = emp.Code;
            toInsert.Name = emp.Name;
            toInsert.Dept = emp.Dept;
            toInsert.Age = emp.Age;
            toInsert.Memo = emp.Memo;
            context.SubmitChanges();
        }
        protected void bind()
        {
            GridView2.DataSource = (from E in context.Employee select E).ToList();
            GridView2.DataKeyNames = new string[] { "ID" };
            GridView2.DataBind();
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            Response.Redirect("add.aspx");
        }
        protected void Btn_select_Click(object sender, EventArgs e)
        {
            string Name = this.TextBoxName.Text.Trim();
            string Code = this.TextBoxSelect.Text.Trim();
            if (Name != "" || Code != "")
            {

                using (EmployeeDataContext context = new EmployeeDataContext())
                {
                    GridView2.DataSource = (from E in context.Employee where E.Name.Contains(Name) && E.Code.Contains(Code) select E).ToList();
                    GridView2.DataKeyNames = new string[] { "ID" };
                    GridView2.DataBind();
                }
            }

        }

        protected void GridView2_RowDeleting(object sender, GridViewDeleteEventArgs e)
        {
            int id = Convert.ToInt32(GridView2.DataKeys[e.RowIndex].Value);
            context.Employee.DeleteOnSubmit(getEmployee(id));
            context.SubmitChanges();
            this.bind();
        }

        protected Employee getEmployee(long ID)
        {
            return (from E in context.Employee where E.ID == ID select E).FirstOrDefault();
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
            Employee employee = getEmployee(id);
            Response.Redirect("add.aspx?ID="+id+"&Code="+employee.Code + "&Name=" + employee.Name + "&Age=" + employee.Age + "&Dept=" + employee.Dept + "&Memo=" + employee.Memo);
            this.bind();

        }
    }
}