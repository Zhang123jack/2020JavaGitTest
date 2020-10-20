package com.zxr.service.impl;

import com.zxr.dao.ContactDao;
import com.zxr.dao.impl.ContactDaoImpl;
import com.zxr.domain.Contact;
import com.zxr.service.ContactService;

import java.util.List;

public class ContactServiceImpl implements ContactService {
    ContactDao dao=new ContactDaoImpl();
    @Override
    public List<Contact> queryAll() {
        return dao.queryAll();
    }

    @Override
    public List<Contact> queryAll(int currentPage, int pageSize) {
        int pageOffset=(currentPage-1)*pageSize;
        return dao.queryAll(pageOffset,pageSize);
    }

    @Override
    public int getPageCount(int pageSize) {
        int count=dao.getContactCount();
        int pageCount=(int)Math.ceil(count/(double)pageSize);
        return pageCount;
    }

    @Override
    public boolean deleteById(String contactId) {
        int num=dao.deleteById(contactId);
        if(num==1){
            return true;
        }
        return false;
    }

    @Override
    public Contact getContact(String id) {
        Contact contact=dao.getContact(id);
        return contact;
    }

    @Override
    public boolean update(Contact contact) {
        int result=dao.update(contact);
        return result==1;
    }

    @Override
    public boolean add(Contact contact) {
        int result=dao.add(contact);
        return result==1;
    }


}
