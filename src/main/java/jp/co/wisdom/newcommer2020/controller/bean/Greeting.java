package jp.co.wisdom.newcommer2020.controller.bean;

import lombok.Data;

/**
 * spring リソース表現クラス
 * @author s.okada
 */
@Data
public class Greeting
{
	/**
	 * 識別子(画面が表示された回数)
	 */
	private final long id;
	/**
	 * あいさつ文
	 */
	private final String content;

}
