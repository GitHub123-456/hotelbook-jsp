package com.ink.hb.common;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库工具类 - 使用连接池进行连接
 */
public class DBUtil {

    private static ComboPooledDataSource dataSource;// 数据源对象

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();// 本地线程对象

    static {
        try {
            dataSource = new ComboPooledDataSource();

            // 连接参数设置
            dataSource.setUser("root");// 用户名
            dataSource.setPassword("123456");// 密码
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hotelbook"); // 连接字符串
            dataSource.setDriverClass("com.mysql.jdbc.Driver"); // 驱动类

            // 连接池设置
            dataSource.setInitialPoolSize(5); // 初始连接数
            dataSource.setMinPoolSize(5); // 连接池最少保留的连接数量
            dataSource.setMaxPoolSize(10); // 连接池最多的连接数上限
            dataSource.setMaxIdleTime(60); // 最大空闲时间60秒

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过连接池对象返回数据库连接
     *
     * @return Connection 连接对象
     * @throws SQLException 数据库错误
     */
    public static Connection getConnection() throws SQLException {

        // 从threadLocal获得连接对象
        Connection conn = threadLocal.get();

        // 如果连接对象不存在或者是已经被关闭的，就从连接池取出一个连接对象返回，如果已经存在，就直接返回
        if (conn == null || conn.isClosed()) {
            conn = dataSource.getConnection();
            // 设置到threadLocal中
            threadLocal.set(conn);
        }

        // 测试语句
        //System.out.println("获得数据库连接：" + conn + "剩余空闲连接数=" + dataSource.getNumIdleConnections());

        return conn;

    }

    /**
     * 通用关闭连接方法
     */
    public static void close() {
        // 从本地线程中获得连接
        Connection conn = threadLocal.get();

        try {
            // 在连接不为空 且 没关闭时
            if (conn != null && !conn.isClosed()) {
                // 解除绑定
                threadLocal.set(null);
                // 关闭连接
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
