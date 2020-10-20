package com.zxr.dao.impl;
import com.zxr.dao.ContactDao;
import com.zxr.domain.Contact;
import com.zxr.utils.DatabaseUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
public class ContactDaoImpl implements ContactDao {
    JdbcTemplate j=DatabaseUtils.getJdbcTemplate();
    @Override
    public List<Contact> queryAll() {
        List<Contact> cons=null;
        String sql="select * from contact_info where del=0";
        try {
            cons= j.query(sql, new BeanPropertyRowMapper<>(Contact.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cons;
    }
    @Override
    public List<Contact> queryAll(int pageOffset, int pageSize) {
        List<Contact> cons=null;
        String sql="select * from contact_info where del=0 limit ?,?";
        try {
            cons = j.query(sql, new BeanPropertyRowMapper<>(Contact.class),pageOffset,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cons;
    }
    @Override
    public int getContactCount() {
        int result=0;
        String sql="select count(*) from contact_info where del=0";
        try {
            result= j.queryForObject(sql,Integer.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        return result;
    }
    @Override
    public int deleteById(String contactId) {
        String sql="Update contact_info set del=1 where id=?";
        int a=0;
        try {
            a=j.update(sql,contactId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }
    @Override
    public Contact getContact(String id) {
        String sql="select * from contact_info where id=? and del=0";
        Contact contact=null;
        contact = j.queryForObject(sql, new BeanPropertyRowMapper<>(Contact.class),id);
        return contact;
    }
    @Override
    public int update(Contact contact) {
        String sql="update contact_info set `name`=?,gender=?,birthday=?,birthplace=?,mobile=?,email=?  where id=?";
        return j.update(sql,contact.getName(),contact.getGender(),contact.getBirthday(),contact.getBirthplace(),contact.getMobile(),contact.getEmail(),contact.getId());
    }
    @Override
    public int add(Contact contact) {
        String sql="insert into contact_info(`name`,gender,birthday,birthplace,mobile,email) values(?,?,?,?,?,?)";
        return j.update(sql,contact.getName(),contact.getGender(),contact.getBirthday(),contact.getBirthplace(),contact.getMobile(),contact.getEmail());
    }
}
