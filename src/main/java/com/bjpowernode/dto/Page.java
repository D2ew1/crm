package com.bjpowernode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页
 *
 * @author Dee
 * @date 2023-03-11 17:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page implements Serializable {
    private Integer currentPage = 1;
    private Integer rowsPerPage = 10;
    private Integer maxRowsPerPage = 100;
    private Integer totalRows;
    private Integer totalPages;
    private Integer visiblePageLinks = 5;
    private List data;
    /**
     * 查询条件(待定)
     */
    private Map<String, Object> conditions = new HashMap<>();
}
