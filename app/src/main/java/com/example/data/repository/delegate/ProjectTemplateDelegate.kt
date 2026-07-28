package com.example.data.repository.delegate

import com.example.data.db.ProjectFileDao
import com.example.data.repository.delegate.template.AndroidComposeTemplateProvider
import com.example.data.repository.delegate.template.CppAppTemplateProvider
import com.example.data.repository.delegate.template.CppNativeTemplateProvider
import com.example.data.repository.delegate.template.CppWebTemplateProvider
import com.example.data.repository.delegate.template.CsharpWebTemplateProvider
import com.example.data.repository.delegate.template.NodeApiTemplateProvider
import com.example.data.repository.delegate.template.ReactPureTemplateProvider
import com.example.data.repository.delegate.template.RustServerTemplateProvider
import com.example.data.repository.delegate.template.WebTemplateProvider

class ProjectTemplateDelegate(
    private val projectFileDao: ProjectFileDao
) {

    suspend fun createWebProjectTemplate(projectId: Long) {
        projectFileDao.insertFiles(WebTemplateProvider.getFiles(projectId))
    }

    suspend fun createReactPureTemplate(projectId: Long) {
        projectFileDao.insertFiles(ReactPureTemplateProvider.getFiles(projectId))
    }

    suspend fun createAndroidComposeTemplate(projectId: Long) {
        projectFileDao.insertFiles(AndroidComposeTemplateProvider.getFiles(projectId))
    }

    suspend fun createRustServerTemplate(projectId: Long) {
        projectFileDao.insertFiles(RustServerTemplateProvider.getFiles(projectId))
    }

    suspend fun createCppWebTemplate(projectId: Long) {
        projectFileDao.insertFiles(CppWebTemplateProvider.getFiles(projectId))
    }

    suspend fun createCppAppTemplate(projectId: Long) {
        projectFileDao.insertFiles(CppAppTemplateProvider.getFiles(projectId))
    }

    suspend fun createCppNativeTemplate(projectId: Long) {
        projectFileDao.insertFiles(CppNativeTemplateProvider.getFiles(projectId))
    }

    suspend fun createNodeApiTemplate(projectId: Long) {
        projectFileDao.insertFiles(NodeApiTemplateProvider.getFiles(projectId))
    }

    suspend fun createCsharpWebTemplate(projectId: Long) {
        projectFileDao.insertFiles(CsharpWebTemplateProvider.getFiles(projectId))
    }
}
