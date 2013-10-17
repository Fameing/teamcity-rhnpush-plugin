package com.miltrex.tc.rhnpush;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Igor.Yova on 15.10.13.
 */
public interface PluginConstants {
    final String PROPERTY_RHNPUSH_PATH = "rhnpush.path";
    final String PROPERTY_SERVER = "rhnpush.server";
    final String PROPERTY_USERNAME = "rhnpush.username";
    final String PROPERTY_PASSWORD = "rhnpush.password";
    final String PROPERTY_CHANNEL = "rhnpush.channel";
    final String PROPERTY_NOGPG = "rhnpush.nogpg";
    final String PROPERTY_VERBOSE = "rhnpush.verbose";

    final String RUN_TYPE = "buildServerResources";
    final String RUNNER_DISPLAY_NAME = "RhnPush";
    final String RUNNER_DESCRIPTION = "Push RPMs to Spacewalk or RHN satellite server.";

    final String PROPERTY_BUILD_WORKINGDIR = "teamcity.build.workingDir";
}
