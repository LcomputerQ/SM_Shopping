package com.hp.utlis;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Upload {
    public static String onUpload(MultipartFile photo, HttpSession session,String dir) throws IOException {
        //获取上传的文件的文件名
        String name = photo.getOriginalFilename();
        if(name.equals(""))
            return null;
        //处理文件重名问题
        String hzName = name.substring(name.lastIndexOf("."));
        hzName= UUID.randomUUID()+hzName;
        //获取服务器中photo目录的路径
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath(dir);
        File file = new File(photoPath);
        String finalPath = photoPath + File.separator + hzName;
        if(!file.exists()){
            file.mkdir();
        }
        //实现上传功能
        photo.transferTo(new File(finalPath));
        return hzName;
    }
}
