package ru.flink.research;

import java.io.File;
import lombok.experimental.UtilityClass;
import org.apache.flink.client.program.PackagedProgram;
import org.apache.flink.client.program.ProgramInvocationException;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.configuration.RestOptions;
import ru.flink.research.upload.UploaderArguments;

@UtilityClass
public class FlinkObjectFactory {

  public Configuration createFlinkClusterConfiguration(UploaderArguments uploaderArguments) {
    Configuration config = new Configuration();
    // config.setString(JobManagerOptions.ADDRESS, host);
    config.setString(RestOptions.ADDRESS, uploaderArguments.getHost());
    config.setInteger(RestOptions.PORT, uploaderArguments.getPort());
    //  config.setInteger(RestOptions.RETRY_MAX_ATTEMPTS, 10);
    //  config.setLong(RestOptions.RETRY_DELAY, 0);
    return config;
  }

  public PackagedProgram createPackagedProgram(UploaderArguments uploaderArguments) throws ProgramInvocationException {
    return PackagedProgram.newBuilder()
                          .setJarFile(new File(uploaderArguments.getPathToFlinkJar()))
                          // .setArguments(arguments)
                          .build();
  }

}
