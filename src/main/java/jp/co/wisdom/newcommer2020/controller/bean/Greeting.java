package jp.co.wisdom.newcommer2020.controller.bean;

/**
 * @author s.okada
 * spring リソース表現クラス
 */
public class Greeting
{
	/**
	 * 識別子
	 */
	private final long id;
	/**
	 * あいさつ文
	 */
	private final String content;

	/**
	 * @param id
	 * @param content
	 */
	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	/**
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return name
	 */
	public String getContent() {
		return content;
	}
}
