package jp.co.wisdom.newcommer2020.service.sampleest;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import jp.co.wisdom.newcommer2020.controller.bean.Greeting;

/**
 * Spring管理のクラス
 * @author s.okada
 */
@Service
public class SampleRestService {

	/**
	 * 識別子(画面が表示された回数のカウント用)
	 */
	private final AtomicLong counter = new AtomicLong();

	/**
	 * processメソッドは
	 * 画面表示カウントの増加とあいさつ文を返却するメソッドです。
	 *
	 * 処理詳細：
	 * ・greetingTimeメソッドであいさつ文の作成
	 * ・incrementAndGet()でカウントの増加
	 *
	 * @param template 作成したあいさつ文
	 * @param id 識別子(画面が表示された回数のカウント用)
	 * @return 画面表示内容
	 */
	public Greeting process(String name) {

		//時間帯に応じたあいさつ文の作成
		String template = greetingTime(name);
		//画面が表示された回数のカウント増加
		long id = counter.incrementAndGet();

		//画面が表示された回数と時間帯に応じたあいさつ文を返す
		return new Greeting(id,template);
	}

	/**
	 * greetingTimeメソッドは
	 * あいさつ文をページにアクセスした時間帯に応じたものにして返却するメソッドです。
	 *
	 * 処理詳細：
	 * ・現在時刻(hh)を数値で取得
	 * ・時間帯（朝昼夜）に応じてあいさつ文を変更
	 *
	 * @param hour ページにアクセスした時刻(hh)
	 * @return 時間帯に応じたあいさつ文
	 */
	private String greetingTime(String name) {

		//ページにアクセスした時の現在日時情報で初期化されたインスタンスの取得
		LocalDateTime nowDateTime = LocalDateTime.now();
		//現在時刻(hh)を数値で取得
		int hour = nowDateTime.getHour();

		//5時～11時にアクセスした場合
		if(hour >= 5 && hour < 12){
			//結合したあいさつ文を返す
			return ("Good morning," + name + "!");
		//12時～18時にアクセスした場合
		}else if(hour >= 12 && hour < 19){
			//結合したあいさつ文を返す
			return ("Hello," + name + "!");
		//19時～4時にアクセスした場合
		}else{
			//結合したあいさつ文を返す
			return ("Good evening," + name + "!");
		}
	}

}
