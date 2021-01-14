package jp.co.wisdom.newcommer2020.controller;


import org.springframework.web.bind.annotation.GetMapping;

import jp.co.wisdom.newcommer2020.controller.bean.Greeting;

/**
 * @author s.okada
 * Spring管理のクラス
 */
public class SampleController {

	/**
	 * あいさつ文
	 */
	private static final String template = "Hello, World!";
	/**
	 * 識別子
	 */
	private final int num = 9;

	/**
	 * getリクエストのときに動作するメソッド
	 * @param name
	 * @return リソース表現
	 */
	@GetMapping("/greeting")
	public Greeting getProc() {
		return new Greeting(num,template);
	}

	/**
	 * postリクエストのときに動作するメソッド
	 */
	//@PostMapping("/input")
	public void postProc() {

	}
}
