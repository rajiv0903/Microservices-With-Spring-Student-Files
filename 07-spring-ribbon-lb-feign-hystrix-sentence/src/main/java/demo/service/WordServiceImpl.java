package demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import demo.dao.AdjectiveClient;
import demo.dao.ArticleClient;
import demo.dao.NounClient;
import demo.dao.SubjectClient;
import demo.dao.VerbClient;
import demo.domain.Word;

@Service
public class WordServiceImpl implements WordService {

	@Autowired VerbClient verbClient;
	@Autowired SubjectClient subjectClient;
	@Autowired ArticleClient articleClient;
	@Autowired AdjectiveClient adjectiveClient;
	@Autowired NounClient nounClient;
	
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackSubject")
	public Word getSubject() {
		System.out.println("Subject FeignClient is being called!");
		return subjectClient.getWord();
	}
	
	@Override
	public Word getVerb() {
		System.out.println("Verb FeignClient is being called!");
		return verbClient.getWord();
	}
	
	@Override
	public Word getArticle() {
		System.out.println("Article FeignClient is being called!");
		return articleClient.getWord();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackAdjective")
	public Word getAdjective() {
		System.out.println("Adjective FeignClient is being called!");
		return adjectiveClient.getWord();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackNoun")
	public Word getNoun() {
		System.out.println("Noun FeignClient is being called!");
		return nounClient.getWord();
	}	

	public Word getFallbackSubject() {
		return new Word("Someone");
	}
	
	public Word getFallbackAdjective() {
		return new Word("");
	}
	
	public Word getFallbackNoun() {
		return new Word("something");
	}

}
