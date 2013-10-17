package com.miltrex.tc.rhnpush;

import jetbrains.buildServer.agent.BuildProgressLogger;
import jetbrains.buildServer.util.StringUtil;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RhnPushRunner {
    final RhnPushRunnerConfiguration configuration;
    final BuildProgressLogger logger;

    RhnPushRunner(RhnPushRunnerConfiguration configuration,@NotNull final BuildProgressLogger logger) {
        this.configuration = configuration;
        this.logger = logger;
    }


    /**
     * @return executable name/path
     */
    @NotNull
    String getExecutable() {
        return RhnPushRunnerConfiguration.getRhnPushPath();
    }

    /**
     * @return get arguments for executable
     */
    @NotNull
    List<String> getArgs() {
        List<String> args = new ArrayList<String>();
        if (configuration.verbose) {
            args.add("--verbose");
        }
        if (configuration.nogpg) {
            args.add("--nosig");
        }
        args.add("--server");
        args.add(configuration.server);
        args.add("-u");
        args.add(configuration.username);
        args.add("-p");
        args.add(configuration.password);
        for (String channel : configuration.channels) {
            args.add("-c");
            args.add(channel.trim());
        }
        args.addAll(getRPMPath());
        return args;
    }

    public List<String> getRPMPath() {
        List<String> stringFile = new ArrayList<String>();
        Collection collection = FileUtils.listFiles(new File(configuration.buildPath), new String[]{"rpm"}, true);
        for (Object next : collection) {
            if (((File)next).exists() && ((File)next).canRead()){
                stringFile.add(StringUtil.escapeQuotes(((File)next).toURI().normalize().getPath()));
                logger.message("[RhnPush] - Found file '" + ((File)next).toURI().normalize().getPath() + "'");
            } else {
                logger.warning("[RhnPush] - File '" + ((File)next).toURI().normalize().getPath() + "' not exist or cannot reads.");
            }
        }
        return stringFile;
    }
}
