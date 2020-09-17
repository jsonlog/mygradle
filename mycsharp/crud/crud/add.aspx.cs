using Newtonsoft.Json.Serialization;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace crud
{
    public partial class add : System.Web.UI.Page
    {
        
        EmployeeDataContext context = new EmployeeDataContext();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                string updateId = Server.HtmlEncode(Request.QueryString["ID"]);
                if (!String.IsNullOrEmpty(updateId))
                {
                    Employee entity = getEmployee(int.Parse(updateId));
                    this.inCode.Text = entity.Code;
                    this.inName.Text = entity.Name;
                    this.inAge.Text = entity.Age?.ToString();
                    this.inDept.Text = entity.Dept;
                    this.inMemo.Text = entity.Memo;
                }
            }
        }

        protected Employee getEmployee(long ID)
        {
            return (from E in context.Employee where E.ID == ID select E).FirstOrDefault();
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            Employee entity = new Employee();
            string updateId = Server.HtmlEncode(Request.QueryString["ID"]);
            if (!String.IsNullOrEmpty(updateId))
            {
                entity =getEmployee(int.Parse(updateId));
            }
            entity.Code = this.inCode.Text.Trim();
            entity.Name = this.inName.Text.Trim();
            entity.Age = String.IsNullOrWhiteSpace(this.inAge.Text.Trim())?(int?)null:int.Parse(this.inAge.Text.Trim());
            entity.Dept = this.inDept.Text.Trim();
            entity.Memo = this.inMemo.Text.Trim();
            if (String.IsNullOrEmpty(updateId))
            {
                context.Employee.InsertOnSubmit(entity);
            }
            context.SubmitChanges();
            Response.Redirect("WebForm1");
        }

        protected void Cancel_Click(object sender, EventArgs e)
        {
            Response.Redirect("WebForm1.aspx");
        }
    }
}