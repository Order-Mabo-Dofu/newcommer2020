package jp.co.wisdom.newcommer2020.service.sampleest;

import java.time.LocalDateTime;
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
	 * あいさつ文用
	 */
	private String template = "";
	/**
	 * 識別子(画面が表示された回数のカウント用)
	 */
	private final AtomicLong counter = new AtomicLong();

	/**
	 * 画面表示カウントの増加とあいさつ文を時刻に応じたものにする
	 * @param name
	 * @return 画面表示内容
	 */
	public Greeting process(String name) {

		//ページにアクセスした時の現在日時情報で初期化されたインスタンスの取得
		LocalDateTime nowDateTime = LocalDateTime.now();
		//現在時刻(hh)を数値で取得
		int hour = nowDateTime.getHour();

		//5時～11時にアクセスした場合
		if(hour >= 5 && hour < 12){
				this.template = ("Good morning," + name + "!");
		//12時～18時にアクセスした場合
		}else if(hour >= 12 && hour < 19){
				this.template = ("Hello," + name + "!");
		//19時～4時にアクセスした場合
		}else{
				this.template = ("Good evening," + name + "!");;
		}
		//カウントの増加とあいさつ文を返す
		return new Greeting(counter.incrementAndGet(),template);
	}
}
