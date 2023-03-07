package com.bjpowernode.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ������
 *
 * @author Dee
 * @date 2023-03-07 17:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    /**
     * ����id
     */
    private String id;
    /**
     * ���۷�����
     */
    private String notePersonId;
    private User notePerson;
    /**
     * ��������
     */
    private String noteContent;
    /**
     * ���۷���ʱ��
     */
    private String noteTime;
    /**
     * �����޸���
     */
    private String editPersonId;
    private User editPerson;
    /**
     * �����޸�ʱ��
     */
    private String editTime;
    /**
     * �����Ƿ��޸Ĺ���0��ʾδ�޸Ĺ���1��ʾ�޸Ĺ�
     */
    private Integer editFlag;
    /**
     * �����id
     */
    private String marketingActivitiesId;
}
