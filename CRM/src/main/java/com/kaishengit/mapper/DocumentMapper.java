package com.kaishengit.mapper;

import com.kaishengit.pojo.Document;

import java.util.List;

public interface DocumentMapper {
    List<Document> findByFid(Integer fid);

    void save(Document document);
}
