package com.bjpowernode.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * �û���
 *
 * @author Dee
 * @date 2023-03-07 17:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    /**
     * �û�id
     */
    private String id;
    /**
     * ��������id
     */
    private String depId;
    /**
     * ��¼�˺�
     */
    private String loginAct;
    /**
     * �û��ǳ�
     */
    private String name;
    /**
     * �û�����
     */
    private String loginPwd;
    /**
     * �û�����
     */
    private String email;
    /**
     * �˺�ʧЧʱ��
     */
    private String expireTime;
    /**
     * �˺��Ƿ�������0��ʾ������1��ʾ����
     */
    private Integer lockStatus;
    /**
     * �����¼IP
     */
    private String allowIps;
    /**
     * �û���Ϣ�����
     */
    private String createById;
    private User createBy;
    /**
     * �û���Ϣ���ʱ��
     */
    private String createTime;
    /**
     * �û���Ϣ�޸���
     */
    private String editById;
    private User editBy;
    /**
     * �û���Ϣ�޸�ʱ��
     */
    private String editTime;
}
