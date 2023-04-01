import java.sql.*; //imports all

public class Database {
    private String url;
    private String port;
    private String db;
    private String username;
    private String passwd;
    private Connection con;

    private static String driver = "com.mysql.cj.jdbc.Driver"; //static means its a class level variable

    public Database(String url, String port, String db,
                    String username, String passwd) {
        try {
            Class.forName(Database.driver);
        }
        catch(Exception e){ System.out.println(e);}

        // assign attributes
    }

    public void connect() {
        // change string to attribute
        try {
            con = DriverManager.getConnection(
                    this.url + ":" +this.port+"/"+this.db,
                    this.username, this.passwd);
        }
        catch(Exception e){ System.out.println(e);}

    }

    public void insert(String username, String email, String password, int age, String fname, String mname, String lname) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO `registration`(username, email,password,age,fname, mname, lname) VALUE ('"+username+"','"+email+"','"+password+"',"+age+",'"+fname+","+mname+","+lname+"')");

        }
        catch(Exception e){ System.out.println(e);}

    }

    public void close() {
        try {
            con.close();
        }
        catch(Exception e){ System.out.println(e);}
    }

}
