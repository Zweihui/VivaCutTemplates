package com.github.zweihui.vivacuttemplates.services

import com.github.zweihui.vivacuttemplates.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
