package li.allan.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtils {
    public static String RESOURCE_LOCATION = "mybatis.xml";
    private static SqlSessionFactory sessionFactory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader(RESOURCE_LOCATION);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        return sessionFactory.openSession();
    }

    public static void closeSession(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
