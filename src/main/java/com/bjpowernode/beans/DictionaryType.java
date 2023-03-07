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
    @NotNull(message = "�ֵ����ͱ�Ų���Ϊ��")
    @NotEmpty(message = "�ֵ����ͱ�Ų���Ϊ��")
    @NotBlank(message = "�ֵ����ͱ�Ų���Ϊ��")
    @Size(min = 1, max = 20, message = "�ֵ����ͱ�ų���Ϊ1-20")
    private String id;
    @NotNull(message = "�ֵ��������Ʋ���Ϊ��")
    @NotEmpty(message = "�ֵ��������Ʋ���Ϊ��")
    @NotBlank(message = "�ֵ��������Ʋ���Ϊ��")
    @Size(min = 1, max = 20, message = "�ֵ��������Ƴ���Ϊ1-20")
    private String name;
    @NotNull(message = "�ֵ�������������Ϊ��")
    @NotEmpty(message = "�ֵ�������������Ϊ��")
    @NotBlank(message = "�ֵ�������������Ϊ��")
    @Size(min = 1, max = 100, message = "�ֵ�������������Ϊ1-100")
    private String description;
}
