package sk.upjs.paz1c.test;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.security.crypto.bcrypt.BCrypt;
import sk.upjs.paz1c.homer.dao.mysql.MysqlUserDao;
import sk.upjs.paz1c.homer.entity.User;
import sk.upjs.paz1c.homer.ObjectFactory;

public class MysqlUserDaoTest {
    
    public MysqlUserDaoTest() {
    }
    
    @Test
    public void podlaMenaTest(){
        MysqlUserDao dao = new MysqlUserDao(ObjectFactory.INSTANCE.getJdbcTemplate());
        User user = new User();
        user.setMeno("Ivan");
        String heslo = "pazko";
        String sol = BCrypt.gensalt();
        String hesloSoSolou = BCrypt.hashpw(heslo, sol);
        user.setHeslo(hesloSoSolou);
        dao.pridajUser(user);
        User novyUser = dao.podlaMena("Ivan");
        assertTrue(novyUser != null);
    }
    
    @Test
    public void pridajUserTest(){
        MysqlUserDao dao = new MysqlUserDao(ObjectFactory.INSTANCE.getJdbcTemplate());
        User user1 = dao.podlaMena("Igor");
        User user = new User();
        user.setMeno("Igor");
        String heslo = "pazko";
        String sol = BCrypt.gensalt();
        String hesloSoSolou = BCrypt.hashpw(heslo, sol);
        user.setHeslo(hesloSoSolou);
        dao.pridajUser(user);
        Assert.assertTrue(user1 != user);
    }
}
