package com.bjpowernode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回的结果JSON
 *
 * @author Dee
 * @date 2023-03-01 10:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO {
    private Boolean result;
    private Object data;
    private String msg;
}
