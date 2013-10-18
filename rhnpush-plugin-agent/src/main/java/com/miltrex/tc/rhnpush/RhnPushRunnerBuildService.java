package com.miltrex.tc.rhnpush;

import jetbrains.buildServer.ExtensionHolder;
import jetbrains.buildServer.RunBuildException;
import jetbrains.buildServer.agent.BuildFinishedStatus;
import jetbrains.buildServer.agent.BuildProgressLogger;
import jetbrains.buildServer.agent.runner.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RhnPushRunnerBuildService extends BuildServiceAdapter {
    private RhnPushRunner rhnPushRunner;
    private ExtensionHolder extensionHolder;

    public RhnPushRunnerBuildService(@NotNull final ExtensionHolder extensionHolder) {
        this.extensionHolder = extensionHolder;
    }

    @Override
    public void afterInitialized() {
        rhnPushRunner = new RhnPushRunner(getConfig(), getLogger(), extensionHolder);
    }


    @NotNull
    @Override
    public ProgramCommandLine makeProgramCommandLine() throws RunBuildException {
        return new SimpleProgramCommandLine(getRunnerContext(), rhnPushRunner.getExecutable(), rhnPushRunner.getArgs());
    }

    @Override
    public void beforeProcessStarted() throws RunBuildException {
        getLogger().message("[RhnPush] - Starting publishing RPMs ...");
    }

    @Override
    public void afterProcessFinished() throws RunBuildException {
        getLogger().message("[RhnPush] - Finished publishing RPMs ...");
    }

    @Override
    public boolean isCommandLineLoggingEnabled() {
        return false;
    }

    @NotNull
    private RhnPushRunnerConfiguration getConfig() {
        return new RhnPushRunnerConfiguration(getAgentConfiguration(), getRunnerParameters(), getBuild());
    }

    @NotNull
    @Override
    public List<ProcessListener> getListeners() {
        List<ProcessListener> myListenerList = new ArrayList<ProcessListener>();
        myListenerList.add(new LoggingProcessListener(getLogger()));
        return myListenerList;
    }
}
