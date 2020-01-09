package com.arbor.note.jdbc.transaction;

import com.mysql.cj.jdbc.MysqlXADataSource;
import com.mysql.cj.jdbc.MysqlXid;

import javax.sql.XAConnection;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;
import java.sql.*;

public class XADemo {

    static Integer integer = null;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        func();
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        String url1 = "jdbc:mysql://127.0.0.1:3306/mydb?useUnicode=true&characterEncoding=UTF-8";
//        String url2 = "jdbc:mysql://127.0.0.1:3306/mydb2?useUnicode=true&characterEncoding=UTF-8";
//        String user = "root";
//        String password = "qiaomu521";
//        Connection connection1 = DriverManager.getConnection(url1, user, password);
//        Connection connection2 = DriverManager.getConnection(url2, user, password);
//
//        PreparedStatement preparedStatement = connection1.prepareStatement("insert into t_user(name) values(\"历史\")");
//        ResultSet resultSet = preparedStatement.executeQuery();
//        boolean execute = preparedStatement.execute();
//        connection2.prepareStatement("insert into t_phone (phone) values (\"17612341235\")").execute();




    }

    public static void func() {
        String url1 = "jdbc:mysql://127.0.0.1:3306/mydb?useUnicode=true&characterEncoding=UTF-8";
        String url2 = "jdbc:mysql://127.0.0.1:3306/mydb2?useUnicode=true&characterEncoding=UTF-8";
        String user = "root";
        String password = "qiaomu521";

        try {
            //从不同数据库获取数据库数据源
            MysqlXADataSource ds1 = getDataSource(url1, user, password);
            MysqlXADataSource ds2 = getDataSource(url2, user, password);

            //数据库1获取连接
            XAConnection xaConnection1 = ds1.getXAConnection();
            XAResource xaResource1 = xaConnection1.getXAResource();
            Connection connection1 = xaConnection1.getConnection();
            Statement statement1 = connection1.createStatement();

            //数据库2获取连接
            XAConnection xaConnection2 = ds2.getXAConnection();
            XAResource xaResource2 = xaConnection2.getXAResource();
            Connection connection2 = xaConnection2.getConnection();
            Statement statement2 = connection2.createStatement();

            //创建事务分支的xid
            Xid xid1 = new MysqlXid(new byte[] { 0x01 }, new byte[] { 0x02 }, 100);
            Xid xid2 = new MysqlXid(new byte[] { 0x011 }, new byte[] { 0x012 }, 100);

            try {
                //事务分支1关联分支事务sql语句
                xaResource1.start(xid1, XAResource.TMNOFLAGS);
                int update1Result = statement1.executeUpdate("update t_user set name='善良美丽' where id=1");
                xaResource1.end(xid1, XAResource.TMSUCCESS);

                //事务分支2关联分支事务sql语句
                xaResource2.start(xid2, XAResource.TMNOFLAGS);
                int update2Result = statement2.executeUpdate("update t_phone set phone= 'asdf' where id=1");
                xaResource2.end(xid2, XAResource.TMSUCCESS);

                // 两阶段提交协议第一阶段
                int ret1 = xaResource1.prepare(xid1);
                int ret2 = xaResource2.prepare(xid2);

                // 两阶段提交协议第二阶段
                if (XAResource.XA_OK == ret1 && XAResource.XA_OK == ret2) {
                    xaResource1.commit(xid1, false);
                    xaResource2.rollback(xid2);

                    System.out.println("reslut1:" + update1Result + ", result2:" + update2Result);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static MysqlXADataSource getDataSource(String conn, String user, String pwd) {
        try {
            MysqlXADataSource dataSource = new MysqlXADataSource();
            dataSource.setUrl(conn);
            dataSource.setUser(user);
            dataSource.setPassword(pwd);
            return dataSource;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
