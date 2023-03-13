package com.bjpowernode.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 活动类
 *
 * @author Dee
 * @date 2023-03-07 17:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity implements Serializable {
    /**
     * 活动id
     */
    private String id;
    /**
     * 活动所有者
     */
    private String ownerId;
    private User owner;
    /**
     * 活动名称
     */
    private String name;
    /**
     * 活动开始日期
     */
    private String startDate;
    /**
     * 活动结束日期
     */
    private String endDate;
    /**
     * 活动花销
     */
    private Integer cost;
    /**
     * 活动描述
     */
    private String description;
    /**
     * 活动发起人
     */
    private String createById;
    private User createBy;
    /**
     * 活动发起时间
     */
    private String createTime;
    /**
     * 活动修改人
     */
    private String editById;
    private User editBy;
    /**
     * 活动修改时间
     */
    private String editTime;
    /**
     * 评论列表
     */
    private ArrayList<Comment> comments;
}
