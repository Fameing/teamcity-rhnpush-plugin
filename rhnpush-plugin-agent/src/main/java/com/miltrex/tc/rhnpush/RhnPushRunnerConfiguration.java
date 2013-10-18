package com.miltrex.tc.rhnpush;

import jetbrains.buildServer.agent.AgentRunningBuild;
import jetbrains.buildServer.agent.BuildAgentConfiguration;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RhnPushRunnerConfiguration {
    final String server;
    final String username;
    final String password;
    final List<String> channels;
    final String buildPath;
    final boolean nogpg;
    final boolean verbose;
    final String param_source_path;
    final File checkoutDirectory;

    final static String rhnPushPath = "rhnpush";

    public RhnPushRunnerConfiguration(BuildAgentConfiguration agentConfiguration, Map<String, String> runnerParameters, AgentRunningBuild agentRunningBuild) {
        checkoutDirectory = agentRunningBuild.getCheckoutDirectory();
        server = Parameters.getString(runnerParameters, PluginConstants.PROPERTY_SERVER);
        username = Parameters.getString(runnerParameters, PluginConstants.PROPERTY_USERNAME);
        password = Parameters.getString(runnerParameters, PluginConstants.PROPERTY_PASSWORD);
        channels = Arrays.asList(Parameters.getString(runnerParameters, PluginConstants.PROPERTY_CHANNEL).split(","));
        nogpg = Parameters.getBoolean(runnerParameters, PluginConstants.PROPERTY_NOGPG);
        verbose = Parameters.getBoolean(runnerParameters, PluginConstants.PROPERTY_VERBOSE);
        param_source_path = Parameters.getString(runnerParameters, PluginConstants.PROPERTY_PARAM_SOURCE_PATH);
        buildPath = FilenameUtils.separatorsToSystem(Parameters.getString(runnerParameters, PluginConstants.PROPERTY_BUILD_WORKINGDIR));
    }

    static String getRhnPushPath() {
        return rhnPushPath;
    }
}


