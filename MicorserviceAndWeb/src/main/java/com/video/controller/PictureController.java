package com.video.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.video.dao.PictureDao;
import com.video.dao.UserDao;
import com.video.entity.Picture;
import com.video.entity.User;
import com.video.service.PictureService;
import com.video.util.VideoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.annotation.security.RunAs;
import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.UUID;

/**
 * (Picture)表控制层
 *
 * @author makejava
 * @since 2023-05-06 21:14:06
 */
@RestController
@RequestMapping("picture")
@CrossOrigin
public class PictureController {

    @Autowired
    private PictureDao pictureDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private WebSocket webSocket;
    /**
     * 服务对象
     */
    @Resource
    private PictureService pictureService;


    @PostMapping("search")
    public R search(String searchText) {
        System.out.println(searchText);


        webSocket.sendMessage("搜索成功");
        List<Picture> pictures = pictureDao.selectList(new QueryWrapper<Picture>()
                        .eq("type",0)
                .like(searchText != null && !searchText.equals(""), "name", searchText));
        return R.success(pictures);
    }

    @GetMapping("startDetection")
    public R startDetection() {


        //todo 调用视频检测算法
        VideoUtil.fun();

        return R.success(null);
    }

    /**
     * 通过主键查询单条数据
     *主键
     * @return 单条数据
     */
    @GetMapping("getAllVideo")
    public R getAllVideo(){
        List<Picture> pictureList = this.pictureService.list(new QueryWrapper<Picture>().eq("type", 1));
        return R.success(pictureList);
    }

    @PostMapping("register")
    public R register(User user){


        user.setName(user.getUsername());
        userDao.insert(user);
        return R.success(user);
    }
    @PostMapping("login")
    public R login(User user){


        User user1 = userDao.selectOne(new QueryWrapper<User>().eq("username", user.getUsername())
                .eq("password", user.getPassword()));
        if(user1!=null)
            return R.success(user);
        else
            return R.failed();
    }

    @PostMapping("send")
    public R send(){
        webSocket.sendMessage("调用");
        return R.success(null);
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return R.success(this.pictureService.removeByIds(idList));
    }

//    @PostMapping("login")
//    public R login(String username,String password){
//        System.out.println(username+"/"+password);
//        return R.success(null);
//    }

    @PostMapping("uploadImg")
    public R img(@RequestParam("file") MultipartFile file) throws IOException {

        if (file.isEmpty()) {
            return R.failed();
        }

        //文件名称
        String fileName = file.getOriginalFilename();
        //允许上传文件名的后缀
//        List<String> FILE_WHILE_EXT_LIST = Arrays.asList("JPG","PNG","JPEG","GIF");
        Assert.notNull(fileName,"File name can not be empty");
//        String fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1);
//        if (FILE_WHILE_EXT_LIST.contains(fileExtName.toUpperCase())){
        //上传文件的位置
        //SAVE_PATH  E:/liangd/Java/stmg-front/src/main/webapp
        //IMG_PATH  /upload/
//        fileName =  UUID.randomUUID()+"."+fileExtName;

        URL url = ResourceUtils.getURL("classpath:");
        String r = url.getPath();
        OutputStream outputStream = new FileOutputStream(new File(r+ "static/" +fileName).getPath());
        outputStream.write(file.getBytes());

        Picture picture = new Picture();
        picture.setName(fileName);
        picture.setPath( fileName);
        picture.setType(0);
        pictureDao.insert(picture);

        return R.success(picture);
    }

    @PostMapping("uploadVideo")
    public R video(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return R.failed();
        }
        //文件名称
        String fileName = file.getOriginalFilename();
        Assert.notNull(fileName,"File name can not be empty");
        URL url = ResourceUtils.getURL("classpath:");
        String r = url.getPath();
        OutputStream outputStream = new FileOutputStream(new File(r+ "static/" +fileName).getPath());
        outputStream.write(file.getBytes());

        Picture picture = new Picture();
        picture.setName(fileName);
        picture.setPath( ""+fileName);
        picture.setType(1);
        pictureDao.insert(picture);

        return R.success(picture);

    }


}

