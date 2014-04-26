package framework.generic.utils.json;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import framework.generic.utils.string.StringUtil;

public class JsonMapper {
	private static Logger logger = LoggerFactory.getLogger(JsonMapper.class);
	private static ObjectMapper mapper;

	public JsonMapper() {
		this(null);
	}

	public JsonMapper(JsonInclude.Include include) {
		mapper = new ObjectMapper();

		if (include != null) {
			mapper.setSerializationInclusion(include);
		}

		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}

	public static JsonMapper nonEmptyMapper() {
		return new JsonMapper(JsonInclude.Include.NON_EMPTY);
	}

	public static JsonMapper nonDefaultMapper() {
		return new JsonMapper(JsonInclude.Include.NON_DEFAULT);
	}

	public String toJson(Object object) {
		try {
			return mapper.writeValueAsString(object);
		} catch (IOException e) {
			logger.warn("write to json string error:" + object, e);
		}
		return null;
	}

	public <T> T fromJson(String jsonString, Class<T> clazz) {
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
	public <T> T fromJson(String jsonString, JavaType javaType) {
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

	public JavaType createCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}

	@SuppressWarnings("unchecked")
	public <T> T update(String jsonString, T object) {
		try {
			return (T)mapper.readerForUpdating(object).readValue(jsonString);
		} catch (JsonProcessingException e) {
			logger.warn("update json string:" + jsonString + " to object:" + object + " error.", e);
		} catch (IOException e) {
			logger.warn("update json string:" + jsonString + " to object:" + object + " error.", e);
		}
		return null;
	}

	public String toJsonP(String functionName, Object object) {
		return toJson(new JSONPObject(functionName, object));
	}

	public void enableEnumUseToString() {
		mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
		mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
	}

	public void enableJaxbAnnotation() {
		JaxbAnnotationModule module = new JaxbAnnotationModule();
		mapper.registerModule(module);
	}

	public ObjectMapper getMapper() {
		return mapper;
	}
}