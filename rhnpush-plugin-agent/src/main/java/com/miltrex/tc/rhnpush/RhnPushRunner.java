package com.miltrex.tc.rhnpush;

import com.sun.org.omg.SendingContext._CodeBaseImplBase;
import jetbrains.buildServer.agent.*;
import jetbrains.buildServer.agent.impl.artifacts.ArtifactsBuilder;
import jetbrains.buildServer.agent.impl.artifacts.ArtifactsBuilderAdapter;
import jetbrains.buildServer.agent.impl.artifacts.ArtifactsCollection;
import jetbrains.buildServer.ExtensionHolder;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class RhnPushRunner {
    private RhnPushRunnerConfiguration configuration;
    private BuildProgressLogger logger;
    private ExtensionHolder extensionHolder;

    public RhnPushRunner(RhnPushRunnerConfiguration config, BuildProgressLogger logger, ExtensionHolder extensionHolder) {
        this.configuration = config;
        this.logger = logger;
        this.extensionHolder = extensionHolder;
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

    private List<String> getRPMPath() {
        List<String> stringFile = new ArrayList<String>();
        final Collection<ArtifactsPreprocessor> preprocessors = extensionHolder.getExtensions(ArtifactsPreprocessor.class);
        final ArtifactsBuilder builder = new ArtifactsBuilder();
        builder.setPreprocessors(preprocessors);
        builder.setBaseDir(configuration.checkoutDirectory);
        builder.setArtifactsPaths(configuration.param_source_path);
        builder.addListener(new ArtifactsBuilderAdapter());
        final List<ArtifactsCollection> artifactsCollections = builder.build();
        for (ArtifactsCollection artifactsCollection : artifactsCollections) {
            for (Map.Entry<File, String> filePathEntry : artifactsCollection.getFilePathMap().entrySet()) {
                File source = filePathEntry.getKey();
                stringFile.add(source.toURI().normalize().getPath());
                logger.message("[RhnPush] - Found file '" + source.toURI().normalize().getPath() + "'");
            }
        }
        return stringFile;
    }
}
