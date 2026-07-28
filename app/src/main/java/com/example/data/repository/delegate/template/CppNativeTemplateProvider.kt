package com.example.data.repository.delegate.template

import com.example.data.db.ProjectFileEntity

object CppNativeTemplateProvider {
    fun getFiles(projectId: Long): List<ProjectFileEntity> {
        return CppAppTemplateProvider.getFiles(projectId)
    }
}
