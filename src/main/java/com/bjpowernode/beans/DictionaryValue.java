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
    @NotNull(message = "�ֵ���ֵ���Ʋ���Ϊ��")
    @NotEmpty(message = "�ֵ���ֵ���Ʋ���Ϊ��")
    @NotBlank(message = "�ֵ���ֵ���Ʋ���Ϊ��")
    @Size(min = 1, max = 20, message = "�ֵ���ֵ���Ƴ���ֻ����1-20")
    private String value;
    @NotNull(message = "�ֵ���ֵ��������Ϊ��")
    @NotEmpty(message = "�ֵ���ֵ��������Ϊ��")
    @NotBlank(message = "�ֵ���ֵ��������Ϊ��")
    @Size(min = 1, max = 100, message = "�ֵ���ֵ��������ֻ����1-100")
    private String text;
    @NotNull
    @Min(value = 1, message = "����Χ��1-1000")
    @Max(value = 1000, message = "����Χ��1-1000")
    private Integer orderNo;
    @NotNull(message = "�ֵ����ͱ�Ų���Ϊ��")
    @NotEmpty(message = "�ֵ����ͱ�Ų���Ϊ��")
    @NotBlank(message = "�ֵ����ͱ�Ų���Ϊ��")
    @Size(min = 1, max = 20, message = "�ֵ����ͱ�ų���Ϊ1-20")
    private String typeId;
    private DictionaryType dictType;
}
