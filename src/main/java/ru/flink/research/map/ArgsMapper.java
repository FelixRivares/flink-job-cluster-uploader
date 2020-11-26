package ru.flink.research.map;

import ru.flink.research.resolver.JvmParamResolver;
import ru.flink.research.resolver.LoadStartParamException;
import ru.flink.research.upload.UploaderArguments;

public class ArgsMapper {

  private final JvmParamResolver jvmParamResolver;

  public ArgsMapper(JvmParamResolver jvmParamResolver) {
    this.jvmParamResolver = jvmParamResolver;
  }

  public UploaderArguments map() throws LoadStartParamException {
    UploaderArguments uploaderArguments = new UploaderArguments();
    uploaderArguments.setHost(jvmParamResolver.getFlinkHost());
    uploaderArguments.setPort(Integer.parseInt(jvmParamResolver.getFlinkPort()));
    uploaderArguments.setPathToFlinkJar(jvmParamResolver.getFlinkJobJarPath());
    return uploaderArguments;
  }

}
