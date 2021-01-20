package jp.co.wisdom.newcommer2020;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.wisdom.newcommer2020.service.sampleest.SampleRestService;

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
		sampleRestService.process(name,hour);
	}
}
