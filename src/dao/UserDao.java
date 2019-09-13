package dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import utils.MD5Util;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class UserDao {
    public boolean findUser(User user  ) throws Exception {
        InputStream in = UserDao.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        properties.load(in);
        DataSource ds = new DruidDataSourceFactory().createDataSource(properties);
        Connection connection = ds.getConnection();
        PreparedStatement statement = connection.prepareStatement("select *from USER where username=?");
       statement.setString(1,user.getUsername());
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();

    }
    public void insretUser(User user) throws Exception {
        InputStream in = UserDao.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        properties.load(in);
        DataSource dataSource = new DruidDataSourceFactory().createDataSource(properties);
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String uid = user.getUid();
        String username = user.getUsername();
        String password = user.getPassword();
        String md5Str = MD5Util.getMd5Str(password);
        int update = queryRunner.update("insert into user velues(?,?,?)", uid, password, username);


    }
}
