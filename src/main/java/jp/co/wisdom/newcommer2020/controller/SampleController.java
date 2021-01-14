package jp.co.wisdom.newcommer2020.controller;


import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.co.wisdom.newcommer2020.controller.bean.Greeting;

/**
 * @author s.okada
 * Spring管理のクラス
 */
@RestController
public class SampleController {

	/**
	 * あいさつ文
	 */
	private final String template = "Hello, %s!";
	/**
	 * 識別子
	 */
	private final AtomicLong counter = new AtomicLong();

	/**
	 * getリクエストのときに動作するメソッド
	 * @param name
	 * @return リソース表現
	 */
	@GetMapping("/greeting")
	public Greeting getProc(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	/**
	 * postリクエストのときに動作するメソッド
	 */
	//@PostMapping("/input")
	public void postProc() {

	}
}
