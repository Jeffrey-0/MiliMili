package dao;

import com.alibaba.fastjson.JSON;
import model.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import servlet.JDBCUtils;

import java.util.List;

public class ResDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询最新的五条数据
     *
     * @return String，JSON格式
     */
    public String queryNewRes() {
        String sql = "select * from src order by id desc limit 5 ";
        List<Resource> resourceList = template.query(sql, new BeanPropertyRowMapper<>(Resource.class));
        return JSON.toJSONString(resourceList);
    }

    /**
     * 查询随机的五条数据
     *
     * @return String，JSON格式
     */
    public String queryRanRes(Integer num) {
        String sql = "SELECT * FROM src ORDER BY RAND() LIMIT ?";
        List<Resource> resourceList = template.query(sql, new BeanPropertyRowMapper<>(Resource.class),num);
        return JSON.toJSONString(resourceList);
    }

    /**
     * 通过id查询资源
     *
     * @param id String
     * @return String, 对象的JSON数据
     */
    public String queryResById(String id) {
        String sql = "SELECT * FROM src where id=?";
        Resource resource = template.queryForObject(sql, new BeanPropertyRowMapper<>(Resource.class), id);
        return JSON.toJSONString(resource);
    }

    public String queryResByName(String search, String page) {
        String sql = "SELECT * FROM src where name like '%" + search + "%' limit " + (Integer.parseInt(page) - 1) * 10 + ",10";
        List<Resource> resourceList = template.query(sql, new BeanPropertyRowMapper<>(Resource.class));
        return JSON.toJSONString(resourceList);
    }

    public Integer querySearchPages(String search) {
        String sql = "SELECT count(id) FROM src where name like '%" + search + "%'";
        Integer count = template.queryForObject(sql, Integer.class);
        return (count / 11) + 1;
    }

    public String queryResByCategory(String search, String page) {
        String sql = "SELECT * FROM src where category=? limit " + (Integer.parseInt(page) - 1) * 10 + ",10";
        List<Resource> resourceList = template.query(sql, new BeanPropertyRowMapper<>(Resource.class), search);
        return JSON.toJSONString(resourceList);
    }

    public Integer queryCategoryPages(String search) {
        String sql = "SELECT count(id) FROM src where category=?";
        Integer count = template.queryForObject(sql, Integer.class, search);
        return (count / 11) + 1;
    }

    public String queryAllRes(String search, String page) {
        String sql = "SELECT * FROM src limit " + (Integer.parseInt(page) - 1) * 10 + ",10";
        List<Resource> resourceList = template.query(sql, new BeanPropertyRowMapper<>(Resource.class));
        return JSON.toJSONString(resourceList);
    }

    public Integer queryAllPages(String search) {
        String sql = "SELECT count(id) FROM src";
        Integer count = template.queryForObject(sql, Integer.class);
        return (count / 11) + 1;
    }

    public String queryResIndexCategory(String search) {
        String sql = "SELECT * FROM src where category = ? ORDER BY RAND() LIMIT 5";
        List<Resource> resourceList = template.query(sql, new BeanPropertyRowMapper<>(Resource.class), search);
        return JSON.toJSONString(resourceList);
    }

    public String queryResByUserId(Integer userId, String page) {
        String sql = "SELECT * FROM src where uploader=? limit " + (Integer.parseInt(page) - 1) * 10 + ",10";
        List<Resource> resourceList = template.query(sql, new BeanPropertyRowMapper<>(Resource.class), userId);
        return JSON.toJSONString(resourceList);
    }

    public Integer queryUserPages(Integer userId) {
        String sql = "SELECT count(id) FROM src where uploader=?";
        Integer count = template.queryForObject(sql, Integer.class, userId);
        return (count / 11) + 1;
    }

    public Integer deleteById(String id) {
        String sql = "delete from src where id=?";
        return template.update(sql, id);
     }
}
