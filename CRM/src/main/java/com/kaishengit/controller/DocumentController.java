package com.kaishengit.controller;

import com.kaishengit.pojo.Document;
import com.kaishengit.service.DocumentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import java.nio.file.Path;
import java.util.List;

@Controller
@RequestMapping("/doc")
public class DocumentController {

@Inject
private DocumentService documentService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(@RequestParam(required = false,defaultValue = "0")Integer fid,
                       Model model){
        List<Document> documentList = documentService.findDocumentByFid(fid);
        model.addAttribute("documentList",documentList);
        model.addAttribute("fid",fid);
        return "document/list";

    }
    /**
     * 新建文件夹
     * @param name
     * @param fid
     * @return
     */
    @RequestMapping(value = "dir/new",method = RequestMethod.POST)
    public String saveDir(String name,Integer fid){
        documentService.saveDir(name,fid);
        return "redirect:/doc?fid"+fid;

    }

    /**
     * 文件上传
     * @return
     */
    @RequestMapping(value = "/file/upload",method = RequestMethod.POST)
    @ResponseBody
    public String saveFile(MultipartFile file,Integer fid){



        return "";

    }



}
