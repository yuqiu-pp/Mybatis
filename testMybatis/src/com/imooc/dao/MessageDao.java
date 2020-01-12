package com.imooc.dao;

import com.imooc.Message;
import com.imooc.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 与表相关的数据库操作
 */
public class MessageDao {
    /**
     * 根据查询条件查询列表
     */
    public List<Message> queryMessageList(String command, String description){
        List<Message> messageList = new ArrayList<>();
        DBAccess dbAccess = new DBAccess();
        // 放到try的外面，即使发生异常也要关闭。final时要关闭
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            // 执行SQL语句
            messageList = sqlSession.selectList("Message.queryMessageList");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 发生异常时，SqlSession为null
            if (sqlSession != null){
                sqlSession.close();
            }

        }

        // Class.forName("com.mysql.jdbc.Driver");

        // 接受页面的值

        // 向页面传值

        // 查询消息列表并传给页面

        // 向页面跳转
        return messageList;
    }

    public static void main(String[] args) {
        MessageDao messageDao = new MessageDao();
        messageDao.queryMessageList("", "");

    }
}
