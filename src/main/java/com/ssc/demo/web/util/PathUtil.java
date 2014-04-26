package com.ssc.demo.web.util;

public class PathUtil {
	
	public final static String getExportPDFFileDir() throws Exception {

		String fileDir = PropertiesUtil.readString("exports.pdf.dir");
		return fileDir;
	}

	public final static String getWkhtmltopdf() throws Exception {
		String executePath = PropertiesUtil.readString("exports.wkhtmltopdf");
		return executePath;
	}
}
