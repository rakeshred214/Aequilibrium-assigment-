package utils;

import static utils.ConfigUtil.getProperty;

public class Config {
    public static final String URL= getProperty("URL");
    public static final String BROWSER= getProperty("BROWSER");
    public static final String STANDARD_USER = getProperty("STANDARD_USER");
    public static final String PASSWORD = getProperty("PASSWORD");
    public static final String LOCKED_USER = getProperty("LOCKED_USER");
    public static final String PROBLEM_USER = getProperty("PROBLEM_USER");
    public static final String PERFORMANCE_GLITCH_USER = getProperty("PERFORMANCE_GLITCH_USER");
}
