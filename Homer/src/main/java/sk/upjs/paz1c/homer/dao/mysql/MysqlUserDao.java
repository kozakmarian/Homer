package sk.upjs.paz1c.homer.dao.mysql;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.paz1c.homer.dao.UserDao;
import sk.upjs.paz1c.homer.entity.User;

public class MysqlUserDao implements UserDao{

    private JdbcTemplate jdbcTemplate;
    
    public MysqlUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public User podlaMena(String meno) {
        String sql = "SELECT * FROM user WHERE meno = ?";
        BeanPropertyRowMapper<User> mapper = BeanPropertyRowMapper.newInstance(User.class);      
        List<User> users = jdbcTemplate.query(sql,mapper, meno);
        if(users.isEmpty()){
            return null;
        }else{
            User user = users.get(0);
            return user;    
        }               
    }

    @Override
    public void pridajUser(User user) {
        jdbcTemplate.update("INSERT INTO user(meno, heslo) VALUES(?,?)",
                user.getMeno(), user.getHeslo());
    }
    
}
