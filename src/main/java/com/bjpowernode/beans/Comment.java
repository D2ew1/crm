package com.bjpowernode.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 评论类
 *
 * @author Dee
 * @date 2023-03-07 17:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    /**
     * 评论id
     */
    private String id;
    /**
     * 评论发表人
     */
    private String notePersonId;
    private User notePerson;
    /**
     * 评论内容
     */
    private String noteContent;
    /**
     * 评论发表时间
     */
    private String noteTime;
    /**
     * 评论修改人
     */
    private String editPersonId;
    private User editPerson;
    /**
     * 评论修改时间
     */
    private String editTime;
    /**
     * 评论是否被修改过，0表示未修改过，1表示修改过
     */
    private Integer editFlag;
    /**
     * 所属活动id
     */
    private String marketingActivitiesId;
}
