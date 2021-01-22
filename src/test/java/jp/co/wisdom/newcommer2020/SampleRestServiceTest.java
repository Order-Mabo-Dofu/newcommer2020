package jp.co.wisdom.newcommer2020;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.wisdom.newcommer2020.controller.bean.Greeting;
import jp.co.wisdom.newcommer2020.service.sampleest.SampleRestService;


@SpringBootTest
public class SampleRestServiceTest {

	/**
	 * テスト対象クラスの呼び出し
	 * コンストラクタインジェクション
	 */

	private final SampleRestService sampleRestService;
	@Autowired
	public SampleRestServiceTest(SampleRestService sampleRestService){
		this.sampleRestService = sampleRestService;
	}

	//あいさつ文を時刻に応じたものにするためのテスト
	//現在時刻を取得する処理をどこにするか考え中
	@Test
    public void processTest1() {
		String name = "World";
		int hour = 5;
		int expId = 1;
		String expContent = "Hello,World!";

		Greeting GreTest = sampleRestService.process(name,hour);

		assertThat(GreTest.getContent()).isEqualTo(expContent);
		assertThat(GreTest.getId()).isEqualTo(expId);
	}

	/**
	 * static methodのモック化
	 */
	@Test
    public void processTest2() {
		LocalDateTime lt = LocalDateTime.of(9999, 12, 31, 23, 59, 59, 99);

        // 対象クラスのモック化
        MockedStatic<LocalDateTime> mocked = Mockito.mockStatic(LocalDateTime.class);

        // 戻り値を設定してスタブ化
        mocked.when(LocalDateTime::now).thenReturn(lt);

		sampleRestService.process("hoge", 99);
	}
}
