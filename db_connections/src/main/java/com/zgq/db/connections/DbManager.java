package com.zgq.db.connections;

import java.sql.*;

/**
 * TODO
 *
 * @author zgq
 * @date 2020/10/22
 */
public class DbManager {

    static {
        try {
            //数据库驱动
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private DbManager() {

    }

    public static void main(String[] args) {
        //尝试多个sql语句批量执行，发现不行
        String sql = "insert into course values(?,?);";
        Connection conn = getConnection();
        Statement statement = getStatement(conn);
        PreparedStatement preparedStatement = getPreparedStatement(conn, sql);
        try {
            for(int i=1;i<=3;i++){
                preparedStatement.setInt(1,i);
                preparedStatement.setString(2,"科目"+i);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }


/*        ResultSet rs = executeSQL(preparedStatement, null);
        operateQueryInfo(rs);

        closeResultSet(rs);*/
        closeStatement(preparedStatement);
        closeConnection(conn);

    }

    private static void operateQueryInfo(ResultSet rs) {
        int count = 0;
        try {
            while (rs.next()) {
                count++;
                //一行记录中第几列元素值，也可以指定列标题获取元素
                System.out.println(rs.getInt(2));

            }
            System.out.println("zgq_tb表中的数据数目为：" + count);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 建立数据库连接
     *
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            //UTC&rewriteBatchedStatements=TRUE
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zgq_db" +
                            "?characterEncoding=utf-8" +
                            "&serverTimezone=UTC" ,
                    "root", "root123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭数据库连接
     *
     * @param connection
     */
    public static void closeConnection(Connection connection) {

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static Statement getStatement(Connection connection) {
        Statement stment = null;
        try {
            stment = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stment;
    }

    public static PreparedStatement getPreparedStatement(Connection connection, String sql) {
        PreparedStatement pstment = null;

        try {
            pstment = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pstment;
    }

    /**
     * ResultSet 结果集，存储查询结果的对象，同时提供对数据的相关操作
     *
     * @param stment
     * @param sql
     * @return
     */
    public static ResultSet executeSQL(Statement stment, String sql) {
        ResultSet rs = null;
        try {
            if (sql != null) {
                rs = stment.executeQuery(sql);
            } else {
                PreparedStatement pstment = (PreparedStatement) stment;
                rs = pstment.executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }


    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
                statement = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

}
