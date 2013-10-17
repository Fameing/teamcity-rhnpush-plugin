package com.miltrex.tc.rhnpush;

import jetbrains.buildServer.agent.AgentBuildRunnerInfo;
import jetbrains.buildServer.agent.BuildAgentConfiguration;
import jetbrains.buildServer.agent.runner.CommandLineBuildService;
import jetbrains.buildServer.agent.runner.CommandLineBuildServiceFactory;
import jetbrains.buildServer.log.Loggers;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class RhnPushRunnerBuildServiceFactory implements CommandLineBuildServiceFactory {

    public RhnPushRunnerBuildServiceFactory() {

    }

    @NotNull
    public CommandLineBuildService createService() {
        return new RhnPushRunnerBuildService();
    }


    @NotNull
    public AgentBuildRunnerInfo getBuildRunnerInfo() {
        return new AgentBuildRunnerInfo() {

            @NotNull
            public String getType() {
                return PluginConstants.RUN_TYPE;
            }

            public boolean canRun(@NotNull BuildAgentConfiguration agentConfiguration) {
                setupConfigurationParameters(agentConfiguration);
                return (agentConfiguration.getSystemInfo().isUnix() || agentConfiguration.getSystemInfo().isMac()) && isExistRhnPush();
            }

            /**
             * Setup agent configuration parameters.
             * @param agentConfiguration build agent configuration.
             */
            public void setupConfigurationParameters(@NotNull BuildAgentConfiguration agentConfiguration) {
                String rhnPushPath = RhnPushRunnerConfiguration.getRhnPushPath();

                if (rhnPushPath != null) {
                    File file = new File(rhnPushPath);

                    if (file.exists()) {
                        agentConfiguration.addConfigurationParameter("rhnpush", rhnPushPath);
                    }
                }
            }
        };
    }


    public boolean isExistRhnPush() {
        try {
            Process process = Runtime.getRuntime().exec("which rhnpush");
            return process.waitFor() <= 0;
        } catch (InterruptedException e) {
            Loggers.AGENT.error(e.getMessage(),e);
        } catch (IOException e) {
            Loggers.AGENT.error(e.getMessage(),e);
        }
        return false;
    }
}
