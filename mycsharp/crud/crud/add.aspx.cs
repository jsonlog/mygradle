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
        int id = -1;
        protected void Page_Load(object sender, EventArgs e)
        {
            string updateId = Server.HtmlEncode(Request.QueryString["ID"]);
            if (!String.IsNullOrEmpty(updateId)) { id = int.Parse(updateId); }
            if (this.Code.Text == "" && this.Name.Text == "" && this.Age.Text == "" && this.Dept.Text == "" && this.Memo.Text == "")
            {
                this.Code.Text = Server.HtmlEncode(Request.QueryString["Code"]);
                this.Name.Text = Server.HtmlEncode(Request.QueryString["Name"]);
                this.Age.Text = Server.HtmlEncode(Request.QueryString["Age"]);
                this.Dept.Text = Server.HtmlEncode(Request.QueryString["Dept"]);
                this.Memo.Text = Server.HtmlEncode(Request.QueryString["Memo"]);
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            string Code = this.Code.Text.Trim();
            string Name = this.Name.Text.Trim();
            string Age = this.Age.Text.Trim();
            string Dept = this.Dept.Text.Trim();
            string Memo = this.Memo.Text.Trim();
            string baseUrl = "WebForm1.aspx?Code=" + Code + "&Name=" + Name + "&Age=" + Age + "&Dept=" + Dept + "&Memo=" + Memo;
            if (id != -1)
            {
                Response.Redirect(baseUrl + "&ID=" + id);
            }
            else
            {
                Response.Redirect(baseUrl);
            }
        }

        protected void Cancel_Click(object sender, EventArgs e)
        {
            Response.Redirect("WebForm1.aspx");
        }
    }
}