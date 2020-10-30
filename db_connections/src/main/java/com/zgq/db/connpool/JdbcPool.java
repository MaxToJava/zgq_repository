package com.zgq.db.connpool;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * TODO
 *
 * @author zgq
 * @date 2020/10/23
 */
public class JdbcPool implements DataSource {

    private static LinkedList<Connection> listConnections = new LinkedList<Connection>();

    static {
        InputStream in = JdbcPool.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();

        try {
            properties.load(in);
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            int jdbcInitPoolSize = Integer.parseInt(properties.getProperty("jdbcPoolInitSize"));
            Class.forName(driver);
            for(int i=1;i<=jdbcInitPoolSize;i++){
                Connection conn = DriverManager.getConnection(url,username,password);
                System.out.printf("获取第 %d 个连接 \n",i);
                System.out.println("获取连接："+conn);

                listConnections.add(conn);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public Connection getConnection() throws SQLException {

        System.out.println("进入了连接池");
        if(listConnections.size()>0){
            final Connection conn = listConnections.removeFirst();
            System.out.println("数据库连接池的大小为："+listConnections.size());
            System.out.println("取出的连接为："+conn);
            return (Connection) Proxy.newProxyInstance(JdbcPool.class.getClassLoader(), conn.getClass()
                   .getInterfaces
                    (), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if(!method.getName().equals("close")){
                        return method.invoke(conn,args);
                    }else{
                        listConnections.add(conn);
                        System.out.println("归还连接："+conn);
                        System.out.println("连接池的大小为："+listConnections.size());
                    }
                    return null;
                }
            });
        }else{
           throw new RuntimeException("数据库正忙");
        }
    }

    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    public void setLoginTimeout(int seconds) throws SQLException {

    }

    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

}
