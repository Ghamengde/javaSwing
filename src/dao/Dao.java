package dao;

import model.User;
import model.UserLabel;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dao
{
    private static String db_class_name = "com.mysql.cj.jdbc.Driver";
    private static String db_url = "jdbc:mysql://localhost:3306/minichat";
    private static String db_user = "root";
    private static String db_pwd = "123456";

    private static Connection conn = null;

    //获取数据库连接
    Dao()
    {
        try
        {
            if (conn==null)
            {
                Class.forName(db_class_name); //注册驱动程序
                conn = DriverManager.getConnection(db_url,db_user,db_pwd);
            }
            else return;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //关闭连接
    public static void close()
    {
        try
        {
            if(conn != null)
                conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            conn = null;
        }
    }

    public static String re(String e_mail)
    {
        //正则表达式分割邮箱第一个字符
        String regex = "\\d";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(e_mail);
        String first_num = "";
        if(matcher.find())
        {
            first_num = matcher.group();//获取第一个匹配项
        }
        return first_num;
    }
    public static int reg(String user_name, String pwd, int age, String e_mail)
    {
        int i = 0;
        String first_num = re(e_mail);
        try
        {
            Dao dao = new Dao();
            String sql = "select * from user_" + first_num + " " + "where e_mail = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, e_mail);
            ResultSet rs_ = pstmt.executeQuery();
            if(rs_.next())
            {
                return -1;
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        try
        {
            String sql = "insert into user_" + first_num + "(user_name,pwd,age,e_mail) values(?,?,?,?)";

            Dao dao = new Dao();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user_name);
            pstmt.setString(2, pwd);
            pstmt.setInt(3, age);
            pstmt.setString(4, e_mail);

            i = pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return i;
    }

    public static User log(String e_mail, String pwd)
    {
        User user = new User();
        String first_num = re(e_mail);
        String sql = "select * from user_" +  first_num + " " + "where e_mail = ? and pwd = ?";

        try
        {
            Dao dao = new Dao();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, e_mail);
            pstmt.setString(2, pwd);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next())
            {
                user.setUser_name(rs.getString("user_name"));
                user.setPwd(rs.getString("pwd"));
                user.setAge(rs.getInt("age"));
                user.setE_mail(rs.getString("e_mail"));
            }

            rs.close();
            pstmt.close();
            Dao.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return user;
    }

    public static User get_user(String e_mail)
    {
        User user = new User();
        Dao dao = new Dao();
        String first_num = re(e_mail);
        String sql = "select * from user_" + first_num + " " + "where e_mail = ?";

        try
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, e_mail);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                user.setId(rs.getInt("user_id"));
                user.setUser_name(rs.getString("user_name"));
                user.setE_mail(rs.getString("e_mail"));
                user.setAge(rs.getInt("age"));
                user.setPwd(rs.getString("pwd"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return user;
    }

    public static ArrayList<User> add_friends_by_name(String user_name) throws SQLException
    {
        String sql = null;
        Dao dao = new Dao();
        ArrayList<User> userlist = new ArrayList<User>();
        User user = new User();
        for(int i = 1; i < 10; i ++)
        {
            sql = "select * from user_" + i + " " + "where user_name like ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + user_name + "%");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                user.setE_mail(rs.getString("e_mail"));
                user.setUser_name(rs.getString("user_name"));
                userlist.add(user);
            }
        }
        return userlist;
    }

    public static ArrayList<UserLabel> add_user_to_user_label(ArrayList<User> user_list)
    {
        UserLabel user_label = new UserLabel();
        ArrayList<UserLabel> user_labels = new ArrayList<UserLabel>();
        for(User user : user_list)
        {
            user_label.setUser_name(user.getUser_name());
            user_label.setUser_email(user.getE_mail());
            user_labels.add(user_label);
        }
        return user_labels;
    }

}
