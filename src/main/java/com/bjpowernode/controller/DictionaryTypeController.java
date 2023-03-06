package com.bjpowernode.controller;

import com.bjpowernode.beans.DictionaryType;
import com.bjpowernode.dto.ResultDTO;
import com.bjpowernode.services.DictionaryTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author Dee
 * @date 2023-02-27 12:24
 */

/**
 * @RestController 作用等同于 @Controller + @ResponseBody；
 * @ResponseBody 作用是将 Controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到 response对象的 body区，通常用来返回 JSON数据或者是 XML；
 * 注意事项：在使用 @ResponseBody后不会再走视图处理器，而是直接将数据写入到输入(?出?)流中，效果等同于通过 response对象输出指定格式的数据。
 */
@RestController
@RequestMapping("/dictionaryType")
public class DictionaryTypeController {

    @Autowired
    DictionaryTypeServices typeServices;

    @RequestMapping("getIds.action")
    public ResultDTO getIds() {

        ResultDTO resultDTO = new ResultDTO();

        ArrayList<String> ids = null;
        ids = typeServices.getIds();
        if (ids != null) {
            resultDTO.setResult(true);
            resultDTO.setData(ids);
            resultDTO.setMsg("查询成功");
        } else {
            resultDTO.setResult(false);
            resultDTO.setData(ids);
            resultDTO.setMsg("查询失败");
        }

        return resultDTO;
    }

    @RequestMapping("getAll.action")
    public ResultDTO getAll() {

        ResultDTO resultDTO = new ResultDTO();

        ArrayList<DictionaryType> dictionaryTypes = null;
        dictionaryTypes = typeServices.getAll();
        if (dictionaryTypes != null) {
            resultDTO.setResult(true);
            resultDTO.setData(dictionaryTypes);
            resultDTO.setMsg("查询成功");
        } else {
            resultDTO.setResult(false);
            resultDTO.setData(dictionaryTypes);
            resultDTO.setMsg("查询失败");
        }

        return resultDTO;
    }

    @RequestMapping("get.action")
    public ResultDTO get(String id) {

        ResultDTO resultDTO = new ResultDTO();

        DictionaryType dictionaryType = null;
        dictionaryType = typeServices.get(id);
        if (dictionaryType != null) {
            resultDTO.setResult(true);
            resultDTO.setData(dictionaryType);
            resultDTO.setMsg("查询成功");
        } else {
            resultDTO.setResult(false);
            resultDTO.setData(dictionaryType);
            resultDTO.setMsg("无对应数据");
        }

        return resultDTO;
    }

    @RequestMapping("add.action")
    public ResultDTO add(@RequestBody DictionaryType dictionaryType) {

        ResultDTO resultDTO = new ResultDTO();

        if (typeServices.add(dictionaryType)) {
            resultDTO.setResult(true);
            resultDTO.setData(null);
            resultDTO.setMsg("添加成功");
        } else {
            resultDTO.setResult(false);
            resultDTO.setData(null);
            resultDTO.setMsg("添加失败");
        }

        return resultDTO;
    }

    @RequestMapping("edit.action")
    public ResultDTO edit(@RequestBody DictionaryType dictionaryType) {

        ResultDTO resultDTO = new ResultDTO();

        if (typeServices.edit(dictionaryType)) {
            resultDTO.setResult(true);
            resultDTO.setData(null);
            resultDTO.setMsg("修改成功");
        } else {
            resultDTO.setResult(false);
            resultDTO.setData(null);
            resultDTO.setMsg("修改失败");
        }

        return resultDTO;
    }

    /**
     * @param ids
     * @return
     * @RequestParam校正请求参数名，修饰处理器方法参数； 可选参数 required为 true时，表示请求必须传递参数；
     * 可选参数 defaultValue为默认参数值
     */
    @RequestMapping("del.action")
    public ResultDTO del(@RequestBody String[] ids) {

        ResultDTO resultDTO = new ResultDTO();

        if (typeServices.del(ids)) {
            resultDTO.setResult(true);
            resultDTO.setData(null);
            resultDTO.setMsg("删除成功");
        } else {
            resultDTO.setResult(false);
            resultDTO.setData(null);
            resultDTO.setMsg("删除失败");
        }

        return resultDTO;
    }
}
