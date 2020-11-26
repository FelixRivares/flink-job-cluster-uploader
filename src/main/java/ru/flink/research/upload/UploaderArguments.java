package ru.flink.research.upload;

import lombok.Data;

@Data
public class UploaderArguments {

  private String host;
  private int port;
  private String pathToFlinkJar;

}
