package org.merscwog.plugins

import org.gradle.api.GradleScriptException
import org.gradle.api.Project

import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic
import groovy.transform.PackageScope

@CompileStatic
class FrcBasePluginExtension {
    Object team

    @PackageScope
    Project project

    FrcBasePluginExtension(Project project) {
        this.project = project
    }

    void team(Object team) {
        this.team = team
    }

    @CompileDynamic
    Integer getTeam() {
        Object retVal = team
	if (retVal instanceof Closure) {
	    retVal = (retVal as Closure).call()
	}

	Integer retInt
	try {
            retInt = retVal as Integer
        }
        catch (NumberFormatException nfe) {
	    throw new GradleScriptException(
	        "frc team must be integer, not '${retVal}'", nfe)
        }

	if (retInt <= 0) {
	    throw new GradleScriptException(
	        "frc team must be positive, not '${retInt}'", null)
	}

	retInt	
    }
}