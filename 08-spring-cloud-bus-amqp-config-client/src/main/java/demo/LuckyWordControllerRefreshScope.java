package demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties
@RefreshScope
public class LuckyWordControllerRefreshScope {
	 
	String luckyWord;
	
	@RequestMapping("/lucky-word-refresh")
	public String showLuckyWord() {
		return  luckyWord;
	}

	public String getLuckyWord() {
		return luckyWord;
	}

	public void setLuckyWord(String luckyWord) {
		this.luckyWord = luckyWord;
	}
	
}
