package com.majorjava.monster.monster.controller;

import com.majorjava.monster.monster.entity.user.User;
import com.majorjava.monster.monster.service.User.UserServices;
import com.majorjava.monster.monster.upload.UploadProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-05 19:58
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @Resource
    private UploadProperties uploadProperties;

    @Resource
    private ResourceLoader resourceLoader;

    @GetMapping("/userList")
      public String list(Model model){
          List<User> userList = userServices.findAll();
          model.addAttribute("userList",userList);
          return "admin/user/admin_user_list";
      }

    @GetMapping("/duserList")
    public String listByDelete(Model model){
        List<User> userList = userServices.findBydelete();
        model.addAttribute("userList",userList);
        return "admin/user/admin_user_list";
    }

      @GetMapping("/edit")
      public String edit(Integer id,Model model){
        User user=null;
        if (id==null){
            user=new User();
        }else {
            user=userServices.finByid(id);
        }
        model.addAttribute("user",user);
        return "user/user_edit";
    }

    @GetMapping("/adminEdit")
    public String edit2(Integer id,Model model){
        User user=null;
        if (id==null){
            user=new User();
        }else {
            user=userServices.finByid(id);
        }
        model.addAttribute("user",user);
        return "admin/user/admin_user_edit";
    }

      @PostMapping("/save")
      public String sava(int age,Integer id,RedirectAttributes redirectAttributes, String username,
                         String password, String password2, String sex, String birthday, String email,
                         Model model,@RequestParam("file") MultipartFile file,String phone,String signature)throws IOException{
                            User user=null;
                            if (id==null){
                                user=new User();
                                user.setPassword(password);
                                user.setUsername(username);
                                String s = UUID.randomUUID().toString().replaceAll("-", "");
                                user.setSalt(s);
                            }else {
                                user=userServices.finByid(id);

                                }
           /*                         File file1=new File("D:\\uploads\\sb");
          if(!file.getOriginalFilename().equals("")){
              //获取文件的后缀名
              String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));;
              //新文件名
              String filename = UUID.randomUUID().toString() + suffix;
              //新文件对象
              File file2=new File("D:\\uploads\\sb\\"+filename);
              //保存文件
              file.transferTo(file2);
              System.out.println("上传头像"+filename+"成功！");
              user.setHeadshot("/uploads/"+filename);
          }*/
                              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                              try {
                                  user.setBirthday(sdf.parse(birthday));
                              } catch (ParseException e) {
                                  e.printStackTrace();
                              }
                              user.setSex(sex);
                              user.setAge(age);
                              user.setCreateTime(new Timestamp(System.currentTimeMillis()));
                              user.setPhone(phone);
                              user.setEmail(email);
                              user.setSignature(signature);
                              user.setState(1);
                              //上传头像
                              String headshotFilename = uploadHeadshot(file);
                              //头像名不为空，才更新头像的路径
                              if(headshotFilename!=null) {
                                  user.setHeadshot("/user/"+headshotFilename);
                                  System.out.println("修改的图像为："+user.getHeadshot());

                            }
                           user = userServices.save(user);
                          redirectAttributes.addFlashAttribute("message","修改成功！");
                          return "redirect:/user/userList";
                      }

    @GetMapping("/delete")
    public String delete(Integer id, RedirectAttributes redirectAttributes){
        User user = userServices.finByid(id);
        user.setState(0);
        userServices.save(user);
        redirectAttributes.addFlashAttribute("message","删除用户成功！");
        return "redirect:/user/duserList";
    }

    @GetMapping("restore")
    private String restore(Integer id,RedirectAttributes redirectAttributes){
        User user = userServices.finByid(id);
        user.setState(1);
        userServices.save(user);
        redirectAttributes.addFlashAttribute("message","恢复用户成功！");
        return "redirect:/user/userList";

    }

    @GetMapping("finalDelete")
    private String finalDelete(Integer id, RedirectAttributes redirectAttributes){
        userServices.finalDelete(id);
        redirectAttributes.addFlashAttribute("message","最终删除成功！");
        return "redirect:/user/duserList";
    }

    /**
     * 获取头像
     * @param filename
     * @return
     */
    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(uploadProperties.getBasePath() + filename)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 上次头像方法
     * @param file
     * @return
     * @throws IOException
     */
    private String uploadHeadshot(MultipartFile file) throws IOException {
        // 获取头像存放路径
        String basePath = uploadProperties.getBasePath();
        // 判断文件夹是否存在，不存在则
        File folder = new File(basePath);
        if(!folder.exists()){
            folder.mkdirs();
        }

        String filename = null;

        //如果上次的头像不为空
        if(!file.getOriginalFilename().equals("")){
            //获取文件的后缀名
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));;
            //新文件名
            filename = UUID.randomUUID().toString() + suffix;
            //新文件对象
            File saveFile = new File(folder + "/" + filename);
            //保存文件
            file.transferTo(saveFile);
            System.out.println("上传头像"+filename+"成功！");
        }

        return filename;
    }
}
