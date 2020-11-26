package ru.flink.research.upload;

import org.apache.flink.client.deployment.StandaloneClusterId;
import org.apache.flink.client.program.PackagedProgram;
import org.apache.flink.client.program.PackagedProgramUtils;
import org.apache.flink.client.program.rest.RestClusterClient;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.runtime.jobgraph.JobGraph;
import ru.flink.research.FlinkObjectFactory;

public class Uploader {

  public String upload(UploaderArguments uploaderArguments) throws Exception {
    Configuration configuration = FlinkObjectFactory.createFlinkClusterConfiguration(uploaderArguments);
    PackagedProgram packagedProgram = FlinkObjectFactory.createPackagedProgram(uploaderArguments);
    try (RestClusterClient<StandaloneClusterId> client = new RestClusterClient<>(
        configuration,
        StandaloneClusterId.getInstance())) {

      JobGraph jobGraph = PackagedProgramUtils.createJobGraph(
          packagedProgram,
          configuration,
          1,
          false);
      return client.submitJob(jobGraph).get().toHexString();
    }
  }

}
