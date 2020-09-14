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
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        /// <summary>
        /// bing()方法，读取数据库的数据，并将其绑定到数据控件GridView中
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected void bind()
        {
            SqlConnection myConn = new SqlConnection("Data Source=WIN8;Initial Catalog=SqlDataTest01;Persist Security Info=True;User ID=sa;Password=123456");
            myConn.Open();

            string sqlStr = "select * from UserTable order by ID ";
            SqlDataAdapter myDa = new SqlDataAdapter(sqlStr, myConn);
            DataSet myDs = new DataSet();
            myDa.Fill(myDs);
            GridView2.DataSource = myDs;
            GridView2.DataKeyNames = new string[] { "ID" };
            GridView2.DataBind();
            myDa.Dispose();
            myDs.Dispose();
            myConn.Close();
        }

        //插入数据
        protected void Button2_Click(object sender, EventArgs e)
        {
            if (this.TextBoxID.Text != "" && this.TextBoxUserName.Text != "" && this.Password.Value != "" && Password.Value == Password_confirm.Value)
            {
                SqlConnection myConn = new SqlConnection("Data Source=WIN8;Initial Catalog=SqlDataTest01;Persist Security Info=True;User ID=sa;Password=123456");
                myConn.Open();
                string sqlStr = "insert into UserTable values ('" + this.TextBoxID.Text.Trim() + "','" + this.TextBoxUserName.Text.Trim() + "','" + this.Password.Value + "')";
                SqlCommand myCmd = new SqlCommand(sqlStr, myConn);
                myCmd.ExecuteNonQuery();
                myConn.Close();
                this.bind();
            }
            else
            {
                Response.Write("<script>alert('请重新输入')</script>");
            }
        }
        //查询功能
        protected void Btn_select_Click(object sender, EventArgs e)
        {
            if (this.TextBoxSelect.Text != "")       //判断输入框是否为空
            {
                //与数据库进行连接
                SqlConnection myConn = new SqlConnection("Data Source=WIN8;Initial Catalog=SqlDataTest01;Persist Security Info=True;User ID=sa;Password=123456");
                myConn.Open();
                //查询操作
                string sqlStr = "select * from UserTable where UserName=@UserName";
                SqlCommand myCmd = new SqlCommand(sqlStr, myConn);
                myCmd.Parameters.Add("@UserName", SqlDbType.VarChar, 50).Value = this.TextBoxSelect.Text.Trim();
                SqlDataAdapter myDa = new SqlDataAdapter(myCmd);
                //将查询的结果添加到DataSet中
                DataSet myDs = new DataSet();
                myDa.Fill(myDs);
                //在GridView中显示查询到的结果
                if (myDs.Tables[0].Rows.Count > 0)
                {
                    GridView2.DataSource = myDs;
                    GridView2.DataBind();
                }
                else
                {
                    Response.Write("<script>alert('查询结果为空')</script>");
                    this.bind();
                }
                myDa.Dispose();
                myDs.Dispose();
                myConn.Close();
            }
            else
            {
                Response.Write("<script>alert('请输入查询的用户名')</script>");
            }
        }

        protected void GridView2_RowDeleting(object sender, GridViewDeleteEventArgs e)
        {
            // string userN =GridView2.DataKeys[e.RowIndex].Value.ToString();
            //获取删除字段所在行的关键字段的值
            int userid = Convert.ToInt32(GridView2.DataKeys[e.RowIndex].Value);

            string sqlStr = "delete from UserTable where ID= " + userid;

            SqlConnection myConn = new SqlConnection("Data Source=WIN8;Initial Catalog=SqlDataTest01;Persist Security Info=True;User ID=sa;Password=123456");
            myConn.Open();
            SqlCommand myCmd = new SqlCommand(sqlStr, myConn);
            myCmd.ExecuteNonQuery();
            myCmd.Dispose();
            myConn.Close();
            GridView2.EditIndex = -1;
            this.bind();
        }

        protected void GridView2_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                ((LinkButton)e.Row.Cells[0].Controls[0]).Attributes.Add("onclick", "javascript:return confirm('确认删除：\"" + e.Row.Cells[1].Text + "\"吗?')");
                //((LinkButton)e.Row.Cells[1].Controls[0]).Attributes.Add("onclick", "return confirm('确定要删除吗？')");
            }
        }

        protected void GridView2_RowEditing(object sender, GridViewEditEventArgs e)
        {
            GridView2.EditIndex = e.NewEditIndex;
            this.bind();
        }

        protected void GridView2_RowUpdating(object sender, GridViewUpdateEventArgs e)
        {
            //更新操作时会对页面进行刷新

            int userid = Convert.ToInt32(GridView2.DataKeys[e.RowIndex].Value);

            string UName = ((TextBox)(GridView2.Rows[e.RowIndex].Cells[2].Controls[0])).Text.ToString();
            string PWord = ((TextBox)(GridView2.Rows[e.RowIndex].Cells[3].Controls[0])).Text.ToString();

            string sqlStr = "update UserTable set UserName='" + UName + "',PassWord='" + PWord + "' where ID =" + userid;

            SqlConnection myConn = new SqlConnection("Data Source=WIN8;Initial Catalog=SqlDataTest01;Persist Security Info=True;User ID=sa;Password=123456");
            myConn.Open();
            SqlCommand myCmd = new SqlCommand(sqlStr, myConn);
            myCmd.ExecuteNonQuery();
            myCmd.Dispose();
            myConn.Close();
            GridView2.EditIndex = -1;
            this.bind();

        }

        protected void GridView2_RowCancelingEdit(object sender, GridViewCancelEditEventArgs e)
        {
            GridView2.EditIndex = -1;
            this.bind();
        }
    }
}