package com.bjpowernode.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Dee
 * @date 2023-02-27 11:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryType {
    private String id;
    private String name;
    private String description;
}
