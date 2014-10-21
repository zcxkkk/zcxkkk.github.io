import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * MySQLUtils
 *
 */

public class MySqlUtils {
	/**
	 * 创建连接
	 * @return
	 * @throws Exception
	 */
	public static Connection openConnection() throws Exception {
        Connection conn = null;
        MySqlUtils msUtils = new MySqlUtils();
        String rootPath = msUtils.getRootPath();
        String exactPath = rootPath.substring(0, rootPath.length()-8) + "config" + File.separator + "jdbc.properties" ;
        File localFile = new File(exactPath);
		InputStream in = new FileInputStream(localFile);
		Properties p = new Properties();
		p.load(in);
        String driverName = p.get("jdbc.driverClassName").toString();
        String url = p.get("jdbc.url").toString();
        String username = p.get("jdbc.username").toString();
        String password = p.get("jdbc.password").toString();
        try {
            Class.forName(driverName).newInstance();
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            conn = null;
        } catch (SQLException e) {
            conn = null;
        }
        return conn;
    }
	/**
	 * 获取classes文件夹的绝对路径
	 * @return
	 */
	public String getRootPath(){
		String webPath = getClass().getResource("/").getPath();
		return webPath;
	}

}