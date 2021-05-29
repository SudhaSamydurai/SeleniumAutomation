package com.demo.constants;

public class GlobalConstants {

	private static final String PROJECTPATH = System.getProperty("user.dir");
	private static final String RESOURCEPATH = PROJECTPATH + "\\src\\test\\resources";
	private static final String PROPERTYFILEPATH = RESOURCEPATH + "\\Configs\\Config.properties";
	private static final String EXCELPATH = RESOURCEPATH + "\\excel\\testdata.xlsx";
	private static final String EXTENTREPORTFOLDERPATH = PROJECTPATH + "\\extent-test-output\\";
	private static final int EXPLICITWAIT = 20;
	private static final int AJAXWAITLOAD = 20;

	public static String getPropertyFilePath() {
		System.out.println("File path" + PROPERTYFILEPATH);
		return PROPERTYFILEPATH;
	}

	public static String getExcelPath() {
		return EXCELPATH;
	}

	public static String getExtentReportFolderPath() {
		return EXTENTREPORTFOLDERPATH;
	}

	public static int getExplicitWait() {
		return EXPLICITWAIT;
	}

	public static int getAjaxWaitLoad() {
		return AJAXWAITLOAD;
	}

}
