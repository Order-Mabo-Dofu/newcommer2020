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
	 * 時間帯に応じたあいさつ文作成テスト（5時～11時）
	 * processのテストメソッドで１つに統合予定。
	 */
	@Test
    public void processTest1() {
		//LocalDateTimeに11時59分59秒をセット（セット時間 < 12時）
    	LocalDateTime lt = LocalDateTime.of(9999, 12, 31, 11, 59, 59, 99);

        // 対象クラスのモック化
        MockedStatic<LocalDateTime> mocked = Mockito.mockStatic(LocalDateTime.class);
        // 戻り値を設定してスタブ化
        mocked.when(LocalDateTime::now).thenReturn(lt);

        //入力値（画面から受け取るvalue）をセット
		String name = "World";
		//期待値（時間帯に応じたあいさつ文）
		String expContent = "Good morning,World!";

		//テストクラスの実行
		Greeting greTest = sampleRestService.process(name);
		//返り値と期待値が合っているかの確認
		assertThat(greTest.getContent()).isEqualTo(expContent);

		//テスト終了後にMockを閉じる
		mocked.close();
	}

	/**
	 * 時間帯に応じたあいさつ文作成テスト（12時～18時）
	 */
	@Test
    public void processTest2() {
		//LocalDateTimeに18時59分59秒をセット（セット時間 < 19時）
		LocalDateTime lt = LocalDateTime.of(9999, 12, 31, 18, 59, 59, 99);

        // 対象クラスのモック化
        MockedStatic<LocalDateTime> mocked = Mockito.mockStatic(LocalDateTime.class);

        // 戻り値を設定してスタブ化
        mocked.when(LocalDateTime::now).thenReturn(lt);

        String name = "World";

		String expContent = "Hello,World!";

		Greeting greTest = sampleRestService.process(name);

		assertThat(greTest.getContent()).isEqualTo(expContent);

        mocked.close();
	}
	/**
	 * 時間帯に応じたあいさつ文作成テスト（19時～4時）
	 *
	 */
	@Test
    public void processTest3() {
		//LocalDateTimeに3時59分59秒をセット（セット時間 < 4時）
		LocalDateTime lt = LocalDateTime.of(9999, 12, 31, 3, 59, 59, 99);

        // 対象クラスのモック化
        MockedStatic<LocalDateTime> mocked = Mockito.mockStatic(LocalDateTime.class);

        // 戻り値を設定してスタブ化
        mocked.when(LocalDateTime::now).thenReturn(lt);

        String name = "World";

		String expContent = "Good evening,World!";

		Greeting greTest = sampleRestService.process(name);

		assertThat(greTest.getContent()).isEqualTo(expContent);

        mocked.close();
	}
}
