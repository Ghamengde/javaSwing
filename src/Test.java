public class Test
{
    public static void main(String[] args) {
        String sql = "select * from user_" + 1 + " " + "where user_name like '%" + "Bob" +"%'";
        System.out.println(sql);
    }
}
