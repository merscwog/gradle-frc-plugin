package org.merscwog.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

import groovy.transform.CompileStatic

@CompileStatic
class FrcBasePlugin implements Plugin<Project> {
    void apply(Project project) {
        project.extensions.create('frc', FrcBasePluginExtension, project)
    }
}
