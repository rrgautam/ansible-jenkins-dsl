# Jenkins Job DSL Gradle Example 

this code has been cloned from https://github.com/jenkinsci/job-dsl-plugin

## File structure

    .
    ├── jobs                    # DSL script files
    ├── resources               # resources for DSL scripts
    ├── src
    │   ├── main
    │   │   ├── groovy          # support classes
    │   │   └── resources
    │   │       └── idea.gdsl   # IDE support for IDEA
    │   └── test
    │       └── groovy          # specs
    └── build.gradle            # build file

# Script Examples

* [Example 3](jobs/example3Jobs.groovy) - shows how to use the configure block
* [Example 4](jobs/example4Jobs.groovy) - shows a way to reuse job definitions for jobs that differ only with a few properties

