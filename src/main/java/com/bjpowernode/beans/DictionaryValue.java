package com.bjpowernode.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @author Dee
 * @date 2023-02-27 11:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryValue implements Serializable {
    private String id;
    @NotNull(message = "字典数值名称不能为空")
    @NotEmpty(message = "字典数值名称不能为空")
    @NotBlank(message = "字典数值名称不能为空")
    @Size(min = 1, max = 20, message = "字典数值名称长度只能是1-20")
    private String value;
    @NotNull(message = "字典数值描述不能为空")
    @NotEmpty(message = "字典数值描述不能为空")
    @NotBlank(message = "字典数值描述不能为空")
    @Size(min = 1, max = 100, message = "字典数值描述长度只能是1-100")
    private String text;
    @NotNull
    @Min(value = 1, message = "排序范围是1-1000")
    @Max(value = 1000, message = "排序范围是1-1000")
    private Integer orderNo;
    @NotNull(message = "字典类型编号不能为空")
    @NotEmpty(message = "字典类型编号不能为空")
    @NotBlank(message = "字典类型编号不能为空")
    @Size(min = 1, max = 20, message = "字典类型编号长度为1-20")
    private String typeId;
    private DictionaryType dictType;
}
