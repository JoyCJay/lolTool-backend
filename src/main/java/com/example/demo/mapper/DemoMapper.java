package com.example.demo.mapper;

import java.util.List;

import com.example.demo.domain.OnlineControlDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.DemoTable1Entity;

@Repository
public interface DemoMapper {
	
	List<OnlineControlDto> getOnlineControl();

	void addOnlineControl(OnlineControlDto OCinformation);
	 
//    public Long insertArticle(Article article);
// 
//    public void updateArticle(Article article);
// 
//    public Article queryById(Long id);
 
//    public List<Article> queryArticlesByPage(@Param("article") Article article, @Param("pageSize") int pageSize,
//                                             @Param("offset") int offset);
 
}