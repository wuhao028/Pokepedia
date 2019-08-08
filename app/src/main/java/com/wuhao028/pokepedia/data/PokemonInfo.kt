package com.wuhao028.pokepedia.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemonInfos")
data class PokemonInfo(
    @PrimaryKey @ColumnInfo(name = "order") val order: Int,
    val abilities: List<Ability>,
    val base_experience: Int,
    val forms: List<Form>,
    val game_indices: List<GameIndice>,
    val height: Int,
    val held_items: List<HeldItem>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<Move>,
    val name: String,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)

data class Species(
    val name: String,
    val url: String
)

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)

data class VersionDetail(
    val rarity: Int,
    val version: VersionX
)

data class Version(
    val name: String,
    val url: String
)

data class Item(
    val name: String,
    val url: String
)

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)

data class VersionGroupDetail(
    val level_learned_at: Int,
    val move_learn_method: MoveLearnMethod,
    val version_group: VersionGroup
)

data class MoveLearnMethod(
    val name: String,
    val url: String
)

data class VersionGroup(
    val name: String,
    val url: String
)

data class MoveX(
    val name: String,
    val url: String
)

data class Ability(
    val ability: AbilityX,
    val is_hidden: Boolean,
    val slot: Int
)

data class AbilityX(
    val name: String,
    val url: String
)

data class Stat(
    val base_stat: Int,
    val effort: Int,
    val stat: StatX
)

data class StatX(
    val name: String,
    val url: String
)

data class Type(
    val slot: Int,
    val type: TypeX
)

data class TypeX(
    val name: String,
    val url: String
)

data class GameIndice(
    val game_index: Int,
    val version: Version
)

data class VersionX(
    val name: String,
    val url: String
)

data class Sprites(
    val back_default: String,
    val back_female: Any,
    val back_shiny: String,
    val back_shiny_female: Any,
    val front_default: String,
    val front_female: Any,
    val front_shiny: String,
    val front_shiny_female: Any
)

data class Form(
    val name: String,
    val url: String
)
