package jp.co.wisdom.newcommer2020.controller;


import org.springframework.beans.factory.annotation.Autowired;
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
	 * 処理用クラスの呼び出し
	 */
	@Autowired
	private jp.co.wisdom.newcommer2020.service.sampleest.SampleRestService sampleRestService;

	/**
	 * getリクエストのときに動作するメソッド
	 * @param name
	 * @return 画面表示内容
	 */
	@GetMapping("/greeting")
	public Greeting greetingProcess(@RequestParam(value = "name", defaultValue = "World") String name) {
        return this.sampleRestService.process(name);
	}

	/**
	 * postリクエストのときに動作するメソッド
	 */
	//@PostMapping("/input")
	public void postProc() {

	}
}
