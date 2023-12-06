package com.zzz.pgn.sfishelper.db

import com.intellij.database.dataSource.url.TypesRegistry
import com.intellij.openapi.ui.Messages
import com.intellij.util.Consumer
@Deprecated("暂时用不上")
class DatabaseServerTypeFactory: TypesRegistry.TypeDescriptorFactory {
    override fun createTypeDescriptor(p0: Consumer<in TypesRegistry.TypeDescriptor>) {
        Messages.showInfoMessage("DatabaseServerTypeFactory", "Dg")

    }
}