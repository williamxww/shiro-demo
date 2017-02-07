package com.bow.spring.transaction;

import com.bow.dao.UserDao;
import com.bow.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO 事务控制需要数据库，在此只是将代码放好，没有做运行
 * 
 * @author ViVi
 * @date 2015年10月2日 上午9:14:40
 */

public class TransactionTest {
    private ApplicationContext context;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext(new String[] { "spring/transaction/applicationContext.xml" });
    }

    // @Test
    public void add() {

        UserDao dao = context.getBean("userDao", UserDao.class);
        User user = new User();
        user.setUsername("customizeDemo");
        user.setNickname("test2");
        user.setPassword("customizeDemo");
        // dao.addUser(user);
    }

    // @Test
    public void delete() {
        int a = 1;
        if (a == 1) {
            // throw new RuntimeException("删除时异常");
        }
        UserDao dao = context.getBean("userDao", UserDao.class);
        // User user = dao.getByUsername("customizeDemo");
        // dao.deleteUser(user);
    }

    @Test
    public void test() {
        TransactionServiceTest service = (TransactionServiceTest) context.getBean("transactionServiceTestImpl");
        // service.testTransaction();
        service.codeTransaction();
    }

}
