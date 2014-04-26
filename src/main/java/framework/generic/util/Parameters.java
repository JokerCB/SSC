package framework.generic.util;

import java.io.Serializable;
import java.util.HashMap;

public class Parameters implements Serializable {

	private static final long serialVersionUID = 8183803590321527582L;
	private Object parameter;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <E> E getParameter() {
		if (parameter == null) {
			return (E) new HashMap();
		}
		return (E) parameter;
	}

	public <E> void setParameter(E parameter) {
		this.parameter = parameter;
	}

}
