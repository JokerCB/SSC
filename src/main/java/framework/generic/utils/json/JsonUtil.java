package framework.generic.utils.json;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import framework.generic.utils.string.StringUtil;

/**
 * json 简单操作的工具类
 * 
 * @author danny.zhang
 * 
 */
public class JsonUtil {
	private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	private static Gson gson = new Gson();
	private static ObjectMapper mapper = new ObjectMapper();

	private JsonUtil() {
	}

	// -----------------jackson start -------------------//
	public static String toJson(Object object) {
		try {
			return mapper.writeValueAsString(object);
		} catch (IOException e) {
			logger.warn("write to json string error:" + object, e);
		}
		return null;
	}

	public static <T> T fromJson(String jsonString, Class<T> clazz) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}
		try {
			return mapper.readValue(jsonString, clazz);
		} catch (IOException e) {
			logger.warn("parse json string error:" + jsonString, e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> T fromJson(String jsonString, JavaType javaType) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}
		try {
			return (T)mapper.readValue(jsonString, javaType);
		} catch (IOException e) {
			logger.warn("parse json string error:" + jsonString, e);
		}
		return null;
	}

	/**
	 * 读取Json节点数据
	 * 
	 * @param jsonString
	 *            json字符串
	 * @return JsonNode
	 */
	public static JsonNode readNode(String jsonString) {
		JsonNode node = null;
		try {
			node = mapper.readTree(jsonString);
		} catch (JsonProcessingException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
		return node;
	}

	/**
	 * 读取Json节点数据，节点路径使用>>
	 * 
	 * @param jsonString
	 *            json字符串
	 * @param nodePath
	 *            节点路径
	 * @return JsonNode
	 */
	public static JsonNode readNode(String jsonString, String nodePath) {
		if ((StringUtil.isNullOrEmpty(jsonString)) || (StringUtil.isNullOrEmpty(nodePath))) {
			return null;
		}
		JsonNode node = readNode(jsonString);
		if (nodePath.contains(">>")) {
			String[] nodeNames = nodePath.split("\\>>");
			for (int i = 0; i < nodeNames.length; i++)
				node = node.get(nodeNames[i].trim());
		} else {
			node = node.get(nodePath);
		}
		return node;
	}
	/**
	 * 构造泛型的Collection Type如： ArrayList<MyBean>,
	 * 则调用constructCollectionType(ArrayList.class,MyBean.class)
	 * HashMap<String,MyBean>, 则调用(HashMap.class,String.class, MyBean.class)
	 * 
	 * @param collectionClass
	 *            泛型的Collection
	 * @param elementClasses
	 *            元素类
	 * @return JavaType Java类型
	 * @since 1.0
	 */
	public static JavaType createCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}

	// -----------------jackson end-------------------//

	/**
	 * 将对象转换成json格式
	 * 
	 * @param ts
	 * @return
	 */
	public static String objectToJson(Object ts) {
		String jsonStr = null;
		if (gson != null) {
			jsonStr = gson.toJson(ts);
		}
		return jsonStr;

	}

	/**
	 * 将对象转换成json格式(并自定义日期格式)
	 * 
	 * @param ts
	 * @return
	 */

	public static String objectToJsonDateSerializer(Object ts, final String dateformat) {

		String jsonStr = null;

		gson = new GsonBuilder().registerTypeHierarchyAdapter(Date.class, new JsonSerializer<Date>() {

			public JsonElement serialize(Date src, Type typeOfSrc,

			JsonSerializationContext context) {

				SimpleDateFormat format = new SimpleDateFormat(dateformat);

				return new JsonPrimitive(format.format(src));

			}

		}).setDateFormat(dateformat).create();

		if (gson != null) {

			jsonStr = gson.toJson(ts);

		}

		return jsonStr;

	}

	/**
	 * 将json格式转换成list对象
	 * 
	 * @param jsonStr
	 * @return
	 */

	public static List<?> jsonToList(String jsonStr) {

		List<?> objList = null;

		if (gson != null) {

			java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<?>>() {
			}.getType();

			objList = gson.fromJson(jsonStr, type);

		}

		return objList;

	}

	/**
	 * 将json格式转换成map对象
	 * 
	 * @param jsonStr
	 * @return
	 */

	public static Map<?, ?> jsonToMap(String jsonStr) {

		Map<?, ?> objMap = null;
		if (gson != null) {
			java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<Map<?, ?>>() {
			}.getType();
			objMap = gson.fromJson(jsonStr, type);
		}
		return objMap;
	}

	/**
	 * 将json转换成bean对象
	 * 
	 * @param jsonStr
	 * @return
	 */

	public static Object jsonToBean(String jsonStr, Class<?> cl) {
		Object obj = null;
		if (gson != null) {
			obj = gson.fromJson(jsonStr, cl);
		}
		return obj;
	}

	/**
	 * 将json转换成bean对象
	 * 
	 * @param jsonStr
	 * @param cl
	 * @return
	 */

	@SuppressWarnings("unchecked")
	public static <T> T jsonToBeanDateSerializer(String jsonStr, Class<T> cl, final String pattern) {
		Object obj = null;
		gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

			public Date deserialize(JsonElement json, Type typeOfT,

			JsonDeserializationContext context)

			throws JsonParseException {

				SimpleDateFormat format = new SimpleDateFormat(pattern);

				String dateStr = json.getAsString();

				try {

					return format.parse(dateStr);

				} catch (ParseException e) {

					e.printStackTrace();

				}

				return null;

			}

		}).setDateFormat(pattern).create();

		if (gson != null) {

			obj = gson.fromJson(jsonStr, cl);

		}

		return (T) obj;

	}

	/**
	 * 根据key获取json中对应的值
	 * 
	 * @param jsonStr
	 * @param key
	 * @return
	 */

	public static Object getJsonValue(String jsonStr, String key) {

		Object rulsObj = null;

		Map<?, ?> rulsMap = jsonToMap(jsonStr);

		if (rulsMap != null && rulsMap.size() > 0) {

			rulsObj = rulsMap.get(key);

		}

		return rulsObj;

	}

	/*
	 * 将类转换成Map
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void objectToMap(Object obj, Map map) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = obj.getClass().getDeclaredFields();
		for (int j = 0; j < fields.length; j++) {
			fields[j].setAccessible(true);// 设置这个变量不进行访问权限检查 在类里设置的变量可以为private
			if (fields[j].get(obj) != null && (((fields[j].get(obj) instanceof String) && !"".equals(fields[j].get(obj))) || ((fields[j].get(obj) instanceof Integer)))) {
				map.put(fields[j].getName(), fields[j].get(obj));
			}
		}
	}

}
