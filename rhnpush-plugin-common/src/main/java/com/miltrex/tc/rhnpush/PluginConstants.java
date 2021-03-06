package com.miltrex.tc.rhnpush;

public interface PluginConstants {
    final String PROPERTY_RHNPUSH_PATH = "rhnpush.path";
    final String PROPERTY_SERVER = "rhnpush.server";
    final String PROPERTY_USERNAME = "rhnpush.username";
    final String PROPERTY_PASSWORD = "rhnpush.password";
    final String PROPERTY_CHANNEL = "rhnpush.channel";
    final String PROPERTY_NOGPG = "rhnpush.nogpg";
    final String PROPERTY_VERBOSE = "rhnpush.verbose";
    final String PROPERTY_PARAM_SOURCE_PATH = "rhnpush.param_source_path";

    final String RUN_TYPE = "buildServerResources";
    final String RUNNER_DISPLAY_NAME = "RhnPush";
    final String RUNNER_DESCRIPTION = "Push RPMs to Spacewalk or RHN satellite server.";

    final String PROPERTY_BUILD_WORKINGDIR = "teamcity.build.workingDir";
}
