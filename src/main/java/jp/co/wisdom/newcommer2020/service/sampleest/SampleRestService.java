package jp.co.wisdom.newcommer2020.service.sampleest;

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
	public Greeting process(String name,int hour) {

		//時間帯に応じたあいさつ文の作成
		String template = greetingTime(name,hour);
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
	 * ・時間帯（朝昼夜）に応じてあいさつ文を変更
	 *
	 * @param template あいさつ文用
	 * @return 時間帯に応じたあいさつ文
	 */
	private String greetingTime(String name,int hour) {

		//あいさつ文用
		String template = "";

		//5時～11時にアクセスした場合
		if(hour >= 5 && hour < 12){
			template = ("Good morning," + name + "!");
		//12時～18時にアクセスした場合
		}else if(hour >= 12 && hour < 19){
			template = ("Hello," + name + "!");
		//19時～4時にアクセスした場合
		}else{
			template = ("Good evening," + name + "!");
		}
		//結合したあいさつ文を返す
		return template;
	}

}
