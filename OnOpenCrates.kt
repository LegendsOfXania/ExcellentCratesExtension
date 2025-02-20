package fr.xania.questjournal.entries.event

import com.typewritermc.core.books.pages.Colors
import com.typewritermc.core.entries.Query
import com.typewritermc.core.entries.Ref
import com.typewritermc.core.extension.annotations.Entry
import com.typewritermc.core.extension.annotations.EntryListener
import com.typewritermc.core.extension.annotations.KeyType
import com.typewritermc.core.interaction.EntryContextKey
import com.typewritermc.engine.paper.entry.TriggerableEntry
import com.typewritermc.engine.paper.entry.entries.EventEntry
import com.typewritermc.engine.paper.entry.triggerAllFor
import su.nightexpress.excellentcrates.api.event.CrateOpenEvent
import kotlin.reflect.KClass

@Entry("on_crates_open",
    "An event entry for crate openings.",
    Colors.YELLOW,
    "material-symbols:bigtop-updates")
class CrateOpenEventEntry(
    override val id: String = "",
    override val name: String = "",
    override val triggers: List<Ref<TriggerableEntry>> = emptyList(),
) : EventEntry

enum class CrateOpenContextKeys(override val klass: KClass<*>) : EntryContextKey {
    @KeyType(String::class)
    CRATE_NAME(String::class),
}

@EntryListener(CrateOpenEventEntry::class)
fun CrateOpenEventEntry(event: CrateOpenEvent, query: Query<CrateOpenEventEntry>) {
    val entries = query.find()
    entries.triggerAllFor(event.player) {
        CrateOpenContextKeys.CRATE_NAME withValue event.crate.name
    }
}