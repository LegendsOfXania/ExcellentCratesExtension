package fr.xania.excellentcrates

import com.typewritermc.core.extension.Initializable
import com.typewritermc.core.extension.annotations.Singleton
import com.typewritermc.engine.paper.logger
import com.typewritermc.engine.paper.plugin
@Singleton
object Initializer : Initializable {
    override suspend fun initialize() {
        plugin.server.pluginManager.getPlugin("ExcellentCrates")
        logger.info("ExcellentCratesExtension has been successfully initialized. Version : 1.0.0 for TypeWriter 0.8.0-beta-153.")
    }

    override suspend fun shutdown() {
        logger.info("ExcellentCratesExtension has been successfully stopped.")
    }
}
