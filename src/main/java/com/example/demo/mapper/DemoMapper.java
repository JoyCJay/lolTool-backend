package com.example.demo.mapper;

import java.util.List;

import com.example.demo.domain.OnlineControlDto;
import com.example.demo.entity.Match;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoMapper {
	
	List<OnlineControlDto> getOnlineControl();

	void addOnlineControl(OnlineControlDto OCinformation);

	List<Match> getMatchInfo(String match_id);
//    public Long insertArticle(Article article);
// 
//    public void updateArticle(Article article);
// 
//    public Article queryById(Long id);
 
//    public List<Article> queryArticlesByPage(@Param("article") Article article, @Param("pageSize") int pageSize,
//                                             @Param("offset") int offset);
 
}