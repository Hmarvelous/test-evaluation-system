package online.shixun.project.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: TopicDto.java
 * @Description: 题目实体类
 *
 * @version: v1.0.0
 * @author: am
 * @date: 2019年10月21日 下午2:48:10
 */
public class TopicDto {

	/**
	 * 题目ID
	 */
	private Long id;
	
	/**
	 * 题目名称
	 */
	private String name;
	
	/**
	 * 题目答案(JSON)
	 */
	private String answer;
	
	/**
	 * 题目是否有效
	 */
	private Boolean dataFlag;


	
	/**
	 * 构造无答案方法
	 * @return JSON对象
	 */
	public JSONObject getNotAnswer() {
		JSONObject json = new JSONObject();
		json.put("id", this.id);
		json.put("name", this.name);
		JSONArray array = new JSONArray();
		// 遍历答案
		for (Object a : JSON.parseArray(answer)) {
			JSONObject j = (JSONObject) a;
			JSONObject jo = new JSONObject();
			jo.put("name", j.get("name"));
			jo.put("number", j.get("number"));
			array.add(jo);
		}
		json.put("answer", array);
		return json;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnswer() {
		return answer;
	}
	
	public JSONArray getAnswerJSONArray() {
		return JSONArray.parseArray(answer);
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Boolean getDataFlag() {
		return dataFlag;
	}

	public void setDataFlag(Boolean dataFlag) {
		this.dataFlag = dataFlag;
	}

	@Override
	public String toString() {
		return "TopicDto [id=" + id + ", name=" + name + ", answer=" + answer + ", dataFlag=" + dataFlag + "]";
	}
	
}
