package com.bjpowernode.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Dee
 * @date 2023-02-27 11:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryType {
    @NotNull(message = "字典类型编号不能为空")
    @NotEmpty(message = "字典类型编号不能为空")
    @NotBlank(message = "字典类型编号不能为空")
    @Size(min = 1, max = 20, message = "字典类型编号长度为1-20")
    private String id;
    @NotNull(message = "字典类型名称不能为空")
    @NotEmpty(message = "字典类型名称不能为空")
    @NotBlank(message = "字典类型名称不能为空")
    @Size(min = 1, max = 20, message = "字典类型名称长度为1-20")
    private String name;
    @NotNull(message = "字典类型描述不能为空")
    @NotEmpty(message = "字典类型描述不能为空")
    @NotBlank(message = "字典类型描述不能为空")
    @Size(min = 1, max = 100, message = "字典类型描述长度为1-100")
    private String description;
}
