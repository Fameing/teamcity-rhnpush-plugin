
 TeamCity plugin adds a build step to push RPMs to Spacewalk or RHN satellite server.

 1. Build
 Issue 'mvn package' command from the root project to build the plugin. Resulting package <artifactId>.zip will be placed in 'target' directory. 
 
 2. Install
 To install the plugin, put zip archive to 'plugins' dir under TeamCity data directory and restart the server.

 
