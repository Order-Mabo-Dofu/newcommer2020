package jp.co.wisdom.newcommer2020;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.wisdom.newcommer2020.controller.bean.Greeting;
import jp.co.wisdom.newcommer2020.service.sampleest.SampleRestService;


@SpringBootTest
public class SampleRestServiceTest {

	/**
	 * テスト対象クラス
	 */

	@InjectMocks
	private SampleRestService sampleRestService;

	/**
	 * 時間帯に応じたあいさつ文作成テスト
	 */
	@Test
    public void processTest() {

		//入力値（全時間帯共通の画面から受け取るvalue）をセット
		String name = "World";

		//LocalDateTimeに3時59分59秒をセット（0時 <= セット時間 < 4時）
		LocalDateTime lt = LocalDateTime.of(9999, 12, 31, 3, 59, 59, 99);
        // 対象クラスのモック化
        MockedStatic<LocalDateTime> mocked = Mockito.mockStatic(LocalDateTime.class);
        // 戻り値を設定してスタブ化
        mocked.when(LocalDateTime::now).thenReturn(lt);
        //テストメソッドの実行(0時～3時にアクセスした場合)
		Greeting greTestE = sampleRestService.process(name);

		//LocalDateTimeに時間を加算して11時59分59秒をセット（4時 <= セット時間 < 12時）
		lt = lt.plusHours(8);
		// 戻り値の時間を更新
		mocked.when(LocalDateTime::now).thenReturn(lt);
		//テストメソッドの実行(5時～11時にアクセスした場合)
		Greeting greTestM = sampleRestService.process(name);

		//LocalDateTimeに時間を加算して18時59分59秒をセット（12時 <= セット時間 < 19時）
		lt = lt.plusHours(7);
		// 戻り値の時間を更新
		mocked.when(LocalDateTime::now).thenReturn(lt);
		//テストメソッドの実行(12時～18時にアクセスした場合)
		Greeting greTestH = sampleRestService.process(name);

		//LocalDateTimeに時間を加算して23時59分59秒をセット（19時 <= セット時間 < 24時）
		lt = lt.plusHours(5);
		// 戻り値の時間を更新
		mocked.when(LocalDateTime::now).thenReturn(lt);
		//テストメソッドの実行(19時～24時にアクセスした場合)
		Greeting greTestE2 = sampleRestService.process(name);

		//期待値（作成される時間帯に応じたあいさつ文）をセット
		String expE = "Good evening,World!";
		String expM = "Good morning,World!";
		String expH = "Hello,World!";
		//返り値と期待値が合っているかの確認
		assertThat(greTestE.getContent()).isEqualTo(expE);
		assertThat(greTestM.getContent()).isEqualTo(expM);
		assertThat(greTestH.getContent()).isEqualTo(expH);
		assertThat(greTestE2.getContent()).isEqualTo(expE);

		mocked.close();
	}
}
