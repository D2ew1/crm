package com.bjpowernode.services;

import com.bjpowernode.beans.Activity;
import com.bjpowernode.dto.Page;
import com.bjpowernode.exception.DBException;
import com.bjpowernode.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Dee
 * @date 2023-03-09 20:58
 */
@Service
public class ActivityServicesImp implements ActivityServices {

    @Autowired
    ActivityMapper mapper;

    @Override
    public void getPage(Page page) throws DBException {

        Integer offset = page.getRowsPerPage();
        Integer index = (page.getCurrentPage() - 1) * offset;
        Integer amount = 0;
        try {
            amount = mapper.count();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        page.setTotalRows(amount);
        if (amount % offset == 0) {
            page.setTotalPages(amount / offset);
        } else {
            page.setTotalPages(amount / offset + 1);
        }

        ArrayList<Activity> activities = null;
        try {
            activities = mapper.getPage(index, offset);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("��ѯʧ��");
        }

        if (activities == null) {
            throw new DBException("���������");
        }

        page.setData(activities);
    }

    @Override
    public Activity get(String id) throws DBException {

        Activity activity = null;
        try {
            activity = mapper.get(id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("��ѯʧ��");
        }

        if (activity == null) {
            throw new DBException("���������");
        }

        return activity;
    }

    @Override
    public void add(Activity activity) throws DBException {

        activity.setId(UUID.randomUUID().toString().replace("-", ""));
        // ��½����Ϣ(�ٶ�Ϊ����)
        activity.setCreateById("d72e803330bd4a83b54b68616b1985ef");
        activity.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        int rows = 0;
        try {
            rows = mapper.add(activity);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("���ʧ��");
        } catch (DuplicateKeyException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("���ʧ�ܣ���Ϊ�����ظ�");
        } catch (DataIntegrityViolationException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("���ʧ�ܣ���ѡ����ȷ�Ļ������");
        }

        if (rows <= 0) {
            throw new DBException("���ʧ��");
        }
    }

    @Override
    public void edit(Activity activity) throws DBException {

    }

    @Override
    public void del(String[] ids) throws DBException {

        int rows = 0;
        try {
            rows = mapper.del(ids);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("ɾ��ʧ��");
        } catch (DataIntegrityViolationException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("ɾ��ʧ�ܣ���Ϊ�û��������");
        } catch (BadSqlGrammarException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("ɾ��ʧ�ܣ�δѡ��������");
        }

        if (rows <= 0) {
            throw new DBException("ɾ��ʧ��");
        }
    }

}
