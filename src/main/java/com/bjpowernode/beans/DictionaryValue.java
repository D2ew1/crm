package com.bjpowernode.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Dee
 * @date 2023-02-27 11:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryValue {
    private String id;
    private String value;
    private String text;
    private Integer orderNo;
    private String typeId;
    private DictionaryType dictType;
}
