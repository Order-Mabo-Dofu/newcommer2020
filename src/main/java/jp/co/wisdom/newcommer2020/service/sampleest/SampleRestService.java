package jp.co.wisdom.newcommer2020.service.sampleest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import jp.co.wisdom.newcommer2020.controller.bean.Greeting;

/**
 * @author s.okada
 * Spring管理のクラス
 */
@Service
public class SampleRestService {

	/**
	 * あいさつ文(String.formatによる置換用テンプレート)
	 */
	private final String template = "Hello, %s!";
	/**
	 * 識別子(画面が表示された回数のカウント用)
	 */
	private final AtomicLong counter = new AtomicLong();

	/**
	 * 画面表示カウントの増加とあいさつ文の可変部分を置換
	 * @param name
	 * @return 画面表示内容
	 */
	public Greeting process(String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
