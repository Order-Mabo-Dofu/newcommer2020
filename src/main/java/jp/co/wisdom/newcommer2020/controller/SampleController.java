package jp.co.wisdom.newcommer2020.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.co.wisdom.newcommer2020.controller.bean.Greeting;
import jp.co.wisdom.newcommer2020.service.sampleest.SampleRestService;

/**
 * Spring管理のクラス
 * @author s.okada
 */
@RestController
public class SampleController {

	/**
	 * 処理用クラスの呼び出し
	 * コンストラクタインジェクション
	 */
	private final SampleRestService sampleRestService;
	@Autowired
	public SampleController(SampleRestService sampleRestService){
		this.sampleRestService = sampleRestService;
	}

	/**
	 * * greetingProcessメソッドは
	 * getリクエストのときに動作してvalueを受け取り、
	 * serviceにあいさつ文作成処理を移譲して、結合したあいさつ文を画面に返却するメソッドです。
	 *
	 * 処理詳細：
	 * ・@RequestParamでvalueの受け取り
	 *
	 * @param name 受け取ったvalue(defaultValue = "World")
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
