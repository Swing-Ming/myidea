package com.kaishengit.service;

import com.kaishengit.mapper.DocumentMapper;
import com.kaishengit.pojo.Document;
import com.kaishengit.util.ShiroUtil;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
@Named
public class DocumentService {
    @Inject
    private DocumentMapper documentMapper;


    public List<Document> findDocumentByFid(Integer fid) {
            return documentMapper.findByFid(fid);
    }


    public void saveDir(String name, Integer fid) {
        Document document = new Document();
        document.setName(name);
        document.setFid(fid);
        document.setCreateuser(ShiroUtil.getCurrentUserRealname());
        document.setType(Document.TYPE_DIR);
        documentMapper.save(document);
    }
}
