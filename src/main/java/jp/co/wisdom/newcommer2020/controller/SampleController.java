package jp.co.wisdom.newcommer2020.controller;


import java.time.LocalDateTime;

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
	 * getリクエストのときに動作し、
	 * valueの受け取りとページにアクセスした時刻を受け渡して画面に返却するメソッドです。
	 *
	 * 処理詳細：
	 * ・@RequestParamでvalueの受け取り
	 * ・現在時刻(hh)を数値で取得
	 *
	 * @param name 受け取ったvalue(defaultValue = "World")
	 * @param hour ページにアクセスした時刻(hh)
	 * @return 画面表示内容
	 */
	@GetMapping("/greeting")
	public Greeting greetingProcess(@RequestParam(value = "name", defaultValue = "World") String name) {
		//ページにアクセスした時の現在日時情報で初期化されたインスタンスの取得
		LocalDateTime nowDateTime = LocalDateTime.now();
		//現在時刻(hh)を数値で取得
		int hour = nowDateTime.getHour();

		return this.sampleRestService.process(name,hour);
	}

	/**
	 * postリクエストのときに動作するメソッド
	 */
	//@PostMapping("/input")
	public void postProc() {

	}
}
