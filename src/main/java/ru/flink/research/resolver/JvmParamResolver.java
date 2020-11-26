package ru.flink.research.resolver;

public class JvmParamResolver {

  public String getFlinkHost() throws LoadStartParamException {
    return getJvmParamByName("flink.host");
  }

  public String getFlinkPort() throws LoadStartParamException {
    return getJvmParamByName("flink.port");
  }

  public String getFlinkJobJarPath() throws LoadStartParamException {
    return getJvmParamByName("flink.job.jar.path");
  }

  private String getJvmParamByName(String jvmParamName) throws LoadStartParamException {
    final String paramValue = System.getProperty(jvmParamName);
    if (paramValue == null) {
      throw new LoadStartParamException(
          String.format("The required jvm param [%s] is missing", jvmParamName));
    }
    return paramValue;
  }

}
