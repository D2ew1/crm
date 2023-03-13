package com.bjpowernode.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * ���
 *
 * @author Dee
 * @date 2023-03-07 17:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity implements Serializable {
    /**
     * �id
     */
    private String id;
    /**
     * �������
     */
    private String ownerId;
    private User owner;
    /**
     * �����
     */
    private String name;
    /**
     * ���ʼ����
     */
    private String startDate;
    /**
     * ���������
     */
    private String endDate;
    /**
     * �����
     */
    private Integer cost;
    /**
     * �����
     */
    private String description;
    /**
     * �������
     */
    private String createById;
    private User createBy;
    /**
     * �����ʱ��
     */
    private String createTime;
    /**
     * ��޸���
     */
    private String editById;
    private User editBy;
    /**
     * ��޸�ʱ��
     */
    private String editTime;
    /**
     * �����б�
     */
    private ArrayList<Comment> comments;
}
