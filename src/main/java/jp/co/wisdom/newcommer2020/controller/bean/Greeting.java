package jp.co.wisdom.newcommer2020.controller.bean;

import lombok.Data;

/**
 * @author s.okada
 * spring リソース表現クラス
 */
@Data
public class Greeting
{
	/**
	 * 識別子(画面が表示された回数)
	 */
	private final long id;
	/**
	 * あいさつ文(String.formatによる変更後)
	 */
	private final String content;

}
