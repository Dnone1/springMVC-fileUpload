package com.java.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

import java.util.UUID;

@Controller
public class TestController {

    //同步上传
    @RequestMapping("/file/upload")
    public String upload(MultipartFile filename , HttpServletRequest servlet , Model model) throws IOException {
        System.out.println(filename);

        //获取当前项目的上下文路径
        ServletContext servletContext = servlet.getSession().getServletContext();
        //获取upload文件夹是否存在在当前路径
        String path = servletContext.getRealPath("upload");
        System.out.println("servletContext "+servletContext);
        System.out.println("path "+path);

        File file = new File(path);
        if(!file.exists()) {
            file.mkdir();
        }

        //获取文件的名称
        String originalFilename = filename.getOriginalFilename();

        //前缀拼接uuid
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFile = UUID.randomUUID().toString()+substring;
        System.out.println(newFile);


        //上传文件
        filename.transferTo(new File(file , newFile));

        //获取文件：http://localhost:9282/文件夹/文件
        String uploadNewFile = servlet.getScheme()+"://"+servlet.getServerName()+":"+servlet.getServerPort()+"/upload/"+newFile ;
        System.out.println(uploadNewFile);
        //filename.transferTo(new File());

        model.addAttribute("file" , uploadNewFile);
        return "index" ;
    }

    //异步上传
    @RequestMapping("/file/uploadAjax")
    public String uploadAjax(MultipartFile filename , HttpServletRequest httpServletRequest , Model model) throws IOException {
        //获取当前项目的上下文路径
        ServletContext servletContext = httpServletRequest.getSession().getServletContext();
        //获取upload在当前项目下的路径
        String path = servletContext.getRealPath("upload");

        //获取文件名称
        String originalFilename = filename.getOriginalFilename();

        //判断当前文件夹是否存在
        File file = new File(path);
        if(!file.exists()) {
            file.mkdir();
        }


        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFile = UUID.randomUUID().toString()+substring;

        filename.transferTo(new File(path , newFile));

        String s = httpServletRequest.getScheme()+"://"+httpServletRequest.getServerName()+":"+httpServletRequest.getServerPort()+"/upload"+newFile ;

        model.addAttribute("fileone" , s);

        return "";

    }
}
