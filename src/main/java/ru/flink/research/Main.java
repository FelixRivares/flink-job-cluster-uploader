package ru.flink.research;

import ru.flink.research.map.ArgsMapper;
import ru.flink.research.resolver.JvmParamResolver;
import ru.flink.research.upload.Uploader;

public class Main {

  public static void main(String[] args) {
    try {
      new Uploader().upload(new ArgsMapper(new JvmParamResolver()).map());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
